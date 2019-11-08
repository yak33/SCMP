package com.yyk.sz.zhzy.jcsjxt.mapper;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJPrescriptionClassify;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JCSJPrescriptionClassifyMapper {

    int deletePrescriptionClassify(String pccode);

    int insertPrescriptionClassify(JCSJPrescriptionClassify record);

    int updatePrescriptionClassify(JCSJPrescriptionClassify record);

    Paging<JCSJPrescriptionClassify> getPrescriptionClassifyTable(@Param("pageNum") int pageNum,
                                                                  @Param("pageSize") int pageSize,
                                                                  @Param("searchText") String searchText,
                                                                  @Param("sortName") String sortName,
                                                                  @Param("sortOrder") String sortOrder);

    List<JCSJPrescriptionClassify> checkPrescriptionClassifyExits(@Param("pccode") String pccode, @Param("pcname") String pcname);
    List<JCSJPrescriptionClassify> GetPrescriptionByPCCode(@Param("pccode") String pccode);
}