package com.awsports.util;

public enum SexEnum {
	MALE(false),
	FEMALE(true);
	
	Boolean value;
	SexEnum(Boolean value){
		this.value=value;
	}
	
	public Boolean getValue(){
		return this.value;
	}
}
