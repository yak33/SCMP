package com.yyk.sz.zhzy.jcsjxt.service;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.*;

import java.util.List;


public interface JCSJDrugDictService {
    Paging<JCSJDrugDict> getWesternDistionaryTable(int pageNum,
                                                          int pageSize,
                                                          String searchText,
                                                          String sortName,
                                                          String sortOrder);

    Paging<JCSJDrugDict> getDrugDictDistionaryTable(int pageNum,
                                                          int pageSize,
                                                          String searchText,
                                                          String sortName,
                                                          String sortOrder);
    Paging<JCSJDrugDict> getAcupointZJTable(int pageNum,
                                                    int pageSize,
                                                    String searchText,
                                                    String sortName,
                                                    String sortOrder);

    int insertWesternDistionary(JCSJDrugDict jcsjDrugDict);

    int updateWesternDistionary(JCSJDrugDict jcsjDrugDict);

    int deleteWesternDistionary(Integer drugcode);

    int deleteAcupointZJ(Integer drugcode);

    int insertAcupointZJ(Integer drugcode,String meridiancode);


    void getBillCode(JCSJDrugDict jcsjDrugDict);

    List<JCSJDictCodeRst> GetDictCodeRst(String proUUID);

    List<JCSJDrugDict> GetDrugInfoByDrugName(String drugname);

    List<JCSJDosage> getDosage();

    List<JCSJDrugModel> getDrugModel();

    List<JCSJDrugWay> getDrugWay();

    List<JCSJProcess> getProcess();

    List<JCSJDrugDict> GetDrugInfoByPrescription(Integer drugcode);
    List<JCSJDrugDict> GetDrugInfoByDrugTaboos(Integer drugcode);
    List<JCSJDrugDict> GetDrugInfoFromFangJiDetailSub(Integer drugcode);

    List<JCSJDrugDict> CheckZJAcuIsUsedOrNot(Integer drugcode);
    List<JCSJDrugDict> CheckZJAcuIsUsedOrNotInPreSub(Integer drugcode);
}
