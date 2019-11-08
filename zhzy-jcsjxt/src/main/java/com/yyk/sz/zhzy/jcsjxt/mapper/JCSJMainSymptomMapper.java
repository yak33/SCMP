package com.yyk.sz.zhzy.jcsjxt.mapper;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJMainSymptom;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JCSJMainSymptomMapper {

    int deleteMainSymptom(@Param("strtable") String strtable,@Param("mainsymptomcode") String mainsymptomcode);

    int insertMainSymptom(JCSJMainSymptom record);

    int insertMainSymptomAll(@Param("strtable") String strtable,@Param("mainsymptomcode") String mainsymptomcode,@Param("cloum") String cloum,@Param("code") String code);

    Paging<JCSJMainSymptom> getMainSymptomTable(@Param("pageNum") int pageNum,
                                                    @Param("pageSize") int pageSize,
                                                    @Param("searchText") String searchText,
                                                    @Param("sortName") String sortName,
                                                    @Param("sortOrder") String sortOrder);

    int updateMainSymptom(JCSJMainSymptom record);

    List<JCSJMainSymptom> GetMainSymptomDeptRelation(@Param("mainsymptomcode") String mainsymptomcode);

    List<JCSJMainSymptom> GetMainSymptomDiseaseRelation(@Param("mainsymptomcode") String mainsymptomcode);

    List<JCSJMainSymptom> GetCureDialecticalByMainSymptomCode(@Param("mainsymptomcode") String mainsymptomcode);

    List<JCSJMainSymptom> GetSingleMainSymptomByMainSymptomCode(@Param("mainsymptomcode") String mainsymptomcode);

    List<JCSJMainSymptom> GetMainSymptomByMainSymptomNameAndMainSymptomTypeCode(@Param("mainsymptomtypecode") String mainsymptomtypecode);

    List<JCSJMainSymptom> GetMainSymptomByMainSymptomCode(@Param("mainsymptomcode") String mainsymptomcode);

    List<JCSJMainSymptom> checkMainSymptomExits(@Param("mainsymptomtypecode") String mainsymptomtypecode,@Param("mainsymptomtypename") String mainsymptomtypename);
}