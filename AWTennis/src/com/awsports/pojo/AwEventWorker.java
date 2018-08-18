package com.awsports.pojo;

import java.util.Date;

public class AwEventWorker {
    private Integer id;

    private Integer userid;

    private Integer eventid;

    private String username;

    private String useravatar;

    private String role;

    private Integer privilege;

    private Boolean isreferee;

    private Boolean islinereferee;

    private Boolean iscaddy;

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

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getEventid() {
        return eventid;
    }

    public void setEventid(Integer eventid) {
        this.eventid = eventid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUseravatar() {
        return useravatar;
    }

    public void setUseravatar(String useravatar) {
        this.useravatar = useravatar == null ? null : useravatar.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public Integer getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Integer privilege) {
        this.privilege = privilege;
    }

    public Boolean getIsreferee() {
        return isreferee;
    }

    public void setIsreferee(Boolean isreferee) {
        this.isreferee = isreferee;
    }

    public Boolean getIslinereferee() {
        return islinereferee;
    }

    public void setIslinereferee(Boolean islinereferee) {
        this.islinereferee = islinereferee;
    }

    public Boolean getIscaddy() {
        return iscaddy;
    }

    public void setIscaddy(Boolean iscaddy) {
        this.iscaddy = iscaddy;
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