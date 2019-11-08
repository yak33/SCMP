package com.yyk.sz.zhzy.zjxt.wcjz.service;

import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysFinancial;
import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysFinancialDetail;
import com.yyk.sz.zhzy.lzxt.jyjc.mapper.SysFinancialDetailMapper;
import com.yyk.sz.zhzy.lzxt.jyjc.mapper.SysFinancialMapper;
import com.yyk.sz.zhzy.zjxt.wcjz.entity.SaveOrFinishZJ;
import com.yyk.sz.zhzy.zjxt.wcjz.mapper.SaveOrFinishZJMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: ZhangChao
 * @Date: 2018/12/4 14:08
 * @Version: 1.0
 */
@Component
@Transactional
public class SaveOrFinishZJServiceImpl implements SaveOrFinishZJService {

    @Resource
    private SaveOrFinishZJMapper saveOrFinishZJMapper;
    @Resource
    private SysFinancialMapper sysFinancialMapper;
    @Resource
    private SysFinancialDetailMapper sysFinancialDetailMapper;


    @Override
    public int delFangJiDetailSub(String empBasicMainID) {
        return saveOrFinishZJMapper.delFangJiDetailSub(empBasicMainID);
    }

    @Override
    public int delFangJiSub(String empBasicMainID) {
        return saveOrFinishZJMapper.delFangJiSub(empBasicMainID);
    }

    @Override
    public int insertFangJiSub(SaveOrFinishZJ saveOrFinishZJ) {
        return saveOrFinishZJMapper.insertFangJiSub(saveOrFinishZJ);
    }

    @Override
    public List<SaveOrFinishZJ> getFangJiSubIDcc(String empBasicMainID) {
        return saveOrFinishZJMapper.getFangJiSubIDcc(empBasicMainID);
    }

    @Override
    public int insertFangJiDetailSubcc(SaveOrFinishZJ saveOrFinishZJ) {
        return saveOrFinishZJMapper.insertFangJiDetailSubcc(saveOrFinishZJ);
    }

    @Override
    public int updateEmpBasicMain(SaveOrFinishZJ saveOrFinishZJ) {
        return saveOrFinishZJMapper.updateEmpBasicMain(saveOrFinishZJ);
    }

    @Override
    public int updateHISEmpBasicMain(SaveOrFinishZJ saveOrFinishZJ) {
        return saveOrFinishZJMapper.updateHISEmpBasicMain(saveOrFinishZJ);
    }

    @Override
    public SaveOrFinishZJ getDrugDict(String acupointCode) {
        return saveOrFinishZJMapper.getDrugDict(acupointCode);
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
}
