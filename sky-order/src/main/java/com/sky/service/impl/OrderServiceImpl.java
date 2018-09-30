package com.sky.service.impl;

import com.sky.service.iface.OrderService;
import lucky.sky.util.lang.FaultException;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @Author:chaoqiang.zhou
 * @Description:
 * @Date:Create in 14:20 2017/6/20
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public String getOrderInfo() {
        System.out.println("测试服务信息");

        return "sdf";
    }



    @Override
    public HashMap<String, String> getOrderInfos(String orderId, String name, int order) {
        System.out.println(order);
        HashMap<String, String> result = new HashMap<>();
        result.put("key1", "key");
        result.put("key2", "key");
        result.put("key3", "key");
        result.put("key4", "key");
        result.put("key5", "key");
        result.put("key6", "key");
        result.put("key7", "key");
        result.put("key8", "key");
        return result;
    }
}
