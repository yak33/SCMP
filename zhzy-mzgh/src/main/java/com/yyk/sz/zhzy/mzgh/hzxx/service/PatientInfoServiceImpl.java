package com.yyk.sz.zhzy.mzgh.hzxx.service;


import com.yyk.sz.zhzy.mzgh.hzxx.entity.EmpBasicIdCodeRst;
import com.yyk.sz.zhzy.mzgh.hzxx.entity.PatientInfo;
import com.yyk.sz.zhzy.mzgh.hzxx.mapper.PatientInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
@Transactional
public class PatientInfoServiceImpl implements PatientInfoService {


    @Autowired
    private PatientInfoMapper patientInfoMapper;

    @Override
    public List<PatientInfo> getSelectPatientInfoTable(String deptCode){
        return patientInfoMapper.getSelectPatientInfoTable(deptCode);
    }

    @Override
    public boolean updatePatientInfo(PatientInfo patientInfo) {
        return patientInfoMapper.updatePatientInfo(patientInfo);
    }

    @Override
    public boolean updateHisPatientInfo(PatientInfo patientInfo) {
        return patientInfoMapper.updateHisPatientInfo(patientInfo);
    }

    @Override
    public boolean insertPatientInfo(PatientInfo patientInfo) {
        return patientInfoMapper.insertPatientInfo(patientInfo);
    }

    @Override
    public boolean insertHisPatientInfo(PatientInfo patientInfo) {
        return patientInfoMapper.insertHisPatientInfo(patientInfo);
    }

    @Override
    public void getBillCode(PatientInfo patientInfo) {
        patientInfoMapper.getBillCode(patientInfo);
    }

    @Override
    public List<EmpBasicIdCodeRst> GetEmpBasicIdCodeRst(String proUUID) {
        return patientInfoMapper.GetEmpBasicIdCodeRst(proUUID);
    }
}
