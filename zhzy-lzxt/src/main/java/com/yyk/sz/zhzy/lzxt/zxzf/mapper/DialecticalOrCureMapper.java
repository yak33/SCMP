package com.yyk.sz.zhzy.lzxt.zxzf.mapper;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.lzxt.zxzf.entity.DialecticalOrCure;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DialecticalOrCureMapper {

    /**
     * 根据所属部门和用户账号查询症型治法
     *
     * @param deptCode
     * @param userCode
     * @return
     */
    public Paging<DialecticalOrCure> getSelectDCTable(
            @Param("deptCode") String deptCode,
            @Param("userCode") String userCode,
            @Param("dialectical") String dialectical,
            @Param("chineseMedicine") String chineseMedicine,
            @Param("pageNum") int pageNum,
            @Param("pageSize") int pageSize,
            @Param("searchText") String searchText,
            @Param("sortName") String sortName,
            @Param("sortOrder") String sortOrder
            );
}
