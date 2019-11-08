package com.yyk.sz.zhzy.lzxt.jyjc.mapper;

import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysFinancialDetail;

import java.util.List;

public interface SysFinancialDetailMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(SysFinancialDetail record);

    int insertSelective(SysFinancialDetail record);

    SysFinancialDetail selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(SysFinancialDetail record);

    int updateByPrimaryKey(SysFinancialDetail record);

    int delFinancialDetail(SysFinancialDetail record);

    List<SysFinancialDetail> getItemDetail(SysFinancialDetail record);
}