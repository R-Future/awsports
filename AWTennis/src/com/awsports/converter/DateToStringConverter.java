package com.awsports.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateToStringConverter implements Converter<Date, String> {

	@Override
	public String convert(Date date) {
		// TODO Auto-generated method stub
		try{
			String dateStr=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(date);
			return dateStr;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
}
