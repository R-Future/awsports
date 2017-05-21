package com.awsports.pojo;

import java.util.Date;

public class AwTeamrankest {
    private Integer id;

    private Integer teamid;

    private Integer entry;

    private Integer highestranking;

    private Date hrstartedat;

    private Integer no1weeks;

    private Integer no1continiousweeks;

    private Integer no1longestcontiniousweeks;

    private Date createdAt;

    private Date updatedAt;

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

    public Integer getNo1continiousweeks() {
        return no1continiousweeks;
    }

    public void setNo1continiousweeks(Integer no1continiousweeks) {
        this.no1continiousweeks = no1continiousweeks;
    }

    public Integer getNo1longestcontiniousweeks() {
        return no1longestcontiniousweeks;
    }

    public void setNo1longestcontiniousweeks(Integer no1longestcontiniousweeks) {
        this.no1longestcontiniousweeks = no1longestcontiniousweeks;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
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