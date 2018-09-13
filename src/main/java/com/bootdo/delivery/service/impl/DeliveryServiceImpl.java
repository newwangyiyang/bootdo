package com.bootdo.delivery.service.impl;

import com.bootdo.delivery.dao.DeliveryDao;
import com.bootdo.delivery.service.DeliveryService;
import com.bootdo.delivery.vo.DeliveryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName DeliveryServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Date 2018/9/13 17:23
 * @Version 1.0
 **/
@Service
@Transactional
public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    private DeliveryDao deliveryDao;
    @Override
    public DeliveryVo getDeliveryById(String id) {
        return deliveryDao.getDeliveryById(id);
    }
}
