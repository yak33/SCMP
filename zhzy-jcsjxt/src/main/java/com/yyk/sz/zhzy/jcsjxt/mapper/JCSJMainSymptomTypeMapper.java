package com.yyk.sz.zhzy.jcsjxt.mapper;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJMainSymptomType;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JCSJMainSymptomTypeMapper {

    int deleteMainSymptomType(String mainsymptomtypecode);

    int insertMainSymptomType(JCSJMainSymptomType record);

    Paging<JCSJMainSymptomType> getMainSymptomTypeTable(@Param("pageNum") int pageNum,
                                                          @Param("pageSize") int pageSize,
                                                          @Param("searchText") String searchText,
                                                          @Param("sortName") String sortName,
                                                          @Param("sortOrder") String sortOrder);


    int updateMainSymptomType(JCSJMainSymptomType record);

    List<JCSJMainSymptomType> GetMainSymptomByMainSymptomTypeCode(@Param("mainsymptomtypecode") String mainsymptomtypecode);

    List<JCSJMainSymptomType> checkMainSymptomTypeExits(@Param("mainsymptomtypecode") String mainsymptomtypecode,@Param("mainsymptomtypename") String mainsymptomtypename);
}