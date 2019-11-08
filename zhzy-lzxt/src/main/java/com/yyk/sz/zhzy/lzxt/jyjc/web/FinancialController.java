package com.yyk.sz.zhzy.lzxt.jyjc.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.lzxt.hzlb.entity.PatientList;
import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysFinancial;
import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysFinancialDetail;
import com.yyk.sz.zhzy.lzxt.jyjc.service.CheckItemService;
import com.yyk.sz.zhzy.lzxt.utils.UtilString;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZhangChao
 * @Date: 2019/1/16 14:25
 * @Version: 1.0
 */
@Api2Doc(id = "lzxt.jyjc.1", name = "财务相关")
@ApiComment(seeClass = SysFinancial.class)
@RestController
@RequestMapping("/lzxt/jyjc")
public class FinancialController {

    @Resource
    private CheckItemService checkItemService;

//    /**
//     * 获取未缴费列表、已缴费列表或者部分缴费列表
//     *
//     * @return
//     */
//    @ApiComment("获取未缴费列表、已缴费列表或者部分缴费列表")
//    @RequestMapping(value = "/getPayStatusListOld", method = RequestMethod.POST)
//    @ResponseBody
//    public Result getPayStatusListOld(@RequestParam("paystatus") String paystatus,
//                                   @RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
//                                   @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
//                                   @RequestParam(value = "searchText", required = false) String searchText,
//                                   @RequestParam(value = "sortName", required = false, defaultValue = "b.MakeDate") String sortName,
//                                   @RequestParam(value = "sortOrder", required = false, defaultValue = "desc") String sortOrder) {
//        List<SysFinancial> wjf = new ArrayList<>();
//        List<SysFinancial> yjf = new ArrayList<>();
//        List<SysFinancial> bfjf = new ArrayList<>();
//        searchText = UtilString.judgeNull(searchText);
//        if (searchText != null) {
//            searchText = "%" + searchText + "%";
//        }
//        Paging<SysFinancial> financialList = checkItemService.getAllList(pageNumber, pageSize, searchText, sortName, sortOrder);
//        //加工数据
//        List<SysFinancial> finaList = new ArrayList<>();
//        for (SysFinancial sf : financialList.getRows()) {
//            finaList = checkItemService.selectPayStatus(sf.getEmpbasicmainid());
//            if (finaList.size() == 1 && finaList.get(0).getPaystatus() == 0) {
//                sf.setPaystatus(0);
//                sf.setPaystatusstr("未缴费");
//                wjf.add(sf);
//            }
//            if (finaList.size() == 1 && finaList.get(0).getPaystatus() == 1) {
//                sf.setPaystatus(1);
//                sf.setPaystatusstr("已缴费");
//                yjf.add(sf);
//            }
//            if (finaList.size() == 2) {
//                sf.setPaystatus(2);
//                sf.setPaystatusstr("部分缴费");
//                bfjf.add(sf);
//            }
//        }
//        System.out.println(wjf.size() + ";" + yjf.size() + ";" + bfjf.size());
//        if ("0".equals(paystatus)) {
//            financialList.setTotal(wjf.size());
//            financialList.setTotalSize(wjf.size());
//            financialList.setSize(0);
//            financialList.setPageSize(pageSize);
//            financialList.setTotalPages((wjf.size() + pageSize - 1) / pageSize);
//            int totalpages = (wjf.size() + pageSize - 1) / pageSize;
//            if (pageNumber == totalpages){
//                wjf = wjf.subList((pageNumber-1)*pageSize,wjf.size()); //前台要几条就给他几条
//            } else {
//                wjf = wjf.subList((pageNumber-1)*pageSize,pageNumber*pageSize); //前台要几条就给他几条
//            }
//            financialList.getRows().clear();
//            financialList.getRows().addAll(wjf);
//            return ResultFactory.create("0", "这是未缴费数据", financialList);
//        }
//        if ("1".equals(paystatus)) {
//            financialList.setTotal(yjf.size());
//            financialList.setTotalSize(yjf.size());
//            financialList.setSize(0);
//            financialList.setPageSize(pageSize);
//            financialList.setTotalPages((yjf.size() + pageSize - 1) / pageSize);
//            int totalpages = (yjf.size() + pageSize - 1) / pageSize;
//            if (pageNumber == totalpages){
//                yjf = yjf.subList((pageNumber-1)*pageSize,yjf.size()); //前台要几条就给他几条
//            } else {
//                yjf = yjf.subList((pageNumber-1)*pageSize,pageNumber*pageSize); //前台要几条就给他几条
//            }
//            financialList.getRows().clear();
//            financialList.getRows().addAll(yjf);
//            return ResultFactory.create("0", "这是已缴费数据", financialList);
//        }
//        if ("2".equals(paystatus)) {
//
//            financialList.setTotal(bfjf.size());
//            financialList.setTotalSize(bfjf.size());
//            financialList.setSize(0);
//            financialList.setPageSize(pageSize);
//            financialList.setTotalPages((bfjf.size() + pageSize - 1) / pageSize);
//            int totalpages = (bfjf.size() + pageSize - 1) / pageSize;
//            if (pageNumber == totalpages){
//                bfjf = bfjf.subList((pageNumber-1)*pageSize,bfjf.size()); //前台要几条就给他几条
//            } else {
//                bfjf = bfjf.subList((pageNumber-1)*pageSize,pageNumber*pageSize); //前台要几条就给他几条
//            }
//            financialList.getRows().clear();
//            financialList.getRows().addAll(bfjf);
//            return ResultFactory.create("0", "这是部分缴费数据", financialList);
//        }
//        return ResultFactory.create("1", "获取失败", null);
//    }

