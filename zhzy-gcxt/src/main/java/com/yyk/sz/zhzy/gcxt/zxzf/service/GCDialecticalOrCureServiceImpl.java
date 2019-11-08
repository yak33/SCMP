package com.yyk.sz.zhzy.gcxt.zxzf.service;


import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.gcxt.zxzf.entity.GCDialecticalOrCure;
import com.yyk.sz.zhzy.gcxt.zxzf.mapper.GCDialecticalOrCureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class GCDialecticalOrCureServiceImpl implements DialecticalOrCureService {


    @Autowired
    private GCDialecticalOrCureMapper gcdialecticalOrCureMapper;

    @Override
    public Paging<GCDialecticalOrCure> getSelectAnorectalDialecticalCure(
            String westernMedicineName,
            int pageNum,
            int pageSize,
            String searchText,
            String sortName,
            String sortOrder){
        return gcdialecticalOrCureMapper.getSelectAnorectalDialecticalCure(westernMedicineName,
                pageNum, pageSize, searchText, sortName, sortOrder);
    }
}
