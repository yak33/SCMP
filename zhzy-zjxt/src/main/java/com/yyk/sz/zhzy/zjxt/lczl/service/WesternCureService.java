package com.yyk.sz.zhzy.zjxt.lczl.service;

import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysFinancial;
import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysFinancialDetail;
import com.yyk.sz.zhzy.zjxt.lczl.entity.WesternCure;

import java.util.List;

public interface WesternCureService {

    List<WesternCure> getWesternCureList(String searchText);

    List<WesternCure> getWesternCureDetailList(String detailItemCode);

    List<WesternCure> getYiCunMedicareCure(Integer empBasicMainID);

    int delFangJiDetailSub(Integer empBasicMainID);

    int delFangJiSub(Integer empBasicMainID);

    int saveWesternCure(WesternCure westernCure);

    WesternCure getFangJiSubID(WesternCure westernCure);

    int saveWesternCureFangjiDetail(WesternCure westernCure);

    /*
    财务相关
     */
    int delFinancial(SysFinancial record);
    int delFinancialDetail(SysFinancialDetail record);

    int insertFin(SysFinancial record);
    int insertFinDet(SysFinancialDetail record);

    String getDetailItemName(String detailItemCode);

}
