package com.yyk.sz.zhzy.lzxt.cjyf.mapper;

import com.yyk.sz.zhzy.lzxt.cjyf.entity.PrescriptionMain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PrescriptionMainMapper {
    /**
     * 存经验方
     * @param prescriptionMain
     * @return
     */
    int insertMain(PrescriptionMain prescriptionMain);

    int insertSub(PrescriptionMain prescriptionMain);

    List<PrescriptionMain> getWantCode(PrescriptionMain prescription);

    int delPrescriptionZJ(PrescriptionMain prescription);
    int delPrescriptionSubZJ(PrescriptionMain prescription);

    List<PrescriptionMain> getClassify();
    List<PrescriptionMain> getSufferType();

}
