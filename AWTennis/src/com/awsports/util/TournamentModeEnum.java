package com.awsports.util;

public enum TournamentModeEnum {
	GROUP_ROUND_ROBIN(1),
	KNOCKOUT(2),
	GROUP_AND_KNOCKOUT(3);
	
	Integer value;
	
	TournamentModeEnum(Integer value){
		this.value = value;
	}
	
	Integer getValue(){
		return this.value;
	}
	
}
