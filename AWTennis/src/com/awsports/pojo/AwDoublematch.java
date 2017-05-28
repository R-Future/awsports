package com.awsports.pojo;

import java.util.Date;

public class AwDoublematch {
    private Integer id;

    private Integer homecontestant;

    private Integer awayplayer;

    private Date matchtime;

    private Integer matchplace;

    private Integer tournamentid;

    private Integer entry;

    private Integer round;

    private Integer sets;

    private Boolean outcome;

    private Integer winnerpoint;

    private Integer loserpoint;

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

    public Boolean getOutcome() {
        return outcome;
    }

    public void setOutcome(Boolean outcome) {
        this.outcome = outcome;
    }

    public Integer getWinnerpoint() {
        return winnerpoint;
    }

    public void setWinnerpoint(Integer winnerpoint) {
        this.winnerpoint = winnerpoint;
    }

    public Integer getLoserpoint() {
        return loserpoint;
    }

    public void setLoserpoint(Integer loserpoint) {
        this.loserpoint = loserpoint;
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