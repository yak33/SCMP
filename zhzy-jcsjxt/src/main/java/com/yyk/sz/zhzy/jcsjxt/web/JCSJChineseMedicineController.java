package com.yyk.sz.zhzy.jcsjxt.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJChineseMedicine;
import com.yyk.sz.zhzy.jcsjxt.service.JCSJChineseMedicineService;
import com.yyk.sz.zhzy.jcsjxt.utils.UtilString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 基础数据-中医病名设置 Controller
 */
@Api2Doc(id = "jcsjxt.zybmsz", name = "基础数据-中医病名设置")
@ApiComment(seeClass = JCSJChineseMedicine.class)
@RestController
@RequestMapping(value = "/jcsjxt/zybmsz/")
public class JCSJChineseMedicineController {

    @Autowired
    private JCSJChineseMedicineService chineseMedicineService;

    /**
     * 获取中医病名
     *
     * @return 中医病名列表
     */
    @ApiComment(" 获取中医病名")
    @RequestMapping(value = "/getChineseMedicineTable", method = RequestMethod.POST)
    @ResponseBody
    public Result getChineseMedicineTable(
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
        Paging<JCSJChineseMedicine> chineseMedicines = chineseMedicineService.getChineseMedicineTable(pageNumber, pageSize, searchText, sortName, sortOrder);
        if (chineseMedicines == null || chineseMedicines.getSize() == 0) {
            return ResultFactory.create("1", "没有中医病名数据", null);
        }
        return ResultFactory.create("0", null, chineseMedicines);
    }

    /**
     * 新增中医病名
     *
     * @return
     */
    @ApiComment(" 新增中医病名")
    @RequestMapping(value = "/insertChineseMedicine", method = RequestMethod.POST)
    @ResponseBody
    public Result insertChineseMedicine(
            @RequestBody JCSJChineseMedicine jcsjChineseMedicine
    ) {
        if (chineseMedicineService.checkChineseMedicineExits(jcsjChineseMedicine.getChinesemedicinecode(), null).size() > 0) {
            return ResultFactory.create("1", "中医病名编码： " + jcsjChineseMedicine.getChinesemedicinecode() + " 已经存在，不能重复添加！", null);
        }
        if (chineseMedicineService.checkChineseMedicineExits(null, jcsjChineseMedicine.getChinesemedicinename()).size() > 0) {
            return ResultFactory.create("1", "中医病名名称： " + jcsjChineseMedicine.getChinesemedicinename() + " 已经存在，不能重复添加！", null);
        }
        int flag = chineseMedicineService.insertChineseMedicine(jcsjChineseMedicine);
        if (flag > 0) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 修改中医病名
     *
     * @return
     */
    @ApiComment(" 修改中医病名 chinesemedicinename2 新的")
    @RequestMapping(value = "/updateChineseMedicine", method = RequestMethod.POST)
    @ResponseBody
    public Result updateChineseMedicine(
            @RequestBody JCSJChineseMedicine jcsjChineseMedicine
    ) {
        if (!jcsjChineseMedicine.getChinesemedicinename().equals(jcsjChineseMedicine.getChinesemedicinename2())) {
            if (chineseMedicineService.checkChineseMedicineExits(null, jcsjChineseMedicine.getChinesemedicinename2()).size() > 0) {
                return ResultFactory.create("1", "中医病名名称： " + jcsjChineseMedicine.getChinesemedicinename2() + " 已经存在，不能修改！", null);
            }
        }
        int flag = chineseMedicineService.updateChineseMedicine(jcsjChineseMedicine);
        if (flag > 0) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 删除中医病名
     *
     * @return
     */
    @ApiComment(" 删除中医病名")
    @RequestMapping(value = "/deleteChineseMedicine", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteChineseMedicine(
            @RequestParam("chinesemedicinecode") String chinesemedicinecode
    ) {
        if (chineseMedicineService.GetMainSymptomInfoByChineseMedicineCode(chinesemedicinecode).size() > 0) {
            return ResultFactory.create("1", chinesemedicinecode + "  主症中用到了此中医病名,不能删除！", null);
        }
        if (chineseMedicineService.GetPrescriptionByChineseMedicineCode(chinesemedicinecode).size() > 0) {
            return ResultFactory.create("1", chinesemedicinecode + "  此中医病名有对应的处方信息,不能删除！", null);
        }
        int flag = chineseMedicineService.deleteChineseMedicine(chinesemedicinecode);
        if (flag > 0) {
            return ResultFactory.create("0", "删除成功", null);
        }
        return ResultFactory.create("1", "删除失败", null);
    }

}
