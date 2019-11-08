package com.yyk.sz.zhzy.lzxt.cjyf.service;

import com.yyk.sz.zhzy.lzxt.cjyf.entity.PrescriptionMain;

import java.util.List;

public interface PrescriptionMainService {

    int insertMain(PrescriptionMain prescriptionMain);

    int insertSub(PrescriptionMain prescriptionMain);

    List<PrescriptionMain> getWantCode(PrescriptionMain prescription);

    int delPrescriptionZJ(PrescriptionMain prescription);
    int delPrescriptionSubZJ(PrescriptionMain prescription);

    List<PrescriptionMain> getClassify();
    List<PrescriptionMain> getSufferType();
}
