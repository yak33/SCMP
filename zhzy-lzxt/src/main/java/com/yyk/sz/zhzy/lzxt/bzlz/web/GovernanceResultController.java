package com.yyk.sz.zhzy.lzxt.bzlz.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.common.base.utils.UtilUuid;
import com.yyk.sz.zhzy.lzxt.bzlz.entity.ForHRWPData;
import com.yyk.sz.zhzy.lzxt.bzlz.entity.GRListRst;
import com.yyk.sz.zhzy.lzxt.bzlz.entity.GovernanceResult;
import com.yyk.sz.zhzy.lzxt.bzlz.service.GovernanceResultService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZhangChao
 * @Date: 2018-11-13 11:14
 */
@Api2Doc(id = "lzxt.bzlz.2", name = "辨证论治-论治结果")
@ApiComment(seeClass = GovernanceResult.class)
@RestController
@RequestMapping("/lzxt/bzlz")
public class GovernanceResultController {

    @Resource
    private GovernanceResultService governanceResultService;

    /**
     * index，测试用
     */
    @RequestMapping(value = "/sousousou", method = RequestMethod.GET)
    public Result index() {
        return ResultFactory.create("0","guolai le 。",null);
    }

    /**
     * 获取论治结果
     * @param
     * @return
     */
    @ApiComment("获取论治结果")
    @RequestMapping(value = "/getGovernanceResult", method = RequestMethod.POST)
    @ResponseBody
    public Result getGovernanceResult(HttpServletRequest request, HttpServletResponse response){
        GovernanceResult governanceResult = new GovernanceResult();
        String empBasicMainID = request.getParameter("empBasicMainID");
        String operationType = request.getParameter("operationType"); // 1辩证论治、2直接开方
        String dialecticalCode = request.getParameter("dialecticalCode"); //证型编码
        String cureCode = request.getParameter("cureCode"); //治则编码
        System.out.println(empBasicMainID +","+ operationType +","+ dialecticalCode +","+ cureCode);
        if (empBasicMainID != null && !"".equals(empBasicMainID)){
            governanceResult.setEmpBasicMainID(Integer.parseInt(empBasicMainID));
        }
        if (operationType != null && !"".equals(operationType)){
            governanceResult.setOperationType(Integer.parseInt(operationType));
        }
        if (dialecticalCode != null && !"".equals(dialecticalCode)){
            governanceResult.setDialecticalCode(dialecticalCode);
        }
        if (cureCode != null && !"".equals(cureCode)){
            governanceResult.setCureCode(cureCode);
        }

        String proUUID = UtilUuid.uuid();
        governanceResult.setProUUID(proUUID);
        governanceResultService.getGRList(governanceResult);
        List<GRListRst> getGRList = governanceResultService.getGRListRst(proUUID);

        if (getGRList != null && getGRList.size() > 0){
            return ResultFactory.create("0",null, getGRList);
        }
        return ResultFactory.create("1","无返回数据",null);
    }

    /**
     * 根据选中的论治结果里的方剂编码获取该方剂里的草药信息
     * @param prescriptionCode
     * @return
     */
    @ApiComment("根据选中的论治结果里的方剂编码获取该方剂里的草药信息")
    @RequestMapping(value = "/getDrugByPrescriptionCode", method = RequestMethod.POST)
    @ResponseBody
    public Result getDrugByPrescriptionCode(
            @RequestParam("prescriptionCode") String prescriptionCode){
        List<GovernanceResult> resultList = new ArrayList<>();
        List<GovernanceResult> getDBPCList = new ArrayList<>();
        String[] pCodeARR = {};
        if (prescriptionCode.contains(";")){
            pCodeARR = prescriptionCode.split(";");
            for (int i=0;i<pCodeARR.length;i++){
                System.out.println(pCodeARR[i]);
                getDBPCList = governanceResultService.getDrugByPrescriptionCode(pCodeARR[i]);
                resultList.addAll(getDBPCList);
            }
            return ResultFactory.create("0",null, resultList);
        }else {
            getDBPCList = governanceResultService.getDrugByPrescriptionCode(prescriptionCode);
            if (getDBPCList != null && getDBPCList.size() > 0){
                return ResultFactory.create("0",null, getDBPCList);
            }
            return ResultFactory.create("1","获取草药失败!",null);
        }

    }

