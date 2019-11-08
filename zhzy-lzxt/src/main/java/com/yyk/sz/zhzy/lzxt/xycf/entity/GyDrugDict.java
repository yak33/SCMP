package com.yyk.sz.zhzy.lzxt.xycf.entity;

import com.yyk.sz.common.base.domain.BaseEntity;

/**
 * 药品信息
 */
public class GyDrugDict extends BaseEntity {

    //药品编码
    private String DrugCode;
    //药品名称
    private String DrugName;
    //输入码
    private String InputCode;
    //类别编码
    private String DrugModelCode;
    //类别名称
    private String DrugModelName;

    private String FrequencyCode;
    private String FrequencyName;
    private String Coefficient;
    private String UseDays;
    private String TotalAmount;
    private String TotalAmountUnitName;
    private String Quanitity;
    private String WholeMoney;

    //别名
    private String OtherName;
    //计量单位编码
    private Gy_UnitEntity Units;
    //计量单位名称
    private Gy_UnitEntity UnitName;
    //零售价
    private double LPrice;
    //来源
    private String DrugSource;
    //炮制
    private String DrugProcess;
    //性味
    private String DrugTaste;
    //归经
    private String DrugMeridian;
    //引经
    private String DrugYinMeridian;
    //功能
    private String DrugFunction;
    //主治
    private String DrugAttend;
    //用法用量
    private String Usage;
    //特殊用法
    private String SpecialUsage;
    //注意事项
    private String MatterAttend;
    //贮藏
    private String DrugStorage;
    //HIS对应编码
    private String HISCorreCode;
    //备注
    private String Remark;
    //炮制、性味、归经
    private String DrugProcessChecked;
    //性味
    private String DrugTasteChecked;
    //归经
    private String DrugMeridianChecked;
    //引经
    private String DrugYinMeridianChecked;
    //药量上限
    private double UpperLimit;
    //药量下限
    private String LowerLimit;
    //是否停用（0,未停用；1停用）
    private boolean StopFlag;
    //药剂标示（0，中药；1，穴位；2，西药）
    private double DrugFlag;
    //服法编码
    private String DrugWayCode;
    //服法名称
    private String DrugWayName;
    //剂型编码
    private String DosageCode;
    //剂型名称
    private String DosageName;
    //计量系数
    private double MeasurementCoefficient;
    //处方单位
    private String PrescriptionUnit;
    //处方单位名称
    private String PrescriptionUnitName;
    //单计量
    private double SingleMeasure;
    //单计量单位
    private String SingleMeasureUnit;
    //单计量单位名称
    private String SingleMeasureUnitName;
    //药品规格
    private String PackageUnits;

    public String getCoefficient() {
        return Coefficient;
    }

    public void setCoefficient(String coefficient) {
        Coefficient = coefficient;
    }

    public String getUseDays() {
        return UseDays;
    }

