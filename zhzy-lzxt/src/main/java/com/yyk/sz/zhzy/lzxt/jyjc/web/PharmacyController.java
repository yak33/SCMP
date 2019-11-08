package com.yyk.sz.zhzy.lzxt.jyjc.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysInventory;
import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysPharmacy;
import com.yyk.sz.zhzy.lzxt.jyjc.service.CheckItemService;
import com.yyk.sz.zhzy.lzxt.utils.UtilString;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: ZhangChao
 * @Date: 2019/1/17 17:47
 * @Version: 1.0
 */
@Api2Doc(id = "lzxt.jyjc.2", name = "药房相关")
@ApiComment(seeClass = SysPharmacy.class)
@RestController
@RequestMapping("/lzxt/jyjc")
public class PharmacyController {

    @Resource
    private CheckItemService checkItemService;

//    /**
//     * 获取未取药、已取药列表
//     *
//     * @return
//     */
//    @ApiComment("获取未取药、已取药列表。0未取药1已取药")
//    @RequestMapping(value = "/getAllPhaListOld", method = RequestMethod.POST)
//    @ResponseBody
//    public Result getAllPhaListOld(
//            @RequestParam("takeflag") String takeflag,
//            @RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
//            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
//            @RequestParam(value = "searchText", required = false) String searchText,
//            @RequestParam(value = "sortName", required = false, defaultValue = "makeDate") String sortName,
//            @RequestParam(value = "sortOrder", required = false, defaultValue = "desc") String sortOrder) {
//        List<SysPharmacy> weiquList = new ArrayList<>();
//        List<SysPharmacy> yiquList = new ArrayList<>();
//        if (searchText != null) {
//            searchText = "%" + searchText + "%";
//        }
//        Paging<SysPharmacy> getAllPhaList = checkItemService.getAllPhaList(pageNumber, pageSize, searchText, sortName, sortOrder);
//        List<SysPharmacy> phaList = getAllPhaList.getRows();
//        List<SysPharmacy> pharmacyList = new ArrayList<>();
//        List<SysPharmacy> finaList = new ArrayList<>();
//        List<SysPharmacy> phList = new ArrayList<>();
//        for (SysPharmacy sp : phaList) {
//            finaList = checkItemService.selectPayStatusPha(sp.getEmpbasicmainid());
//            phList = checkItemService.selectTakeFlagPha(sp.getEmpbasicmainid());
//            //缴费情况
//            if (finaList.size() == 1 && finaList.get(0).getPaystatus() == 0) {
//                sp.setPaystatus(0);
//                sp.setPaystatusstr("未缴费");
//            }
//            if (finaList.size() >= 2) {
//                sp.setPaystatus(2);
//                sp.setPaystatusstr("部分缴费");
//            }
//            if (finaList.size() == 1 && finaList.get(0).getPaystatus() == 1) {
//                sp.setPaystatus(1);
//                sp.setPaystatusstr("已缴费");
//            }
//            //取药情况
//            if (phList.size() >= 2 || phList.get(0).getTakeflag() == 0) {
//                sp.setTakeflag(0);
//                sp.setTakeflagstr("未取药");
//            }
//            if (phList.size() == 1 && phList.get(0).getTakeflag() == 1) {
//                sp.setTakeflag(1);
//                sp.setTakeflagstr("已取药");
//            }
//            pharmacyList.add(sp);
//        }
//        for (SysPharmacy sph : pharmacyList) {
//            if (sph.getTakeflag() == 0) {
//                weiquList.add(sph);
//            }
//            if (sph.getTakeflag() == 1) {
//                yiquList.add(sph);
//            }
//        }
//        if (takeflag != null && takeflag.equals("0")) {
//            getAllPhaList.setTotalSize(weiquList.size());
//            getAllPhaList.setTotal(weiquList.size());
//            getAllPhaList.setSize(0);
//            getAllPhaList.setTotalPages((weiquList.size()+pageSize-1)/pageSize);
//            int totalpages = (weiquList.size() + pageSize - 1) / pageSize;
//            if (pageNumber == totalpages){
//                weiquList = weiquList.subList((pageNumber-1)*pageSize,weiquList.size()); //前台要几条就给他几条
//            } else {
//                weiquList = weiquList.subList((pageNumber-1)*pageSize,pageNumber*pageSize); //前台要几条就给他几条
//            }
//            getAllPhaList.getRows().clear();
//            getAllPhaList.getRows().addAll(weiquList);
//            return ResultFactory.create("0", "这是未取药的数据", getAllPhaList);
//        }
//        if (takeflag != null && takeflag.equals("1")) {
//            getAllPhaList.setTotal(yiquList.size());
//            getAllPhaList.setTotalSize(yiquList.size());
//            getAllPhaList.setSize(0);
//            getAllPhaList.setTotalPages((yiquList.size()+pageSize-1)/pageSize);
//            int totalpages = (yiquList.size() + pageSize - 1) / pageSize;
//            if (pageNumber == totalpages){
//                yiquList = yiquList.subList((pageNumber-1)*pageSize,yiquList.size()); //前台要几条就给他几条
//            } else {
//                yiquList = yiquList.subList((pageNumber-1)*pageSize,pageNumber*pageSize); //前台要几条就给他几条
//            }
//            getAllPhaList.getRows().clear();
//            getAllPhaList.getRows().addAll(yiquList);
//            return ResultFactory.create("0", "这是已取药的数据", getAllPhaList);
//        }
//
//        return ResultFactory.create("1", "获取失败", null);
//    }

