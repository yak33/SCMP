package com.yyk.sz.zhzy.bbxt.service;


import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.bbxt.entity.BBDoctorTreatmentAnalysis;

import java.util.List;

public interface BBDoctorTreatmentAnalysisService {
    Paging<BBDoctorTreatmentAnalysis> getDoctorTreatmentRecord(String beginDate, String endDate,String userCode, int pageNum,
                                                               int pageSize,
                                                               String searchText,
                                                               String sortName,
                                                               String sortOrder);

    List<BBDoctorTreatmentAnalysis> getDoctorTreatmentMoney(String beginDate, String endDate, String userCode);

    List<BBDoctorTreatmentAnalysis> getDoctorWorkloadByDate(String beginDate, String endDate, String userCode);

    List<BBDoctorTreatmentAnalysis> getDeptWorkloadByTime(String beginDate, String endDate, String userCode);
}
