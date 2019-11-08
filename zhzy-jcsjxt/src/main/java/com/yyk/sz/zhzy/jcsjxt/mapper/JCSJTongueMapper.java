package com.yyk.sz.zhzy.jcsjxt.mapper;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJTongue;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JCSJTongueMapper {

    int deleteTongue(String tonguecode);

    int insertTongue(JCSJTongue record);

    int updateTongue(JCSJTongue record);

    Paging<JCSJTongue> getTongueTable(@Param("pageNum") int pageNum,
                                       @Param("pageSize") int pageSize,
                                       @Param("searchText") String searchText,
                                       @Param("sortName") String sortName,
                                       @Param("sortOrder") String sortOrder);
    List<JCSJTongue> checkTongueExits(@Param("tonguecode") String tonguecode, @Param("tonguename") String tonguename);
    List<JCSJTongue> GetMainTongueByTongueCode(@Param("tonguecode") String tonguecode);
}