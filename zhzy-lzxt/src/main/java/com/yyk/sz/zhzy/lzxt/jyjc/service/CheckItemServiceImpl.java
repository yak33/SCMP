package com.yyk.sz.zhzy.lzxt.jyjc.service;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.lzxt.jyjc.entity.*;
import com.yyk.sz.zhzy.lzxt.jyjc.mapper.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: ZhangChao
 * @Date: 2018-11-14 10:07
 */
@Component
@Transactional
public class CheckItemServiceImpl implements CheckItemService {

    @Resource
    private CheckItemMapper checkItemMapper;
    @Resource
    private SysFinancialMapper sysFinancialMapper;
    @Resource
    private SysFinancialDetailMapper sysFinancialDetailMapper;
    @Resource
    private SysPharmacyMapper sysPharmacyMapper;
    @Resource
    private SysInventoryMapper sysInventoryMapper;


    @Override
    public List<CheckItem> getCheckItemList(int detailItemFlag) {
        return checkItemMapper.getCheckItemList(detailItemFlag);
    }

    @Override
    public List<CheckItem> getCheckItemDetailList(String summaryCode) {
        return checkItemMapper.getCheckItemDetailList(summaryCode);
    }

    @Override
    public List<CheckItem> getYiCunCheckItemList(Integer empBasicMainID, Integer checkFlag) {
        return checkItemMapper.getYiCunCheckItemList(empBasicMainID,checkFlag);
    }

    @Override
    public int updateRemark(CheckItem checkItem) {
        return checkItemMapper.updateRemark(checkItem);
    }

    @Override
    public int delCheckSub(CheckItem checkItem) {
        return checkItemMapper.delCheckSub(checkItem);
    }

    @Override
    public int insertCheckSub(CheckItem checkItem) {
        return checkItemMapper.insertCheckSub(checkItem);
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
        return checkItemMapper.getDetailItemName(detailItemCode);
    }

    @Override
    public Paging<SysFinancial> getAllList(int pageNum, int pageSize, String searchText, String sortName, String sortOrder) {
        return sysFinancialMapper.getAllList(pageNum,pageSize,searchText,sortName,sortOrder);
    }

    @Override
    public Paging<SysFinancial> getWFKList(int pageNum, int pageSize, String searchText, String sortName, String sortOrder) {
        return sysFinancialMapper.getWFKList(pageNum,pageSize,searchText,sortName,sortOrder);
    }

    @Override
    public Paging<SysFinancial> getYFKList(int pageNum, int pageSize, String searchText, String sortName, String sortOrder) {
        return sysFinancialMapper.getYFKList(pageNum,pageSize,searchText,sortName,sortOrder);
    }

    @Override
    public Paging<SysFinancial> getBFFKList(int pageNum, int pageSize, String searchText, String sortName, String sortOrder) {
        return sysFinancialMapper.getBFFKList(pageNum,pageSize,searchText,sortName,sortOrder);
    }

    @Override
    public List<SysFinancial> selectPayStatus(Integer empbasicmainid) {
        return sysFinancialMapper.selectPayStatus(empbasicmainid);
    }

    @Override
    public List<SysFinancial> getItemList(Integer empbasicmainid) {
        return sysFinancialMapper.getItemList(empbasicmainid);
    }

    @Override
    public int updatePayStatus(SysFinancial record) {
        return sysFinancialMapper.updatePayStatus(record);
    }

    @Override
    public int updatePayStatusAll(SysFinancial record) {
        return sysFinancialMapper.updatePayStatusAll(record);
    }

    @Override
    public List<SysFinancialDetail> getItemDetail(SysFinancialDetail record) {
        return sysFinancialDetailMapper.getItemDetail(record);
    }

    @Override
    public SysFinancial selectRatio(Integer paytype) {
        return sysFinancialMapper.selectRatio(paytype);
    }

    @Override
    public Paging<SysPharmacy> getWQPhaList(int pageNum, int pageSize, String searchText, String sortName, String sortOrder) {
        return sysPharmacyMapper.getWQPhaList(pageNum,pageSize,searchText,sortName,sortOrder);
    }
    @Override
    public Paging<SysPharmacy> getYQPhaList(int pageNum, int pageSize, String searchText, String sortName, String sortOrder) {
        return sysPharmacyMapper.getYQPhaList(pageNum,pageSize,searchText,sortName,sortOrder);
    }

    @Override
    public List<SysPharmacy> selectPayStatusPha(Integer empbasicmainid) {
        return sysPharmacyMapper.selectPayStatusPha(empbasicmainid);
    }

    @Override
    public List<SysPharmacy> selectTakeFlagPha(Integer empbasicmainid) {
        return sysPharmacyMapper.selectTakeFlagPha(empbasicmainid);
    }

    @Override
    public List<SysPharmacy> getDrugDetail(Integer empbasicmainid) {
        return sysPharmacyMapper.getDrugDetail(empbasicmainid);
    }

    @Override
    public int updateTakeFlag(SysPharmacy record) {
        return sysPharmacyMapper.updateTakeFlag(record);
    }

    @Override
    public Paging<SysInventory> getInventoryAll(int pageNum, int pageSize, String searchText, String sortName, String sortOrder) {
        return sysInventoryMapper.getInventoryAll(pageNum,pageSize,searchText,sortName,sortOrder);
    }

    @Override
    public Paging<SysInventoryTX> getWarningList(int pageNum, int pageSize, String searchText, String sortName, String sortOrder) {
        return sysInventoryMapper.getWarningList(pageNum,pageSize,searchText,sortName,sortOrder);
    }

    @Override
    public int updateInvertory(SysInventory record) {
        return sysInventoryMapper.updateInvertory(record);
    }

    @Override
    public SysInventory selectByPrimaryKey(Integer drugcode) {
        return sysInventoryMapper.selectByPrimaryKey(drugcode);
    }

    @Override
    public List<SysPharmacy> getDrugCodeList(SysPharmacy record) {
        return sysPharmacyMapper.getDrugCodeList(record);
    }

    @Override
    public int updateNewRemain(SysInventory record) {
        return sysInventoryMapper.updateNewRemain(record);
    }

    @Override
    public List<SysPharmacy> getPayOrNo(Integer empbasicmainid) {
        return sysPharmacyMapper.getPayOrNo(empbasicmainid);
    }

    @Override
    public SysPharmacy getPrescriptionName(String drugcode) {
        return sysPharmacyMapper.getPrescriptionName(drugcode);
    }


}
