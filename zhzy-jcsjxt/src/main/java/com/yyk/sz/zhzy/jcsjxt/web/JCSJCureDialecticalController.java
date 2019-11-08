package com.yyk.sz.zhzy.jcsjxt.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.common.util.UtilDES;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJCureDialectical;
import com.yyk.sz.zhzy.jcsjxt.service.JCSJCureDialecticalService;
import com.yyk.sz.zhzy.jcsjxt.utils.UtilString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 基础数据-证型治法设置 Controller
 */
@Api2Doc(id = "jcsjxt.zxzfsz", name = "基础数据-证型治法设置")
@ApiComment(seeClass = JCSJCureDialectical.class)
@RestController
@RequestMapping(value = "/jcsjxt/zxzfsz/")
public class JCSJCureDialecticalController {

    @Autowired
    private JCSJCureDialecticalService dialecticalService;

    /**
     * 获取证型治法设置
     *
     * @return 证型治法设置列表
     */
    @ApiComment(" 获取证型治法设置")
    @RequestMapping(value = "/GetCureDialecticalTable", method = RequestMethod.POST)
    @ResponseBody
    public Result GetCureDialecticalTable(
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
        Paging<JCSJCureDialectical> dialecticals = dialecticalService.GetCureDialecticalTable(pageNumber, pageSize, searchText, sortName, sortOrder);
        if (dialecticals == null || dialecticals.getSize() == 0) {
            return ResultFactory.create("1", "没有证型治法设置数据", null);
        }
        //DES解密
        List<JCSJCureDialectical> content = dialecticals.getContent();
        for (JCSJCureDialectical doc : content) {
            doc.setMainsymptomname(UtilDES.Decrypt(doc.getMainsymptomname()));
        }
        return ResultFactory.create("0", null, dialecticals);
    }

