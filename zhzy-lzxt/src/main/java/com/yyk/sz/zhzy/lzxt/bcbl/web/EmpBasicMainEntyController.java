package com.yyk.sz.zhzy.lzxt.bcbl.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.common.base.utils.UtilUuid;
import com.yyk.sz.zhzy.common.util.UtilDES;
import com.yyk.sz.zhzy.lzxt.bcbl.entity.EmpBasicInfoRst;
import com.yyk.sz.zhzy.lzxt.bcbl.entity.EmpBasicMainEnty;
import com.yyk.sz.zhzy.lzxt.bcbl.service.EmpBasicMainEntyService;
import com.yyk.sz.zhzy.lzxt.zjkf.entity.DirectPrescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 临症系统-病例
 */
@Api2Doc(id = "lzxt.bcbl", name = "临症-保存病例")
@ApiComment(seeClass = EmpBasicMainEnty.class)
@RestController
@RequestMapping(value = "/lzxt/bcbl/")
public class EmpBasicMainEntyController {

    @Autowired
    private EmpBasicMainEntyService empBasicMainEntyService;

    /**
     * 获取病例列表
     *
     * @param mecidalNum 病例号
     * @return 病例列表
     */
    @ApiComment("获取病例列表")
    @RequestMapping(value = "/getEmpBasicList", method = RequestMethod.POST)
    @ResponseBody
    public Result getEmpBasicList(
            @RequestParam("mecidalNum") String mecidalNum
    ) {
        List<EmpBasicMainEnty> models = empBasicMainEntyService.getEmpBasicList(mecidalNum);
        if (models == null || models.size() == 0) {
            return ResultFactory.create("1", "没有（" + mecidalNum + "）下的病例数据", null);
        }
        return ResultFactory.create("0", null, models);
    }


    /**
     * 获取病人基本信息方法
     *
     * @param registrationNum 挂号序号
     * @return 病人基本信息
     */
    @ApiComment("获取病人基本信息方法")
    @RequestMapping(value = "/getEmpBasicMainEntyTable", method = RequestMethod.POST)
    @ResponseBody
    public Result getEmpBasicMainEntyTable(
            @RequestParam("registrationNum") String registrationNum
    ) {
        List<EmpBasicMainEnty> models = empBasicMainEntyService.getEmpBasicMainEntyTable(registrationNum);
        if (models == null || models.size() == 0) {
            return ResultFactory.create("1", "没有（" + registrationNum + "）下的病人信息", null);
        }
        return ResultFactory.create("0", null, models);
    }

