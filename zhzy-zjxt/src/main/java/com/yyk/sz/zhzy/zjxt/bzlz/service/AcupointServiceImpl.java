package com.yyk.sz.zhzy.zjxt.bzlz.service;

import com.yyk.sz.zhzy.zjxt.bzlz.entity.Acupoint;
import com.yyk.sz.zhzy.zjxt.bzlz.mapper.AcupointMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: ZhangChao
 * @Date: 2018/11/23 15:41
 * @Version: 1.0
 */
@Component
@Transactional
public class AcupointServiceImpl implements AcupointService {

    @Resource
    private AcupointMapper acupointMapper;

    @Override
    public List<Acupoint> getAllAcupoint(String searchText) {
        return acupointMapper.getAllAcupoint(searchText);
    }

    @Override
    public List<Acupoint> getAcupointByPrescriptionCode(String prescriptionCode) {
        return acupointMapper.getAcupointByPrescriptionCode(prescriptionCode);
    }
}
