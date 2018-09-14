package com.bootdo.delivery.service.impl;

import com.bootdo.common.exception.BDException;
import com.bootdo.delivery.dao.DeliveryDao;
import com.bootdo.delivery.service.DeliveryService;
import com.bootdo.delivery.vo.DeliveryVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DeliveryDao deliveryDao;
    @Override
    public DeliveryVo getDeliveryById(String id) {
        return deliveryDao.getDeliveryById(id);
    }

    @Override
    public void SaveUploadFile(String id, String path) {
        Integer integer = deliveryDao.saveUploadFile(id, path);
        logger.info("判断当前结果是否成功={}", integer);
    }
}
