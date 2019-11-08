package com.yyk.sz.zhzy.jcsjxt.mapper;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJChineseMedicine;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JCSJChineseMedicineMapper {

    int deleteChineseMedicine(String chinesemedicinecode);

    int insertChineseMedicine(JCSJChineseMedicine record);

    int updateChineseMedicine(JCSJChineseMedicine record);

    Paging<JCSJChineseMedicine> getChineseMedicineTable(@Param("pageNum") int pageNum,
                                                             @Param("pageSize") int pageSize,
                                                             @Param("searchText") String searchText,
                                                             @Param("sortName") String sortName,
                                                             @Param("sortOrder") String sortOrder);

    List<JCSJChineseMedicine> checkChineseMedicineExits(@Param("chinesemedicinecode") String chinesemedicinecode, @Param("chinesemedicinename") String chinesemedicinename);
    List<JCSJChineseMedicine> GetMainSymptomInfoByChineseMedicineCode(@Param("chinesemedicinecode") String chinesemedicinecode);
    List<JCSJChineseMedicine> GetPrescriptionByChineseMedicineCode(@Param("chinesemedicinecode") String chinesemedicinecode);
}