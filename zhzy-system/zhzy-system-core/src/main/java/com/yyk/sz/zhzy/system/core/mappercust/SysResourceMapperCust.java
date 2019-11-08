package com.yyk.sz.zhzy.system.core.mappercust;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.system.core.entity.SysResource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysResourceMapperCust {

    /**
     * 分页查询
     */
    public Paging<SysResource> listPage(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize, @Param("sortType") String sortType);
}