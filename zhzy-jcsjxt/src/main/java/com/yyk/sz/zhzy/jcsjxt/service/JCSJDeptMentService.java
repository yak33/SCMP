package com.yyk.sz.zhzy.jcsjxt.service;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJDeptMent;

import java.util.List;


public interface JCSJDeptMentService {
    Paging<JCSJDeptMent> getDeptMentTable(int pageNum,
                                       int pageSize,
                                       String searchText,
                                       String sortName,
                                       String sortOrder);
    int insertDeptMent(JCSJDeptMent jcsjDeptMent);

    int updateDeptMent(JCSJDeptMent jcsjDeptMent);

    int deleteDeptMent(String deptcode);

    int deleteDepartmentMainSymptom(String deptcode);

    int insertDepartmentMainSymptom(String deptcode, String mainsymptomcode);

    List<JCSJDeptMent> checkDeptMentExits(String deptcode, String deptname);
    List<JCSJDeptMent> GetUserByDeptCode(String deptcode);
    List<JCSJDeptMent> getMainSymptomByDeptCode(String deptcode);

}
