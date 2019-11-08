package com.yyk.sz.zhzy.jcsjxt.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJSummaryItem;
import com.yyk.sz.zhzy.jcsjxt.service.JCSJSummaryItemService;
import com.yyk.sz.zhzy.jcsjxt.utils.UtilString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 基础数据-汇总项目 Controller
 */
@Api2Doc(id = "jcsjxt.hzxm", name = "基础数据-汇总项目")
@ApiComment(seeClass = JCSJSummaryItem.class)
@RestController
@RequestMapping(value = "/jcsjxt/hzxm/")
public class JCSJSummaryItemController {

    @Autowired
    private JCSJSummaryItemService jcsjSummaryItemService;

    /**
     * 获取汇总项目
     *
     * @return 汇总项目列表
     */
    @ApiComment(" 获取汇总项目")
    @RequestMapping(value = "/getSummaryItem", method = RequestMethod.POST)
    @ResponseBody
    public Result getSummaryItem(
            @RequestParam(value = "summarycode", required = false) String summarycode,
            @RequestParam(value = "summaryname", required = false) String summaryname,
            @RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
            @RequestParam(value = "searchText", required = false) String searchText,
            @RequestParam(value = "sortName", required = false) String sortName,
            @RequestParam(value = "sortOrder", required = false, defaultValue = "desc") String sortOrder
    ) {
        searchText=UtilString.judgeNull(searchText);
        if(searchText!=null) {
            searchText = "%" + searchText + "%";
        }
        summarycode=UtilString.judgeNull(summarycode);
        if(summarycode!=null) {
            summarycode = "%" + summarycode + "%";
        }
        summaryname=UtilString.judgeNull(summaryname);
        if(summaryname!=null) {
            summaryname = "%" + summaryname + "%";
        }
        Paging<JCSJSummaryItem> jcsjSummaryItems = jcsjSummaryItemService.getSummaryItem(summarycode,summaryname,pageNumber, pageSize, searchText, sortName, sortOrder);
        if (jcsjSummaryItems == null || jcsjSummaryItems.getSize() == 0) {
            return ResultFactory.create("1", "没有项目数据", null);
        }
        return ResultFactory.create("0", null, jcsjSummaryItems);
    }

    /**
     * 新增汇总项目
     *
     * @return
     */
    @ApiComment(" 新增汇总项目 detailitemflag: 0 检查,1检验")
    @RequestMapping(value = "/insertSummaryItem", method = RequestMethod.POST)
    @ResponseBody
    public Result insertSummaryItem(
            @RequestBody JCSJSummaryItem jcsjSummaryItem
    ) {
        if (jcsjSummaryItemService.checkSummaryItemExits(jcsjSummaryItem.getSummarycode(),null).size() > 0)
        {
            return ResultFactory.create("1", "汇总项目编码： " + jcsjSummaryItem.getSummarycode() + " 已经存在，不能重复添加！", null);
        }
        if (jcsjSummaryItemService.checkSummaryItemExits(null,jcsjSummaryItem.getSummaryname()).size() > 0)
        {
            return ResultFactory.create("1", "汇总项目名称： " + jcsjSummaryItem.getSummaryname() + " 已经存在，不能重复添加！", null);
        }
        int flag = jcsjSummaryItemService.insertSummaryItem(jcsjSummaryItem);
        if (flag > 0) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 修改汇总项目
     *
     * @return
     */
    @ApiComment(" 修改汇总项目 summaryname2 修改后的")
    @RequestMapping(value = "/updateSummaryItem", method = RequestMethod.POST)
    @ResponseBody
    public Result updateSummaryItem(
            @RequestBody JCSJSummaryItem jcsjSummaryItem
    ) {
        int flag = 0;
        if (!jcsjSummaryItem.getSummaryname().equals(jcsjSummaryItem.getSummaryname2())) {
            if (jcsjSummaryItemService.checkSummaryItemExits(null, jcsjSummaryItem.getSummaryname2()).size() > 0) {
                return ResultFactory.create("1", "汇总项目名称： " + jcsjSummaryItem.getSummaryname2() + " 已经存在，不能修改！", null);
            }
        }
        flag = jcsjSummaryItemService.updateSummaryItem(jcsjSummaryItem);
        if (flag > 0) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 删除汇总项目
     *
     * @return
     */
    @ApiComment(" 删除汇总项目")
    @RequestMapping(value = "/deleteSummaryItem", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteSummaryItem(
            @RequestParam("summarycode") String summarycode
    ) {
        if (jcsjSummaryItemService.checkSummaryItemIsUsed(summarycode).size() > 0)
        {
            return ResultFactory.create("1",  summarycode+ " 该汇总项目下含有明细项目！不能删除！", null);
        }
        int flag = jcsjSummaryItemService.deleteSummaryItem(summarycode);
        if (flag > 0) {
            return ResultFactory.create("0", "删除成功", null);
        }
        return ResultFactory.create("1", "删除失败", null);
    }

}
