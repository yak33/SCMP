package com.yyk.sz.zhzy.lzxt.zjkf.service;

import com.yyk.sz.zhzy.lzxt.zjkf.entity.Taste;
import com.yyk.sz.zhzy.lzxt.zjkf.mapper.TasteMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Component
@Transactional
public class TasteServiceImpl implements TasteService{

    @Resource
    private TasteMapper tasteMapper;

    @Override
    public List<Taste> getTasteList(String drugCode) {
        return tasteMapper.getTasteList(drugCode);
    }
}
