package com.bootdo.common.utils;

/**
* @author Mxy
* @time 2018年5月28日 上午9:26:22
* @description: 
*/
public enum ResultEnum {
	
	SUCCESS(1,"请求成功"),
	
	ERROR(0,"请求出错"),
	
	EXCEPTION(2,"请求异常");
	
	private Integer status;
	
	private String description;
	
	ResultEnum(Integer status, String description) {
		
		this.status = status;
		
		this.description = description;
		
	}

	public Integer getStatus() {
		return status;
	}

	public String getDescription() {
		return description;
	}
	
}
