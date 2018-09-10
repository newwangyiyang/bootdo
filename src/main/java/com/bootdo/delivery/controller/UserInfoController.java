package com.bootdo.delivery.controller;

import com.bootdo.common.utils.ResultBean;
import com.bootdo.delivery.domain.UserInfo;
import com.bootdo.delivery.service.UserInfoService;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/9/5 20:34
 * @Description:
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
public class UserInfoController {
    private Logger logger = LoggerFactory.getLogger(UserInfo.class);

    @Autowired
    private UserInfoService userInfoService;
    /**
     * @Author Administrator
     * @Description //TODO
     * @Date 13:15 2018/9/6
     * @Param
     * @return
     **/
    @RequestMapping(value = "/getUserInfoByUserId")
    public ResultBean<UserInfo> getUserInfoByUserId(@RequestParam("userId") String userId) {

        try {
            UserInfo userInfo = userInfoService.getUserInfoByUserId(userId);
            return ResultBean.success(userInfo);
        } catch (Exception e) {
            logger.error("获取个人信息失败" + e);
            return ResultBean.error("服务器错误");
        }
    }

    /**
     * @Author Administrator
     * @Description //UserInfo的分页查询
     * @Date 13:29 2018/9/6
     * @Param
     * @return
     **/
    @RequestMapping("getUserInfoList")
    public ResultBean<List<UserInfo>> getUserInfoList(@RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = true, defaultValue = "5") Integer pageSize) {
        try{
            PageHelper.startPage(pageNum, pageSize);
            List<UserInfo> userInfos = userInfoService.getUserInfoList();
            return ResultBean.success(userInfos);
        }catch (Exception e) {
            return ResultBean.error("服务器错误");
        }
    }

    /**
     * @Author Administrator
     * @Description //TODO 
     * @Date 9:33 2018/9/10
     * @Param 
     * @return 
     **/
    @GetMapping("/saveUserInfo")
    public ResultBean<UserInfo> saveUserInfo(UserInfo userInfo) {
        UserInfo info = userInfoService.saveUserInfo(userInfo);
        return ResultBean.success(info);
    }
}
