package com.yyk.sz.zhzy.jcsjxt.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJCure;
import com.yyk.sz.zhzy.jcsjxt.service.JCSJCureService;
import com.yyk.sz.zhzy.jcsjxt.utils.UtilString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 基础数据-治法设置 Controller
 */
@Api2Doc(id = "jcsjxt.zfsz", name = "基础数据-治法设置")
@ApiComment(seeClass = JCSJCure.class)
@RestController
@RequestMapping(value = "/jcsjxt/zfsz/")
public class JCSJCureController {

    @Autowired
    private JCSJCureService cureService;

    /**
     * 获取治法设置
     *
     * @return 治法设置列表
     */
    @ApiComment(" 获取治法设置")
    @RequestMapping(value = "/getCureTable", method = RequestMethod.POST)
    @ResponseBody
    public Result getCureTable(
            @RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
            @RequestParam(value = "searchText", required = false) String searchText,
            @RequestParam(value = "sortName", required = false) String sortName,
            @RequestParam(value = "sortOrder", required = false, defaultValue = "desc") String sortOrder
    ) {
        searchText = UtilString.judgeNull(searchText);
        if (searchText != null) {
            searchText = "%" + searchText + "%";
        }
        Paging<JCSJCure> pulses = cureService.getCureTable(pageNumber, pageSize, searchText, sortName, sortOrder);
        if (pulses == null || pulses.getSize() == 0) {
            return ResultFactory.create("1", "没有治法数据", null);
        }
        return ResultFactory.create("0", null, pulses);
    }

    /**
     * 新增治法设置
     *
     * @return
     */
    @ApiComment(" 新增治法设置")
    @RequestMapping(value = "/insertCure", method = RequestMethod.POST)
    @ResponseBody
    public Result insertCure(
            @RequestBody JCSJCure jcsjCure
    ) {
        if (cureService.checkCureExits(jcsjCure.getCurecode(), null).size() > 0) {
            return ResultFactory.create("1", "治法编码： " + jcsjCure.getCurecode() + " 已经存在，不能重复添加！", null);
        }
        if (cureService.checkCureExits(null, jcsjCure.getCurename()).size() > 0) {
            return ResultFactory.create("1", "治法名称： " + jcsjCure.getCurename() + " 已经存在，不能重复添加！", null);
        }
        int flag = cureService.insertCure(jcsjCure);
        if (flag > 0) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 修改治法设置
     *
     * @return
     */
    @ApiComment(" 修改治法设置 curename2 新的")
    @RequestMapping(value = "/updateCure", method = RequestMethod.POST)
    @ResponseBody
    public Result updateCure(
            @RequestBody JCSJCure jcsjCure
    ) {
        if (!jcsjCure.getCurename().equals(jcsjCure.getCurename2())) {
            if (cureService.checkCureExits(null, jcsjCure.getCurename2()).size() > 0) {
                return ResultFactory.create("1", "治法名称： " + jcsjCure.getCurename2() + " 已经存在，不能修改！", null);
            }
        }
        int flag = cureService.updateCure(jcsjCure);
        if (flag > 0) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 删除治法设置
     *
     * @return
     */
    @ApiComment(" 删除治法设置")
    @RequestMapping(value = "/deleteCure", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteCure(
            @RequestParam("curecode") String curecode
    ) {
        if (cureService.GetCureDialecticalRelation(curecode).size() > 0) {
            return ResultFactory.create("1", curecode + "  证型中用到了该治法，不能删除！", null);
        }
        int flag = cureService.deleteCure(curecode);
        if (flag > 0) {
            return ResultFactory.create("0", "删除成功", null);
        }
        return ResultFactory.create("1", "删除失败", null);
    }

}
