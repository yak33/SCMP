package com.yyk.sz.zhzy.jcsjxt.service;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJPrescriptionClassify;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJPulse;

import java.util.List;


public interface JCSJPrescriptionClassifyService {
    Paging<JCSJPrescriptionClassify> getPrescriptionClassifyTable(int pageNum,
                                                   int pageSize,
                                                   String searchText,
                                                   String sortName,
                                                   String sortOrder);
    int insertPrescriptionClassify(JCSJPrescriptionClassify jcsjPrescriptionClassify);

    int updatePrescriptionClassify(JCSJPrescriptionClassify jcsjPrescriptionClassify);

    int deletePrescriptionClassify(String pccode);

    List<JCSJPrescriptionClassify> checkPrescriptionClassifyExits(String pccode, String pulsename);
    List<JCSJPrescriptionClassify> GetPrescriptionByPCCode(String pccode);

}
