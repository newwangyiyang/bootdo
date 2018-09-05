package com.bootdo.delivery.service;

import com.bootdo.delivery.domain.UserInfo;

/**
 * @Auther: Administrator
 * @Date: 2018/9/5 20:32
 * @Description:
 */
public interface UserInfoService {
    UserInfo getUserInfoByUserId(String userId);
}
