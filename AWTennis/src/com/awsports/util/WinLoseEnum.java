package com.awsports.util;

public enum WinLoseEnum {
	WIN("w"),
	LOSE("l"),
	TIE("t");
	
	String value;
	
	WinLoseEnum(String value){
		this.value=value;
	}
	
	public String getValue(){
		return this.value;
	}
}
