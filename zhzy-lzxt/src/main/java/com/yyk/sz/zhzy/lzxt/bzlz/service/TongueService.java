package com.yyk.sz.zhzy.lzxt.bzlz.service;

import com.yyk.sz.zhzy.lzxt.bzlz.entity.Disease;
import com.yyk.sz.zhzy.lzxt.bzlz.entity.Tongue;

import java.util.List;

public interface TongueService {
    public List<Tongue> getTongueTable(String mainSymptomCode);
}
