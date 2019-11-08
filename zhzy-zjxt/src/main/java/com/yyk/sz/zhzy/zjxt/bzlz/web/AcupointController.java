package com.yyk.sz.zhzy.zjxt.bzlz.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.zjxt.bzlz.entity.Acupoint;
import com.yyk.sz.zhzy.zjxt.bzlz.service.AcupointService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 针灸-添加穴位获取穴位
 * @Author: ZhangChao
 * @Date: 2018/11/23 15:54
 * @Version: 1.0
 */
@Api2Doc(id = "zjxt.bzlz.1",name = "针灸-添加穴位获取穴位")
@ApiComment(seeClass = Acupoint.class)
@RestController
@RequestMapping("/zjxt/bzlz")
public class AcupointController {

    @Resource
    private AcupointService acupointService;

    /**
     * 获取所有穴位
     * @return
     */
    @ApiComment("获取穴位")
    @RequestMapping(name = "获取穴位",value = "/getAllAcupoint", method = RequestMethod.POST)
    @ResponseBody
    public Result getAllAcupoint(
            @RequestParam(value = "searchText",required = false) String searchText){
        List<Acupoint> acupointList = acupointService.getAllAcupoint(searchText);
        if (acupointList != null && acupointList.size() > 0){
            return ResultFactory.create("0",null, acupointList);
        }
        return ResultFactory.create("1","无数据",null);
    }

}
