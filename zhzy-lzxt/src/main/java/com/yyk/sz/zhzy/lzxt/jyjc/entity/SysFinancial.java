package com.yyk.sz.zhzy.lzxt.jyjc.entity;

import java.math.BigDecimal;
import java.util.Date;

public class SysFinancial {
    private String uuid;

    private Integer empbasicmainid;

    private String payitemcode;

    /**
     * 缴费项目:0中药处方 1西药处方 2检验 3检查 4临证治疗 5针灸治疗
     */
    private Integer payitem;

    private String payitemstr;

    private Integer paytype;

    private BigDecimal totalmoney;

    private Integer paystatus;

    private String paystatusstr;

    private Date syscreatedate;

    private String syscreateby;

    private Date sysupdatedate;

    private String sysupdateby;

    private Integer versionnum;

    private double ratio; //报销比例

    /**********************************************/
    /**
     * 挂号序号
     */
    private String registrationNum;
    /**
     * 就诊号
     */
    private String mecidalNum;
    /**
     * 姓名
     */
    private String emName;
    /**
     * 挂号日期
     */
    private String makeDate;
    /**
     * 开单医生
     */
    private String userName;
    /**
     * 开单科室
     */
    private String deptName;


    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public String getPayitemstr() {
        return payitemstr;
    }

    public void setPayitemstr(String payitemstr) {
        this.payitemstr = payitemstr;
    }

    public String getRegistrationNum() {
        return registrationNum;
    }

    public void setRegistrationNum(String registrationNum) {
        this.registrationNum = registrationNum;
    }

    public String getMecidalNum() {
        return mecidalNum;
    }

    public void setMecidalNum(String mecidalNum) {
        this.mecidalNum = mecidalNum;
    }

    public String getEmName() {
        return emName;
    }

    public void setEmName(String emName) {
        this.emName = emName;
    }

    public String getMakeDate() {
        return makeDate;
    }

    public void setMakeDate(String makeDate) {
        this.makeDate = makeDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getPaystatusstr() {
        return paystatusstr;
    }

    public void setPaystatusstr(String paystatusstr) {
        this.paystatusstr = paystatusstr;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public Integer getEmpbasicmainid() {
        return empbasicmainid;
    }

    public void setEmpbasicmainid(Integer empbasicmainid) {
        this.empbasicmainid = empbasicmainid;
    }

    public String getPayitemcode() {
        return payitemcode;
    }

    public void setPayitemcode(String payitemcode) {
        this.payitemcode = payitemcode == null ? null : payitemcode.trim();
    }

    public Integer getPayitem() {
        return payitem;
    }

    public void setPayitem(Integer payitem) {
        this.payitem = payitem;
    }

    public Integer getPaytype() {
        return paytype;
    }

    public void setPaytype(Integer paytype) {
        this.paytype = paytype;
    }

    public BigDecimal getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(BigDecimal totalmoney) {
        this.totalmoney = totalmoney;
    }

    public Integer getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(Integer paystatus) {
        this.paystatus = paystatus;
    }

    public Date getSyscreatedate() {
        return syscreatedate;
    }

    public void setSyscreatedate(Date syscreatedate) {
        this.syscreatedate = syscreatedate;
    }

    public String getSyscreateby() {
        return syscreateby;
    }

    public void setSyscreateby(String syscreateby) {
        this.syscreateby = syscreateby == null ? null : syscreateby.trim();
    }

    public Date getSysupdatedate() {
        return sysupdatedate;
    }

    public void setSysupdatedate(Date sysupdatedate) {
        this.sysupdatedate = sysupdatedate;
    }

    public String getSysupdateby() {
        return sysupdateby;
    }

    public void setSysupdateby(String sysupdateby) {
        this.sysupdateby = sysupdateby == null ? null : sysupdateby.trim();
    }

    public Integer getVersionnum() {
        return versionnum;
    }

    public void setVersionnum(Integer versionnum) {
        this.versionnum = versionnum;
    }

}