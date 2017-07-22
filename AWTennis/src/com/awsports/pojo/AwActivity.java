package com.awsports.pojo;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class AwActivity {
    private Integer id;

    @NotBlank(message="{activity.name.null}")
    private String name;

    @Future(message="activity.startedat.range")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startedat;
    
    @Future(message="activity.endedat.range")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endedat;

    @NotNull(message="activity.arenaid.null")
    private Integer arenaid;

    @Min(value=0, message="activity.cost.range")
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