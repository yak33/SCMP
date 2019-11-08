package com.yyk.sz.zhzy.lzxt.xycf.mapper;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.lzxt.xycf.entity.GyDrugDict;
import com.yyk.sz.zhzy.lzxt.xycf.entity.XiYaoInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GyDrugDictMapper {

    /**
     * 根据病人信息单号和方剂ID获取西药信息
     *
     * @return
     */
    public List<GyDrugDict> getWesternDrugByFangJiSubID(@Param("empBasicMainID") int empBasicMainID, @Param("fangJiSubID") int fangJiSubID);
}

