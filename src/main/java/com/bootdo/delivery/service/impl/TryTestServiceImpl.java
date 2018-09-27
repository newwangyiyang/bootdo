package com.bootdo.delivery.service.impl;

import com.bootdo.delivery.dao.TryTestDao;
import com.bootdo.delivery.service.TryTestService;
import com.bootdo.delivery.vo.DeliveryListVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName TryTestServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Date 2018/9/26 10:46
 * @Version 1.0
 **/

@Service
@Transactional
public class TryTestServiceImpl implements TryTestService {

    @Autowired
    private TryTestDao tryTestDao;
    @Override
    public DeliveryListVo getDeliveryListAndUserByUserInfo(Integer userId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return tryTestDao.getDeliveryListAndUserByUserInfo(userId);
    }
}
