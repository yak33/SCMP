package com.yyk.sz.zhzy.lzxt.hzlb.entity;

import java.util.Date;


public class PatientList {

    /**
     * 就诊号
     */
    private String MecidalNum;

    /**
     * 挂号序号
     */
    private String RegistrationNum;

    /**
     * 姓名
     */
    private String EmName;

    /**
     * 挂号日期
     */
    private String MakeDate;

    private String OnSetDate;


    /**
     * 开单医生
     */
    private String UserName;

    /**
     * 开单科室
     */
    private String DeptName;

    /**
     * 开单科室代码
     */
    private String DeptCode;

    /**
     * 就诊状态
     */
    private String TreatmentState;

    /**
     * 患者信息
     */
    private  String AttachmentSize;

    /**
     * 备注
     */
    private  String AttachmentStorageType;

    public String getOnSetDate() {
        return OnSetDate;
    }

    public void setOnSetDate(String onSetDate) {
        OnSetDate = onSetDate;
    }

    public String getMecidalNum() {
        return MecidalNum;
    }

    public void setMecidalNum(String mecidalNum) {
        MecidalNum = mecidalNum;
    }

    public String getRegistrationNum() {
        return RegistrationNum;
    }

    public void setRegistrationNum(String registrationNum) {
        RegistrationNum = registrationNum;
    }

    public String getEmName() {
        return EmName;
    }

    public void setEmName(String emName) {
        EmName = emName;
    }

    public String getMakeDate() {
        return MakeDate;
    }

    public void setMakeDate(String makeDate) {
        MakeDate = makeDate;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getDeptName() {
        return DeptName;
    }

    public void setDeptName(String deptName) {
        DeptName = deptName;
    }

    public String getDeptCode() {
        return DeptCode;
    }

    public void setDeptCode(String deptCode) {
        DeptCode = deptCode;
    }

    public String getTreatmentState() {
        return TreatmentState;
    }

    public void setTreatmentState(String treatmentState) {
        TreatmentState = treatmentState;
    }

    public String getAttachmentSize() {
        return AttachmentSize;
    }

    public void setAttachmentSize(String attachmentSize) {
        AttachmentSize = attachmentSize;
    }

    public String getAttachmentStorageType() {
        return AttachmentStorageType;
    }

    public void setAttachmentStorageType(String attachmentStorageType) {
        AttachmentStorageType = attachmentStorageType;
    }
}
