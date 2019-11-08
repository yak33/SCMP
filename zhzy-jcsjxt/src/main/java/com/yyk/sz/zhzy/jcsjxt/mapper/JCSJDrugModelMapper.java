package com.yyk.sz.zhzy.jcsjxt.mapper;

import com.yyk.sz.zhzy.jcsjxt.entity.JCSJDrugModel;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JCSJDrugModelMapper {

    List<JCSJDrugModel> getDrugModel();

}