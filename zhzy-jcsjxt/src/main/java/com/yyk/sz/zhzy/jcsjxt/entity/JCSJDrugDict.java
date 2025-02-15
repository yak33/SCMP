package com.yyk.sz.zhzy.jcsjxt.entity;

import java.math.BigDecimal;
import java.util.Date;

public class JCSJDrugDict {

    private Integer drugcode;
    private String uuid;
    private String drugname;
    private String drugname2;
    private String salesguige;
    private Integer units;
    private String drugdosagecode;
    private BigDecimal doseperunit;
    private String doseunits;
    private Integer drugmodelcode;
    private String inputcode;
    private String drugtypecode;
    private String packageunits;
    private BigDecimal druglow;
    private BigDecimal drughigh;
    private BigDecimal drughanliang;
    private String drughanliangunit;
    private String othername;
    private String drugsource;
    private String drugprocess;
    private String drugtaste;
    private String drugmeridian;
    private String drugyinmeridian;
    private String drugfunction;
    private String drugattend;
    private String usage;
    private String specialusage;
    private String matterattend;
    private String drugstorage;
    private BigDecimal lprice;
    private String hiscorrecode;
    private String remark;
    private BigDecimal upperlimit;
    private BigDecimal lowerlimit;
    private Integer meridianorder;
    private Integer ptype;
    private BigDecimal pointx;
    private BigDecimal pointy;
    private String positionexplain;
    private Integer drugflag;
    private Boolean stopflag;
    private Integer drugwaycode;
    private Integer dosagecode;
    private BigDecimal measurementcoefficient;
    private Integer prescriptionunit;
    private BigDecimal singlemeasure;
    private Integer singlemeasureunit;

    private String drugwayname;
    private String dosagename;
    private String prescriptionunitname;
    private String singlemeasureunitname;
    private String drugmodelname;
    private String unitname;
    private String meridiancode;//归经编码

    private String billCode;
    private String dateString;
    private String itemCode;
    private int option;
    private String voucherCode;
    private  String v_GetBillCode;
    private  int v_GetBillID;
    private String proUUID;

    public String getMeridiancode() {
        return meridiancode;
    }

    public void setMeridiancode(String meridiancode) {
        this.meridiancode = meridiancode;
    }

    public String getProUUID() {
        return proUUID;
    }

    public void setProUUID(String proUUID) {
        this.proUUID = proUUID;
    }

    public String getV_GetBillCode() {
        return v_GetBillCode;
    }

    public void setV_GetBillCode(String v_GetBillCode) {
        this.v_GetBillCode = v_GetBillCode;
    }

    public int getV_GetBillID() {
        return v_GetBillID;
    }

    public void setV_GetBillID(int v_GetBillID) {
        this.v_GetBillID = v_GetBillID;
    }

    public String getDrugname2() {
        return drugname2;
    }

    public void setDrugname2(String drugname2) {
        this.drugname2 = drugname2;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }

    public String getVoucherCode() {
        return voucherCode;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }

    public String getDrugwayname() {
        return drugwayname;
    }

    public void setDrugwayname(String drugwayname) {
        this.drugwayname = drugwayname;
    }

    public String getDosagename() {
        return dosagename;
    }

    public void setDosagename(String dosagename) {
        this.dosagename = dosagename;
    }

    public String getPrescriptionunitname() {
        return prescriptionunitname;
    }

    public void setPrescriptionunitname(String prescriptionunitname) {
        this.prescriptionunitname = prescriptionunitname;
    }

    public String getSinglemeasureunitname() {
        return singlemeasureunitname;
    }

    public void setSinglemeasureunitname(String singlemeasureunitname) {
        this.singlemeasureunitname = singlemeasureunitname;
    }

    public String getDrugmodelname() {
        return drugmodelname;
    }

