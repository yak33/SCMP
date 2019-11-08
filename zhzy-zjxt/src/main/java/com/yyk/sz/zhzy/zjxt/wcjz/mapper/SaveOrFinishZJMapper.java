package com.yyk.sz.zhzy.zjxt.wcjz.mapper;

import com.yyk.sz.zhzy.zjxt.wcjz.entity.SaveOrFinishZJ;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: ZhangChao
 * @Date: 2018/12/4 11:12
 * @Version: 1.0
 */
@Mapper
public interface SaveOrFinishZJMapper {

    int delFangJiDetailSub(@Param("empBasicMainID") String empBasicMainID);

    int delFangJiSub(@Param("empBasicMainID") String empBasicMainID);

    int insertFangJiSub(SaveOrFinishZJ saveOrFinishZJ);

    List<SaveOrFinishZJ> getFangJiSubIDcc(@Param("empBasicMainID") String empBasicMainID);

    int insertFangJiDetailSubcc(SaveOrFinishZJ saveOrFinishZJ);

    int updateEmpBasicMain(SaveOrFinishZJ saveOrFinishZJ);

    int updateHISEmpBasicMain(SaveOrFinishZJ saveOrFinishZJ);

    SaveOrFinishZJ getDrugDict(@Param("acupointCode") String acupointCode);


}
