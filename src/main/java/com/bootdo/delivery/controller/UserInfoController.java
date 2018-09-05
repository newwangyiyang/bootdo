package com.bootdo.delivery.controller;

import com.bootdo.delivery.domain.UserInfo;
import com.bootdo.delivery.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Administrator
 * @Date: 2018/9/5 20:34
 * @Description:
 */
@RestController
@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/getUserInfoByUserId")
    public UserInfo getUserInfoByUserId(@RequestParam("userId") String userId) {
        return userInfoService.getUserInfoByUserId(userId);
    }
}
