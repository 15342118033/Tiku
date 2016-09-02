package com.yu.test.tiku.pojo;

/**
 * Created by yu on 2016/9/2.
 */
public class UserBean {
    private String success;
    private Users user;
    private String reason;


    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
