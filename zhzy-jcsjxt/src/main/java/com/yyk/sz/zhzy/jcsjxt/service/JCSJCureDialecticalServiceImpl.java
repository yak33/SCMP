package com.yyk.sz.zhzy.jcsjxt.service;


import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJCureDialectical;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJMainSymptom;
import com.yyk.sz.zhzy.jcsjxt.mapper.JCSJCureDialecticalMapper;
import com.yyk.sz.zhzy.jcsjxt.mapper.JCSJMainSymptomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class JCSJCureDialecticalServiceImpl implements JCSJCureDialecticalService {


    @Autowired
    private JCSJCureDialecticalMapper jcsjCureDialecticalMapper;

    @Override
    public Paging<JCSJCureDialectical> GetCureDialecticalTable(int pageNum,
                                                           int pageSize,
                                                           String searchText,
                                                           String sortName,
                                                           String sortOrder) {
        return jcsjCureDialecticalMapper.GetCureDialecticalTable(pageNum, pageSize, searchText, sortName, sortOrder);
    }

    @Override
    public int insertCureDialectical(JCSJCureDialectical jcsjCureDialectical) {
        return jcsjCureDialecticalMapper.insertCureDialectical(jcsjCureDialectical);
    }

    @Override
    public int insertDialecticalMainSymptom(JCSJCureDialectical jcsjCureDialectical) {
        return jcsjCureDialecticalMapper.insertDialecticalMainSymptom(jcsjCureDialectical);
    }

    @Override
    public int updateCureDialectical(JCSJCureDialectical jcsjCureDialectical) {
        return jcsjCureDialecticalMapper.updateCureDialectical(jcsjCureDialectical);
    }

    @Override
    public int deleteCureDialectical(String strtable,String dialecticalcode,String mainsymptomcode) {
        return jcsjCureDialecticalMapper.deleteCureDialectical(strtable,dialecticalcode,mainsymptomcode);
    }

    @Override
    public int insertMainSymptomAll(String strtable, String mainsymptomcode, String cloum, String code) {
        return 0;
    }

    @Override
    public List<JCSJCureDialectical> GetDialecticalCureRelation(String dialecticalcode,String mainsymptomcode) {
        return jcsjCureDialecticalMapper.GetDialecticalCureRelation(dialecticalcode,mainsymptomcode);
    }

    @Override
    public List<JCSJCureDialectical> CheckSingleInfo(String dialecticalcode, String mainsymptomcode) {
        return jcsjCureDialecticalMapper.CheckSingleInfo(dialecticalcode,mainsymptomcode);
    }

    @Override
    public void dialecticalDiseaseCurePrescription_SP(JCSJCureDialectical jcsjCureDialectical) {
        jcsjCureDialecticalMapper.dialecticalDiseaseCurePrescription_SP(jcsjCureDialectical);
    }

    @Override
    public int updateDialecticalMainSymptom(JCSJCureDialectical jcsjCureDialectical) {
        return jcsjCureDialecticalMapper.updateDialecticalMainSymptom(jcsjCureDialectical);
    }

    @Override
    public List<JCSJCureDialectical> GetDiseaseByMainSymptomCode(String mainsymptomcode) {
        return jcsjCureDialecticalMapper.GetDiseaseByMainSymptomCode(mainsymptomcode);
    }

    @Override
    public List<JCSJCureDialectical> GetCureAndPreListBycode(String dialecticalcode, String mainsymptomcode) {
        return jcsjCureDialecticalMapper.GetCureAndPreListBycode(dialecticalcode,mainsymptomcode);
    }

    @Override
    public List<JCSJCureDialectical> GetDiseaseByDialecticalAndMainSymptomCode(String dialecticalcode, String mainsymptomcode) {
        return jcsjCureDialecticalMapper.GetDiseaseByDialecticalAndMainSymptomCode(dialecticalcode,mainsymptomcode);
    }

    @Override
    public List<JCSJCureDialectical> GetWesternTable(String dialecticalcode, String mainsymptomcode) {
        return jcsjCureDialecticalMapper.GetWesternTable(dialecticalcode,mainsymptomcode);
    }
}
