package com.yyk.sz.zhzy.lzxt.zjkf.service;

import com.yyk.sz.zhzy.lzxt.zjkf.entity.DirectPrescription;
import com.yyk.sz.zhzy.lzxt.zjkf.entity.DrugTaboos;
import com.yyk.sz.zhzy.lzxt.zjkf.mapper.DirectPrescriptionMapper;
import com.yyk.sz.zhzy.lzxt.zjkf.mapper.DrugTaboosMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Component
@Transactional
public class DirectPrescriptionServiceImpl implements DirectPrescriptionService {

    @Resource
    private DirectPrescriptionMapper directPrescriptionMapper;

    @Resource
    private DrugTaboosMapper drugTaboosMapper;

    @Override
    public List<DirectPrescription> getDrugDictList(
            String drugModelCode, String stopFlag, String inputCode, String drugTaste, String drugMeridian) {
        return directPrescriptionMapper.getDrugDictList(drugModelCode,stopFlag,inputCode,drugTaste,drugMeridian);
    }

    @Override
    public List<DirectPrescription> getChineseMedicineList(String chineseMedicineCode, String chineseMedicineName, String pinYinCode,String searchText) {
        return directPrescriptionMapper.getChineseMedicineList(chineseMedicineCode,chineseMedicineName,pinYinCode,searchText);
    }

    @Override
    public List<DirectPrescription> getWesternMedicineList(String westernMedicineCode, String westernMedicineName, String pinYinCode,String searchText) {
        return directPrescriptionMapper.getWesternMedicineList(westernMedicineCode,westernMedicineName,pinYinCode,searchText);
    }

    @Override
    public List<DirectPrescription> getTaste() {
        return directPrescriptionMapper.getTaste();
    }

    @Override
    public List<DirectPrescription> getMeridian() {
        return directPrescriptionMapper.getMeridian();
    }

    @Override
    public List<DrugTaboos> getDrugTaboosList() {
        return drugTaboosMapper.getDrugTaboosList();
    }
}
