package com.awsports.pojo;

import java.util.Date;

public class AwTeampoint {
    private Integer id;

    private Integer teamid;

    private Integer entry;

    private Integer year;

    private Integer week;

    private Integer matchs;

    private Integer wins;

    private Integer marginbureau;

    private Integer points;

    private Date createdat;

    private Date updatedat;

    private Boolean invalid;

    private Integer tournamentid;

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

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
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

    public Integer getTournamentid() {
        return tournamentid;
    }

    public void setTournamentid(Integer tournamentid) {
        this.tournamentid = tournamentid;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}