package com.yyk.sz.zhzy.jcsjxt.service;


import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJSummaryItem;
import com.yyk.sz.zhzy.jcsjxt.mapper.JCSJSummaryItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class JCSJSummaryItemServiceImpl implements JCSJSummaryItemService {


    @Autowired
    private JCSJSummaryItemMapper jcsjSummaryItemMapper;

    @Override
    public Paging<JCSJSummaryItem> getSummaryItem(String summarycode, String summaryname, int pageNum,
                                               int pageSize,
                                               String searchText,
                                               String sortName,
                                               String sortOrder) {
        return jcsjSummaryItemMapper.getSummaryItem(summarycode,summaryname,pageNum, pageSize, searchText, sortName, sortOrder);
    }

    @Override
    public int insertSummaryItem(JCSJSummaryItem jcsjSummaryItem) {
        return jcsjSummaryItemMapper.insertSummaryItem(jcsjSummaryItem);
    }

    @Override
    public int updateSummaryItem(JCSJSummaryItem jcsjSummaryItem) {
        return jcsjSummaryItemMapper.updateSummaryItem(jcsjSummaryItem);
    }

    @Override
    public int deleteSummaryItem(String summarycode) {
        return jcsjSummaryItemMapper.deleteSummaryItem(summarycode);
    }

    @Override
    public List<JCSJSummaryItem> checkSummaryItemIsUsed(String summarycode) {
        return jcsjSummaryItemMapper.checkSummaryItemIsUsed(summarycode);
    }

    @Override
    public List<JCSJSummaryItem> checkSummaryItemExits(String summarycode,String summaryname) {
        return jcsjSummaryItemMapper.checkSummaryItemExits(summarycode,summaryname);
    }
}
