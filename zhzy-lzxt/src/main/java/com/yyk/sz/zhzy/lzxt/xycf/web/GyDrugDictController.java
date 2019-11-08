package com.yyk.sz.zhzy.lzxt.xycf.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.lzxt.xycf.entity.GyDrugDict;
import com.yyk.sz.zhzy.lzxt.xycf.service.GyDrugDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 临症系统-西药详情Controller
 */
@Api2Doc(id = "lzxt.xycf.1", name = "临症-西药详情")
@ApiComment(seeClass = GyDrugDict.class)
@RestController
@RequestMapping(value = "/lzxt/xycf/")
public class GyDrugDictController {

    @Autowired
    private GyDrugDictService gyDrugDictService;

    /**
     * 根据病人信息单号和方剂ID获取西药信息
     *
     * @param empBasicMainID
     * @param fangJiSubID
     * @return 西药详情
     */
    @ApiComment("根据病人信息单号和方剂ID获取西药信息")
    @RequestMapping(value = "/getWesternDrugByFangJiSubID", method = RequestMethod.POST)
    @ResponseBody
    public Result getWesternDrugByFangJiSubID(@RequestParam("empBasicMainID") int empBasicMainID,@RequestParam("fangJiSubID") int fangJiSubID
    ) {
        List<GyDrugDict> frequencyList = gyDrugDictService.getWesternDrugByFangJiSubID(empBasicMainID,fangJiSubID);
        if( frequencyList == null || frequencyList.size() == 0 ){
            return ResultFactory.create("1","没有西药信息",null);
        }
        return ResultFactory.create("0",null,frequencyList);
    }

}
