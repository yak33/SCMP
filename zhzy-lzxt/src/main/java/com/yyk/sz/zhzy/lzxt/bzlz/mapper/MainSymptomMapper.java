package com.yyk.sz.zhzy.lzxt.bzlz.mapper;

import com.yyk.sz.zhzy.lzxt.bzlz.entity.MainSymptom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MainSymptomMapper {

    /**
     * 根据所属部门和用户账号查询主症
     *
     * @param deptCode
     * @param userCode
     * @return
     */
    List<MainSymptom> getSelectMainSymptomTable(@Param("deptCode") String deptCode, @Param("userCode") String userCode, @Param("searchText") String searchText);
}
