package com.awsports.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class AwTeam {
    private Integer id;

    private Integer user1id;

    private Integer user2id;

    private Integer entry;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startedat;

    private Date createdat;

    private Date updatedat;

    private Boolean invalid;

    private String name;

    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}