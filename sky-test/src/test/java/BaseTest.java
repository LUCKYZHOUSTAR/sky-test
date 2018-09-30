//import lucky.sky.util.test.TestBase;
//import lucky.sky.util.test.spring.SpringJUnit;
//import org.junit.BeforeClass;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
//import sky.test.order.OrderBootstrap;
//
///**
// * 测试基类
// */
//public class BaseTest extends TestBase {
//
//    @BeforeClass
//    public static void init() {
//        SpringJUnit.boot(Dummy.class, OrderBootstrap.class);
//    }
//
//    /**
//     * HACK: LOOP ENDLESS IF ANNOTATING ON AbstractTest DIRECTLY
//     */
//    @SpringBootApplication(exclude = MongoAutoConfiguration.class)
//    public static class Dummy {
//    }
//}