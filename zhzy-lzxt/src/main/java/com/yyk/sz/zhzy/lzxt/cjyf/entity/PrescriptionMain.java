package com.yyk.sz.zhzy.lzxt.cjyf.entity;

import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 方剂主表实体
 */
@ApiComment("方剂主表实体类")
public class PrescriptionMain extends BaseEntity {

    /**
     * 方剂编码
     */
    @ApiComment(value = "方剂编码", sample = "5211314")
    private String prescriptionCode;
    /**
     * 方剂名称
     */
    private String prescriptionName;
    /**
     * 拼音码
     */
    private String pinYinCode;
    /**
     * 功效
     */
    private String effect;
    /**
     * 主治
     */
    private String attend;
    /**
     * 方解
     */
    private String calcite;
    /**
     * 来源
     */
    private String source;
    /**
     * 君药比例
     */
    private BigDecimal jRate;
    /**
     * 臣药比例
     */
    private BigDecimal cRate;
    /**
     * 左药比例
     */
    private BigDecimal zRate;
    /**
     * 史药比例
     */
    private BigDecimal sRate;
    /**
     * 备注
     */
    private String remark;

    private boolean SysFlag;
    private String userCode;
    private Date makeDate;
    private String drugFlag;
    /**
     * 处方分类
     */
    private String pCCode;
    private String pCName;
    private boolean personalFlag;
    private String searchText;
    /**
     * 中药编码
     */
    private int drugCode;
    /**
     * 子表ID
     */
    private int prescriptionSubID;
    /**
     * 药量
     */
    private double quanitity;
    /**
     * 煎熬方法编码
     */
    private String sufferTypeCode;
    private String sufferTypeName;
    private String hisCode;
    /**
     * 君药
     */
    private boolean JFlag;
    /**
     * 臣药
     */
    private boolean CFlag;
    /**
     * 左药
     */
    private boolean ZFlag;
    /**
     * 史药
     */
    private boolean SFlag;
    private boolean mainFlag;
    /**
     * 方剂包含的草药list
     */
    private List<PrescriptionMain> subList;


    public String getSufferTypeName() {
        return sufferTypeName;
    }

    public void setSufferTypeName(String sufferTypeName) {
        this.sufferTypeName = sufferTypeName;
    }

    public String getHisCode() {
        return hisCode;
    }

    public void setHisCode(String hisCode) {
        this.hisCode = hisCode;
    }

    public String getpCName() {
        return pCName;
    }

    public void setpCName(String pCName) {
        this.pCName = pCName;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public List<PrescriptionMain> getSubList() {
        return subList;
    }

    public void setSubList(List<PrescriptionMain> subList) {
        this.subList = subList;
    }

    public int getDrugCode() {
        return drugCode;
    }

    public void setDrugCode(int drugCode) {
        this.drugCode = drugCode;
    }

    public int getPrescriptionSubID() {
        return prescriptionSubID;
    }

    public void setPrescriptionSubID(int prescriptionSubID) {
        this.prescriptionSubID = prescriptionSubID;
    }

    public double getQuanitity() {
        return quanitity;
    }

    public void setQuanitity(double quanitity) {
        this.quanitity = quanitity;
    }

    public String getSufferTypeCode() {
        return sufferTypeCode;
    }

    public void setSufferTypeCode(String sufferTypeCode) {
        this.sufferTypeCode = sufferTypeCode;
    }

    public boolean isJFlag() {
        return JFlag;
    }

    public void setJFlag(boolean JFlag) {
        this.JFlag = JFlag;
    }

    public boolean isCFlag() {
        return CFlag;
    }

    public void setCFlag(boolean CFlag) {
        this.CFlag = CFlag;
    }

    public boolean isZFlag() {
        return ZFlag;
    }

    public void setZFlag(boolean ZFlag) {
        this.ZFlag = ZFlag;
    }

    public boolean isSFlag() {
        return SFlag;
    }

    public void setSFlag(boolean SFlag) {
        this.SFlag = SFlag;
    }

    public boolean isMainFlag() {
        return mainFlag;
    }

    public void setMainFlag(boolean mainFlag) {
        this.mainFlag = mainFlag;
    }

    public String getPrescriptionCode() {
        return prescriptionCode;
    }

    public void setPrescriptionCode(String prescriptionCode) {
        this.prescriptionCode = prescriptionCode;
    }

    public String getPrescriptionName() {
        return prescriptionName;
    }

    public void setPrescriptionName(String prescriptionName) {
        this.prescriptionName = prescriptionName;
    }

    public String getPinYinCode() {
        return pinYinCode;
    }

    public void setPinYinCode(String pinYinCode) {
        this.pinYinCode = pinYinCode;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getAttend() {
        return attend;
    }

    public void setAttend(String attend) {
        this.attend = attend;
    }

    public String getCalcite() {
        return calcite;
    }

    public void setCalcite(String calcite) {
        this.calcite = calcite;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getMakeDate() {
        return makeDate;
    }

    public void setMakeDate(Date makeDate) {
        this.makeDate = makeDate;
    }

    public String getDrugFlag() {
        return drugFlag;
    }

    public void setDrugFlag(String drugFlag) {
        this.drugFlag = drugFlag;
    }

    public boolean isSysFlag() {
        return SysFlag;
    }

    public void setSysFlag(boolean sysFlag) {
        SysFlag = sysFlag;
    }

    public boolean isPersonalFlag() {
        return personalFlag;
    }

    public void setPersonalFlag(boolean personalFlag) {
        this.personalFlag = personalFlag;
    }

    public BigDecimal getjRate() {
        return jRate;
    }

    public void setjRate(BigDecimal jRate) {
        this.jRate = jRate;
    }

    public BigDecimal getcRate() {
        return cRate;
    }

    public void setcRate(BigDecimal cRate) {
        this.cRate = cRate;
    }

    public BigDecimal getzRate() {
        return zRate;
    }

    public void setzRate(BigDecimal zRate) {
        this.zRate = zRate;
    }

    public BigDecimal getsRate() {
        return sRate;
    }

    public void setsRate(BigDecimal sRate) {
        this.sRate = sRate;
    }

    public String getpCCode() {
        return pCCode;
    }

    public void setpCCode(String pCCode) {
        this.pCCode = pCCode;
    }
}
