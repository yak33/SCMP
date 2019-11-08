package com.yyk.sz.zhzy.zjxt.zxzf.service;

import com.yyk.sz.zhzy.zjxt.zxzf.entity.GRZJListRst;
import com.yyk.sz.zhzy.zjxt.zxzf.entity.GovernanceResultZJ;

import java.util.List;

/**
 * @Author: ZhangChao
 * @Date: 2018/12/1 10:51
 * @Version: 1.0
 */
public interface GovernanceResultZJService {

    void getGRZJList(GovernanceResultZJ governanceResultZJ);

    List<GRZJListRst> getGRZJListRst(String proUUID);

    int updateEmpBasicMain(GovernanceResultZJ governanceResultZJ);

}
