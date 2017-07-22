package com.awsports.pojo;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class AwSinglematch {
    private Integer id;

    @NotNull(message="{singlematch.homecontestant.null}")
    private Integer homecontestant;

    @NotNull(message="{singlematch.awayplayer.null}")
    private Integer awayplayer;

    @NotNull(message="{singlematch.matchtime.null}")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date matchtime;

    @NotNull(message="{singlematch.matchplace.null}")
    private Integer matchplace;

    @NotNull(message="{singlematch.tournamentid.null}")
    private Integer tournamentid;

    private Integer entry;

    @NotNull(message="{singlematch.round.null}")
    private Integer round;

    @Min(value=0,message="{singlematch.sets.range}")
    private Integer sets;

    private String outcome;

    private Integer hcpoint;

    private Integer appoint;

//    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private String createdat;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updatedat;

    private Boolean invalid;

    private Boolean hcretired;

    private Boolean apretired;
    
    private Boolean ishcchallenger;

    private Boolean isapchallenger;

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

    public Boolean getIshcchallenger() {
		return ishcchallenger;
	}

	public void setIshcchallenger(Boolean ishcchallenger) {
		this.ishcchallenger = ishcchallenger;
	}

	public Boolean getIsapchallenger() {
		return isapchallenger;
	}

	public void setIsapchallenger(Boolean isapchallenger) {
		this.isapchallenger = isapchallenger;
	}

	public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}