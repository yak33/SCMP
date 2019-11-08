package com.yyk.sz.zhzy.common.service;


import com.yyk.sz.zhzy.common.entity.Dictionary;
import com.yyk.sz.zhzy.common.entity.MecidalType;
import com.yyk.sz.zhzy.common.mapper.DictionaryMapper;
import com.yyk.sz.zhzy.common.mapper.MecidalTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class MecidalTypeServiceImpl implements MecidalTypeService {


    @Autowired
    private MecidalTypeMapper mecidalTypeMapper;

    @Override
    public List<MecidalType> getMecidalType(String checkFlag) {
        return mecidalTypeMapper.getMecidalType(checkFlag);
    }
}
