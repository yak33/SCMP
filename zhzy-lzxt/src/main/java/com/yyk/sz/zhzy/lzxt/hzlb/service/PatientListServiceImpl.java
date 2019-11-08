package com.yyk.sz.zhzy.lzxt.hzlb.service;


import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.lzxt.hzlb.entity.PatientList;
import com.yyk.sz.zhzy.lzxt.hzlb.mapper.PatientListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class PatientListServiceImpl implements PatientListService {


    @Autowired
    private PatientListMapper patientListMapper;

    @Override
    public Paging<PatientList> getSelectPatientListTable(String treatmentState,String deptcode, int pageNum,
                                                         int pageSize,
                                                         String searchText,
                                                         String sortName,
                                                         String sortOrder){
        return patientListMapper.getSelectPatientListTable(treatmentState,deptcode,pageNum, pageSize, searchText, sortName, sortOrder);
    }
}
