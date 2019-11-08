package com.yyk.sz.zhzy.lzxt.zjkf.service;

import com.yyk.sz.zhzy.lzxt.zjkf.entity.Meridian;
import com.yyk.sz.zhzy.lzxt.zjkf.mapper.MeridianMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Component
@Transactional
public class MeridianServiceImpl implements MeridianService{

    @Resource
    private MeridianMapper meridianMapper;

    @Override
    public List<Meridian> getMeridianList(String drugCode) {
        return meridianMapper.getMeridianList(drugCode);
    }
}
