package com.yyk.sz.zhzy.gcxt.bzlz.service;

import com.yyk.sz.zhzy.gcxt.bzlz.entity.GCMainSymptom;

import java.util.List;

public interface GCMainSymptomService {
    public List<GCMainSymptom> getSelectMainSymptomByCode(String deptCode, String userCode, String westernMedicineCode, String searchText);
}
