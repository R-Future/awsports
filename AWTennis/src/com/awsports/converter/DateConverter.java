package com.awsports.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		// TODO Auto-generated method stub
		try{
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
			return simpleDateFormat.parse(source);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
}
