package com.yyk.sz.zhzy.lzxt.hzlb.mapper;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.lzxt.hzlb.entity.PatientList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PatientListMapper {

    /**
     * 获取患者列表
     *
     * @param treatmentState  0未就诊，1已就诊
     * @return
     */
    Paging<PatientList> getSelectPatientListTable(@Param("treatmentState") String treatmentState,
                                                  @Param("deptcode") String deptcode,
                                                  @Param("pageNum") int pageNum,
                                                  @Param("pageSize") int pageSize,
                                                  @Param("searchText") String searchText,
                                                  @Param("sortName") String sortName,
                                                  @Param("sortOrder") String sortOrder);
}
