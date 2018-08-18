package com.awsports.pojo;

import java.util.Date;

public class AwTeamrankest {
    private Integer id;

    private Integer teamid;

    private Integer entry;

    private Integer highestranking;

    private Date hrstartedat;

    private Integer no1weeks;

    private Integer no1continuousweeks;

    private Integer no1longestcontinuousweeks;

    private Date createdat;

    private Date updatedat;

    private Boolean invalid;

    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeamid() {
        return teamid;
    }

    public void setTeamid(Integer teamid) {
        this.teamid = teamid;
    }

    public Integer getEntry() {
        return entry;
    }

    public void setEntry(Integer entry) {
        this.entry = entry;
    }

    public Integer getHighestranking() {
        return highestranking;
    }

    public void setHighestranking(Integer highestranking) {
        this.highestranking = highestranking;
    }

    public Date getHrstartedat() {
        return hrstartedat;
    }

    public void setHrstartedat(Date hrstartedat) {
        this.hrstartedat = hrstartedat;
    }

    public Integer getNo1weeks() {
        return no1weeks;
    }

    public void setNo1weeks(Integer no1weeks) {
        this.no1weeks = no1weeks;
    }

    public Integer getNo1continuousweeks() {
        return no1continuousweeks;
    }

    public void setNo1continuousweeks(Integer no1continuousweeks) {
        this.no1continuousweeks = no1continuousweeks;
    }

    public Integer getNo1longestcontinuousweeks() {
        return no1longestcontinuousweeks;
    }

    public void setNo1longestcontinuousweeks(Integer no1longestcontinuousweeks) {
        this.no1longestcontinuousweeks = no1longestcontinuousweeks;
    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    public Date getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(Date updatedat) {
        this.updatedat = updatedat;
    }

    public Boolean getInvalid() {
        return invalid;
    }

    public void setInvalid(Boolean invalid) {
        this.invalid = invalid;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}