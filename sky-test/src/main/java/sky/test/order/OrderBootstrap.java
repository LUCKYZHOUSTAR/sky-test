package sky.test.order;

import com.sky.service.iface.OrderService;
import lucky.sky.net.rpc.RpcApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author:chaoqiang.zhou
 * @Description:
 * @Date:Create in 9:02 2017/6/20
 */

@SpringBootApplication()
public class OrderBootstrap {


  public static OrderService orderService = null;

  public static final Logger logger = LoggerFactory.getLogger(OrderBootstrap.class);

  /**
   * 主函数
   */
  public static void main(String[] args) {
//    int processors = Runtime.getRuntime().availableProcessors();

    int processors = 4;

    RpcApplication application = new RpcApplication(OrderBootstrap.class, args);
    ApplicationContext context = application.run();
    orderService = application.getBean(OrderService.class);
    System.out.println(orderService.getOrderInfo());
    System.out.println(orderService.getOrderInfos("23", null, 5));

//        orderService = application.getBean(OrderService.class);

//    syncCall(processors);
  }

  private static void syncCall(int processors) {
    for (int i = 0; i < 10000; i++) {
      try {
        orderService.getOrderInfo();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    final int t = 5000;
    final int step = 6;
    long start = System.currentTimeMillis();
    final CountDownLatch latch = new CountDownLatch(processors << step);
    final AtomicLong count = new AtomicLong();
    for (int i = 0; i < (processors << step); i++) {
      new Thread(new Runnable() {

        @Override
        public void run() {
          for (int i = 0; i < t; i++) {
            try {
              orderService.getOrderInfo();
              if (count.getAndIncrement() % 1000 == 0) {
                logger.warn("count=" + count.get());
              }
            } catch (Exception e) {
              e.printStackTrace();
            }
          }
          latch.countDown();
        }
      }).start();
    }
    try {
      latch.await();
      logger.warn("count=" + count.get());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    long second = (System.currentTimeMillis() - start) / 1000;
    System.out.println("Request count: " + count.get() + ", time: " + second + " second, qps: "
        + count.get() / second);
  }
}
