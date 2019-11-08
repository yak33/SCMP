package com.yyk.sz.zhzy.lzxt.bzlz.mapper;

import com.yyk.sz.zhzy.lzxt.bzlz.entity.Pulse;
import com.yyk.sz.zhzy.lzxt.bzlz.entity.Tongue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PulseMapper {

    /**
     * 获取脉象（根据主症编码获取对应的脉象）
     *
     * @param mainSymptomCode 主症编码
     * @return
     */
    List<Pulse> getPulseTable(@Param("mainSymptomCode") String mainSymptomCode);
}
