package com.sky.service.spring;

import com.sky.service.iface.OrderService;
import lucky.sky.net.rpc.RpcClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;


@Configuration
@Lazy
@Order(Ordered.LOWEST_PRECEDENCE)
public class OrderServiceProxyAutoConfig {
    private static final String SERVICE = "com.lucky.order.service";

    /**
     * 订单服务
     *
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    public OrderService orderServiceProxy() {
        return RpcClient.get(SERVICE, OrderService.class);
    }

}
