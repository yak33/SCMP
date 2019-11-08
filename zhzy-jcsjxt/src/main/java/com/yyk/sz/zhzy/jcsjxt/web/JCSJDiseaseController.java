package com.yyk.sz.zhzy.jcsjxt.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.common.util.UtilDES;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJDisease;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJMainSymptomType;
import com.yyk.sz.zhzy.jcsjxt.service.JCSJDiseaseService;
import com.yyk.sz.zhzy.jcsjxt.service.JCSJMainSymptomTypeService;
import com.yyk.sz.zhzy.jcsjxt.utils.UtilString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 基础数据-兼症设置 Controller
 */
@Api2Doc(id = "jcsjxt.jzsz", name = "基础数据-兼症设置")
@ApiComment(seeClass = JCSJDisease.class)
@RestController
@RequestMapping(value = "/jcsjxt/jzsz/")
public class JCSJDiseaseController {

    @Autowired
    private JCSJDiseaseService diseaseService;

    /**
     * 获取兼症设置
     *
     * @return 兼症设置列表
     */
    @ApiComment(" 获取兼症设置")
    @RequestMapping(value = "/getDiseaseTable", method = RequestMethod.POST)
    @ResponseBody
    public Result getDiseaseTable(
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
        Paging<JCSJDisease> jcsjDiseases = diseaseService.getDiseaseTable(pageNumber, pageSize, searchText, sortName, sortOrder);
        if (jcsjDiseases == null || jcsjDiseases.getSize() == 0) {
            return ResultFactory.create("1", "没有兼症设置数据", null);
        }
        //DES解密
        List<JCSJDisease> content = jcsjDiseases.getContent();
        for (JCSJDisease doc : content) {
            doc.setDiseasename(UtilDES.Decrypt(doc.getDiseasename()));
        }
        return ResultFactory.create("0", null, jcsjDiseases);
    }

    /**
     * 新增兼症设置
     *
     * @return
     */
    @ApiComment(" 新增兼症设置")
    @RequestMapping(value = "/insertDisease", method = RequestMethod.POST)
    @ResponseBody
    public Result insertDisease(
            @RequestBody JCSJDisease jcsjDisease
    ) {
        if (diseaseService.checkDiseaseExits(jcsjDisease.getDiseasecode(), null).size() > 0) {
            return ResultFactory.create("1", "兼症编码： " + jcsjDisease.getDiseasecode() + " 已经存在，不能重复添加！", null);
        }
        if (diseaseService.checkDiseaseExits(null, jcsjDisease.getDiseasename()).size() > 0) {
            return ResultFactory.create("1", "兼症名称： " + jcsjDisease.getDiseasename() + " 已经存在，不能重复添加！", null);
        }
        int flag = diseaseService.insertDisease(jcsjDisease);
        //清除原来数据
        String[] tables = {"Gy_DiseaseMeridian", "Gy_MainSymptomDisease"};
        for (String strtable : tables) {
            flag += diseaseService.deleteMeridianMainSymptom(strtable, jcsjDisease.getDiseasecode());
        }
        //兼症与归经
        String[] meridianCode = null;
        if (jcsjDisease.getDiseasemeridian() != null) {
            meridianCode = jcsjDisease.getDiseasemeridian().split(",");
        }
        if (meridianCode != null) {
            for (int i = 0; i < meridianCode.length; i++) {
                flag += diseaseService.insertMeridianMainSymptom("Gy_DiseaseMeridian", jcsjDisease.getDiseasecode(), "MeridianCode", meridianCode[i]);
            }
        }
        //兼症与主症
        String[] symptomCode = null;
        if (jcsjDisease.getDiseasemainsymptom() != null) {
            symptomCode = jcsjDisease.getDiseasemainsymptom().split(",");
        }
        if (symptomCode != null) {
            for (int i = 0; i < symptomCode.length; i++) {
                flag += diseaseService.insertMeridianMainSymptom("Gy_MainSymptomDisease", jcsjDisease.getDiseasecode(), "MainSymptomCode", symptomCode[i]);
            }
        }
        if (flag > 0) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 修改兼症设置
     *
     * @return
     */
    @ApiComment(" 修改兼症设置 diseasename2 新的")
    @RequestMapping(value = "/updateDisease", method = RequestMethod.POST)
    @ResponseBody
    public Result updateDisease(
            @RequestBody JCSJDisease jcsjDisease
    ) {
        int flag = 0;
        if (!jcsjDisease.getDiseasename().equals(jcsjDisease.getDiseasename2())) {
            if (diseaseService.checkDiseaseExits(null, jcsjDisease.getDiseasename2()).size() > 0) {
                return ResultFactory.create("1", "兼症名称： " + jcsjDisease.getDiseasename2() + " 已经存在，不能重复添加！", null);
            }
        }
        flag = diseaseService.updateDisease(jcsjDisease);
        //清除原来数据
        String[] tables = {"Gy_DiseaseMeridian", "Gy_MainSymptomDisease"};
        for (String strtable : tables) {
            flag += diseaseService.deleteMeridianMainSymptom(strtable, jcsjDisease.getDiseasecode());
        }
        //兼症与归经
        String[] meridianCode = null;
        if (jcsjDisease.getDiseasemeridian() != null) {
            meridianCode = jcsjDisease.getDiseasemeridian().split(",");
        }
        if (meridianCode != null) {
            for (int i = 0; i < meridianCode.length; i++) {
                flag += diseaseService.insertMeridianMainSymptom("Gy_DiseaseMeridian", jcsjDisease.getDiseasecode(), "MeridianCode", meridianCode[i]);
            }
        }
        //兼症与主症
        String[] symptomCode = null;
        if (jcsjDisease.getDiseasemainsymptom() != null) {
            symptomCode = jcsjDisease.getDiseasemainsymptom().split(",");
        }
        if (symptomCode != null) {
            for (int i = 0; i < symptomCode.length; i++) {
                flag += diseaseService.insertMeridianMainSymptom("Gy_MainSymptomDisease", jcsjDisease.getDiseasecode(), "MainSymptomCode", symptomCode[i]);
            }
        }
        if (flag > 0) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 删除兼症设置
     *
     * @return
     */
    @ApiComment(" 删除兼症设置")
    @RequestMapping(value = "/deleteDisease", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteDisease(
            @RequestParam("diseaseCode") String diseaseCode
    ) {
        //判断主症中是否用到此兼症
        if (diseaseService.GetDiseaseMainSymptomRelation(diseaseCode).size() > 0) {
            return ResultFactory.create("1", diseaseCode + " 主症中用到了该兼症，不能删除！", null);
        }
        //判断证型中是否用到此兼症
        if (diseaseService.GetDiseaseDialecticalRelation(diseaseCode).size() > 0) {
            return ResultFactory.create("1", diseaseCode + " 证型中用到了该兼症，不能删除！", null);
        }
        int flag = 0;
        String[] tables = {"Gy_DiseaseMeridian", "Gy_MainSymptomDisease", "Gy_Disease"};
        for (String strtable : tables) {
            flag += diseaseService.deleteMeridianMainSymptom(strtable, diseaseCode);
        }
        if (flag > 0) {
            return ResultFactory.create("0", "删除成功", null);
        }
        return ResultFactory.create("1", "删除失败", null);
    }

}
