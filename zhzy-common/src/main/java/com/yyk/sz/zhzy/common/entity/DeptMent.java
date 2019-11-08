package com.yyk.sz.zhzy.common.entity;

import com.yyk.sz.common.base.domain.BaseEntity;


public class DeptMent extends BaseEntity {

    /**
     * 科室编码
     */
    private String DeptCode;

    /**
     * 科室名称
     */
    private String DeptName;

    public String getDeptCode() {
        return DeptCode;
    }

    public void setDeptCode(String deptCode) {
        DeptCode = deptCode;
    }

    public String getDeptName() {
        return DeptName;
    }

    public void setDeptName(String deptName) {
        DeptName = deptName;
    }
}
