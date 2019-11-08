package com.yyk.sz.zhzy.common.service;


import com.yyk.sz.zhzy.common.entity.Dictionary;
import com.yyk.sz.zhzy.common.mapper.DictionaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class DictionaryServiceImpl implements DictionaryService {


    @Autowired
    private DictionaryMapper dictionaryMapper;

    @Override
    public List<Dictionary> getDictionaryByType(String type) {
        return dictionaryMapper.getDictionaryByType(type);
    }
}
