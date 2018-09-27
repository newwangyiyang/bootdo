package com.bootdo.delivery.service;

import com.bootdo.delivery.vo.DeliveryListVo;

public interface TryTestService {
    public DeliveryListVo getDeliveryListAndUserByUserInfo(Integer userId, Integer pageSize, Integer pageNum);
}
