package com.yyk.sz.zhzy.common.entity;

import com.yyk.sz.common.base.domain.BaseEntity;


public class Dictionary extends BaseEntity {

    /**
     * code
     */
    private String code;

    /**
     * value
     */
    private String value;

    /**
     * name
     */
    private String name;

    /**
     * type
     */
    private String type;

    /**
     * subType
     */
    private String subType;

    /**
     * 备注
     */
    private String note;

    /**
     * 上级字典项
     */
    private String parentCode;

    /**
     * 扩展信息1 - 6
     */
    private String info1;
    private String info2;
    private String info3;
    private String info4;
    private String info5;
    private String info6;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getInfo1() {
        return info1;
    }

    public void setInfo1(String info1) {
        this.info1 = info1;
    }

    public String getInfo2() {
        return info2;
    }

    public void setInfo2(String info2) {
        this.info2 = info2;
    }

    public String getInfo3() {
        return info3;
    }

    public void setInfo3(String info3) {
        this.info3 = info3;
    }

    public String getInfo4() {
        return info4;
    }

    public void setInfo4(String info4) {
        this.info4 = info4;
    }

    public String getInfo5() {
        return info5;
    }

    public void setInfo5(String info5) {
        this.info5 = info5;
    }

    public String getInfo6() {
        return info6;
    }

    public void setInfo6(String info6) {
        this.info6 = info6;
    }

}
