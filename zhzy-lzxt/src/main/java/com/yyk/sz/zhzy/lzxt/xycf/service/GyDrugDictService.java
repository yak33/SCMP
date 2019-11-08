package com.yyk.sz.zhzy.lzxt.xycf.service;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.lzxt.xycf.entity.GyDrugDict;
import com.yyk.sz.zhzy.lzxt.xycf.entity.XiYaoInfo;

import java.util.List;

public interface GyDrugDictService {

    public List<GyDrugDict> getWesternDrugByFangJiSubID(int empBasicMainID, int fangJiSubID);
}
