package com.yyk.sz.zhzy.lzxt.jyjc.entity;

import java.util.Date;
import java.util.List;

public class SysPharmacy {
    private String uuid;

    private Integer empbasicmainid;

    private String drugcode;

    private String drugname;

    private Integer itemtype;

    private Integer takeflag;

    private String takeflagstr;

    private Date syscreatedate;

    private String syscreateby;

    private Date sysupdatedate;

    private String sysupdateby;

    private Integer versionnum;

    private String sysdelflag;

    private double quantity;

    private String takeflagstatus;

    /**
     * 缴费项目:0中药处方 1西药处方 2检验 3检查 4临证治疗 5针灸治疗
     */
    private Integer payitem;

    private String payitemstr;

    private Integer paystatus;

    private String paystatusstr;

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

    /**
     * 付数
     */
    private Integer usageCount;

    /**
     * 是否代煎
     * @return
     */
    private Integer daiJian;

    private String prescriptionunitname;

    private String zyFlag; //中药

    private String xyFlag; //西药

    private List<SysPharmacy> zyList; //存中药

    private List<SysPharmacy> xyList; //存西药


    public String getTakeflagstatus() {
        return takeflagstatus;
    }

    public void setTakeflagstatus(String takeflagstatus) {
        this.takeflagstatus = takeflagstatus;
    }

    public String getPrescriptionunitname() {
        return prescriptionunitname;
    }

    public void setPrescriptionunitname(String prescriptionunitname) {
        this.prescriptionunitname = prescriptionunitname;
    }

    public String getZyFlag() {
        return zyFlag;
    }

    public void setZyFlag(String zyFlag) {
        this.zyFlag = zyFlag;
    }

    public String getXyFlag() {
        return xyFlag;
    }

    public void setXyFlag(String xyFlag) {
        this.xyFlag = xyFlag;
    }

    public List<SysPharmacy> getZyList() {
        return zyList;
    }

    public void setZyList(List<SysPharmacy> zyList) {
        this.zyList = zyList;
    }

    public List<SysPharmacy> getXyList() {
        return xyList;
    }

    public void setXyList(List<SysPharmacy> xyList) {
        this.xyList = xyList;
    }

    public Integer getUsageCount() {
        return usageCount;
    }

    public void setUsageCount(Integer usageCount) {
        this.usageCount = usageCount;
    }

    public Integer getDaiJian() {
        return daiJian;
    }

    public void setDaiJian(Integer daiJian) {
        this.daiJian = daiJian;
    }

    public String getTakeflagstr() {
        return takeflagstr;
    }

    public void setTakeflagstr(String takeflagstr) {
        this.takeflagstr = takeflagstr;
    }

    public Integer getPayitem() {
        return payitem;
    }

    public void setPayitem(Integer payitem) {
        this.payitem = payitem;
    }

    public String getPayitemstr() {
        return payitemstr;
    }

    public void setPayitemstr(String payitemstr) {
        this.payitemstr = payitemstr;
    }

    public Integer getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(Integer paystatus) {
        this.paystatus = paystatus;
    }

    public String getPaystatusstr() {
        return paystatusstr;
    }

    public void setPaystatusstr(String paystatusstr) {
        this.paystatusstr = paystatusstr;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
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

    public String getDrugcode() {
        return drugcode;
    }

    public void setDrugcode(String drugcode) {
        this.drugcode = drugcode == null ? null : drugcode.trim();
    }

    public String getDrugname() {
        return drugname;
    }

    public void setDrugname(String drugname) {
        this.drugname = drugname == null ? null : drugname.trim();
    }

    public Integer getItemtype() {
        return itemtype;
    }

    public void setItemtype(Integer itemtype) {
        this.itemtype = itemtype;
    }

    public Integer getTakeflag() {
        return takeflag;
    }

    public void setTakeflag(Integer takeflag) {
        this.takeflag = takeflag;
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

    public String getSysdelflag() {
        return sysdelflag;
    }

    public void setSysdelflag(String sysdelflag) {
        this.sysdelflag = sysdelflag == null ? null : sysdelflag.trim();
    }
}