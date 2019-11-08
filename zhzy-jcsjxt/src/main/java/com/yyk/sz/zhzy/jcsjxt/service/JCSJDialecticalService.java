package com.yyk.sz.zhzy.jcsjxt.service;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJDialectical;

import java.util.List;


public interface JCSJDialecticalService {
    Paging<JCSJDialectical> getDialecticalTable(int pageNum,
                                          int pageSize,
                                          String searchText,
                                          String sortName,
                                          String sortOrder);
    int insertDialectical(JCSJDialectical jcsjDialectical);

    int updateDialectical(JCSJDialectical jcsjDialectical);

    int deleteDialectical(String dialecticalcode);

    List<JCSJDialectical> checkDialecticalExits(String dialecticalcode, String dialecticalname);
    List<JCSJDialectical> GetMainSymptomInfoByDialecticalCode(String dialecticalcode);

}
