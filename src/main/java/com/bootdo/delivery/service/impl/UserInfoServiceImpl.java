package com.bootdo.delivery.service.impl;

import com.bootdo.common.exception.BDException;
import com.bootdo.common.utils.DateUtils;
import com.bootdo.delivery.dao.UserInfoDao;
import com.bootdo.delivery.domain.UserInfo;
import com.bootdo.delivery.service.UserInfoService;
import com.bootdo.delivery.vo.DeliveryListVo;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Administrator
 * @Date: 2018/9/5 20:33
 * @Description:
 */
@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {
    private final static Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo getUserInfoByUserId(String userId) {
        return userInfoDao.getUserInfoByUserId(userId);
    }

    @Override
    public List<UserInfo> getUserInfoList() {
        return userInfoDao.getUserInfoList();
    }

    @Override
    public UserInfo saveUserInfo(UserInfo userInfo) {
        userInfo.setGmtCreate(DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
        userInfoDao.saveUserInfo(userInfo);
        throw new BDException("请求异常");
    }

    @Override
    public DeliveryListVo getMapList() {
        return userInfoDao.getMapList();
    }

    @Override
    public List<UserInfo> getUserInfoListSp() {
        return userInfoDao.getUserInfoListSp();
    }
}
