package com.yyk.sz.zhzy.lzxt.bzlz.mapper;

import com.yyk.sz.zhzy.lzxt.bzlz.entity.Disease;
import com.yyk.sz.zhzy.lzxt.bzlz.entity.Tongue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TongueMapper {

    /**
     * 获取舌像（根据主症编码获取对应的舌像）
     *
     * @param mainSymptomCode 主症编码
     * @return
     */
    List<Tongue> getTongueTable(@Param("mainSymptomCode") String mainSymptomCode);
}
