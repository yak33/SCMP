package com.yyk.sz.zhzy.zjxt.lczl.mapper;

import com.yyk.sz.zhzy.zjxt.lczl.entity.WesternCure;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WesternCureMapper {

    List<WesternCure> getWesternCureList(@Param("searchText") String searchText);

    List<WesternCure> getWesternCureDetailList(@Param("detailItemCode") String detailItemCode);

    List<WesternCure> getYiCunMedicareCure(@Param("empBasicMainID") Integer empBasicMainID);

    int delFangJiDetailSub(@Param("empBasicMainID") Integer empBasicMainID);

    int delFangJiSub(@Param("empBasicMainID") Integer empBasicMainID);

    int saveWesternCure(WesternCure westernCure);

    WesternCure getFangJiSubID(WesternCure westernCure);

    int saveWesternCureFangjiDetail(WesternCure westernCure);

    String getDetailItemName(String detailItemCode);

}
