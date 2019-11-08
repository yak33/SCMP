package com.yyk.sz.zhzy.lzxt.zjkf.service;

import com.yyk.sz.zhzy.lzxt.zjkf.entity.DrugDict;
import com.yyk.sz.zhzy.lzxt.zjkf.mapper.DrugDictMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Component
@Transactional
public class DrugDictServiceImpl implements DrugDictService {

    @Resource
    private DrugDictMapper drugDictMapper;

    @Override
    public List<DrugDict> getDrugInfoList(String drugCode) {
        return drugDictMapper.getDrugInfoList(drugCode);
    }
}
