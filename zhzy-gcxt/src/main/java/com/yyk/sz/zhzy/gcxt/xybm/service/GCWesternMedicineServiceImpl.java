package com.yyk.sz.zhzy.gcxt.xybm.service;


import com.yyk.sz.zhzy.gcxt.xybm.entity.GCWesternMedicine;
import com.yyk.sz.zhzy.gcxt.xybm.mapper.GCWesternMedicineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class GCWesternMedicineServiceImpl implements WesternMedicineService {


    @Autowired
    private GCWesternMedicineMapper gcwesternMedicineMapper;

    @Override
    public List<GCWesternMedicine> getAllWesternMedicineName(String searchText){
        return gcwesternMedicineMapper.getAllWesternMedicineName(searchText);
    }
}
