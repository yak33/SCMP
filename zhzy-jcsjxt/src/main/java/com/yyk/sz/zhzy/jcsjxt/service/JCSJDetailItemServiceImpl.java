package com.yyk.sz.zhzy.jcsjxt.service;


import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJDetailItem;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJDetailItemSub;
import com.yyk.sz.zhzy.jcsjxt.mapper.JCSJDetailItemMapper;
import com.yyk.sz.zhzy.jcsjxt.mapper.JCSJDetailItemSubMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class JCSJDetailItemServiceImpl implements JCSJDetailItemService {

    @Autowired
    private JCSJDetailItemMapper jcsjDetailItemMapper;

    @Autowired
    private JCSJDetailItemSubMapper jcsjDetailItemSubMapper;

    @Override
    public Paging<JCSJDetailItem> getDetailItem(String detailItemCode, String detailItemName, String pinYinCode, int pageNum, int pageSize, String searchText, String sortName, String sortOrder) {
        return jcsjDetailItemMapper.getDetailItem(detailItemCode,detailItemName,pinYinCode,pageNum, pageSize, searchText, sortName, sortOrder);
    }

    @Override
    public int insertDetailItem(JCSJDetailItem jcsjDetailItem) {
        return jcsjDetailItemMapper.insertDetailItem(jcsjDetailItem);
    }

    @Override
    public int updateDetailItem(JCSJDetailItem jcsjDetailItem) {
        return jcsjDetailItemMapper.updateDetailItem(jcsjDetailItem);
    }

    @Override
    public int deleteDetailItem(String detailItemCode) {
        return jcsjDetailItemMapper.deleteDetailItem(detailItemCode);
    }

    @Override
    public List<JCSJDetailItem> CheckDetailItemExits(String detailItemCode,String detailItemName) {
        return jcsjDetailItemMapper.CheckDetailItemExits(detailItemCode,detailItemName);
    }

    @Override
    public int insertDetailItemSub(JCSJDetailItemSub jcsjDetailItemSub) {
        return jcsjDetailItemSubMapper.insertDetailItemSub(jcsjDetailItemSub);
    }

    @Override
    public int deleteDetailItemSub(String detailItemCode) {
        return jcsjDetailItemSubMapper.deleteDetailItemSub(detailItemCode);
    }

    @Override
    public List<JCSJDetailItemSub> getFromDetailItemSubByDetailItemCode(String detailItemCode) {
        return jcsjDetailItemSubMapper.getFromDetailItemSubByDetailItemCode(detailItemCode);
    }
}
