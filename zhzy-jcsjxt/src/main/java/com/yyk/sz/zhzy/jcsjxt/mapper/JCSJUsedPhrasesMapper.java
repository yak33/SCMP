package com.yyk.sz.zhzy.jcsjxt.mapper;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJUsedPhrases;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JCSJUsedPhrasesMapper {

    int deleteUsedPhrases(@Param("usedphrasestype") String usedphrasestype,
                          @Param("usedphrasesname") String usedphrasesname);

    int insertUsedPhrases(JCSJUsedPhrases record);


    Paging<JCSJUsedPhrases> getUsedPhrasesList(@Param("usedPhrasesType") String usedPhrasesType,
                                               @Param("usedPhrasesName") String usedPhrasesName, @Param("pageNum") int pageNum,
                                               @Param("pageSize") int pageSize,
                                               @Param("searchText") String searchText,
                                               @Param("sortName") String sortName,
                                               @Param("sortOrder") String sortOrder);


    int updateUsedPhrases(JCSJUsedPhrases record);

    List<JCSJUsedPhrases> GetUsedPhrasesByTypeName(@Param("usedPhrasesType") String usedPhrasesType,
                                                   @Param("usedPhrasesName") String usedPhrasesName);

}