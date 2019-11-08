package com.yyk.sz.zhzy.lzxt.bzlz.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.lzxt.bzlz.entity.Pulse;
import com.yyk.sz.zhzy.lzxt.bzlz.service.PulseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 临症系统-辨证论治 Controller
 */
@Api2Doc(id = "lzxt.bzlz.4", name = "辨证论治-脉象")
@ApiComment(seeClass = Pulse.class)
@RestController
@RequestMapping(value = "/lzxt/bzlz/")
public class PulseController {

    @Autowired
    private PulseService pulseService;

    /**
     * 获取脉象（根据主症编码获取对应的舌像）
     *
     * @return 脉象列表
     */
    @ApiComment("获取脉象（根据主症编码获取对应的舌像）")
    @RequestMapping(value = "/getPulseTable", method = RequestMethod.POST)
    @ResponseBody
    public Result getPulseTable(
            @RequestParam("mainSymptomCode") String mainSymptomCode
    ) {
        List<Pulse> diseases = pulseService.getPulseTable(mainSymptomCode);
        if( diseases == null || diseases.size() == 0 ){
            return ResultFactory.create("1","主症（"+mainSymptomCode+"）没有脉象数据",null);
        }
        return ResultFactory.create("0",null,diseases);
    }
}
