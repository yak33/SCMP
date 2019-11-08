package com.yyk.sz.zhzy.zjxt.wcjz.service;

import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysFinancial;
import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysFinancialDetail;
import com.yyk.sz.zhzy.zjxt.wcjz.entity.SaveOrFinishZJ;

import java.util.List;

/**
 * @Author: ZhangChao
 * @Date: 2018/12/4 14:07
 * @Version: 1.0
 */
public interface SaveOrFinishZJService {
    int delFangJiDetailSub(String empBasicMainID);

    int delFangJiSub(String empBasicMainID);

    int insertFangJiSub(SaveOrFinishZJ saveOrFinishZJ);

    List<SaveOrFinishZJ> getFangJiSubIDcc(String empBasicMainID);

    int insertFangJiDetailSubcc(SaveOrFinishZJ saveOrFinishZJ);

    int updateEmpBasicMain(SaveOrFinishZJ saveOrFinishZJ);

    int updateHISEmpBasicMain(SaveOrFinishZJ saveOrFinishZJ);

    SaveOrFinishZJ getDrugDict(String acupointCode);

    /*
       财务相关
        */
    int delFinancial(SysFinancial record);
    int delFinancialDetail(SysFinancialDetail record);

    int insertFin(SysFinancial record);
    int insertFinDet(SysFinancialDetail record);
}
