package com.yyk.sz.zhzy.lzxt.qjyf.service;

import com.yyk.sz.zhzy.lzxt.qjyf.entity.GetPrescription;

import java.util.List;

public interface GetPrescriptionService {

    public List<GetPrescription> selectPrescriptionList(GetPrescription getPrescription);

}
