package com.yyk.sz.zhzy.jcsjxt.service;


import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJWesternMedicine;
import com.yyk.sz.zhzy.jcsjxt.mapper.JCSJWesternMedicineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class JCSJWesternMedicineServiceImpl implements JCSJWesternMedicineService {


    @Autowired
    private JCSJWesternMedicineMapper jcsjWesternMedicineMapper;

    @Override
    public Paging<JCSJWesternMedicine> getWesternMedicineTable(int pageNum,
                                                     int pageSize,
                                                     String searchText,
                                                     String sortName,
                                                     String sortOrder) {
        return jcsjWesternMedicineMapper.getWesternMedicineTable(pageNum, pageSize, searchText, sortName, sortOrder);
    }

    @Override
    public int insertWesternMedicine(JCSJWesternMedicine jcsjWesternMedicine) {
        return jcsjWesternMedicineMapper.insertWesternMedicine(jcsjWesternMedicine);
    }

    @Override
    public int updateWesternMedicine(JCSJWesternMedicine jcsjWesternMedicine) {
        return jcsjWesternMedicineMapper.updateWesternMedicine(jcsjWesternMedicine);
    }

    @Override
    public int deleteWesternMedicine(String westernmedicinecode) {
        return jcsjWesternMedicineMapper.deleteWesternMedicine(westernmedicinecode);
    }

    @Override
    public List<JCSJWesternMedicine> checkWesternMedicineExits(String westernmedicinecode, String westernmedicinename) {
        return jcsjWesternMedicineMapper.checkWesternMedicineExits(westernmedicinecode, westernmedicinename);
    }

    @Override
    public List<JCSJWesternMedicine> GetMainSymptomInfoByWesternMedicineCode(String westernmedicinecode) {
        return jcsjWesternMedicineMapper.GetMainSymptomInfoByWesternMedicineCode(westernmedicinecode);
    }
}
