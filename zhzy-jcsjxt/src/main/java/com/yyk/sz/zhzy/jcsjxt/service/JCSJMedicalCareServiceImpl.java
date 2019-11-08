package com.yyk.sz.zhzy.jcsjxt.service;


import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJMedicalCare;
import com.yyk.sz.zhzy.jcsjxt.mapper.JCSJMedicalCareMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class JCSJMedicalCareServiceImpl implements JCSJMedicalCareService {

    @Autowired
    private JCSJMedicalCareMapper jcsjMedicalCareMapper;

    @Override
    public Paging<JCSJMedicalCare> getMedicalCare(String medicalCareCode, String medicalCareName, String pinYinCode, int pageNum, int pageSize, String searchText, String sortName, String sortOrder) {
        return jcsjMedicalCareMapper.getMedicalCare(medicalCareCode,medicalCareName,pinYinCode,pageNum, pageSize, searchText, sortName, sortOrder);
    }

    @Override
    public int insertMedicalCare(JCSJMedicalCare jcsjMedicalCare) {
        return jcsjMedicalCareMapper.insertMedicalCare(jcsjMedicalCare);
    }

    @Override
    public int updateMedicalCare(JCSJMedicalCare jcsjMedicalCare) {
        return jcsjMedicalCareMapper.updateMedicalCare(jcsjMedicalCare);
    }

    @Override
    public int deleteMedicalCare(String medicalCareCode) {
        return jcsjMedicalCareMapper.deleteMedicalCare(medicalCareCode);
    }

    @Override
    public List<JCSJMedicalCare> CheckMedicalExits(String medicalCareCode,String medicalCareName) {
        return jcsjMedicalCareMapper.CheckMedicalExits(medicalCareCode,medicalCareName);
    }

}
