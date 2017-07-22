package com.awsports.pojo;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class AwArena {
    private Integer id;

    @NotBlank(message="{arena.name.null}")
    private String name;

    @NotBlank(message="{arena.address.null}")
    private String address;

    @NotNull(message="arena.type.null")
    private Integer type;

    @Min(value=0, message="{arena.indoornumber.range}")
    private Integer indoornumber;

    @Min(value=0, message="{arena.outdoornumber.range}")
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