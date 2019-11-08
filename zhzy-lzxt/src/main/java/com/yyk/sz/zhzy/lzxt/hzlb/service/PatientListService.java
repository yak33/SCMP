package com.yyk.sz.zhzy.lzxt.hzlb.service;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.lzxt.hzlb.entity.PatientList;

public interface PatientListService {
    public Paging<PatientList> getSelectPatientListTable(String treatmentState,String deptcode, int pageNum,
                                                         int pageSize,
                                                         String searchText,
                                                         String sortName,
                                                         String sortOrder);
}
