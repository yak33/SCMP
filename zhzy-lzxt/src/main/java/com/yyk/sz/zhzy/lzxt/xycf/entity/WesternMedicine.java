package com.yyk.sz.zhzy.lzxt.xycf.entity;

import com.yyk.sz.common.base.domain.BaseEntity;

/**
 * 西药信息
 */
public class WesternMedicine extends BaseEntity {

    //药品编码
    private String DrugCode;
    //药品名称
    private String DrugName;
    //药品规格
    private String PackageUnits;
    //单计量
    private double SingleMeasure;
    //单计量单位
    private String SingleMeasureUnit;
    //单计量单位名称
    private String SingleMeasureUnitName;
    //用药方式编码
    private String DrugWayCode;
    //计量单位名称
    private String TotalAmountUnitName;
    //处方单位
    private String PrescriptionUnit;
    //处方单位名称
    private String PrescriptionUnitName;
    //零售价
    private double LPrice;
    //计量系数
    private double Coefficient;
    //用药时长
    private double UseDays;
    //计量系数
    private double MeasurementCoefficient;

    public String getDrugCode() {
        return DrugCode;
    }

    public void setDrugCode(String drugCode) {
        DrugCode = drugCode;
    }

    public String getDrugName() {
        return DrugName;
    }

    public void setDrugName(String drugName) {
        DrugName = drugName;
    }

    public String getPackageUnits() {
        return PackageUnits;
    }

    public void setPackageUnits(String packageUnits) {
        PackageUnits = packageUnits;
    }

    public double getSingleMeasure() {
        return SingleMeasure;
    }

    public void setSingleMeasure(double singleMeasure) {
        SingleMeasure = singleMeasure;
    }

    public String getSingleMeasureUnit() {
        return SingleMeasureUnit;
    }

    public void setSingleMeasureUnit(String singleMeasureUnit) {
        SingleMeasureUnit = singleMeasureUnit;
    }

    public String getSingleMeasureUnitName() {
        return SingleMeasureUnitName;
    }

    public void setSingleMeasureUnitName(String singleMeasureUnitName) {
        SingleMeasureUnitName = singleMeasureUnitName;
    }

    public String getDrugWayCode() {
        return DrugWayCode;
    }

    public void setDrugWayCode(String drugWayCode) {
        DrugWayCode = drugWayCode;
    }

    public String getTotalAmountUnitName() {
        return TotalAmountUnitName;
    }

    public void setTotalAmountUnitName(String totalAmountUnitName) {
        TotalAmountUnitName = totalAmountUnitName;
    }

    public String getPrescriptionUnit() {
        return PrescriptionUnit;
    }

    public void setPrescriptionUnit(String prescriptionUnit) {
        PrescriptionUnit = prescriptionUnit;
    }

    public String getPrescriptionUnitName() {
        return PrescriptionUnitName;
    }

    public void setPrescriptionUnitName(String prescriptionUnitName) {
        PrescriptionUnitName = prescriptionUnitName;
    }

    public double getLPrice() {
        return LPrice;
    }

    public void setLPrice(double LPrice) {
        this.LPrice = LPrice;
    }

    public double getCoefficient() {
        return Coefficient;
    }

    public void setCoefficient(double coefficient) {
        Coefficient = coefficient;
    }

    public double getUseDays() {
        return UseDays;
    }

    public void setUseDays(double useDays) {
        UseDays = useDays;
    }

    public double getMeasurementCoefficient() {
        return MeasurementCoefficient;
    }

    public void setMeasurementCoefficient(double measurementCoefficient) {
        MeasurementCoefficient = measurementCoefficient;
    }
}

