package com.bootdo.delivery.vo;

import java.io.Serializable;

/**
 * @ClassName UserInfoVo
 * @Description TODO
 * @Author Administrator
 * @Date 2018/9/27 16:52
 * @Version 1.0
 **/
public class UserInfoVo implements Serializable {

    private String name;

    private String age;

    private String sex;

    public UserInfoVo(String name, String age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public UserInfoVo() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
