package com.yyk.sz.zhzy.lzxt.bzlz.service;

import com.yyk.sz.zhzy.lzxt.bzlz.entity.MainSymptom;

import java.util.List;

public interface MainSymptomService {
    public List<MainSymptom> getSelectMainSymptomTable(String deptCode, String userCode,String searchText);
}
