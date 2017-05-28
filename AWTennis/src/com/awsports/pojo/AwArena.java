package com.awsports.pojo;

import java.util.Date;

public class AwArena {
    private Integer id;

    private String name;

    private String address;

    private Integer type;

    private Integer indoornumber;

    private Integer outdoornumber;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIndoornumber() {
        return indoornumber;
    }

    public void setIndoornumber(Integer indoornumber) {
        this.indoornumber = indoornumber;
    }

    public Integer getOutdoornumber() {
        return outdoornumber;
    }

    public void setOutdoornumber(Integer outdoornumber) {
        this.outdoornumber = outdoornumber;
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