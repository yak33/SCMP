package com.yyk.sz.zhzy.jcsjxt.mapper;

import com.yyk.sz.zhzy.jcsjxt.entity.JCSJProcess;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JCSJProcessMapper {

    List<JCSJProcess> getProcess();
}