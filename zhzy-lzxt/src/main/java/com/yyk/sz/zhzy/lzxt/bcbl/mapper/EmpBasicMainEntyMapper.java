package com.yyk.sz.zhzy.lzxt.bcbl.mapper;

import com.yyk.sz.zhzy.lzxt.bcbl.entity.EmpBasicInfoRst;
import com.yyk.sz.zhzy.lzxt.bcbl.entity.EmpBasicMainEnty;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmpBasicMainEntyMapper {

    /**
     * 获取病例列表
     *
     * @param mecidalNum
     * @return
     */
    List<EmpBasicMainEnty> getEmpBasicList(@Param("mecidalNum") String mecidalNum);

    /**
     * 获取病例信息
     *
     * @param registrationNum
     * @return
     */
    List<EmpBasicMainEnty> getEmpBasicMainEntyTable(@Param("registrationNum") String registrationNum);

    /**
     * 新增模版
     *
     * @param empBasicMainEnty
     * @return
     */
    boolean insertEmpBasic(@Param("empBasicMainEnty") EmpBasicMainEnty empBasicMainEnty);

    boolean insertEmpBasicSP(@Param("empBasicMainEnty") EmpBasicMainEnty empBasicMainEnty);

    /**
     * 获取病例详情（存储过程）
     *
     * @return
     */
    void getEmpBasicInfo(@Param("registrationNum") String registrationNum, @Param("drugFlag") String drugFlag, @Param("proUUID") String proUUID);

    /**
     * 获取病例详情结果
     *
     * @return
     */
    List<EmpBasicInfoRst> getEmpBasicInfoRst(@Param("proUUID") String proUUID);

    /**
     * 修改模版
     *
     * @param empBasicMainEnty
     * @return
     */
    boolean updateEmpBasic(@Param("empBasicMainEnty") EmpBasicMainEnty empBasicMainEnty);

    boolean updateEmpBasicSP(@Param("empBasicMainEnty") EmpBasicMainEnty empBasicMainEnty);

    /**
     * 比较病例-获取病例列表
     *
     * @param mecidalNum
     * @return
     */
    List<EmpBasicMainEnty> getCompareEmpBasicList(@Param("mecidalNum") String mecidalNum);

    /**
     * 比较病例-获取病例信息
     *
     * @param registrationNum
     * @return
     */
    List<EmpBasicMainEnty> getCompareEmpBasicInfo(@Param("registrationNum") String registrationNum);

    /**
     * 比较病例-处方明细
     *
     * @param empBasicMainID
     * @return
     */
    List<EmpBasicMainEnty> getCompareEmpBasicChuFang(@Param("empBasicMainID") String empBasicMainID,@Param("drugFlag") int drugFlag);

    /**
     * 比较病例-处方
     *
     * @param registrationNum
     * @return
     */
    List<EmpBasicMainEnty> getCompareEmpBasicWesternTable(@Param("registrationNum") String registrationNum);

    /**
     * 比较病例-检查项目
     *
     * @param empBasicMainID
     * @return
     */
    List<EmpBasicMainEnty> getCompareEmpBasicCheckItem(@Param("empBasicMainID") String empBasicMainID,@Param("checkFlag") int checkFlag);

    boolean deleteDiseaseSub(@Param("empBasicMainID") int empBasicMainID);

    boolean deleteTongueSub(@Param("empBasicMainID") int empBasicMainID);

    boolean deletePulseSub(@Param("empBasicMainID") int empBasicMainID);

    boolean insertDiseaseSub(@Param("empBasicMainEnty") EmpBasicMainEnty empBasicMainEnty);

    boolean insertTongueSub(@Param("empBasicMainEnty") EmpBasicMainEnty empBasicMainEnty);

    boolean insertPulseSub(@Param("empBasicMainEnty") EmpBasicMainEnty empBasicMainEnty);

    boolean EvaluationCodeRemark(@Param("empBasicMainEnty") EmpBasicMainEnty empBasicMainEnty);

}
