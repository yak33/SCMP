package com.yyk.sz.zhzy.jcsjxt.service;


import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJCure;
import com.yyk.sz.zhzy.jcsjxt.mapper.JCSJCureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class JCSJCureServiceImpl implements JCSJCureService {


    @Autowired
    private JCSJCureMapper jcsjCureMapper;

    @Override
    public Paging<JCSJCure> getCureTable(int pageNum,
                                         int pageSize,
                                         String searchText,
                                         String sortName,
                                         String sortOrder) {
        return jcsjCureMapper.getCureTable(pageNum, pageSize, searchText, sortName, sortOrder);
    }

    @Override
    public int insertCure(JCSJCure jcsjCure) {
        return jcsjCureMapper.insertCure(jcsjCure);
    }

    @Override
    public int updateCure(JCSJCure jcsjCure) {
        return jcsjCureMapper.updateCure(jcsjCure);
    }

    @Override
    public int deleteCure(String curecode) {
        return jcsjCureMapper.deleteCure(curecode);
    }

    @Override
    public List<JCSJCure> checkCureExits(String curecode, String curename) {
        return jcsjCureMapper.checkCureExits(curecode, curename);
    }

    @Override
    public List<JCSJCure> GetCureDialecticalRelation(String curecode) {
        return jcsjCureMapper.GetCureDialecticalRelation(curecode);
    }
}
