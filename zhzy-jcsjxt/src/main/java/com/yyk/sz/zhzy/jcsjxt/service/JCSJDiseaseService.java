package com.yyk.sz.zhzy.jcsjxt.service;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJDisease;

import java.util.List;


public interface JCSJDiseaseService {
    Paging<JCSJDisease> getDiseaseTable(int pageNum,
                                                int pageSize,
                                                String searchText,
                                                String sortName,
                                                String sortOrder);
    int insertDisease(JCSJDisease jcsjDisease);

    int updateDisease(JCSJDisease jcsjDisease);

    int deleteDisease(String diseasecode);

    int deleteMeridianMainSymptom(String strtable,String diseasecode);
    int insertMeridianMainSymptom(String strtable,String diseasecode,String cloum,String code);

    List<JCSJDisease> checkDiseaseExits(String diseasecode, String diseasename);
    List<JCSJDisease> GetDiseaseMainSymptomRelation(String diseasecode);
    List<JCSJDisease> GetDiseaseDialecticalRelation(String diseasecode);

}
