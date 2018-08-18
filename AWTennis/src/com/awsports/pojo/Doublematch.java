package com.awsports.pojo;

public class Doublematch extends AwDoublematch {
	//起止时间，用于根据比赛时间范围查询
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
