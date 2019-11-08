package com.yyk.sz.zhzy.zjxt.bzlz.mapper;

import com.yyk.sz.zhzy.zjxt.bzlz.entity.MainSymptomZJ;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MainSymptomZJMapper {

    /**
     * 根据所属部门和用户账号查询主症
     *
     * @param deptCode
     * @param userCode
     * @return
     */
    List<MainSymptomZJ> getMainSymptomList(@Param("deptCode") String deptCode, @Param("userCode") String userCode);

    /**
     * 获取兼症（根据主症编码获取对应的兼症）
     * @param mainSymptomCode
     * @return
     */
    List<MainSymptomZJ> getDiseaseList(@Param("mainSymptomCode") int mainSymptomCode);

    /**
     * 获取舌像（根据主症编码获取对应的舌像）
     *
     * @param mainSymptomCode 主症编码
     * @return
     */
    List<MainSymptomZJ> getTongueList(@Param("mainSymptomCode") int mainSymptomCode);

    /**
     * 获取脉象（根据主症编码获取对应的脉象）
     *
     * @param mainSymptomCode 主症编码
     * @return
     */
    List<MainSymptomZJ> getPulseList(@Param("mainSymptomCode") int mainSymptomCode);

}
