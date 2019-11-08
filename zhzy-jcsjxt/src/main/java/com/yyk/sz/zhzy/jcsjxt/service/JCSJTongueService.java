package com.yyk.sz.zhzy.jcsjxt.service;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJTongue;

import java.util.List;


public interface JCSJTongueService {
    Paging<JCSJTongue> getTongueTable(int pageNum,
                                        int pageSize,
                                        String searchText,
                                        String sortName,
                                        String sortOrder);
    int insertTongue(JCSJTongue jcsjTongue);

    int updateTongue(JCSJTongue jcsjTongue);

    int deleteTongue(String tonguecode);

    List<JCSJTongue> checkTongueExits(String tonguecode, String tonguename);
    List<JCSJTongue> GetMainTongueByTongueCode(String tonguecode);

}
