package com.awsports.pojo;

public class Singlematch extends AwSinglematch {

	/**
	 * 自定义的时间段起止字段，用于通过比赛时间来查询比赛记录
	 */
	private String startedat;
	private String endedat;

	public String getStartedat() {
		return startedat;
	}
	public void setStartedat(String startedat) {
		this.startedat = startedat;
	}
	public String getEndedat() {
		return endedat;
	}
	public void setEndedat(String endedat) {
		this.endedat = endedat;
	}
	
}
