package com.yyk.sz.zhzy.lzxt.xycf.service;


import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.lzxt.xycf.entity.GyDrugDict;
import com.yyk.sz.zhzy.lzxt.xycf.entity.XiYaoInfo;
import com.yyk.sz.zhzy.lzxt.xycf.mapper.GyDrugDictMapper;
import com.yyk.sz.zhzy.lzxt.xycf.mapper.XiYaoInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
@Transactional
public class GyDrugDictServiceImpl implements GyDrugDictService {


    @Autowired
    private GyDrugDictMapper gyDrugDictMapper;

    @Override
    public List<GyDrugDict> getWesternDrugByFangJiSubID(int empBasicMainID, int fangJiSubID) {
        return gyDrugDictMapper.getWesternDrugByFangJiSubID(empBasicMainID,fangJiSubID);
    }
}
