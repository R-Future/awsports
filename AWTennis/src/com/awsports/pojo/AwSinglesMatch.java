package com.awsports.pojo;

import java.util.Date;

public class AwSinglesMatch {
    private Integer id;

    private Integer eventid;

    private Integer homeid;

    private Integer guestid;

    private String type;

    private String score;

    private String round;

    private Boolean ishomeretired;

    private Boolean isguestretired;

    private Integer homepoint;

    private Integer guestpoint;

    private Boolean ishomewin;

    private Date createdat;

    private Date updatedat;

    private Boolean invalid;

    private String mirror;

    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEventid() {
        return eventid;
    }

    public void setEventid(Integer eventid) {
        this.eventid = eventid;
    }

    public Integer getHomeid() {
        return homeid;
    }

    public void setHomeid(Integer homeid) {
        this.homeid = homeid;
    }

    public Integer getGuestid() {
        return guestid;
    }

    public void setGuestid(Integer guestid) {
        this.guestid = guestid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round == null ? null : round.trim();
    }

    public Boolean getIshomeretired() {
        return ishomeretired;
    }

    public void setIshomeretired(Boolean ishomeretired) {
        this.ishomeretired = ishomeretired;
    }

    public Boolean getIsguestretired() {
        return isguestretired;
    }

    public void setIsguestretired(Boolean isguestretired) {
        this.isguestretired = isguestretired;
    }

    public Integer getHomepoint() {
        return homepoint;
    }

    public void setHomepoint(Integer homepoint) {
        this.homepoint = homepoint;
    }

    public Integer getGuestpoint() {
        return guestpoint;
    }

    public void setGuestpoint(Integer guestpoint) {
        this.guestpoint = guestpoint;
    }

    public Boolean getIshomewin() {
        return ishomewin;
    }

    public void setIshomewin(Boolean ishomewin) {
        this.ishomewin = ishomewin;
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

    public String getMirror() {
        return mirror;
    }

    public void setMirror(String mirror) {
        this.mirror = mirror == null ? null : mirror.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}