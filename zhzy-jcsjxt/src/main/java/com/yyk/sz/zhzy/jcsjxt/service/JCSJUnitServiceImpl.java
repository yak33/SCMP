package com.yyk.sz.zhzy.jcsjxt.service;


import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJDrugDict;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJUnit;
import com.yyk.sz.zhzy.jcsjxt.mapper.JCSJUnitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class JCSJUnitServiceImpl implements JCSJUnitService {


    @Autowired
    private JCSJUnitMapper jcsjUnitMapper;

    @Override
    public Paging<JCSJUnit> getUnitList(String unitCode, String unitName, int pageNum,
                                               int pageSize,
                                               String searchText,
                                               String sortName,
                                               String sortOrder) {
        return jcsjUnitMapper.getUnitList(unitCode,unitName,pageNum, pageSize, searchText, sortName, sortOrder);
    }

    @Override
    public int insertUnit(JCSJUnit jcsjUnit) {
        return jcsjUnitMapper.insertUnit(jcsjUnit);
    }

    @Override
    public int updateUnit(JCSJUnit jcsjUnit) {
        return jcsjUnitMapper.updateUnit(jcsjUnit);
    }

    @Override
    public int deleteUnit(Integer unitCode) {
        return jcsjUnitMapper.deleteUnit(unitCode);
    }

    @Override
    public List<JCSJUnit> GetUnitByUnitCode(JCSJUnit jcsjUnit) {
        return jcsjUnitMapper.GetUnitByUnitCode(jcsjUnit);
    }

    @Override
    public List<JCSJUnit> GetUnitByUnitName(String unitName) {
        return jcsjUnitMapper.GetUnitByUnitName(unitName);
    }

    @Override
    public List<JCSJDrugDict> GetDrugByUnitCode(Integer unitCode) {
        return jcsjUnitMapper.GetDrugByUnitCode(unitCode);
    }
}
