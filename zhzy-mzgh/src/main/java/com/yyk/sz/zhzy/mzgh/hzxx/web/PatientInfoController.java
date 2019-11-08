package com.yyk.sz.zhzy.mzgh.hzxx.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.common.base.utils.UtilUuid;
import com.yyk.sz.zhzy.mzgh.hzxx.entity.EmpBasicIdCodeRst;
import com.yyk.sz.zhzy.mzgh.hzxx.entity.PatientInfo;
import com.yyk.sz.zhzy.mzgh.hzxx.service.PatientInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 门诊挂号-患者信息 Controller
 */
@Api2Doc(id = "mzgh.hzxx", name = "门诊挂号-患者信息")
@ApiComment(seeClass = PatientInfo.class)
@RestController
@RequestMapping(value = "/mzgh/hzxx/")
public class PatientInfoController {

    @Autowired
    private PatientInfoService patientInfoService;

    /**
     * index，测试用
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public Result index() {
        return ResultFactory.create("0","临症系统-症型治法测试访问成功。",null);
    }

    /**
     * 获取患者信息（根据请求传递的registrationNum）
     *
     * @return 患者信息
     */
    @ApiComment("获取患者信息（根据请求传递的registrationNum）")
    @RequestMapping(value = "/getSelectPatientInfoTable", method = RequestMethod.POST)
    public Result currentUser(
            @RequestParam("registrationNum") String registrationNum
    ) {
        List<PatientInfo> patientInfoList = patientInfoService.getSelectPatientInfoTable(registrationNum);
        if( patientInfoList == null || patientInfoList.size() == 0 ){
            return ResultFactory.create("1","没有用户："+registrationNum+")下的患者信息",null);
        }
        return ResultFactory.create("0",null,patientInfoList.get(0));
    }

//    /**
//     * 修改患者信息（根据请求传递的registrationNum）
//     *
//     * @return 是否成功
//     */
//    @ApiComment("修改患者信息（根据请求传递的registrationNum）")
//    @RequestMapping(value = "/updatePatientInfo", method = RequestMethod.POST)
//    public Result updatePatientInfo(
//           PatientInfo patientInfo
//    ) {
//        boolean suc = patientInfoService.updatePatientInfo(patientInfo);
//        if(!suc){
//            return ResultFactory.create("0",null,"0");
//        }
//        return ResultFactory.create("1","保存成功",1);
//    }

    /**
     * 修改患者信息（根据请求传递的registrationNum）
     *
     * @return 是否成功
     */
    @ApiComment("修改患者信息（根据请求传递的registrationNum）")
    @RequestMapping(value = "/updatePatientInfo", method = RequestMethod.POST)
    public Result updatePatientInfo(
            @RequestParam("registrationNum") String registrationNum,
            @RequestParam("emName") String emName,
            @RequestParam("emNum") String emNum,
            @RequestParam("maker") String maker,
            @RequestParam("makeDate") String makeDate,
            @RequestParam("onSetDate") String onSetDate,
            @RequestParam("deptCode") String deptCode,
            @RequestParam("deptName") String deptName,
            @RequestParam("userCode") String userCode,
            @RequestParam("userName") String userName,
            @RequestParam("mecidalType") String mecidalType,
            @RequestParam("emType") int emType,
            @RequestParam(value = "emSex", required = false,defaultValue = "0") int emSex,
            @RequestParam(value = "emAge", required = false,defaultValue = "0") int emAge,
            @RequestParam(value = "emComName", required = false,defaultValue = "") String emComName,
            @RequestParam(value = "emMobile", required = false,defaultValue = "") String emMobile,
            @RequestParam(value = "weight", required = false,defaultValue = "0") int weight,
            @RequestParam(value = "emAddress", required = false,defaultValue = "") String emAddress,
            @RequestParam(value = "isYuFu", required = false,defaultValue = "0") int isYuFu
    ) {
        PatientInfo patientInfo=new PatientInfo();
        patientInfo.setRegistrationNum(registrationNum);
        patientInfo.setEmName(emName);
        patientInfo.setEmNum(emNum);
        patientInfo.setMaker(maker);
        patientInfo.setMakeDate(makeDate);
        patientInfo.setOnSetDate(onSetDate);
        patientInfo.setDeptCode(deptCode);
        patientInfo.setDeptName(deptName);
        patientInfo.setUserCode(userCode);
        patientInfo.setUserName(userName);
        patientInfo.setMecidalType(mecidalType);
        patientInfo.setEmType(emType);
        patientInfo.setEmSex(emSex);
        if(emAge!=0) {
            patientInfo.setEmAge(emAge);
        }
        patientInfo.setEmComName(emComName);
        patientInfo.setEmMobile(emMobile);
        if(weight!=0) {
            patientInfo.setWeight(weight);
        }
        patientInfo.setEmAddress(emAddress);
        patientInfo.setIsYuFu(isYuFu);
        boolean suc = patientInfoService.updateHisPatientInfo(patientInfo);
        boolean suc2 = patientInfoService.updatePatientInfo(patientInfo);
        if(!suc||!suc2){
            return ResultFactory.create("0","保存失败","0");
        }
        return ResultFactory.create("1","保存成功",1);
    }


//    /**
//     * 增加患者信息
//     *
//     * @return 是否成功
//     */
//    @ApiComment("增加患者信息")
//    @RequestMapping(value = "/insertPatientInfo", method = RequestMethod.POST)
//    public Result insertPatientInfo(
//           PatientInfo patientInfo
//    ) {
//        PatientInfo billInfo=getBillCode("1001").get(0);
//        patientInfo.setEmpBasicMainID(billInfo.getV_GetBillID());
//        patientInfo.setEmpBasicCode(billInfo.getV_GetBillCode());
//        PatientInfo billInfo2=getBillCode("1004").get(0);
//        patientInfo.setRegistrationNumMainID(billInfo2.getV_GetBillID());
//        patientInfo.setRegistrationNum(billInfo2.getV_GetBillCode());
//        patientInfo.setTreatmentState(false);
//        boolean suc = patientInfoService.insertPatientInfo(patientInfo);
//        if(!suc){
//            return ResultFactory.create("0",null,"0");
//        }
//        return ResultFactory.create("1","保存成功",1);
//    }

