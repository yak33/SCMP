package com.yyk.sz.zhzy.lzxt.bzlz.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.common.util.UtilDES;
import com.yyk.sz.zhzy.lzxt.bzlz.entity.Disease;
import com.yyk.sz.zhzy.lzxt.bzlz.entity.GovernanceResult;
import com.yyk.sz.zhzy.lzxt.bzlz.entity.MainSymptom;
import com.yyk.sz.zhzy.lzxt.bzlz.service.DiseaseService;
import com.yyk.sz.zhzy.lzxt.bzlz.service.MainSymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 临症系统-辨证论治 Controller
 */
@Api2Doc(id = "lzxt.bzlz.1", name = "辨证论治-兼症")
@ApiComment(seeClass = Disease.class)
@RestController
@RequestMapping(value = "/lzxt/bzlz/")
public class DiseaseController {

    @Autowired
    private DiseaseService diseaseService;

    /**
     * 获取兼症（根据主症编码获取对应的兼症）
     *
     * @return 兼症列表
     */
    @ApiComment("获取兼症（根据主症编码获取对应的兼症）")
    @RequestMapping(value = "/getDiseaseTable", method = RequestMethod.POST)
    @ResponseBody
    public Result getDiseaseTable(
            @RequestParam("mainSymptomCode") String mainSymptomCode
    ) {
        List<Disease> diseases = diseaseService.getDiseaseTable(mainSymptomCode);
        if( diseases == null || diseases.size() == 0 ){
            return ResultFactory.create("1","主症（"+mainSymptomCode+"）没有兼症数据",null);
        }
        //DES解密
        for(Disease doc : diseases){
            doc.setDiseaseName(UtilDES.Decrypt(doc.getDiseaseName()));
        }
        return ResultFactory.create("0",null,diseases);
    }
}
