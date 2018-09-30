package com.sky.service.iface;

import java.util.HashMap;

/**
 * @Author:chaoqiang.zhou
 * @Description:
 * @Date:Create in 14:15 2017/6/20
 */
public interface OrderService {

    public String getOrderInfo();

    public HashMap<String, String> getOrderInfos(String orderId, String name, int order);
}
