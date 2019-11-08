package com.yyk.sz.zhzy.common.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.common.entity.MecidalType;
import com.yyk.sz.zhzy.common.service.MecidalTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api2Doc(id = "common.mecidalType", name = "就诊类型、费用类别")
@ApiComment(seeClass = MecidalType.class)
@RestController
@RequestMapping(value = "/common/mecidalType")
public class MecidalTypeController {

    @Autowired
    private MecidalTypeService mecidalTypeService;

    /**
     * index，测试用
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public Result index() {
        return ResultFactory.create("0","dictionary测试访问成功。",null);
    }

    /**
     * 获取就诊类型及费用类别（CheckFlag=0，就诊类型；CheckFlag=1，费用类别）
     *
     * @return 就诊类型、费用类别
     */
    @ApiComment(" 获取就诊类型及费用类别（CheckFlag=0，就诊类型；CheckFlag=1，费用类别）")
    @RequestMapping(value = "/getMecidalType", method = RequestMethod.POST)
    public Result getMecidalType( @RequestParam("checkFlag") String checkFlag) {
        List<MecidalType> mecidalTypeList = mecidalTypeService.getMecidalType(checkFlag);
        if( mecidalTypeList == null || mecidalTypeList.size() == 0 ){
            return ResultFactory.create("1","没有："+checkFlag+"类别信息)",null);
        }
        return ResultFactory.create("0",null,mecidalTypeList);
    }

}
