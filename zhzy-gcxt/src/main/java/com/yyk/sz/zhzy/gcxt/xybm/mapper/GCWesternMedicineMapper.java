package com.yyk.sz.zhzy.gcxt.xybm.mapper;

import com.yyk.sz.zhzy.gcxt.xybm.entity.GCWesternMedicine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GCWesternMedicineMapper {

    /**
     * 根据所属部门和用户账号查询症型治法
     *
     * @return
     */
    public List<GCWesternMedicine> getAllWesternMedicineName( @Param("searchText") String searchText);
}
