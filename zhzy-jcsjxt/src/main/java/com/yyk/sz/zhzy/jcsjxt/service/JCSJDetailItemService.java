package com.yyk.sz.zhzy.jcsjxt.service;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJDetailItem;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJDetailItemSub;

import java.util.List;


public interface JCSJDetailItemService {

    Paging<JCSJDetailItem> getDetailItem(String detailItemCode, String detailItemName, String pinYinCode, int pageNum,
                                          int pageSize,
                                          String searchText,
                                          String sortName,
                                          String sortOrder);

    int insertDetailItem(JCSJDetailItem jcsjDetailItem);

    int insertDetailItemSub(JCSJDetailItemSub jcsjDetailItemSub);

    int updateDetailItem(JCSJDetailItem jcsjDetailItem);

    int deleteDetailItem(String detailItemCode);

    int deleteDetailItemSub(String detailItemCode);

    List<JCSJDetailItem> CheckDetailItemExits(String detailItemCode, String detailItemName);

    List<JCSJDetailItemSub> getFromDetailItemSubByDetailItemCode(String detailItemCode);

}
