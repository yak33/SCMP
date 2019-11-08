package com.yyk.sz.zhzy.lzxt.jyjc.mapper;

import com.yyk.sz.zhzy.lzxt.jyjc.entity.CheckItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: ZhangChao
 * @Date: 2018-11-14 10:00
 */
@Mapper
public interface CheckItemMapper {
    /**
     * 获取检验项目or检查项目-- 0：检查，1：检验
     * @param detailItemFlag
     * @return
     */
    List<CheckItem> getCheckItemList(@Param("detailItemFlag") int detailItemFlag);

    /**
     * 获取检验或检查项目明细
     * @param summaryCode
     * @return
     */
    List<CheckItem> getCheckItemDetailList(@Param("summaryCode") String summaryCode);

    /**
     * 获取已存的检验或检查项目
     * @param empBasicMainID
     * @param checkFlag
     * @return
     */
    List<CheckItem> getYiCunCheckItemList(
            @Param("empBasicMainID") Integer empBasicMainID,
            @Param("checkFlag") Integer checkFlag);

    /**
     * 更新临床和门诊备注
     * @param checkItem
     * @return
     */
    int updateRemark(@Param("checkItem") CheckItem checkItem);

    int delCheckSub(CheckItem checkItem);
    int insertCheckSub(CheckItem checkItem);

    String getDetailItemName(String detailItemCode);

}
