package com.yyk.sz.zhzy.lzxt.bzlz.service;


import com.yyk.sz.zhzy.lzxt.bzlz.entity.MainSymptom;
import com.yyk.sz.zhzy.lzxt.bzlz.mapper.MainSymptomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class MainSymptomServiceImpl implements MainSymptomService {


    @Autowired
    private MainSymptomMapper mainSymptomMapper;

    @Override
    public List<MainSymptom> getSelectMainSymptomTable(String deptCode, String userCode, String searchText){
        return mainSymptomMapper.getSelectMainSymptomTable(deptCode, userCode,searchText);
    }
}
