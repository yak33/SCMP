package com.yyk.sz.zhzy.jcsjxt.service;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJSummaryItem;

import java.util.List;


public interface JCSJSummaryItemService {
    Paging<JCSJSummaryItem> getSummaryItem(String summarycode, String summaryname, int pageNum,
                                 int pageSize,
                                 String searchText,
                                 String sortName,
                                 String sortOrder);
    int insertSummaryItem(JCSJSummaryItem jcsjSummaryItem);

    int updateSummaryItem(JCSJSummaryItem jcsjSummaryItem);

    int deleteSummaryItem(String summarycode);

    List<JCSJSummaryItem> checkSummaryItemIsUsed(String summarycode);

    List<JCSJSummaryItem> checkSummaryItemExits(String summarycode,String summaryname);

}