    public void setDrugmodelname(String drugmodelname) {
        this.drugmodelname = drugmodelname;
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Gy_DrugDict
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public JCSJDrugDict() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.DrugCode
     *
     * @return the value of Gy_DrugDict.DrugCode
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public Integer getDrugcode() {
        return drugcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.DrugCode
     *
     * @param drugcode the value for Gy_DrugDict.DrugCode
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setDrugcode(Integer drugcode) {
        this.drugcode = drugcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.UUID
     *
     * @return the value of Gy_DrugDict.UUID
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.UUID
     *
     * @param uuid the value for Gy_DrugDict.UUID
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.DrugName
     *
     * @return the value of Gy_DrugDict.DrugName
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public String getDrugname() {
        return drugname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.DrugName
     *
     * @param drugname the value for Gy_DrugDict.DrugName
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setDrugname(String drugname) {
        this.drugname = drugname == null ? null : drugname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.SalesGuige
     *
     * @return the value of Gy_DrugDict.SalesGuige
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public String getSalesguige() {
        return salesguige;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.SalesGuige
     *
     * @param salesguige the value for Gy_DrugDict.SalesGuige
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setSalesguige(String salesguige) {
        this.salesguige = salesguige == null ? null : salesguige.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.Units
     *
     * @return the value of Gy_DrugDict.Units
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public Integer getUnits() {
        return units;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.Units
     *
     * @param units the value for Gy_DrugDict.Units
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setUnits(Integer units) {
        this.units = units;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.DrugDosageCode
     *
     * @return the value of Gy_DrugDict.DrugDosageCode
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public String getDrugdosagecode() {
        return drugdosagecode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.DrugDosageCode
     *
     * @param drugdosagecode the value for Gy_DrugDict.DrugDosageCode
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setDrugdosagecode(String drugdosagecode) {
        this.drugdosagecode = drugdosagecode == null ? null : drugdosagecode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.DosePerUnit
     *
     * @return the value of Gy_DrugDict.DosePerUnit
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public BigDecimal getDoseperunit() {
        return doseperunit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.DosePerUnit
     *
     * @param doseperunit the value for Gy_DrugDict.DosePerUnit
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setDoseperunit(BigDecimal doseperunit) {
        this.doseperunit = doseperunit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.DoseUnits
     *
     * @return the value of Gy_DrugDict.DoseUnits
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public String getDoseunits() {
        return doseunits;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.DoseUnits
     *
     * @param doseunits the value for Gy_DrugDict.DoseUnits
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setDoseunits(String doseunits) {
        this.doseunits = doseunits == null ? null : doseunits.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.DrugModelCode
     *
     * @return the value of Gy_DrugDict.DrugModelCode
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public Integer getDrugmodelcode() {
        return drugmodelcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.DrugModelCode
     *
     * @param drugmodelcode the value for Gy_DrugDict.DrugModelCode
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setDrugmodelcode(Integer drugmodelcode) {
        this.drugmodelcode = drugmodelcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.InputCode
     *
     * @return the value of Gy_DrugDict.InputCode
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public String getInputcode() {
        return inputcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.InputCode
     *
     * @param inputcode the value for Gy_DrugDict.InputCode
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setInputcode(String inputcode) {
        this.inputcode = inputcode == null ? null : inputcode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.DrugTypeCode
     *
     * @return the value of Gy_DrugDict.DrugTypeCode
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public String getDrugtypecode() {
        return drugtypecode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.DrugTypeCode
     *
     * @param drugtypecode the value for Gy_DrugDict.DrugTypeCode
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setDrugtypecode(String drugtypecode) {
        this.drugtypecode = drugtypecode == null ? null : drugtypecode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.PackageUnits
     *
     * @return the value of Gy_DrugDict.PackageUnits
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public String getPackageunits() {
        return packageunits;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.PackageUnits
     *
     * @param packageunits the value for Gy_DrugDict.PackageUnits
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setPackageunits(String packageunits) {
        this.packageunits = packageunits == null ? null : packageunits.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.DrugLow
     *
     * @return the value of Gy_DrugDict.DrugLow
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public BigDecimal getDruglow() {
        return druglow;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.DrugLow
     *
     * @param druglow the value for Gy_DrugDict.DrugLow
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setDruglow(BigDecimal druglow) {
        this.druglow = druglow;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.DrugHigh
     *
     * @return the value of Gy_DrugDict.DrugHigh
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public BigDecimal getDrughigh() {
        return drughigh;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.DrugHigh
     *
     * @param drughigh the value for Gy_DrugDict.DrugHigh
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setDrughigh(BigDecimal drughigh) {
        this.drughigh = drughigh;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.DrugHanLiang
     *
     * @return the value of Gy_DrugDict.DrugHanLiang
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public BigDecimal getDrughanliang() {
        return drughanliang;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.DrugHanLiang
     *
     * @param drughanliang the value for Gy_DrugDict.DrugHanLiang
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setDrughanliang(BigDecimal drughanliang) {
        this.drughanliang = drughanliang;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.DrugHanLiangUnit
     *
     * @return the value of Gy_DrugDict.DrugHanLiangUnit
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public String getDrughanliangunit() {
        return drughanliangunit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.DrugHanLiangUnit
     *
     * @param drughanliangunit the value for Gy_DrugDict.DrugHanLiangUnit
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setDrughanliangunit(String drughanliangunit) {
        this.drughanliangunit = drughanliangunit == null ? null : drughanliangunit.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.OtherName
     *
     * @return the value of Gy_DrugDict.OtherName
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public String getOthername() {
        return othername;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.OtherName
     *
     * @param othername the value for Gy_DrugDict.OtherName
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setOthername(String othername) {
        this.othername = othername == null ? null : othername.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.DrugSource
     *
     * @return the value of Gy_DrugDict.DrugSource
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public String getDrugsource() {
        return drugsource;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.DrugSource
     *
     * @param drugsource the value for Gy_DrugDict.DrugSource
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setDrugsource(String drugsource) {
        this.drugsource = drugsource == null ? null : drugsource.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.DrugProcess
     *
     * @return the value of Gy_DrugDict.DrugProcess
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public String getDrugprocess() {
        return drugprocess;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.DrugProcess
     *
     * @param drugprocess the value for Gy_DrugDict.DrugProcess
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setDrugprocess(String drugprocess) {
        this.drugprocess = drugprocess == null ? null : drugprocess.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.DrugTaste
     *
     * @return the value of Gy_DrugDict.DrugTaste
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public String getDrugtaste() {
        return drugtaste;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.DrugTaste
     *
     * @param drugtaste the value for Gy_DrugDict.DrugTaste
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setDrugtaste(String drugtaste) {
        this.drugtaste = drugtaste == null ? null : drugtaste.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.DrugMeridian
     *
     * @return the value of Gy_DrugDict.DrugMeridian
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public String getDrugmeridian() {
        return drugmeridian;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.DrugMeridian
     *
     * @param drugmeridian the value for Gy_DrugDict.DrugMeridian
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setDrugmeridian(String drugmeridian) {
        this.drugmeridian = drugmeridian == null ? null : drugmeridian.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.DrugYinMeridian
     *
     * @return the value of Gy_DrugDict.DrugYinMeridian
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public String getDrugyinmeridian() {
        return drugyinmeridian;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.DrugYinMeridian
     *
     * @param drugyinmeridian the value for Gy_DrugDict.DrugYinMeridian
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setDrugyinmeridian(String drugyinmeridian) {
        this.drugyinmeridian = drugyinmeridian == null ? null : drugyinmeridian.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.DrugFunction
     *
     * @return the value of Gy_DrugDict.DrugFunction
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public String getDrugfunction() {
        return drugfunction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.DrugFunction
     *
     * @param drugfunction the value for Gy_DrugDict.DrugFunction
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setDrugfunction(String drugfunction) {
        this.drugfunction = drugfunction == null ? null : drugfunction.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.DrugAttend
     *
     * @return the value of Gy_DrugDict.DrugAttend
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public String getDrugattend() {
        return drugattend;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.DrugAttend
     *
     * @param drugattend the value for Gy_DrugDict.DrugAttend
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setDrugattend(String drugattend) {
        this.drugattend = drugattend == null ? null : drugattend.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.Usage
     *
     * @return the value of Gy_DrugDict.Usage
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public String getUsage() {
        return usage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.Usage
     *
     * @param usage the value for Gy_DrugDict.Usage
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setUsage(String usage) {
        this.usage = usage == null ? null : usage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.SpecialUsage
     *
     * @return the value of Gy_DrugDict.SpecialUsage
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public String getSpecialusage() {
        return specialusage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.SpecialUsage
     *
     * @param specialusage the value for Gy_DrugDict.SpecialUsage
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setSpecialusage(String specialusage) {
        this.specialusage = specialusage == null ? null : specialusage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.MatterAttend
     *
     * @return the value of Gy_DrugDict.MatterAttend
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public String getMatterattend() {
        return matterattend;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.MatterAttend
     *
     * @param matterattend the value for Gy_DrugDict.MatterAttend
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setMatterattend(String matterattend) {
        this.matterattend = matterattend == null ? null : matterattend.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.DrugStorage
     *
     * @return the value of Gy_DrugDict.DrugStorage
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public String getDrugstorage() {
        return drugstorage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.DrugStorage
     *
     * @param drugstorage the value for Gy_DrugDict.DrugStorage
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setDrugstorage(String drugstorage) {
        this.drugstorage = drugstorage == null ? null : drugstorage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.LPrice
     *
     * @return the value of Gy_DrugDict.LPrice
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public BigDecimal getLprice() {
        return lprice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.LPrice
     *
     * @param lprice the value for Gy_DrugDict.LPrice
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setLprice(BigDecimal lprice) {
        this.lprice = lprice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.HISCorreCode
     *
     * @return the value of Gy_DrugDict.HISCorreCode
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public String getHiscorrecode() {
        return hiscorrecode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.HISCorreCode
     *
     * @param hiscorrecode the value for Gy_DrugDict.HISCorreCode
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setHiscorrecode(String hiscorrecode) {
        this.hiscorrecode = hiscorrecode == null ? null : hiscorrecode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.Remark
     *
     * @return the value of Gy_DrugDict.Remark
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.Remark
     *
     * @param remark the value for Gy_DrugDict.Remark
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.UpperLimit
     *
     * @return the value of Gy_DrugDict.UpperLimit
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public BigDecimal getUpperlimit() {
        return upperlimit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.UpperLimit
     *
     * @param upperlimit the value for Gy_DrugDict.UpperLimit
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setUpperlimit(BigDecimal upperlimit) {
        this.upperlimit = upperlimit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.LowerLimit
     *
     * @return the value of Gy_DrugDict.LowerLimit
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public BigDecimal getLowerlimit() {
        return lowerlimit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.LowerLimit
     *
     * @param lowerlimit the value for Gy_DrugDict.LowerLimit
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setLowerlimit(BigDecimal lowerlimit) {
        this.lowerlimit = lowerlimit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.MeridianOrder
     *
     * @return the value of Gy_DrugDict.MeridianOrder
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public Integer getMeridianorder() {
        return meridianorder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.MeridianOrder
     *
     * @param meridianorder the value for Gy_DrugDict.MeridianOrder
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setMeridianorder(Integer meridianorder) {
        this.meridianorder = meridianorder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.PType
     *
     * @return the value of Gy_DrugDict.PType
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public Integer getPtype() {
        return ptype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.PType
     *
     * @param ptype the value for Gy_DrugDict.PType
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setPtype(Integer ptype) {
        this.ptype = ptype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.PointX
     *
     * @return the value of Gy_DrugDict.PointX
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public BigDecimal getPointx() {
        return pointx;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.PointX
     *
     * @param pointx the value for Gy_DrugDict.PointX
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setPointx(BigDecimal pointx) {
        this.pointx = pointx;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.PointY
     *
     * @return the value of Gy_DrugDict.PointY
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public BigDecimal getPointy() {
        return pointy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.PointY
     *
     * @param pointy the value for Gy_DrugDict.PointY
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setPointy(BigDecimal pointy) {
        this.pointy = pointy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.PositionExplain
     *
     * @return the value of Gy_DrugDict.PositionExplain
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public String getPositionexplain() {
        return positionexplain;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.PositionExplain
     *
     * @param positionexplain the value for Gy_DrugDict.PositionExplain
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setPositionexplain(String positionexplain) {
        this.positionexplain = positionexplain == null ? null : positionexplain.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.DrugFlag
     *
     * @return the value of Gy_DrugDict.DrugFlag
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public Integer getDrugflag() {
        return drugflag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.DrugFlag
     *
     * @param drugflag the value for Gy_DrugDict.DrugFlag
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setDrugflag(Integer drugflag) {
        this.drugflag = drugflag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.StopFlag
     *
     * @return the value of Gy_DrugDict.StopFlag
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public Boolean getStopflag() {
        return stopflag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.StopFlag
     *
     * @param stopflag the value for Gy_DrugDict.StopFlag
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setStopflag(Boolean stopflag) {
        this.stopflag = stopflag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.DrugWayCode
     *
     * @return the value of Gy_DrugDict.DrugWayCode
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public Integer getDrugwaycode() {
        return drugwaycode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.DrugWayCode
     *
     * @param drugwaycode the value for Gy_DrugDict.DrugWayCode
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setDrugwaycode(Integer drugwaycode) {
        this.drugwaycode = drugwaycode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.DosageCode
     *
     * @return the value of Gy_DrugDict.DosageCode
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public Integer getDosagecode() {
        return dosagecode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.DosageCode
     *
     * @param dosagecode the value for Gy_DrugDict.DosageCode
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setDosagecode(Integer dosagecode) {
        this.dosagecode = dosagecode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.MeasurementCoefficient
     *
     * @return the value of Gy_DrugDict.MeasurementCoefficient
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public BigDecimal getMeasurementcoefficient() {
        return measurementcoefficient;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.MeasurementCoefficient
     *
     * @param measurementcoefficient the value for Gy_DrugDict.MeasurementCoefficient
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setMeasurementcoefficient(BigDecimal measurementcoefficient) {
        this.measurementcoefficient = measurementcoefficient;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.PrescriptionUnit
     *
     * @return the value of Gy_DrugDict.PrescriptionUnit
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public Integer getPrescriptionunit() {
        return prescriptionunit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.PrescriptionUnit
     *
     * @param prescriptionunit the value for Gy_DrugDict.PrescriptionUnit
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setPrescriptionunit(Integer prescriptionunit) {
        this.prescriptionunit = prescriptionunit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.SingleMeasure
     *
     * @return the value of Gy_DrugDict.SingleMeasure
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public BigDecimal getSinglemeasure() {
        return singlemeasure;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.SingleMeasure
     *
     * @param singlemeasure the value for Gy_DrugDict.SingleMeasure
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setSinglemeasure(BigDecimal singlemeasure) {
        this.singlemeasure = singlemeasure;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Gy_DrugDict.SingleMeasureUnit
     *
     * @return the value of Gy_DrugDict.SingleMeasureUnit
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public Integer getSinglemeasureunit() {
        return singlemeasureunit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Gy_DrugDict.SingleMeasureUnit
     *
     * @param singlemeasureunit the value for Gy_DrugDict.SingleMeasureUnit
     *
     * @mbggenerated Wed Dec 19 10:20:08 CST 2018
     */
    public void setSinglemeasureunit(Integer singlemeasureunit) {
        this.singlemeasureunit = singlemeasureunit;
    }

}