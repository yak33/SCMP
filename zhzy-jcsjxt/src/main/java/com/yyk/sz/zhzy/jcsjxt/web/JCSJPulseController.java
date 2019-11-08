package com.yyk.sz.zhzy.jcsjxt.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJPulse;
import com.yyk.sz.zhzy.jcsjxt.service.JCSJPulseService;
import com.yyk.sz.zhzy.jcsjxt.utils.UtilString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 基础数据-脉象设置 Controller
 */
@Api2Doc(id = "jcsjxt.mxsz", name = "基础数据-脉象设置")
@ApiComment(seeClass = JCSJPulse.class)
@RestController
@RequestMapping(value = "/jcsjxt/mxsz/")
public class JCSJPulseController {

    @Autowired
    private JCSJPulseService pulseService;

    /**
     * 获取脉象设置
     *
     * @return 脉象设置列表
     */
    @ApiComment(" 获取脉象设置")
    @RequestMapping(value = "/getPulseTable", method = RequestMethod.POST)
    @ResponseBody
    public Result getPulseTable(
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
        Paging<JCSJPulse> pulses = pulseService.getPulseTable(pageNumber, pageSize, searchText, sortName, sortOrder);
        if (pulses == null || pulses.getSize() == 0) {
            return ResultFactory.create("1", "没有脉象数据", null);
        }
        return ResultFactory.create("0", null, pulses);
    }

    /**
     * 新增脉象设置
     *
     * @return
     */
    @ApiComment(" 新增脉象设置")
    @RequestMapping(value = "/insertPulse", method = RequestMethod.POST)
    @ResponseBody
    public Result insertPulse(
            @RequestBody JCSJPulse jcsjPulse
    ) {
        if (pulseService.checkPulseExits(jcsjPulse.getPulsecode(), null).size() > 0) {
            return ResultFactory.create("1", "脉象编码： " + jcsjPulse.getPulsecode() + " 已经存在，不能重复添加！", null);
        }
        if (pulseService.checkPulseExits(null, jcsjPulse.getPulsename()).size() > 0) {
            return ResultFactory.create("1", "脉象名称： " + jcsjPulse.getPulsename() + " 已经存在，不能重复添加！", null);
        }
        int flag = pulseService.insertPulse(jcsjPulse);
        if (flag > 0) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 修改脉象设置
     *
     * @return
     */
    @ApiComment(" 修改脉象设置 pulsename2 新的")
    @RequestMapping(value = "/updatePulse", method = RequestMethod.POST)
    @ResponseBody
    public Result updatePulse(
            @RequestBody JCSJPulse jcsjPulse
    ) {
        if (!jcsjPulse.getPulsename().equals(jcsjPulse.getPulsename2())) {
            if (pulseService.checkPulseExits(null, jcsjPulse.getPulsename2()).size() > 0) {
                return ResultFactory.create("1", "脉象名称： " + jcsjPulse.getPulsename2() + " 已经存在，不能修改！", null);
            }
        }
        int flag = pulseService.updatePulse(jcsjPulse);
        if (flag > 0) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 删除脉象设置
     *
     * @return
     */
    @ApiComment(" 删除脉象设置")
    @RequestMapping(value = "/deletePulse", method = RequestMethod.POST)
    @ResponseBody
    public Result deletePulse(
            @RequestParam("pulsecode") String pulsecode
    ) {
        if (pulseService.GetMainPulseByPulseCode(pulsecode).size() > 0) {
            return ResultFactory.create("1", pulsecode + "  主症中用到了此脉象,不能删除！", null);
        }
        int flag = pulseService.deletePulse(pulsecode);
        if (flag > 0) {
            return ResultFactory.create("0", "删除成功", null);
        }
        return ResultFactory.create("1", "删除失败", null);
    }

}
