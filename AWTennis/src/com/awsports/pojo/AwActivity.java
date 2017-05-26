package com.awsports.pojo;

import java.util.Date;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class AwActivity {
    private Integer id;

    private String name;

    //@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private String startedat;

    //@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private String endedat;

    private Integer arenaId;

    @NumberFormat(style=Style.CURRENCY)
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

    public Integer getArenaId() {
        return arenaId;
    }

    public void setArenaId(Integer arenaId) {
        this.arenaId = arenaId;
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