package com.yyk.sz.zhzy.jcsjxt.service;


import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJDrugTaboos;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJPulse;
import com.yyk.sz.zhzy.jcsjxt.mapper.JCSJDrugTaboosMapper;
import com.yyk.sz.zhzy.jcsjxt.mapper.JCSJPulseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class JCSJDrugTaboosServiceImpl implements JCSJDrugTaboosService {


    @Autowired
    private JCSJDrugTaboosMapper jcsjDrugTaboosMapper;

    @Override
    public Paging<JCSJDrugTaboos> getDrugTaboosTable(String drugtaboostype, String drugname, int pageNum, int pageSize, String searchText, String sortName, String sortOrder) {
        return jcsjDrugTaboosMapper.getDrugTaboosTable(drugtaboostype, drugname, pageNum, pageSize, searchText, sortName, sortOrder);
    }

    @Override
    public int deleteDrugTaboos(String drugtaboostype, String drugcode, String drugcodeone) {
        return jcsjDrugTaboosMapper.deleteDrugTaboos(drugtaboostype, drugcode, drugcodeone);
    }

    @Override
    public int insertDrugTaboos(JCSJDrugTaboos jcsjDrugTaboos) {
        return jcsjDrugTaboosMapper.insertDrugTaboos(jcsjDrugTaboos);
    }

    @Override
    public int updateDrugTaboos(JCSJDrugTaboos jcsjDrugTaboos) {
        return jcsjDrugTaboosMapper.updateDrugTaboos(jcsjDrugTaboos);
    }

    @Override
    public List<JCSJDrugTaboos> GetDrugAnti(String drugtaboostype, String drugcode, String drugcodeone) {
        return jcsjDrugTaboosMapper.GetDrugAnti(drugtaboostype, drugcode, drugcodeone);
    }

    @Override
    public List<JCSJDrugTaboos> GetDrugSM(String drugtaboostype, String drugcode) {
        return jcsjDrugTaboosMapper.GetDrugSM(drugtaboostype, drugcode);
    }

    @Override
    public List<JCSJDrugTaboos> GetDrugToaboosQuanitity(String drugtaboostype, String drugcode) {
        return jcsjDrugTaboosMapper.GetDrugToaboosQuanitity(drugtaboostype, drugcode);
    }
}
