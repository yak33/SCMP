package com.yyk.sz.zhzy.lzxt.zjkf.service;

import com.yyk.sz.zhzy.lzxt.zjkf.entity.Meridian;

import java.util.List;

public interface MeridianService {

    List<Meridian> getMeridianList(String drugCode);
}
