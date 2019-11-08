package com.yyk.sz.zhzy.bbxt.service;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.bbxt.entity.BBDoctorTreatmentAnalysis;
import com.yyk.sz.zhzy.bbxt.mapper.BBDoctorTreatmentAnalysisMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class BBDoctorTreatmentAnalysisServiceImpl implements BBDoctorTreatmentAnalysisService {


    @Autowired
    private BBDoctorTreatmentAnalysisMapper bbDoctorTreatmentAnalysisMapper;

    @Override
    public Paging<BBDoctorTreatmentAnalysis> getDoctorTreatmentRecord(String beginDate, String endDate,String userCode, int pageNum,
                                                                      int pageSize,
                                                                      String searchText,
                                                                      String sortName,
                                                                      String sortOrder) {
        return bbDoctorTreatmentAnalysisMapper.getDoctorTreatmentRecord(beginDate,endDate,userCode,pageNum, pageSize, searchText, sortName, sortOrder);
    }

    @Override
    public List<BBDoctorTreatmentAnalysis> getDoctorTreatmentMoney(String beginDate, String endDate, String userCode) {
        return bbDoctorTreatmentAnalysisMapper.getDoctorTreatmentMoney(beginDate,endDate,userCode);
    }

    @Override
    public List<BBDoctorTreatmentAnalysis> getDoctorWorkloadByDate(String beginDate, String endDate, String userCode) {
        return bbDoctorTreatmentAnalysisMapper.getDoctorWorkloadByDate(beginDate,endDate,userCode);
    }

    @Override
    public List<BBDoctorTreatmentAnalysis> getDeptWorkloadByTime(String beginDate, String endDate, String userCode) {
        return bbDoctorTreatmentAnalysisMapper.getDeptWorkloadByTime(beginDate,endDate,userCode);
    }
}
