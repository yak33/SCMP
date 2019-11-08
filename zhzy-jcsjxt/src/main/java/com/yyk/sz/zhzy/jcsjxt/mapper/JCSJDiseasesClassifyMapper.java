package com.yyk.sz.zhzy.jcsjxt.mapper;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJDiseasesClassify;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JCSJDiseasesClassifyMapper {

    int deleteDiseasesClassify(String dccode);

    int deleteDiseasesClassifyCMedicine(String dccode);

    int insertDiseasesClassify(JCSJDiseasesClassify record);

    int updateDiseasesClassify(JCSJDiseasesClassify record);

    int insertDiseasesClassifyCMedicine(@Param("dccode") String dccode, @Param("chinesemedicinecode") String chinesemedicinecode);

    Paging<JCSJDiseasesClassify> getDiseasesClassifyTable(@Param("pageNum") int pageNum,
                                               @Param("pageSize") int pageSize,
                                               @Param("searchText") String searchText,
                                               @Param("sortName") String sortName,
                                               @Param("sortOrder") String sortOrder);

    List<JCSJDiseasesClassify> checkDiseasesClassifyExits(@Param("dccode") String dccode, @Param("dcname") String dcname);
    List<JCSJDiseasesClassify> GetDClassifyCMedicineByDCCode(@Param("dccode") String dccode);
    List<JCSJDiseasesClassify> getChineseMedicineByDCCode(@Param("dccode") String dccode);
}