package com.yyk.sz.zhzy.jcsjxt.service;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJPulse;

import java.util.List;


public interface JCSJPulseService {
    Paging<JCSJPulse> getPulseTable(int pageNum,
                                      int pageSize,
                                      String searchText,
                                      String sortName,
                                      String sortOrder);
    int insertPulse(JCSJPulse jcsjPulse);

    int updatePulse(JCSJPulse jcsjPulse);

    int deletePulse(String pulsecode);

    List<JCSJPulse> checkPulseExits(String pulsecode, String pulsename);
    List<JCSJPulse> GetMainPulseByPulseCode(String pulsecode);

}
