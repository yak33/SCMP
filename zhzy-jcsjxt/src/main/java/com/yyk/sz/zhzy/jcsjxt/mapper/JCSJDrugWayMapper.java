package com.yyk.sz.zhzy.jcsjxt.mapper;

import com.yyk.sz.zhzy.jcsjxt.entity.JCSJDrugWay;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JCSJDrugWayMapper {

    List<JCSJDrugWay> getDrugWay();
}