package com.yyk.sz.zhzy.lzxt.zjkf.mapper;

import com.yyk.sz.zhzy.lzxt.zjkf.entity.DrugDict;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DrugDictMapper {
    /**
     * 根据药物编码获取药物信息
     * @param drugCode
     * @return
     */
    List<DrugDict> getDrugInfoList(@Param("drugCode") String drugCode);
}