    /**
     * 增加患者信息
     *
     * @return 是否成功
     */
    @ApiComment("增加患者信息")
    @RequestMapping(value = "/insertPatientInfo", method = RequestMethod.POST)
    public Result insertPatientInfo(
            @RequestParam("mecidalNum") String mecidalNum,
            @RequestParam("emName") String emName,
            @RequestParam("deptCode") String deptCode,
            @RequestParam("deptName") String deptName,
            @RequestParam("userCode") String userCode,
            @RequestParam("userName") String userName,
            @RequestParam("emNum") String emNum,
            @RequestParam("mecidalType") String mecidalType,
            @RequestParam("emType") int emType,
            @RequestParam("maker") String maker,
            @RequestParam("makeDate") String makeDate,
            @RequestParam("onSetDate") String onSetDate,
            @RequestParam(value = "emSex", required = false,defaultValue = "0") int emSex,
            @RequestParam(value = "emAge", required = false,defaultValue = "0") int emAge,
            @RequestParam(value = "emComName", required = false,defaultValue = "") String emComName,
            @RequestParam(value = "emMobile", required = false,defaultValue = "") String emMobile,
            @RequestParam(value = "weight", required = false,defaultValue = "0") int weight,
            @RequestParam(value = "emAddress", required = false,defaultValue = "") String emAddress,
            @RequestParam(value = "isYuFu", required = false,defaultValue = "0") int isYuFu
    ) {
        PatientInfo patientInfo=new PatientInfo();
        String proUUID = UtilUuid.uuid();
        getBillCode("1001",proUUID);
        EmpBasicIdCodeRst empBasicIdCodeRst=patientInfoService.GetEmpBasicIdCodeRst(proUUID).get(0);
        patientInfo.setEmpBasicMainID(Integer.parseInt(empBasicIdCodeRst.getGetBillId()));
        patientInfo.setEmpBasicCode(empBasicIdCodeRst.getGetBillCode());
        String proUUID2 = UtilUuid.uuid();
        getBillCode("1004",proUUID2);
        EmpBasicIdCodeRst empBasicIdCodeRst2=patientInfoService.GetEmpBasicIdCodeRst(proUUID2).get(0);
        patientInfo.setRegistrationNumMainID(Integer.parseInt(empBasicIdCodeRst2.getGetBillId()));
        patientInfo.setRegistrationNum(empBasicIdCodeRst2.getGetBillCode());
        patientInfo.setTreatmentState(0);
        patientInfo.setMecidalNum(mecidalNum);
        patientInfo.setEmName(emName);
        patientInfo.setDeptCode(deptCode);
        patientInfo.setDeptName(deptName);
        patientInfo.setUserCode(userCode);
        patientInfo.setUserName(userName);
        patientInfo.setEmNum(emNum);
        patientInfo.setMecidalType(mecidalType);
        patientInfo.setEmType(emType);
        patientInfo.setMaker(maker);
        patientInfo.setMakeDate(makeDate);
        patientInfo.setOnSetDate(onSetDate);
        patientInfo.setEmSex(emSex);
        patientInfo.setEmAge(emAge);
        patientInfo.setEmComName(emComName);
        patientInfo.setWeight(weight);
        patientInfo.setEmAddress(emAddress);
        patientInfo.setIsYuFu(isYuFu);
        patientInfo.setEmMobile(emMobile);
        boolean suc = patientInfoService.insertHisPatientInfo(patientInfo);
        boolean suc2 = patientInfoService.insertPatientInfo(patientInfo);
        if(!suc||!suc2){
            return ResultFactory.create("0","保存失败","0");
        }
        return ResultFactory.create("1","保存成功",1);
    }

    public void getBillCode(String billCode,String uuid) {
        PatientInfo patientInfo = new PatientInfo();
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        patientInfo.setBillCode(billCode);
        patientInfo.setDateString(dateString);
        patientInfo.setItemCode("");
        patientInfo.setOption(1);
        patientInfo.setVoucherCode("");
        patientInfo.setProUUID(uuid);
        patientInfoService.getBillCode(patientInfo);
    }
//    /**
//     * 生成挂号序号
//     * @param billCode 1001：EmpBasicMainID、EmpBasicCode；1004挂号序号、挂号序号id
//     * @return 挂号序号，id
//     */
//    @ApiComment("生成序号,billCode 1001：EmpBasicMainID、EmpBasicCode；1004挂号序号、挂号序号id")
//    @RequestMapping(value = "/getBillCode", method = RequestMethod.POST)
//    @ResponseBody
//    public Result getBillCode( @RequestParam("billCode") String billCode) {
//        PatientInfo patientInfo = new PatientInfo();
//        Date currentTime = new Date();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        String dateString = formatter.format(currentTime);
//        patientInfo.setBillCode(billCode);
//        patientInfo.setDateString(dateString);
//        patientInfo.setItemCode("");
//        patientInfo.setOption(1);
//        patientInfo.setVoucherCode("");
//        List<PatientInfo> patientInfoList = patientInfoService.getBillCode(patientInfo);
//        if( patientInfoList == null || patientInfoList.size() == 0 ){
//            return ResultFactory.create("1","生成失败",null);
//        }
//        return ResultFactory.create("0",null,patientInfoList);
//    }

}
