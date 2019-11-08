package com.yyk.sz.zhzy.jcsjxt.service;


import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.GetBillCodeRst;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJPrescriptionMain;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJPrescriptionSub;
import com.yyk.sz.zhzy.jcsjxt.mapper.JCSJPrescriptionMainMapper;
import com.yyk.sz.zhzy.jcsjxt.mapper.JCSJPrescriptionSubMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class JCSJPrescriptionMainServiceImpl implements JCSJPrescriptionMainService {


    @Autowired
    private JCSJPrescriptionMainMapper jcsjPrescriptionMainMapper;

    @Autowired
    private JCSJPrescriptionSubMapper jcsjPrescriptionSubMapper;

    @Override
    public Paging<JCSJPrescriptionMain> getPrescriptionMainTable(int pageNum,
                                                                 int pageSize,
                                                                 String searchText,
                                                                 String sortName,
                                                                 String sortOrder) {
        return jcsjPrescriptionMainMapper.getPrescriptionMainTable(pageNum, pageSize, searchText, sortName, sortOrder);
    }

    @Override
    public Paging<JCSJPrescriptionMain> getPrescriptionZJTable(int pageNum, int pageSize, String searchText, String sortName, String sortOrder) {
        return jcsjPrescriptionMainMapper.getPrescriptionZJTable(pageNum, pageSize, searchText, sortName, sortOrder);
    }

    @Override
    public int insertPrescriptionMain(JCSJPrescriptionMain jcsjPrescriptionMain) {
        return jcsjPrescriptionMainMapper.insertPrescriptionMain(jcsjPrescriptionMain);
    }

    @Override
    public int insertPrescriptionSub(JCSJPrescriptionSub jcsjPrescriptionSub) {
        return jcsjPrescriptionSubMapper.insertPrescriptionSub(jcsjPrescriptionSub);
    }

    @Override
    public int updatePrescriptionMain(JCSJPrescriptionMain jcsjPrescriptionMain) {
        return jcsjPrescriptionMainMapper.updatePrescriptionMain(jcsjPrescriptionMain);
    }

    @Override
    public int deletePrescriptionMain(String prescriptioncode) {
        return jcsjPrescriptionMainMapper.deletePrescriptionMain(prescriptioncode);
    }

    @Override
    public int deletePrescriptionSub(String prescriptioncode) {
        return jcsjPrescriptionMainMapper.deletePrescriptionSub(prescriptioncode);
    }

    @Override
    public List<JCSJPrescriptionMain> checkPrescriptionMainExits(String prescriptioncode, String prescriptionname) {
        return jcsjPrescriptionMainMapper.checkPrescriptionMainExits(prescriptioncode, prescriptionname);
    }

    @Override
    public List<JCSJPrescriptionMain> GetCMedicinePrescription(String prescriptioncode) {
        return jcsjPrescriptionMainMapper.GetCMedicinePrescription(prescriptioncode);
    }

    @Override
    public List<JCSJPrescriptionMain> GetPrescriptionMedicine(String prescriptioncode) {
        return jcsjPrescriptionMainMapper.GetPrescriptionMedicine(prescriptioncode);
    }

    @Override
    public List<JCSJPrescriptionSub> GetPrescriptionMedicineSub(String prescriptioncode) {
        return jcsjPrescriptionSubMapper.GetPrescriptionMedicineSub(prescriptioncode);
    }

    @Override
    public List<JCSJPrescriptionMain> GetMaxPrescriptionCode() {
        return jcsjPrescriptionMainMapper.GetMaxPrescriptionCode();
    }

    @Override
    public void getBillCode(JCSJPrescriptionMain jcsjPrescriptionMain) {
        jcsjPrescriptionMainMapper.getBillCode(jcsjPrescriptionMain);
    }

    @Override
    public List<GetBillCodeRst> getBillCodeRst(String proUUID) {
        return jcsjPrescriptionMainMapper.getBillCodeRst(proUUID);
    }

    @Override
    public List<JCSJPrescriptionMain> CheckZJPreIsUsedOrNot(String prescriptioncode) {
        return jcsjPrescriptionMainMapper.CheckZJPreIsUsedOrNot(prescriptioncode);
    }
}