    /**
     * 修改病例
     *
     * @return 修改成功
     */
    @ApiComment("修改病例")
    @RequestMapping(value = "/updateEmpBasic", method = RequestMethod.POST)
    @ResponseBody
    public Result updateEmpBasic(
            @RequestParam("empBasicMainID") int empBasicMainID,
            @RequestParam(value = "chiefComplaint", required = false) String chiefComplaint,
            @RequestParam(value = "historyPresent", required = false) String historyPresent,
            @RequestParam(value = "historyPast", required = false) String historyPast,
            @RequestParam(value = "historyAllergic", required = false) String historyAllergic,
            @RequestParam(value = "physicalExamination", required = false) String physicalExamination,
            @RequestParam(value = "otherDescription", required = false) String otherDescription,
            @RequestParam(value = "dialecticalCode", required = false) String dialecticalCode,
            @RequestParam(value = "cureCode", required = false) String cureCode,
            @RequestParam(value = "chineseMedicineCode", required = false) String chineseMedicineCode,
            @RequestParam(value = "westernMedicineCode", required = false) String westernMedicineCode,
            @RequestParam(value = "mainSymptomCode", required = false) String mainSymptomCode,
            @RequestParam(value = "mainSymptomName", required = false) String mainSymptomName,
            @RequestParam(value = "diseaseCode", required = false) String diseaseCode,
            @RequestParam(value = "diseaseName", required = false) String diseaseName,
            @RequestParam(value = "tongueCode", required = false) String tongueCode,
            @RequestParam(value = "tongueName", required = false) String tongueName,
            @RequestParam(value = "pulseCode", required = false) String pulseCode,
            @RequestParam(value = "pulseName", required = false) String pulseName
    ) {

        EmpBasicMainEnty empBasicMainEnty = new EmpBasicMainEnty();
        empBasicMainEnty.setEmpBasicMainID(empBasicMainID);
        empBasicMainEnty.setChiefComplaint(chiefComplaint);
        empBasicMainEnty.setHistoryPresent(historyPresent);
        empBasicMainEnty.setHistoryPast(historyPast);
        empBasicMainEnty.setHistoryAllergic(historyAllergic);
        empBasicMainEnty.setPhysicalExamination(physicalExamination);
        empBasicMainEnty.setOtherDescription(otherDescription);
        empBasicMainEnty.setDialecticalCode(dialecticalCode);
        empBasicMainEnty.setCureCode(cureCode);
        empBasicMainEnty.setChineseMedicineCode(chineseMedicineCode);
        empBasicMainEnty.setWesternMedicineCode(westernMedicineCode);
        empBasicMainEnty.setMainSymptomCode(mainSymptomCode);
        empBasicMainEnty.setMainSymptomName(mainSymptomName);
        empBasicMainEnty.setDiseaseCode(diseaseCode);
        empBasicMainEnty.setDiseaseName(diseaseName);
        empBasicMainEnty.setTongueCode(tongueCode);
        empBasicMainEnty.setTongueName(tongueName);
        empBasicMainEnty.setPulseCode(pulseCode);
        empBasicMainEnty.setPulseName(pulseName);
        //修改病人信息表
        boolean issuc = empBasicMainEntyService.updateEmpBasic(empBasicMainEnty);
        //删除问诊记录各项子表数据
        empBasicMainEntyService.deleteDiseaseSub(empBasicMainEnty.getEmpBasicMainID());
        empBasicMainEntyService.deleteTongueSub(empBasicMainEnty.getEmpBasicMainID());
        empBasicMainEntyService.deletePulseSub(empBasicMainEnty.getEmpBasicMainID());
        //病人信息基本表中插入问诊记录各项子表
        if(empBasicMainEnty.getDiseaseCode()!=null&&empBasicMainEnty.getDiseaseCode()!="") {
            String[] arr = empBasicMainEnty.getDiseaseCode().split(";");
            if (arr.length > 0) {
                for (int i = 0; i < arr.length; i++) {
                    empBasicMainEnty.setDiseaseCode(arr[i]);
                    empBasicMainEntyService.insertDiseaseSub(empBasicMainEnty);
                }
            }
        }
        if (empBasicMainEnty.getTongueCode() != null && empBasicMainEnty.getTongueCode() !="") {
            empBasicMainEntyService.insertTongueSub(empBasicMainEnty);
        }
        if (empBasicMainEnty.getPulseCode() != null && empBasicMainEnty.getPulseCode() != "") {
            empBasicMainEntyService.insertPulseSub(empBasicMainEnty);
        }
        if (issuc) {
            return ResultFactory.create("0", "修改成功", null);
        } else {
            return ResultFactory.create("1", "修改失败", null);
        }
    }


    /**
     * 获取病例详情
     *
     * @param registrationNum 挂号序号
     * @param drugFlag 默认0
     * @return 病例详情
     */
    @ApiComment("获取病例详情")
    @RequestMapping(value = "/getEmpBasicInfo", method = RequestMethod.POST)
    @ResponseBody
    public Result getEmpBasicInfo(
            @RequestParam("registrationNum") String registrationNum,
            @RequestParam("drugFlag") String drugFlag
    ) {
        String proUUID = UtilUuid.uuid();
        empBasicMainEntyService.getEmpBasicInfo(registrationNum,drugFlag,proUUID);
        List<EmpBasicInfoRst> models = empBasicMainEntyService.getEmpBasicInfoRst(proUUID);
        if (models == null || models.size() == 0) {
            return ResultFactory.create("0", "不存在", null);
        } else {
            return ResultFactory.create("1", "查找成功", models);
        }
    }

    /**
     * 比较病例-获取病例列表
     *
     * @param mecidalNum 病例号
     * @return 病例列表
     */
    @ApiComment("比较病例-获取病例列表")
    @RequestMapping(value = "/getCompareEmpBasicList", method = RequestMethod.POST)
    @ResponseBody
    public Result getCompareEmpBasicList(
            @RequestParam("mecidalNum") String mecidalNum
    ) {
        List<EmpBasicMainEnty> models = empBasicMainEntyService.getCompareEmpBasicList(mecidalNum);
        if (models == null || models.size() == 0) {
            return ResultFactory.create("1", "没有（" + mecidalNum + "）下的病例数据", null);
        }
        return ResultFactory.create("0", null, models);
    }

