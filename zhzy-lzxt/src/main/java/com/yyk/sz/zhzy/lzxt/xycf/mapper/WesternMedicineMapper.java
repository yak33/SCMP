package com.yyk.sz.zhzy.lzxt.xycf.mapper;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.lzxt.xycf.entity.WesternMedicine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WesternMedicineMapper {

    public Paging<WesternMedicine> getWesternMedicine(@Param("pageNum") int pageNum,
                                                      @Param("pageSize") int pageSize,
                                                      @Param("searchText") String searchText,
                                                      @Param("sortName") String sortName,
                                                      @Param("sortOrder") String sortOrder);
}

