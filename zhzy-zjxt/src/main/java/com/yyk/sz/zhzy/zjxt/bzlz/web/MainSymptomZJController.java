package com.yyk.sz.zhzy.zjxt.bzlz.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.common.util.UtilDES;
import com.yyk.sz.zhzy.zjxt.bzlz.entity.MainSymptomZJ;
import com.yyk.sz.zhzy.zjxt.bzlz.service.MainSymptomZJService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 针灸系统--辨证论治
 */
@Api2Doc(id = "zjxt.bzlz.2", name = "针灸-辨证论治")
@ApiComment(seeClass = MainSymptomZJ.class)
@RestController
@RequestMapping("/zjxt/bzlz")
public class MainSymptomZJController {

    @Resource
    private MainSymptomZJService mainSymptomZJService;

    /**
     * 获取主证
     * @param deptCode
     * @param userCode
     * @return
     */
    @Api2Doc(order = 10)
    @RequestMapping(name = "获取主证",value = "/getMainSymptomList", method = RequestMethod.POST)
    @ResponseBody
    public Result getMainSymptomList(
            @RequestParam("deptCode") String deptCode,
            @RequestParam("userCode") String userCode){
        List<MainSymptomZJ> mainSymptomsList = mainSymptomZJService.getMainSymptomList(deptCode, userCode);
        if (mainSymptomsList != null && mainSymptomsList.size() > 0){
            for (MainSymptomZJ mszj : mainSymptomsList){
                mszj.setMainSymptomName(UtilDES.Decrypt(mszj.getMainSymptomName()));
            }
            return ResultFactory.create("0",null, mainSymptomsList);
        }
        return ResultFactory.create("1","没有信息",null);
    }

    /**
     * 获取兼症（根据主症编码获取对应的兼症）
     *
     * @return 兼症列表
     */
    @Api2Doc(order = 20)
    @RequestMapping(name = "获取兼症",value = "/getDiseaseList", method = RequestMethod.POST)
    @ResponseBody
    public Result getDiseaseList(
            @RequestParam("mainSymptomCode") int mainSymptomCode
    ) {
        List<MainSymptomZJ> diseases = mainSymptomZJService.getDiseaseList(mainSymptomCode);
        if( diseases == null || diseases.size() == 0 ){
            return ResultFactory.create("1","主症（"+mainSymptomCode+"）没有兼症数据",null);
        }
        for (MainSymptomZJ mszj : diseases){
            mszj.setDiseaseName(UtilDES.Decrypt(mszj.getDiseaseName()));
        }
        return ResultFactory.create("0",null,diseases);
    }

    /**
     * 获取舌像（根据主症编码获取对应的舌像）
     *
     * @return 舌像列表
     */
    @Api2Doc(order = 30)
    @RequestMapping(name = "获取舌像",value = "/getTongueList", method = RequestMethod.POST)
    @ResponseBody
    public Result getTongueList(
            @RequestParam("mainSymptomCode") int mainSymptomCode
    ) {
        List<MainSymptomZJ> tongueList = mainSymptomZJService.getTongueList(mainSymptomCode);
        if( tongueList == null || tongueList.size() == 0 ){
            return ResultFactory.create("1","主症（"+mainSymptomCode+"）没有舌像数据",null);
        }
        return ResultFactory.create("0",null,tongueList);
    }

    /**
     * 获取脉象（根据主症编码获取对应的脉象）
     *
     * @return 脉象列表
     */
    @Api2Doc(order = 40)
    @RequestMapping(name = "获取脉象",value = "/getPulseList", method = RequestMethod.POST)
    @ResponseBody
    public Result getPulseList(
            @RequestParam("mainSymptomCode") int mainSymptomCode
    ) {
        List<MainSymptomZJ> pulseList = mainSymptomZJService.getPulseList(mainSymptomCode);
        if( pulseList == null || pulseList.size() == 0 ){
            return ResultFactory.create("1","主症（"+mainSymptomCode+"）没有脉象数据",null);
        }
        return ResultFactory.create("0",null, pulseList);
    }
}
