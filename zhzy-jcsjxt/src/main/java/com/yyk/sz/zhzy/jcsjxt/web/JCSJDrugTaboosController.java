package com.yyk.sz.zhzy.jcsjxt.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJDrugTaboos;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJPulse;
import com.yyk.sz.zhzy.jcsjxt.service.JCSJDrugTaboosService;
import com.yyk.sz.zhzy.jcsjxt.service.JCSJPulseService;
import com.yyk.sz.zhzy.jcsjxt.utils.UtilString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 基础数据-药品禁忌 Controller
 */
@Api2Doc(id = "jcsjxt.ypjj", name = "基础数据-药品禁忌")
@ApiComment(seeClass = JCSJDrugTaboos.class)
@RestController
@RequestMapping(value = "/jcsjxt/ypjj/")
public class JCSJDrugTaboosController {

    @Autowired
    private JCSJDrugTaboosService drugTaboosService;

    /**
     * 获取药品禁忌
     *
     * @return 药品禁忌列表
     */
    @ApiComment(" 获取药品禁忌")
    @RequestMapping(value = "/getDrugTaboosTable", method = RequestMethod.POST)
    @ResponseBody
    public Result getDrugTaboosTable(
            @RequestParam(value = "drugtaboostype", required = false) String drugtaboostype,
            @RequestParam(value = "drugname", required = false) String drugname,
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
        if (drugname != null) {
            drugname = "%" + drugname + "%";
        }
        Paging<JCSJDrugTaboos> drugTaboos = drugTaboosService.getDrugTaboosTable(drugtaboostype, drugname, pageNumber, pageSize, searchText, sortName, sortOrder);
        if (drugTaboos == null || drugTaboos.getSize() == 0) {
            return ResultFactory.create("1", "没有药品禁忌数据", null);
        }
        return ResultFactory.create("0", null, drugTaboos);
    }

    /**
     * 新增药品禁忌
     *
     * @return
     */
    @ApiComment(" 新增药品禁忌")
    @RequestMapping(value = "/insertDrugTaboos", method = RequestMethod.POST)
    @ResponseBody
    public Result insertDrugTaboos(
            @RequestBody JCSJDrugTaboos jcsjDrugTaboos
    ) {
        //反药畏药验证
        if ("10".equals(jcsjDrugTaboos.getDrugtaboostype()) || "20".equals(jcsjDrugTaboos.getDrugtaboostype())) {
            if (drugTaboosService.GetDrugAnti(jcsjDrugTaboos.getDrugtaboostype(), jcsjDrugTaboos.getDrugcode(), jcsjDrugTaboos.getDrugcodeone()).size() > 0) {
                return ResultFactory.create("1", " 已经存在 " + jcsjDrugTaboos.getDrugname() + " 和 " + jcsjDrugTaboos.getDrugnameone() + "互为反药的记录，不能重复！", null);
            }
        }
        //孕妇禁忌验证
        if ("30".equals(jcsjDrugTaboos.getDrugtaboostype())) {
            if (drugTaboosService.GetDrugSM(jcsjDrugTaboos.getDrugtaboostype(), jcsjDrugTaboos.getDrugcode()).size() > 0) {
                return ResultFactory.create("1", "已经存在" + jcsjDrugTaboos.getDrugname() + " 的孕妇禁忌说明，不能重复添加！", null);
            }
        }
        //药量禁忌验证
        if ("40".equals(jcsjDrugTaboos.getDrugtaboostype())) {
            if (drugTaboosService.GetDrugToaboosQuanitity(jcsjDrugTaboos.getDrugtaboostype(), jcsjDrugTaboos.getDrugcode()).size() > 0) {
                return ResultFactory.create("1", "已经存在" + jcsjDrugTaboos.getDrugname() + " 的药量禁忌说明，不能重复添加！", null);
            }
        }

        int flag = drugTaboosService.insertDrugTaboos(jcsjDrugTaboos);
        if (flag > 0) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 修改药品禁忌
     *
     * @return
     */
    @ApiComment(" 修改药品禁忌 根据DrugTaboosType，DrugCode修改")
    @RequestMapping(value = "/updateDrugTaboos", method = RequestMethod.POST)
    @ResponseBody
    public Result updateDrugTaboos(
            @RequestBody JCSJDrugTaboos jcsjDrugTaboos
    ) {
        int flag = drugTaboosService.updateDrugTaboos(jcsjDrugTaboos);
        if (flag > 0) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 删除药品禁忌
     *
     * @return
     */
    @ApiComment(" 删除药品禁忌")
    @RequestMapping(value = "/deleteDrugTaboos", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteDrugTaboos(
            @RequestParam("drugtaboostype") String drugtaboostype,
            @RequestParam("drugcode") String drugcode,
            @RequestParam("drugcodeone") String drugcodeone
    ) {
        int flag = drugTaboosService.deleteDrugTaboos(drugtaboostype, drugcode, drugcodeone);
        if (flag > 0) {
            return ResultFactory.create("0", "删除成功", null);
        }
        return ResultFactory.create("1", "删除失败", null);
    }

}
