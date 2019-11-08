package com.yyk.sz.zhzy.lzxt.zjkf.service;

import com.yyk.sz.zhzy.lzxt.zjkf.entity.DrugDict;

import java.util.List;

public interface DrugDictService {

    List<DrugDict> getDrugInfoList(String drugCode);
}
