package com.yyk.sz.zhzy.lzxt.xycf.service;

import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysFinancial;
import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysFinancialDetail;
import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysPharmacy;
import com.yyk.sz.zhzy.lzxt.xycf.entity.FangJiDetailSubEntity;
import com.yyk.sz.zhzy.lzxt.xycf.entity.FangJiSubEntity;

public interface XiYaoChuFangService {

    public boolean saveWesternDrugFangji(
            FangJiSubEntity fangJiSubEntity
           );
    public void saveWesternDrugFangji_SP(
            FangJiSubEntity fangJiSubEntity
    );

    public void updateWesternDrugFangji(
            FangJiSubEntity fangJiSubEntity
    );

    public boolean deleteWesternDrugFangji(
            FangJiSubEntity fangJiSubEntity
    );

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
