package com.bootdo.delivery.controller;

import com.bootdo.delivery.service.DeliveryService;
import com.bootdo.delivery.vo.DeliveryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName DeliveryController
 * @Description TODO
 * @Author Administrator
 * @Date 2018/9/13 17:25
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "/delivery", method = RequestMethod.GET)
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    @RequestMapping("/getDeliveryById")
    public DeliveryVo getDeliveryById(@RequestParam("id") String id) {
        return deliveryService.getDeliveryById(id);
    }
}
