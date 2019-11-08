package com.yyk.sz.zhzy.jcsjxt.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.common.util.UtilDES;
import com.yyk.sz.zhzy.jcsjxt.entity.JCSJMainSymptom;
import com.yyk.sz.zhzy.jcsjxt.service.JCSJMainSymptomService;
import com.yyk.sz.zhzy.jcsjxt.utils.UtilString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 基础数据-主症设置 Controller
 */
@Api2Doc(id = "jcsjxt.zzsz", name = "基础数据-主症设置")
@ApiComment(seeClass = JCSJMainSymptom.class)
@RestController
@RequestMapping(value = "/jcsjxt/zzsz/")
public class JCSJMainSymptomController {

    @Autowired
    private JCSJMainSymptomService mainSymptomService;

    /**
     * 获取主症设置
     *
     * @return 主症设置列表
     */
    @ApiComment(" 获取主症设置")
    @RequestMapping(value = "/getMainSymptomTable", method = RequestMethod.POST)
    @ResponseBody
    public Result getMainSymptomTable(
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
        Paging<JCSJMainSymptom> jcsjMainSymptoms = mainSymptomService.getMainSymptomTable(pageNumber, pageSize, searchText, sortName, sortOrder);
        //DES解密主症名称
        List<JCSJMainSymptom> content = jcsjMainSymptoms.getContent();
        for (JCSJMainSymptom doc : content) {
            doc.setMainsymptomname(UtilDES.Decrypt(doc.getMainsymptomname()));
        }
        if (jcsjMainSymptoms == null || jcsjMainSymptoms.getSize() == 0) {
            return ResultFactory.create("1", "没有主症设置数据", null);
        }
        return ResultFactory.create("0", null, jcsjMainSymptoms);
    }

