package com.yyk.sz.zhzy.jcsjxt.service;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJDrugDict;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJUnit;

import java.util.List;


public interface JCSJUnitService {
    Paging<JCSJUnit> getUnitList(String unitCode, String unitName, int pageNum,
                                 int pageSize,
                                 String searchText,
                                 String sortName,
                                 String sortOrder);
    int insertUnit(JCSJUnit jcsjUnit);

    int updateUnit(JCSJUnit jcsjUnit);

    int deleteUnit(Integer unitCode);

    List<JCSJUnit> GetUnitByUnitCode(JCSJUnit jcsjUnit);

    List<JCSJUnit> GetUnitByUnitName(String unitName);

    List<JCSJDrugDict> GetDrugByUnitCode(Integer unitCode);
}
