package com.yyk.sz.zhzy.lzxt.bzlz.service;

import java.util.List;

import com.yyk.sz.zhzy.lzxt.bzlz.entity.GRListRst;
import com.yyk.sz.zhzy.lzxt.bzlz.entity.GovernanceResult;

/**
 * @Author: ZhangChao
 * @Date: 2018-11-13 11:06
 */
public interface GovernanceResultService {

    public void getGRList(GovernanceResult governanceResult);
    public List<GRListRst> getGRListRst(String proUUID);

    List<GovernanceResult> getDrugByPrescriptionCode(String prescriptionCode);
    List<GovernanceResult> getCalciteByPrescriptionCode(String prescriptionCode);
    List<GovernanceResult> getMeridian();
    List<GovernanceResult> getMeridianScore(int empBasicMainID);
    List<GovernanceResult> getTasteScore(int empBasicMainID);

    List<GovernanceResult> getDTZXTData(String drugCodeStr);

    List<GovernanceResult> getHRWP(String DCStr);

}
