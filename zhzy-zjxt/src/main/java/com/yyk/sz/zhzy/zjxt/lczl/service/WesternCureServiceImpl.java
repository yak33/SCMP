package com.yyk.sz.zhzy.zjxt.lczl.service;

import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysFinancial;
import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysFinancialDetail;
import com.yyk.sz.zhzy.lzxt.jyjc.mapper.SysFinancialDetailMapper;
import com.yyk.sz.zhzy.lzxt.jyjc.mapper.SysFinancialMapper;
import com.yyk.sz.zhzy.zjxt.lczl.entity.WesternCure;
import com.yyk.sz.zhzy.zjxt.lczl.mapper.WesternCureMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Component
@Transactional
public class WesternCureServiceImpl implements WesternCureService {

    @Resource
    private WesternCureMapper westernCureMapper;
    @Resource
    private SysFinancialMapper sysFinancialMapper;
    @Resource
    private SysFinancialDetailMapper sysFinancialDetailMapper;


    @Override
    public List<WesternCure> getWesternCureList(String searchText) {
        return westernCureMapper.getWesternCureList(searchText);
    }

    @Override
    public List<WesternCure> getWesternCureDetailList(String detailItemCode) {
        return westernCureMapper.getWesternCureDetailList(detailItemCode);
    }

    @Override
    public List<WesternCure> getYiCunMedicareCure(Integer empBasicMainID) {
        return westernCureMapper.getYiCunMedicareCure(empBasicMainID);
    }

    @Override
    public int delFangJiDetailSub(Integer empBasicMainID) {
        return westernCureMapper.delFangJiDetailSub(empBasicMainID);
    }

    @Override
    public int delFangJiSub(Integer empBasicMainID) {
        return westernCureMapper.delFangJiSub(empBasicMainID);
    }

    @Override
    public int saveWesternCure(WesternCure westernCure) {
        return westernCureMapper.saveWesternCure(westernCure);
    }

    @Override
    public WesternCure getFangJiSubID(WesternCure westernCure) {
        return westernCureMapper.getFangJiSubID(westernCure);
    }

    @Override
    public int saveWesternCureFangjiDetail(WesternCure westernCure) {
        return westernCureMapper.saveWesternCureFangjiDetail(westernCure);
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
    public String getDetailItemName(String detailItemCode) {
        return westernCureMapper.getDetailItemName(detailItemCode);
    }
}
