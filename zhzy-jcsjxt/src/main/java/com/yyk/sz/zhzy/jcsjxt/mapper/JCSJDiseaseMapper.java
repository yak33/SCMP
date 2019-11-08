package com.yyk.sz.zhzy.jcsjxt.mapper;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJDisease;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JCSJDiseaseMapper {
    int deleteDisease(@Param("diseasecode") String diseasecode);

    int insertDisease(JCSJDisease record);

    Paging<JCSJDisease> getDiseaseTable(@Param("pageNum") int pageNum,
                                            @Param("pageSize") int pageSize,
                                            @Param("searchText") String searchText,
                                            @Param("sortName") String sortName,
                                            @Param("sortOrder") String sortOrder);

    int updateDisease(JCSJDisease record);

    int deleteMeridianMainSymptom(@Param("strtable") String strtable,@Param("diseasecode") String diseasecode);
    int insertMeridianMainSymptom(@Param("strtable") String strtable,@Param("diseasecode") String diseasecode,@Param("cloum") String cloum,@Param("code") String code);

    List<JCSJDisease> checkDiseaseExits(@Param("diseasecode") String diseasecode,@Param("diseasename") String diseasename);
    List<JCSJDisease> GetDiseaseMainSymptomRelation(@Param("diseasecode") String diseasecode);
    List<JCSJDisease> GetDiseaseDialecticalRelation(@Param("diseasecode") String diseasecode);

}