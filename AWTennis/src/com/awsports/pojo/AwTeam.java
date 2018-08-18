package com.awsports.pojo;

import java.util.Date;

public class AwTeam {
    private Integer id;

    private Integer eventid;

    private Integer user1id;

    private Integer user2id;

    private String name;

    private Integer entry;

    private Date startedat;

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

    public Integer getEventid() {
        return eventid;
    }

    public void setEventid(Integer eventid) {
        this.eventid = eventid;
    }

    public Integer getUser1id() {
        return user1id;
    }

    public void setUser1id(Integer user1id) {
        this.user1id = user1id;
    }

    public Integer getUser2id() {
        return user2id;
    }

    public void setUser2id(Integer user2id) {
        this.user2id = user2id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getEntry() {
        return entry;
    }

    public void setEntry(Integer entry) {
        this.entry = entry;
    }

    public Date getStartedat() {
        return startedat;
    }

    public void setStartedat(Date startedat) {
        this.startedat = startedat;
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