    /**
     * 新增证型治法设置
     *
     * @return
     */
    @ApiComment(" 新增证型治法设置")
    @RequestMapping(value = "/insertCureDialectical", method = RequestMethod.POST)
    @ResponseBody
    public Result insertCureDialectical(
            @RequestBody JCSJCureDialectical jcsjCureDialectical
    ) {
        if (dialecticalService.CheckSingleInfo(jcsjCureDialectical.getDialecticalcode(), jcsjCureDialectical.getMainsymptomcode()).size() > 0) {
            return ResultFactory.create("1", "此证型、主症编码已经存在,不能重复添加！", null);
        }
        int flag = dialecticalService.insertDialecticalMainSymptom(jcsjCureDialectical);
        dialecticalService.dialecticalDiseaseCurePrescription_SP(jcsjCureDialectical);
        if (flag > 0) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 修改证型治法设置
     *
     * @return
     */
    @ApiComment(" 修改证型治法设置")
    @RequestMapping(value = "/updateCureDialectical", method = RequestMethod.POST)
    @ResponseBody
    public Result updateCureDialectical(
            @RequestBody JCSJCureDialectical jcsjCureDialectical
    ) {
        int flag = dialecticalService.updateDialecticalMainSymptom(jcsjCureDialectical);
        dialecticalService.dialecticalDiseaseCurePrescription_SP(jcsjCureDialectical);

        if (flag > 0) {
            return ResultFactory.create("0", "保存成功", null);
        }
        return ResultFactory.create("1", "保存失败", null);
    }

    /**
     * 删除证型治法设置
     *
     * @return
     */
    @ApiComment(" 删除证型治法设置")
    @RequestMapping(value = "/deleteCureDialectical", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteCureDialectical(
            @RequestParam("dialecticalcode") String dialecticalcode,
            @RequestParam("mainsymptomcode") String mainsymptomcode
    ) {
        //判断主症中是否用到此兼症
        if (dialecticalService.GetDialecticalCureRelation(dialecticalcode, mainsymptomcode).size() > 0) {
            return ResultFactory.create("1", " 治法中用到了此证型，不能删除！", null);
        }
        int flag = 0;
        String[] tables = {"Gy_DiseaseOrDialectical", "Gy_CureDialectical", "Gy_DialecticalMainSymptom", "Gy_DialectcalWesternMedicine"};
        for (String strtable : tables) {
            flag += dialecticalService.deleteCureDialectical(strtable, dialecticalcode, mainsymptomcode);
        }
        if (flag > 0) {
            return ResultFactory.create("0", "删除成功", null);
        }
        return ResultFactory.create("1", "删除失败", null);
    }

    /**
     * 获取主症的包括的所有兼症、脉象、舌像
     *
     * @return 兼症、脉象、舌像列表
     */
    @ApiComment(" 获取主症的包括的所有兼症、脉象、舌像")
    @RequestMapping(value = "/GetDiseaseByMainSymptomCode", method = RequestMethod.POST)
    @ResponseBody
    public Result GetDiseaseByMainSymptomCode(
            @RequestParam("mainsymptomcode") String mainsymptomcode
    ) {
        List<JCSJCureDialectical> dialecticals = dialecticalService.GetDiseaseByMainSymptomCode(mainsymptomcode);
        if (dialecticals == null || dialecticals.size() == 0) {
            return ResultFactory.create("1", "没有数据", null);
        }
        //DES解密
        for (JCSJCureDialectical doc : dialecticals) {
            doc.setDiseasename(UtilDES.Decrypt(doc.getDiseasename()));
        }
        return ResultFactory.create("0", null, dialecticals);
    }

    /**
     * 获取治法
     *
     * @return 治法列表
     */
    @ApiComment(" 获取治法")
    @RequestMapping(value = "/GetCureAndPreListBycode", method = RequestMethod.POST)
    @ResponseBody
    public Result GetCureAndPreListBycode(
            @RequestParam("dialecticalcode") String dialecticalcode,
            @RequestParam("mainsymptomcode") String mainsymptomcode
    ) {
        List<JCSJCureDialectical> dialecticals = dialecticalService.GetCureAndPreListBycode(dialecticalcode,mainsymptomcode);
        if (dialecticals == null || dialecticals.size() == 0) {
            return ResultFactory.create("1", "没有数据", null);
        }
        return ResultFactory.create("0", null, dialecticals);
    }

    /**
     * 根据证型编码和主症编码获取证型和兼症的关系
     *
     * @return 治法列表
     */
    @ApiComment(" 根据证型编码和主症编码获取证型和兼症的关系")
    @RequestMapping(value = "/GetDiseaseByDialecticalAndMainSymptomCode", method = RequestMethod.POST)
    @ResponseBody
    public Result GetDiseaseByDialecticalAndMainSymptomCode(
            @RequestParam("dialecticalcode") String dialecticalcode,
            @RequestParam("mainsymptomcode") String mainsymptomcode
    ) {
        List<JCSJCureDialectical> dialecticals = dialecticalService.GetDiseaseByDialecticalAndMainSymptomCode(dialecticalcode,mainsymptomcode);
        if (dialecticals == null || dialecticals.size() == 0) {
            return ResultFactory.create("1", "没有数据", null);
        }
        //DES解密
        for (JCSJCureDialectical doc : dialecticals) {
            if(doc.getDiseasename()!=null) {
                doc.setDiseasename(UtilDES.Decrypt(doc.getDiseasename()));
            }
        }
        return ResultFactory.create("0", null, dialecticals);
    }

    /**
     * 获取西医病名
     *
     * @return 西医病名列表
     */
    @ApiComment(" 获取西医病名")
    @RequestMapping(value = "/GetWesternTable", method = RequestMethod.POST)
    @ResponseBody
    public Result GetWesternTable(
            @RequestParam("dialecticalcode") String dialecticalcode,
            @RequestParam("mainsymptomcode") String mainsymptomcode
    ) {
        List<JCSJCureDialectical> dialecticals = dialecticalService.GetWesternTable(dialecticalcode,mainsymptomcode);
        if (dialecticals == null || dialecticals.size() == 0) {
            return ResultFactory.create("1", "没有数据", null);
        }
        return ResultFactory.create("0", null, dialecticals);
    }

}
