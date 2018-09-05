package com.bootdo.delivery.service.impl;

import com.bootdo.delivery.dao.UserInfoDao;
import com.bootdo.delivery.domain.UserInfo;
import com.bootdo.delivery.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: Administrator
 * @Date: 2018/9/5 20:33
 * @Description:
 */
@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;
    @Override
    public UserInfo getUserInfoByUserId(String userId) {
        return userInfoDao.getUserInfoByUserId(userId);
    }
}
