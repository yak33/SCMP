package com.yyk.sz.zhzy.zjxt.cqjyf.mapper;

import com.yyk.sz.zhzy.zjxt.cqjyf.entity.Prescription;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: ZhangChao
 * @Date: 2018/11/23 16:18
 * @Version: 1.0
 */
@Mapper
public interface PrescriptionMapper {

    List<Prescription> getPrescription(Prescription prescription);

    int savePrescriptionZJ(Prescription prescription);

    //
    String getMaxCode();
    List<Prescription> getWantCode(Prescription prescription);

    int delPrescriptionZJ(Prescription prescription);
    int delPrescriptionSubZJ(Prescription prescription);

    int savePrescriptionSubZJ(Prescription prescription);

    List<Prescription> getFangJie(@Param("prescriptionCode") String prescriptionCode);

}
