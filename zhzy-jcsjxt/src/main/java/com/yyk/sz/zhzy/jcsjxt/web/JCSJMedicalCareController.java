package com.yyk.sz.zhzy.jcsjxt.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJMedicalCare;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJUnit;
import com.yyk.sz.zhzy.jcsjxt.service.JCSJMedicalCareService;
import com.yyk.sz.zhzy.jcsjxt.service.JCSJUnitService;
import com.yyk.sz.zhzy.jcsjxt.utils.UtilString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 基础数据-医疗项目 Controller
 */
@Api2Doc(id = "jcsjxt.ylxm", name = "基础数据-医疗项目")
@ApiComment(seeClass = JCSJMedicalCare.class)
@RestController
@RequestMapping(value = "/jcsjxt/ylxm/")
public class JCSJMedicalCareController {

    @Autowired
    private JCSJMedicalCareService jcsjMedicalCareService;

    /**
     * 获取医疗项目
     *
     * @return 医疗项目列表
     */
    @ApiComment("获取医疗项目")
    @RequestMapping(value = "/getMedicalCare", method = RequestMethod.POST)
    @ResponseBody
    public Result getMedicalCare(
            @RequestParam(value = "medicalCareCode", required = false) String medicalCareCode,
            @RequestParam(value = "medicalCareName", required = false) String medicalCareName,
            @RequestParam(value = "pinYinCode", required = false) String pinYinCode,
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
        medicalCareCode=UtilString.judgeNull(medicalCareCode);
        if(medicalCareCode!=null) {
            medicalCareCode = "%" + medicalCareCode + "%";
        }
        medicalCareName=UtilString.judgeNull(medicalCareName);
        if(medicalCareName!=null) {
            medicalCareName = "%" + medicalCareName + "%";
        }
        pinYinCode=UtilString.judgeNull(pinYinCode);
        if(pinYinCode!=null) {
            pinYinCode = "%" + pinYinCode + "%";
        }
        Paging<JCSJMedicalCare> jcsjUnits = jcsjMedicalCareService.getMedicalCare(medicalCareCode,medicalCareName,pinYinCode,pageNumber, pageSize, searchText, sortName, sortOrder);
        if (jcsjUnits == null || jcsjUnits.getSize() == 0) {
            return ResultFactory.create("1", "没有医疗项目数据", null);
        }
        return ResultFactory.create("0", null, jcsjUnits);
    }

    /**
     * 新增医疗项目
     *
     * @return
     */
    @ApiComment(" 新增医疗项目")
    @RequestMapping(value = "/insertMedicalCare", method = RequestMethod.POST)
    @ResponseBody
    public Result insertMedicalCare(
            @RequestBody JCSJMedicalCare jcsjMedicalCare
    ) {
        if (jcsjMedicalCareService.CheckMedicalExits(jcsjMedicalCare.getMedicalcarecode(),null).size() > 0)
        {
            return ResultFactory.create("1", "医疗项目编码： " + jcsjMedicalCare.getMedicalcarecode() + " 已经存在，不能重复添加！", null);
        }
        if (jcsjMedicalCareService.CheckMedicalExits(null,jcsjMedicalCare.getMedicalcarename()).size() > 0)
        {
            return ResultFactory.create("1", "医疗项目名称： " + jcsjMedicalCare.getMedicalcarename() + " 已经存在，不能重复添加！", null);
        }
        int flag = jcsjMedicalCareService.insertMedicalCare(jcsjMedicalCare);
        if (flag > 0) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 修改医疗项目
     *
     * @return
     */
    @ApiComment(" 修改医疗项目 medicalcarename2 新的")
    @RequestMapping(value = "/updateMedicalCare", method = RequestMethod.POST)
    @ResponseBody
    public Result updateMedicalCare(
            @RequestBody JCSJMedicalCare jcsjMedicalCare
    ) {
        if (!jcsjMedicalCare.getMedicalcarename().equals(jcsjMedicalCare.getMedicalcarename2())) {
            if (jcsjMedicalCareService.CheckMedicalExits(null, jcsjMedicalCare.getMedicalcarename2()).size() > 0) {
                return ResultFactory.create("1", "医疗项目名称： " + jcsjMedicalCare.getMedicalcarename2() + " 已经存在，不能修改！", null);
            }
        }
        int flag = jcsjMedicalCareService.updateMedicalCare(jcsjMedicalCare);
        if (flag > 0) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 删除医疗项目
     *
     * @return
     */
    @ApiComment(" 删除医疗项目")
    @RequestMapping(value = "/deleteMedicalCare", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteMedicalCare(
            @RequestParam("medicalCareCode") String medicalCareCode
    ) {
        int flag = jcsjMedicalCareService.deleteMedicalCare(medicalCareCode);
        if (flag > 0) {
            return ResultFactory.create("0", "删除成功", null);
        }
        return ResultFactory.create("1", "删除失败", null);
    }

}
