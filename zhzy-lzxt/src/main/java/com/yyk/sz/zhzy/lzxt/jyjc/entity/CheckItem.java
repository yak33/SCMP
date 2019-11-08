package com.yyk.sz.zhzy.lzxt.jyjc.entity;

import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.List;

/**
 * 检验检查
 * @Author: ZhangChao
 * @Date: 2018-11-14 9:55
 */
public class CheckItem extends BaseEntity {
    @ApiComment(value = "门诊病人ID", sample = "11886")
    private int empBasicMainID;
    @ApiComment(value = "类型标记，0检查1检验", sample = "0")
    private int checkFlag;
    @ApiComment(value = "主项目编号", sample = "H0001")
    private String summaryCode;
    @ApiComment(value = "检验检查标记", sample = "0")
    private int detailItemFlag;
    private String summaryName;
    private String pinYinCode;
    private String detailItemCode;
    private String detailItemName;
    private BigDecimal price;
    private String clinicalRemark; //临床备注
    private String linRemark; //门诊备注
    private List<CheckItem> checkItemList;

    public List<CheckItem> getCheckItemList() {
        return checkItemList;
    }

    public void setCheckItemList(List<CheckItem> checkItemList) {
        this.checkItemList = checkItemList;
    }
    public int getCheckFlag() {
        return checkFlag;
    }

    public void setCheckFlag(int checkFlag) {
        this.checkFlag = checkFlag;
    }

    public int getEmpBasicMainID() {
        return empBasicMainID;
    }

    public void setEmpBasicMainID(int empBasicMainID) {
        this.empBasicMainID = empBasicMainID;
    }

    public String getSummaryCode() {
        return summaryCode;
    }

    public void setSummaryCode(String summaryCode) {
        this.summaryCode = summaryCode;
    }

    public String getClinicalRemark() {
        return clinicalRemark;
    }

    public void setClinicalRemark(String clinicalRemark) {
        this.clinicalRemark = clinicalRemark;
    }

    public String getLinRemark() {
        return linRemark;
    }

    public void setLinRemark(String linRemark) {
        this.linRemark = linRemark;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getDetailItemFlag() {
        return detailItemFlag;
    }

    public void setDetailItemFlag(int detailItemFlag) {
        this.detailItemFlag = detailItemFlag;
    }

    public String getSummaryName() {
        return summaryName;
    }

    public void setSummaryName(String summaryName) {
        this.summaryName = summaryName;
    }

    public String getPinYinCode() {
        return pinYinCode;
    }

    public void setPinYinCode(String pinYinCode) {
        this.pinYinCode = pinYinCode;
    }
}
