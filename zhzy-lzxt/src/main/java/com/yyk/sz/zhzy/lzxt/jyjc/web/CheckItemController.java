package com.yyk.sz.zhzy.lzxt.jyjc.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.lzxt.jyjc.entity.CheckItem;
import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysFinancial;
import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysFinancialDetail;
import com.yyk.sz.zhzy.lzxt.jyjc.service.CheckItemService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZhangChao
 * @Date: 2018-11-14 10:09
 */
@Api2Doc(id = "lzxt.jyjc", name = "临症-检验检查")
@ApiComment(seeClass = CheckItem.class)
@RestController
@RequestMapping("/lzxt/jyjc")
public class CheckItemController {
    @Resource
    private CheckItemService checkItemService;

    /**
     * index，测试用
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public Result index() {
        return ResultFactory.create("0","success",null);
    }

    /**
     * 获取所有的检验或检查项目-- 0：检查，1：检验
     * @param detailItemFlag
     * @return
     */
    @ApiComment("获取所有的检验或检查项目-- 0：检查，1：检验")
    @RequestMapping(value = "/getCheckItemList", method = RequestMethod.POST)
    @ResponseBody
    public Result getCheckItemList(
            @RequestParam(value = "detailItemFlag") int detailItemFlag){
        List<CheckItem> es = new ArrayList<>();
        List<CheckItem> getCIList = checkItemService.getCheckItemList(detailItemFlag);
        for (CheckItem checkItem : getCIList){
            checkItem.setCheckItemList(checkItemService.getCheckItemDetailList(checkItem.getSummaryCode()));
            es.add(checkItem);
        }
        if (getCIList != null){
            return ResultFactory.create("0",null, es);
        }
        return ResultFactory.create("1","无数据",null);
    }

    /**
     * 获取检验或检查项目明细
     * @param summaryCode
     * @return
     */
    @ApiComment("根据主项目编号获取检验或检查子项目")
    @RequestMapping(value = "/getCheckItemDetailList", method = RequestMethod.POST)
    @ResponseBody
    public Result getCheckItemDetailList(
            @RequestParam("summaryCode") String summaryCode){
        List<CheckItem> getCIDList = checkItemService.getCheckItemDetailList(summaryCode);
        if (getCIDList != null && getCIDList.size() > 0){
            return ResultFactory.create("0",null, getCIDList);
        }
        return ResultFactory.create("1","无数据",null);
    } 

    /**
     * 获取已存的检验或检查项目
     * @param empBasicMainID
     * @param checkFlag
     * @return
     */
    @ApiComment("获取已存的检验或检查项目")
    @RequestMapping(value = "/getYiCunCheckItemList", method = RequestMethod.POST)
    @ResponseBody
    public Result getYiCunCheckItemList(
            @RequestParam("empBasicMainID") Integer empBasicMainID,
            @RequestParam(value = "checkFlag",required = false) Integer checkFlag){
        List<CheckItem> getYCCIList = checkItemService.getYiCunCheckItemList(empBasicMainID,checkFlag);
        if (getYCCIList != null && getYCCIList.size() > 0){
            return ResultFactory.create("0",null, getYCCIList);
        }
        return ResultFactory.create("1","无数据",null);
    }

    /**
     * 保存检验or检查项目
     * @return
     */
    @ApiComment("保存检验or检查项目")
    @RequestMapping(value = "/saveCheckItem", method = RequestMethod.POST)
    @ResponseBody
    public Result saveCheckItem(@RequestBody CheckItem checkItem){
        List<CheckItem> es = new ArrayList<>();
        checkItemService.delCheckSub(checkItem);
        // 财务相关。
        // 先清一遍主表和子表，根据病人id和检验检查类型。
        SysFinancial sysFinancial = new SysFinancial();
        SysFinancialDetail sysFinancialDetail = new SysFinancialDetail();
        int payitem = -1;
        if (checkItem.getCheckFlag() == 1){ //检验
            payitem = 2;
        }
        if (checkItem.getCheckFlag() == 0){ //检查
            payitem = 3;
        }
        sysFinancial.setEmpbasicmainid(checkItem.getEmpBasicMainID());
        sysFinancial.setPayitem(payitem);
        sysFinancialDetail.setEmpbasicmainid(checkItem.getEmpBasicMainID());
        sysFinancialDetail.setPayitem(payitem);
        checkItemService.delFinancial(sysFinancial); //删除主表此人此项目..
        checkItemService.delFinancialDetail(sysFinancialDetail); //删除子表此人此项目明细..
        //添加财务主表数据..
        sysFinancial.setPayitemcode("(๑¯ ³ ¯๑)");
        sysFinancial.setPaytype(60); //默认不报销
        sysFinancial.setPaystatus(0); //默认未缴费
        double totalmoney = 0;
        boolean flag = false;
        List<CheckItem> checkItemList = checkItem.getCheckItemList();
        if (checkItemList != null && checkItemList.size() > 0){
            for (int i=0;i<checkItemList.size();i++){
                CheckItem ci = checkItemList.get(i);
                ci.setEmpBasicMainID(checkItem.getEmpBasicMainID());
                ci.setCheckFlag(checkItem.getCheckFlag());
                totalmoney += checkItemList.get(i).getPrice().doubleValue();
                int insert = checkItemService.insertCheckSub(checkItemList.get(i));
                sysFinancialDetail.setDetailitemcode(checkItemList.get(i).getDetailItemCode());
                sysFinancialDetail.setDetailitemname(checkItemService.getDetailItemName(checkItemList.get(i).getDetailItemCode()));
                sysFinancialDetail.setQuantity(new BigDecimal(1));
                sysFinancialDetail.setUnitprice(checkItemList.get(i).getPrice());
                sysFinancialDetail.setPayitemcode("(๑¯ ³ ¯๑)");
                int insFinDet = checkItemService.insertFinDet(sysFinancialDetail);
                System.out.println(insFinDet+"财务子表添加!");
                if (insert > 0){
                    flag = true;
                }
            }
            sysFinancial.setTotalmoney(new BigDecimal(Double.toString(totalmoney)));
            int insFin = checkItemService.insertFin(sysFinancial);
            System.out.println(insFin+"财务主表添加");
        } else {
            return ResultFactory.create("0","success", 1);
        }
        if (flag){
            return ResultFactory.create("0","success", 1);
        }
        return ResultFactory.create("1","保存失败!",null);
    }

}
