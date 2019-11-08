package com.yyk.sz.zhzy.lzxt.zxzf.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.common.util.UtilDES;
import com.yyk.sz.zhzy.lzxt.utils.UtilString;
import com.yyk.sz.zhzy.lzxt.zxzf.entity.DialecticalOrCure;
import com.yyk.sz.zhzy.lzxt.zxzf.service.DialecticalOrCureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 临症系统-症型治法 Controller
 */
@Api2Doc(id = "lzxt.zxzf", name = "临症-症型治法")
@ApiComment(seeClass = DialecticalOrCure.class)
@RestController
@RequestMapping(value = "/lzxt/zxzf/")
public class DialecticalOrCureController {

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
     * 获取症型治法（根据请求传递的userCode和deptCode）
     *
     * @return 症型治法列表
     */
    @ApiComment("获取症型治法（根据请求传递的userCode和deptCode）")
    @RequestMapping(value = "/getSelectDCTable", method = RequestMethod.POST)
    @ResponseBody
    public Result getSelectDCTable(
            @RequestParam("deptCode") String deptCode,
            @RequestParam("account") String userCode,
            @RequestParam(value = "dialectical", required = false) String dialectical,
            @RequestParam(value = "chineseMedicine", required = false) String chineseMedicine,
            @RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
            @RequestParam(value = "searchText", required = false) String searchText,
            @RequestParam(value = "sortName", required = false) String sortName,
            @RequestParam(value = "sortOrder", required = false) String sortOrder
    ) {
        dialectical = UtilString.judgeNull(dialectical);
        chineseMedicine = UtilString.judgeNull(chineseMedicine);
        if(UtilString.judgeNull(searchText)!=null) {
            searchText = "%" + UtilString.judgeNull(searchText) + "%";
        }
        Paging<DialecticalOrCure> dialecticalOrCureList = dialecticalOrCureService.getSelectDCTable(
                deptCode, userCode, dialectical, chineseMedicine,
                pageNumber,pageSize,searchText,sortName,sortOrder);
        if( dialecticalOrCureList == null || dialecticalOrCureList.getSize() == 0 ){
            return ResultFactory.create("1","没有（部门："+deptCode+"）(用户："+userCode+")下的症型治法数据",null);
        }

        //DES解密主症名称
        List<DialecticalOrCure> content = dialecticalOrCureList.getContent();
        for(DialecticalOrCure doc : content){
            doc.setMainSymptomName(UtilDES.Decrypt(doc.getMainSymptomName()));
        }

        return ResultFactory.create("0",null,dialecticalOrCureList);
    }



}
