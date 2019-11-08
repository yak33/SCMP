package com.yyk.sz.zhzy.zjxt.zxzf.service;

import com.yyk.sz.zhzy.zjxt.zxzf.entity.DialecticalOrCureZJ;
import com.yyk.sz.zhzy.zjxt.zxzf.mapper.DialecticalOrCureZJMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: ZhangChao
 * @Date: 2018/11/30 14:55
 * @Version: 1.0
 */
@Component
@Transactional
public class DialecticalOrCureZJServiceImpl implements DialecticalOrCureZJService {

    @Resource
    private DialecticalOrCureZJMapper dialecticalOrCureZJMapper;

    @Override
    public List<DialecticalOrCureZJ> getDrugSolution(String acupointCode) {
        return dialecticalOrCureZJMapper.getDrugSolution(acupointCode);
    }

    @Override
    public List<DialecticalOrCureZJ> getKaiXue(String fdC6, String fdC7, String fdC10) {
        return dialecticalOrCureZJMapper.getKaiXue(fdC6,fdC7,fdC10);
    }

    @Override
    public List<DialecticalOrCureZJ> getBiXue(String fdC6, String fdC7, String fdC10) {
        return dialecticalOrCureZJMapper.getBiXue(fdC6,fdC7,fdC10);
    }
}
