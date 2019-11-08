package com.yyk.sz.zhzy.common.mapper;

import com.yyk.sz.zhzy.common.entity.DeptMent;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface DeptMentMapper {

    /**
     * 获取科室信息
     *
     * @return
     */
    List<DeptMent> getKeShi();
}
