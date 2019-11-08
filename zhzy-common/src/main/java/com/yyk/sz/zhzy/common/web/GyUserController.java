package com.yyk.sz.zhzy.common.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.common.entity.GyUser;
import com.yyk.sz.zhzy.common.entity.MecidalType;
import com.yyk.sz.zhzy.common.service.GyUserService;
import com.yyk.sz.zhzy.common.service.MecidalTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api2Doc(id = "common.gyUser", name = "医生列表")
@ApiComment(seeClass = GyUser.class)
@RestController
@RequestMapping(value = "/common/gyUser")
public class GyUserController {

    @Autowired
    private GyUserService gyUserService;

    /**
     * 根据科室获取医生列表
     *
     * @return 医生列表
     */
    @ApiComment("根据科室获取医生列表")
    @RequestMapping(value = "/getGyUser", method = RequestMethod.POST)
    public Result getGyUser( @RequestParam("deptCode") String deptCode) {
        List<GyUser> gyUserList = gyUserService.getGyUser(deptCode);
        if( gyUserList == null || gyUserList.size() == 0 ){
            return ResultFactory.create("1","科室编码："+deptCode+"没有医生信息)",null);
        }
        return ResultFactory.create("0",null,gyUserList);
    }

}