    /**
     * 获取未取药、已取药列表--2019/3/5重构
     *
     * @return
     */
    @ApiComment("获取未取药、已取药列表。0未取药1已取药--2019/3/5重构")
    @RequestMapping(value = "/getAllPhaList", method = RequestMethod.POST)
    @ResponseBody
    public Result getAllPhaList(
            @RequestParam("takeflag") String takeflag,
            @RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
            @RequestParam(value = "searchText", required = false) String searchText,
            @RequestParam(value = "sortName", required = false, defaultValue = "makeDate") String sortName,
            @RequestParam(value = "sortOrder", required = false, defaultValue = "desc") String sortOrder) {
        searchText = UtilString.judgeNull(searchText);
        if (searchText != null) {
            searchText = "%" + searchText + "%";
        }
        Paging<SysPharmacy> getAllPhaList = null;
        //未取药
        if ("0".equals(takeflag)){
            getAllPhaList = checkItemService.getWQPhaList(pageNumber, pageSize, searchText, sortName, sortOrder);
            return ResultFactory.create("0", "这是未取药数据", getAllPhaList);
        }
        //已取药
        if ("1".equals(takeflag)){
            getAllPhaList = checkItemService.getYQPhaList(pageNumber, pageSize, searchText, sortName, sortOrder);
            return ResultFactory.create("0", "这是已取药数据", getAllPhaList);
        }

        return ResultFactory.create("1", "获取失败", null);
    }

    /**
     * 获取某病人的药物详情
     *
     * @return
     */
    @ApiComment("获取某病人的药物详情--daiJian 0否 1是")
    @RequestMapping(value = "/getDrugDetail", method = RequestMethod.POST)
    @ResponseBody
    public Result getDrugDetail(@RequestParam("empBasicMainID") Integer empBasicMainID) {
        SysPharmacy sysPharmacy = new SysPharmacy();
        List<SysPharmacy> zyList = new ArrayList<>();
        List<SysPharmacy> xyList = new ArrayList<>();
        List<SysPharmacy> xyList1 = new ArrayList<>();
        List<SysPharmacy> sysPharmacyList = checkItemService.getDrugDetail(empBasicMainID);
        for (SysPharmacy sp : sysPharmacyList) {
            if (sp.getItemtype() == 0) { //中药
                zyList.add(sp);
                sysPharmacy.setUsageCount(sp.getUsageCount());
                sysPharmacy.setDaiJian(sp.getDaiJian());
            }
            if (sp.getItemtype() == 1) {
                xyList.add(sp);
            }
        }
        if (xyList != null && xyList.size() > 0){
            for (SysPharmacy sppp : xyList){
                SysPharmacy sysPharmacy1 = checkItemService.getPrescriptionName(sppp.getDrugcode());
                if (sysPharmacy1!=null){
                    sppp.setPrescriptionunitname(sysPharmacy1.getPrescriptionunitname());
                }
                xyList1.add(sppp);
            }
            sysPharmacy.setXyList(xyList1);
        }else{
            sysPharmacy.setXyList(xyList);
        }

        List<SysPharmacy> es = checkItemService.getPayOrNo(empBasicMainID);
        String zyflag = "";
        String xyflag = "";
        for (SysPharmacy spp : es){
            if (spp.getPayitem()==1){ //西药
                if (spp.getPaystatus()==0){
                    xyflag = "0";
                    sysPharmacy.setXyFlag(xyflag);
                }else{
                    xyflag = "1";
                    sysPharmacy.setXyFlag(xyflag);
                }
            }
            if (spp.getPayitem()==0){ //中药
                if (spp.getPaystatus()==0){
                    zyflag = "0";
                    sysPharmacy.setZyFlag(zyflag);
                }else{
                    zyflag = "1";
                    sysPharmacy.setZyFlag(zyflag);
                }
            }
        }
        sysPharmacy.setZyList(zyList);

        return ResultFactory.create("0", "success", sysPharmacy);
    }

    /**
     * 设置已取药，放药
     *
     * @return
     */
    @ApiComment("设置已取药，放药")
    @RequestMapping(value = "/updateTakeFlag", method = RequestMethod.POST)
    @ResponseBody
    public Result updateTakeFlag(
            @RequestParam("empBasicMainID") Integer empBasicMainID,
            @RequestParam("itemType") Integer itemType) {
        SysPharmacy sysPharmacy = new SysPharmacy();
        sysPharmacy.setEmpbasicmainid(empBasicMainID);
        sysPharmacy.setItemtype(itemType);
        sysPharmacy.setTakeflag(1); //设置为已取药
        int update = checkItemService.updateTakeFlag(sysPharmacy);

        //设置库存
        //找到此人此项目下所有的药物code
        List<SysPharmacy> splist = checkItemService.getDrugCodeList(sysPharmacy);
        //List<String> list = new ArrayList<>();
        Map<String, Double> drugMap = new HashMap();
        for (SysPharmacy sp : splist) {
            if (itemType == 1){
                drugMap.put(sp.getDrugcode(), sp.getQuantity());
            }else {
                drugMap.put(sp.getDrugcode(), sp.getQuantity()*sp.getUsageCount());
            }
        }
        //遍历所有的药物code
        for (Map.Entry<String, Double> entry : drugMap.entrySet()) {
            System.out.println(entry.getKey()+";"+entry.getValue());
            BigDecimal remainamount = checkItemService.selectByPrimaryKey(Integer.parseInt(entry.getKey())).getRemainamount(); // 获取此药物的剩余库存
            remainamount = remainamount.subtract(new BigDecimal(entry.getValue().toString())); //减去取药数量即新的库存数量
            SysInventory sysInventory = new SysInventory();
            sysInventory.setDrugcode(Integer.parseInt(entry.getKey()));
            sysInventory.setRemainamount(remainamount);
            checkItemService.updateNewRemain(sysInventory);
        }

        if (update > 0) {
            return ResultFactory.create("0", "放药成功", 1);
        }
        return ResultFactory.create("1", "error", null);
    }

}
