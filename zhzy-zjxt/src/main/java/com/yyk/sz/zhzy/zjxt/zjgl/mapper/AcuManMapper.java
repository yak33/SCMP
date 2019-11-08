package com.yyk.sz.zhzy.zjxt.zjgl.mapper;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.zjxt.zjgl.entity.AcuMan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 针灸管理
 *
 * @Author: ZhangChao
 * @Date: 2019/2/19 11:50
 * @Version: 1.0
 */
@Mapper
public interface AcuManMapper {

    Paging<AcuMan> getAcuManAll(@Param("pageNum") int pageNum,
                              @Param("pageSize") int pageSize,
                              @Param("searchText") String searchText,
                              @Param("sortName") String sortName,
                              @Param("sortOrder") String sortOrder);

    Paging<AcuMan> getAcuManNoList(@Param("pageNum") int pageNum,
                                   @Param("pageSize") int pageSize,
                                   @Param("searchText") String searchText,
                                   @Param("sortName") String sortName,
                                   @Param("sortOrder") String sortOrder);

    Paging<AcuMan> getAcuManYesList(@Param("pageNum") int pageNum,
                                  @Param("pageSize") int pageSize,
                                  @Param("searchText") String searchText,
                                  @Param("sortName") String sortName,
                                  @Param("sortOrder") String sortOrder,
                                  @Param("strDateTime") String strDateTime);

    Paging<AcuMan> getAcuManIngList(@Param("pageNum") int pageNum,
                                    @Param("pageSize") int pageSize,
                                    @Param("searchText") String searchText,
                                    @Param("sortName") String sortName,
                                    @Param("sortOrder") String sortOrder,
                                    @Param("strDateTime") String strDateTime);

    int updateZZDateTime(AcuMan acuMan);
}
