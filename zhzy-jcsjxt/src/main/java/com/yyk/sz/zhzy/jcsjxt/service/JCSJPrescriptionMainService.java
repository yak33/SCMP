package com.yyk.sz.zhzy.jcsjxt.service;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.GetBillCodeRst;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJPrescriptionMain;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJPrescriptionSub;

import java.util.List;


public interface JCSJPrescriptionMainService {
    Paging<JCSJPrescriptionMain> getPrescriptionMainTable(int pageNum,
                                               int pageSize,
                                               String searchText,
                                               String sortName,
                                               String sortOrder);
    Paging<JCSJPrescriptionMain> getPrescriptionZJTable(int pageNum,
                                                          int pageSize,
                                                          String searchText,
                                                          String sortName,
                                                          String sortOrder);
    int insertPrescriptionMain(JCSJPrescriptionMain jcsjPrescriptionMain);
    int insertPrescriptionSub(JCSJPrescriptionSub jcsjPrescriptionSub);

    int updatePrescriptionMain(JCSJPrescriptionMain jcsjPrescriptionMain);

    int deletePrescriptionMain(String prescriptioncode);
    int deletePrescriptionSub(String prescriptioncode);

    List<JCSJPrescriptionMain> checkPrescriptionMainExits(String prescriptioncode, String prescriptionname);
    List<JCSJPrescriptionMain> GetCMedicinePrescription(String prescriptioncode);
    List<JCSJPrescriptionMain> GetPrescriptionMedicine(String prescriptioncode);
    List<JCSJPrescriptionSub> GetPrescriptionMedicineSub(String prescriptioncode);
    List<JCSJPrescriptionMain> GetMaxPrescriptionCode();
    List<JCSJPrescriptionMain> CheckZJPreIsUsedOrNot(String prescriptioncode);

    void getBillCode(JCSJPrescriptionMain jcsjPrescriptionMain);
    List<GetBillCodeRst> getBillCodeRst(String proUUID);
}
