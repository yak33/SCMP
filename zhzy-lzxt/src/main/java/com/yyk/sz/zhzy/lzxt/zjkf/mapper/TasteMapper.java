package com.yyk.sz.zhzy.lzxt.zjkf.mapper;

import com.yyk.sz.zhzy.lzxt.zjkf.entity.Taste;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TasteMapper {
    /**
     * 根据药物编码获取性味
     * @param drugCode
     * @return
     */
    List<Taste> getTasteList(@Param("drugCode") String drugCode);
}
