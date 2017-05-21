package com.awsports.pojo;

import java.util.Date;

public class AwTeam {
    private Integer id;

    private Integer user1id;

    private Integer user2id;

    private byte[] entry;

    private Date startedAt;

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

    public byte[] getEntry() {
        return entry;
    }

    public void setEntry(byte[] entry) {
        this.entry = entry;
    }

    public Date getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(Date startedAt) {
        this.startedAt = startedAt;
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