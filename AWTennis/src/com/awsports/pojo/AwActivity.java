package com.awsports.pojo;

import java.util.Date;

public class AwActivity {
    private Integer id;

    private String name;

    private Date startedat;

    private Date endedat;

    private Integer arena;

    private Double cost;

    private Date createdAt;

    private Date updatedAt;

    private Boolean invalid;

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

    public Integer getArena() {
        return arena;
    }

    public void setArena(Integer arena) {
        this.arena = arena;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
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
}