package com.yyk.sz.zhzy.lzxt.xycf.service;


import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysFinancial;
import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysFinancialDetail;
import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysPharmacy;
import com.yyk.sz.zhzy.lzxt.jyjc.mapper.SysFinancialDetailMapper;
import com.yyk.sz.zhzy.lzxt.jyjc.mapper.SysFinancialMapper;
import com.yyk.sz.zhzy.lzxt.jyjc.mapper.SysPharmacyMapper;
import com.yyk.sz.zhzy.lzxt.xycf.entity.FangJiDetailSubEntity;
import com.yyk.sz.zhzy.lzxt.xycf.entity.FangJiSubEntity;
import com.yyk.sz.zhzy.lzxt.xycf.mapper.XiYaoChuFangMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component
@Transactional
public class XiYaoChuFangServiceImpl implements XiYaoChuFangService {


    @Autowired
    private XiYaoChuFangMapper xiYaoChuFangMapper;
    @Resource
    private SysFinancialMapper sysFinancialMapper;
    @Resource
    private SysFinancialDetailMapper sysFinancialDetailMapper;
    @Resource
    private SysPharmacyMapper sysPharmacyMapper;

    @Override
    public boolean saveWesternDrugFangji(FangJiSubEntity fangJiSubEntity) {
        return xiYaoChuFangMapper.saveWesternDrugFangji(fangJiSubEntity);
    }

    @Override
    public void saveWesternDrugFangji_SP(FangJiSubEntity fangJiSubEntity) {
        xiYaoChuFangMapper.saveWesternDrugFangji_SP(fangJiSubEntity);
    }

    @Override
    public void updateWesternDrugFangji(FangJiSubEntity fangJiSubEntity) {
        xiYaoChuFangMapper.updateWesternDrugFangji(fangJiSubEntity);
    }

    @Override
    public boolean deleteWesternDrugFangji(FangJiSubEntity fangJiSubEntity) {
        return xiYaoChuFangMapper.deleteWesternDrugFangji(fangJiSubEntity);
    }

    @Override
    public int delFinancial(SysFinancial record) {
        return sysFinancialMapper.delFinancial(record);
    }

    @Override
    public int delFinancialDetail(SysFinancialDetail record) {
        return sysFinancialDetailMapper.delFinancialDetail(record);
    }

    @Override
    public int insertFin(SysFinancial record) {
        return sysFinancialMapper.insert(record);
    }

    @Override
    public int insertFinDet(SysFinancialDetail record) {
        return sysFinancialDetailMapper.insert(record);
    }

    @Override
    public int delPharmacy(SysPharmacy record) {
        return sysPharmacyMapper.delPharmacy(record);
    }

    @Override
    public int insertPha(SysPharmacy record) {
        return sysPharmacyMapper.insert(record);
    }
}
