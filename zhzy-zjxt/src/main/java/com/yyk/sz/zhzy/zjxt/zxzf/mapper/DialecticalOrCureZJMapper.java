package com.yyk.sz.zhzy.zjxt.zxzf.mapper;

import com.yyk.sz.zhzy.zjxt.zxzf.entity.DialecticalOrCureZJ;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: ZhangChao
 * @Date: 2018/11/30 14:52
 * @Version: 1.0
 */
@Mapper
public interface DialecticalOrCureZJMapper {

    List<DialecticalOrCureZJ> getDrugSolution(@Param("acupointCode") String acupointCode);

    List<DialecticalOrCureZJ> getKaiXue(@Param("fdC6") String fdC6, @Param("fdC7") String fdC7, @Param("fdC10") String fdC10);

    List<DialecticalOrCureZJ> getBiXue(@Param("fdC6") String fdC6, @Param("fdC7") String fdC7, @Param("fdC10") String fdC10);
}
