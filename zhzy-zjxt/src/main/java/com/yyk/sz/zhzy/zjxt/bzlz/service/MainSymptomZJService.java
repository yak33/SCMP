package com.yyk.sz.zhzy.zjxt.bzlz.service;

import com.yyk.sz.zhzy.zjxt.bzlz.entity.MainSymptomZJ;

import java.util.List;

public interface MainSymptomZJService {

    List<MainSymptomZJ> getMainSymptomList(String deptCode, String userCode);

    List<MainSymptomZJ> getDiseaseList(int mainSymptomCode);

    List<MainSymptomZJ> getTongueList(int mainSymptomCode);

    List<MainSymptomZJ> getPulseList(int mainSymptomCode);

}
