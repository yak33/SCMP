package com.yyk.sz.zhzy.lzxt.zjkf.service;

import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysFinancial;
import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysFinancialDetail;
import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysPharmacy;
import com.yyk.sz.zhzy.lzxt.zjkf.entity.SaveOrFinishVisit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SaveOrFinishVisitService {

    int delFangJiDetailSub(SaveOrFinishVisit saveOrFinishVisit);

    int delFangJiSub(SaveOrFinishVisit saveOrFinishVisit);

    int insertFangJiSub(SaveOrFinishVisit saveOrFinishVisit);

    int updateEmpBasicMain(SaveOrFinishVisit saveOrFinishVisit);

    int updateHISEmpBasicMain(SaveOrFinishVisit saveOrFinishVisit);
    int updateHISEmpBasicMain1(String registrationNum);
    List<SaveOrFinishVisit> getFangJiSubIDcc(int empBasicMainID);
    int delFangJiDetailSubcc(int fangJiSubID);
    int insertFangJiDetailSubcc(SaveOrFinishVisit saveOrFinishVisit);
    int updateFangJiDetailSubcc(SaveOrFinishVisit saveOrFinishVisit);

    SaveOrFinishVisit getDrugDict(String DrugCode);

    List<SaveOrFinishVisit> getFangJiDetailSub(SaveOrFinishVisit saveOrFinishVisit);
    List<SaveOrFinishVisit> getFangJi(SaveOrFinishVisit saveOrFinishVisit);

    /*
    财务相关
     */
    int delFinancial(SysFinancial record);
    int delFinancialDetail(SysFinancialDetail record);

    int insertFin(SysFinancial record);
    int insertFinDet(SysFinancialDetail record);

    /*
    药房相关
     */
    int delPharmacy(SysPharmacy record);
    int insertPha(SysPharmacy record);

}
