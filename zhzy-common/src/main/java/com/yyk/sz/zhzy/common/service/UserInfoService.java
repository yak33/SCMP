package com.yyk.sz.zhzy.common.service;

import com.yyk.sz.zhzy.common.entity.UserInfo;

public interface UserInfoService {
    UserInfo getUserInfoByAccount(String account);
    String save(UserInfo entity);
}
