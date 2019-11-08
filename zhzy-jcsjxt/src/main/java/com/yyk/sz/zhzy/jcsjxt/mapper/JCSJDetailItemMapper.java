package com.yyk.sz.zhzy.jcsjxt.mapper;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJDetailItem;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JCSJDetailItemMapper {


    int deleteDetailItem(String detailitemcode);

    int insertDetailItem(JCSJDetailItem record);

    Paging<JCSJDetailItem> getDetailItem(@Param("detailItemCode") String detailItemCode,
                                                 @Param("detailItemName") String detailItemName,
                                                 @Param("pinYinCode") String pinYinCode,
                                                 @Param("pageNum") int pageNum,
                                                 @Param("pageSize") int pageSize,
                                                 @Param("searchText") String searchText,
                                                 @Param("sortName") String sortName,
                                                 @Param("sortOrder") String sortOrder);

    int updateDetailItem(JCSJDetailItem record);

    List<JCSJDetailItem> CheckDetailItemExits(@Param("detailItemCode") String detailItemCode,
                                              @Param("detailItemName") String detailItemName);
}