package com.xl.model;

import java.util.Date;

/**
 * Created by  X.L on 2018/5/27.
 */
public class WechatAuthId {
    private Long wechatAuthId;
    private String openId;
    private Date createTime;
    private PersonInfo pesonInfo;

    public Long getWechatAuthId() {
        return wechatAuthId;
    }

    public void setWechatAuthId(Long wechatAuthId) {
        this.wechatAuthId = wechatAuthId;
    }

    public String getOpebId() {
        return openId;
    }

    public void setOpebId(String openId) {
        this.openId = openId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public PersonInfo getPesonInfo() {
        return pesonInfo;
    }

    public void setPesonInfo(PersonInfo pesonInfo) {
        this.pesonInfo = pesonInfo;
    }
}
