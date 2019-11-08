package com.yyk.sz.zhzy.lzxt.bcbl.service;

import com.yyk.sz.zhzy.lzxt.bcbl.entity.EmpBasicInfoRst;
import com.yyk.sz.zhzy.lzxt.bcbl.entity.EmpBasicMainEnty;

import java.util.List;

public interface EmpBasicMainEntyService {
    public List<EmpBasicMainEnty> getEmpBasicList(String mecidalNum);

    public List<EmpBasicMainEnty> getEmpBasicMainEntyTable(String registrationNum);

    public boolean insertEmpBasic(EmpBasicMainEnty empBasicMainEnty);

    public boolean insertEmpBasicSP(EmpBasicMainEnty empBasicMainEnty);

    public void getEmpBasicInfo( String registrationNum,String drugFlag, String proUUID);

    public List<EmpBasicInfoRst> getEmpBasicInfoRst(String proUUID);

    public boolean updateEmpBasic(EmpBasicMainEnty empBasicMainEnty);

    public boolean updateEmpBasicSP(EmpBasicMainEnty empBasicMainEnty);

    public List<EmpBasicMainEnty> getCompareEmpBasicList(String mecidalNum);

    public List<EmpBasicMainEnty> getCompareEmpBasicInfo(String registrationNum);

    public List<EmpBasicMainEnty> getCompareEmpBasicChuFang(String empBasicMainID,int drugFlag);

    public List<EmpBasicMainEnty> getCompareEmpBasicWesternTable(String registrationNum);

    public List<EmpBasicMainEnty> getCompareEmpBasicCheckItem(String empBasicMainID,int checkFlag);

    public boolean deleteDiseaseSub(int empBasicMainID);

    public boolean deleteTongueSub(int empBasicMainID);

    public boolean deletePulseSub(int empBasicMainID);

    public boolean insertDiseaseSub(EmpBasicMainEnty empBasicMainEnty);

    public boolean insertTongueSub(EmpBasicMainEnty empBasicMainEnty);

    public boolean insertPulseSub(EmpBasicMainEnty empBasicMainEnty);

    public boolean EvaluationCodeRemark(EmpBasicMainEnty empBasicMainEnty);


}
