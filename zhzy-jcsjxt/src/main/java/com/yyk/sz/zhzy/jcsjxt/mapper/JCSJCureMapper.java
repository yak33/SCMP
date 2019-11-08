package com.yyk.sz.zhzy.jcsjxt.mapper;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJCure;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JCSJCureMapper {

    int deleteCure(String curecode);

    int insertCure(JCSJCure record);

    int updateCure(JCSJCure record);
    Paging<JCSJCure> getCureTable(@Param("pageNum") int pageNum,
                                   @Param("pageSize") int pageSize,
                                   @Param("searchText") String searchText,
                                   @Param("sortName") String sortName,
                                   @Param("sortOrder") String sortOrder);
    List<JCSJCure> checkCureExits(@Param("curecode") String curecode, @Param("curename") String curename);
    List<JCSJCure> GetCureDialecticalRelation(@Param("curecode") String curecode);

}