package com.awsports.pojo;

import java.util.Date;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class AwTournament {
    private Integer id;

    private String name;

    private String startedat;

    private String endedat;

    private Integer arenaid;

    private String level;

    @NumberFormat(style=Style.CURRENCY)
    private Integer praize;

    @NumberFormat(style=Style.CURRENCY)
    private Double cost;

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

    public String getStartedat() {
        return startedat;
    }

    public void setStartedat(String startedat) {
        this.startedat = startedat;
    }

    public String getEndedat() {
        return endedat;
    }

    public void setEndedat(String endedat) {
        this.endedat = endedat;
    }

    public Integer getArenaid() {
        return arenaid;
    }

    public void setArenaid(Integer arenaid) {
        this.arenaid = arenaid;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public Integer getPraize() {
        return praize;
    }

    public void setPraize(Integer praize) {
        this.praize = praize;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
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