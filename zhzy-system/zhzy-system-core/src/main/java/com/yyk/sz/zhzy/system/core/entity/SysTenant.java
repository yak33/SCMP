package com.yyk.sz.zhzy.system.core.entity;

import java.util.Date;

public class SysTenant {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_tenant.UUID
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    private String uuid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_tenant.code
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    private String code;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_tenant.name
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_tenant.contactor
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    private String contactor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_tenant.phoneNo
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    private String phoneno;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_tenant.address
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_tenant.email
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_tenant.remark
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_tenant.SysCreateDate
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    private Date syscreatedate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_tenant.SysCreateBy
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    private String syscreateby;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_tenant.SysUpdateDate
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    private Date sysupdatedate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_tenant.SysUpdateBy
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    private String sysupdateby;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_tenant.VersionNum
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    private Integer versionnum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_tenant.SysDelFlag
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    private String sysdelflag;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_tenant
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public SysTenant(String uuid, String code, String name, String contactor, String phoneno, String address, String email, String remark, Date syscreatedate, String syscreateby, Date sysupdatedate, String sysupdateby, Integer versionnum, String sysdelflag) {
        this.uuid = uuid;
        this.code = code;
        this.name = name;
        this.contactor = contactor;
        this.phoneno = phoneno;
        this.address = address;
        this.email = email;
        this.remark = remark;
        this.syscreatedate = syscreatedate;
        this.syscreateby = syscreateby;
        this.sysupdatedate = sysupdatedate;
        this.sysupdateby = sysupdateby;
        this.versionnum = versionnum;
        this.sysdelflag = sysdelflag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_tenant
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public SysTenant() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_tenant.UUID
     *
     * @return the value of sys_tenant.UUID
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_tenant.UUID
     *
     * @param uuid the value for sys_tenant.UUID
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_tenant.code
     *
     * @return the value of sys_tenant.code
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_tenant.code
     *
     * @param code the value for sys_tenant.code
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_tenant.name
     *
     * @return the value of sys_tenant.name
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_tenant.name
     *
     * @param name the value for sys_tenant.name
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_tenant.contactor
     *
     * @return the value of sys_tenant.contactor
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public String getContactor() {
        return contactor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_tenant.contactor
     *
     * @param contactor the value for sys_tenant.contactor
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public void setContactor(String contactor) {
        this.contactor = contactor == null ? null : contactor.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_tenant.phoneNo
     *
     * @return the value of sys_tenant.phoneNo
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public String getPhoneno() {
        return phoneno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_tenant.phoneNo
     *
     * @param phoneno the value for sys_tenant.phoneNo
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno == null ? null : phoneno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_tenant.address
     *
     * @return the value of sys_tenant.address
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_tenant.address
     *
     * @param address the value for sys_tenant.address
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_tenant.email
     *
     * @return the value of sys_tenant.email
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_tenant.email
     *
     * @param email the value for sys_tenant.email
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_tenant.remark
     *
     * @return the value of sys_tenant.remark
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_tenant.remark
     *
     * @param remark the value for sys_tenant.remark
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_tenant.SysCreateDate
     *
     * @return the value of sys_tenant.SysCreateDate
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public Date getSyscreatedate() {
        return syscreatedate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_tenant.SysCreateDate
     *
     * @param syscreatedate the value for sys_tenant.SysCreateDate
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public void setSyscreatedate(Date syscreatedate) {
        this.syscreatedate = syscreatedate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_tenant.SysCreateBy
     *
     * @return the value of sys_tenant.SysCreateBy
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public String getSyscreateby() {
        return syscreateby;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_tenant.SysCreateBy
     *
     * @param syscreateby the value for sys_tenant.SysCreateBy
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public void setSyscreateby(String syscreateby) {
        this.syscreateby = syscreateby == null ? null : syscreateby.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_tenant.SysUpdateDate
     *
     * @return the value of sys_tenant.SysUpdateDate
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public Date getSysupdatedate() {
        return sysupdatedate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_tenant.SysUpdateDate
     *
     * @param sysupdatedate the value for sys_tenant.SysUpdateDate
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public void setSysupdatedate(Date sysupdatedate) {
        this.sysupdatedate = sysupdatedate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_tenant.SysUpdateBy
     *
     * @return the value of sys_tenant.SysUpdateBy
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public String getSysupdateby() {
        return sysupdateby;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_tenant.SysUpdateBy
     *
     * @param sysupdateby the value for sys_tenant.SysUpdateBy
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public void setSysupdateby(String sysupdateby) {
        this.sysupdateby = sysupdateby == null ? null : sysupdateby.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_tenant.VersionNum
     *
     * @return the value of sys_tenant.VersionNum
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public Integer getVersionnum() {
        return versionnum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_tenant.VersionNum
     *
     * @param versionnum the value for sys_tenant.VersionNum
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public void setVersionnum(Integer versionnum) {
        this.versionnum = versionnum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_tenant.SysDelFlag
     *
     * @return the value of sys_tenant.SysDelFlag
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public String getSysdelflag() {
        return sysdelflag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_tenant.SysDelFlag
     *
     * @param sysdelflag the value for sys_tenant.SysDelFlag
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public void setSysdelflag(String sysdelflag) {
        this.sysdelflag = sysdelflag == null ? null : sysdelflag.trim();
    }
}