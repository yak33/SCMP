package com.yyk.sz.zhzy.mzgh.hzxx.entity;

import com.yyk.sz.common.base.domain.BaseEntity;

import java.util.Date;


public class PatientInfo extends BaseEntity {

    /**
     * 挂号序号
     */
    private String RegistrationNum;

    /**
     * 挂号序号id
     */
    private int RegistrationNumMainID;

    /**
<<<<<<< HEAD
     * 就诊类
=======
     * 就诊类型名称
>>>>>>> 2ca12d44b27e2c85f34350be07239722df50312c
     */
    private String MecidalTypeName;

    /**
     * 就诊状态 0未就诊，1已就诊
     */
    private int TreatmentState;

    /**
     * 就诊号
     */
    private String MecidalNum;

    /**
     * 费用类别
     */
    private String EmTypeName;

    private int EmType;

    /**
     * 姓名
     */
    private String EmName;

    /**
     * 性别
     */
    private int EmSex;

    /**
     * 年龄
     */
    private int EmAge;

    /**
     * 科室
     */
    private String DeptName;

    /**
     * 医生
     */
    private String UserName;

    /**
     * 联系人
     */
    private String EmComName;

    /**
     * 联系电话
     */
    private String EmMobile;

    /**
     * 地址
     */
    private String EmAddress;

    /**
     * 身份证号
     */
    private String EmNum;

    /**
     * 增加人
     */
    private String Maker;

    /**
     * 增加日期
     */
    private String MakeDate;

    /**
     * 体重
     */
    private int Weight;

    /**
     * 就诊日期
     */
    private String OnSetDate;

    private String proUUID;

    /**
     * 孕否
     */
    private String UserCode;
    private String DeptCode;
    private  int IsYuFu;
    private String billCode;
    private String dateString;
    private String itemCode;
    private int option;
    private String voucherCode;
    private int EmpStatus;
    private int EmpType;
    private String EmHealthCardNum;
    private String EmPreferentialNum;

    /**
     * 就诊类型
     */
    private String MecidalType;

    private int EmpBasicMainID;
    private String EmpBasicCode;

    public int isYuFu() {
        return IsYuFu;
    }

    public void setYuFu(int yuFu) {
        IsYuFu = yuFu;
    }

    public String getEmpBasicCode() {
        return EmpBasicCode;
    }

    public void setEmpBasicCode(String empBasicCode) {
        EmpBasicCode = empBasicCode;
    }

    public int getEmpBasicMainID() {
        return EmpBasicMainID;
    }

    public void setEmpBasicMainID(int empBasicMainID) {
        EmpBasicMainID = empBasicMainID;
    }

    public int getEmType() {
        return EmType;
    }

    public void setEmType(int emType) {
        EmType = emType;
    }

    public int getEmSex() {
        return EmSex;
    }

    public void setEmSex(int emSex) {
        EmSex = emSex;
    }

    public int getEmpType() {
        return EmpType;
    }

    public void setEmpType(int empType) {
        EmpType = empType;
    }

    public String getMecidalType() {
        return MecidalType;
    }

    public void setMecidalType(String mecidalType) {
        MecidalType = mecidalType;
    }

    public String getEmPreferentialNum() {
        return EmPreferentialNum;
    }

    public void setEmPreferentialNum(String emPreferentialNum) {
        EmPreferentialNum = emPreferentialNum;
    }

    public String getEmHealthCardNum() {
        return EmHealthCardNum;
    }

    public void setEmHealthCardNum(String emHealthCardNum) {
        EmHealthCardNum = emHealthCardNum;
    }

    public int getEmpStatus() {
        return EmpStatus;
    }

    public void setEmpStatus(int empStatus) {
        EmpStatus = empStatus;
    }

    public String getDeptCode() {
        return DeptCode;
    }

    public void setDeptCode(String deptCode) {
        DeptCode = deptCode;
    }

    public String getUserCode() {
        return UserCode;
    }

    public void setUserCode(String userCode) {
        UserCode = userCode;
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

    private  String v_GetBillCode;
    private  int v_GetBillID;

    public String getRegistrationNum() {
        return RegistrationNum;
    }

    public void setRegistrationNum(String registrationNum) {
        RegistrationNum = registrationNum;
    }

    public String getMecidalTypeName() {
        return MecidalTypeName;
    }

    public void setMecidalTypeName(String mecidalTypeName) {
        MecidalTypeName = mecidalTypeName;
    }

    public String getMecidalNum() {
        return MecidalNum;
    }

    public void setMecidalNum(String mecidalNum) {
        MecidalNum = mecidalNum;
    }

    public String getEmTypeName() {
        return EmTypeName;
    }

    public void setEmTypeName(String emTypeName) {
        EmTypeName = emTypeName;
    }

    public String getEmName() {
        return EmName;
    }

    public void setEmName(String emName) {
        EmName = emName;
    }

    public int getEmAge() {
        return EmAge;
    }

    public void setEmAge(int emAge) {
        EmAge = emAge;
    }

    public String getDeptName() {
        return DeptName;
    }

    public void setDeptName(String deptName) {
        DeptName = deptName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmComName() {
        return EmComName;
    }

    public void setEmComName(String emComName) {
        EmComName = emComName;
    }

    public String getEmMobile() {
        return EmMobile;
    }

    public void setEmMobile(String emMobile) {
        EmMobile = emMobile;
    }

    public String getEmAddress() {
        return EmAddress;
    }

    public void setEmAddress(String emAddress) {
        EmAddress = emAddress;
    }

    public String getEmNum() {
        return EmNum;
    }

    public void setEmNum(String emNum) {
        EmNum = emNum;
    }

    public String getMaker() {
        return Maker;
    }

    public void setMaker(String maker) {
        Maker = maker;
    }

    public String getMakeDate() {
        return MakeDate;
    }

    public void setMakeDate(String makeDate) {
        MakeDate = makeDate;
    }

    public int getWeight() {
        return Weight;
    }

    public void setWeight(int weight) {
        Weight = weight;
    }

    public String getOnSetDate() {
        return OnSetDate;
    }

    public void setOnSetDate(String onSetDate) {
        OnSetDate = onSetDate;
    }

    public int getIsYuFu() {
        return IsYuFu;
    }

    public void setIsYuFu(int isYuFu) {
        IsYuFu = isYuFu;
    }

    public int getRegistrationNumMainID() {
        return RegistrationNumMainID;
    }

    public void setRegistrationNumMainID(int registrationNumMainID) {
        RegistrationNumMainID = registrationNumMainID;
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

    public int getTreatmentState() {
        return TreatmentState;
    }

    public void setTreatmentState(int treatmentState) {
        TreatmentState = treatmentState;
    }

    public String getProUUID() {
        return proUUID;
    }

    public void setProUUID(String proUUID) {
        this.proUUID = proUUID;
    }
}
