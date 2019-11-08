package com.yyk.sz.zhzy.jcsjxt.service;


import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.jcsjxt.entity.*;
import com.yyk.sz.zhzy.jcsjxt.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class JCSJDrugDictServiceImpl implements JCSJDrugDictService {


    @Autowired
    private JCSJDrugDictMapper jcsjDrugDictMapper;

    @Autowired
    private JCSJDosageMapper jcsjDosageMapper;

    @Autowired
    private JCSJDrugModelMapper jcsjDrugModelMapper;

    @Autowired
    private JCSJDrugWayMapper jcsjDrugWayMapper;

    @Autowired
    private JCSJProcessMapper jcsjProcessMapper;

    @Override
    public Paging<JCSJDrugDict> getWesternDistionaryTable(int pageNum,
                                                          int pageSize,
                                                          String searchText,
                                                          String sortName,
                                                          String sortOrder) {
        return jcsjDrugDictMapper.getWesternDistionaryTable(pageNum, pageSize, searchText, sortName, sortOrder);
    }

    @Override
    public Paging<JCSJDrugDict> getDrugDictDistionaryTable(int pageNum, int pageSize, String searchText, String sortName, String sortOrder) {
        return jcsjDrugDictMapper.getDrugDictDistionaryTable(pageNum, pageSize, searchText, sortName, sortOrder);
    }

    @Override
    public Paging<JCSJDrugDict> getAcupointZJTable(int pageNum,
                                                          int pageSize,
                                                          String searchText,
                                                          String sortName,
                                                          String sortOrder) {
        return jcsjDrugDictMapper.getAcupointZJTable(pageNum, pageSize, searchText, sortName, sortOrder);
    }

    @Override
    public int insertWesternDistionary(JCSJDrugDict jcsjDrugDict) {
        return jcsjDrugDictMapper.insertWesternDistionary(jcsjDrugDict);
    }

    @Override
    public int updateWesternDistionary(JCSJDrugDict jcsjDrugDict) {
        return jcsjDrugDictMapper.updateWesternDistionary(jcsjDrugDict);
    }

    @Override
    public int deleteWesternDistionary(Integer drugcode) {
        return jcsjDrugDictMapper.deleteWesternDistionary(drugcode);
    }

    @Override
    public void getBillCode(JCSJDrugDict jcsjDrugDict) {
        jcsjDrugDictMapper.getBillCode(jcsjDrugDict);
    }

    @Override
    public List<JCSJDictCodeRst> GetDictCodeRst(String proUUID) {
        return jcsjDrugDictMapper.GetDictCodeRst(proUUID);
    }

    @Override
    public List<JCSJDrugDict> GetDrugInfoByDrugName(String drugname) {
        return jcsjDrugDictMapper.GetDrugInfoByDrugName(drugname);
    }

    @Override
    public List<JCSJDosage> getDosage() {
        return jcsjDosageMapper.getDosage();
    }

    @Override
    public List<JCSJDrugModel> getDrugModel() {
        return jcsjDrugModelMapper.getDrugModel();
    }

    @Override
    public List<JCSJDrugWay> getDrugWay() {
        return jcsjDrugWayMapper.getDrugWay();
    }

    @Override
    public List<JCSJProcess> getProcess() {
        return jcsjProcessMapper.getProcess();
    }

    @Override
    public List<JCSJDrugDict> GetDrugInfoByPrescription(Integer drugcode) {
        return jcsjDrugDictMapper.GetDrugInfoByPrescription(drugcode);
    }

    @Override
    public List<JCSJDrugDict> GetDrugInfoByDrugTaboos(Integer drugcode) {
        return jcsjDrugDictMapper.GetDrugInfoByDrugTaboos(drugcode);
    }

    @Override
    public List<JCSJDrugDict> GetDrugInfoFromFangJiDetailSub(Integer drugcode) {
        return jcsjDrugDictMapper.GetDrugInfoFromFangJiDetailSub(drugcode);
    }

    @Override
    public int deleteAcupointZJ(Integer drugcode) {
        return jcsjDrugDictMapper.deleteAcupointZJ(drugcode);
    }

    @Override
    public int insertAcupointZJ(Integer drugcode, String meridiancode) {
        return jcsjDrugDictMapper.insertAcupointZJ(drugcode,meridiancode);
    }

    @Override
    public List<JCSJDrugDict> CheckZJAcuIsUsedOrNot(Integer drugcode) {
        return jcsjDrugDictMapper.CheckZJAcuIsUsedOrNot(drugcode);
    }

    @Override
    public List<JCSJDrugDict> CheckZJAcuIsUsedOrNotInPreSub(Integer drugcode) {
        return jcsjDrugDictMapper.CheckZJAcuIsUsedOrNotInPreSub(drugcode);
    }
}
