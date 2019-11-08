package com.yyk.sz.zhzy.jcsjxt.mapper;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJPulse;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JCSJPulseMapper {

    int deletePulse(String pulsecode);

    int insertPulse(JCSJPulse record);
    Paging<JCSJPulse> getPulseTable(@Param("pageNum") int pageNum,
                                     @Param("pageSize") int pageSize,
                                     @Param("searchText") String searchText,
                                     @Param("sortName") String sortName,
                                     @Param("sortOrder") String sortOrder);

    int updatePulse(JCSJPulse record);

    List<JCSJPulse> checkPulseExits(@Param("pulsecode") String pulsecode, @Param("pulsename") String pulsename);
    List<JCSJPulse> GetMainPulseByPulseCode(@Param("pulsecode") String pulsecode);
}