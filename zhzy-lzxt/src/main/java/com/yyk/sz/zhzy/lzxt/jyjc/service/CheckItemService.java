package com.yyk.sz.zhzy.lzxt.jyjc.service;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.lzxt.jyjc.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: ZhangChao
 * @Date: 2018-11-14 10:07
 */
public interface CheckItemService {

    List<CheckItem> getCheckItemList(int detailItemFlag);

    List<CheckItem> getCheckItemDetailList(String summaryCode);

    List<CheckItem> getYiCunCheckItemList(Integer empBasicMainID, Integer checkFlag);

    int updateRemark(CheckItem checkItem);

    int delCheckSub(CheckItem checkItem);

    int insertCheckSub(CheckItem checkItem);

    int delFinancial(SysFinancial record);

    int delFinancialDetail(SysFinancialDetail record);

    int insertFin(SysFinancial record);

    int insertFinDet(SysFinancialDetail record);

    String getDetailItemName(String detailItemCode);

//    List<SysFinancial> getAllList(String searchText);
    Paging<SysFinancial> getAllList(int pageNum,
                                      int pageSize,
                                      String searchText,
                                      String sortName,
                                      String sortOrder);
    Paging<SysFinancial> getWFKList(int pageNum,
                                    int pageSize,
                                    String searchText,
                                    String sortName,
                                    String sortOrder);
    Paging<SysFinancial> getYFKList(int pageNum,
                                    int pageSize,
                                    String searchText,
                                    String sortName,
                                    String sortOrder);
    Paging<SysFinancial> getBFFKList(int pageNum,
                                    int pageSize,
                                    String searchText,
                                    String sortName,
                                    String sortOrder);

    List<SysFinancial> selectPayStatus(Integer empbasicmainid);

    List<SysFinancial> getItemList(Integer empbasicmainid);

    int updatePayStatus(SysFinancial record);

    int updatePayStatusAll(SysFinancial record);

    List<SysFinancialDetail> getItemDetail(SysFinancialDetail record);

    SysFinancial selectRatio(Integer paytype);

    Paging<SysPharmacy> getWQPhaList(int pageNum,
                                      int pageSize,
                                      String searchText,
                                      String sortName,
                                      String sortOrder);
    Paging<SysPharmacy> getYQPhaList(int pageNum,
                                      int pageSize,
                                      String searchText,
                                      String sortName,
                                      String sortOrder);

    List<SysPharmacy> selectPayStatusPha(Integer empbasicmainid);

    List<SysPharmacy> selectTakeFlagPha(Integer empbasicmainid);

    List<SysPharmacy> getDrugDetail(Integer empbasicmainid);

    int updateTakeFlag(SysPharmacy record);

    Paging<SysInventory> getInventoryAll(int pageNum,
                                         int pageSize,
                                         String searchText,
                                         String sortName,
                                         String sortOrder);

    Paging<SysInventoryTX> getWarningList(@Param("pageNum") int pageNum,
                                          @Param("pageSize") int pageSize,
                                          @Param("searchText") String searchText,
                                          @Param("sortName") String sortName,
                                          @Param("sortOrder") String sortOrder);

    int updateInvertory(SysInventory record);

    SysInventory selectByPrimaryKey(Integer drugcode);

    List<SysPharmacy> getDrugCodeList(SysPharmacy record);

    int updateNewRemain(SysInventory record);

    List<SysPharmacy> getPayOrNo(Integer empbasicmainid);

    SysPharmacy getPrescriptionName(String drugcode);
}
