package com.yyk.sz.zhzy.lzxt.xycf.service;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.lzxt.xycf.entity.WesternMedicine;

public interface WesternMedicineService {

    public Paging<WesternMedicine> getWesternMedicine(int pageNum,
                                                      int pageSize,
                                                      String searchText,
                                                      String sortName,
                                                      String sortOrder);
}
