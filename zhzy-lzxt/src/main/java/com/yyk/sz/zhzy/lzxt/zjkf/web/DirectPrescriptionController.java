package com.yyk.sz.zhzy.lzxt.zjkf.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.lzxt.zjkf.entity.*;
import com.yyk.sz.zhzy.lzxt.zjkf.entity.Process;
import com.yyk.sz.zhzy.lzxt.zjkf.service.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Api2Doc(id = "lzxt.zjkf.1", name = "临症-直接开方")
@ApiComment(seeClass = DirectPrescription.class)
@RestController
@RequestMapping(value = "/lzxt/zjkf")
public class DirectPrescriptionController {

    @Resource
    private DirectPrescriptionService directPrescriptionService;
    @Resource
    private ProcessService processService;
    @Resource
    private TasteService tasteService;
    @Resource
    private MeridianService meridianService;
    @Resource
    private DrugDictService drugDictService;

    /**
     * index，测试用
     */
    @ApiComment("测试用")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public Result index() {
        return ResultFactory.create("0", "临症系统-直接开方 测试访问成功。", null);
    }

    /**
     * 获取草药列表--根据drugModelCode和stopFlag
     *
     * @param drugModelCode
     * @param stopFlag
     * @return
     */
    @RequestMapping(value = "/getDrugDictList", method = RequestMethod.POST)
    @ResponseBody
    public Result getDrugDictList(
            @RequestParam("drugModelCode") String drugModelCode,
            @RequestParam("stopFlag") String stopFlag,
            @RequestParam(value = "inputCode", required = false) String inputCode,
            @RequestParam(value = "drugTaste", required = false) String drugTaste,
            @RequestParam(value = "drugMeridian", required = false) String drugMeridian) {
        List<DirectPrescription> resultList = new ArrayList<>();
        List<DirectPrescription> drugList = new ArrayList<>();
        String[] arr=null;
        if(drugTaste!=null) {
            arr = drugTaste.split(","); // 14:有小毒,15:有大毒,16:微毒
        }
        if(arr!=null) {
            for (int i = 0; i < arr.length; i++) {
                drugList = directPrescriptionService
                        .getDrugDictList(drugModelCode, stopFlag, inputCode, arr[i], drugMeridian);
                resultList.addAll(drugList);
            }
        }else {
            drugList = directPrescriptionService
                    .getDrugDictList(drugModelCode, stopFlag,inputCode, null, drugMeridian);
            resultList.addAll(drugList);
        }

        if (resultList != null && resultList.size() > 0) {
            return ResultFactory.create("0", null, resultList);
        } else {
            return ResultFactory.create("1", "没有信息", null);
        }
    }

    /**
     * 获取所有的中医病名
     *
     * @param chineseMedicineCode
     * @param chineseMedicineName
     * @param pinYinCode
     * @return
     */
    @ApiComment("获取所有的中医病名")
    @RequestMapping(name = "获取所有的中医病名", value = "/getAllChineseMedicine", method = RequestMethod.POST)
    @ResponseBody
    public Result searchChineseMedicineList(
            @RequestParam(value = "chineseMedicineCode", required = false) String chineseMedicineCode,
            @RequestParam(value = "chineseMedicineName", required = false) String chineseMedicineName,
            @RequestParam(value = "pinYinCode", required = false) String pinYinCode,
            @RequestParam(value = "searchText", required = false) String searchText) {

        List<DirectPrescription> chineseMedicineList = directPrescriptionService
                .getChineseMedicineList(chineseMedicineCode, chineseMedicineName, pinYinCode, searchText);
        if (chineseMedicineList != null && chineseMedicineList.size() > 0) {
            return ResultFactory.create("0", null, chineseMedicineList);
        } else {
            return ResultFactory.create("1", "没有信息", null);
        }
    }

