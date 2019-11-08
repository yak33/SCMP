package com.yyk.sz.zhzy.jcsjxt.mapper;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJDrugDict;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJUnit;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JCSJUnitMapper {

    int deleteUnit(@Param("unitCode") Integer unitCode);

    int insertUnit(JCSJUnit record);

    Paging<JCSJUnit> getUnitList(@Param("unitCode") String unitCode,
                                 @Param("unitName") String unitName, @Param("pageNum") int pageNum,
                                 @Param("pageSize") int pageSize,
                                 @Param("searchText") String searchText,
                                 @Param("sortName") String sortName,
                                 @Param("sortOrder") String sortOrder);

    int updateUnit(JCSJUnit record);

    List<JCSJUnit> GetUnitByUnitCode(JCSJUnit record);

    List<JCSJUnit> GetUnitByUnitName(@Param("unitName") String unitName);

    List<JCSJDrugDict> GetDrugByUnitCode(@Param("unitCode") Integer unitCode);

}