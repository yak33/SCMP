package com.yyk.sz.zhzy.lzxt.jyjc.entity;

import java.math.BigDecimal;
import java.util.Date;

public class SysInventory {
    private Integer drugcode;

    private String uuid;

    private String drugname;

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

    private String remark;

    private BigDecimal upperlimit;

    private BigDecimal lowerlimit;

    private Integer drugflag;

    private Boolean stopflag;
    /**
     * 入库量
     */
    private BigDecimal intoamount;
    /**
     * 剩余库存
     */
    private BigDecimal remainamount;

    private BigDecimal totalamount;
    /**
     * 预警值
     */
    private BigDecimal warningamount;

    private Integer drugwaycode;

    private Integer dosagecode;

    private BigDecimal measurementcoefficient;

    private Integer prescriptionunit;

    private String prescriptionunitname;

    private BigDecimal singlemeasure;

    private Integer singlemeasureunit;

    private Date syscreatedate;

    private String syscreateby;

    private Date sysupdatedate;

    private String sysupdateby;

    private Integer versionnum;

    private String sysdelflag;

    public String getPrescriptionunitname() {
        return prescriptionunitname;
    }

    public void setPrescriptionunitname(String prescriptionunitname) {
        this.prescriptionunitname = prescriptionunitname;
    }

    public BigDecimal getWarningamount() {
        return warningamount;
    }

    public void setWarningamount(BigDecimal warningamount) {
        this.warningamount = warningamount;
    }

    public Integer getDrugcode() {
        return drugcode;
    }

