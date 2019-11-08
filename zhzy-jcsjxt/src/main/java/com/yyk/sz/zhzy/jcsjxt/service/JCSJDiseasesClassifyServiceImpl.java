package com.yyk.sz.zhzy.jcsjxt.service;


import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJDiseasesClassify;
import com.yyk.sz.zhzy.jcsjxt.mapper.JCSJDiseasesClassifyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class JCSJDiseasesClassifyServiceImpl implements JCSJDiseasesClassifyService {


    @Autowired
    private JCSJDiseasesClassifyMapper jcsjDiseasesClassifyMapper;

    @Override
    public Paging<JCSJDiseasesClassify> getDiseasesClassifyTable(int pageNum,
                                                      int pageSize,
                                                      String searchText,
                                                      String sortName,
                                                      String sortOrder) {
        return jcsjDiseasesClassifyMapper.getDiseasesClassifyTable(pageNum, pageSize, searchText, sortName, sortOrder);
    }

    @Override
    public int insertDiseasesClassify(JCSJDiseasesClassify jcsjDiseasesClassify) {
        return jcsjDiseasesClassifyMapper.insertDiseasesClassify(jcsjDiseasesClassify);
    }

    @Override
    public int updateDiseasesClassify(JCSJDiseasesClassify jcsjDiseasesClassify) {
        return jcsjDiseasesClassifyMapper.updateDiseasesClassify(jcsjDiseasesClassify);
    }

    @Override
    public int deleteDiseasesClassify(String dccode) {
        return jcsjDiseasesClassifyMapper.deleteDiseasesClassify(dccode);
    }

    @Override
    public int deleteDiseasesClassifyCMedicine(String dccode) {
        return jcsjDiseasesClassifyMapper.deleteDiseasesClassifyCMedicine(dccode);
    }

    @Override
    public int insertDiseasesClassifyCMedicine(String dccode, String chinesemedicinecode) {
        return jcsjDiseasesClassifyMapper.insertDiseasesClassifyCMedicine(dccode,chinesemedicinecode);
    }

    @Override
    public List<JCSJDiseasesClassify> checkDiseasesClassifyExits(String dccode, String dcname) {
        return jcsjDiseasesClassifyMapper.checkDiseasesClassifyExits(dccode, dcname);
    }

    @Override
    public List<JCSJDiseasesClassify> GetDClassifyCMedicineByDCCode(String dccode) {
        return jcsjDiseasesClassifyMapper.GetDClassifyCMedicineByDCCode(dccode);
    }

    @Override
    public List<JCSJDiseasesClassify> getChineseMedicineByDCCode(String dccode) {
        return jcsjDiseasesClassifyMapper.getChineseMedicineByDCCode(dccode);
    }
}
