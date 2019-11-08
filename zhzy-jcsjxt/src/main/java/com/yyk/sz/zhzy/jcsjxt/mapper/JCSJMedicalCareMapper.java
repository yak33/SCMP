package com.yyk.sz.zhzy.jcsjxt.mapper;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJMedicalCare;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JCSJMedicalCareMapper {

    int deleteMedicalCare(@Param("medicalCareCode") String medicalCareCode);

    int insertMedicalCare(JCSJMedicalCare record);

    Paging<JCSJMedicalCare> getMedicalCare(@Param("medicalCareCode") String medicalCareCode,
                                           @Param("medicalCareName") String medicalCareName,
                                           @Param("pinYinCode") String pinYinCode,
                                           @Param("pageNum") int pageNum,
                                           @Param("pageSize") int pageSize,
                                           @Param("searchText") String searchText,
                                           @Param("sortName") String sortName,
                                           @Param("sortOrder") String sortOrder);

    int updateMedicalCare(JCSJMedicalCare record);

    List<JCSJMedicalCare> CheckMedicalExits(@Param("medicalCareCode") String medicalCareCode,
                                            @Param("medicalCareName") String medicalCareName);

}