package com.yyk.sz.zhzy.system.core.entity;

import java.util.Date;

public class SysMenu {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.UUID
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    private String uuid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.code
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    private String code;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.name
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.url
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    private String url;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.parentId
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    private String parentid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.icon
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    private String icon;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.level
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    private Integer level;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.type
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.sortNo
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    private Integer sortno;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.remark
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.target
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    private String target;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.SysCreateDate
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    private Date syscreatedate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.SysCreateBy
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    private String syscreateby;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.SysUpdateDate
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    private Date sysupdatedate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.SysUpdateBy
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    private String sysupdateby;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.VersionNum
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    private Integer versionnum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.SysDelFlag
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    private String sysdelflag;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_menu
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public SysMenu(String uuid, String code, String name, String url, String parentid, String icon, Integer level, String type, Integer sortno, String remark, String target, Date syscreatedate, String syscreateby, Date sysupdatedate, String sysupdateby, Integer versionnum, String sysdelflag) {
        this.uuid = uuid;
        this.code = code;
        this.name = name;
        this.url = url;
        this.parentid = parentid;
        this.icon = icon;
        this.level = level;
        this.type = type;
        this.sortno = sortno;
        this.remark = remark;
        this.target = target;
        this.syscreatedate = syscreatedate;
        this.syscreateby = syscreateby;
        this.sysupdatedate = sysupdatedate;
        this.sysupdateby = sysupdateby;
        this.versionnum = versionnum;
        this.sysdelflag = sysdelflag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_menu
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public SysMenu() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.UUID
     *
     * @return the value of sys_menu.UUID
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.UUID
     *
     * @param uuid the value for sys_menu.UUID
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.code
     *
     * @return the value of sys_menu.code
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.code
     *
     * @param code the value for sys_menu.code
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.name
     *
     * @return the value of sys_menu.name
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.name
     *
     * @param name the value for sys_menu.name
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.url
     *
     * @return the value of sys_menu.url
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.url
     *
     * @param url the value for sys_menu.url
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.parentId
     *
     * @return the value of sys_menu.parentId
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public String getParentid() {
        return parentid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.parentId
     *
     * @param parentid the value for sys_menu.parentId
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public void setParentid(String parentid) {
        this.parentid = parentid == null ? null : parentid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.icon
     *
     * @return the value of sys_menu.icon
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public String getIcon() {
        return icon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.icon
     *
     * @param icon the value for sys_menu.icon
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.level
     *
     * @return the value of sys_menu.level
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.level
     *
     * @param level the value for sys_menu.level
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.type
     *
     * @return the value of sys_menu.type
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.type
     *
     * @param type the value for sys_menu.type
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.sortNo
     *
     * @return the value of sys_menu.sortNo
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public Integer getSortno() {
        return sortno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.sortNo
     *
     * @param sortno the value for sys_menu.sortNo
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public void setSortno(Integer sortno) {
        this.sortno = sortno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.remark
     *
     * @return the value of sys_menu.remark
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.remark
     *
     * @param remark the value for sys_menu.remark
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.target
     *
     * @return the value of sys_menu.target
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public String getTarget() {
        return target;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.target
     *
     * @param target the value for sys_menu.target
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public void setTarget(String target) {
        this.target = target == null ? null : target.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.SysCreateDate
     *
     * @return the value of sys_menu.SysCreateDate
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public Date getSyscreatedate() {
        return syscreatedate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.SysCreateDate
     *
     * @param syscreatedate the value for sys_menu.SysCreateDate
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public void setSyscreatedate(Date syscreatedate) {
        this.syscreatedate = syscreatedate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.SysCreateBy
     *
     * @return the value of sys_menu.SysCreateBy
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public String getSyscreateby() {
        return syscreateby;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.SysCreateBy
     *
     * @param syscreateby the value for sys_menu.SysCreateBy
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public void setSyscreateby(String syscreateby) {
        this.syscreateby = syscreateby == null ? null : syscreateby.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.SysUpdateDate
     *
     * @return the value of sys_menu.SysUpdateDate
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public Date getSysupdatedate() {
        return sysupdatedate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.SysUpdateDate
     *
     * @param sysupdatedate the value for sys_menu.SysUpdateDate
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public void setSysupdatedate(Date sysupdatedate) {
        this.sysupdatedate = sysupdatedate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.SysUpdateBy
     *
     * @return the value of sys_menu.SysUpdateBy
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public String getSysupdateby() {
        return sysupdateby;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.SysUpdateBy
     *
     * @param sysupdateby the value for sys_menu.SysUpdateBy
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public void setSysupdateby(String sysupdateby) {
        this.sysupdateby = sysupdateby == null ? null : sysupdateby.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.VersionNum
     *
     * @return the value of sys_menu.VersionNum
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public Integer getVersionnum() {
        return versionnum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.VersionNum
     *
     * @param versionnum the value for sys_menu.VersionNum
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public void setVersionnum(Integer versionnum) {
        this.versionnum = versionnum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.SysDelFlag
     *
     * @return the value of sys_menu.SysDelFlag
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public String getSysdelflag() {
        return sysdelflag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.SysDelFlag
     *
     * @param sysdelflag the value for sys_menu.SysDelFlag
     *
     * @mbggenerated Tue Dec 18 11:46:00 CST 2018
     */
    public void setSysdelflag(String sysdelflag) {
        this.sysdelflag = sysdelflag == null ? null : sysdelflag.trim();
    }
}