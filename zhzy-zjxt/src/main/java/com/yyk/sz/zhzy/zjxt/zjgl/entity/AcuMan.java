package com.yyk.sz.zhzy.zjxt.zjgl.entity;

import com.yyk.sz.common.base.domain.BaseEntity;

/**
 * 针灸管理
 * @Author: ZhangChao
 * @Date: 2019/2/19 11:50
 * @Version: 1.0
 */
public class AcuMan extends BaseEntity {

    private String registrationNum;
    private String empBasicMainID;
    private String emName;
    private String beginDate;
    private String makeBeginDate;
    private String zjMinutes; //留针时间
    private String zzDateTime;
    private String zzTime;
    private String bzTime;

    private String strDateTime;

    public String getStrDateTime() {
        return strDateTime;
    }

    public void setStrDateTime(String strDateTime) {
        this.strDateTime = strDateTime;
    }

    public String getRegistrationNum() {
        return registrationNum;
    }

    public void setRegistrationNum(String registrationNum) {
        this.registrationNum = registrationNum;
    }

    public String getEmpBasicMainID() {
        return empBasicMainID;
    }

    public void setEmpBasicMainID(String empBasicMainID) {
        this.empBasicMainID = empBasicMainID;
    }

    public String getEmName() {
        return emName;
    }

    public void setEmName(String emName) {
        this.emName = emName;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getMakeBeginDate() {
        return makeBeginDate;
    }

    public void setMakeBeginDate(String makeBeginDate) {
        this.makeBeginDate = makeBeginDate;
    }

    public String getZjMinutes() {
        return zjMinutes;
    }

    public void setZjMinutes(String zjMinutes) {
        this.zjMinutes = zjMinutes;
    }

    public String getZzDateTime() {
        return zzDateTime;
    }

    public void setZzDateTime(String zzDateTime) {
        this.zzDateTime = zzDateTime;
    }

    public String getZzTime() {
        return zzTime;
    }

    public void setZzTime(String zzTime) {
        this.zzTime = zzTime;
    }

    public String getBzTime() {
        return bzTime;
    }

    public void setBzTime(String bzTime) {
        this.bzTime = bzTime;
    }
}
