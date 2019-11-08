package com.yyk.sz.zhzy.lzxt.qjyf.mapper;

import com.yyk.sz.zhzy.lzxt.qjyf.entity.GetPrescription;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GetPrescriptionMapper {
    /**
     * 取经验方
     * @param getPrescription
     * @return
     */
    public List<GetPrescription> selectPrescriptionList(GetPrescription getPrescription);
}
