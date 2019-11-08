package com.yyk.sz.zhzy.jcsjxt.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJPrescriptionClassify;
import com.yyk.sz.zhzy.jcsjxt.service.JCSJPrescriptionClassifyService;
import com.yyk.sz.zhzy.jcsjxt.utils.UtilString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 基础数据-处方分类 Controller
 */
@Api2Doc(id = "jcsjxt.cffl", name = "基础数据-处方分类")
@ApiComment(seeClass = JCSJPrescriptionClassify.class)
@RestController
@RequestMapping(value = "/jcsjxt/cffl/")
public class JCSJPrescriptionClassifyController {

    @Autowired
    private JCSJPrescriptionClassifyService prescriptionClassifyService;

    /**
     * 获取处方分类
     *
     * @return 处方分类列表
     */
    @ApiComment(" 获取处方分类")
    @RequestMapping(value = "/getPrescriptionClassifyTable", method = RequestMethod.POST)
    @ResponseBody
    public Result getPrescriptionClassifyTable(
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
        Paging<JCSJPrescriptionClassify> pulses = prescriptionClassifyService.getPrescriptionClassifyTable(pageNumber, pageSize, searchText, sortName, sortOrder);
        if (pulses == null || pulses.getSize() == 0) {
            return ResultFactory.create("1", "没有处方分类数据", null);
        }
        return ResultFactory.create("0", null, pulses);
    }

    /**
     * 新增处方分类
     *
     * @return
     */
    @ApiComment(" 新增处方分类")
    @RequestMapping(value = "/insertPrescriptionClassify", method = RequestMethod.POST)
    @ResponseBody
    public Result insertPrescriptionClassify(
            @RequestBody JCSJPrescriptionClassify jcsjPrescriptionClassify
    ) {
        if (prescriptionClassifyService.checkPrescriptionClassifyExits(jcsjPrescriptionClassify.getPccode(), null).size() > 0) {
            return ResultFactory.create("1", "处方分类编码： " + jcsjPrescriptionClassify.getPccode() + " 已经存在，不能重复添加！", null);
        }
        if (prescriptionClassifyService.checkPrescriptionClassifyExits(null, jcsjPrescriptionClassify.getPcname()).size() > 0) {
            return ResultFactory.create("1", "处方分类名称： " + jcsjPrescriptionClassify.getPcname() + " 已经存在，不能重复添加！", null);
        }
        int flag = prescriptionClassifyService.insertPrescriptionClassify(jcsjPrescriptionClassify);
        if (flag > 0) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 修改处方分类
     *
     * @return
     */
    @ApiComment(" 修改处方分类 pcname2 新的")
    @RequestMapping(value = "/updatePrescriptionClassify", method = RequestMethod.POST)
    @ResponseBody
    public Result updatePrescriptionClassify(
            @RequestBody JCSJPrescriptionClassify jcsjPrescriptionClassify
    ) {
        if (!jcsjPrescriptionClassify.getPcname().equals(jcsjPrescriptionClassify.getPcname2())) {
            if (prescriptionClassifyService.checkPrescriptionClassifyExits(null, jcsjPrescriptionClassify.getPcname2()).size() > 0) {
                return ResultFactory.create("1", "处方分类名称： " + jcsjPrescriptionClassify.getPcname2() + " 已经存在，不能修改！", null);
            }
        }
        int flag = prescriptionClassifyService.updatePrescriptionClassify(jcsjPrescriptionClassify);
        if (flag > 0) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 删除处方分类
     *
     * @return
     */
    @ApiComment(" 删除处方分类")
    @RequestMapping(value = "/deletePrescriptionClassify", method = RequestMethod.POST)
    @ResponseBody
    public Result deletePrescriptionClassify(
            @RequestParam("pccode") String pccode
    ) {
        if (prescriptionClassifyService.GetPrescriptionByPCCode(pccode).size() > 0) {
            return ResultFactory.create("1", pccode + "  该处方分类下包含处方信息,不能删除！", null);
        }
        int flag = prescriptionClassifyService.deletePrescriptionClassify(pccode);
        if (flag > 0) {
            return ResultFactory.create("0", "删除成功", null);
        }
        return ResultFactory.create("1", "删除失败", null);
    }

}
