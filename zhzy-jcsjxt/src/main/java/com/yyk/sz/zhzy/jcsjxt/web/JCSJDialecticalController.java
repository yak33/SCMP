package com.yyk.sz.zhzy.jcsjxt.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJDialectical;
import com.yyk.sz.zhzy.jcsjxt.service.JCSJDialecticalService;
import com.yyk.sz.zhzy.jcsjxt.utils.UtilString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 基础数据-证型设置 Controller
 */
@Api2Doc(id = "jcsjxt.zxsz", name = "基础数据-证型设置")
@ApiComment(seeClass = JCSJDialectical.class)
@RestController
@RequestMapping(value = "/jcsjxt/zxsz/")
public class JCSJDialecticalController {

    @Autowired
    private JCSJDialecticalService dialecticalService;

    /**
     * 获取证型设置
     *
     * @return 证型设置列表
     */
    @ApiComment(" 获取证型设置")
    @RequestMapping(value = "/getDialecticalTable", method = RequestMethod.POST)
    @ResponseBody
    public Result getDialecticalTable(
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
        Paging<JCSJDialectical> dialecticalTables = dialecticalService.getDialecticalTable(pageNumber, pageSize, searchText, sortName, sortOrder);
        if (dialecticalTables == null || dialecticalTables.getSize() == 0) {
            return ResultFactory.create("1", "没有证型数据", null);
        }
        return ResultFactory.create("0", null, dialecticalTables);
    }

    /**
     * 新增证型设置
     *
     * @return
     */
    @ApiComment(" 新增证型设置")
    @RequestMapping(value = "/insertDialectical", method = RequestMethod.POST)
    @ResponseBody
    public Result insertDialectical(
            @RequestBody JCSJDialectical jcsjDialectical
    ) {
        if (dialecticalService.checkDialecticalExits(jcsjDialectical.getDialecticalcode(), null).size() > 0) {
            return ResultFactory.create("1", "证型编码： " + jcsjDialectical.getDialecticalcode() + " 已经存在，不能重复添加！", null);
        }
        if (dialecticalService.checkDialecticalExits(null, jcsjDialectical.getDialecticalname()).size() > 0) {
            return ResultFactory.create("1", "证型名称： " + jcsjDialectical.getDialecticalname() + " 已经存在，不能重复添加！", null);
        }
        int flag = dialecticalService.insertDialectical(jcsjDialectical);
        if (flag > 0) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 修改证型设置
     *
     * @return
     */
    @ApiComment(" 修改证型设置 dialecticalname2 新的")
    @RequestMapping(value = "/updateDialectical", method = RequestMethod.POST)
    @ResponseBody
    public Result updateDialectical(
            @RequestBody JCSJDialectical jcsjDialectical
    ) {
        if (!jcsjDialectical.getDialecticalname().equals(jcsjDialectical.getDialecticalname2())) {
            if (dialecticalService.checkDialecticalExits(null, jcsjDialectical.getDialecticalname2()).size() > 0) {
                return ResultFactory.create("1", "证型名称： " + jcsjDialectical.getDialecticalname2() + " 已经存在，不能修改！", null);
            }
        }
        int flag = dialecticalService.updateDialectical(jcsjDialectical);
        if (flag > 0) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 删除证型设置
     *
     * @return
     */
    @ApiComment(" 删除证型设置")
    @RequestMapping(value = "/deleteDialectical", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteDialectical(
            @RequestParam("dialecticalcode") String dialecticalcode
    ) {
        if (dialecticalService.GetMainSymptomInfoByDialecticalCode(dialecticalcode).size() > 0) {
            return ResultFactory.create("1", dialecticalcode + "  证型治法设置中用到了此证型，不能删除！", null);
        }
        int flag = dialecticalService.deleteDialectical(dialecticalcode);
        if (flag > 0) {
            return ResultFactory.create("0", "删除成功", null);
        }
        return ResultFactory.create("1", "删除失败", null);
    }

}
