package com.yyk.sz.zhzy.lzxt.bcbl.service;


import com.yyk.sz.zhzy.lzxt.bcbl.entity.EmpBasicInfoRst;
import com.yyk.sz.zhzy.lzxt.bcbl.entity.EmpBasicMainEnty;
import com.yyk.sz.zhzy.lzxt.bcbl.mapper.EmpBasicMainEntyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class EmpBasicMainEntyServiceImpl implements EmpBasicMainEntyService {


    @Autowired
    private EmpBasicMainEntyMapper empBasicMainEntyMapper;

    @Override
    public List<EmpBasicMainEnty> getEmpBasicList(String mecidalNum){
        return empBasicMainEntyMapper.getEmpBasicList(mecidalNum);
    }

    @Override
    public List<EmpBasicMainEnty> getEmpBasicMainEntyTable(String registrationNum) {
        return empBasicMainEntyMapper.getEmpBasicMainEntyTable(registrationNum);
    }

    @Override
    public boolean insertEmpBasic(EmpBasicMainEnty empBasicMainEnty) {
        return empBasicMainEntyMapper.insertEmpBasic(empBasicMainEnty);
    }

    @Override
    public boolean insertEmpBasicSP(EmpBasicMainEnty empBasicMainEnty) {
        return empBasicMainEntyMapper.insertEmpBasicSP(empBasicMainEnty);
    }

    @Override
    public void getEmpBasicInfo( String registrationNum,String drugFlag, String proUUID){
        empBasicMainEntyMapper.getEmpBasicInfo(registrationNum,drugFlag, proUUID);
    }

    @Override
    public List<EmpBasicInfoRst> getEmpBasicInfoRst(String proUUID){
        return empBasicMainEntyMapper.getEmpBasicInfoRst(proUUID);
    }

    @Override
    public boolean updateEmpBasic(EmpBasicMainEnty empBasicMainEnty) {
        return  empBasicMainEntyMapper.updateEmpBasic(empBasicMainEnty);
    }

    @Override
    public boolean updateEmpBasicSP(EmpBasicMainEnty empBasicMainEnty) {
        return  empBasicMainEntyMapper.updateEmpBasicSP(empBasicMainEnty);
    }

    @Override
    public List<EmpBasicMainEnty> getCompareEmpBasicList(String mecidalNum) {
        return empBasicMainEntyMapper.getCompareEmpBasicList(mecidalNum);
    }

    @Override
    public List<EmpBasicMainEnty> getCompareEmpBasicInfo(String registrationNum) {
        return empBasicMainEntyMapper.getCompareEmpBasicInfo(registrationNum);
    }

    @Override
    public List<EmpBasicMainEnty> getCompareEmpBasicChuFang(String empBasicMainID, int drugFlag) {
        return empBasicMainEntyMapper.getCompareEmpBasicChuFang(empBasicMainID,drugFlag);
    }

    @Override
    public List<EmpBasicMainEnty> getCompareEmpBasicWesternTable(String registrationNum) {
        return empBasicMainEntyMapper.getCompareEmpBasicWesternTable(registrationNum);
    }

    @Override
    public List<EmpBasicMainEnty> getCompareEmpBasicCheckItem(String empBasicMainID,int checkFlag) {
        return empBasicMainEntyMapper.getCompareEmpBasicCheckItem(empBasicMainID,checkFlag);
    }

    @Override
    public boolean deleteDiseaseSub(int empBasicMainID) {
        return empBasicMainEntyMapper.deleteDiseaseSub(empBasicMainID);
    }

    @Override
    public boolean deleteTongueSub(int empBasicMainID) {
        return empBasicMainEntyMapper.deleteTongueSub(empBasicMainID);
    }

    @Override
    public boolean deletePulseSub(int empBasicMainID) {
        return empBasicMainEntyMapper.deletePulseSub(empBasicMainID);
    }

    @Override
    public boolean insertDiseaseSub(EmpBasicMainEnty empBasicMainEnty) {
        return empBasicMainEntyMapper.insertDiseaseSub(empBasicMainEnty);
    }

    @Override
    public boolean insertTongueSub(EmpBasicMainEnty empBasicMainEnty) {
        return empBasicMainEntyMapper.insertTongueSub(empBasicMainEnty);
    }

    @Override
    public boolean insertPulseSub(EmpBasicMainEnty empBasicMainEnty) {
        return empBasicMainEntyMapper.insertPulseSub(empBasicMainEnty);
    }

    @Override
    public boolean EvaluationCodeRemark(EmpBasicMainEnty empBasicMainEnty) {
        return empBasicMainEntyMapper.EvaluationCodeRemark(empBasicMainEnty);
    }
}
