package com.yyk.sz.zhzy.jcsjxt.service;


import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJMainSymptom;
import com.yyk.sz.zhzy.jcsjxt.mapper.JCSJMainSymptomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class JCSJMainSymptomServiceImpl implements JCSJMainSymptomService {


    @Autowired
    private JCSJMainSymptomMapper jcsjMainSymptomMapper;

    @Override
    public Paging<JCSJMainSymptom> getMainSymptomTable(int pageNum,
                                                          int pageSize,
                                                          String searchText,
                                                          String sortName,
                                                          String sortOrder) {
        return jcsjMainSymptomMapper.getMainSymptomTable(pageNum, pageSize, searchText, sortName, sortOrder);
    }

    @Override
    public int insertMainSymptom(JCSJMainSymptom jcsjMainSymptomType) {
        return jcsjMainSymptomMapper.insertMainSymptom(jcsjMainSymptomType);
    }

    @Override
    public int insertMainSymptomAll(String strtable, String mainsymptomcode, String cloum, String code) {
        return jcsjMainSymptomMapper.insertMainSymptomAll(strtable,mainsymptomcode,cloum,code);
    }

    @Override
    public int updateMainSymptom(JCSJMainSymptom jcsjMainSymptomType) {
        return jcsjMainSymptomMapper.updateMainSymptom(jcsjMainSymptomType);
    }

    @Override
    public int deleteMainSymptom(String strtable,String mainsymptomtypecode) {
        return jcsjMainSymptomMapper.deleteMainSymptom(strtable,mainsymptomtypecode);
    }

    @Override
    public List<JCSJMainSymptom> GetMainSymptomDeptRelation(String mainsymptomcode) {
        return jcsjMainSymptomMapper.GetMainSymptomDeptRelation(mainsymptomcode);
    }


    @Override
    public List<JCSJMainSymptom> GetMainSymptomDiseaseRelation(String mainsymptomcode) {
        return jcsjMainSymptomMapper.GetMainSymptomDiseaseRelation(mainsymptomcode);
    }

    @Override
    public List<JCSJMainSymptom> GetCureDialecticalByMainSymptomCode(String mainsymptomcode) {
        return jcsjMainSymptomMapper.GetCureDialecticalByMainSymptomCode(mainsymptomcode);
    }

    @Override
    public List<JCSJMainSymptom> GetSingleMainSymptomByMainSymptomCode(String mainsymptomcode) {
        return jcsjMainSymptomMapper.GetSingleMainSymptomByMainSymptomCode(mainsymptomcode);
    }

    @Override
    public List<JCSJMainSymptom> GetMainSymptomByMainSymptomNameAndMainSymptomTypeCode(String mainsymptomtypecode) {
        return jcsjMainSymptomMapper.GetMainSymptomByMainSymptomNameAndMainSymptomTypeCode(mainsymptomtypecode);
    }

    @Override
    public List<JCSJMainSymptom> GetMainSymptomByMainSymptomCode(String mainsymptomcode) {
        return jcsjMainSymptomMapper.GetMainSymptomByMainSymptomCode(mainsymptomcode);
    }

    @Override
    public List<JCSJMainSymptom> checkMainSymptomExits(String mainsymptomtypecode, String mainsymptomtypename) {
        return jcsjMainSymptomMapper.checkMainSymptomExits(mainsymptomtypecode,mainsymptomtypename);
    }
}
