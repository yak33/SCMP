package com.yyk.sz.zhzy.jcsjxt.service;


import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJPrescriptionClassify;
import com.yyk.sz.zhzy.jcsjxt.mapper.JCSJPrescriptionClassifyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class JCSJPrescriptionClassifyServiceImpl implements JCSJPrescriptionClassifyService {


    @Autowired
    private JCSJPrescriptionClassifyMapper jcsjPrescriptionClassifyMapper;

    @Override
    public Paging<JCSJPrescriptionClassify> getPrescriptionClassifyTable(int pageNum,
                                                          int pageSize,
                                                          String searchText,
                                                          String sortName,
                                                          String sortOrder) {
        return jcsjPrescriptionClassifyMapper.getPrescriptionClassifyTable(pageNum, pageSize, searchText, sortName, sortOrder);
    }

    @Override
    public int insertPrescriptionClassify(JCSJPrescriptionClassify jcsjPrescriptionClassify) {
        return jcsjPrescriptionClassifyMapper.insertPrescriptionClassify(jcsjPrescriptionClassify);
    }

    @Override
    public int updatePrescriptionClassify(JCSJPrescriptionClassify jcsjPrescriptionClassify) {
        return jcsjPrescriptionClassifyMapper.updatePrescriptionClassify(jcsjPrescriptionClassify);
    }

    @Override
    public int deletePrescriptionClassify(String pccode) {
        return jcsjPrescriptionClassifyMapper.deletePrescriptionClassify(pccode);
    }

    @Override
    public List<JCSJPrescriptionClassify> checkPrescriptionClassifyExits(String pccode, String pcname) {
        return jcsjPrescriptionClassifyMapper.checkPrescriptionClassifyExits(pccode, pcname);
    }

    @Override
    public List<JCSJPrescriptionClassify> GetPrescriptionByPCCode(String pccode) {
        return jcsjPrescriptionClassifyMapper.GetPrescriptionByPCCode(pccode);
    }
}
