package com.bootdo.delivery.service;

import com.bootdo.delivery.vo.DeliveryVo;

/**
 * @ClassName DeliveryService
 * @Description TODO
 * @Author Administrator
 * @Date 2018/9/13 17:22
 * @Version 1.0
 **/
public interface DeliveryService {
    DeliveryVo getDeliveryById(String id);
}
