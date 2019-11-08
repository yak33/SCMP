package com.yyk.sz.zhzy.zjxt.lczl.service;


import com.yyk.sz.zhzy.zjxt.lczl.entity.FangJiZJCodeRst;
import com.yyk.sz.zhzy.zjxt.lczl.entity.SFangJiCode;
import com.yyk.sz.zhzy.zjxt.lczl.mapper.SFangJiCodeMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Component
@Transactional
public class SFangJiCodeServiceImpl implements SFangJiCodeService {

    @Resource
    private SFangJiCodeMapper sFangJiCodeMapper;

    @Override
    public void GetFangJiCode(SFangJiCode sFangJiCode) {
        sFangJiCodeMapper.GetFangJiCode(sFangJiCode);
    }

    @Override
    public List<FangJiZJCodeRst> GetFangJiZJCodeRst(String proUUID) {
        return sFangJiCodeMapper.GetFangJiZJCodeRst(proUUID);
    }
}
