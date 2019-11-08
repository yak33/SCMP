package com.yyk.sz.zhzy.zjxt.wcjz.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysFinancial;
import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysFinancialDetail;
import com.yyk.sz.zhzy.zjxt.wcjz.entity.SaveOrFinishZJ;
import com.yyk.sz.zhzy.zjxt.wcjz.service.SaveOrFinishZJService;
import com.yyk.sz.zhzy.zjxt.zjutil.ZJResult;
import com.yyk.sz.zhzy.zjxt.zjutil.ZJUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 针灸-保存or完成就诊
 *
 * @Author: ZhangChao
 * @Date: 2018/12/4 14:11
 * @Version: 1.0
 */
@Api2Doc(id = "zjxt.wcjz", name = "针灸-保存or完成就诊")
@ApiComment(seeClass = SaveOrFinishZJ.class)
@RestController
@RequestMapping(value = "/zjxt/wcjz")
public class SaveOrFinishZJController {

    @Resource
    private SaveOrFinishZJService saveOrFinishZJService;

    /**
     * 保存or完成就诊
     * @param saveOrFinishZJ
     * @return
     */
    @ApiComment("针灸-保存or完成就诊")
    @RequestMapping(value = "/saveOrFinishZJ", method = RequestMethod.POST)
    @ResponseBody
    public Result saveOrFinishZJ(@RequestBody SaveOrFinishZJ saveOrFinishZJ) {
        //System.out.println(saveOrFinishZJ.getZjMinutes());
        // 财务相关
        // 先清一遍主表和子表，根据病人id和项目类型。--5
        SysFinancial sysFinancial = new SysFinancial();
        SysFinancialDetail sysFinancialDetail = new SysFinancialDetail();
        sysFinancial.setEmpbasicmainid(Integer.parseInt(saveOrFinishZJ.getEmpBasicMainID()));
        sysFinancial.setPayitem(5); //针灸治疗
        saveOrFinishZJService.delFinancial(sysFinancial); //删除主表此人临证治疗..
        sysFinancialDetail.setEmpbasicmainid(Integer.parseInt(saveOrFinishZJ.getEmpBasicMainID()));
        sysFinancialDetail.setPayitem(5);
        saveOrFinishZJService.delFinancialDetail(sysFinancialDetail); //删除子表此人临证治疗明细..
        sysFinancial.setPayitemcode("(๑¯ ³ ¯๑)");
        sysFinancial.setPaytype(60); //默认不报销
        sysFinancial.setPaystatus(0); //默认未缴费
        double totalmoney = saveOrFinishZJ.getWholeMoney();
        sysFinancial.setTotalmoney(new BigDecimal(Double.toString(totalmoney)));
        int insFin = saveOrFinishZJService.insertFin(sysFinancial);
        System.out.println(insFin+"针灸治疗--财务主表添加");

        //删除俩表的数据
        saveOrFinishZJService.delFangJiDetailSub(saveOrFinishZJ.getEmpBasicMainID());
        saveOrFinishZJService.delFangJiSub(saveOrFinishZJ.getEmpBasicMainID());

        int updateEMP = saveOrFinishZJService.updateEmpBasicMain(saveOrFinishZJ);
        System.out.println(updateEMP);
        // flag = 0保存 1完成
        if (saveOrFinishZJ.getFlag() != null && saveOrFinishZJ.getFlag().equals("1")){
            int updateHISEMP = saveOrFinishZJService.updateHISEmpBasicMain(saveOrFinishZJ);
            System.out.println(updateHISEMP);
        }

        if (saveOrFinishZJ.getZjMinutes() == null || "".equals(saveOrFinishZJ.getZjMinutes())){
            saveOrFinishZJ.setZjMinutes(10);
        }
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        saveOrFinishZJ.setBeginDate(sdf.format(new Date()));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
        ZJResult zjResult = ZJUtil.getZJData();
        String g_time_invalid_end = zjResult.getG_time_invalid_end();
        String txttxtPointIfOpenEndTime = "";
        try {
            txttxtPointIfOpenEndTime = sdf.format(sdf.parse(g_time_invalid_end)) + ":00";

        } catch (ParseException e) {
            e.printStackTrace();
        }
        saveOrFinishZJ.setBeginDate(txttxtPointIfOpenEndTime);
        int insertSub = saveOrFinishZJService.insertFangJiSub(saveOrFinishZJ);
        System.out.println(insertSub);

        List<SaveOrFinishZJ> acupointList = saveOrFinishZJ.getFangJiDetailList(); //穴位表格的数据
        boolean ouye = false;
        if (acupointList != null && acupointList.size() > 0) {
            List<SaveOrFinishZJ> subIdList = saveOrFinishZJService.getFangJiSubIDcc(saveOrFinishZJ.getEmpBasicMainID());
            int fangJiSubID = subIdList.get(0).getFangJiSubID();
            for (SaveOrFinishZJ sofzj : acupointList){
                //double LPrice = saveOrFinishZJService.getDrugDict(sofzj.getDrugCode()).getLPrice();
                double LPrice = 0.0;
                //double WholeMoney = LPrice * sofzj.getQuanitity();
                double WholeMoney = 0.0;
                double quanitity = 0.0;
                sofzj.setFangJiSubID(fangJiSubID);
                sofzj.setWholeMoney(WholeMoney);
                sofzj.setLPrice(LPrice);
                sofzj.setQuanitity(quanitity);
                int insertDetail = saveOrFinishZJService.insertFangJiDetailSubcc(sofzj);
                sysFinancialDetail.setDetailitemcode(sofzj.getAcupointCode());
                sysFinancialDetail.setDetailitemname(sofzj.getAcupointName());
                sysFinancialDetail.setQuantity(new BigDecimal(1));
                sysFinancialDetail.setUnitprice(new BigDecimal(0));
                sysFinancialDetail.setPayitemcode("(๑¯ ³ ¯๑)");
                int insFinDet = saveOrFinishZJService.insertFinDet(sysFinancialDetail);
                System.out.println(insFinDet+"针灸治疗--财务子表添加!");
                if (insertDetail > 0){
                    ouye = true;
                }
            }

        }
        System.out.println(ouye);
//        if (updateEMP > 0 && updateHISEMP > 0 && insertSub > 0 && ouye){
        if (insertSub > 0 && ouye){
            return ResultFactory.create("0","保存成功!",1);
        }
        return ResultFactory.create("1","保存失败!",null);

    }


}
