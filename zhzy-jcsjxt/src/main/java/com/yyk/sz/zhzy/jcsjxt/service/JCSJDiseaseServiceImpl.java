package com.yyk.sz.zhzy.jcsjxt.service;


import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJDisease;
import com.yyk.sz.zhzy.jcsjxt.mapper.JCSJDiseaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class JCSJDiseaseServiceImpl implements JCSJDiseaseService {


    @Autowired
    private JCSJDiseaseMapper jcsjDiseaseMapper;

    @Override
    public Paging<JCSJDisease> getDiseaseTable(int pageNum,
                                               int pageSize,
                                               String searchText,
                                               String sortName,
                                               String sortOrder) {
        return jcsjDiseaseMapper.getDiseaseTable(pageNum, pageSize, searchText, sortName, sortOrder);
    }

    @Override
    public int insertDisease(JCSJDisease jcsjDisease) {
        return jcsjDiseaseMapper.insertDisease(jcsjDisease);
    }

    @Override
    public int updateDisease(JCSJDisease jcsjDisease) {
        return jcsjDiseaseMapper.updateDisease(jcsjDisease);
    }

    @Override
    public int deleteDisease(String diseasecode) {
        return jcsjDiseaseMapper.deleteDisease(diseasecode);
    }

    @Override
    public List<JCSJDisease> checkDiseaseExits(String diseasecode, String diseasename) {
        return jcsjDiseaseMapper.checkDiseaseExits(diseasecode, diseasename);
    }

    @Override
    public int deleteMeridianMainSymptom(String strtable, String diseasecode) {
        return jcsjDiseaseMapper.deleteMeridianMainSymptom(strtable, diseasecode);
    }

    @Override
    public int insertMeridianMainSymptom(String strtable, String diseasecode, String cloum, String code) {
        return jcsjDiseaseMapper.insertMeridianMainSymptom(strtable, diseasecode, cloum, code);
    }

    @Override
    public List<JCSJDisease> GetDiseaseMainSymptomRelation(String diseasecode) {
        return jcsjDiseaseMapper.GetDiseaseMainSymptomRelation(diseasecode);
    }

    @Override
    public List<JCSJDisease> GetDiseaseDialecticalRelation(String diseasecode) {
        return jcsjDiseaseMapper.GetDiseaseDialecticalRelation(diseasecode);
    }
}
