package com.bootdo.delivery.service;

import com.bootdo.delivery.domain.UserInfo;
import com.bootdo.delivery.vo.DeliveryListVo;

import java.util.List;
import java.util.Map;

/**
 * @Auther: Administrator
 * @Date: 2018/9/5 20:32
 * @Description:
 */
public interface UserInfoService {
    UserInfo getUserInfoByUserId(String userId);
    List<UserInfo> getUserInfoList();
    UserInfo saveUserInfo(UserInfo userInfo);
    DeliveryListVo getMapList();
}
