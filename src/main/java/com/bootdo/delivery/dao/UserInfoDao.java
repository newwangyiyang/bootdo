package com.bootdo.delivery.dao;

import com.bootdo.delivery.domain.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/9/5 20:27
 * @Description:
 */
@Mapper
public interface UserInfoDao {
    public UserInfo getUserInfoByUserId(@Param("userId") String userId);
    public List<UserInfo> getUserInfoList();
    public void saveUserInfo(UserInfo userInfo);
}
