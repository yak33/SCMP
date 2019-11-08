package com.yyk.sz.zhzy.jcsjxt.service;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJDrugDict;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJUsedPhrases;

import java.util.List;


public interface JCSJUsedPhrasesService {
    Paging<JCSJUsedPhrases> getUsedPhrasesList(String usedPhrasesType,String usedPhrasesName,int pageNum,
                                               int pageSize,
                                               String searchText,
                                               String sortName,
                                               String sortOrder);
    int insertUsedPhrases(JCSJUsedPhrases jcsjUsedPhrases);

    int updateUsedPhrases(JCSJUsedPhrases jcsjUsedPhrases);

    int deleteUsedPhrases(String usedphrasestype,String usedphrasesname);


    List<JCSJUsedPhrases> GetUsedPhrasesByTypeName(String usedPhrasesType,String usedPhrasesName);
}
