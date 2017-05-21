package com.awsports.pojo;

import java.util.Date;

public class AwDoublematchscore {
    private Integer id;

    private Integer matchid;

    private Integer setth;

    private Integer hcscore;

    private Integer apscore;

    private Integer hctiescore;

    private Integer aptiescore;

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