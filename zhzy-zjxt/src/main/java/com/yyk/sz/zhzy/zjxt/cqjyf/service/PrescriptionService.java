package com.yyk.sz.zhzy.zjxt.cqjyf.service;

import com.yyk.sz.zhzy.zjxt.cqjyf.entity.Prescription;

import java.util.List;

/**
 * @Author: ZhangChao
 * @Date: 2018/11/23 16:19
 * @Version: 1.0
 */
public interface PrescriptionService {

    List<Prescription> getPrescription(Prescription prescription);

    int savePrescriptionZJ(Prescription prescription);

    String getMaxCode();
    List<Prescription> getWantCode(Prescription prescription);
    int delPrescriptionZJ(Prescription prescription);
    int delPrescriptionSubZJ(Prescription prescription);

    int savePrescriptionSubZJ(Prescription prescription);

    List<Prescription> getFangJie(String prescriptionCode);
}
