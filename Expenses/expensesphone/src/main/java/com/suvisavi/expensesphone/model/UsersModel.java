package com.suvisavi.expensesphone.model;

/**
 * Created by suvisavi on 16/07/15.
 */
public class UsersModel {
    private Integer userId=null;
    private String logonId=null;
    private String password=null;
    private String nickName=null;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLogonId() {
        return logonId;
    }

    public void setLogonId(String logonId) {
        this.logonId = logonId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
