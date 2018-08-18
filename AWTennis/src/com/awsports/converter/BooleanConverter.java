package com.awsports.converter;

import org.springframework.core.convert.converter.Converter;

public class BooleanConverter implements Converter<String, Boolean> {

	@Override
	public Boolean convert(String source) {
		// TODO Auto-generated method stub
		try{
			return Boolean.parseBoolean(source);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
}