    /**
     * 根据选中的论治结果里的方剂编码获取方解信息
     * @param prescriptionCode
     * @return
     */
    @ApiComment("根据选中的论治结果里的方剂编码获取方解信息")
    @RequestMapping(value = "/getCalciteByPrescriptionCode", method = RequestMethod.POST)
    @ResponseBody
    public Result getCalciteByPrescriptionCode(
            @RequestParam("prescriptionCode") String prescriptionCode){
        List<GovernanceResult> resultList = new ArrayList<>();
        List<GovernanceResult> getCBPCList = new ArrayList<>();
        String[] pCodeARR = {};
        if (prescriptionCode.contains(";")){
            pCodeARR = prescriptionCode.split(";");
            for (int i=0;i<pCodeARR.length;i++){
                System.out.println(pCodeARR[i]);
                getCBPCList = governanceResultService.getCalciteByPrescriptionCode(pCodeARR[i]);
                resultList.addAll(getCBPCList);
            }
            return ResultFactory.create("0",null, resultList);
        }else {
            getCBPCList = governanceResultService.getCalciteByPrescriptionCode(prescriptionCode);
            if (getCBPCList != null && getCBPCList.size() > 0){
                return ResultFactory.create("0",null, getCBPCList);
            }
            return ResultFactory.create("1","获取方解失败!",null);
        }

    }

//    /**
//     * 为echarts提供数据
//     * @param empBasicMainID
//     * @return
//     */
//    @RequestMapping(value = "/forEchartsData", method = RequestMethod.POST)
//    @ResponseBody
//    public Result forEchartsData(
//            @RequestParam("empBasicMainID") int empBasicMainID){
//        ForEchartsData fed = new ForEchartsData();
//        List<GovernanceResult> getMSList = null;
//        List<GovernanceResult> getTSList = null;
//        List<GovernanceResult> getMList = governanceResultService.getMeridian();
//        getMSList = governanceResultService.getMeridianScore(empBasicMainID);
//        getTSList = governanceResultService.getTasteScore(empBasicMainID);
//        fed.setxData(getMList);
//        if (getMSList != null && getMSList.size() > 0){
//            fed.setMeridianScore(getMSList);
//        }
//        if (getTSList != null && getTSList.size() > 0){
//            fed.setTasteScore(getTSList);
//        }
//        return ResultFactory.create("0",null, fed);
//    }

    /**
     * 为echarts提供数据--X轴
     * @param
     * @return
     */
    @ApiComment("为echarts提供数据--X轴")
    @RequestMapping(value = "/forXData", method = RequestMethod.POST)
    @ResponseBody
    public Result forXData(){
        List<GovernanceResult> getMList = governanceResultService.getMeridian();
        return ResultFactory.create("0",null, getMList);
    }

    /**
     * 为echarts提供数据--柱状图
     * @param empBasicMainID
     * @return
     */
    @ApiComment("为echarts提供数据--柱状图")
    @RequestMapping(value = "/forZZTData", method = RequestMethod.POST)
    @ResponseBody
    public Result forZZTData(
            @RequestParam("empBasicMainID") int empBasicMainID){
        List<GovernanceResult> getMSList = governanceResultService.getMeridianScore(empBasicMainID);
        return ResultFactory.create("0",null, getMSList);
    }

    /**
     * 为echarts提供数据--进入页面时的折线图
     * @param empBasicMainID
     * @return
     */
    @ApiComment("为echarts提供数据--进入页面时的折线图")
    @RequestMapping(value = "/forZXTData", method = RequestMethod.POST)
    @ResponseBody
    public Result forZXTData(
            @RequestParam("empBasicMainID") int empBasicMainID){
        List<GovernanceResult> getTSList = governanceResultService.getTasteScore(empBasicMainID);
        return ResultFactory.create("0",null, getTSList);
    }

