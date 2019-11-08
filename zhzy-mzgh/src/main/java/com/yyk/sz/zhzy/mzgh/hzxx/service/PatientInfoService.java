package com.yyk.sz.zhzy.mzgh.hzxx.service;

import com.yyk.sz.zhzy.mzgh.hzxx.entity.EmpBasicIdCodeRst;
import com.yyk.sz.zhzy.mzgh.hzxx.entity.PatientInfo;
import java.util.List;

public interface PatientInfoService {
    public List<PatientInfo> getSelectPatientInfoTable(String registrationNum);

    public boolean updatePatientInfo(PatientInfo patientInfo);

    public boolean updateHisPatientInfo(PatientInfo patientInfo);

    public boolean insertPatientInfo(PatientInfo patientInfo);

    public boolean insertHisPatientInfo(PatientInfo patientInfo);

    void getBillCode(PatientInfo patientInfo);

    List<EmpBasicIdCodeRst> GetEmpBasicIdCodeRst(String proUUID);
}
