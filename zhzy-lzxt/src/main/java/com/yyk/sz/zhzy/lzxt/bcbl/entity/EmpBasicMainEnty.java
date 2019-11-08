package com.yyk.sz.zhzy.lzxt.bcbl.entity;

import com.yyk.sz.common.base.domain.BaseEntity;

import java.util.Date;


public class EmpBasicMainEnty extends BaseEntity {

    private String UUID;
    //自动主表编码
    private int EmpBasicMainID;
    //病人基本信息单号
    private String EmpBasicCode;
    //病历号
    private String MecidalNum;
    //挂号流水号
    private String RegistrationNum;
    //处方号
    private String PrescriptionCode;
    //诊断信息
    private String DiagnosticInfo;
    //姓名
    private String EmName;
    //性别
    private String EmSex;
    //年龄
    private int EmAge;
    //身份证号
    private String EmNum;
    //联系电话
    private String EmMobile;
    //联系人
    private String EmComName;
    //地址
    private String EmAddress;
    //开单医生代码
    private String UserCode;
    //开单医生
    private String UserName;
    //开单科室代码
    private String DeptCode;
    //开单科室名称
    private String DeptName;
    //体重
    private double Weight;
    //主诉
    private String ChiefComplaint;
    //体格检查
    private String PhysicalExamination;
    //现病史
    private String HistoryPresent;
    //既往史
    private String HistoryPast;
    //过敏史
    private String HistoryAllergic;
    //诊疗意见
    private String DiagnosisViews;
    //其它情况描述
    private String OtherDescription;
    //主症编码
    private String MainSymptomCode;
    //证型编码
    private String DialecticalCode;
    //治法编码
    private String CureCode;
    //医生代码
    private String Maker;
    //发病日期
    private String OnSetDate;
    //看病日期精确到小时分钟
    private String MakeDate;
    //看病完成日期精确到小时分钟
    private String FinishDate;
    //是否孕妇
    private String IsYuFu;
    //中药
    private String ChineseMedicineCode;
    //西药
    private String WesternMedicineCode;

    //中药
    private String ChineseMedicineName;
    //西药
    private String WesternMedicineName;

    //处方名称
    private String FangJiSubName;
    //医嘱
    private String Advice;

    //证型名称
    private String DialecticalName;
    //治法名称
    private String CureName;

    //病人状态
    private String EmpStatus;

    private String EmpCheckState;

    //评价编码
    private String EvaluationCode;

    private String EvaluationName;

    //评价备注
    private String EvaluationRemark;

    //主症名称
    private String MainSymptomName;

    //兼症名称
    private String DiseaseName;

    //舌像名称
    private String TongueName;

    //脉象名称
    private String PulseName;
    //病种分类编码
    private String DCCode;

    //问诊记录兼症子表 兼症编码
    private String DiseaseCode;
    //问诊记录脉象子表 脉象编码
    private String PulseCode;
    //问诊记录舌像子表 舌像编码
    private String TongueCode;

    private String selName;
    //处方结果
    private String strChuFang;
    //方剂明细
    private String strFangJi;

    private String v_ReturnValueStr;

    private String FangjiReturnValue;

    private String DetailItemName;

    private int checkFlag;

    private String FangJiSubID;
    private String FangJiUsage;
    private String IsDaiJian;
    private String Remark;
    private String UsageCount;
    private String LunAfterImg;//论治后图片


    public String getLunAfterImg() {
        return LunAfterImg;
    }

    public void setLunAfterImg(String lunAfterImg) {
        LunAfterImg = lunAfterImg;
    }

    public String getFangJiSubID() {
        return FangJiSubID;
    }

    public void setFangJiSubID(String fangJiSubID) {
        FangJiSubID = fangJiSubID;
    }

    public String getFangJiUsage() {
        return FangJiUsage;
    }

    public void setFangJiUsage(String fangJiUsage) {
        FangJiUsage = fangJiUsage;
    }

    public String getIsDaiJian() {
        return IsDaiJian;
    }

