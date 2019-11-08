package com.yyk.sz.zhzy.lzxt.jyjc.mapper;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysInventory;
import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysInventoryTX;
import org.apache.ibatis.annotations.Param;

public interface SysInventoryMapper {
    int deleteByPrimaryKey(Integer drugcode);

    int insert(SysInventory record);

    int insertSelective(SysInventory record);

    SysInventory selectByPrimaryKey(Integer drugcode);

    int updateByPrimaryKeySelective(SysInventory record);

    int updateByPrimaryKey(SysInventory record);

    Paging<SysInventory> getInventoryAll(@Param("pageNum") int pageNum,
                                      @Param("pageSize") int pageSize,
                                      @Param("searchText") String searchText,
                                      @Param("sortName") String sortName,
                                      @Param("sortOrder") String sortOrder);

    Paging<SysInventoryTX> getWarningList(@Param("pageNum") int pageNum,
                                          @Param("pageSize") int pageSize,
                                          @Param("searchText") String searchText,
                                          @Param("sortName") String sortName,
                                          @Param("sortOrder") String sortOrder);

    int updateInvertory(SysInventory record);

    int updateNewRemain(SysInventory record);

}