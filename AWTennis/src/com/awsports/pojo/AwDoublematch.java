package com.awsports.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class AwDoublematch {
    private Integer id;

    private Integer homecontestant;

    private Integer awayplayer;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date matchtime;

    private Integer matchplace;

    private Integer tournamentid;

    private Integer entry;

    private Integer round;

    private Integer sets;

    private String outcome;

    private Integer hcpoint;

    private Integer appoint;

    //将Date换成String,便于利用时间查询
    private String createdat;

    private Date updatedat;

    private Boolean invalid;

    private Boolean hcretired;

    private Boolean apretired;

    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHomecontestant() {
        return homecontestant;
    }

    public void setHomecontestant(Integer homecontestant) {
        this.homecontestant = homecontestant;
    }

    public Integer getAwayplayer() {
        return awayplayer;
    }

    public void setAwayplayer(Integer awayplayer) {
        this.awayplayer = awayplayer;
    }

    public Date getMatchtime() {
        return matchtime;
    }

    public void setMatchtime(Date matchtime) {
        this.matchtime = matchtime;
    }

    public Integer getMatchplace() {
        return matchplace;
    }

    public void setMatchplace(Integer matchplace) {
        this.matchplace = matchplace;
    }

    public Integer getTournamentid() {
        return tournamentid;
    }

    public void setTournamentid(Integer tournamentid) {
        this.tournamentid = tournamentid;
    }

    public Integer getEntry() {
        return entry;
    }

    public void setEntry(Integer entry) {
        this.entry = entry;
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public Integer getSets() {
        return sets;
    }

    public void setSets(Integer sets) {
        this.sets = sets;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome == null ? null : outcome.trim();
    }

    public Integer getHcpoint() {
        return hcpoint;
    }

    public void setHcpoint(Integer hcpoint) {
        this.hcpoint = hcpoint;
    }

    public Integer getAppoint() {
        return appoint;
    }

    public void setAppoint(Integer appoint) {
        this.appoint = appoint;
    }

    public String getCreatedat() {
        return createdat;
    }

    public void setCreatedat(String createdat) {
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

    public Boolean getHcretired() {
        return hcretired;
    }

    public void setHcretired(Boolean hcretired) {
        this.hcretired = hcretired;
    }

    public Boolean getApretired() {
        return apretired;
    }

    public void setApretired(Boolean apretired) {
        this.apretired = apretired;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}