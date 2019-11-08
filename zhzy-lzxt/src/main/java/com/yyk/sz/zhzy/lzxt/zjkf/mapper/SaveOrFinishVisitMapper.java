package com.yyk.sz.zhzy.lzxt.zjkf.mapper;

import com.yyk.sz.zhzy.lzxt.zjkf.entity.SaveOrFinishVisit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface SaveOrFinishVisitMapper {

    int delFangJiDetailSub(SaveOrFinishVisit saveOrFinishVisit);

    int delFangJiSub(SaveOrFinishVisit saveOrFinishVisit);

    int insertFangJiSub(SaveOrFinishVisit saveOrFinishVisit);

    int updateEmpBasicMain(SaveOrFinishVisit saveOrFinishVisit);

    int updateHISEmpBasicMain(SaveOrFinishVisit saveOrFinishVisit);
    int updateHISEmpBasicMain1(@Param("registrationNum") String registrationNum);

    List<SaveOrFinishVisit> getFangJiSubIDcc(@Param("empBasicMainID") int empBasicMainID);
    int delFangJiDetailSubcc(@Param("fangJiSubID") int fangJiSubID);
    int insertFangJiDetailSubcc(SaveOrFinishVisit saveOrFinishVisit);
    int updateFangJiDetailSubcc(SaveOrFinishVisit saveOrFinishVisit);

    SaveOrFinishVisit getDrugDict(@Param("drugCode") String drugCode);

    List<SaveOrFinishVisit> getFangJiDetailSub(SaveOrFinishVisit saveOrFinishVisit);
    List<SaveOrFinishVisit> getFangJi(SaveOrFinishVisit saveOrFinishVisit);
}
