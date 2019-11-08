package com.yyk.sz.zhzy.jcsjxt.service;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJWesternMedicine;

import java.util.List;


public interface JCSJWesternMedicineService {
    Paging<JCSJWesternMedicine> getWesternMedicineTable(int pageNum,
                                    int pageSize,
                                    String searchText,
                                    String sortName,
                                    String sortOrder);
    int insertWesternMedicine(JCSJWesternMedicine jcsjWesternMedicine);

    int updateWesternMedicine(JCSJWesternMedicine jcsjWesternMedicine);

    int deleteWesternMedicine(String westernmedicinecode);

    List<JCSJWesternMedicine> checkWesternMedicineExits(String westernmedicinecode, String westernmedicinename);
    List<JCSJWesternMedicine> GetMainSymptomInfoByWesternMedicineCode(String westernmedicinecode);

}
