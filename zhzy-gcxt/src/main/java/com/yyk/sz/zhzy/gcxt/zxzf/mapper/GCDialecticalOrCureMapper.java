package com.yyk.sz.zhzy.gcxt.zxzf.mapper;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.gcxt.zxzf.entity.GCDialecticalOrCure;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GCDialecticalOrCureMapper {

    /**
     * 根据所属部门和用户账号查询症型治法
     *
     * @return
     */
    public Paging<GCDialecticalOrCure> getSelectAnorectalDialecticalCure(
            @Param("westernMedicineName") String westernMedicineName,
            @Param("pageNum") int pageNum,
            @Param("pageSize") int pageSize,
            @Param("searchText") String searchText,
            @Param("sortName") String sortName,
            @Param("sortOrder") String sortOrder
    );
}