    /**
     * 获取未缴费列表、已缴费列表或者部分缴费列表--2019/3/4重构
     *
     * @return
     */
    @ApiComment("获取未缴费列表、已缴费列表或者部分缴费列表--2019/3/4重构")
    @RequestMapping(value = "/getPayStatusList", method = RequestMethod.POST)
    @ResponseBody
    public Result getPayStatusList(@RequestParam("paystatus") String paystatus,
                                   @RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
                                   @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                                   @RequestParam(value = "searchText", required = false) String searchText,
                                   @RequestParam(value = "sortName", required = false, defaultValue = "m.MakeDate") String sortName,
                                   @RequestParam(value = "sortOrder", required = false, defaultValue = "desc") String sortOrder) {
        Paging<SysFinancial> resultList = null;
        searchText = UtilString.judgeNull(searchText);
        if (searchText != null) {
            searchText = "%" + searchText + "%";
        }
        //未缴费
        if ("0".equals(paystatus)){
            resultList = checkItemService.getWFKList(pageNumber,pageSize,searchText,sortName,sortOrder);
            return ResultFactory.create("0", "这是未缴费数据", resultList);
        }
        //已缴费
        if ("1".equals(paystatus)){
            resultList = checkItemService.getYFKList(pageNumber,pageSize,searchText,sortName,sortOrder);
            return ResultFactory.create("0", "这是已缴费数据", resultList);
        }
        //部分缴费
        if ("2".equals(paystatus)){
            resultList = checkItemService.getBFFKList(pageNumber,pageSize,searchText,sortName,sortOrder);
            return ResultFactory.create("0", "这是部分缴费数据", resultList);
        }

        return ResultFactory.create("1", "获取失败", null);
    }

