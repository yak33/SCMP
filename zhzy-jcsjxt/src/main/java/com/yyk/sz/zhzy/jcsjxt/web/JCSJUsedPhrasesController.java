package com.yyk.sz.zhzy.jcsjxt.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJUsedPhrases;
import com.yyk.sz.zhzy.jcsjxt.service.JCSJUsedPhrasesService;
import com.yyk.sz.zhzy.jcsjxt.utils.UtilString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 基础数据-模版设置 Controller
 */
@Api2Doc(id = "jcsjxt.mbsz", name = "基础数据-模版设置")
@ApiComment(seeClass = JCSJUsedPhrases.class)
@RestController
@RequestMapping(value = "/jcsjxt/mbsz/")
public class JCSJUsedPhrasesController {

    @Autowired
    private JCSJUsedPhrasesService usedPhrasesService;

    /**
     * 获取模版
     *
     * @return 模版列表
     */
    @ApiComment(" 获取模版")
    @RequestMapping(value = "/getUsedPhrasesList", method = RequestMethod.POST)
    @ResponseBody
    public Result getUsedPhrasesList(
            @RequestParam(value = "usedPhrasesType", required = false) String usedPhrasesType,
            @RequestParam(value = "usedPhrasesName", required = false) String usedPhrasesName,
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
        usedPhrasesType = UtilString.judgeNull(usedPhrasesType);
        usedPhrasesName = UtilString.judgeNull(usedPhrasesName);
        if (usedPhrasesName != null) {
            usedPhrasesName = "%" + usedPhrasesName + "%";
        }
        Paging<JCSJUsedPhrases> jcsjUsedPhrases = usedPhrasesService.getUsedPhrasesList(usedPhrasesType, usedPhrasesName, pageNumber, pageSize, searchText, sortName, sortOrder);
        if (jcsjUsedPhrases == null || jcsjUsedPhrases.getSize() == 0) {
            return ResultFactory.create("1", "没有模版数据", null);
        }
        return ResultFactory.create("0", null, jcsjUsedPhrases);
    }

    /**
     * 新增模版
     *
     * @return
     */
    @ApiComment(" 新增模版")
    @RequestMapping(value = "/insertUsedPhrases", method = RequestMethod.POST)
    @ResponseBody
    public Result insertUsedPhrases(
            @RequestBody JCSJUsedPhrases jcsjUsedPhrases
    ) {
        if (usedPhrasesService.GetUsedPhrasesByTypeName(jcsjUsedPhrases.getUsedphrasestype().toString(), jcsjUsedPhrases.getUsedphrasesname()).size() > 0) {
            return ResultFactory.create("1", "模版信息： " + jcsjUsedPhrases.getUsedphrasestype().toString()+":"+jcsjUsedPhrases.getUsedphrasesname() + " 已经存在，不能重复添加！", null);
        }
        int flag = usedPhrasesService.insertUsedPhrases(jcsjUsedPhrases);
        if (flag > 0) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 修改模版
     *
     * @return
     */
    @ApiComment(" 修改模版 usedphrasestype2 新的  usedphrasesname2 新的")
    @RequestMapping(value = "/updateUsedPhrases", method = RequestMethod.POST)
    @ResponseBody
    public Result updateUsedPhrases(
            @RequestBody JCSJUsedPhrases jcsjUsedPhrases
    ) {
        if(!jcsjUsedPhrases.getUsedphrasestype().equals(jcsjUsedPhrases.getUsedphrasestype2())&&jcsjUsedPhrases.getUsedphrasesname().equals(jcsjUsedPhrases.getUsedphrasesname2())) {
            if (usedPhrasesService.GetUsedPhrasesByTypeName(jcsjUsedPhrases.getUsedphrasestype2().toString(), jcsjUsedPhrases.getUsedphrasesname2()).size() > 0) {
                return ResultFactory.create("1", "模版信息： " + jcsjUsedPhrases.getUsedphrasestype2().toString() + ":" + jcsjUsedPhrases.getUsedphrasesname2() + " 已经存在，不能修改！", null);
            }
        }
        int flag = usedPhrasesService.updateUsedPhrases(jcsjUsedPhrases);
        if (flag > 0) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 删除模版
     *
     * @return
     */
    @ApiComment(" 删除模版")
    @RequestMapping(value = "/deleteUsedPhrases", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteUsedPhrases(
            @RequestParam("usedphrasestype") String usedphrasestype, @RequestParam("usedphrasesname") String usedphrasesname
    ) {
        int flag = usedPhrasesService.deleteUsedPhrases(usedphrasestype, usedphrasesname);
        if (flag > 0) {
            return ResultFactory.create("0", "删除成功", null);
        }
        return ResultFactory.create("1", "删除失败", null);
    }

}
