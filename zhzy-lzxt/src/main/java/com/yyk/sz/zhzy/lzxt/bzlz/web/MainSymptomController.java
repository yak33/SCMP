package com.yyk.sz.zhzy.lzxt.bzlz.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.common.util.UtilDES;
import com.yyk.sz.zhzy.lzxt.bzlz.entity.MainSymptom;
import com.yyk.sz.zhzy.lzxt.bzlz.service.MainSymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 临症系统-辨证论治 Controller
 */
@Api2Doc(id = "lzxt.bzlz.3", name = "辨证论治-主症")
@ApiComment(seeClass = MainSymptom.class)
@RestController
@RequestMapping(value = "/lzxt/bzlz/")
public class MainSymptomController {

    @Autowired
    private MainSymptomService mainSymptomService;

    /**
     * index，测试用
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public Result index() {
        return ResultFactory.create("0","临症系统-辨证论治测试访问成功。",null);
    }

    /**
     * 获取主症（根据请求传递的userCode和deptCode）
     *
     * @return 主症列表
     */
    @ApiComment("获取主症（根据请求传递的userCode和deptCode）")
    @RequestMapping(value = "/getSelectMainSymptomTable", method = RequestMethod.POST)
    @ResponseBody
    public Result getSelectMainSymptomTable(
            @RequestParam("deptCode") String deptCode,
            @RequestParam("userCode") String userCode,
            @RequestParam(value = "searchText", required = false,defaultValue = "") String searchText
    ) {
        List<MainSymptom> mainSymptoms = mainSymptomService.getSelectMainSymptomTable(deptCode, userCode,searchText);
        if( mainSymptoms == null || mainSymptoms.size() == 0 ){
            return ResultFactory.create("1","没有（部门："+deptCode+"）(用户："+userCode+")下的主症数据",null);
        }
        //DES解密主症名称
        for(MainSymptom doc : mainSymptoms){
            doc.setMainSymptomName(UtilDES.Decrypt(doc.getMainSymptomName()));
        }
        return ResultFactory.create("0",null,mainSymptoms);
    }
}
