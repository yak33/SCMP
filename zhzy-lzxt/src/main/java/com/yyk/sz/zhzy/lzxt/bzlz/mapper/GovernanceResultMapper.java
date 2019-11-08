package com.yyk.sz.zhzy.lzxt.bzlz.mapper;

import com.yyk.sz.zhzy.lzxt.bzlz.entity.GRListRst;
import com.yyk.sz.zhzy.lzxt.bzlz.entity.GovernanceResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: ZhangChao
 * @Date: 2018-11-13 10:26
 */
@Mapper
public interface GovernanceResultMapper {

    /**
     * 获取论治结果（存储过程）
     * @param governanceResult
     * @return
     */
    void getGRList(GovernanceResult governanceResult);

    /**
     * 获取论治结果
     * @param proUUID
     * @return
     */
    List<GRListRst> getGRListRst(String proUUID);

    /**
     * 根据选中的论治结果里的方剂编码获取该方剂里的草药信息
     * @param
     * @return
     */
    List<GovernanceResult> getDrugByPrescriptionCode(@Param("prescriptionCode") String prescriptionCode);

    /**
     * 根据选中的论治结果里的方剂编码获取方解信息
     * @param
     * @return
     */
    List<GovernanceResult> getCalciteByPrescriptionCode(@Param("prescriptionCode") String prescriptionCode);

    /**
     * 获取所有归经--ZJFlag = 0
     * @return
     */
    List<GovernanceResult> getMeridian();

    /**
     * 获取归经分值--根据病人信息ID
     * @param empBasicMainID
     * @return
     */
    List<GovernanceResult> getMeridianScore(@Param("empBasicMainID") int empBasicMainID);
    /**
     * 获取性味分值--根据病人信息ID
     * @param empBasicMainID
     * @return
     */
    List<GovernanceResult> getTasteScore(@Param("empBasicMainID") int empBasicMainID);

    List<GovernanceResult> getDTZXTData(@Param("drugCodeStr") String drugCodeStr);

    List<GovernanceResult> getHRWP(@Param("DCStr") String DCStr);

}
