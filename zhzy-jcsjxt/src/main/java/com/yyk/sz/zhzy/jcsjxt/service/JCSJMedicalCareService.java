package com.yyk.sz.zhzy.jcsjxt.service;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJMedicalCare;

import java.util.List;


public interface JCSJMedicalCareService {
    Paging<JCSJMedicalCare> getMedicalCare(String medicalCareCode, String medicalCareName,String pinYinCode, int pageNum,
                                 int pageSize,
                                 String searchText,
                                 String sortName,
                                 String sortOrder);
    int insertMedicalCare(JCSJMedicalCare jcsjMedicalCare);

    int updateMedicalCare(JCSJMedicalCare jcsjMedicalCare);

    int deleteMedicalCare(String medicalCareCode);

    List<JCSJMedicalCare> CheckMedicalExits(String medicalCareCode,String medicalCareName);

}
