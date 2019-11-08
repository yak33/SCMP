package com.yyk.sz.zhzy.jcsjxt.service;


import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJDialectical;
import com.yyk.sz.zhzy.jcsjxt.mapper.JCSJDialecticalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class JCSJDialecticalServiceImpl implements JCSJDialecticalService {


    @Autowired
    private JCSJDialecticalMapper jcsjDialecticalMapper;

    @Override
    public Paging<JCSJDialectical> getDialecticalTable(int pageNum,
                                                 int pageSize,
                                                 String searchText,
                                                 String sortName,
                                                 String sortOrder) {
        return jcsjDialecticalMapper.getDialecticalTable(pageNum, pageSize, searchText, sortName, sortOrder);
    }

    @Override
    public int insertDialectical(JCSJDialectical jcsjDialectical) {
        return jcsjDialecticalMapper.insertDialectical(jcsjDialectical);
    }

    @Override
    public int updateDialectical(JCSJDialectical jcsjDialectical) {
        return jcsjDialecticalMapper.updateDialectical(jcsjDialectical);
    }

    @Override
    public int deleteDialectical(String dialecticalcode) {
        return jcsjDialecticalMapper.deleteDialectical(dialecticalcode);
    }

    @Override
    public List<JCSJDialectical> checkDialecticalExits(String dialecticalcode, String dialecticalname) {
        return jcsjDialecticalMapper.checkDialecticalExits(dialecticalcode, dialecticalname);
    }

    @Override
    public List<JCSJDialectical> GetMainSymptomInfoByDialecticalCode(String dialecticalcode) {
        return jcsjDialecticalMapper.GetMainSymptomInfoByDialecticalCode(dialecticalcode);
    }
}
