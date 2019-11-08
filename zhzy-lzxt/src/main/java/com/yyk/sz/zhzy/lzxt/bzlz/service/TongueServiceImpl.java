package com.yyk.sz.zhzy.lzxt.bzlz.service;


import com.yyk.sz.zhzy.lzxt.bzlz.entity.Disease;
import com.yyk.sz.zhzy.lzxt.bzlz.entity.Tongue;
import com.yyk.sz.zhzy.lzxt.bzlz.mapper.DiseaseMapper;
import com.yyk.sz.zhzy.lzxt.bzlz.mapper.TongueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class TongueServiceImpl implements TongueService {


    @Autowired
    private TongueMapper tongueMapper;

    @Override
    public List<Tongue> getTongueTable(String mainSymptomCode){
        return tongueMapper.getTongueTable(mainSymptomCode);
    }
}
