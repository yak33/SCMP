package com.yyk.sz.zhzy.lzxt.jyjc.mapper;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysFinancial;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysFinancialMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(SysFinancial record);

    int insertSelective(SysFinancial record);

    SysFinancial selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(SysFinancial record);

    int updateByPrimaryKey(SysFinancial record);

    int delFinancial(SysFinancial record);

//    List<SysFinancial> getAllList(@Param("searchText") String searchText);
    Paging<SysFinancial> getAllList(@Param("pageNum") int pageNum,
                                         @Param("pageSize") int pageSize,
                                         @Param("searchText") String searchText,
                                         @Param("sortName") String sortName,
                                         @Param("sortOrder") String sortOrder);

    /**
     * 未付款
     * @param pageNum
     * @param pageSize
     * @param searchText
     * @param sortName
     * @param sortOrder
     * @return
     */
    Paging<SysFinancial> getWFKList(@Param("pageNum") int pageNum,
                                    @Param("pageSize") int pageSize,
                                    @Param("searchText") String searchText,
                                    @Param("sortName") String sortName,
                                    @Param("sortOrder") String sortOrder);

    /**
     * 已付款
     * @param pageNum
     * @param pageSize
     * @param searchText
     * @param sortName
     * @param sortOrder
     * @return
     */
    Paging<SysFinancial> getYFKList(@Param("pageNum") int pageNum,
                                    @Param("pageSize") int pageSize,
                                    @Param("searchText") String searchText,
                                    @Param("sortName") String sortName,
                                    @Param("sortOrder") String sortOrder);

    /**
     * 部分付款
     * @param pageNum
     * @param pageSize
     * @param searchText
     * @param sortName
     * @param sortOrder
     * @return
     */
    Paging<SysFinancial> getBFFKList(@Param("pageNum") int pageNum,
                                    @Param("pageSize") int pageSize,
                                    @Param("searchText") String searchText,
                                    @Param("sortName") String sortName,
                                    @Param("sortOrder") String sortOrder);

    List<SysFinancial> selectPayStatus(Integer empbasicmainid);

    List<SysFinancial> getItemList(Integer empbasicmainid);

    int updatePayStatus(SysFinancial record);

    int updatePayStatusAll(SysFinancial record);

    SysFinancial selectRatio(Integer paytype);
}