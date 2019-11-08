package com.yyk.sz.zhzy.lzxt.zjkf.service;

import com.yyk.sz.zhzy.lzxt.zjkf.entity.Taste;

import java.util.List;

public interface TasteService {

    List<Taste> getTasteList(String drugCode);

}
