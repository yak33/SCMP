package com.yyk.sz.zhzy.common.web;

//import javax.validation.Valid;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.common.entity.UserInfo;
import com.yyk.sz.zhzy.common.mapper.UserMapper;
//import com.yyk.sz.zhzy.common.service.UserInfoService;
import com.yyk.sz.zhzy.common.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api2Doc(id = "common.userInfo", name = "用户信息")
@ApiComment(seeClass = UserInfo.class)
@RestController
@RequestMapping(value = "/common/userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private UserMapper userMapper;

    /**
     * index，测试用
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public Result index() {
        return ResultFactory.create("0","userInfo测试访问成功。",null);
    }

    /**
     * 获取当前用户信息（根据请求传递的sessionId）
     *
     * @return 当前登录用户
     */
    @ApiComment("获取当前用户信息（根据请求传递的sessionId）")
    @RequestMapping(value = "/currentUser", method = RequestMethod.GET)
    public Result currentUser() {
        UserInfo debugUserInfo = new UserInfo();
        debugUserInfo.setAccount("zws");
        debugUserInfo.setName("张文山");
        debugUserInfo.setNote("Debug用户-框架测试用");
        return ResultFactory.create("0",null,debugUserInfo);
    }


    /**
     * 根据account取得用户信息
     *
     * @param
     * @return
     */
    @ApiComment("根据account取得用户信息")
    @RequestMapping(value = "/account/{account}", method = RequestMethod.GET)
    public Result account(@PathVariable("account") String account) {
        return ResultFactory.create(userInfoService.getUserInfoByAccount(account));
        //return ResultFactory.create(userMapper.getOne(Long.parseLong(account)));
    }
//
//    /**
//     * 保存用户信息
//     *
//     * @param entity
//     * @return
//     */
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public Result save(@Valid UserInfo entity) {
//        if( entity.getAccount() == null || entity.getAccount().trim().length() == 0 ){
//            return ResultFactory.create("1","用户信息中账号为空，无法保存。",null);
//        }
//        userInfoService.save(entity);
//        String account = entity.getAccount().trim();
//        UserInfo userInfo = userInfoService.getUserInfoByAccount(account);
//        if( userInfo == null ){
//            return ResultFactory.create("1","保存用户信息失败。",null);
//        }
//        return ResultFactory.create("0","保存用户信息成功。",null);
//    }
}
