package com.yyk.sz.zhzy.lzxt.bzlz.service;


import com.yyk.sz.zhzy.lzxt.bzlz.entity.Pulse;
import com.yyk.sz.zhzy.lzxt.bzlz.entity.Tongue;
import com.yyk.sz.zhzy.lzxt.bzlz.mapper.PulseMapper;
import com.yyk.sz.zhzy.lzxt.bzlz.mapper.TongueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class PulseServiceImpl implements PulseService {


    @Autowired
    private PulseMapper pulseMapper;

    @Override
    public List<Pulse> getPulseTable(String mainSymptomCode){
        return pulseMapper.getPulseTable(mainSymptomCode);
    }
}
