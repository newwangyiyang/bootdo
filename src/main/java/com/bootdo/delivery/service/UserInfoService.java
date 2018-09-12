package com.bootdo.delivery.service;

import com.bootdo.delivery.domain.UserInfo;

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
    Map<String, Object> getMapList();
}
