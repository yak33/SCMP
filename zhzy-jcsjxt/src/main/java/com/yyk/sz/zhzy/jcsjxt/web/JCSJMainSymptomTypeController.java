package com.yyk.sz.zhzy.jcsjxt.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJMainSymptomType;
import com.yyk.sz.zhzy.jcsjxt.service.JCSJMainSymptomTypeService;
import com.yyk.sz.zhzy.jcsjxt.utils.UtilString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 基础数据-主症分类 Controller
 */
@Api2Doc(id = "jcsjxt.zzfl", name = "基础数据-主症分类")
@ApiComment(seeClass = JCSJMainSymptomType.class)
@RestController
@RequestMapping(value = "/jcsjxt/zzfl/")
public class JCSJMainSymptomTypeController {

    @Autowired
    private JCSJMainSymptomTypeService mainSymptomTypeService;

    /**
     * 获取主症分类
     *
     * @return 主症分类列表
     */
    @ApiComment(" 获取主症分类")
    @RequestMapping(value = "/getMainSymptomTypeTable", method = RequestMethod.POST)
    @ResponseBody
    public Result getMainSymptomTypeTable(
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
        Paging<JCSJMainSymptomType> jcsjMainSymptomTypes = mainSymptomTypeService.getMainSymptomTypeTable(pageNumber, pageSize, searchText, sortName, sortOrder);
        if (jcsjMainSymptomTypes == null || jcsjMainSymptomTypes.getSize() == 0) {
            return ResultFactory.create("1", "没有主症分类数据", null);
        }
        return ResultFactory.create("0", null, jcsjMainSymptomTypes);
    }

    /**
     * 新增主症分类
     *
     * @return
     */
    @ApiComment(" 新增主症分类")
    @RequestMapping(value = "/insertMainSymptomType", method = RequestMethod.POST)
    @ResponseBody
    public Result insertMainSymptomType(
            @RequestBody JCSJMainSymptomType jcsjMainSymptomType
    ) {
        if (mainSymptomTypeService.checkMainSymptomTypeExits(jcsjMainSymptomType.getMainsymptomtypecode(),null).size() > 0)
        {
            return ResultFactory.create("1", "主症分类编码： " + jcsjMainSymptomType.getMainsymptomtypecode() + " 已经存在，不能重复添加！", null);
        }
        if (mainSymptomTypeService.checkMainSymptomTypeExits(null,jcsjMainSymptomType.getMainsymptomtypename()).size() > 0)
        {
            return ResultFactory.create("1", "主症分类名称： " + jcsjMainSymptomType.getMainsymptomtypename() + " 已经存在，不能重复添加！", null);
        }
        int flag = mainSymptomTypeService.insertMainSymptomType(jcsjMainSymptomType);
        if (flag > 0) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 修改主症分类
     *
     * @return
     */
    @ApiComment(" 修改主症分类 mainsymptomtypename2 新的")
    @RequestMapping(value = "/updateMainSymptomType", method = RequestMethod.POST)
    @ResponseBody
    public Result updateMainSymptomType(
            @RequestBody JCSJMainSymptomType jcsjMainSymptomType
    ) {
        int flag = 0;
        if (!jcsjMainSymptomType.getMainsymptomtypename().equals(jcsjMainSymptomType.getMainsymptomtypename2())) {
            if (mainSymptomTypeService.checkMainSymptomTypeExits(null, jcsjMainSymptomType.getMainsymptomtypename2()).size() > 0) {
                return ResultFactory.create("1", "主症分类名称： " + jcsjMainSymptomType.getMainsymptomtypename2() + " 已经存在，不能修改！", null);
            }
        }
        flag = mainSymptomTypeService.updateMainSymptomType(jcsjMainSymptomType);
        if (flag > 0) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 删除主症分类
     *
     * @return
     */
    @ApiComment(" 删除主症分类")
    @RequestMapping(value = "/deleteMainSymptomType", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteMainSymptomType(
            @RequestParam("mainsymptomtypecode") String mainsymptomtypecode
    ) {
        if (mainSymptomTypeService.GetMainSymptomByMainSymptomTypeCode(mainsymptomtypecode).size() > 0)
        {
            return ResultFactory.create("1",  mainsymptomtypecode+ " 该主症分类下包含主症信息！不能删除！", null);
        }
        int flag = mainSymptomTypeService.deleteMainSymptomType(mainsymptomtypecode);
        if (flag > 0) {
            return ResultFactory.create("0", "删除成功", null);
        }
        return ResultFactory.create("1", "删除失败", null);
    }

}
