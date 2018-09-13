package com.bootdo.delivery.dao;

import com.bootdo.delivery.domain.UserInfo;
import com.bootdo.delivery.vo.DeliveryListVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Auther: Administrator
 * @Date: 2018/9/5 20:27
 * @Description:
 */
@Mapper
public interface UserInfoDao {
    public UserInfo getUserInfoByUserId(@Param("userId") String userId);
    public DeliveryListVo getMapList();
    public List<UserInfo> getUserInfoList();
    public void saveUserInfo(UserInfo userInfo);
}
