package com.yyk.sz.zhzy.lzxt.xycf.service;


import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.lzxt.xycf.entity.WesternMedicine;
import com.yyk.sz.zhzy.lzxt.xycf.mapper.WesternMedicineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class WesternMedicineServiceImpl implements WesternMedicineService {


    @Autowired
    private WesternMedicineMapper westernMedicineMapper;

    @Override
    public Paging<WesternMedicine> getWesternMedicine(int pageNum,
                                                      int pageSize,
                                                      String searchText,
                                                      String sortName,
                                                      String sortOrder) {
        return westernMedicineMapper.getWesternMedicine(pageNum, pageSize, searchText, sortName, sortOrder);
    }
}
