package com.yyk.sz.zhzy.lzxt.zjkf.service;

import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysFinancial;
import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysFinancialDetail;
import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysPharmacy;
import com.yyk.sz.zhzy.lzxt.jyjc.mapper.SysFinancialDetailMapper;
import com.yyk.sz.zhzy.lzxt.jyjc.mapper.SysFinancialMapper;
import com.yyk.sz.zhzy.lzxt.jyjc.mapper.SysPharmacyMapper;
import com.yyk.sz.zhzy.lzxt.zjkf.entity.SaveOrFinishVisit;
import com.yyk.sz.zhzy.lzxt.zjkf.mapper.SaveOrFinishVisitMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Component
@Transactional
public class SaveOrFinishVisitServiceImpl implements SaveOrFinishVisitService {

    @Resource
    private SaveOrFinishVisitMapper SaveOrFinishVisitMapper;
    @Resource
    private SysFinancialMapper sysFinancialMapper;
    @Resource
    private SysFinancialDetailMapper sysFinancialDetailMapper;
    @Resource
    private SysPharmacyMapper sysPharmacyMapper;

    @Override
    public int delFangJiDetailSub(SaveOrFinishVisit saveOrFinishVisit) {
        return SaveOrFinishVisitMapper.delFangJiDetailSub(saveOrFinishVisit);
    }

    @Override
    public int delFangJiSub(SaveOrFinishVisit saveOrFinishVisit) {
        return SaveOrFinishVisitMapper.delFangJiSub(saveOrFinishVisit);
    }

    @Override
    public int insertFangJiSub(SaveOrFinishVisit saveOrFinishVisit) {
        return SaveOrFinishVisitMapper.insertFangJiSub(saveOrFinishVisit);
    }

    @Override
    public int updateEmpBasicMain(SaveOrFinishVisit saveOrFinishVisit) {
        return SaveOrFinishVisitMapper.updateEmpBasicMain(saveOrFinishVisit);
    }

    @Override
    public int updateHISEmpBasicMain(SaveOrFinishVisit saveOrFinishVisit) {
        return SaveOrFinishVisitMapper.updateHISEmpBasicMain(saveOrFinishVisit);
    }

    @Override
    public int updateHISEmpBasicMain1(String registrationNum) {
        return SaveOrFinishVisitMapper.updateHISEmpBasicMain1(registrationNum);
    }

    @Override
    public List<SaveOrFinishVisit> getFangJiSubIDcc(int empBasicMainID) {
        return SaveOrFinishVisitMapper.getFangJiSubIDcc(empBasicMainID);
    }

    @Override
    public int delFangJiDetailSubcc(int fangJiSubID) {
        return SaveOrFinishVisitMapper.delFangJiDetailSubcc(fangJiSubID);
    }

    @Override
    public int insertFangJiDetailSubcc(SaveOrFinishVisit saveOrFinishVisit) {
        return SaveOrFinishVisitMapper.insertFangJiDetailSubcc(saveOrFinishVisit);
    }

    @Override
    public int updateFangJiDetailSubcc(SaveOrFinishVisit saveOrFinishVisit) {
        return SaveOrFinishVisitMapper.updateFangJiDetailSubcc(saveOrFinishVisit);
    }

    @Override
    public SaveOrFinishVisit getDrugDict(String DrugCode) {
        return SaveOrFinishVisitMapper.getDrugDict(DrugCode);
    }

    @Override
    public List<SaveOrFinishVisit> getFangJiDetailSub(SaveOrFinishVisit saveOrFinishVisit) {
        return SaveOrFinishVisitMapper.getFangJiDetailSub(saveOrFinishVisit);
    }

    @Override
    public List<SaveOrFinishVisit> getFangJi(SaveOrFinishVisit saveOrFinishVisit) {
        return SaveOrFinishVisitMapper.getFangJi(saveOrFinishVisit);
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
