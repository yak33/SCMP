package com.yyk.sz.zhzy.lzxt.jyjc.mapper;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysPharmacy;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysPharmacyMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(SysPharmacy record);

    int insertSelective(SysPharmacy record);

    SysPharmacy selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(SysPharmacy record);

    int updateByPrimaryKey(SysPharmacy record);

    int delPharmacy(SysPharmacy record);

    /**
     * 未取药
     * @param pageNum
     * @param pageSize
     * @param searchText
     * @param sortName
     * @param sortOrder
     * @return
     */
    Paging<SysPharmacy> getWQPhaList(@Param("pageNum") int pageNum,
                                      @Param("pageSize") int pageSize,
                                      @Param("searchText") String searchText,
                                      @Param("sortName") String sortName,
                                      @Param("sortOrder") String sortOrder);

    /**
     * 已取药
     * @param pageNum
     * @param pageSize
     * @param searchText
     * @param sortName
     * @param sortOrder
     * @return
     */
    Paging<SysPharmacy> getYQPhaList(@Param("pageNum") int pageNum,
                                      @Param("pageSize") int pageSize,
                                      @Param("searchText") String searchText,
                                      @Param("sortName") String sortName,
                                      @Param("sortOrder") String sortOrder);

    List<SysPharmacy> selectPayStatusPha(Integer empbasicmainid);

    List<SysPharmacy> selectTakeFlagPha(Integer empbasicmainid);

    List<SysPharmacy> getDrugDetail(Integer empbasicmainid);

    int updateTakeFlag(SysPharmacy record);

    List<SysPharmacy> getDrugCodeList(SysPharmacy record);

    List<SysPharmacy> getPayOrNo(Integer empbasicmainid);

    SysPharmacy getPrescriptionName(String drugcode);

}