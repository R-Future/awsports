package com.awsports.pojo;

import java.util.Date;

public class AwUser {
    private Integer id;

    private String name;

    private String password;

    private String nickname;

    private String portrait;

    private String realname;

    private String idcard;

    private String phone;

    private String email;

    private Boolean sex;

    private Double height;

    private Double weight;

    private Double level;

    private Double playedyears;

    private Integer forehand;

    private Boolean backhand;

    private String address;

    private Integer singletitles;

    private Integer doubletitles;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait == null ? null : portrait.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getLevel() {
        return level;
    }

    public void setLevel(Double level) {
        this.level = level;
    }

    public Double getPlayedyears() {
        return playedyears;
    }

    public void setPlayedyears(Double playedyears) {
        this.playedyears = playedyears;
    }

    public Integer getForehand() {
        return forehand;
    }

    public void setForehand(Integer forehand) {
        this.forehand = forehand;
    }

    public Boolean getBackhand() {
        return backhand;
    }

    public void setBackhand(Boolean backhand) {
        this.backhand = backhand;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getSingletitles() {
        return singletitles;
    }

    public void setSingletitles(Integer singletitles) {
        this.singletitles = singletitles;
    }

    public Integer getDoubletitles() {
        return doubletitles;
    }

    public void setDoubletitles(Integer doubletitles) {
        this.doubletitles = doubletitles;
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