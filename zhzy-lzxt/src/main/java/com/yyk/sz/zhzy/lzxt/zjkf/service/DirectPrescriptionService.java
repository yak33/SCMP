package com.yyk.sz.zhzy.lzxt.zjkf.service;

import com.yyk.sz.zhzy.lzxt.zjkf.entity.DirectPrescription;
import com.yyk.sz.zhzy.lzxt.zjkf.entity.DrugTaboos;
import com.yyk.sz.zhzy.lzxt.zjkf.entity.Meridian;
import com.yyk.sz.zhzy.lzxt.zjkf.entity.Taste;
import java.util.List;

public interface DirectPrescriptionService {
    public List<DirectPrescription> getDrugDictList(
            String drugModelCode,
            String stopFlag,
            String inputCode,
            String drugTaste,
            String drugMeridian
    );

    public List<DirectPrescription> getChineseMedicineList(
            String chineseMedicineCode,
            String chineseMedicineName,
            String pinYinCode,
            String searchText
    );

    public List<DirectPrescription> getWesternMedicineList(
            String westernMedicineCode,
            String westernMedicineName,
            String pinYinCode,
            String searchText
    );

    List<DirectPrescription> getTaste();
    List<DirectPrescription> getMeridian();

    List<DrugTaboos> getDrugTaboosList();
}
