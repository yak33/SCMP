package com.yyk.sz.zhzy.lzxt.zjkf.service;

import com.yyk.sz.zhzy.lzxt.zjkf.entity.Process;

import java.util.List;

public interface ProcessService {

    List<Process> getProcessList(String drugCode);
}
