package com.bootdo.delivery.vo;

import java.util.List;
import java.util.Map;

/**
 * @ClassName DeliveryListVo
 * @Description TODO
 * @Author Administrator
 * @Date 2018/9/13 13:12
 * @Version 1.0
 **/
public class DeliveryListVo {
    private String name;

    private List<Map<String, Object>> list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Map<String, Object>> getList() {
        return list;
    }

    public void setList(List<Map<String, Object>> list) {
        this.list = list;
    }
}
