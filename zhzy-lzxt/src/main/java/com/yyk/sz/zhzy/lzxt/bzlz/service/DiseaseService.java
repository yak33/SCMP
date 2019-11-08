package com.yyk.sz.zhzy.lzxt.bzlz.service;

import com.yyk.sz.zhzy.lzxt.bzlz.entity.Disease;

import java.util.List;

public interface DiseaseService {
    public List<Disease> getDiseaseTable(String mainSymptomCode);
}
