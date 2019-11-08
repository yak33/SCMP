package com.yyk.sz.zhzy.jcsjxt.service;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJCure;

import java.util.List;


public interface JCSJCureService {
    Paging<JCSJCure> getCureTable(int pageNum,
                                   int pageSize,
                                   String searchText,
                                   String sortName,
                                   String sortOrder);
    int insertCure(JCSJCure jcsjCure);

    int updateCure(JCSJCure jcsjCure);

    int deleteCure(String curecode);

    List<JCSJCure> checkCureExits(String curecode, String curename);
    List<JCSJCure> GetCureDialecticalRelation(String curecode);

}
