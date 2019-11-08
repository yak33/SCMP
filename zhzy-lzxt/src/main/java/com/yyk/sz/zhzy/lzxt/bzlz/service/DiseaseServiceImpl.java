package com.yyk.sz.zhzy.lzxt.bzlz.service;


import com.yyk.sz.zhzy.lzxt.bzlz.entity.Disease;
import com.yyk.sz.zhzy.lzxt.bzlz.entity.MainSymptom;
import com.yyk.sz.zhzy.lzxt.bzlz.mapper.DiseaseMapper;
import com.yyk.sz.zhzy.lzxt.bzlz.mapper.MainSymptomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class DiseaseServiceImpl implements DiseaseService {


    @Autowired
    private DiseaseMapper diseaseMapper;

    @Override
    public List<Disease> getDiseaseTable(String mainSymptomCode){
        return diseaseMapper.getDiseaseTable(mainSymptomCode);
    }
}
