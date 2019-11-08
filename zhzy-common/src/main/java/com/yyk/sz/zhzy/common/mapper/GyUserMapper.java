package com.yyk.sz.zhzy.common.mapper;

import com.yyk.sz.zhzy.common.entity.GyUser;
import com.yyk.sz.zhzy.common.entity.MecidalType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GyUserMapper {

    /**
     * 根据deptCode查询
     *
     * @param deptCode
     * @return
     */
    List<GyUser> getGyUser(@Param("deptCode") String deptCode);
}
