package com.yyk.sz.zhzy.gcxt.bzlz.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.common.util.UtilDES;
import com.yyk.sz.zhzy.gcxt.bzlz.entity.GCMainSymptom;
import com.yyk.sz.zhzy.gcxt.bzlz.service.GCMainSymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 肛肠系统-辨证论治 Controller
 */
@Api2Doc(id = "gcxt.bzlz.3", name = "肛肠系统-辨证论治-主症")
@ApiComment(seeClass = GCMainSymptom.class)
@RestController
@RequestMapping(value = "/gcxt/bzlz/")
public class GCMainSymptomController {

    @Autowired
    private GCMainSymptomService gcMainSymptomService;

    /**
     * index，测试用
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public Result index() {
        return ResultFactory.create("0","临症系统-辨证论治测试访问成功。",null);
    }

    /**
     * 根据西医病名编码筛选主症
     *
     * @return 主症列表
     */
    @ApiComment("获取主症（根据西医病名编码筛选主症）")
    @RequestMapping(value = "/getSelectMainSymptomByCode", method = RequestMethod.POST)
    @ResponseBody
    public Result getSelectMainSymptomByCode(
            @RequestParam("deptCode") String deptCode,
            @RequestParam("userCode") String userCode,
            @RequestParam("westernMedicineCode") String westernMedicineCode,
            @RequestParam(value = "searchText", required = false,defaultValue = "") String searchText
    ) {
        List<GCMainSymptom> mainSymptoms = gcMainSymptomService.getSelectMainSymptomByCode(deptCode, userCode,westernMedicineCode,searchText);
        if( mainSymptoms == null || mainSymptoms.size() == 0 ){
            return ResultFactory.create("1","没有（部门："+deptCode+"）(用户："+userCode+")下的主症数据",null);
        }
        //DES解密主症名称
        for(GCMainSymptom doc : mainSymptoms){
            doc.setMainSymptomName(UtilDES.Decrypt(doc.getMainSymptomName()));
        }
        return ResultFactory.create("0",null,mainSymptoms);
    }
}
