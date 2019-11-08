package com.yyk.sz.zhzy.jcsjxt.mapper;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJDictCodeRst;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJDrugDict;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JCSJDrugDictMapper {
    Paging<JCSJDrugDict> getWesternDistionaryTable(@Param("pageNum") int pageNum,
                                                   @Param("pageSize") int pageSize,
                                                   @Param("searchText") String searchText,
                                                   @Param("sortName") String sortName,
                                                   @Param("sortOrder") String sortOrder);

    Paging<JCSJDrugDict> getDrugDictDistionaryTable(@Param("pageNum") int pageNum,
                                                   @Param("pageSize") int pageSize,
                                                   @Param("searchText") String searchText,
                                                   @Param("sortName") String sortName,
                                                   @Param("sortOrder") String sortOrder);
    Paging<JCSJDrugDict> getAcupointZJTable(@Param("pageNum") int pageNum,
                                                    @Param("pageSize") int pageSize,
                                                    @Param("searchText") String searchText,
                                                    @Param("sortName") String sortName,
                                                    @Param("sortOrder") String sortOrder);

    int insertWesternDistionary(JCSJDrugDict jcsjDrugDict);

    int updateWesternDistionary(JCSJDrugDict jcsjDrugDict);

    int deleteWesternDistionary(Integer drugcode);

    int deleteAcupointZJ(Integer drugcode);
    int insertAcupointZJ(Integer drugcode,String meridiancode);

    void getBillCode(JCSJDrugDict jcsjDrugDict);

    List<JCSJDictCodeRst> GetDictCodeRst(@Param("proUUID") String proUUID);

    List<JCSJDrugDict> GetDrugInfoByDrugName(String drugname);

    List<JCSJDrugDict> GetDrugInfoByPrescription(Integer drugcode);

    List<JCSJDrugDict> GetDrugInfoByDrugTaboos(Integer drugcode);

    List<JCSJDrugDict> GetDrugInfoFromFangJiDetailSub(Integer drugcode);

    List<JCSJDrugDict> CheckZJAcuIsUsedOrNot(Integer drugcode);

    List<JCSJDrugDict> CheckZJAcuIsUsedOrNotInPreSub(Integer drugcode);
}