package com.yyk.sz.zhzy.gcxt.zxzf.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.common.util.UtilDES;
import com.yyk.sz.zhzy.gcxt.utils.UtilString;
import com.yyk.sz.zhzy.gcxt.zxzf.entity.GCDialecticalOrCure;
import com.yyk.sz.zhzy.gcxt.zxzf.service.DialecticalOrCureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 肛肠系统-症型治法 Controller
 */
@Api2Doc(id = "gcxt.zxzf", name = "肛肠系统-症型治法")
@ApiComment(seeClass = GCDialecticalOrCure.class)
@RestController
@RequestMapping(value = "/gcxt/zxzf/")
public class GCDialecticalOrCureController {

    @Autowired
    private DialecticalOrCureService dialecticalOrCureService;

    /**
     * index，测试用
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public Result index() {
        return ResultFactory.create("0","临症系统-症型治法测试访问成功。",null);
    }

    /**
     * 获取症型治法（肛肠根据西医病名获取症型治法,WesternMedicineName）
     *
     * @return 症型治法列表
     */
    @ApiComment("获取症型治法（肛肠根据西医病名获取症型治法,WesternMedicineName）")
    @RequestMapping(value = "/getSelectAnorectalDialecticalCure", method = RequestMethod.POST)
    @ResponseBody
    public Result getSelectAnorectalDialecticalCure(
            @RequestParam("westernMedicineName") String westernMedicineName,
            @RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
            @RequestParam(value = "searchText", required = false) String searchText,
            @RequestParam(value = "sortName", required = false) String sortName,
            @RequestParam(value = "sortOrder", required = false) String sortOrder
    ) {
        searchText = UtilString.judgeNull(searchText);
        Paging<GCDialecticalOrCure> dialecticalOrCureList = dialecticalOrCureService.getSelectAnorectalDialecticalCure(
                westernMedicineName, pageNumber,pageSize,searchText,sortName,sortOrder);
        if( dialecticalOrCureList == null || dialecticalOrCureList.getSize() == 0 ){
            return ResultFactory.create("1","没有"+westernMedicineName+"下的症型治法数据",null);
        }

        //DES解密主症名称
        List<GCDialecticalOrCure> content = dialecticalOrCureList.getContent();
        for(GCDialecticalOrCure doc : content){
            doc.setMainSymptomName(UtilDES.Decrypt(doc.getMainSymptomName()));
        }

        return ResultFactory.create("0",null,dialecticalOrCureList);
    }



}
