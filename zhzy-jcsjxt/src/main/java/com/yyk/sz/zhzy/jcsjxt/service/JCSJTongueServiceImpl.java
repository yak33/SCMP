package com.yyk.sz.zhzy.jcsjxt.service;


import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJTongue;
import com.yyk.sz.zhzy.jcsjxt.mapper.JCSJTongueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class JCSJTongueServiceImpl implements JCSJTongueService {


    @Autowired
    private JCSJTongueMapper jcsjTongueMapper;

    @Override
    public Paging<JCSJTongue> getTongueTable(int pageNum,
                                              int pageSize,
                                              String searchText,
                                              String sortName,
                                              String sortOrder) {
        return jcsjTongueMapper.getTongueTable(pageNum, pageSize, searchText, sortName, sortOrder);
    }

    @Override
    public int insertTongue(JCSJTongue jcsjTongue) {
        return jcsjTongueMapper.insertTongue(jcsjTongue);
    }

    @Override
    public int updateTongue(JCSJTongue jcsjTongue) {
        return jcsjTongueMapper.updateTongue(jcsjTongue);
    }

    @Override
    public int deleteTongue(String tonguecode) {
        return jcsjTongueMapper.deleteTongue(tonguecode);
    }

    @Override
    public List<JCSJTongue> checkTongueExits(String tonguecode, String tonguename) {
        return jcsjTongueMapper.checkTongueExits(tonguecode, tonguename);
    }

    @Override
    public List<JCSJTongue> GetMainTongueByTongueCode(String tonguecode) {
        return jcsjTongueMapper.GetMainTongueByTongueCode(tonguecode);
    }
}
