package com.yyk.sz.zhzy.lzxt.zxzf.service;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.lzxt.zxzf.entity.DialecticalOrCure;

public interface DialecticalOrCureService {

    public Paging<DialecticalOrCure> getSelectDCTable(
            String deptCode,
            String userCode,
            String dialectical,
            String chineseMedicine,
            int pageNum,
            int pageSize,
            String searchText,
            String sortName,
            String sortOrder);
}
