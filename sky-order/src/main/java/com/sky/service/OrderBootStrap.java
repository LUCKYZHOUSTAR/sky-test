package com.sky.service;

import lucky.sky.net.rpc.RpcApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author:chaoqiang.zhou
 * @Description:
 * @Date:Create in 14:19 2017/6/20
 */

@SpringBootApplication
public class OrderBootStrap {


    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {

        RpcApplication application = new RpcApplication(OrderBootStrap.class, args);
        application.run();
    }
}
