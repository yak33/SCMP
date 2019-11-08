package com.yyk.sz.zhzy.common.service;


import com.yyk.sz.zhzy.common.entity.DeptMent;
import com.yyk.sz.zhzy.common.entity.Dictionary;
import com.yyk.sz.zhzy.common.mapper.DeptMentMapper;
import com.yyk.sz.zhzy.common.mapper.DictionaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class DeptMentServiceImpl implements DeptMentService {


    @Autowired
    private DeptMentMapper deptMentMapper;

    @Override
    public List<DeptMent> getKeShi() {
        return deptMentMapper.getKeShi();
    }


}