    /**
     * 新增主症设置
     *
     * @return
     */
    @ApiComment(" 新增主症设置")
    @RequestMapping(value = "/insertMainSymptom", method = RequestMethod.POST)
    @ResponseBody
    public Result insertMainSymptom(
            @RequestBody JCSJMainSymptom jcsjMainSymptom
    ) {
        if (mainSymptomService.GetSingleMainSymptomByMainSymptomCode(jcsjMainSymptom.getMainsymptomcode()).size() > 0)
        {
            return ResultFactory.create("1", "主症编码为：： " + jcsjMainSymptom.getMainsymptomcode() + " 已经存在，不能重复添加！", null);
        }
        List<JCSJMainSymptom> mainSymptoms=mainSymptomService.GetMainSymptomByMainSymptomNameAndMainSymptomTypeCode(jcsjMainSymptom.getMainsymptomtypecode());
        //DES解密
        for(JCSJMainSymptom doc : mainSymptoms){
            doc.setMainsymptomname(UtilDES.Decrypt(doc.getMainsymptomname()));
        }
        if(mainSymptoms.contains(jcsjMainSymptom.getMainsymptomname())){
            return ResultFactory.create("1", "主症分类： " + jcsjMainSymptom.getMainsymptomtypecode() + " 中已经存在名称为"+jcsjMainSymptom.getMainsymptomname()+"的主症，不能重复添加！", null);
        }

        int flag = mainSymptomService.insertMainSymptom(jcsjMainSymptom);
        String[] tables = {"Gy_MainMeridian", "Gy_MainPulse", "Gy_MainTongue", "Gy_MainSymptomDisease", "Gy_MainSymptomSystem"};
        if(mainSymptomService.GetMainSymptomByMainSymptomCode(jcsjMainSymptom.getMainsymptomcode()).size()>0){
            for (String strtable : tables) {
                flag += mainSymptomService.deleteMainSymptom(strtable, jcsjMainSymptom.getMainsymptomcode());
            }
        }
        //归经
        String[] meridianCode=null;
        if(jcsjMainSymptom.getMeridianCode()!=null) {
            meridianCode = jcsjMainSymptom.getMeridianCode().split(",");
        }
        if(meridianCode!=null) {
            for (int i = 0; i < meridianCode.length; i++) {
                flag += mainSymptomService.insertMainSymptomAll("Gy_MainMeridian", jcsjMainSymptom.getMainsymptomcode(),"MeridianCode",meridianCode[i]);
            }
        }
        //脉象
        String[] pulseCode=null;
        if(jcsjMainSymptom.getPulseCode()!=null) {
            pulseCode = jcsjMainSymptom.getPulseCode().split(",");
        }
        if(pulseCode!=null) {
            for (int i = 0; i < pulseCode.length; i++) {
                flag += mainSymptomService.insertMainSymptomAll("Gy_MainPulse", jcsjMainSymptom.getMainsymptomcode(),"PulseCode",pulseCode[i]);
            }
        }
        //舌像
        String[] tongueCode=null;
        if(jcsjMainSymptom.getTongueCode()!=null) {
            tongueCode = jcsjMainSymptom.getTongueCode().split(",");
        }
        if(tongueCode!=null) {
            for (int i = 0; i < tongueCode.length; i++) {
                flag += mainSymptomService.insertMainSymptomAll("Gy_MainTongue", jcsjMainSymptom.getMainsymptomcode(),"TongueCode",tongueCode[i]);
            }
        }
        //兼症
        String[] diseaseCode=null;
        if(jcsjMainSymptom.getDiseaseCode()!=null) {
            diseaseCode = jcsjMainSymptom.getDiseaseCode().split(",");
        }
        if(diseaseCode!=null) {
            for (int i = 0; i < diseaseCode.length; i++) {
                flag += mainSymptomService.insertMainSymptomAll("Gy_MainSymptomDisease", jcsjMainSymptom.getMainsymptomcode(),"DiseaseCode",diseaseCode[i]);
            }
        }
        //系统
        String[] systemCode=null;
        if(jcsjMainSymptom.getSystemCode()!=null) {
            systemCode = jcsjMainSymptom.getSystemCode().split(",");
        }
        if(systemCode!=null) {
            for (int i = 0; i < systemCode.length; i++) {
                flag += mainSymptomService.insertMainSymptomAll("Gy_MainSymptomSystem", jcsjMainSymptom.getMainsymptomcode(),"SystemCode",systemCode[i]);
            }
        }
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
    @ApiComment(" 修改主症分类 2 新的")
    @RequestMapping(value = "/updateMainSymptom", method = RequestMethod.POST)
    @ResponseBody
    public Result updateMainSymptom(
            @RequestBody JCSJMainSymptom jcsjMainSymptom
    ) {
        List<JCSJMainSymptom> mainSymptoms = mainSymptomService.GetMainSymptomByMainSymptomNameAndMainSymptomTypeCode(jcsjMainSymptom.getMainsymptomtypecode2());
        //DES解密
        for (JCSJMainSymptom doc : mainSymptoms) {
            doc.setMainsymptomname(UtilDES.Decrypt(doc.getMainsymptomname()));
        }
        if (mainSymptoms.contains(jcsjMainSymptom.getMainsymptomname2())) {
            return ResultFactory.create("1", "主症分类： " + jcsjMainSymptom.getMainsymptomtypecode2() + " 中已经存在名称为" + jcsjMainSymptom.getMainsymptomname2() + "的主症，不能重复添加！", null);
        }

        int flag = mainSymptomService.updateMainSymptom(jcsjMainSymptom);
        String[] tables = {"Gy_MainMeridian", "Gy_MainPulse", "Gy_MainTongue", "Gy_MainSymptomDisease", "Gy_MainSymptomSystem"};
        if (mainSymptomService.GetMainSymptomByMainSymptomCode(jcsjMainSymptom.getMainsymptomcode()).size() > 0) {
            for (String strtable : tables) {
                flag += mainSymptomService.deleteMainSymptom(strtable, jcsjMainSymptom.getMainsymptomcode());
            }
        }

        //归经
        String[] meridianCode=null;
        if(jcsjMainSymptom.getMeridianCode()!=null) {
            meridianCode = jcsjMainSymptom.getMeridianCode().split(",");
        }
        if(meridianCode!=null) {
            for (int i = 0; i < meridianCode.length; i++) {
                flag += mainSymptomService.insertMainSymptomAll("Gy_MainMeridian", jcsjMainSymptom.getMainsymptomcode(),"MeridianCode",meridianCode[i]);
            }
        }
        //脉象
        String[] pulseCode=null;
        if(jcsjMainSymptom.getPulseCode()!=null) {
            pulseCode = jcsjMainSymptom.getPulseCode().split(",");
        }
        if(pulseCode!=null) {
            for (int i = 0; i < pulseCode.length; i++) {
                flag += mainSymptomService.insertMainSymptomAll("Gy_MainPulse", jcsjMainSymptom.getMainsymptomcode(),"PulseCode",pulseCode[i]);
            }
        }
        //舌像
        String[] tongueCode=null;
        if(jcsjMainSymptom.getTongueCode()!=null) {
            tongueCode = jcsjMainSymptom.getTongueCode().split(",");
        }
        if(tongueCode!=null) {
            for (int i = 0; i < tongueCode.length; i++) {
                flag += mainSymptomService.insertMainSymptomAll("Gy_MainTongue", jcsjMainSymptom.getMainsymptomcode(),"TongueCode",tongueCode[i]);
            }
        }
        //兼症
        String[] diseaseCode=null;
        if(jcsjMainSymptom.getDiseaseCode()!=null) {
            diseaseCode = jcsjMainSymptom.getDiseaseCode().split(",");
        }
        if(diseaseCode!=null) {
            for (int i = 0; i < diseaseCode.length; i++) {
                flag += mainSymptomService.insertMainSymptomAll("Gy_MainSymptomDisease", jcsjMainSymptom.getMainsymptomcode(),"DiseaseCode",diseaseCode[i]);
            }
        }
        //系统
        String[] systemCode=null;
        if(jcsjMainSymptom.getSystemCode()!=null) {
            systemCode = jcsjMainSymptom.getSystemCode().split(",");
        }
        if(systemCode!=null) {
            for (int i = 0; i < systemCode.length; i++) {
                flag += mainSymptomService.insertMainSymptomAll("Gy_MainSymptomSystem", jcsjMainSymptom.getMainsymptomcode(),"SystemCode",systemCode[i]);
            }
        }

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
    @RequestMapping(value = "/deleteMainSymptom", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteMainSymptom(
            @RequestParam("mainsymptomcode") String mainsymptomcode
    ) {
        //判断科室中是否用到该主症
        if (mainSymptomService.GetMainSymptomDeptRelation(mainsymptomcode).size() > 0) {
            return ResultFactory.create("1", mainsymptomcode + " 科室中用到了该主症，不能删除！", null);
        }
        //判断兼症中是否用到该主症
        if (mainSymptomService.GetMainSymptomDiseaseRelation(mainsymptomcode).size() > 0) {
            return ResultFactory.create("1", mainsymptomcode + " 兼症中用到了该主症，不能删除！", null);
        }
        //判断症型和治法关系表中是否用到该主症
        if (mainSymptomService.GetCureDialecticalByMainSymptomCode(mainsymptomcode).size() > 0) {
            return ResultFactory.create("1", mainsymptomcode + " 症型和治法中用到了该主症，不能删除！", null);
        }
        int flag = 0;
        String[] tables = {"Gy_MainTongue", "Gy_MainPulse", "Gy_MainMeridian", "Gy_MainSymptomDisease", "Gy_MainSymptomSystem", "Gy_MainSymptom"};
        for (String strtable : tables) {
            flag += mainSymptomService.deleteMainSymptom(strtable, mainsymptomcode);
        }

        if (flag > 0) {
            return ResultFactory.create("0", "删除成功", null);
        }
        return ResultFactory.create("1", "删除失败", null);
    }

}
