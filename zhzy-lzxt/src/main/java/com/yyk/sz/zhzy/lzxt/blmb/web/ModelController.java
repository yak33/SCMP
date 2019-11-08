package com.yyk.sz.zhzy.lzxt.blmb.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.lzxt.blmb.entity.Model;
import com.yyk.sz.zhzy.lzxt.blmb.service.ModelService;
import com.yyk.sz.zhzy.lzxt.bzlz.entity.Disease;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 临症系统-模版选择
 */
@Api2Doc(id = "lzxt.blmb", name = "临症系统-模版选择")
@ApiComment(seeClass = Model.class)
@RestController
@RequestMapping(value = "/lzxt/blmb/")
public class ModelController {

    @Autowired
    private ModelService modelService;

    /**
     * 获取模版列表（usedPhrasesType：主诉 40，过敏史 20，既往史 30，现病史 10，体格检查 50，其他 60，医嘱 70）
     *
     * @param usedPhrasesType 模版类型
     * @param deptCode        科室编号
     * @return 模版列表
     */
    @ApiComment("获取模版列表（usedPhrasesType：主诉 40，过敏史 20，既往史 30，现病史 10，体格检查 50，其他 60，医嘱 70）")
    @RequestMapping(value = "/getModelTable", method = RequestMethod.POST)
    @ResponseBody
    public Result getModelTable(
            @RequestParam("usedPhrasesType") String usedPhrasesType,
            @RequestParam("deptCode") String deptCode,
            @RequestParam(value = "searchText", required = false,defaultValue = "") String searchText
    ) {
        List<Model> models = modelService.getModelTable(usedPhrasesType, deptCode,searchText);
        if (models == null || models.size() == 0) {
            return ResultFactory.create("1", "没有（科室：" + deptCode + "）(类型：" + usedPhrasesType + ")下的模版数据", null);
        }
        return ResultFactory.create("0", null, models);
    }

    /**
     * 增加模版
     *
     * @param model 模版对象
     * @return 添加成功
     */
    @ApiComment("增加模版")
    @RequestMapping(value = "/insertModel", method = RequestMethod.POST)
    @ResponseBody
    public Result insertModel(
            @RequestParam("model") Model model
    ) {
        //检查模板信息是否存在
        List<Model> models = modelService.selectModel(model);
        if (models == null || models.size() == 0) {
            //不存在，新增
            boolean issuc = modelService.insertModel(model);
            if (issuc) {
                return ResultFactory.create("1", "添加成功", null);
            } else {
                return ResultFactory.create("0", "添加失败", null);
            }
        } else {
            return ResultFactory.create("1", "该模板信息已经存在，不能重复！", null);
        }
    }

    /**
     * 修改模版
     *
     * @param model 修改后的模版对象
     * @return 修改成功
     */
    @ApiComment("修改模版")
    @RequestMapping(value = "/updateModel", method = RequestMethod.POST)
    @ResponseBody
    public Result updateModel(
            @RequestParam("model") Model model
    ) {
        boolean issuc = modelService.updateModel(model);
        if (issuc) {
            return ResultFactory.create("1", "修改成功", null);
        } else {
            return ResultFactory.create("0", "修改失败", null);
        }
    }

    /**
     * 删除模版
     *
     * @param model 删除的模版对象
     * @return 删除成功
     */
    @ApiComment("删除模版")
    @RequestMapping(value = "/deleteModel", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteModel(
            @RequestParam("model") Model model
    ) {
        boolean issuc = modelService.deleteModel(model);
        if (issuc) {
            return ResultFactory.create("1", "删除成功", null);
        } else {
            return ResultFactory.create("0", "删除失败", null);
        }
    }

    /**
     * 查找模版
     *
     * @param model 查找的模版对象
     * @return 是否存在
     */
    @ApiComment("查找模版")
    @RequestMapping(value = "/selectModel", method = RequestMethod.POST)
    @ResponseBody
    public Result selectModel(
            @RequestParam("model") Model model
    ) {
        List<Model> models = modelService.selectModel(model);
        if (models == null || models.size() == 0) {
            return ResultFactory.create("0", "模版不存在", null);
        } else {
            return ResultFactory.create("1", "查找成功", null);
        }
    }
}
