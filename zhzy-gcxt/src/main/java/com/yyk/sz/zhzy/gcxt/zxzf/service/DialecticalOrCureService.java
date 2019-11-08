package com.yyk.sz.zhzy.gcxt.zxzf.service;


import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.gcxt.zxzf.entity.GCDialecticalOrCure;

public interface DialecticalOrCureService {

    public Paging<GCDialecticalOrCure> getSelectAnorectalDialecticalCure(
            String westernMedicineName,
            int pageNum,
            int pageSize,
            String searchText,
            String sortName,
            String sortOrder);
}
