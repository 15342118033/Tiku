package com.yu.test.tiku.pojo;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/9/2.
 */
public class Users{
    private String id;
    private String username;
    private String nickname;
    private String password;
    private String telephone;
    private String picurl;

    public Users() {
    }

    public Users(String id, String username, String nickname, String password, String telephone, String picurl) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.telephone = telephone;
        this.picurl = picurl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", telephone='" + telephone + '\'' +
                ", picurl='" + picurl + '\'' +
                '}';
    }
}
