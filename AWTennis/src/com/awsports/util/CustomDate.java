package com.awsports.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CustomDate extends Date {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9221331164991850525L;
	
	private int year;
	private int week;
	private Calendar date;
	
	public CustomDate(){
		date=Calendar.getInstance();
		//设置每周的第一天为周一，默认为周日
		date.setFirstDayOfWeek(Calendar.MONDAY);
		year=date.get(Calendar.YEAR);
		week=date.get(Calendar.WEEK_OF_YEAR);
	}
	
	public CustomDate(Date datetime){
		date=Calendar.getInstance();
		date.setTime(datetime);
		//设置每周的第一天为周一，默认为周日
		date.setFirstDayOfWeek(Calendar.MONDAY);
		year=date.get(Calendar.YEAR);
		week=date.get(Calendar.WEEK_OF_YEAR);
	}
	
	public CustomDate(String datetimeStr){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date datetime;
		try {
			datetime = sdf.parse(datetimeStr);
			date=Calendar.getInstance();
			date.setTime(datetime);
			//设置每周的第一天为周一，默认为周日
			date.setFirstDayOfWeek(Calendar.MONDAY);
			year=date.get(Calendar.YEAR);
			week=date.get(Calendar.WEEK_OF_YEAR);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}
	
	
}
