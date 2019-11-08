package com.yyk.sz.zhzy.system.core.mappercust;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.system.core.entity.GyUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserMapperCust {

    /**
     * 分页查询
     */
    public Paging<GyUser> listPage(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize,
                                   @Param("sortType") String sortType, @Param("searchText") String searchText);
}