package com.awsports.pojo;

public class Event extends AwEvent {
    private String detail;

    private String note;
    
    //query condition, select all events which are started from {year} to now.
    private Integer year;
    
    private String starttime;

    private String endtime;

    private String enrollingtime;

    private String closingtime;
    
	public String getStarttime() {
		return starttime;
	}	

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getEnrollingtime() {
		return enrollingtime;
	}

	public void setEnrollingtime(String enrollingtime) {
		this.enrollingtime = enrollingtime;
	}

	public String getClosingtime() {
		return closingtime;
	}

	public void setClosingtime(String closingtime) {
		this.closingtime = closingtime;
	}

	public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}
}
