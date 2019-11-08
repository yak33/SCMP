package com.yyk.sz.zhzy.jcsjxt.service;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJChineseMedicine;

import java.util.List;


public interface JCSJChineseMedicineService {
    Paging<JCSJChineseMedicine> getChineseMedicineTable(int pageNum,
                                              int pageSize,
                                              String searchText,
                                              String sortName,
                                              String sortOrder);
    int insertChineseMedicine(JCSJChineseMedicine jcsjChineseMedicine);

    int updateChineseMedicine(JCSJChineseMedicine jcsjChineseMedicine);

    int deleteChineseMedicine(String chinesemedicinecode);

    List<JCSJChineseMedicine> checkChineseMedicineExits(String chinesemedicinecode, String chinesemedicinename);
    List<JCSJChineseMedicine> GetMainSymptomInfoByChineseMedicineCode(String chinesemedicinecode);
    List<JCSJChineseMedicine> GetPrescriptionByChineseMedicineCode(String chinesemedicinecode);

}
