package com.yyk.sz.zhzy.lzxt.zjkf.mapper;

import com.yyk.sz.zhzy.lzxt.zjkf.entity.Meridian;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface MeridianMapper {
    /**
     * 根据药物编码获取归经
     * @param drugCode
     * @return
     */
    List<Meridian> getMeridianList(@Param("drugCode") String drugCode);
}
