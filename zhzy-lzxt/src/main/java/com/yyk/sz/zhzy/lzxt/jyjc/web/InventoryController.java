package com.yyk.sz.zhzy.lzxt.jyjc.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysInventory;
import com.yyk.sz.zhzy.lzxt.jyjc.entity.SysInventoryTX;
import com.yyk.sz.zhzy.lzxt.jyjc.service.CheckItemService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZhangChao
 * @Date: 2019/1/18 16:25
 * @Version: 1.0
 */
@Api2Doc(id = "lzxt.jyjc.3", name = "进销存相关")
@ApiComment(seeClass = SysInventory.class)
@RestController
@RequestMapping("/lzxt/jyjc")
public class InventoryController {

    @Resource
    private CheckItemService checkItemService;

    /**
     * 获取所有药物列表--进销存
     *
     * @return
     */
    @ApiComment("获取所有药物列表--进销存")
    @RequestMapping(value = "/getInventoryAll", method = RequestMethod.POST)
    @ResponseBody
    public Result getInventoryAll(
            @RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
            @RequestParam(value = "searchText", required = false) String searchText,
            @RequestParam(value = "sortName", required = false, defaultValue = "a.DrugCode") String sortName,
            @RequestParam(value = "sortOrder", required = false, defaultValue = "desc") String sortOrder) {
        if (searchText != null) {
            searchText = "%" + searchText + "%";
        }
        Paging<SysInventory> inventorList = checkItemService.getInventoryAll(pageNumber,pageSize,searchText,sortName,sortOrder);
        if (inventorList != null && inventorList.getSize() > 0){
            return ResultFactory.create("0", "这是所有药物的数据", inventorList);
        }
        return ResultFactory.create("1", "获取失败", null);
    }

    /**
     * 库存预警提醒
     *
     * @return
     */
    @ApiComment("库存预警提醒")
    @RequestMapping(value = "/getWarningList", method = RequestMethod.POST)
    @ResponseBody
    public Result getWarningList(
            @RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
            @RequestParam(value = "searchText", required = false) String searchText,
            @RequestParam(value = "sortName", required = false, defaultValue = "a.DrugCode") String sortName,
            @RequestParam(value = "sortOrder", required = false, defaultValue = "desc") String sortOrder) {
        if (searchText != null) {
            searchText = "%" + searchText + "%";
        }
        Paging<SysInventoryTX> inventorList = checkItemService.getWarningList(pageNumber,pageSize,searchText,sortName,sortOrder);
        for (SysInventoryTX sitx : inventorList.getRows()){

        }

        if (inventorList != null){
            return ResultFactory.create("0", "这是预警数据列表", inventorList);
        }
        return ResultFactory.create("1", "获取失败", null);
    }

    /**
     * 库存管理
     *
     * @return
     */
    @ApiComment("库存管理")
    @RequestMapping(value = "/updateInvertory", method = RequestMethod.POST)
    @ResponseBody
    public Result updateInvertory(
            @RequestParam("intoamount") String intoamount,
            @RequestParam("warningamount") String warningamount,
            @RequestParam("drugcode") String drugcode) {
        //search this data
        BigDecimal intoamountt = new BigDecimal(intoamount);
        int i = intoamountt.compareTo(new BigDecimal(0));
        if (i < 0){ //入库值小于0
            intoamountt = new BigDecimal(0);
            System.out.println("输入的入库值小于0，非法!");
        }
        SysInventory sysInventory1 = checkItemService.selectByPrimaryKey(Integer.parseInt(drugcode));
        BigDecimal remainamount = sysInventory1.getRemainamount(); // 获取此药物的剩余库存
        remainamount = remainamount.add(intoamountt);
        SysInventory sysInventory = new SysInventory();
        sysInventory.setDrugcode(Integer.parseInt(drugcode));
        sysInventory.setIntoamount(intoamountt); //入库值
        sysInventory.setWarningamount(new BigDecimal(warningamount)); //预警值
        sysInventory.setRemainamount(remainamount); //设置新的剩余库存
        int update = checkItemService.updateInvertory(sysInventory);

        if (update> 0){
            return ResultFactory.create("0", "更新成功", 1);
        }
        return ResultFactory.create("1", "更新失败", null);
    }



}
