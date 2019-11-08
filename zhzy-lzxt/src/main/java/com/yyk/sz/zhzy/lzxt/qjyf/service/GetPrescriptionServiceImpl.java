package com.yyk.sz.zhzy.lzxt.qjyf.service;

import com.yyk.sz.zhzy.lzxt.qjyf.entity.GetPrescription;
import com.yyk.sz.zhzy.lzxt.qjyf.mapper.GetPrescriptionMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Component
@Transactional
public class GetPrescriptionServiceImpl implements GetPrescriptionService {

    @Resource
    private GetPrescriptionMapper getPrescriptionMapper;

    @Override
    public List<GetPrescription> selectPrescriptionList(GetPrescription getPrescription) {
        return getPrescriptionMapper.selectPrescriptionList(getPrescription);
    }
}
