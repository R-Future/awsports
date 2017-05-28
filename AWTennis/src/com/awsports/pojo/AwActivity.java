package com.awsports.pojo;

import java.util.Date;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class AwActivity {
    private Integer id;

    private String name;

    private String startedat;

    private String endedat;

    private Integer arenaid;

    @NumberFormat(style=Style.CURRENCY)
    private Double cost;

    private Date createdat;

    private Date updatedat;

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

    public Integer getArenaid() {
        return arenaid;
    }

    public void setArenaid(Integer arenaid) {
        this.arenaid = arenaid;
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
}