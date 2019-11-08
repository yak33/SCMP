package com.yyk.sz.zhzy.zjxt.zxzf.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.zjxt.zjutil.ZJResult;
import com.yyk.sz.zhzy.zjxt.zjutil.ZJUtil;
import com.yyk.sz.zhzy.zjxt.zxzf.entity.DialecticalOrCureZJ;
import com.yyk.sz.zhzy.zjxt.zxzf.service.DialecticalOrCureZJService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 针灸-证型治法
 *
 * @Author: ZhangChao
 * @Date: 2018/11/30 14:56
 * @Version: 1.0
 */
@Api2Doc(id = "zjxt.zxzf.1", name = "针灸-证型治法")
@ApiComment(seeClass = DialecticalOrCureZJ.class)
@RestController
@RequestMapping(value = "/zjxt/zxzf")
public class DialecticalOrCureZJController {

    @Resource
    private DialecticalOrCureZJService dialecticalOrCureZJService;

    /**
     * 获取穴解
     *
     * @param acupointCode
     * @return
     */
    @ApiComment("获取穴解")
    @RequestMapping(value = "/getDrugSolution", method = RequestMethod.POST)
    @ResponseBody
    public Result getDrugSolution(@RequestParam("acupointCode") String acupointCode) {
        List<DialecticalOrCureZJ> getDrugSolution = dialecticalOrCureZJService.getDrugSolution(acupointCode);
        if (getDrugSolution != null && getDrugSolution.size() > 0) {
            return ResultFactory.create("0", null, getDrugSolution);
        }
        return ResultFactory.create("1", "没有信息", null);
    }

    /**
     * 获取开穴列表
     *
     * @return
     */
    @ApiComment("获取开穴列表")
    @RequestMapping(value = "/getKaiXue", method = RequestMethod.POST)
    @ResponseBody
    public Result getKaiXue() {
        ZJResult zjResult = ZJUtil.getZJData();
        String fdC6 = zjResult.getDd_tg() + "日";
        String fdC7 = zjResult.getTime_tg() + zjResult.getTime_dz();
        String fdC10 = zjResult.getTime_tg() + zjResult.getTime_dz();
        System.out.println("fdC6:" + fdC6 + "fdC7:" + fdC7 + "fdC10:" + fdC10);
        List<DialecticalOrCureZJ> getKaiXue = dialecticalOrCureZJService.getKaiXue(fdC6, fdC7, fdC10);
        if (getKaiXue != null && getKaiXue.size() > 0) {
            return ResultFactory.create("0", null, getKaiXue);
        }
        return ResultFactory.create("1", "无数据!", null);
    }

    /**
     * 获取闭穴列表
     *
     * @return
     */
    @ApiComment("获取闭穴列表")
    @RequestMapping(value = "/getBiXue", method = RequestMethod.POST)
    @ResponseBody
    public Result getBiXue() {
        ZJResult zjResult = ZJUtil.getZJData();
        String fdC6 = zjResult.getDd_tg() + "日";
        String fdC7 = zjResult.getTime_tg() + zjResult.getTime_dz();
        String fdC10 = zjResult.getTime_tg() + zjResult.getTime_dz();
        List<DialecticalOrCureZJ> getBiXue = dialecticalOrCureZJService.getBiXue(fdC6, fdC7, fdC10);
        if (getBiXue != null && getBiXue.size() > 0) {
            return ResultFactory.create("0", null, getBiXue);
        }
        return ResultFactory.create("1", "无数据!", null);
    }

    /**
     * 获取开穴有效时间
     *
     * @return
     */
    @ApiComment("获取开穴有效时间")
    @RequestMapping(value = "/getEffectiveTime", method = RequestMethod.POST)
    @ResponseBody
    public Result getEffectiveTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
        ZJResult zjResult = ZJUtil.getZJData();
        String g_time_invalid_end = zjResult.getG_time_invalid_end();
        String txttxtPointIfOpenEndTime = "";
        long txtPointIfOpenEndTime = 0;
        try {
            txttxtPointIfOpenEndTime = sdf.format(sdf.parse(g_time_invalid_end)) + "时";

            txtPointIfOpenEndTime = (sdf.parse(g_time_invalid_end).getTime() - new Date().getTime()) / 1000 / 60;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ZJResult zjr = new ZJResult();
        zjr.setTxtPointIfOpenEndTime(txtPointIfOpenEndTime);
        zjr.setTxttxtPointIfOpenEndTime(txttxtPointIfOpenEndTime);
        String effectiveTime = "开穴有效时间：" + txtPointIfOpenEndTime + " 分钟至 " + txttxtPointIfOpenEndTime;
        zjr.setEffectiveTime(effectiveTime);

        return ResultFactory.create("0", null, zjr);
    }

}