    public void setIsDaiJian(String isDaiJian) {
        IsDaiJian = isDaiJian;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public String getUsageCount() {
        return UsageCount;
    }

    public void setUsageCount(String usageCount) {
        UsageCount = usageCount;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public int getCheckFlag() {
        return checkFlag;
    }

    public void setCheckFlag(int checkFlag) {
        this.checkFlag = checkFlag;
    }

    public String getDetailItemName() {
        return DetailItemName;
    }

    public void setDetailItemName(String detailItemName) {
        DetailItemName = detailItemName;
    }

    public String getFangjiReturnValue() {
        return FangjiReturnValue;
    }

    public void setFangjiReturnValue(String fangjiReturnValue) {
        FangjiReturnValue = fangjiReturnValue;
    }

    public String getStrFangJi() {
        return strFangJi;
    }

    public void setStrFangJi(String strFangJi) {
        this.strFangJi = strFangJi;
    }

    public String getStrChuFang() {
        return strChuFang;
    }

    public void setStrChuFang(String strChuFang) {
        this.strChuFang = strChuFang;
    }

    public String getSelName() {
        return selName;
    }

    public void setSelName(String selName) {
        this.selName = selName;
    }

    public String getV_ReturnValueStr() {
        return v_ReturnValueStr;
    }

    public void setV_ReturnValueStr(String v_ReturnValueStr) {
        this.v_ReturnValueStr = v_ReturnValueStr;
    }

    public int getEmpBasicMainID() {
        return EmpBasicMainID;
    }

    public void setEmpBasicMainID(int empBasicMainID) {
        EmpBasicMainID = empBasicMainID;
    }

    public String getEmpBasicCode() {
        return EmpBasicCode;
    }

    public void setEmpBasicCode(String empBasicCode) {
        EmpBasicCode = empBasicCode;
    }

    public String getMecidalNum() {
        return MecidalNum;
    }

    public void setMecidalNum(String mecidalNum) {
        MecidalNum = mecidalNum;
    }

    public String getRegistrationNum() {
        return RegistrationNum;
    }

    public void setRegistrationNum(String registrationNum) {
        RegistrationNum = registrationNum;
    }

    public String getPrescriptionCode() {
        return PrescriptionCode;
    }

    public void setPrescriptionCode(String prescriptionCode) {
        PrescriptionCode = prescriptionCode;
    }

    public String getDiagnosticInfo() {
        return DiagnosticInfo;
    }

    public void setDiagnosticInfo(String diagnosticInfo) {
        DiagnosticInfo = diagnosticInfo;
    }

    public String getEmName() {
        return EmName;
    }

    public void setEmName(String emName) {
        EmName = emName;
    }

    public String getEmSex() {
        return EmSex;
    }

    public void setEmSex(String emSex) {
        EmSex = emSex;
    }

    public int getEmAge() {
        return EmAge;
    }

    public void setEmAge(int emAge) {
        EmAge = emAge;
    }

    public String getEmNum() {
        return EmNum;
    }

    public void setEmNum(String emNum) {
        EmNum = emNum;
    }

    public String getEmMobile() {
        return EmMobile;
    }

    public void setEmMobile(String emMobile) {
        EmMobile = emMobile;
    }

    public String getEmComName() {
        return EmComName;
    }

    public void setEmComName(String emComName) {
        EmComName = emComName;
    }

    public String getEmAddress() {
        return EmAddress;
    }

    public void setEmAddress(String emAddress) {
        EmAddress = emAddress;
    }

    public String getUserCode() {
        return UserCode;
    }

    public void setUserCode(String userCode) {
        UserCode = userCode;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getDeptCode() {
        return DeptCode;
    }

    public void setDeptCode(String deptCode) {
        DeptCode = deptCode;
    }

    public String getDeptName() {
        return DeptName;
    }

    public void setDeptName(String deptName) {
        DeptName = deptName;
    }

    public double getWeight() {
        return Weight;
    }

    public void setWeight(double weight) {
        Weight = weight;
    }

    public String getChiefComplaint() {
        return ChiefComplaint;
    }

    public void setChiefComplaint(String chiefComplaint) {
        ChiefComplaint = chiefComplaint;
    }

    public String getPhysicalExamination() {
        return PhysicalExamination;
    }

    public void setPhysicalExamination(String physicalExamination) {
        PhysicalExamination = physicalExamination;
    }

    public String getHistoryPresent() {
        return HistoryPresent;
    }

    public void setHistoryPresent(String historyPresent) {
        HistoryPresent = historyPresent;
    }

    public String getHistoryPast() {
        return HistoryPast;
    }

    public void setHistoryPast(String historyPast) {
        HistoryPast = historyPast;
    }

    public String getHistoryAllergic() {
        return HistoryAllergic;
    }

    public void setHistoryAllergic(String historyAllergic) {
        HistoryAllergic = historyAllergic;
    }

    public String getDiagnosisViews() {
        return DiagnosisViews;
    }

    public void setDiagnosisViews(String diagnosisViews) {
        DiagnosisViews = diagnosisViews;
    }

    public String getOtherDescription() {
        return OtherDescription;
    }

    public void setOtherDescription(String otherDescription) {
        OtherDescription = otherDescription;
    }

    public String getMainSymptomCode() {
        return MainSymptomCode;
    }

    public void setMainSymptomCode(String mainSymptomCode) {
        MainSymptomCode = mainSymptomCode;
    }

    public String getDialecticalCode() {
        return DialecticalCode;
    }

    public void setDialecticalCode(String dialecticalCode) {
        DialecticalCode = dialecticalCode;
    }

    public String getCureCode() {
        return CureCode;
    }

    public void setCureCode(String cureCode) {
        CureCode = cureCode;
    }

    public String getMaker() {
        return Maker;
    }

    public void setMaker(String maker) {
        Maker = maker;
    }

    public String getOnSetDate() {
        return OnSetDate;
    }

    public void setOnSetDate(String onSetDate) {
        OnSetDate = onSetDate;
    }

    public String getMakeDate() {
        return MakeDate;
    }

    public void setMakeDate(String makeDate) {
        MakeDate = makeDate;
    }

    public String getFinishDate() {
        return FinishDate;
    }

    public void setFinishDate(String finishDate) {
        FinishDate = finishDate;
    }

    public String getIsYuFu() {
        return IsYuFu;
    }

    public void setIsYuFu(String isYuFu) {
        IsYuFu = isYuFu;
    }

    public String getChineseMedicineCode() {
        return ChineseMedicineCode;
    }

    public void setChineseMedicineCode(String chineseMedicineCode) {
        ChineseMedicineCode = chineseMedicineCode;
    }

    public String getWesternMedicineCode() {
        return WesternMedicineCode;
    }

    public void setWesternMedicineCode(String westernMedicineCode) {
        WesternMedicineCode = westernMedicineCode;
    }

    public String getChineseMedicineName() {
        return ChineseMedicineName;
    }

    public void setChineseMedicineName(String chineseMedicineName) {
        ChineseMedicineName = chineseMedicineName;
    }

    public String getWesternMedicineName() {
        return WesternMedicineName;
    }

    public void setWesternMedicineName(String westernMedicineName) {
        WesternMedicineName = westernMedicineName;
    }

    public String getFangJiSubName() {
        return FangJiSubName;
    }

    public void setFangJiSubName(String fangJiSubName) {
        FangJiSubName = fangJiSubName;
    }

    public String getAdvice() {
        return Advice;
    }

    public void setAdvice(String advice) {
        Advice = advice;
    }

    public String getDialecticalName() {
        return DialecticalName;
    }

    public void setDialecticalName(String dialecticalName) {
        DialecticalName = dialecticalName;
    }

    public String getCureName() {
        return CureName;
    }

    public void setCureName(String cureName) {
        CureName = cureName;
    }

    public String getEmpStatus() {
        return EmpStatus;
    }

    public void setEmpStatus(String empStatus) {
        EmpStatus = empStatus;
    }

    public String getEmpCheckState() {
        return EmpCheckState;
    }

    public void setEmpCheckState(String empCheckState) {
        EmpCheckState = empCheckState;
    }

    public String getEvaluationCode() {
        return EvaluationCode;
    }

    public void setEvaluationCode(String evaluationCode) {
        EvaluationCode = evaluationCode;
    }

    public String getEvaluationName() {
        return EvaluationName;
    }

    public void setEvaluationName(String evaluationName) {
        EvaluationName = evaluationName;
    }

    public String getEvaluationRemark() {
        return EvaluationRemark;
    }

    public void setEvaluationRemark(String evaluationRemark) {
        EvaluationRemark = evaluationRemark;
    }

    public String getMainSymptomName() {
        return MainSymptomName;
    }

    public void setMainSymptomName(String mainSymptomName) {
        MainSymptomName = mainSymptomName;
    }

    public String getDiseaseName() {
        return DiseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        DiseaseName = diseaseName;
    }

    public String getTongueName() {
        return TongueName;
    }

    public void setTongueName(String tongueName) {
        TongueName = tongueName;
    }

    public String getPulseName() {
        return PulseName;
    }

    public void setPulseName(String pulseName) {
        PulseName = pulseName;
    }

    public String getDCCode() {
        return DCCode;
    }

    public void setDCCode(String DCCode) {
        this.DCCode = DCCode;
    }

    public String getDiseaseCode() {
        return DiseaseCode;
    }

    public void setDiseaseCode(String diseaseCode) {
        DiseaseCode = diseaseCode;
    }

    public String getPulseCode() {
        return PulseCode;
    }

    public void setPulseCode(String pulseCode) {
        PulseCode = pulseCode;
    }

    public String getTongueCode() {
        return TongueCode;
    }

    public void setTongueCode(String tongueCode) {
        TongueCode = tongueCode;
    }
}
