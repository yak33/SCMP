package com.yyk.sz.zhzy.lzxt.bzlz.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.lzxt.bzlz.entity.Tongue;
import com.yyk.sz.zhzy.lzxt.bzlz.service.TongueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 临症系统-辨证论治 Controller
 */
@Api2Doc(id = "lzxt.bzlz.5", name = "辨证论治-舌像")
@ApiComment(seeClass = Tongue.class)
@RestController
@RequestMapping(value = "/lzxt/bzlz/")
public class TongueController {

    @Autowired
    private TongueService tongueService;

    /**
     * 获取舌像（根据主症编码获取对应的舌像）
     *
     * @return 舌像列表
     */
    @ApiComment("获取舌像（根据主症编码获取对应的舌像）")
    @RequestMapping(value = "/getTongueTable", method = RequestMethod.POST)
    @ResponseBody
    public Result getTongueTable(
            @RequestParam("mainSymptomCode") String mainSymptomCode
    ) {
        List<Tongue> diseases = tongueService.getTongueTable(mainSymptomCode);
        if( diseases == null || diseases.size() == 0 ){
            return ResultFactory.create("1","主症（"+mainSymptomCode+"）没有舌像数据",null);
        }
        return ResultFactory.create("0",null,diseases);
    }
}
