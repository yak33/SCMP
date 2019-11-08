package com.yyk.sz.zhzy.jcsjxt.mapper;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJDialectical;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JCSJDialecticalMapper {

    int deleteDialectical(String dialecticalcode);

    int insertDialectical(JCSJDialectical record);

    Paging<JCSJDialectical> getDialecticalTable(@Param("pageNum") int pageNum,
                                          @Param("pageSize") int pageSize,
                                          @Param("searchText") String searchText,
                                          @Param("sortName") String sortName,
                                          @Param("sortOrder") String sortOrder);

    int updateDialectical(JCSJDialectical record);

    List<JCSJDialectical> checkDialecticalExits(@Param("dialecticalcode") String dialecticalcode, @Param("dialecticalname") String dialecticalname);
    List<JCSJDialectical> GetMainSymptomInfoByDialecticalCode(@Param("dialecticalcode") String dialecticalcode);
}