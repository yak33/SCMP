package com.yyk.sz.zhzy.common.service;

import com.yyk.sz.zhzy.common.entity.GyUser;
import com.yyk.sz.zhzy.common.entity.MecidalType;

import java.util.List;

public interface GyUserService {
    List<GyUser> getGyUser(String deptCode);
}
