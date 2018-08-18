package com.awsports.pojo;

import java.util.Date;

public class AwStatistic {
    private Integer id;

    private String matchid;

    private Integer userid;

    private Integer aces;

    private Integer firstservices;

    private Integer secondservices;

    private Integer doublefaults;

    private Integer firstgoals;

    private Integer secondgoals;

    private Integer savebreakpoints;

    private Integer breakpoints;

    private Integer servicebreakpoints;

    private Integer receivebreakpoints;

    private Integer firstreturngoals;

    private Integer secondreturngoals;

    private Integer services;

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

    public String getMatchid() {
        return matchid;
    }

    public void setMatchid(String matchid) {
        this.matchid = matchid == null ? null : matchid.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getAces() {
        return aces;
    }

    public void setAces(Integer aces) {
        this.aces = aces;
    }

    public Integer getFirstservices() {
        return firstservices;
    }

    public void setFirstservices(Integer firstservices) {
        this.firstservices = firstservices;
    }

    public Integer getSecondservices() {
        return secondservices;
    }

    public void setSecondservices(Integer secondservices) {
        this.secondservices = secondservices;
    }

    public Integer getDoublefaults() {
        return doublefaults;
    }

    public void setDoublefaults(Integer doublefaults) {
        this.doublefaults = doublefaults;
    }

    public Integer getFirstgoals() {
        return firstgoals;
    }

    public void setFirstgoals(Integer firstgoals) {
        this.firstgoals = firstgoals;
    }

    public Integer getSecondgoals() {
        return secondgoals;
    }

    public void setSecondgoals(Integer secondgoals) {
        this.secondgoals = secondgoals;
    }

    public Integer getSavebreakpoints() {
        return savebreakpoints;
    }

    public void setSavebreakpoints(Integer savebreakpoints) {
        this.savebreakpoints = savebreakpoints;
    }

    public Integer getBreakpoints() {
        return breakpoints;
    }

    public void setBreakpoints(Integer breakpoints) {
        this.breakpoints = breakpoints;
    }

    public Integer getServicebreakpoints() {
        return servicebreakpoints;
    }

    public void setServicebreakpoints(Integer servicebreakpoints) {
        this.servicebreakpoints = servicebreakpoints;
    }

    public Integer getReceivebreakpoints() {
        return receivebreakpoints;
    }

    public void setReceivebreakpoints(Integer receivebreakpoints) {
        this.receivebreakpoints = receivebreakpoints;
    }

    public Integer getFirstreturngoals() {
        return firstreturngoals;
    }

    public void setFirstreturngoals(Integer firstreturngoals) {
        this.firstreturngoals = firstreturngoals;
    }

    public Integer getSecondreturngoals() {
        return secondreturngoals;
    }

    public void setSecondreturngoals(Integer secondreturngoals) {
        this.secondreturngoals = secondreturngoals;
    }

    public Integer getServices() {
        return services;
    }

    public void setServices(Integer services) {
        this.services = services;
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