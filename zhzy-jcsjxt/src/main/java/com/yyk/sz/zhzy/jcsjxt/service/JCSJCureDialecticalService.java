package com.yyk.sz.zhzy.jcsjxt.service;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJCureDialectical;

import java.util.List;


public interface JCSJCureDialecticalService {
    Paging<JCSJCureDialectical> GetCureDialecticalTable(int pageNum,
                                                    int pageSize,
                                                    String searchText,
                                                    String sortName,
                                                    String sortOrder);
    int insertCureDialectical(JCSJCureDialectical jcsjCureDialectical);

    int insertDialecticalMainSymptom(JCSJCureDialectical jcsjCureDialectical);

    int insertMainSymptomAll(String strtable, String mainsymptomcode, String cloum, String code);

    int updateCureDialectical(JCSJCureDialectical jcsjCureDialectical);

    int deleteCureDialectical(String strtable,String dialecticalcode, String mainsymptomcode);

    List<JCSJCureDialectical> GetDialecticalCureRelation(String dialecticalcode,String mainsymptomcode);

    List<JCSJCureDialectical> CheckSingleInfo(String mainsymptomtypecode, String mainsymptomtypename);

    void dialecticalDiseaseCurePrescription_SP(JCSJCureDialectical jcsjCureDialectical);

    int updateDialecticalMainSymptom(JCSJCureDialectical jcsjCureDialectical);

    List<JCSJCureDialectical> GetDiseaseByMainSymptomCode(String mainsymptomcode);

    List<JCSJCureDialectical> GetCureAndPreListBycode(String dialecticalcode,String mainsymptomcode);

    List<JCSJCureDialectical> GetDiseaseByDialecticalAndMainSymptomCode(String dialecticalcode,String mainsymptomcode);

    List<JCSJCureDialectical> GetWesternTable(String dialecticalcode,String mainsymptomcode);
}
