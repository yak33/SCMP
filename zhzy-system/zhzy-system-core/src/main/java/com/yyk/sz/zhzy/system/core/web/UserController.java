package com.yyk.sz.zhzy.system.core.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.common.base.domain.Token;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.common.base.utils.UtilIP;
import com.yyk.sz.common.base.utils.UtilRequest;
import com.yyk.sz.common.base.utils.UtilRequestAttrHolder;
import com.yyk.sz.common.base.utils.UtilTokenDealer;
import com.yyk.sz.zhzy.system.common.Constants;
import com.yyk.sz.zhzy.system.common.MD5Util;
import com.yyk.sz.zhzy.system.core.entity.GyUser;
import com.yyk.sz.zhzy.system.core.entity.SysRole;
import com.yyk.sz.zhzy.system.core.mappercust.TenantNode;
import com.yyk.sz.zhzy.system.core.mappercust.UserNode;
import com.yyk.sz.zhzy.system.core.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/***
 * 处理用户相关的请求等，主要用于用户管理模块，包括对用户的增删改查等操作
 * @author lhw
 */
@CrossOrigin
@Api2Doc(id = "system.core.usercontroller", name = "权限系统-用户")
@ApiComment(seeClass = GyUser.class)
@Controller
@RequestMapping(UserController.BASE_PATH)
public class UserController {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    public static final String BASE_PATH = "/core/user";

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private OrganizationService orgService;

    @Autowired
    private TenantUserNodeService userNodeService;

    @Resource
    private TenantNodeService tenantNodeService;

    /**
     * 分页查询
     *
     * @param pageNumber
     * @param pageSize
     * @param sortType
     * @return
     */
    @ApiComment("分页查询")
    @RequestMapping(value = "/list", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Result list(
            @RequestParam(value = "pageNumber", defaultValue = "1") int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = Constants.PAGE_SIZE + "") int pageSize,
            @RequestParam(value = "sortType", defaultValue = "usercode") String sortType,
            @RequestParam(value = "searchText",required = false) String searchText) {
        Paging<GyUser> page = userService.findByPage(pageNumber, pageSize, sortType, searchText);
        return ResultFactory.create(page);
    }

    /**
     * 根据id取得用户
     *
     * @param id
     * @return
     */
    @ApiComment("根据id取得用户---url动态参数，只能GET请求")
    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result getById(@PathVariable("id") String id) {
        GyUser user = userService.getById(id);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("user", user);
        return ResultFactory.create(map);
    }

    /**
     * 根据账号取得用户
     *
     * @param account
     * @return
     */
    @ApiComment("根据账号（编码）取得用户")
    @RequestMapping(value = "/getByAccount/{account}", method = RequestMethod.GET)
    @ResponseBody
    public Result getByAccount(@PathVariable("account") String account) {
        GyUser user = userService.getByAccount(account);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("user", user);
        return ResultFactory.create(map);
    }

