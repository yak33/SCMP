package com.yyk.sz.zhzy.system.core.entity;

import java.util.Date;
import java.util.List;

public class GyUser {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Gy_User.UserCode
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    private String usercode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Gy_User.UUID
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    private String uuid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Gy_User.UserName
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Gy_User.PassWord
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Gy_User.Mobile
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    private String mobile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Gy_User.DeptCode
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    private String deptcode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Gy_User.HISUserCode
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    private String hisusercode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Gy_User.Remark
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Gy_User.IdentityFlag
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    private Boolean identityflag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Gy_User.SysCreateDate
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    private Date syscreatedate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Gy_User.SysCreateBy
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    private String syscreateby;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Gy_User.SysUpdateDate
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    private Date sysupdatedate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Gy_User.SysUpdateBy
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    private String sysupdateby;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Gy_User.VersionNum
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    private Integer versionnum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Gy_User.SysDelFlag
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    private String sysdelflag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Gy_User.alias
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    private String alias;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Gy_User.address
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Gy_User.email
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Gy_User.status
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Gy_User.startDate
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    private Date startdate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Gy_User.endDate
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    private Date enddate;

    private String node;

    private String pId;

    private String sex;

    private String flag;

    private List<SysRole> userRoles;

    private String hospid;

    public String getHospid() {
        return hospid;
    }

