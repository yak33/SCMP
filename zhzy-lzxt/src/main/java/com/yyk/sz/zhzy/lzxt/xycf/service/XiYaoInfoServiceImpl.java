package com.yyk.sz.zhzy.lzxt.xycf.service;


import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.lzxt.xycf.entity.FangJiCodeRst;
import com.yyk.sz.zhzy.lzxt.xycf.entity.XiYaoInfo;
import com.yyk.sz.zhzy.lzxt.xycf.mapper.XiYaoChuFangMapper;
import com.yyk.sz.zhzy.lzxt.xycf.mapper.XiYaoInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
@Transactional
public class XiYaoInfoServiceImpl implements XiYaoInfoService {


    @Autowired
    private XiYaoInfoMapper xiYaoInfoMapper;

    @Override
    public Paging<XiYaoInfo> getXiYaoTable(
            int pageNum,
            int pageSize,
            String searchText,
            String sortName,
            String sortOrder){
        return xiYaoInfoMapper.getXiYaoTable(pageNum, pageSize, searchText, sortName, sortOrder);
    }

    @Override
    public List<XiYaoInfo> getDrugWayTable() {
        return xiYaoInfoMapper.getDrugWayTable();
    }

    @Override
    public List<XiYaoInfo> getFrequencyTable() {
        return xiYaoInfoMapper.getFrequencyTable();
    }

    @Override
    public List<XiYaoInfo> getFangJiTable(String empBasicMainID) {
        return xiYaoInfoMapper.getFangJiTable(empBasicMainID);
    }


    @Override
    public void GetFangJiCode(XiYaoInfo xiYaoInfo) {
        xiYaoInfoMapper.GetFangJiCode(xiYaoInfo);
    }
    @Override
    public List<FangJiCodeRst> GetFangJiCodeRst(String proUUID){ return xiYaoInfoMapper.GetFangJiCodeRst(proUUID);}
}
