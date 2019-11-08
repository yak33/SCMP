package com.yyk.sz.zhzy.jcsjxt.service;


import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJUsedPhrases;
import com.yyk.sz.zhzy.jcsjxt.mapper.JCSJUsedPhrasesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class JCSJUsedPhrasesServiceImpl implements JCSJUsedPhrasesService {


    @Autowired
    private JCSJUsedPhrasesMapper jcsjUsedPhrasesMapper;

    @Override
    public Paging<JCSJUsedPhrases> getUsedPhrasesList(String usedPhrasesType,String usedPhrasesName,int pageNum,
                                                          int pageSize,
                                                          String searchText,
                                                          String sortName,
                                                          String sortOrder) {
        return jcsjUsedPhrasesMapper.getUsedPhrasesList(usedPhrasesType,usedPhrasesName,pageNum, pageSize, searchText, sortName, sortOrder);
    }

    @Override
    public int insertUsedPhrases(JCSJUsedPhrases jcsjUsedPhrases) {
        return jcsjUsedPhrasesMapper.insertUsedPhrases(jcsjUsedPhrases);
    }

    @Override
    public int updateUsedPhrases(JCSJUsedPhrases jcsjUsedPhrases) {
        return jcsjUsedPhrasesMapper.updateUsedPhrases(jcsjUsedPhrases);
    }

    @Override
    public int deleteUsedPhrases(String usedphrasestype,String usedphrasesname) {
        return jcsjUsedPhrasesMapper.deleteUsedPhrases(usedphrasestype,usedphrasesname);
    }

    @Override
    public List<JCSJUsedPhrases> GetUsedPhrasesByTypeName(String usedPhrasesType,String usedPhrasesName) {
        return jcsjUsedPhrasesMapper.GetUsedPhrasesByTypeName(usedPhrasesType,usedPhrasesName);
    }
}
