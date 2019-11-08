package com.yyk.sz.zhzy.jcsjxt.service;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJDiseasesClassify;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJPulse;

import java.util.List;


public interface JCSJDiseasesClassifyService {
    Paging<JCSJDiseasesClassify> getDiseasesClassifyTable(int pageNum,
                                               int pageSize,
                                               String searchText,
                                               String sortName,
                                               String sortOrder);
    int insertDiseasesClassify(JCSJDiseasesClassify jcsjDiseasesClassify);

    int updateDiseasesClassify(JCSJDiseasesClassify jcsjDiseasesClassify);

    int deleteDiseasesClassify(String dccode);

    int deleteDiseasesClassifyCMedicine(String dccode);

    int insertDiseasesClassifyCMedicine(String dccode, String chinesemedicinecode);

    List<JCSJDiseasesClassify> checkDiseasesClassifyExits(String dccode, String dcname);
    List<JCSJDiseasesClassify> GetDClassifyCMedicineByDCCode(String dccode);
    List<JCSJDiseasesClassify> getChineseMedicineByDCCode(String dccode);
}
