package com.yyk.sz.zhzy.zjxt.zxzf.service;

import com.yyk.sz.zhzy.zjxt.zxzf.entity.DialecticalOrCureZJ;

import java.util.List;

/**
 * @Author: ZhangChao
 * @Date: 2018/11/30 14:54
 * @Version: 1.0
 */
public interface DialecticalOrCureZJService {

    List<DialecticalOrCureZJ> getDrugSolution(String acupointCode);

    List<DialecticalOrCureZJ> getKaiXue(String fdC6, String fdC7, String fdC10);

    List<DialecticalOrCureZJ> getBiXue(String fdC6, String fdC7, String fdC10);

}
