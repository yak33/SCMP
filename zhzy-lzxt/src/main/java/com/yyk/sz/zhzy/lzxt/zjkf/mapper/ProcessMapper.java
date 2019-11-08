package com.yyk.sz.zhzy.lzxt.zjkf.mapper;

import com.yyk.sz.zhzy.lzxt.zjkf.entity.Process;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProcessMapper {
    /**
     * 根据药物编码获取炮制方法
     * @param drugCode
     * @return
     */
    List<Process> getProcessList(@Param("drugCode") String drugCode);
}
