package com.yyk.sz.zhzy.lzxt.zxzf.service;


import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.lzxt.zxzf.entity.DialecticalOrCure;
import com.yyk.sz.zhzy.lzxt.zxzf.mapper.DialecticalOrCureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class DialecticalOrCureServiceImpl implements DialecticalOrCureService {


    @Autowired
    private DialecticalOrCureMapper dialecticalOrCureMapper;

    @Override
    public Paging<DialecticalOrCure> getSelectDCTable(
            String deptCode,
            String userCode,
            String dialectical,
            String chineseMedicine,
            int pageNum,
            int pageSize,
            String searchText,
            String sortName,
            String sortOrder){
        return dialecticalOrCureMapper.getSelectDCTable(
                deptCode, userCode, dialectical, chineseMedicine,
                pageNum, pageSize, searchText, sortName, sortOrder);
    }
}
