package com.awsports.pojo;

public class Event extends AwEvent {
    private String detail;

    private String note;
    
    //query condition, select all events which are started from {year} to now.
    private Integer year;

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
