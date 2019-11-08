package com.yyk.sz.zhzy.jcsjxt.mapper;

import com.yyk.sz.zhzy.jcsjxt.entity.JCSJDetailItemSub;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JCSJDetailItemSubMapper {

    int deleteDetailItemSub(@Param("detailItemCode") String detailItemCode);

    int insertDetailItemSub(JCSJDetailItemSub record);

    List<JCSJDetailItemSub> getFromDetailItemSubByDetailItemCode(@Param("detailItemCode") String detailItemCode);

}