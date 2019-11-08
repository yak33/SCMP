package com.yyk.sz.zhzy.jcsjxt.mapper;

import com.yyk.sz.zhzy.jcsjxt.entity.JCSJPrescriptionSub;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JCSJPrescriptionSubMapper {

    int insertPrescriptionSub(JCSJPrescriptionSub record);

    int updatePrescriptionSub(JCSJPrescriptionSub record);

    List<JCSJPrescriptionSub> GetPrescriptionMedicineSub(@Param("prescriptioncode") String prescriptioncode);
}