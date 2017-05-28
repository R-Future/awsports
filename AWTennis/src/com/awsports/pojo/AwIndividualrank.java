package com.awsports.pojo;

import java.util.Date;

public class AwIndividualrank {
    private Integer id;

    private Integer userid;

    private Integer entry;

    private Double totalpoint;

    private Integer currentrank;

    private Integer rankingchange;

    private Integer wins;

    private Integer totalmatchs;

    private Integer totalmarginbureau;

    private Integer year;

    private Integer week;

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

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getEntry() {
        return entry;
    }

    public void setEntry(Integer entry) {
        this.entry = entry;
    }

    public Double getTotalpoint() {
        return totalpoint;
    }

    public void setTotalpoint(Double totalpoint) {
        this.totalpoint = totalpoint;
    }

    public Integer getCurrentrank() {
        return currentrank;
    }

    public void setCurrentrank(Integer currentrank) {
        this.currentrank = currentrank;
    }

    public Integer getRankingchange() {
        return rankingchange;
    }

    public void setRankingchange(Integer rankingchange) {
        this.rankingchange = rankingchange;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getTotalmatchs() {
        return totalmatchs;
    }

    public void setTotalmatchs(Integer totalmatchs) {
        this.totalmatchs = totalmatchs;
    }

    public Integer getTotalmarginbureau() {
        return totalmarginbureau;
    }

    public void setTotalmarginbureau(Integer totalmarginbureau) {
        this.totalmarginbureau = totalmarginbureau;
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