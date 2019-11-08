package com.yyk.sz.zhzy.jcsjxt.mapper;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJDrugTaboos;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JCSJDrugTaboosMapper {

    int deleteDrugTaboos(@Param("drugtaboostype") String drugtaboostype,
                         @Param("drugcode") String drugcode,
                         @Param("drugcodeone") String drugcodeone);

    int insertDrugTaboos(JCSJDrugTaboos record);

    int updateDrugTaboos(JCSJDrugTaboos record);

    Paging<JCSJDrugTaboos> getDrugTaboosTable(@Param("drugtaboostype") String drugtaboostype,
                                              @Param("drugname") String drugname,
                                              @Param("pageNum") int pageNum,
                                              @Param("pageSize") int pageSize,
                                              @Param("searchText") String searchText,
                                              @Param("sortName") String sortName,
                                              @Param("sortOrder") String sortOrder);

    List<JCSJDrugTaboos> GetDrugAnti(@Param("drugtaboostype") String drugtaboostype,
                                     @Param("drugcode") String drugcode,
                                     @Param("drugcodeone") String drugcodeone);

    List<JCSJDrugTaboos> GetDrugSM(@Param("drugtaboostype") String drugtaboostype,
                                   @Param("drugcode") String drugcode);

    List<JCSJDrugTaboos> GetDrugToaboosQuanitity(@Param("drugtaboostype") String drugtaboostype,
                                                 @Param("drugcode") String drugcode);
}