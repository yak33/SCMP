package com.yyk.sz.zhzy.lzxt.bzlz.service;

import com.yyk.sz.zhzy.lzxt.bzlz.entity.GRListRst;
import com.yyk.sz.zhzy.lzxt.bzlz.entity.GovernanceResult;
import com.yyk.sz.zhzy.lzxt.bzlz.mapper.GovernanceResultMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: ZhangChao
 * @Date: 2018-11-13 11:11
 */
@Component
@Transactional
public class GovernanceResultServiceImpl implements GovernanceResultService {

    @Resource
    private GovernanceResultMapper governanceResultMapper;

    @Override
    public void getGRList(GovernanceResult governanceResult) {
        governanceResultMapper.getGRList(governanceResult);
    }

    @Override
    public List<GRListRst> getGRListRst(String proUUID) {
        return governanceResultMapper.getGRListRst(proUUID);
    }

    @Override
    public List<GovernanceResult> getDrugByPrescriptionCode(String prescriptionCode) {
        return governanceResultMapper.getDrugByPrescriptionCode(prescriptionCode);
    }

    @Override
    public List<GovernanceResult> getCalciteByPrescriptionCode(String prescriptionCode) {
        return governanceResultMapper.getCalciteByPrescriptionCode(prescriptionCode);
    }

    @Override
    public List<GovernanceResult> getMeridian() {
        return governanceResultMapper.getMeridian();
    }

    @Override
    public List<GovernanceResult> getMeridianScore(int empBasicMainID) {
        return governanceResultMapper.getMeridianScore(empBasicMainID);
    }

    @Override
    public List<GovernanceResult> getTasteScore(int empBasicMainID) {
        return governanceResultMapper.getTasteScore(empBasicMainID);
    }

    @Override
    public List<GovernanceResult> getDTZXTData(String drugCodeStr) {
        return governanceResultMapper.getDTZXTData(drugCodeStr);
    }

    @Override
    public List<GovernanceResult> getHRWP(String DCStr) {
        return governanceResultMapper.getHRWP(DCStr);
    }

}
