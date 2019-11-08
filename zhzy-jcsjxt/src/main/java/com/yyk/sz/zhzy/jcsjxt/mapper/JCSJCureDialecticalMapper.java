package com.yyk.sz.zhzy.jcsjxt.mapper;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJCureDialectical;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JCSJCureDialecticalMapper {

    Paging<JCSJCureDialectical> GetCureDialecticalTable(@Param("pageNum") int pageNum,
                                                @Param("pageSize") int pageSize,
                                                @Param("searchText") String searchText,
                                                @Param("sortName") String sortName,
                                                @Param("sortOrder") String sortOrder);
    int deleteCureDialectical(@Param("strtable") String strtable,@Param("dialecticalcode") String dialecticalcode,@Param("mainsymptomcode") String mainsymptomcode);

    int insertCureDialectical(JCSJCureDialectical record);

    int insertDialecticalMainSymptom(JCSJCureDialectical record);

    int updateCureDialectical(JCSJCureDialectical record);

    List<JCSJCureDialectical> CheckSingleInfo(@Param("dialecticalcode") String dialecticalcode, @Param("mainsymptomcode") String mainsymptomcode);
    List<JCSJCureDialectical> GetDialecticalCureRelation(@Param("dialecticalcode") String dialecticalcode,@Param("mainsymptomcode") String mainsymptomcode);

    void dialecticalDiseaseCurePrescription_SP(JCSJCureDialectical record);

    int updateDialecticalMainSymptom(JCSJCureDialectical record);

    List<JCSJCureDialectical> GetDiseaseByMainSymptomCode(@Param("mainsymptomcode") String mainsymptomcode);

    List<JCSJCureDialectical> GetCureAndPreListBycode(@Param("dialecticalcode") String dialecticalcode,@Param("mainsymptomcode") String mainsymptomcode);

    List<JCSJCureDialectical> GetDiseaseByDialecticalAndMainSymptomCode(@Param("dialecticalcode") String dialecticalcode,@Param("mainsymptomcode") String mainsymptomcode);

    List<JCSJCureDialectical> GetWesternTable(@Param("dialecticalcode") String dialecticalcode,@Param("mainsymptomcode") String mainsymptomcode);
}