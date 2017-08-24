package com.awsports.pojo;

public class Punishment extends AwPunishment {
	private Integer currentYear;
	private String cDatetime;
	
	public String getcDatetime() {
		return cDatetime;
	}

	public void setcDatetime(String cDatetime) {
		this.cDatetime = cDatetime;
	}

	public Integer getCurrentYear() {
		return currentYear;
	}

	public void setCurrentYear(Integer currentYear) {
		this.currentYear = currentYear;
	}
}
