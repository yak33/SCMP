package com.yyk.sz.zhzy.common.mapper;

import com.yyk.sz.zhzy.common.entity.Dictionary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DictionaryMapper {

    /**
     * 根据type查询字典项
     *
     * @param type
     * @return
     */
    List<Dictionary> getDictionaryByType(@Param("type") String type);
}
