package com.awsports.util;

public enum StatusEnum {
	GET_SUCCESS(200),
	POST_SUCCESS(201),
	DELETE_SUCCESS(204),
	INVALID_REQUEST(400),
	NOT_FOUND(404);
	
	private Integer value;
	
	StatusEnum(Integer value){
		this.value = value;
	}
	
	public Integer getValue(){
		return value;
	}
}
