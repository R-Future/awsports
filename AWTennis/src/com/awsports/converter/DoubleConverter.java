package com.awsports.converter;

import org.springframework.core.convert.converter.Converter;

public class DoubleConverter implements Converter<String, Double> {

	@Override
	public Double convert(String source) {
		// TODO Auto-generated method stub
		try{
			return Double.parseDouble(source);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
}
