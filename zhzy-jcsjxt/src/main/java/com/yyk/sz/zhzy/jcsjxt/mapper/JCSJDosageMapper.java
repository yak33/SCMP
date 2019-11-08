package com.yyk.sz.zhzy.jcsjxt.mapper;

import com.yyk.sz.zhzy.jcsjxt.entity.JCSJDosage;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JCSJDosageMapper {

    List<JCSJDosage> getDosage();
}