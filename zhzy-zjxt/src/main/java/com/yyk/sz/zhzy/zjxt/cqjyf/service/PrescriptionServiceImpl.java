package com.yyk.sz.zhzy.zjxt.cqjyf.service;

import com.yyk.sz.zhzy.zjxt.cqjyf.entity.Prescription;
import com.yyk.sz.zhzy.zjxt.cqjyf.mapper.PrescriptionMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: ZhangChao
 * @Date: 2018/11/23 16:20
 * @Version: 1.0
 */
@Component
@Transactional
public class PrescriptionServiceImpl implements PrescriptionService {
    @Resource
    private PrescriptionMapper prescriptionMapper;
    @Override
    public List<Prescription> getPrescription(Prescription prescription) {
        return prescriptionMapper.getPrescription(prescription);
    }

    @Override
    public int savePrescriptionZJ(Prescription prescription) {
        return prescriptionMapper.savePrescriptionZJ(prescription);
    }

    @Override
    public String getMaxCode() {
        return prescriptionMapper.getMaxCode();
    }

    @Override
    public List<Prescription> getWantCode(Prescription prescription) {
        return prescriptionMapper.getWantCode(prescription);
    }

    @Override
    public int delPrescriptionZJ(Prescription prescription) {
        return prescriptionMapper.delPrescriptionZJ(prescription);
    }

    @Override
    public int delPrescriptionSubZJ(Prescription prescription) {
        return prescriptionMapper.delPrescriptionSubZJ(prescription);
    }

    @Override
    public int savePrescriptionSubZJ(Prescription prescription) {
        return prescriptionMapper.savePrescriptionSubZJ(prescription);
    }

    @Override
    public List<Prescription> getFangJie(String prescriptionCode) {
        return prescriptionMapper.getFangJie(prescriptionCode);
    }
}
