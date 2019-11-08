package com.yyk.sz.zhzy.jcsjxt.service;


import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJMainSymptomType;
import com.yyk.sz.zhzy.jcsjxt.mapper.JCSJMainSymptomTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class JCSJMainSymptomTypeServiceImpl implements JCSJMainSymptomTypeService {


    @Autowired
    private JCSJMainSymptomTypeMapper jcsjMainSymptomTypeMapper;

    @Override
    public Paging<JCSJMainSymptomType> getMainSymptomTypeTable(int pageNum,
                                                          int pageSize,
                                                          String searchText,
                                                          String sortName,
                                                          String sortOrder) {
        return jcsjMainSymptomTypeMapper.getMainSymptomTypeTable(pageNum, pageSize, searchText, sortName, sortOrder);
    }

    @Override
    public int insertMainSymptomType(JCSJMainSymptomType jcsjMainSymptomType) {
        return jcsjMainSymptomTypeMapper.insertMainSymptomType(jcsjMainSymptomType);
    }

    @Override
    public int updateMainSymptomType(JCSJMainSymptomType jcsjMainSymptomType) {
        return jcsjMainSymptomTypeMapper.updateMainSymptomType(jcsjMainSymptomType);
    }

    @Override
    public int deleteMainSymptomType(String mainsymptomtypecode) {
        return jcsjMainSymptomTypeMapper.deleteMainSymptomType(mainsymptomtypecode);
    }

    @Override
    public List<JCSJMainSymptomType> GetMainSymptomByMainSymptomTypeCode(String mainsymptomtypecode) {
        return jcsjMainSymptomTypeMapper.GetMainSymptomByMainSymptomTypeCode(mainsymptomtypecode);
    }

    @Override
    public List<JCSJMainSymptomType> checkMainSymptomTypeExits(String mainsymptomtypecode, String mainsymptomtypename) {
        return jcsjMainSymptomTypeMapper.checkMainSymptomTypeExits(mainsymptomtypecode,mainsymptomtypename);
    }
}
