package com.yyk.sz.zhzy.jcsjxt.service;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJDrugTaboos;

import java.util.List;


public interface JCSJDrugTaboosService {
    Paging<JCSJDrugTaboos> getDrugTaboosTable(String drugtaboostype,
                                              String drugname,
                                              int pageNum,
                                              int pageSize,
                                              String searchText,
                                              String sortName,
                                              String sortOrder);

    int deleteDrugTaboos(String drugtaboostype,
                         String drugcode,
                         String drugcodeone);

    int insertDrugTaboos(JCSJDrugTaboos jcsjDrugTaboos);

    int updateDrugTaboos(JCSJDrugTaboos jcsjDrugTaboos);

    List<JCSJDrugTaboos> GetDrugAnti(String drugtaboostype, String drugcode, String drugcodeone);

    List<JCSJDrugTaboos> GetDrugSM(String drugtaboostype, String drugcode);

    List<JCSJDrugTaboos> GetDrugToaboosQuanitity(String drugtaboostype, String drugcode);

}
