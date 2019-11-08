package com.yyk.sz.zhzy.zjxt.zjgl.service;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.zjxt.zjgl.entity.AcuMan;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: ZhangChao
 * @Date: 2019/2/19 12:06
 * @Version: 1.0
 */
public interface AcuManService {

    Paging<AcuMan> getAcuManAll(int pageNum,
                              int pageSize,
                              String searchText,
                              String sortName,
                              String sortOrder);

    Paging<AcuMan> getAcuManNoList(int pageNum,
                                   int pageSize,
                                   String searchText,
                                   String sortName,
                                   String sortOrder);

    Paging<AcuMan> getAcuManYesList(int pageNum,
                                  int pageSize,
                                  String searchText,
                                  String sortName,
                                  String sortOrder,
                                  String strDateTime);

    Paging<AcuMan> getAcuManIngList(int pageNum,
                                    int pageSize,
                                    String searchText,
                                    String sortName,
                                    String sortOrder,
                                    String strDateTime);

    int updateZZDateTime(AcuMan acuMan);
}