    public void setDrugcode(Integer drugcode) {
        this.drugcode = drugcode;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getDrugname() {
        return drugname;
    }

    public void setDrugname(String drugname) {
        this.drugname = drugname == null ? null : drugname.trim();
    }

    public String getSalesguige() {
        return salesguige;
    }

    public void setSalesguige(String salesguige) {
        this.salesguige = salesguige == null ? null : salesguige.trim();
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }

    public String getDrugdosagecode() {
        return drugdosagecode;
    }

    public void setDrugdosagecode(String drugdosagecode) {
        this.drugdosagecode = drugdosagecode == null ? null : drugdosagecode.trim();
    }

    public BigDecimal getDoseperunit() {
        return doseperunit;
    }

    public void setDoseperunit(BigDecimal doseperunit) {
        this.doseperunit = doseperunit;
    }

    public String getDoseunits() {
        return doseunits;
    }

    public void setDoseunits(String doseunits) {
        this.doseunits = doseunits == null ? null : doseunits.trim();
    }

    public Integer getDrugmodelcode() {
        return drugmodelcode;
    }

    public void setDrugmodelcode(Integer drugmodelcode) {
        this.drugmodelcode = drugmodelcode;
    }

    public String getInputcode() {
        return inputcode;
    }

    public void setInputcode(String inputcode) {
        this.inputcode = inputcode == null ? null : inputcode.trim();
    }

    public String getDrugtypecode() {
        return drugtypecode;
    }

    public void setDrugtypecode(String drugtypecode) {
        this.drugtypecode = drugtypecode == null ? null : drugtypecode.trim();
    }

    public String getPackageunits() {
        return packageunits;
    }

    public void setPackageunits(String packageunits) {
        this.packageunits = packageunits == null ? null : packageunits.trim();
    }

    public BigDecimal getDruglow() {
        return druglow;
    }

    public void setDruglow(BigDecimal druglow) {
        this.druglow = druglow;
    }

    public BigDecimal getDrughigh() {
        return drughigh;
    }

    public void setDrughigh(BigDecimal drughigh) {
        this.drughigh = drughigh;
    }

    public BigDecimal getDrughanliang() {
        return drughanliang;
    }

    public void setDrughanliang(BigDecimal drughanliang) {
        this.drughanliang = drughanliang;
    }

    public String getDrughanliangunit() {
        return drughanliangunit;
    }

    public void setDrughanliangunit(String drughanliangunit) {
        this.drughanliangunit = drughanliangunit == null ? null : drughanliangunit.trim();
    }

    public String getOthername() {
        return othername;
    }

    public void setOthername(String othername) {
        this.othername = othername == null ? null : othername.trim();
    }

    public String getDrugsource() {
        return drugsource;
    }

    public void setDrugsource(String drugsource) {
        this.drugsource = drugsource == null ? null : drugsource.trim();
    }

    public String getDrugprocess() {
        return drugprocess;
    }

    public void setDrugprocess(String drugprocess) {
        this.drugprocess = drugprocess == null ? null : drugprocess.trim();
    }

    public String getDrugtaste() {
        return drugtaste;
    }

    public void setDrugtaste(String drugtaste) {
        this.drugtaste = drugtaste == null ? null : drugtaste.trim();
    }

    public String getDrugmeridian() {
        return drugmeridian;
    }

    public void setDrugmeridian(String drugmeridian) {
        this.drugmeridian = drugmeridian == null ? null : drugmeridian.trim();
    }

    public String getDrugyinmeridian() {
        return drugyinmeridian;
    }

    public void setDrugyinmeridian(String drugyinmeridian) {
        this.drugyinmeridian = drugyinmeridian == null ? null : drugyinmeridian.trim();
    }

    public String getDrugfunction() {
        return drugfunction;
    }

    public void setDrugfunction(String drugfunction) {
        this.drugfunction = drugfunction == null ? null : drugfunction.trim();
    }

    public String getDrugattend() {
        return drugattend;
    }

    public void setDrugattend(String drugattend) {
        this.drugattend = drugattend == null ? null : drugattend.trim();
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage == null ? null : usage.trim();
    }

    public String getSpecialusage() {
        return specialusage;
    }

    public void setSpecialusage(String specialusage) {
        this.specialusage = specialusage == null ? null : specialusage.trim();
    }

    public String getMatterattend() {
        return matterattend;
    }

    public void setMatterattend(String matterattend) {
        this.matterattend = matterattend == null ? null : matterattend.trim();
    }

    public String getDrugstorage() {
        return drugstorage;
    }

    public void setDrugstorage(String drugstorage) {
        this.drugstorage = drugstorage == null ? null : drugstorage.trim();
    }

    public BigDecimal getLprice() {
        return lprice;
    }

    public void setLprice(BigDecimal lprice) {
        this.lprice = lprice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public BigDecimal getUpperlimit() {
        return upperlimit;
    }

    public void setUpperlimit(BigDecimal upperlimit) {
        this.upperlimit = upperlimit;
    }

    public BigDecimal getLowerlimit() {
        return lowerlimit;
    }

    public void setLowerlimit(BigDecimal lowerlimit) {
        this.lowerlimit = lowerlimit;
    }

    public Integer getDrugflag() {
        return drugflag;
    }

    public void setDrugflag(Integer drugflag) {
        this.drugflag = drugflag;
    }

    public Boolean getStopflag() {
        return stopflag;
    }

    public void setStopflag(Boolean stopflag) {
        this.stopflag = stopflag;
    }

    public BigDecimal getIntoamount() {
        return intoamount;
    }

    public void setIntoamount(BigDecimal intoamount) {
        this.intoamount = intoamount;
    }

    public BigDecimal getRemainamount() {
        return remainamount;
    }

    public void setRemainamount(BigDecimal remainamount) {
        this.remainamount = remainamount;
    }

    public BigDecimal getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(BigDecimal totalamount) {
        this.totalamount = totalamount;
    }

    public Integer getDrugwaycode() {
        return drugwaycode;
    }

    public void setDrugwaycode(Integer drugwaycode) {
        this.drugwaycode = drugwaycode;
    }

    public Integer getDosagecode() {
        return dosagecode;
    }

    public void setDosagecode(Integer dosagecode) {
        this.dosagecode = dosagecode;
    }

    public BigDecimal getMeasurementcoefficient() {
        return measurementcoefficient;
    }

    public void setMeasurementcoefficient(BigDecimal measurementcoefficient) {
        this.measurementcoefficient = measurementcoefficient;
    }

    public Integer getPrescriptionunit() {
        return prescriptionunit;
    }

    public void setPrescriptionunit(Integer prescriptionunit) {
        this.prescriptionunit = prescriptionunit;
    }

    public BigDecimal getSinglemeasure() {
        return singlemeasure;
    }

    public void setSinglemeasure(BigDecimal singlemeasure) {
        this.singlemeasure = singlemeasure;
    }

    public Integer getSinglemeasureunit() {
        return singlemeasureunit;
    }

    public void setSinglemeasureunit(Integer singlemeasureunit) {
        this.singlemeasureunit = singlemeasureunit;
    }

    public Date getSyscreatedate() {
        return syscreatedate;
    }

    public void setSyscreatedate(Date syscreatedate) {
        this.syscreatedate = syscreatedate;
    }

    public String getSyscreateby() {
        return syscreateby;
    }

    public void setSyscreateby(String syscreateby) {
        this.syscreateby = syscreateby == null ? null : syscreateby.trim();
    }

    public Date getSysupdatedate() {
        return sysupdatedate;
    }

    public void setSysupdatedate(Date sysupdatedate) {
        this.sysupdatedate = sysupdatedate;
    }

    public String getSysupdateby() {
        return sysupdateby;
    }

    public void setSysupdateby(String sysupdateby) {
        this.sysupdateby = sysupdateby == null ? null : sysupdateby.trim();
    }

    public Integer getVersionnum() {
        return versionnum;
    }

    public void setVersionnum(Integer versionnum) {
        this.versionnum = versionnum;
    }

    public String getSysdelflag() {
        return sysdelflag;
    }

    public void setSysdelflag(String sysdelflag) {
        this.sysdelflag = sysdelflag == null ? null : sysdelflag.trim();
    }
}