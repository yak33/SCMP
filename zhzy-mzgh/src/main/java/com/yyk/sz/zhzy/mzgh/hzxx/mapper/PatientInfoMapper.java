package com.yyk.sz.zhzy.mzgh.hzxx.mapper;

import com.yyk.sz.zhzy.mzgh.hzxx.entity.EmpBasicIdCodeRst;
import com.yyk.sz.zhzy.mzgh.hzxx.entity.PatientInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PatientInfoMapper {

    /**
     * 查询患者信息
     *
     * @param registrationNum
     * @return
     */
    List<PatientInfo> getSelectPatientInfoTable(@Param("registrationNum") String registrationNum);

    /**
     * 修改患者信息
     *
     * @param patientInfo
     * @return
     */
    boolean updatePatientInfo(@Param("patientInfo") PatientInfo patientInfo);
    boolean updateHisPatientInfo(@Param("patientInfo") PatientInfo patientInfo);

    /**
     * 增加患者信息
     *
     * @param patientInfo
     * @return
     */
    boolean insertPatientInfo(PatientInfo patientInfo);

    boolean insertHisPatientInfo(PatientInfo patientInfo);

    /**
     * 生成挂号序号
     *
     * @return
     */
    void getBillCode(PatientInfo patientInfo);

    /**
     * 获取挂号序号
     *
     * @return
     */
    List<EmpBasicIdCodeRst> GetEmpBasicIdCodeRst(@Param("proUUID") String proUUID);
}
