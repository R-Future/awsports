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
	private int month;
	private int week;
	private int lastWeek;
//	private int weeksOfYear;
	private Calendar calendar;
	
	public CustomDate(){
		calendar=Calendar.getInstance();
		//设置每周的第一天为周一，默认为周日
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		year=calendar.get(Calendar.YEAR);
		week=calendar.get(Calendar.WEEK_OF_YEAR);
		month=calendar.get(Calendar.MONTH);//[0,11]
		//the last week
		calendar.add(Calendar.DAY_OF_MONTH, -7);
		lastWeek=calendar.get(Calendar.WEEK_OF_YEAR);
		if(month == 11 && week < lastWeek){
			year++;
		}
	}
	
	public CustomDate(Date datetime){
		calendar=Calendar.getInstance();
		calendar.setTime(datetime);
		//设置每周的第一天为周一，默认为周日
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		year=calendar.get(Calendar.YEAR);
		week=calendar.get(Calendar.WEEK_OF_YEAR);
		month=calendar.get(Calendar.MONTH);//[0,11]
		//the last week
		calendar.add(Calendar.DAY_OF_MONTH, -7);
		lastWeek=calendar.get(Calendar.WEEK_OF_YEAR);
		if(month == 11 && week < lastWeek){
			year++;
		}
	}
	
	public CustomDate(String datetimeStr){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date datetime;
		try {
			datetime = sdf.parse(datetimeStr);
			calendar=Calendar.getInstance();
			calendar.setTime(datetime);
			//设置每周的第一天为周一，默认为周日
			calendar.setFirstDayOfWeek(Calendar.MONDAY);
			year=calendar.get(Calendar.YEAR);
			week=calendar.get(Calendar.WEEK_OF_YEAR);
			month=calendar.get(Calendar.MONTH);//[0,11]
			//the last week
			calendar.add(Calendar.DAY_OF_MONTH, -7);
			lastWeek=calendar.get(Calendar.WEEK_OF_YEAR);
			if(month == 11 && week < lastWeek){
				year++;
			}
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

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getLastWeek() {
		return lastWeek;
	}

	public void setLastWeek(int lastWeek) {
		this.lastWeek = lastWeek;
	}
	
}
