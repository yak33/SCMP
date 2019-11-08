package com.yyk.sz.zhzy.jcsjxt.mapper;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJWesternMedicine;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JCSJWesternMedicineMapper {

    Paging<JCSJWesternMedicine> getWesternMedicineTable(@Param("pageNum") int pageNum,
                                              @Param("pageSize") int pageSize,
                                              @Param("searchText") String searchText,
                                              @Param("sortName") String sortName,
                                              @Param("sortOrder") String sortOrder);
    int deleteWesternMedicine(String westernmedicinecode);

    int insertWesternMedicine(JCSJWesternMedicine record);

    int updateWesternMedicine(JCSJWesternMedicine record);

    List<JCSJWesternMedicine> checkWesternMedicineExits(@Param("westernmedicinecode") String westernmedicinecode, @Param("westernmedicinename") String westernmedicinename);

    List<JCSJWesternMedicine> GetMainSymptomInfoByWesternMedicineCode(@Param("westernmedicinecode") String westernmedicinecode);

}