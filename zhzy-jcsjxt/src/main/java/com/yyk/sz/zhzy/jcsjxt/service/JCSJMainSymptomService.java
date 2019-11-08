package com.yyk.sz.zhzy.jcsjxt.service;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJMainSymptom;

import java.util.List;


public interface JCSJMainSymptomService {
    Paging<JCSJMainSymptom> getMainSymptomTable(int pageNum,
                                                int pageSize,
                                                String searchText,
                                                String sortName,
                                                String sortOrder);
    int insertMainSymptom(JCSJMainSymptom jcsjUsedPhrases);

    int insertMainSymptomAll(String strtable,String mainsymptomcode,String cloum,String code);

    int updateMainSymptom(JCSJMainSymptom jcsjUsedPhrases);

    int deleteMainSymptom(String strtable,String mainsymptomtypecode);


    List<JCSJMainSymptom> GetMainSymptomDeptRelation(String mainsymptomcode);
    List<JCSJMainSymptom> GetMainSymptomDiseaseRelation(String mainsymptomcode);
    List<JCSJMainSymptom> GetCureDialecticalByMainSymptomCode(String mainsymptomcode);

    List<JCSJMainSymptom> GetSingleMainSymptomByMainSymptomCode(String mainsymptomcode);
    List<JCSJMainSymptom> GetMainSymptomByMainSymptomNameAndMainSymptomTypeCode(String mainsymptomtypecode);
    List<JCSJMainSymptom> GetMainSymptomByMainSymptomCode(String mainsymptomcode);
    List<JCSJMainSymptom> checkMainSymptomExits(String mainsymptomtypecode, String mainsymptomtypename);
}
