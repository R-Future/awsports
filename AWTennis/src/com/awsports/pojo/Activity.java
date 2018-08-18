package com.awsports.pojo;

public class Activity extends AwActivityWithBLOBs {
	//根据时间查询活动
    private String startTime;
    private String endTime;
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}
