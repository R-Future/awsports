package com.awsports.util;

public enum RoundEnum {
	FINAL(2),
	SEMIFINAL(4),
	QUARTERFINAL(8),
	LASTSIXTEEN(16),
	LASTTHIRTYTWO(32),
	LASTSIXTYFOUR(64),
	LASTONEHUNDREDTWENTYEIGHT(128),
	GROUP(1);
	
	private Integer value;
	
	RoundEnum(Integer value){
		this.value=value;
	}
	
	public Integer getValue(){
		return value;
	}
}
