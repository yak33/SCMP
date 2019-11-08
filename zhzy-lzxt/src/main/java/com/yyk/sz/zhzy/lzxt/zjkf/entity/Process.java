package com.yyk.sz.zhzy.lzxt.zjkf.entity;

import com.yyk.sz.common.base.domain.BaseEntity;

/**
 * 炮制方法
 */
public class Process extends BaseEntity {
    /**
     * 中药编码
     */
    private String DrugCode;
    /**
     *炮制编码
     */
    private String ProcessCode;
    /**
     *炮制名称
     */
    private String ProcessName;

    public String getDrugCode() {
        return DrugCode;
    }

    public void setDrugCode(String drugCode) {
        DrugCode = drugCode;
    }

    public String getProcessCode() {
        return ProcessCode;
    }

    public void setProcessCode(String processCode) {
        ProcessCode = processCode;
    }

    public String getProcessName() {
        return ProcessName;
    }

    public void setProcessName(String processName) {
        ProcessName = processName;
    }
}
