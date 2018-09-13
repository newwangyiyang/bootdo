package com.bootdo.delivery.dao;

import com.bootdo.delivery.vo.DeliveryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName DeliveryDao
 * @Description TODO
 * @Author Administrator
 * @Date 2018/9/13 16:47
 * @Version 1.0
 **/
@Mapper
public interface DeliveryDao {
    public DeliveryVo getDeliveryById(@Param("id") String id);
}
