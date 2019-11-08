package com.yyk.sz.zhzy.common.service;

import com.yyk.sz.zhzy.common.entity.Dictionary;
import com.yyk.sz.zhzy.common.entity.MecidalType;

import java.util.List;

public interface MecidalTypeService {
    List<MecidalType> getMecidalType(String checkFlag);
}
