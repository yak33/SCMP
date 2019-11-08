package com.yyk.sz.zhzy.bbxt.mapper;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.bbxt.entity.BBDoctorTreatmentAnalysis;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BBDoctorTreatmentAnalysisMapper {

    Paging<BBDoctorTreatmentAnalysis> getDoctorTreatmentRecord(@Param("beginDate") String beginDate,
                                                               @Param("endDate") String endDate,
                                                               @Param("userCode") String userCode,
                                                               @Param("pageNum") int pageNum,
                                                               @Param("pageSize") int pageSize,
                                                               @Param("searchText") String searchText,
                                                               @Param("sortName") String sortName,
                                                               @Param("sortOrder") String sortOrder);

    List<BBDoctorTreatmentAnalysis> getDoctorTreatmentMoney(@Param("beginDate") String beginDate,
                                                            @Param("endDate") String endDate,
                                                            @Param("userCode") String userCode);

    List<BBDoctorTreatmentAnalysis> getDoctorWorkloadByDate(@Param("beginDate") String beginDate,
                                                            @Param("endDate") String endDate,
                                                            @Param("userCode") String userCode);

    List<BBDoctorTreatmentAnalysis> getDeptWorkloadByTime(@Param("beginDate") String beginDate,
                                                          @Param("endDate") String endDate,
                                                          @Param("userCode") String userCode);


}