    /**
     * 保存用户
     *
     * @return
     */
    @ApiComment("保存用户")
    @PostMapping("/save")
    @ResponseBody
    public Result save(@RequestParam(value = "usercode") String usercode
            , @RequestParam(value = "hisusercode", required = false) String hisusercode
            , @RequestParam(value = "deptcode") String deptcode
            , @RequestParam(value = "username") String username
            , @RequestParam(value = "password", required = false) String password
            , @RequestParam(value = "alias", required = false) String alias
            , @RequestParam(value = "sex", required = false) String sex
            , @RequestParam(value = "mobile", required = false) String mobile
            , @RequestParam(value = "address", required = false) String address
            , @RequestParam(value = "email", required = false) String email
            , @RequestParam(value = "status", required = false) String status
            , @RequestParam(value = "startdate", required = false) String startdate
            , @RequestParam(value = "enddate", required = false) String enddate
            , @RequestParam(value = "remark", required = false) String remark
            , @RequestParam(value = "node") String node
            , @RequestParam(value = "pId") String pId
            , HttpServletRequest request) {
        if (usercode == null || "".equals(usercode)){
            return ResultFactory.create("用户编码不能为空!");
        }
        GyUser user = new GyUser();
        user.setUsercode(usercode);
        user.setHisusercode(hisusercode);
        user.setDeptcode(deptcode);
        user.setUsername(username);
        if (password != null) {
            user.setPassword(MD5Util.MD5(password));
        }
        user.setAlias(alias);
        user.setSex("0");
        user.setSex(sex);
        user.setMobile(mobile);
        user.setaddress(address);
        user.setEmail(email);
        user.setStatus(status);
        user.setStartdate(new Date());
        if (startdate != null) {
            try {
                user.setStartdate(sdf.parse(startdate));
            } catch (Exception e) {
            }
        }
        user.setEnddate(new Date());
        if (enddate != null) {
            try {
                user.setEnddate(sdf.parse(enddate));
            } catch (Exception e) {
            }
        }
        user.setRemark(remark);
        user.setFlag(""); //设置为普通用户，默认绑定basic
        userService.save(user);
        //在公共库dn0添加数据
//        HttpSession session = request.getSession();
//        session.setAttribute("node","dn0");
        UtilRequestAttrHolder.setAttribute(request, "node", "dn0");
        UserNode userNode = new UserNode();
        userNode.setAccount(usercode);
        userNode.setNode(node);
        userNode.setpId(pId);
        int addSuperUser = userNodeService.addSuperUser(userNode);
        System.out.println(addSuperUser);
//        session.setAttribute("node",node);
        UtilRequestAttrHolder.setAttribute(request, "node", node);
        return ResultFactory.create(Constants.MESSAGE_PUBLIC_SAVE);
    }

    /**
     * 更新用户信息
     *
     * @return
     */
    @ApiComment("更新用户信息")
    @PostMapping("/updateUser")
    @ResponseBody
    public Result updateUser(@RequestParam(value = "uuid") String uuid
            , @RequestParam(value = "usercode") String usercode
            , @RequestParam(value = "hisusercode", required = false) String hisusercode
            , @RequestParam(value = "deptcode") String deptcode
            , @RequestParam(value = "username") String username
            , @RequestParam(value = "alias", required = false) String alias
            , @RequestParam(value = "sex", required = false) String sex
            , @RequestParam(value = "mobile", required = false) String mobile
            , @RequestParam(value = "address", required = false) String address
            , @RequestParam(value = "email", required = false) String email
            , @RequestParam(value = "status", required = false) String status
            , @RequestParam(value = "startdate", required = false) String startdate
            , @RequestParam(value = "enddate", required = false) String enddate
            , @RequestParam(value = "remark", required = false) String remark) {
        if (usercode == null || "".equals(usercode)){
            return ResultFactory.create("用户编码不能为空!");
        }
        if (uuid == null || "".equals(uuid)){
            return ResultFactory.create("uuid不能为空!");
        }
        GyUser user = new GyUser();
        user.setUsercode(usercode);
        user.setUuid(uuid);
        user.setHisusercode(hisusercode);
        user.setDeptcode(deptcode);
        user.setUsername(username);
        user.setSex("0");
        user.setSex(sex);
        user.setAlias(alias);
        user.setMobile(mobile);
        user.setaddress(address);
        user.setEmail(email);
        user.setStatus(status);
        user.setStartdate(new Date());
        if (startdate != null) {
            try {
                user.setStartdate(sdf.parse(startdate));
            } catch (Exception e) {
            }
        }
        user.setEnddate(new Date());
        if (enddate != null) {
            try {
                user.setEnddate(sdf.parse(enddate));
            } catch (Exception e) {
            }
        }
        user.setRemark(remark);
        userService.updateByUUID(user);
        return ResultFactory.create(Constants.MESSAGE_PUBLIC_UPDATE);
    }

