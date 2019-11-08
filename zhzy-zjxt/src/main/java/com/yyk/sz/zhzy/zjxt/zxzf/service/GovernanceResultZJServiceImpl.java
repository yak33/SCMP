package com.yyk.sz.zhzy.zjxt.zxzf.service;

import com.yyk.sz.zhzy.zjxt.zxzf.entity.GRZJListRst;
import com.yyk.sz.zhzy.zjxt.zxzf.entity.GovernanceResultZJ;
import com.yyk.sz.zhzy.zjxt.zxzf.mapper.GovernanceResultZJMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: ZhangChao
 * @Date: 2018/12/1 10:52
 * @Version: 1.0
 */
@Component
@Transactional
public class GovernanceResultZJServiceImpl implements GovernanceResultZJService {

    @Resource
    private GovernanceResultZJMapper governanceResultZJMapper;


    @Override
    public void getGRZJList(GovernanceResultZJ governanceResultZJ) {
        governanceResultZJMapper.getGRZJList(governanceResultZJ);
    }

    @Override
    public List<GRZJListRst> getGRZJListRst(String proUUID) {
        return governanceResultZJMapper.getGRZJListRst(proUUID);
    }

    @Override
    public int updateEmpBasicMain(GovernanceResultZJ governanceResultZJ) {
        return governanceResultZJMapper.updateEmpBasicMain(governanceResultZJ);
    }
}
