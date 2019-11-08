package com.yyk.sz.zhzy.lzxt.zjkf.mapper;

import com.yyk.sz.zhzy.lzxt.zjkf.entity.DirectPrescription;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DirectPrescriptionMapper {

    /**
     * 获取草药列表--根据drugModelCode和stopFlag
     * @param drugModelCode
     * @param stopFlag
     * @return
     */
    public List<DirectPrescription> getDrugDictList(
            @Param("drugModelCode") String drugModelCode,
            @Param("stopFlag") String stopFlag,
            @Param("inputCode") String inputCode,
            @Param("drugTaste") String drugTaste,
            @Param("drugMeridian") String drugMeridian
    );

    /**
     * 获取所有中医病名
     * @param chineseMedicineCode
     * @param chineseMedicineName
     * @param pinYinCode
     * @return
     */
    public List<DirectPrescription> getChineseMedicineList(
            @Param("chineseMedicineCode") String chineseMedicineCode,
            @Param("chineseMedicineName") String chineseMedicineName,
            @Param("pinYinCode") String pinYinCode,
            @Param("searchText") String searchText
    );

    /**
     * 获取所有西医病名
     * @param westernMedicineCode
     * @param westernMedicineName
     * @param pinYinCode
     * @return
     */
    public List<DirectPrescription> getWesternMedicineList(
            @Param("westernMedicineCode") String westernMedicineCode,
            @Param("westernMedicineName") String westernMedicineName,
            @Param("pinYinCode") String pinYinCode,
            @Param("searchText") String searchText
    );


    List<DirectPrescription> getTaste();
    List<DirectPrescription> getMeridian();

}
