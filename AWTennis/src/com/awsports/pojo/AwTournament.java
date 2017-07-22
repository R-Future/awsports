package com.awsports.pojo;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class AwTournament {
    private Integer id;

    @NotBlank(message="{tournament.name.null}")
    private String name;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startedat;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endedat;

    @NotNull(message="{tournament.areaid.null}")
    private Integer arenaid;

    private String level;

    @NumberFormat(style=Style.CURRENCY)
    private Integer prize;

    @Min(value=0,message="{tournament.cost.range}")
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

    public Date getStartedat() {
        return startedat;
    }

    public void setStartedat(Date startedat) {
        this.startedat = startedat;
    }

    public Date getEndedat() {
        return endedat;
    }

    public void setEndedat(Date endedat) {
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

    public Integer getPrize() {
        return prize;
    }

    public void setPraize(Integer prize) {
        this.prize = prize;
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