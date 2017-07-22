package com.awsports.pojo;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AwDoublematchscore {
    private Integer id;

    @NotNull(message="{doublematchscore.matchid.null}")
    private Integer matchid;

    @Min(value=1, message="{doublematchscore.setth.range}")
    private Integer setth;

    @Min(value=0, message="{doublematchscore.hcscore.range}")
    private Integer hcscore;

    @Min(value=0, message="{doublematchscore.apscore.range}")
    private Integer apscore;

    private Integer hctiescore;

    private Integer aptiescore;

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

    public Integer getMatchid() {
        return matchid;
    }

    public void setMatchid(Integer matchid) {
        this.matchid = matchid;
    }

    public Integer getSetth() {
        return setth;
    }

    public void setSetth(Integer setth) {
        this.setth = setth;
    }

    public Integer getHcscore() {
        return hcscore;
    }

    public void setHcscore(Integer hcscore) {
        this.hcscore = hcscore;
    }

    public Integer getApscore() {
        return apscore;
    }

    public void setApscore(Integer apscore) {
        this.apscore = apscore;
    }

    public Integer getHctiescore() {
        return hctiescore;
    }

    public void setHctiescore(Integer hctiescore) {
        this.hctiescore = hctiescore;
    }

    public Integer getAptiescore() {
        return aptiescore;
    }

    public void setAptiescore(Integer aptiescore) {
        this.aptiescore = aptiescore;
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