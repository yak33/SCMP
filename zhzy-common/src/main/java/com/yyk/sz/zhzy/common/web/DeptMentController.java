package com.yyk.sz.zhzy.common.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.common.entity.DeptMent;
import com.yyk.sz.zhzy.common.service.DeptMentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api2Doc(id = "common.deptment", name = "用户信息")
@ApiComment(seeClass = DeptMent.class)
@RestController
@RequestMapping(value = "/common/deptment")
public class DeptMentController {

    @Autowired
    private DeptMentService deptMentService;


    /**
     * 获取科室
     *
     * @return 科室信息
     */
    @ApiComment("获取科室")
    @RequestMapping(value = "/getKeShi", method = RequestMethod.GET)
    public Result getKeShi() {
        List<DeptMent> dictionary = deptMentService.getKeShi();
        if( dictionary == null || dictionary.size() == 0 ){
            return ResultFactory.create("1","没有科室数据",null);
        }
        return ResultFactory.create("0",null,dictionary);
    }
}
