package com.bootdo.delivery.dao;

import com.bootdo.delivery.vo.DeliveryListVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName TryTestDao
 * @Description TODO
 * @Author Administrator
 * @Date 2018/9/26 10:36
 * @Version 1.0
 **/
@Mapper
public interface TryTestDao {
    public DeliveryListVo getDeliveryListAndUserByUserInfo(@Param("userId") Integer userId);
}
