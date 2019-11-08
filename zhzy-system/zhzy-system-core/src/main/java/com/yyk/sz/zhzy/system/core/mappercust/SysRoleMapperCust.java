package com.yyk.sz.zhzy.system.core.mappercust;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.system.core.entity.SysRole;
import com.yyk.sz.zhzy.system.core.entity.SysRoleExample;
import com.yyk.sz.zhzy.system.core.mapper.SysRoleMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleMapperCust extends SysRoleMapper {

    /**
     * 分页查询
     */
    public Paging<SysRole> listPage(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize, @Param("sortType") String sortType, @Param("name") String name);
}