    /**
     * 比较病例-获取病例信息
     *
     * @param registrationNum 就诊号
     * @return 病例信息
     */
    @ApiComment("比较病例-获取病例信息")
    @RequestMapping(value = "/getCompareEmpBasicInfo", method = RequestMethod.POST)
    @ResponseBody
    public Result getCompareEmpBasicInfo(
            @RequestParam("registrationNum") String registrationNum
    ) {
        List<EmpBasicMainEnty> models = empBasicMainEntyService.getCompareEmpBasicInfo(registrationNum);
        if (models == null || models.size() == 0) {
            return ResultFactory.create("1", "没有（" + registrationNum + "）下的病例数据", null);
        }
        //DES解密主症名称
        for(EmpBasicMainEnty doc : models){
            doc.setMainSymptomName(UtilDES.Decrypt(doc.getMainSymptomName()));
        }
        return ResultFactory.create("0", null, models);
    }

    /**
     * 比较病例-处方明细
     * CM_Fun_GetFangJiZJValue
     * @param empBasicMainID  主表编码
     * @return 病例列表
     */
    @ApiComment("比较病例-处方明细")
    @RequestMapping(value = "/getCompareEmpBasicChuFang", method = RequestMethod.POST)
    @ResponseBody
    public Result getCompareEmpBasicChuFang(
            @RequestParam("empBasicMainID") String empBasicMainID,
            @RequestParam("drugFlag") int drugFlag
    ) {
        List<EmpBasicMainEnty> models = empBasicMainEntyService.getCompareEmpBasicChuFang(empBasicMainID,drugFlag);
        if (models == null || models.size() == 0) {
            return ResultFactory.create("1", "没有（" + empBasicMainID + "）的处方明细", null);
        }
        return ResultFactory.create("0", null, models);
    }

    /**
     * 比较病例-处方
     * CM_Fun_GetChuFangValue
     * @param registrationNum  就诊号
     * @return 病例列表
     */
    @ApiComment("比较病例-处方")
    @RequestMapping(value = "/getCompareEmpBasicWesternTable", method = RequestMethod.POST)
    @ResponseBody
    public Result getCompareEmpBasicWesternTable(
            @RequestParam("registrationNum") String registrationNum
    ) {
        List<EmpBasicMainEnty> models = empBasicMainEntyService.getCompareEmpBasicWesternTable(registrationNum);
        if (models == null || models.size() == 0) {
            return ResultFactory.create("1", "没有（" + registrationNum + "）的处方明细", null);
        }
        return ResultFactory.create("0", null, models);
    }

    /**
     * 比较病例-检查项目
     * CM_Fun_GetCheckItemValue
     * @param empBasicMainID  主表编码
     * @return 病例列表
     */
    @ApiComment("比较病例-处方")
    @RequestMapping(value = "/getCompareEmpBasicCheckItem", method = RequestMethod.POST)
    @ResponseBody
    public Result getCompareEmpBasicCheckItem(
            @RequestParam("empBasicMainID") String empBasicMainID,
            @RequestParam("checkFlag") int checkFlag
    ) {
        List<EmpBasicMainEnty> models = empBasicMainEntyService.getCompareEmpBasicCheckItem(empBasicMainID,checkFlag);
        if (models == null || models.size() == 0) {
            return ResultFactory.create("1", "没有（" + empBasicMainID + "）的检查项目", null);
        }
        return ResultFactory.create("0", null, models);
    }

    /**
     * 治疗评价
     */
    @ApiComment("治疗评价（评价编码：10001:有效；10002：好转；10003：痊愈；10004：未愈）")
    @RequestMapping(value = "/EvaluationCodeRemark", method = RequestMethod.POST)
    @ResponseBody
    public Result EvaluationCodeRemark(
            @RequestParam("evaluationCode") String evaluationCode,
            @RequestParam("evaluationRemark") String evaluationRemark,
            @RequestParam("lunAfterImg") String lunAfterImg,
            @RequestParam("registrationNum") String registrationNum
    ) {
        EmpBasicMainEnty empBasicMainEnty = new EmpBasicMainEnty();
        empBasicMainEnty.setEvaluationCode(evaluationCode);
        empBasicMainEnty.setEvaluationRemark(evaluationRemark);
        empBasicMainEnty.setLunAfterImg(lunAfterImg);
        empBasicMainEnty.setRegistrationNum(registrationNum);
        boolean issuc = empBasicMainEntyService.EvaluationCodeRemark(empBasicMainEnty);
        if (issuc) {
            return ResultFactory.create("0", "评价成功", null);
        } else {
            return ResultFactory.create("1", "评价失败", null);
        }
    }
}
