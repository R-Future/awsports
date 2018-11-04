package com.awsports.pojo;

import java.util.Date;

public class AwEvent {
    private Integer id;

    private Integer publisher;

    private String contact;

    private String contactinfo;

    private String cover;

    private String name;

    private String place;

    private String type;

    private String sponsor;

    private Integer numberofplayer;

//    private Date starttime;
//
//    private Date endtime;

    private Double cost;

//    private Date enrollingtime;
//
//    private Date closingtime;

    private String draw;

    private String schedule;

    private Date createdat;

    private Date updatedat;

    private Boolean invalid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPublisher() {
        return publisher;
    }

    public void setPublisher(Integer publisher) {
        this.publisher = publisher;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getContactinfo() {
        return contactinfo;
    }

    public void setContactinfo(String contactinfo) {
        this.contactinfo = contactinfo == null ? null : contactinfo.trim();
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover == null ? null : cover.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor == null ? null : sponsor.trim();
    }

    public Integer getNumberofplayer() {
        return numberofplayer;
    }

    public void setNumberofplayer(Integer numberofplayer) {
        this.numberofplayer = numberofplayer;
    }

//    public Date getStarttime() {
//        return starttime;
//    }
//
//    public void setStarttime(Date starttime) {
//        this.starttime = starttime;
//    }
//
//    public Date getEndtime() {
//        return endtime;
//    }
//
//    public void setEndtime(Date endtime) {
//        this.endtime = endtime;
//    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

//    public Date getEnrollingtime() {
//        return enrollingtime;
//    }
//
//    public void setEnrollingtime(Date enrollingtime) {
//        this.enrollingtime = enrollingtime;
//    }
//
//    public Date getClosingtime() {
//        return closingtime;
//    }
//
//    public void setClosingtime(Date closingtime) {
//        this.closingtime = closingtime;
//    }

    public String getDraw() {
        return draw;
    }

    public void setDraw(String draw) {
        this.draw = draw == null ? null : draw.trim();
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule == null ? null : schedule.trim();
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