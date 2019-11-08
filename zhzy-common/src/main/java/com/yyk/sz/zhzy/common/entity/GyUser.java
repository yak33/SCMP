package com.yyk.sz.zhzy.common.entity;

import com.yyk.sz.common.base.domain.BaseEntity;

import java.security.Timestamp;


public class GyUser extends BaseEntity {

    /**
     * 用户编码
     */
    private String UserCode;

    /**
     * 用户名称
     */
    private String UserName;

    /**
     * 用户密码
     */
    private String PassWord;


    /**
     * 联系方式
     */
    private String Mobile;


    /**
     * 科室编码
     */
    private String DeptCode;


    /**
     * HIS用户对应编码
     */
    private String HISUserCode;


    /**
     * 备注
     */
    private String Remark;


    /**
     * 用户身份标识
     */
    private Boolean IdentityFlag;

    /**
     * 创建时间
     */
    private Timestamp SysCreateDate;

    /**
     * 创建者
     */
    private Boolean SysCreateBy;

    /**
     * 更新时间
     */
    private Timestamp SysUpdateDate;

    /**
     * 更新者
     */
    private String SysUpdateBy;

    /**
     * 删除标识
     */
    private String SysDelFlag;

    public String getUserCode() {
        return UserCode;
    }

    public void setUserCode(String userCode) {
        UserCode = userCode;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getDeptCode() {
        return DeptCode;
    }

    public void setDeptCode(String deptCode) {
        DeptCode = deptCode;
    }

    public String getHISUserCode() {
        return HISUserCode;
    }

    public void setHISUserCode(String HISUserCode) {
        this.HISUserCode = HISUserCode;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public Boolean getIdentityFlag() {
        return IdentityFlag;
    }

    public void setIdentityFlag(Boolean identityFlag) {
        IdentityFlag = identityFlag;
    }

    public Timestamp getSysCreateDate() {
        return SysCreateDate;
    }

    public void setSysCreateDate(Timestamp sysCreateDate) {
        SysCreateDate = sysCreateDate;
    }

    public Boolean getSysCreateBy() {
        return SysCreateBy;
    }

    public void setSysCreateBy(Boolean sysCreateBy) {
        SysCreateBy = sysCreateBy;
    }

    public Timestamp getSysUpdateDate() {
        return SysUpdateDate;
    }

    public void setSysUpdateDate(Timestamp sysUpdateDate) {
        SysUpdateDate = sysUpdateDate;
    }

    public String getSysUpdateBy() {
        return SysUpdateBy;
    }

    public void setSysUpdateBy(String sysUpdateBy) {
        SysUpdateBy = sysUpdateBy;
    }

    public String getSysDelFlag() {
        return SysDelFlag;
    }

    public void setSysDelFlag(String sysDelFlag) {
        SysDelFlag = sysDelFlag;
    }
}