    /**
     * 为echarts提供数据--动态折线图
     * @param prescriptionCode
     * @return
     */
    @ApiComment("为echarts提供数据--动态折线图")
    @RequestMapping(value = "/forDTZXTData", method = RequestMethod.POST)
    @ResponseBody
    public Result forDTZXTData(
            @RequestParam("prescriptionCode") String prescriptionCode,
            @RequestParam(value = "drugCode", required = false) String drugCode){
        List<GovernanceResult> resultList = new ArrayList<>();
        List<GovernanceResult> es = new ArrayList<>();
        List<GovernanceResult> getDBPCList = new ArrayList<>();
        System.out.println(prescriptionCode);

        String[] pCodeArr = {};
        String drugCodeStr = "";

        pCodeArr = prescriptionCode.split(";");
        for (int i=0;i<pCodeArr.length;i++){
            getDBPCList = governanceResultService.getDrugByPrescriptionCode(pCodeArr[i]);
            resultList.addAll(getDBPCList);
        }
        for (GovernanceResult gr : resultList){
            drugCodeStr += gr.getDrugCode()+","; // 10222,10555,13620,
        }

        if (drugCode != null && !"".equals(drugCode)){
            System.out.println(drugCode);
            String drugCode1 = "";
            String[] drugCodeArr ={};
            if (drugCode.contains(";")){
                drugCodeArr = drugCode.split(";");
                for (int i=0;i<drugCodeArr.length;i++){
                    drugCode1 += drugCodeArr[i]+",";
                }
                System.out.println("drugCode1:= "+drugCode1);
            }
            drugCodeStr = drugCode1;
        }
        drugCodeStr = drugCodeStr.substring(0,drugCodeStr.lastIndexOf(",")); // 10222,10555,13620
        System.out.println("drugCodeStr: "+drugCodeStr);
        es = governanceResultService.getDTZXTData(drugCodeStr);


        return ResultFactory.create("0",null, es);
    }

    /**
     * 寒热温平
     * @param prescriptionCode
     * @return
     */
    @ApiComment("寒热温平")
    @RequestMapping(value = "/forHRWPData", method = RequestMethod.POST)
    @ResponseBody
    public Result forHRWPData(
            @RequestParam("prescriptionCode") String prescriptionCode,
            @RequestParam(value = "drugCode", required = false) String drugCode){
        List<GovernanceResult> resultList = new ArrayList<>();
        System.out.println(prescriptionCode);
        String[] pCodeArr = {};
        String drugCodeStr = "";

        pCodeArr = prescriptionCode.split(";");
        for (int i=0;i<pCodeArr.length;i++){
            List<GovernanceResult> getDBPCList = governanceResultService.getDrugByPrescriptionCode(pCodeArr[i]);
            resultList.addAll(getDBPCList);
        }
        for (GovernanceResult gr : resultList){
            drugCodeStr += gr.getDrugCode()+","; // 10222,10555,13620,
        }

        if (drugCode != null && !"".equals(drugCode)){
            System.out.println(drugCode);
            String drugCode1 = "";
            String[] drugCodeArr ={};
            drugCodeArr = drugCode.split(";");
            for (int i=0;i<drugCodeArr.length;i++){
                drugCode1 += drugCodeArr[i]+",";
            }
            System.out.println("drugCode1:= "+drugCode1);
            drugCodeStr = drugCode1;
        }
        drugCodeStr = drugCodeStr.substring(0,drugCodeStr.lastIndexOf(",")); // 10222,10555,13620
        System.out.println("drugCodeStr: "+drugCodeStr);
        List<GovernanceResult> getHRWPList = governanceResultService.getHRWP(drugCodeStr);

        int han=0;
        int re=0;
        int wen=0;
        int ping=0;
        for (GovernanceResult gr : getHRWPList){
            if (gr.getDrugTaste().indexOf("01:寒") != -1){
                han++;
            }
            if (gr.getDrugTaste().indexOf("02:热") != -1){
                re++;
            }
            if (gr.getDrugTaste().indexOf("03:温") != -1){
                wen++;
            }
            if (gr.getDrugTaste().indexOf("04:平") != -1){
                ping++;
            }
        }
        ForHRWPData HRWP = new ForHRWPData();
        HRWP.setHan(han);
        HRWP.setRe(re);
        HRWP.setWen(wen);
        HRWP.setPing(ping);

        return ResultFactory.create("0",null, HRWP);
    }

}
