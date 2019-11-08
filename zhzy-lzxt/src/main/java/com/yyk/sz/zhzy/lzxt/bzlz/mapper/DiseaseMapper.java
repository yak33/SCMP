package com.yyk.sz.zhzy.lzxt.bzlz.mapper;

import com.yyk.sz.zhzy.lzxt.bzlz.entity.Disease;
import com.yyk.sz.zhzy.lzxt.bzlz.entity.MainSymptom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiseaseMapper {

    /**
     * 获取兼症（根据主症编码获取对应的兼症）
     *
     * @param mainSymptomCode 主症编码
     * @return
     */
    List<Disease> getDiseaseTable(@Param("mainSymptomCode") String mainSymptomCode);
}