    /**
     * 删除id对应的用户
     *
     * @param id
     * @return
     */
    @ApiComment("根据id删除用户")
    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result deleteById(@PathVariable("id") String id) {
        userService.delete(id);
        return ResultFactory.create(Constants.MESSAGE_PUBLIC_DELETE);
    }

    /**
     * 删除账号（编码）对应的用户
     *
     * @param usercode
     * @return
     */
    @ApiComment("根据账号（编码）删除用户")
    @RequestMapping(value = "/deleteByAccount/{usercode}", method = RequestMethod.GET)
    @ResponseBody
    public Result deleteByAccount(@PathVariable("usercode") String usercode) {
        GyUser user = userService.getByAccount(usercode);
        userService.delete(user.getUuid());
        return ResultFactory.create(Constants.MESSAGE_PUBLIC_DELETE);
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @ApiComment("批量删除，ids是用逗号拼接的id")
    @RequestMapping(value = "/deleteByIds/{ids}", method = RequestMethod.GET)
    @ResponseBody
    public Result deleteByIds(@PathVariable("ids") String ids) {
        userService.deleteByIds(ids);
        return ResultFactory.create(Constants.MESSAGE_PUBLIC_DELETE);
    }

    /**
     * 根据id重设用户密码
     *
     * @return
     */
    @ApiComment("根据id重设用户密码")
    @RequestMapping(value = "/resetPwdById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result resetPwdById(@PathVariable("id") String id) {
        userService.restPwd(id);
        return ResultFactory.create("操作成功");
    }

    /**
     * 根据账号（编码）重设用户密码
     *
     * @return
     */
    @ApiComment("根据账号（编码）重设用户密码")
    @RequestMapping(value = "/resetPwdByAccount/{usercode}", method = RequestMethod.GET)
    @ResponseBody
    public Result resetPwdByAccount(@PathVariable("usercode") String account) {
        GyUser user = userService.getByAccount(account);
        userService.restPwd(user.getUuid());
        return ResultFactory.create("操作成功");
    }

    /**
     * 根据id修改用户密码
     *
     * @return
     */
    @ApiComment("根据id修改用户密码")
    @RequestMapping(value = "/editPwdById/{id}/{password}", method = RequestMethod.GET)
    @ResponseBody
    public Result editPwdById(@PathVariable("id") String id, @PathVariable("password") String password) {
        GyUser user = userService.getById(id);
        user.setPassword(MD5Util.MD5(password));
        userService.save(user);
        return ResultFactory.create("操作成功");
    }

    /**
     * 根据账号（编码）修改用户密码
     *
     * @return
     */
    @ApiComment("根据账号（编码）修改用户密码")
    @RequestMapping(value = "/editPwdByAccount/{oldpwd}/{usercode}/{password}", method = RequestMethod.GET)
    @ResponseBody
    public Result editPwdByAccount(
            @PathVariable("usercode") String usercode,
            @PathVariable("password") String password,
            @PathVariable("oldpwd") String oldpwd) {
        GyUser user = userService.getByAccount(usercode);
        String inputOldPwd = MD5Util.MD5(oldpwd);
        String oldPwd = user.getPassword();
        if (!inputOldPwd.equals(oldPwd)){
            return ResultFactory.create("1","原密码错误!",null);
        }
        user.setPassword(MD5Util.MD5(password));
        userService.save(user);
        return ResultFactory.create("操作成功");
    }

    /**
     * 为用户绑定角色
     *
     * @param account   用户账号
     * @param roleCodes 角色编码（逗号拼接）
     * @return
     */
    @ApiComment("为用户绑定角色，roleCodes是用逗号拼接的roleCode")
    @RequestMapping(value = "/bindroles", method = RequestMethod.POST)
    @ResponseBody
    public Result bindRoles(
            @RequestParam("account") String account,
            @RequestParam(value = "roleCodes",required = false) String roleCodes) {
        userService.deleteByAccout(account);
        if (roleCodes != null && !"".equals(roleCodes)){
            userService.bindRoles(account, roleCodes);
        }
        return ResultFactory.create(Constants.MESSAGE_PUBLIC_BIND);
    }


    /**
     * 获取组织机构用户树
     *
     * @return
     */
    @ApiComment("获取组织机构用户树")
    @RequestMapping(value = "/orgusertree", method = RequestMethod.POST)
    @ResponseBody
    public Result findOrgUserTree(@RequestParam(value = "deptname", required = false) String filterOrgName) {
        return ResultFactory.create(orgService.findOrgUserTree(filterOrgName));
    }

    /**
     * 编码唯一性校验
     *
     * @return
     */
    @ApiComment("编码唯一性校验，专用于validform的ajaxUrl方式校验")
    @RequestMapping(value = "/checkuser", method = RequestMethod.POST)
    @ResponseBody
    public String checkUser(
            @RequestParam(value = "param") String param) {
        String jsonString = "{\"info\":\"通过信息验证！\",\"status\":\"y\"}";
        if (userService.checkUserAccountExist("", param)) {
            jsonString = "{\"info\":\"此账户已存在\",\"status\":\"n\"}";

        }
        return jsonString;
    }

    /**
     * 取得指定用户的角色
     *
     * @param account
     * @return
     */
    @ApiComment("取得指定用户的角色")
    @RequestMapping(value = "/rolesbyaccount/{account}", method = RequestMethod.GET)
    @ResponseBody
    public Result findRolesByAccount(@PathVariable("account") String account) {
        return ResultFactory.create(roleService.findByUserAccount(account));
    }

    /**
     * 获取所有的医院
     *
     * @return
     */
    @ApiComment("获取所有的医院")
    @RequestMapping(value = "/getAllHospital", method = RequestMethod.GET)
    @ResponseBody
    public Result getAllHospital(HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        System.out.println("【获取所有的医院】当前session："+session);
//        session.setAttribute("node","dn0");
        UtilRequestAttrHolder.setAttribute(request, "node", "dn0");
        List<TenantNode> list = tenantNodeService.getAllHospital();
//        session.removeAttribute("node");z
        //销毁session
//        System.out.println("【获取所有的医院】移除session："+session);
//        UtilSession.removeSession(session);
        return ResultFactory.create(list);
    }

    /**
     * 用户注册
     *
     * @param username
     * @param password
     * @return
     */
    @ApiComment("用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Result register(
            @RequestParam("usercode") String usercode,
            @RequestParam(value = "username",required = false) String username,
            @RequestParam("name") String name,
            @RequestParam(value = "password",required = false) String password,
            @RequestParam(value = "mobile",required = false) String mobile,
            @RequestParam("invitationCode") String invitationCode,
            HttpServletRequest request) {

        System.out.println("【用户注册】开始");
        if (username == null || "".equals(username)){
            username = "超级管理员";
        }
        //先判断邀请码invitationCode正不正确,即存在不存在
        List<TenantNode> tenantNodeList = tenantNodeService.getByInvitationCode(invitationCode);
        if (tenantNodeList == null || tenantNodeList.size()==0){
            return ResultFactory.create("1","请输入正确的邀请码!",null);
        }
        //判断此邀请码有没有被使用，即有木有绑定医院或超级用户
        List<TenantNode> tnList = tenantNodeService.getBeUsedOrNo(invitationCode);
        if (tnList != null && tnList.size() > 0){
            return ResultFactory.create("1","此邀请码已被使用!",null);
        }
        //如果邀请码存在且没有使用，则继续...
        //从公共库（dn0）保存此超级用户
        UserNode userNode = new UserNode();
        userNode.setAccount(usercode);
        userNode.setNode(tenantNodeList.get(0).getNode());
        int addSuperUser = userNodeService.addSuperUser(userNode);
        System.out.println(addSuperUser);
        //保存医院名称
        TenantNode tenantNode = new TenantNode();
        tenantNode.setInvitationCode(invitationCode);
        tenantNode.setName(name); //设置医院名称
        int updateByInvitationCode = tenantNodeService.updateByInvitationCode(tenantNode);
        System.out.println(updateByInvitationCode);
        //往Gy_User表保存这个超级用户(管理员)
        GyUser user = new GyUser();
        user.setUsercode(usercode);
        user.setDeptcode("10001"); //先默认..
        user.setUsername(username);
        if (password != null) {
            user.setPassword(MD5Util.MD5(password));
        }
        user.setMobile(mobile);
        user.setStatus("0");
        user.setStartdate(new Date());
        user.setRemark("");
        user.setFlag("超级管理员");
        //不要让它去公共库dn0去找..
//        session.setAttribute("node",tenantNodeList.get(0).getNode());
        UtilRequestAttrHolder.setAttribute(request, "node", tenantNodeList.get(0).getNode());
        int insertGyUser = userService.save(user); //保存到对应的分库的Gy_User表里..
        System.out.println(insertGyUser);
        if (insertGyUser > 0 && addSuperUser > 0){
            System.out.println("【用户注册】结束，保存成功!");
//            session.removeAttribute("node");
//            //销毁session
//            UtilSession.removeSession(session);
            return ResultFactory.create("0","注册成功!",userNode);
        }
        return ResultFactory.create("2","注册失败!",null);
    }

    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     */
    @ApiComment("用户登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("node") String node,
            @RequestParam(value = "force", required = false) String force) {

        logger.debug("【用户登录】开始，"+username);

        GyUser gyUser = new GyUser();
        gyUser.setUsername(username);
        //bug-fix:密码应为MD5，不应为明文
        //gyUser.setPassword(MD5Util.MD5(password));
        gyUser.setPassword(password);
        System.out.println(gyUser.getPassword());

        //TODO 用户提交数据(四个参数)的危险字符串过滤，防止sql注入

        //1，多租户查询：查找该用户属于哪个租户节点（从公共库（dn0）查询）
        logger.debug("【用户登录】查找该用户属于哪个租户节点（从公共库（dn0）查询）。");
        UserNode un = new UserNode();
        un.setNode(node);
        un.setAccount(username);
        HttpServletRequest request = UtilRequest.getRequest();
        UtilRequestAttrHolder.setAttribute(request, "node", "dn0");//设置当前请求从公共库获取数据
        TenantNode tenantNode = tenantNodeService.getByNode(node); //2019/3/6 返回用户所在医院的id，数据共享要用。
        List<UserNode> userNodes = userNodeService.getUserNode(un);
        if(userNodes == null || userNodes.size() == 0 ){
            logger.error("【用户登录】结束，租户系统内没有此用户的注册信息!（账号："+username+"，节点："+node+"）");
            return ResultFactory.create("1","租户系统内没有此用户的注册信息!",null);
        }

        //2，密码验证
        UserNode userNode = userNodes.get(0);
        String node1 = userNode.getNode();
        logger.debug("【用户登录】租户系统查询成功，账号："+username+"，节点："+node1+"");
        UtilRequestAttrHolder.setAttribute(request, "node", node1);//设置当前请求从指定库获取数据
        logger.debug("【用户登录】查询所属租户节点内，用户基本信息。");
        //查询所属租户节点库内的用户详细信息
        GyUser user = null;
        List<GyUser> es = userService.selectUser(gyUser);
        if (es != null && es.size() > 0){//密码正确
            user = es.get(0);
            logger.debug("【用户登录】密码正确，开始设置返回值");
            List<SysRole> roles = roleService.findByUserAccount(user.getUsercode());
            if (userNode.getpId().equals("-1")){ //说明是超级管理员
                user.setpId(userNode.getUUID());
            }else {
                user.setpId("");
            }
            user.setNode(node1);
            user.setPassword("");
            user.setUserRoles(roles); // 2019/1/7

            user.setHospid(String.valueOf(tenantNode.getId()));
            logger.debug("【用户登录】结束，登录成功！");
        }else{//密码错误
            logger.debug("【用户登录】查询失败，用户名或密码错误。销毁session。");
            //密码错误，销毁属性
            UtilRequestAttrHolder.removeRequest(request);
            return ResultFactory.create("2","用户名或密码错误,请重试!",null);
        }

        //TODO 先验证用户名-密码正确，在执行token的后续操作

        //3，既存token查找判断
        //获取既存session
        logger.debug("【用户登录】查找既存token。");
        Token requestToken = null;
        Token existedToken = UtilTokenDealer.getExistedToken(username);
        //已有同账号登录
        if( existedToken != null ){
            logger.debug("【用户登录】判断存在既存token。");
            Calendar createCalen = Calendar.getInstance();
            String createTime = existedToken.createTime;
            logger.debug("【用户登录】redis中已经存在的existedToken创建时间："+createTime);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            try {
                Date createDate = sdf.parse(createTime);
                createCalen.setTime(createDate);
                createCalen.add(Calendar.SECOND, 60 * 60);
                Date createDateAfter = createCalen.getTime();
                logger.debug("【用户登录】existedToken创建时间加：60分钟后为："+sdf.format(createDateAfter));
                Date nowDate = new Date();
                logger.debug("【用户登录】当前时间："+sdf.format(nowDate));//判断
                logger.debug("【用户登录】判断结果："+nowDate.after(createDateAfter));
                boolean timepara = nowDate.after(createDateAfter);
                if (timepara) {
                    logger.debug("【用户登录】existedToken已经超时，应该删除掉");
                    UtilTokenDealer.removeToken(existedToken);
                } else {
                    //重复登录（相同IP在登录状态下再次登录）
                    String currentIp = UtilIP.getIpAddr();
                    logger.debug("【用户登录】当前请求的IP："+currentIp);
                    if( currentIp.equalsIgnoreCase(existedToken.ip) ){
                        logger.debug("【用户登录】检测到重复登录（相同IP在登录状态下再次登录），销毁之前登录的token。");
                        //销毁之前登录的token
                        UtilTokenDealer.removeToken(existedToken);
                    }else{//其他终端同账号登录
                        //强制登录，踢下已登录终端
                        if (force != null && force.equalsIgnoreCase("true")) {
                            logger.debug("【用户登录】检测到同账号其他终端登录，强制登录，踢下已登录终端。");
                            //销毁之前登录的token
                            UtilTokenDealer.removeToken(existedToken);
                        } else {//询问是否强制登录
                            logger.error("【用户登录】检测到同账号其他终端登录，询问是否继续登录？");
                            return ResultFactory.create("3", "相同账号已在其他终端登录，请问是否继续登录？", null);
                        }
                    }
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }else{
            logger.debug("【用户登录】判断没有既存token。");
        }

        //4，token生成
        //生成本次登录token
        requestToken = UtilTokenDealer.makeToken(username);
        String tokenStr = UtilTokenDealer.getTokenStr(requestToken);
        HashMap map = new HashMap();
        map.put("user", user);
        map.put("token", tokenStr);
        //设置当前token的node属性，以后所有使用本token的请求，使用node属性指定的节点
        UtilTokenDealer.setTokenAttr(tokenStr,"node", node1);
        return ResultFactory.create("200","登录成功!",map);
    }


    /**
     * 用户登出
     * @return
     */
    @ApiComment("用户登出")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public Result logout(HttpServletRequest request, HttpServletResponse response) {

        logger.debug("【用户登出】开始");

        //移除token
        String tokeStr = (String)UtilRequestAttrHolder.getAttribute(request,"token");
        logger.debug("【用户登出】tokeStr: "+tokeStr);
        if( tokeStr == null ){
            logger.error("【错误】当前logout请求，没有配套的token，无法logout。");
            ResultFactory.create("0","当前用户登出成功",null);
        }
        UtilTokenDealer.removeToken(UtilTokenDealer.getToken(tokeStr));

        logger.debug("【用户登出】结束");

        return ResultFactory.create("0","当前用户登出成功",null);
    }

}
