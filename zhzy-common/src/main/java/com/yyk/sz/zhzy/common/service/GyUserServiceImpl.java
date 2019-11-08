package com.yyk.sz.zhzy.common.service;


import com.yyk.sz.zhzy.common.entity.GyUser;
import com.yyk.sz.zhzy.common.entity.MecidalType;
import com.yyk.sz.zhzy.common.mapper.GyUserMapper;
import com.yyk.sz.zhzy.common.mapper.MecidalTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class GyUserServiceImpl implements GyUserService {


    @Autowired
    private GyUserMapper gyUserMapper;

    @Override
    public List<GyUser> getGyUser(String deptCode) {
        return gyUserMapper.getGyUser(deptCode);
    }
}
