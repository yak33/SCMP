package com.yyk.sz.zhzy.zjxt.bzlz.service;


import com.yyk.sz.zhzy.zjxt.bzlz.entity.Acupoint;

import java.util.List;

/**
 * @Author: ZhangChao
 * @Date: 2018/11/23 15:40
 * @Version: 1.0
 */
public interface AcupointService {

    List<Acupoint> getAllAcupoint(String searchText);

    List<Acupoint> getAcupointByPrescriptionCode(String prescriptionCode);
}