    /**
     * 某病人的缴费页面
     *
     * @return
     */
    @ApiComment("某病人的缴费页面")
    @RequestMapping(value = "/getItemList", method = RequestMethod.POST)
    @ResponseBody
    public Result getItemList(@RequestParam("empBasicMainID") Integer empBasicMainID) {
        List<SysFinancial> resultList = new ArrayList<>();
        List<SysFinancial> itemList = checkItemService.getItemList(empBasicMainID);
        for (SysFinancial sf : itemList) {
            if (sf.getPayitem() == 0) {
                sf.setPayitemstr("中药处方");
            }
            if (sf.getPayitem() == 1) {
                sf.setPayitemstr("西药处方");
            }
            if (sf.getPayitem() == 2) {
                sf.setPayitemstr("检验");
            }
            if (sf.getPayitem() == 3) {
                sf.setPayitemstr("检查");
            }
            if (sf.getPayitem() == 4) {
                sf.setPayitemstr("临证治疗");
            }
            if (sf.getPayitem() == 5) {
                sf.setPayitemstr("针灸治疗");
            }
            resultList.add(sf);
        }
        if (itemList != null && itemList.size() > 0) {
            return ResultFactory.create("0", "主项目获取成功!", resultList);
        }
        return ResultFactory.create("1", "获取失败", null);
    }


    /**
     * 某一主项点击付款
     *
     * @return
     */
    @ApiComment("某一主项点击付款")
    @RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
    @ResponseBody
    public Result updateStatus(
            @RequestParam("empBasicMainID") Integer empBasicMainID,
            @RequestParam("payitem") Integer payitem,
            @RequestParam("paytype") Integer paytype) {
        SysFinancial sysFinancial = new SysFinancial();
        sysFinancial.setEmpbasicmainid(empBasicMainID);
        sysFinancial.setPaytype(paytype);
        sysFinancial.setPaystatus(1); //设置为已付款
        String[] payitemArr = payitem.toString().split(",");
        int updateStatus = 0;
        for (int i = 0; i < payitemArr.length; i++) {
            sysFinancial.setPayitem(Integer.parseInt(payitemArr[i]));
            updateStatus += checkItemService.updatePayStatus(sysFinancial);
        }
        System.out.println(updateStatus);
        if (updateStatus > 0) {
            return ResultFactory.create("0", "付款成功!", 1);
        }
        return ResultFactory.create("1", "付款失败", null);
    }

    /**
     * 全部付款
     *
     * @return
     */
    @ApiComment("全部付款")
    @RequestMapping(value = "/updateStatusAll", method = RequestMethod.POST)
    @ResponseBody
    public Result updateStatusAll(
            @RequestParam("empBasicMainID") Integer empBasicMainID,
            @RequestParam(value = "paytype", required = false) Integer paytype) {
        SysFinancial sysFinancial = new SysFinancial();
        sysFinancial.setEmpbasicmainid(empBasicMainID);
        if (paytype != null) {
            sysFinancial.setPaytype(paytype);
        }
        sysFinancial.setPaystatus(1); //设置为已付款
        int updateStatus = checkItemService.updatePayStatusAll(sysFinancial);
        System.out.println(updateStatus);
        if (updateStatus > 0) {
            return ResultFactory.create("0", "全部付款成功!", 1);
        }
        return ResultFactory.create("1", "全部付款失败", null);
    }

    /**
     * 详情页面
     *
     * @return
     */
    @ApiComment("详情页面")
    @RequestMapping(value = "/getItemDetail", method = RequestMethod.POST)
    @ResponseBody
    public Result getItemDetail(
            @RequestParam("empBasicMainID") Integer empBasicMainID,
            @RequestParam("payitem") Integer payitem) {
        SysFinancialDetail sysFinancialDetail = new SysFinancialDetail();
        sysFinancialDetail.setEmpbasicmainid(empBasicMainID);
        sysFinancialDetail.setPayitem(payitem);
        List<SysFinancialDetail> sysFinancialDetailList = checkItemService.getItemDetail(sysFinancialDetail);
        if (sysFinancialDetailList != null && sysFinancialDetailList.size() > 0) {
            return ResultFactory.create("0", "项目详情获取成功!", sysFinancialDetailList);
        }
        return ResultFactory.create("1", "获取失败", null);
    }

}