    /**
     * 获取所有的西医病名
     *
     * @param westernMedicineCode
     * @param westernMedicineName
     * @param pinYinCode
     * @return
     */
    @RequestMapping(value = "/getAllWesternMedicine", method = RequestMethod.POST)
    @ResponseBody
    public Result searchWesternMedicineList(
            @RequestParam(value = "westernMedicineCode", required = false) String westernMedicineCode,
            @RequestParam(value = "westernMedicineName", required = false) String westernMedicineName,
            @RequestParam(value = "pinYinCode", required = false) String pinYinCode,
            @RequestParam(value = "searchText", required = false) String searchText
    ) {
        List<DirectPrescription> westernMedicineList = directPrescriptionService
                .getWesternMedicineList(westernMedicineCode, westernMedicineName, pinYinCode, searchText);
        if (westernMedicineList != null && westernMedicineList.size() > 0) {
            return ResultFactory.create("0", null, westernMedicineList);
        } else {
            return ResultFactory.create("1", "没有信息", null);
        }

    }

    /**
     * 获取药解--根据drugCode
     *
     * @param drugCode
     * @return
     */
    @RequestMapping(value = "/getDrugExplanation", method = RequestMethod.GET)
    @ResponseBody
    public Result getDrugExplanation(@RequestParam("drugCode") String drugCode) {
        List<String> resultList = new ArrayList();
        //获取炮制方式
        List<Process> processList = processService.getProcessList(drugCode);
        if (processList != null && processList.size() > 0) {
            String process = "";
            for (Process p : processList) {
                process += p.getProcessName() + ",";
            }
            process = process.substring(0, process.length() - 1);
            resultList.add(process); //炮制方式
        }
        //获取性味
        List<Taste> tasteList = tasteService.getTasteList(drugCode);
        if (tasteList != null && tasteList.size() > 0) {
            String taste = "";
            for (Taste t : tasteList) {
                taste += t.getTasteName() + ",";
            }
            taste = taste.substring(0, taste.length() - 1);
            resultList.add(taste); //性味
        }
        //获取归经
        List<Meridian> meridianList = meridianService.getMeridianList(drugCode);
        if (meridianList != null && meridianList.size() > 0) {
            String meridian = "";
            for (Meridian m : meridianList) {
                meridian += m.getMeridianName() + ",";
            }
            meridian = meridian.substring(0, meridian.length() - 1);
            resultList.add(meridian); //归经
        }
        //获取别名、来源、功能、主治等。
        List<DrugDict> drugDictList = drugDictService.getDrugInfoList(drugCode);
        if (drugDictList != null && drugDictList.size() > 0) {
            DrugDict drugDict = drugDictList.get(0);
            resultList.add(drugDict.getOtherName()); //别名
            resultList.add(drugDict.getDrugSource()); //来源
            resultList.add(drugDict.getDrugFunction()); //功能
            resultList.add(drugDict.getDrugAttend()); //主治
            resultList.add(drugDict.getUSAGEE()); //用法用量
            resultList.add(drugDict.getSpecialUsage()); //特殊用法
            resultList.add(drugDict.getMatterAttend()); //注意事项
            resultList.add(drugDict.getDrugStorage()); //贮藏
        }
        if (resultList != null && resultList.size() > 0) {
            return ResultFactory.create("0", null, resultList);
        } else {
            return ResultFactory.create("1", "没有信息", null);
        }

    }

    /**
     * 获取性味或归经
     *
     * @param flag
     * @return
     */
    @RequestMapping(value = "/getTasteOrMeridian", method = RequestMethod.POST)
    @ResponseBody
    public Result getTasteOrMeridian(@RequestParam("flag") String flag) {
        List<DirectPrescription> list = new ArrayList<>();
        if ("0".equals(flag)) { //性味
            list = directPrescriptionService.getTaste();
        }
        if ("1".equals(flag)) { //归经
            list = directPrescriptionService.getMeridian();
        }
        return ResultFactory.create("0", null, list);
    }

    /**
     * 获取药品禁忌
     *
     * @return
     */
    @ApiComment("获取药品禁忌.DrugFlag:10禁用,20慎用;DrugTaboosType:18反19畏20孕妇禁忌21药量禁忌")
    @RequestMapping(value = "/getDrugTaboosList", method = RequestMethod.POST)
    @ResponseBody
    public Result getDrugTaboosList(
    ) {
        List<DrugTaboos> drugTaboosList = directPrescriptionService.getDrugTaboosList();
        if (drugTaboosList != null && drugTaboosList.size() > 0) {
            return ResultFactory.create("0", null, drugTaboosList);
        } else {
            return ResultFactory.create("1", "没有信息", null);
        }

    }
}
