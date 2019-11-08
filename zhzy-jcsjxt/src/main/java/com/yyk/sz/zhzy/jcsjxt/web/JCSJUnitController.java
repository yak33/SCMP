package com.yyk.sz.zhzy.jcsjxt.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJUnit;
import com.yyk.sz.zhzy.jcsjxt.service.JCSJUnitService;
import com.yyk.sz.zhzy.jcsjxt.utils.UtilString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 基础数据-单位设置 Controller
 */
@Api2Doc(id = "jcsjxt.dwsz", name = "基础数据-单位设置")
@ApiComment(seeClass = JCSJUnit.class)
@RestController
@RequestMapping(value = "/jcsjxt/dwsz/")
public class JCSJUnitController {

    @Autowired
    private JCSJUnitService unitService;

    /**
     * 获取单位
     *
     * @return 单位列表
     */
    @ApiComment(" 获取单位- 默认值 计量单位 1007,处方单位 1133,单计量单位 1097")
    @RequestMapping(value = "/getUnitList", method = RequestMethod.POST)
    @ResponseBody
    public Result getUnitList(
            @RequestParam(value = "unitCode", required = false) String unitCode,
            @RequestParam(value = "unitName", required = false) String unitName,
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
        unitCode=UtilString.judgeNull(unitCode);
        if(unitCode!=null) {
            unitCode = "%" + unitCode + "%";
        }
        unitName=UtilString.judgeNull(unitName);
        if(unitName!=null) {
            unitName = "%" + unitName + "%";
        }
        Paging<JCSJUnit> jcsjUnits = unitService.getUnitList(unitCode,unitName,pageNumber, pageSize, searchText, sortName, sortOrder);
        if (jcsjUnits == null || jcsjUnits.getSize() == 0) {
            return ResultFactory.create("1", "没有单位数据", null);
        }
        return ResultFactory.create("0", null, jcsjUnits);
    }

    /**
     * 新增单位
     *
     * @return
     */
    @ApiComment(" 新增单位")
    @RequestMapping(value = "/insertUnit", method = RequestMethod.POST)
    @ResponseBody
    public Result insertUnit(
            @RequestBody JCSJUnit jcsjUnit
    ) {
        if (unitService.GetUnitByUnitCode(jcsjUnit).size() > 0)
        {
            return ResultFactory.create("1", "单位编码： " + jcsjUnit.getUnitcode() + " 已经存在，不能重复添加！", null);
        }
        if (unitService.GetUnitByUnitName(jcsjUnit.getUnitname()).size() > 0)
        {
            return ResultFactory.create("1", "单位名称： " + jcsjUnit.getUnitname() + " 已经存在，不能重复添加！", null);
        }
        int flag = unitService.insertUnit(jcsjUnit);
        if (flag > 0) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 修改单位
     *
     * @return
     */
    @ApiComment(" 修改单位 unitname2 新的")
    @RequestMapping(value = "/updateUnit", method = RequestMethod.POST)
    @ResponseBody
    public Result updateUnit(
            @RequestBody JCSJUnit jcsjUnit
    ) {
        if(!jcsjUnit.getUnitname().equals(jcsjUnit.getUnitname2())) {
            if (unitService.GetUnitByUnitName(jcsjUnit.getUnitname2()).size() > 0) {
                return ResultFactory.create("1", "单位名称： " + jcsjUnit.getUnitname2() + " 已经存在，不能重复添加！", null);
            }
        }
        int flag = unitService.updateUnit(jcsjUnit);
        if (flag > 0) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 删除单位
     *
     * @return
     */
    @ApiComment(" 删除单位")
    @RequestMapping(value = "/deleteUnit", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteUnit(
            @RequestParam("unitcode") Integer unitcode
    ) {
        if (unitService.GetDrugByUnitCode(unitcode).size() > 0)
        {
            return ResultFactory.create("1", "单位编码： " + unitcode+ " 在中药字典里正在用该单位信息不能删除！", null);
        }
        int flag = unitService.deleteUnit(unitcode);
        if (flag > 0) {
            return ResultFactory.create("0", "删除成功", null);
        }
        return ResultFactory.create("1", "删除失败", null);
    }

}
