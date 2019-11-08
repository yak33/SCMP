package com.yyk.sz.zhzy.lzxt.blmb.entity;

import com.yyk.sz.common.base.domain.BaseEntity;


public class Model extends BaseEntity {

    /**
     * 模版类型
     */
    private int UsedPhrasesType;

    /**
     * 模版类型名称
     */
    private String UsedPhrasesName;

    /**
     * 拼音码
     */
    private String PinYinCode;

    /**
     * 模版内容
     */
    private String UsedPhrasesContent;

    /**
     * 备注
     */
    private String RemarkSub;

    /**
     * 科室编号
     */
    private String DeptCode;

    public int getUsedPhrasesType() {
        return UsedPhrasesType;
    }

    public void setUsedPhrasesType(int usedPhrasesType) {
        UsedPhrasesType = usedPhrasesType;
    }

    public String getUsedPhrasesName() {
        return UsedPhrasesName;
    }

    public void setUsedPhrasesName(String usedPhrasesName) {
        UsedPhrasesName = usedPhrasesName;
    }

    public String getPinYinCode() {
        return PinYinCode;
    }

    public void setPinYinCode(String pinYinCode) {
        PinYinCode = pinYinCode;
    }

    public String getUsedPhrasesContent() {
        return UsedPhrasesContent;
    }

    public void setUsedPhrasesContent(String usedPhrasesContent) {
        UsedPhrasesContent = usedPhrasesContent;
    }

    public String getRemarkSub() {
        return RemarkSub;
    }

    public void setRemarkSub(String remarkSub) {
        RemarkSub = remarkSub;
    }

    public String getDeptCode() {
        return DeptCode;
    }

    public void setDeptCode(String deptCode) {
        DeptCode = deptCode;
    }
}
