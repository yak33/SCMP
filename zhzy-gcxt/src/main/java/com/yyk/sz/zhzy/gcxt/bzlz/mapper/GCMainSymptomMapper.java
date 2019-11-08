package com.yyk.sz.zhzy.gcxt.bzlz.mapper;

import com.yyk.sz.zhzy.gcxt.bzlz.entity.GCMainSymptom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GCMainSymptomMapper {

    /**
     * 根据所属部门和用户账号查询主症
     *
     * @param deptCode
     * @param userCode
     * @return
     */
    List<GCMainSymptom> getSelectMainSymptomByCode(@Param("deptCode") String deptCode, @Param("userCode") String userCode, @Param("westernMedicineCode") String westernMedicineCode, @Param("searchText") String searchText);
}
