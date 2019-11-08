package com.yyk.sz.zhzy.zjxt.bzlz.mapper;

import com.yyk.sz.zhzy.zjxt.bzlz.entity.Acupoint;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: ZhangChao
 * @Date: 2018/11/23 15:39
 * @Version: 1.0
 */
@Mapper
public interface AcupointMapper {

    List<Acupoint> getAllAcupoint(@Param("searchText") String searchText);

    List<Acupoint> getAcupointByPrescriptionCode(
            @Param("prescriptionCode") String prescriptionCode);
}
