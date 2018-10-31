package com.xl.model;

import java.util.Date;

/**
 * Created by  X.L on 2018/5/27.
 */
public class LocalAuth {
    private String localAuthId;
    private String userName;
    private String passWord;
    private Date creatTime;
    private Date lastEditTime;
    private PersonInfo pesonInfo;

    public String getLocalAuthId() {
        return localAuthId;
    }

    public void setLocalAuthId(String localAuthId) {
        this.localAuthId = localAuthId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public PersonInfo getPesonInfo() {
        return pesonInfo;
    }

    public void setPesonInfo(PersonInfo pesonInfo) {
        this.pesonInfo = pesonInfo;
    }
}
