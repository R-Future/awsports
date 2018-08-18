package com.awsports.util;

public enum EntryEnum {
	MANSINGLE(1),
	WOMANSINGLE(2),
	MIXEDSINGLE(3),
	DOUBLEMANINDIVIDUAL(4),
	DOUBLEWOMANINDIVIDUAL(5),
	MANDOUBLE(6),
	WOMANDOUBLE(7),
	MIXEDDOUBLE(8);
	
	Integer value;
	
	EntryEnum(Integer value){
		this.value=value;
	}
	
	public Integer getValue(){
		return this.value;
	}
}
