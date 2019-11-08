package com.yyk.sz.zhzy.jcsjxt.service;


import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJDeptMent;
import com.yyk.sz.zhzy.jcsjxt.mapper.JCSJDeptMentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class JCSJDeptMentServiceImpl implements JCSJDeptMentService {


    @Autowired
    private JCSJDeptMentMapper jcsjDeptMentMapper;

    @Override
    public Paging<JCSJDeptMent> getDeptMentTable(int pageNum,
                                              int pageSize,
                                              String searchText,
                                              String sortName,
                                              String sortOrder) {
        return jcsjDeptMentMapper.getDeptMentTable(pageNum, pageSize, searchText, sortName, sortOrder);
    }

    @Override
    public int insertDeptMent(JCSJDeptMent jcsjDeptMent) {
        return jcsjDeptMentMapper.insertDeptMent(jcsjDeptMent);
    }

    @Override
    public int updateDeptMent(JCSJDeptMent jcsjDeptMent) {
        return jcsjDeptMentMapper.updateDeptMent(jcsjDeptMent);
    }

    @Override
    public int deleteDeptMent(String deptcode) {
        return jcsjDeptMentMapper.deleteDeptMent(deptcode);
    }

    @Override
    public List<JCSJDeptMent> checkDeptMentExits(String deptcode, String deptname) {
        return jcsjDeptMentMapper.checkDeptMentExits(deptcode, deptname);
    }

    @Override
    public List<JCSJDeptMent> GetUserByDeptCode(String deptcode) {
        return jcsjDeptMentMapper.GetUserByDeptCode(deptcode);
    }

    @Override
    public int insertDepartmentMainSymptom(String deptcode, String mainsymptomcode) {
        return jcsjDeptMentMapper.insertDepartmentMainSymptom(deptcode,mainsymptomcode);
    }

    @Override
    public int deleteDepartmentMainSymptom(String deptcode) {
        return jcsjDeptMentMapper.deleteDepartmentMainSymptom(deptcode);
    }

    @Override
    public List<JCSJDeptMent> getMainSymptomByDeptCode(String deptcode) {
        return jcsjDeptMentMapper.getMainSymptomByDeptCode(deptcode);
    }
}
