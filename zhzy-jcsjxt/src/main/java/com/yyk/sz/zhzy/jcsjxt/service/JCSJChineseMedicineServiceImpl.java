package com.yyk.sz.zhzy.jcsjxt.service;


import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJChineseMedicine;
import com.yyk.sz.zhzy.jcsjxt.mapper.JCSJChineseMedicineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class JCSJChineseMedicineServiceImpl implements JCSJChineseMedicineService {


    @Autowired
    private JCSJChineseMedicineMapper jcsjChineseMedicineMapper;

    @Override
    public Paging<JCSJChineseMedicine> getChineseMedicineTable(int pageNum,
                                                     int pageSize,
                                                     String searchText,
                                                     String sortName,
                                                     String sortOrder) {
        return jcsjChineseMedicineMapper.getChineseMedicineTable(pageNum, pageSize, searchText, sortName, sortOrder);
    }

    @Override
    public int insertChineseMedicine(JCSJChineseMedicine jcsjChineseMedicine) {
        return jcsjChineseMedicineMapper.insertChineseMedicine(jcsjChineseMedicine);
    }

    @Override
    public int updateChineseMedicine(JCSJChineseMedicine jcsjChineseMedicine) {
        return jcsjChineseMedicineMapper.updateChineseMedicine(jcsjChineseMedicine);
    }

    @Override
    public int deleteChineseMedicine(String chinesemedicinecode) {
        return jcsjChineseMedicineMapper.deleteChineseMedicine(chinesemedicinecode);
    }

    @Override
    public List<JCSJChineseMedicine> checkChineseMedicineExits(String chinesemedicinecode, String chinesemedicinename) {
        return jcsjChineseMedicineMapper.checkChineseMedicineExits(chinesemedicinecode, chinesemedicinename);
    }

    @Override
    public List<JCSJChineseMedicine> GetMainSymptomInfoByChineseMedicineCode(String chinesemedicinecode) {
        return jcsjChineseMedicineMapper.GetMainSymptomInfoByChineseMedicineCode(chinesemedicinecode);
    }

    @Override
    public List<JCSJChineseMedicine> GetPrescriptionByChineseMedicineCode(String chinesemedicinecode) {
        return jcsjChineseMedicineMapper.GetPrescriptionByChineseMedicineCode(chinesemedicinecode);
    }
}
