package com.yyk.sz.zhzy.jcsjxt.entity;

public class JCSJDeptMent {

    private String deptcode;

    private String uuid;

    private String deptname;
    private String deptname2;

    private String remark;

    private String mainsymptomcode;
    private String mainsymptomname;

    public String getMainsymptomname() {
        return mainsymptomname;
    }

    public void setMainsymptomname(String mainsymptomname) {
        this.mainsymptomname = mainsymptomname;
    }

    public String getMainsymptomcode() {
        return mainsymptomcode;
    }

    public void setMainsymptomcode(String mainsymptomcode) {
        this.mainsymptomcode = mainsymptomcode;
    }

    public String getDeptname2() {
        return deptname2;
    }

    public void setDeptname2(String deptname2) {
        this.deptname2 = deptname2;
    }

    public String getDeptcode() {
        return deptcode;
    }

    public void setDeptcode(String deptcode) {
        this.deptcode = deptcode == null ? null : deptcode.trim();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname == null ? null : deptname.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}