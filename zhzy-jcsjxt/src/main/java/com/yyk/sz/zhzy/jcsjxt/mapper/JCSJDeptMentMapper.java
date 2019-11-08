package com.yyk.sz.zhzy.jcsjxt.mapper;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJDeptMent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JCSJDeptMentMapper {

    int deleteDeptMent(String deptcode);

    int insertDeptMent(JCSJDeptMent record);

    int updateDeptMent(JCSJDeptMent record);

    int deleteDepartmentMainSymptom(String deptcode);

    Paging<JCSJDeptMent> getDeptMentTable(@Param("pageNum") int pageNum,
                                       @Param("pageSize") int pageSize,
                                       @Param("searchText") String searchText,
                                       @Param("sortName") String sortName,
                                       @Param("sortOrder") String sortOrder);

    List<JCSJDeptMent> checkDeptMentExits(@Param("deptcode") String deptcode, @Param("deptname") String deptname);

    int insertDepartmentMainSymptom(@Param("deptcode") String deptcode, @Param("mainsymptomcode") String mainsymptomcode);

    List<JCSJDeptMent> GetUserByDeptCode(@Param("deptcode") String deptcode);
    List<JCSJDeptMent> getMainSymptomByDeptCode(@Param("deptcode") String deptcode);
}