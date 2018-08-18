package com.awsports.pojo;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

public class AwPunishment {
    private Integer id;

    @NotNull(message="{punishment.userid.null}")
    private Integer userid;

    @NotNull(message="{punishment.tournamentid.null}")
    private Integer tournamentid;

    @Past(message="{punishment.matchtime.range}")
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    private Date matchtime;

    @NotNull(message="{punishment.entry.null}")
    private Integer entry;

    @Min(value=1, message="{punishment.points.range}")
    private Integer points;

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

    public Integer getTournamentid() {
        return tournamentid;
    }

    public void setTournamentid(Integer tournamentid) {
        this.tournamentid = tournamentid;
    }

    public Date getMatchtime() {
        return matchtime;
    }

    public void setMatchtime(Date matchtime) {
        this.matchtime = matchtime;
    }

    public Integer getEntry() {
        return entry;
    }

    public void setEntry(Integer entry) {
        this.entry = entry;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}