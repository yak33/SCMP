package com.yyk.sz.zhzy.common.service;

import com.yyk.sz.zhzy.common.entity.Dictionary;

import java.util.List;

public interface DictionaryService {
    List<Dictionary> getDictionaryByType(String type);
}
