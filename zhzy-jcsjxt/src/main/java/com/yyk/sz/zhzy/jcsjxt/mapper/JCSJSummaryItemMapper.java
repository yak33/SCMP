package com.yyk.sz.zhzy.jcsjxt.mapper;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJSummaryItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JCSJSummaryItemMapper {

    int deleteSummaryItem(String summarycode);

    int insertSummaryItem(JCSJSummaryItem record);

    Paging<JCSJSummaryItem> getSummaryItem(@Param("summarycode") String summarycode,
                                           @Param("summaryname") String summaryname,
                                           @Param("pageNum") int pageNum,
                                           @Param("pageSize") int pageSize,
                                           @Param("searchText") String searchText,
                                           @Param("sortName") String sortName,
                                           @Param("sortOrder") String sortOrder);

    int updateSummaryItem(JCSJSummaryItem record);

    List<JCSJSummaryItem> checkSummaryItemIsUsed(@Param("summarycode") String summarycode);

    List<JCSJSummaryItem> checkSummaryItemExits(@Param("summarycode") String summarycode,@Param("summaryname") String summaryname);
}