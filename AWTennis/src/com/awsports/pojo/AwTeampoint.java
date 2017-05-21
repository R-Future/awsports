package com.awsports.pojo;

import java.util.Date;

public class AwTeampoint {
    private Integer id;

    private Integer teamid;

    private byte[] entry;

    private Integer year;

    private Integer week;

    private Integer matchs;

    private Integer wins;

    private Integer marginbureau;

    private Integer point;

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

    public byte[] getEntry() {
        return entry;
    }

    public void setEntry(byte[] entry) {
        this.entry = entry;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public Integer getMatchs() {
        return matchs;
    }

    public void setMatchs(Integer matchs) {
        this.matchs = matchs;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getMarginbureau() {
        return marginbureau;
    }

    public void setMarginbureau(Integer marginbureau) {
        this.marginbureau = marginbureau;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
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