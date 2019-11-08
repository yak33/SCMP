package com.yyk.sz.zhzy.gcxt.bzlz.service;


import com.yyk.sz.zhzy.gcxt.bzlz.entity.GCMainSymptom;
import com.yyk.sz.zhzy.gcxt.bzlz.mapper.GCMainSymptomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class GCMainSymptomServiceImpl implements GCMainSymptomService {


    @Autowired
    private GCMainSymptomMapper gcmainSymptomMapper;

    @Override
    public List<GCMainSymptom> getSelectMainSymptomByCode(String deptCode, String userCode, String westernMedicineCode, String searchText){
        return gcmainSymptomMapper.getSelectMainSymptomByCode(deptCode, userCode,westernMedicineCode,searchText);
    }
}
