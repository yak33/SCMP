package com.yyk.sz.zhzy.lzxt.cjyf.service;

import com.yyk.sz.zhzy.lzxt.cjyf.entity.PrescriptionMain;
import com.yyk.sz.zhzy.lzxt.cjyf.mapper.PrescriptionMainMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Component
@Transactional
public class PrescriptionMainServiceImpl implements PrescriptionMainService {

    @Resource
    private PrescriptionMainMapper prescriptionMainMapper;

    @Override
    public int insertMain(PrescriptionMain prescriptionMain) {
        return prescriptionMainMapper.insertMain(prescriptionMain);
    }

    @Override
    public int insertSub(PrescriptionMain prescriptionMain) {
        return prescriptionMainMapper.insertSub(prescriptionMain);
    }

    @Override
    public List<PrescriptionMain> getWantCode(PrescriptionMain prescription) {
        return prescriptionMainMapper.getWantCode(prescription);
    }

    @Override
    public int delPrescriptionZJ(PrescriptionMain prescription) {
        return prescriptionMainMapper.delPrescriptionZJ(prescription);
    }

    @Override
    public int delPrescriptionSubZJ(PrescriptionMain prescription) {
        return prescriptionMainMapper.delPrescriptionSubZJ(prescription);
    }

    @Override
    public List<PrescriptionMain> getClassify() {
        return prescriptionMainMapper.getClassify();
    }

    @Override
    public List<PrescriptionMain> getSufferType() {
        return prescriptionMainMapper.getSufferType();
    }


}