    public void setHospid(String hospid) {
        this.hospid = hospid;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public List<SysRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<SysRole> userRoles) {
        this.userRoles = userRoles;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Gy_User
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public GyUser(String usercode, String uuid, String username, String password, String mobile, String deptcode, String hisusercode, String remark, Boolean identityflag, Date syscreatedate, String syscreateby, Date sysupdatedate, String sysupdateby, Integer versionnum, String sysdelflag, String alias, String sex, String address, String email, String status, Date startdate, Date enddate) {
        this.usercode = usercode;
        this.uuid = uuid;
        this.username = username;
        this.password = password;
        this.mobile = mobile;
        this.deptcode = deptcode;
        this.hisusercode = hisusercode;
        this.remark = remark;
        this.identityflag = identityflag;
        this.syscreatedate = syscreatedate;
        this.syscreateby = syscreateby;
        this.sysupdatedate = sysupdatedate;
        this.sysupdateby = sysupdateby;
        this.versionnum = versionnum;
        this.sysdelflag = sysdelflag;
        this.alias = alias;
        this.sex = sex;
        this.address = address;
        this.email = email;
        this.status = status;
        this.startdate = startdate;
        this.enddate = enddate;
        this.node = node;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Gy_User
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public GyUser() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_User.UserCode
     *
     * @return the value of Gy_User.UserCode
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public String getUsercode() {
        return usercode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_User.UserCode
     *
     * @param usercode the value for Gy_User.UserCode
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public void setUsercode(String usercode) {
        this.usercode = usercode == null ? null : usercode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_User.UUID
     *
     * @return the value of Gy_User.UUID
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_User.UUID
     *
     * @param uuid the value for Gy_User.UUID
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_User.UserName
     *
     * @return the value of Gy_User.UserName
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_User.UserName
     *
     * @param username the value for Gy_User.UserName
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_User.PassWord
     *
     * @return the value of Gy_User.PassWord
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_User.PassWord
     *
     * @param password the value for Gy_User.PassWord
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_User.Mobile
     *
     * @return the value of Gy_User.Mobile
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_User.Mobile
     *
     * @param mobile the value for Gy_User.Mobile
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_User.DeptCode
     *
     * @return the value of Gy_User.DeptCode
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public String getDeptcode() {
        return deptcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_User.DeptCode
     *
     * @param deptcode the value for Gy_User.DeptCode
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public void setDeptcode(String deptcode) {
        this.deptcode = deptcode == null ? null : deptcode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_User.HISUserCode
     *
     * @return the value of Gy_User.HISUserCode
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public String getHisusercode() {
        return hisusercode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_User.HISUserCode
     *
     * @param hisusercode the value for Gy_User.HISUserCode
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public void setHisusercode(String hisusercode) {
        this.hisusercode = hisusercode == null ? null : hisusercode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_User.Remark
     *
     * @return the value of Gy_User.Remark
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_User.Remark
     *
     * @param remark the value for Gy_User.Remark
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_User.IdentityFlag
     *
     * @return the value of Gy_User.IdentityFlag
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public Boolean getIdentityflag() {
        return identityflag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_User.IdentityFlag
     *
     * @param identityflag the value for Gy_User.IdentityFlag
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public void setIdentityflag(Boolean identityflag) {
        this.identityflag = identityflag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_User.SysCreateDate
     *
     * @return the value of Gy_User.SysCreateDate
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public Date getSyscreatedate() {
        return syscreatedate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_User.SysCreateDate
     *
     * @param syscreatedate the value for Gy_User.SysCreateDate
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public void setSyscreatedate(Date syscreatedate) {
        this.syscreatedate = syscreatedate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_User.SysCreateBy
     *
     * @return the value of Gy_User.SysCreateBy
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public String getSyscreateby() {
        return syscreateby;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_User.SysCreateBy
     *
     * @param syscreateby the value for Gy_User.SysCreateBy
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public void setSyscreateby(String syscreateby) {
        this.syscreateby = syscreateby == null ? null : syscreateby.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_User.SysUpdateDate
     *
     * @return the value of Gy_User.SysUpdateDate
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public Date getSysupdatedate() {
        return sysupdatedate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_User.SysUpdateDate
     *
     * @param sysupdatedate the value for Gy_User.SysUpdateDate
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public void setSysupdatedate(Date sysupdatedate) {
        this.sysupdatedate = sysupdatedate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_User.SysUpdateBy
     *
     * @return the value of Gy_User.SysUpdateBy
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public String getSysupdateby() {
        return sysupdateby;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_User.SysUpdateBy
     *
     * @param sysupdateby the value for Gy_User.SysUpdateBy
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public void setSysupdateby(String sysupdateby) {
        this.sysupdateby = sysupdateby == null ? null : sysupdateby.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_User.VersionNum
     *
     * @return the value of Gy_User.VersionNum
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public Integer getVersionnum() {
        return versionnum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_User.VersionNum
     *
     * @param versionnum the value for Gy_User.VersionNum
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public void setVersionnum(Integer versionnum) {
        this.versionnum = versionnum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_User.SysDelFlag
     *
     * @return the value of Gy_User.SysDelFlag
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public String getSysdelflag() {
        return sysdelflag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_User.SysDelFlag
     *
     * @param sysdelflag the value for Gy_User.SysDelFlag
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public void setSysdelflag(String sysdelflag) {
        this.sysdelflag = sysdelflag == null ? null : sysdelflag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_User.alias
     *
     * @return the value of Gy_User.alias
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public String getAlias() {
        return alias;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_User.alias
     *
     * @param alias the value for Gy_User.alias
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public void setAlias(String alias) {
        this.alias = alias == null ? null : alias.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_User.address
     *
     * @return the value of Gy_User.address
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public String getaddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_User.address
     *
     * @param address the value for Gy_User.address
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public void setaddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_User.email
     *
     * @return the value of Gy_User.email
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_User.email
     *
     * @param email the value for Gy_User.email
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_User.status
     *
     * @return the value of Gy_User.status
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_User.status
     *
     * @param status the value for Gy_User.status
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_User.startDate
     *
     * @return the value of Gy_User.startDate
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public Date getStartdate() {
        return startdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_User.startDate
     *
     * @param startdate the value for Gy_User.startDate
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_User.endDate
     *
     * @return the value of Gy_User.endDate
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public Date getEnddate() {
        return enddate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_User.endDate
     *
     * @param enddate the value for Gy_User.endDate
     *
     * @mbggenerated Thu Dec 20 19:10:25 CST 2018
     */
    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }
}