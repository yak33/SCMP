package com.yyk.sz.zhzy.common.mapper;

import com.yyk.sz.zhzy.common.entity.Dictionary;
import com.yyk.sz.zhzy.common.entity.MecidalType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MecidalTypeMapper {

    /**
     * 根据checkFlag查询
     *
     * @param checkFlag
     * @return
     */
    List<MecidalType> getMecidalType(@Param("checkFlag") String checkFlag);
}
