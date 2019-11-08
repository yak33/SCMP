package com.yyk.sz.zhzy.common.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.common.entity.Dictionary;
import com.yyk.sz.zhzy.common.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api2Doc(id = "common.dictionary", name = "当前用户信息")
@ApiComment(seeClass = Dictionary.class)
@RestController
@RequestMapping(value = "/common/dictionary")
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

    /**
     * index，测试用
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public Result index() {
        return ResultFactory.create("0","dictionary测试访问成功。",null);
    }

    /**
     * 获取当前用户信息（根据请求传递的sessionId）
     *
     * @return 当前登录用户
     */
    @ApiComment("获取当前用户信息（根据请求传递的sessionId）")
    @RequestMapping(value = "/getByType/{type}", method = RequestMethod.GET)
    public Result currentUser(@PathVariable("type") String type) {
        List<Dictionary> dictionary = dictionaryService.getDictionaryByType(type);
        if( dictionary == null || dictionary.size() == 0 ){
            return ResultFactory.create("1","没有（"+type+"）的字典数据",null);
        }
        return ResultFactory.create("0",null,dictionary);
    }

}