    public String getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        TotalAmount = totalAmount;
    }

    public String getTotalAmountUnitName() {
        return TotalAmountUnitName;
    }

    public void setTotalAmountUnitName(String totalAmountUnitName) {
        TotalAmountUnitName = totalAmountUnitName;
    }

    public String getQuanitity() {
        return Quanitity;
    }

    public void setQuanitity(String quanitity) {
        Quanitity = quanitity;
    }

    public String getWholeMoney() {
        return WholeMoney;
    }

    public void setWholeMoney(String wholeMoney) {
        WholeMoney = wholeMoney;
    }

    public void setUseDays(String useDays) {
        UseDays = useDays;
    }

    public String getFrequencyCode() {
        return FrequencyCode;
    }

    public void setFrequencyCode(String frequencyCode) {
        FrequencyCode = frequencyCode;
    }

    public String getFrequencyName() {
        return FrequencyName;
    }

    public void setFrequencyName(String frequencyName) {
        FrequencyName = frequencyName;
    }

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

    public String getInputCode() {
        return InputCode;
    }

    public void setInputCode(String inputCode) {
        InputCode = inputCode;
    }

    public String getDrugModelCode() {
        return DrugModelCode;
    }

    public void setDrugModelCode(String drugModelCode) {
        DrugModelCode = drugModelCode;
    }

    public String getDrugModelName() {
        return DrugModelName;
    }

    public void setDrugModelName(String drugModelName) {
        DrugModelName = drugModelName;
    }

    public String getOtherName() {
        return OtherName;
    }

    public void setOtherName(String otherName) {
        OtherName = otherName;
    }

    public Gy_UnitEntity getUnits() {
        return Units;
    }

    public void setUnits(Gy_UnitEntity units) {
        Units = units;
    }

    public Gy_UnitEntity getUnitName() {
        return UnitName;
    }

    public void setUnitName(Gy_UnitEntity unitName) {
        UnitName = unitName;
    }

    public double getLPrice() {
        return LPrice;
    }

    public void setLPrice(double LPrice) {
        this.LPrice = LPrice;
    }

    public String getDrugSource() {
        return DrugSource;
    }

    public void setDrugSource(String drugSource) {
        DrugSource = drugSource;
    }

    public String getDrugProcess() {
        return DrugProcess;
    }

    public void setDrugProcess(String drugProcess) {
        DrugProcess = drugProcess;
    }

    public String getDrugTaste() {
        return DrugTaste;
    }

    public void setDrugTaste(String drugTaste) {
        DrugTaste = drugTaste;
    }

    public String getDrugMeridian() {
        return DrugMeridian;
    }

    public void setDrugMeridian(String drugMeridian) {
        DrugMeridian = drugMeridian;
    }

    public String getDrugYinMeridian() {
        return DrugYinMeridian;
    }

    public void setDrugYinMeridian(String drugYinMeridian) {
        DrugYinMeridian = drugYinMeridian;
    }

    public String getDrugFunction() {
        return DrugFunction;
    }

    public void setDrugFunction(String drugFunction) {
        DrugFunction = drugFunction;
    }

    public String getDrugAttend() {
        return DrugAttend;
    }

    public void setDrugAttend(String drugAttend) {
        DrugAttend = drugAttend;
    }

    public String getUsage() {
        return Usage;
    }

    public void setUsage(String usage) {
        Usage = usage;
    }

    public String getSpecialUsage() {
        return SpecialUsage;
    }

    public void setSpecialUsage(String specialUsage) {
        SpecialUsage = specialUsage;
    }

    public String getMatterAttend() {
        return MatterAttend;
    }

    public void setMatterAttend(String matterAttend) {
        MatterAttend = matterAttend;
    }

    public String getDrugStorage() {
        return DrugStorage;
    }

    public void setDrugStorage(String drugStorage) {
        DrugStorage = drugStorage;
    }

    public String getHISCorreCode() {
        return HISCorreCode;
    }

    public void setHISCorreCode(String HISCorreCode) {
        this.HISCorreCode = HISCorreCode;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public String getDrugProcessChecked() {
        return DrugProcessChecked;
    }

    public void setDrugProcessChecked(String drugProcessChecked) {
        DrugProcessChecked = drugProcessChecked;
    }

    public String getDrugTasteChecked() {
        return DrugTasteChecked;
    }

    public void setDrugTasteChecked(String drugTasteChecked) {
        DrugTasteChecked = drugTasteChecked;
    }

    public String getDrugMeridianChecked() {
        return DrugMeridianChecked;
    }

    public void setDrugMeridianChecked(String drugMeridianChecked) {
        DrugMeridianChecked = drugMeridianChecked;
    }

    public String getDrugYinMeridianChecked() {
        return DrugYinMeridianChecked;
    }

    public void setDrugYinMeridianChecked(String drugYinMeridianChecked) {
        DrugYinMeridianChecked = drugYinMeridianChecked;
    }

    public double getUpperLimit() {
        return UpperLimit;
    }

    public void setUpperLimit(double upperLimit) {
        UpperLimit = upperLimit;
    }

    public String getLowerLimit() {
        return LowerLimit;
    }

    public void setLowerLimit(String lowerLimit) {
        LowerLimit = lowerLimit;
    }

    public boolean isStopFlag() {
        return StopFlag;
    }

    public void setStopFlag(boolean stopFlag) {
        StopFlag = stopFlag;
    }

    public double getDrugFlag() {
        return DrugFlag;
    }

    public void setDrugFlag(double drugFlag) {
        DrugFlag = drugFlag;
    }

    public String getDrugWayCode() {
        return DrugWayCode;
    }

    public void setDrugWayCode(String drugWayCode) {
        DrugWayCode = drugWayCode;
    }

    public String getDrugWayName() {
        return DrugWayName;
    }

    public void setDrugWayName(String drugWayName) {
        DrugWayName = drugWayName;
    }

    public String getDosageCode() {
        return DosageCode;
    }

    public void setDosageCode(String dosageCode) {
        DosageCode = dosageCode;
    }

    public String getDosageName() {
        return DosageName;
    }

    public void setDosageName(String dosageName) {
        DosageName = dosageName;
    }

    public double getMeasurementCoefficient() {
        return MeasurementCoefficient;
    }

    public void setMeasurementCoefficient(double measurementCoefficient) {
        MeasurementCoefficient = measurementCoefficient;
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

    public String getPackageUnits() {
        return PackageUnits;
    }

    public void setPackageUnits(String packageUnits) {
        PackageUnits = packageUnits;
    }

    public class Gy_UnitEntity
    {
        //单位编码
        private String UnitCode;
        //单位名称
        private String UnitName;

        public String getUnitCode() {
            return UnitCode;
        }

        public void setUnitCode(String unitCode) {
            UnitCode = unitCode;
        }

        public String getUnitName() {
            return UnitName;
        }

        public void setUnitName(String unitName) {
            UnitName = unitName;
        }
    }

}

