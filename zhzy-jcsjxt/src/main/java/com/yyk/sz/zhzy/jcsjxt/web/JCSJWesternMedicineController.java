package com.yyk.sz.zhzy.jcsjxt.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJWesternMedicine;
import com.yyk.sz.zhzy.jcsjxt.service.JCSJWesternMedicineService;
import com.yyk.sz.zhzy.jcsjxt.utils.UtilString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 基础数据-西医病名设置 Controller
 */
@Api2Doc(id = "jcsjxt.xybmsz", name = "基础数据-西医病名设置")
@ApiComment(seeClass = JCSJWesternMedicine.class)
@RestController
@RequestMapping(value = "/jcsjxt/xybmsz/")
public class JCSJWesternMedicineController {

    @Autowired
    private JCSJWesternMedicineService westernMedicineService;

    /**
     * 获取西医病名
     *
     * @return 西医病名列表
     */
    @ApiComment(" 获取西医病名")
    @RequestMapping(value = "/getWesternMedicineTable", method = RequestMethod.POST)
    @ResponseBody
    public Result getWesternMedicineTable(
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
        Paging<JCSJWesternMedicine> westernMedicines = westernMedicineService.getWesternMedicineTable(pageNumber, pageSize, searchText, sortName, sortOrder);
        if (westernMedicines == null || westernMedicines.getSize() == 0) {
            return ResultFactory.create("1", "没有西医病名数据", null);
        }
        return ResultFactory.create("0", null, westernMedicines);
    }

    /**
     * 新增西医病名
     *
     * @return
     */
    @ApiComment(" 新增西医病名")
    @RequestMapping(value = "/insertWesternMedicine", method = RequestMethod.POST)
    @ResponseBody
    public Result insertWesternMedicine(
            @RequestBody JCSJWesternMedicine jcsjWesternMedicine
    ) {
        if (westernMedicineService.checkWesternMedicineExits(jcsjWesternMedicine.getWesternmedicinecode(), null).size() > 0) {
            return ResultFactory.create("1", "西医病名编码： " + jcsjWesternMedicine.getWesternmedicinecode() + " 已经存在，不能重复添加！", null);
        }
        if (westernMedicineService.checkWesternMedicineExits(null, jcsjWesternMedicine.getWesternmedicinename()).size() > 0) {
            return ResultFactory.create("1", "西医病名名称： " + jcsjWesternMedicine.getWesternmedicinename() + " 已经存在，不能重复添加！", null);
        }
        int flag = westernMedicineService.insertWesternMedicine(jcsjWesternMedicine);
        if (flag > 0) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 修改西医病名
     *
     * @return
     */
    @ApiComment(" 修改西医病名 westernmedicinename2 新的")
    @RequestMapping(value = "/updateWesternMedicine", method = RequestMethod.POST)
    @ResponseBody
    public Result updateWesternMedicine(
            @RequestBody JCSJWesternMedicine jcsjWesternMedicine
    ) {
        if (!jcsjWesternMedicine.getWesternmedicinename().equals(jcsjWesternMedicine.getWesternmedicinename2())) {
            if (westernMedicineService.checkWesternMedicineExits(null, jcsjWesternMedicine.getWesternmedicinename2()).size() > 0) {
                return ResultFactory.create("1", "西医病名名称： " + jcsjWesternMedicine.getWesternmedicinename2() + " 已经存在，不能修改！", null);
            }
        }
        int flag = westernMedicineService.updateWesternMedicine(jcsjWesternMedicine);
        if (flag > 0) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 删除西医病名
     *
     * @return
     */
    @ApiComment(" 删除西医病名")
    @RequestMapping(value = "/deleteWesternMedicine", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteWesternMedicine(
            @RequestParam("westernmedicinecode") String westernmedicinecode
    ) {
        //删除西医病名时判断在证型中是否用到
        if (westernMedicineService.GetMainSymptomInfoByWesternMedicineCode(westernmedicinecode).size() > 0) {
            return ResultFactory.create("1", westernmedicinecode + "  证型中用到了此西医病名,不能删除！", null);
        }
        int flag = westernMedicineService.deleteWesternMedicine(westernmedicinecode);
        if (flag > 0) {
            return ResultFactory.create("0", "删除成功", null);
        }
        return ResultFactory.create("1", "删除失败", null);
    }

}
