package com.yyk.sz.zhzy.zjxt.lczl.service;

import com.yyk.sz.zhzy.zjxt.lczl.entity.FangJiZJCodeRst;
import com.yyk.sz.zhzy.zjxt.lczl.entity.SFangJiCode;

import java.util.List;

public interface SFangJiCodeService {

    void GetFangJiCode(SFangJiCode xiYaoInfo);

    List<FangJiZJCodeRst> GetFangJiZJCodeRst(String proUUID);
}
