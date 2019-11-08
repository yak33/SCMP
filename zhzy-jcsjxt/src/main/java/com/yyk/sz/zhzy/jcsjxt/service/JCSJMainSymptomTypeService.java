package com.yyk.sz.zhzy.jcsjxt.service;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJMainSymptomType;

import java.util.List;


public interface JCSJMainSymptomTypeService {
    Paging<JCSJMainSymptomType> getMainSymptomTypeTable(int pageNum,
                                               int pageSize,
                                               String searchText,
                                               String sortName,
                                               String sortOrder);
    int insertMainSymptomType(JCSJMainSymptomType jcsjUsedPhrases);

    int updateMainSymptomType(JCSJMainSymptomType jcsjUsedPhrases);

    int deleteMainSymptomType(String mainsymptomtypecode);


    List<JCSJMainSymptomType> GetMainSymptomByMainSymptomTypeCode(String mainsymptomtypecode);

    List<JCSJMainSymptomType> checkMainSymptomTypeExits(String mainsymptomtypecode,String mainsymptomtypename);
}
