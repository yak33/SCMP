package com.yyk.sz.zhzy.jcsjxt.mapper;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.GetBillCodeRst;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJPrescriptionMain;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JCSJPrescriptionMainMapper {

    Paging<JCSJPrescriptionMain> getPrescriptionMainTable(@Param("pageNum") int pageNum,
                                                          @Param("pageSize") int pageSize,
                                                          @Param("searchText") String searchText,
                                                          @Param("sortName") String sortName,
                                                          @Param("sortOrder") String sortOrder);
    Paging<JCSJPrescriptionMain> getPrescriptionZJTable(@Param("pageNum") int pageNum,
                                                          @Param("pageSize") int pageSize,
                                                          @Param("searchText") String searchText,
                                                          @Param("sortName") String sortName,
                                                          @Param("sortOrder") String sortOrder);

    int deletePrescriptionMain(@Param("prescriptioncode") String prescriptioncode);
    int deletePrescriptionSub(@Param("prescriptioncode") String prescriptioncode);


    int insertPrescriptionMain(JCSJPrescriptionMain record);

    int updatePrescriptionMain(JCSJPrescriptionMain record);

    List<JCSJPrescriptionMain> checkPrescriptionMainExits(@Param("prescriptioncode") String prescriptioncode, @Param("prescriptionname") String prescriptionname);

    List<JCSJPrescriptionMain> GetCMedicinePrescription(@Param("prescriptioncode") String prescriptioncode);

    List<JCSJPrescriptionMain> GetPrescriptionMedicine(@Param("prescriptioncode") String prescriptioncode);

    List<JCSJPrescriptionMain> GetMaxPrescriptionCode();

    void getBillCode(JCSJPrescriptionMain jcsjPrescriptionMain);

    List<GetBillCodeRst> getBillCodeRst(@Param("proUUID") String proUUID);

    List<JCSJPrescriptionMain> CheckZJPreIsUsedOrNot(@Param("prescriptioncode") String prescriptioncode);
}