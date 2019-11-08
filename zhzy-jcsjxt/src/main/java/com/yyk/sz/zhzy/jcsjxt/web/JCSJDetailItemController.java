package com.yyk.sz.zhzy.jcsjxt.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJDetailItem;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJDetailItemSub;
import com.yyk.sz.zhzy.jcsjxt.service.JCSJDetailItemService;
import com.yyk.sz.zhzy.jcsjxt.utils.UtilString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 基础数据-明细项目 Controller
 */
@Api2Doc(id = "jcsjxt.mxxm", name = "基础数据-明细项目")
@ApiComment(seeClass = JCSJDetailItem.class)
@RestController
@RequestMapping(value = "/jcsjxt/mxxm/")
public class JCSJDetailItemController {

    @Autowired
    private JCSJDetailItemService jcsjDetailItemService;

    /**
     * 获取明细项目
     *
     * @return 明细项目列表
     */
    @ApiComment("获取明细项目")
    @RequestMapping(value = "/getDetailItem", method = RequestMethod.POST)
    @ResponseBody
    public Result getDetailItem(
            @RequestParam(value = "detailItemCode", required = false) String detailItemCode,
            @RequestParam(value = "detailItemName", required = false) String detailItemName,
            @RequestParam(value = "pinYinCode", required = false) String pinYinCode,
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
        detailItemCode = UtilString.judgeNull(detailItemCode);
        if (detailItemCode != null) {
            detailItemCode = "%" + detailItemCode + "%";
        }
        detailItemName = UtilString.judgeNull(detailItemName);
        if (detailItemName != null) {
            detailItemName = "%" + detailItemName + "%";
        }
        pinYinCode = UtilString.judgeNull(pinYinCode);
        if (pinYinCode != null) {
            pinYinCode = "%" + pinYinCode + "%";
        }
        Paging<JCSJDetailItem> jcsjUnits = jcsjDetailItemService.getDetailItem(detailItemCode, detailItemName, pinYinCode, pageNumber, pageSize, searchText, sortName, sortOrder);
        if (jcsjUnits == null || jcsjUnits.getSize() == 0) {
            return ResultFactory.create("1", "没有明细项目数据", null);
        }
        return ResultFactory.create("0", null, jcsjUnits);
    }

    /**
     * 新增明细项目
     *
     * @return
     */
    @ApiComment(" 新增明细项目")
    @RequestMapping(value = "/insertDetailItem", method = RequestMethod.POST)
    @ResponseBody
    public Result insertDetailItem(
            @RequestBody JCSJDetailItem jcsjDetailItem
    ) {
        if (jcsjDetailItemService.CheckDetailItemExits(jcsjDetailItem.getDetailitemcode(), null).size() > 0) {
            return ResultFactory.create("1", "明细项目编码： " + jcsjDetailItem.getDetailitemcode() + " 已经存在，不能重复添加！", null);
        }
        if (jcsjDetailItemService.CheckDetailItemExits(null, jcsjDetailItem.getDetailitemname()).size() > 0) {
            return ResultFactory.create("1", "明细项目名称： " + jcsjDetailItem.getDetailitemname() + " 已经存在，不能重复添加！", null);
        }
        int flag = jcsjDetailItemService.insertDetailItem(jcsjDetailItem);

        boolean suc = false;
        //保存明细
        jcsjDetailItemService.deleteDetailItemSub(jcsjDetailItem.getDetailitemcode());
        suc = true;
        if(jcsjDetailItem.getJCSJDetailItemSubs().size()>0) {
            for (JCSJDetailItemSub doc : jcsjDetailItem.getJCSJDetailItemSubs()) {
                jcsjDetailItemService.insertDetailItemSub(doc);
                suc = true;
            }
        }
        if (flag > 0 && suc) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 修改明细项目
     *
     * @return
     */
    @ApiComment(" 修改明细项目 medicalcarename2 新的")
    @RequestMapping(value = "/updateDetailItem", method = RequestMethod.POST)
    @ResponseBody
    public Result updateDetailItem(
            @RequestBody JCSJDetailItem jcsjDetailItem
    ) {
        if (!jcsjDetailItem.getDetailitemname().equals(jcsjDetailItem.getDetailitemname2())) {
            if (jcsjDetailItemService.CheckDetailItemExits(null, jcsjDetailItem.getDetailitemname2()).size() > 0) {
                return ResultFactory.create("1", "明细项目名称： " + jcsjDetailItem.getDetailitemname2() + " 已经存在，不能重复添加！", null);
            }
        }
        int flag = jcsjDetailItemService.updateDetailItem(jcsjDetailItem);
        boolean suc = false;
        //保存明细
        jcsjDetailItemService.deleteDetailItemSub(jcsjDetailItem.getDetailitemcode());
        suc = true;
        if(jcsjDetailItem.getJCSJDetailItemSubs().size()>0) {
            for (JCSJDetailItemSub doc : jcsjDetailItem.getJCSJDetailItemSubs()) {
                jcsjDetailItemService.insertDetailItemSub(doc);
                suc = true;
            }
        }
        if (flag > 0 && suc) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 删除明细项目
     *
     * @return
     */
    @ApiComment(" 删除明细项目")
    @RequestMapping(value = "/deleteDetailItem", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteDetailItem(
            @RequestParam("detailItemCode") String detailItemCode
    ) {
        jcsjDetailItemService.deleteDetailItemSub(detailItemCode);
        int flag = jcsjDetailItemService.deleteDetailItem(detailItemCode);
        if (flag > 0) {
            return ResultFactory.create("0", "删除成功", null);
        }
        return ResultFactory.create("1", "删除失败", null);
    }

    /**
     * 根据医疗明细项目编码获取明细项目与医疗项目的关系
     *
     * @return
     */
    @ApiComment(" 根据医疗明细项目编码获取明细项目与医疗项目的关系")
    @RequestMapping(value = "/getFromDetailItemSubByDetailItemCode", method = RequestMethod.POST)
    @ResponseBody
    public Result getFromDetailItemSubByDetailItemCode(
            @RequestParam("detailItemCode") String detailItemCode
    ) {
        List<JCSJDetailItemSub> jcsjDetailItemSubs= jcsjDetailItemService.getFromDetailItemSubByDetailItemCode(detailItemCode);
        if (jcsjDetailItemSubs == null || jcsjDetailItemSubs.size() == 0) {
            return ResultFactory.create("1", "没有医疗项目数据", null);
        }
        return ResultFactory.create("1", null, jcsjDetailItemSubs);
    }


}
