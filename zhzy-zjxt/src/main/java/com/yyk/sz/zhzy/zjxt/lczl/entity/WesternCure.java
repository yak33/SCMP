package com.yyk.sz.zhzy.zjxt.lczl.entity;

import com.yyk.sz.common.base.domain.BaseEntity;

import java.util.List;

/**
 * 临床治疗
 */
public class WesternCure extends BaseEntity {

    private String detailItemCode;
    private String detailItemName;
    private String pinYinCode;
    private String summaryCode;
    private String summaryName;
    private String remark;
    private String HISDetailItemCode;
    private Integer detailItemFlag;
    private double price;

    private Integer empBasicMainID;
    private Integer fangJiSubID;
    private String fangJiSubCode;
    private String fangJiSubName;
    private String sysupdatedate;

    List<WesternCure> getDetailList;


    public List<WesternCure> getGetDetailList() {
        return getDetailList;
    }

    public void setGetDetailList(List<WesternCure> getDetailList) {
        this.getDetailList = getDetailList;
    }

    public String getSysupdatedate() {
        return sysupdatedate;
    }

    public void setSysupdatedate(String sysupdatedate) {
        this.sysupdatedate = sysupdatedate;
    }

    public Integer getFangJiSubID() {
        return fangJiSubID;
    }

    public void setFangJiSubID(Integer fangJiSubID) {
        this.fangJiSubID = fangJiSubID;
    }

    public Integer getEmpBasicMainID() {
        return empBasicMainID;
    }

    public void setEmpBasicMainID(Integer empBasicMainID) {
        this.empBasicMainID = empBasicMainID;
    }

    public String getFangJiSubCode() {
        return fangJiSubCode;
    }

    public void setFangJiSubCode(String fangJiSubCode) {
        this.fangJiSubCode = fangJiSubCode;
    }

    public String getFangJiSubName() {
        return fangJiSubName;
    }

    public void setFangJiSubName(String fangJiSubName) {
        this.fangJiSubName = fangJiSubName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDetailItemCode() {
        return detailItemCode;
    }

    public void setDetailItemCode(String detailItemCode) {
        this.detailItemCode = detailItemCode;
    }

    public String getDetailItemName() {
        return detailItemName;
    }

    public void setDetailItemName(String detailItemName) {
        this.detailItemName = detailItemName;
    }

    public String getPinYinCode() {
        return pinYinCode;
    }

    public void setPinYinCode(String pinYinCode) {
        this.pinYinCode = pinYinCode;
    }

    public String getSummaryCode() {
        return summaryCode;
    }

    public void setSummaryCode(String summaryCode) {
        this.summaryCode = summaryCode;
    }

    public String getSummaryName() {
        return summaryName;
    }

    public void setSummaryName(String summaryName) {
        this.summaryName = summaryName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getHISDetailItemCode() {
        return HISDetailItemCode;
    }

    public void setHISDetailItemCode(String HISDetailItemCode) {
        this.HISDetailItemCode = HISDetailItemCode;
    }

    public Integer getDetailItemFlag() {
        return detailItemFlag;
    }

    public void setDetailItemFlag(Integer detailItemFlag) {
        this.detailItemFlag = detailItemFlag;
    }
}
