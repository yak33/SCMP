package com.yyk.sz.zhzy.lzxt.xycf.service;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.lzxt.xycf.entity.FangJiCodeRst;
import com.yyk.sz.zhzy.lzxt.xycf.entity.XiYaoInfo;

import java.util.List;

public interface XiYaoInfoService {

    public Paging<XiYaoInfo> getXiYaoTable(
            int pageNum,
            int pageSize,
            String searchText,
            String sortName,
            String sortOrder);

    public List<XiYaoInfo> getDrugWayTable();

    public List<XiYaoInfo> getFrequencyTable();

    public List<XiYaoInfo> getFangJiTable(String empBasicMainID);

    public void GetFangJiCode(XiYaoInfo xiYaoInfo);
    public List<FangJiCodeRst> GetFangJiCodeRst(String proUUID);
}
