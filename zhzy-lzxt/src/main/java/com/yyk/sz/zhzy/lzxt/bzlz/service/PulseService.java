package com.yyk.sz.zhzy.lzxt.bzlz.service;

import com.yyk.sz.zhzy.lzxt.bzlz.entity.Pulse;
import com.yyk.sz.zhzy.lzxt.bzlz.entity.Tongue;

import java.util.List;

public interface PulseService {
    public List<Pulse> getPulseTable(String mainSymptomCode);
}
