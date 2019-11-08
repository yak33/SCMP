package com.yyk.sz.zhzy.system.core.web;

import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/***
 * 处理用户相关的请求等，主要用于用户管理模块，包括对用户的增删改查等操作
 * @author lhw
 */
@Controller
@RequestMapping("/test")
public class TestController {

    /**
     * index，测试用
     */
    @ApiComment("测试用")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ResponseBody
    public Result index() {
        return ResultFactory.create("0","测试Controller 测试访问成功。",null);
    }

}
