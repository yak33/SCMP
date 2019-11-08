package com.yyk.sz.zhzy.jcsjxt.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJDiseasesClassify;
import com.yyk.sz.zhzy.jcsjxt.service.JCSJDiseasesClassifyService;
import com.yyk.sz.zhzy.jcsjxt.utils.UtilString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 基础数据-病种分类设置 Controller
 */
@Api2Doc(id = "jcsjxt.bzflsz", name = "基础数据-病种分类")
@ApiComment(seeClass = JCSJDiseasesClassify.class)
@RestController
@RequestMapping(value = "/jcsjxt/bzflsz/")
public class JCSJDiseasesClassifyController {

    @Autowired
    private JCSJDiseasesClassifyService diseasesClassifyService;

    /**
     * 获取病种分类
     *
     * @return 病种分类列表
     */
    @ApiComment(" 获取病种分类")
    @RequestMapping(value = "/getDiseasesClassifyTable", method = RequestMethod.POST)
    @ResponseBody
    public Result getDiseasesClassifyTable(
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
        Paging<JCSJDiseasesClassify> pulses = diseasesClassifyService.getDiseasesClassifyTable(pageNumber, pageSize, searchText, sortName, sortOrder);
        if (pulses == null || pulses.getSize() == 0) {
            return ResultFactory.create("1", "没有病种分类数据", null);
        }
        return ResultFactory.create("0", null, pulses);
    }

    /**
     * 新增病种分类
     *
     * @return
     */
    @ApiComment(" 新增病种分类 chinesemedicineCode中医病名编码，逗号隔开")
    @RequestMapping(value = "/insertDiseasesClassify", method = RequestMethod.POST)
    @ResponseBody
    public Result insertDiseasesClassify(
            @RequestBody JCSJDiseasesClassify jcsjDiseasesClassify
    ) {
        if (diseasesClassifyService.checkDiseasesClassifyExits(jcsjDiseasesClassify.getDccode(), null).size() > 0) {
            return ResultFactory.create("1", "病种分类编码： " + jcsjDiseasesClassify.getDccode() + " 已经存在，不能重复添加！", null);
        }
        if (diseasesClassifyService.checkDiseasesClassifyExits(null, jcsjDiseasesClassify.getDcname()).size() > 0) {
            return ResultFactory.create("1", "病种分类名称： " + jcsjDiseasesClassify.getDcname() + " 已经存在，不能重复添加！", null);
        }
        int flag = diseasesClassifyService.insertDiseasesClassify(jcsjDiseasesClassify);
        //保存病种分类和中医病名的关系
        String[] chinesemedicineCode = null;
        if (jcsjDiseasesClassify.getChinesemedicinecode() != null) {
            chinesemedicineCode = jcsjDiseasesClassify.getChinesemedicinecode().split(",");
        }
        if (chinesemedicineCode != null) {
            for (int i = 0; i < chinesemedicineCode.length; i++) {
                flag += diseasesClassifyService.insertDiseasesClassifyCMedicine(jcsjDiseasesClassify.getDccode(), chinesemedicineCode[i]);
            }
        }
        if (flag > 0) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 修改病种分类
     *
     * @return
     */
    @ApiComment(" 修改病种分类 dcname2 新的")
    @RequestMapping(value = "/updateDiseasesClassify", method = RequestMethod.POST)
    @ResponseBody
    public Result updateDiseasesClassify(
            @RequestBody JCSJDiseasesClassify jcsjDiseasesClassify
    ) {
        if (!jcsjDiseasesClassify.getDcname().equals(jcsjDiseasesClassify.getDcname2())) {
            if (diseasesClassifyService.checkDiseasesClassifyExits(null, jcsjDiseasesClassify.getDcname2()).size() > 0) {
                return ResultFactory.create("1", "病种分类名称： " + jcsjDiseasesClassify.getDcname2() + " 已经存在，不能修改！", null);
            }
        }
        int flag = diseasesClassifyService.updateDiseasesClassify(jcsjDiseasesClassify);
        //删除病种分类和中医病名的关系
        flag += diseasesClassifyService.deleteDiseasesClassifyCMedicine(jcsjDiseasesClassify.getDccode());
        //保存病种分类和中医病名的关系
        String[] chinesemedicineCode = null;
        if (jcsjDiseasesClassify.getChinesemedicinecode() != null) {
            chinesemedicineCode = jcsjDiseasesClassify.getChinesemedicinecode().split(",");
        }
        if (chinesemedicineCode != null) {
            for (int i = 0; i < chinesemedicineCode.length; i++) {
                flag += diseasesClassifyService.insertDiseasesClassifyCMedicine(jcsjDiseasesClassify.getDccode(), chinesemedicineCode[i]);
            }
        }
        if (flag > 0) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 删除病种分类
     *
     * @return
     */
    @ApiComment(" 删除病种分类")
    @RequestMapping(value = "/deleteDiseasesClassify", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteDiseasesClassify(
            @RequestParam("dccode") String dccode
    ) {
        if (diseasesClassifyService.GetDClassifyCMedicineByDCCode(dccode).size() > 0) {
            return ResultFactory.create("1", dccode + "  该病种分类存在中医病名，不能删除！", null);
        }
        int flag = diseasesClassifyService.deleteDiseasesClassify(dccode);
        if (flag > 0) {
            return ResultFactory.create("0", "删除成功", null);
        }
        return ResultFactory.create("1", "删除失败", null);
    }

    /**
     * 根据病种分类编码获取病种分类与中医病名的关系信息
     *
     * @return
     */
    @ApiComment(" 根据病种分类编码获取病种分类与中医病名的关系信息")
    @RequestMapping(value = "/getChineseMedicineByDCCode", method = RequestMethod.POST)
    @ResponseBody
    public Result getChineseMedicineByDCCode(
            @RequestParam("dccode") String dccode
    ) {
        List<JCSJDiseasesClassify> diseasesClassifies = diseasesClassifyService.getChineseMedicineByDCCode(dccode);
        if (diseasesClassifies == null || diseasesClassifies.size() == 0) {
            return ResultFactory.create("1", "没有病种分类与中医病名的关系数据", null);
        }
        return ResultFactory.create("0", null, diseasesClassifies);
    }
}
