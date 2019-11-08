package com.yyk.sz.zhzy.system.core.web;

import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.system.common.Constants;
import com.yyk.sz.zhzy.system.core.entity.SysOrganization;
import com.yyk.sz.zhzy.system.core.service.OrganizationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;


/**
 * 处理组织机构相关的请求等，主要用于组织机构管理模块，包括对组织机构的增删改查等操作
 * @author lhw
 */
@Controller
@RequestMapping("/core/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService orgService;


    /**
     * index，测试用
     */
    @ApiComment("测试用")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ResponseBody
    public Result index() {
        return ResultFactory.create("0","权限系统-组织机构 测试访问成功。",null);
    }


    /**
     * 根据查询条件获取符合要求的组织机构树
     *
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ResponseBody
    public Result listFilterOrgName(String filterOrgName) {
        List<Map> orgUserTree = orgService.findOrgUserTree(filterOrgName);
        return ResultFactory.create(orgUserTree);
    }


    /**
     * 根据id取得对象
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result get(@PathVariable("id") String id) {

        SysOrganization org = orgService.getById(id);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("org", org);

        return ResultFactory.create(map);
    }

    /**
     * 保存组织机构信息 ，id存在为更新，id不存在为新建
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public Result save(@RequestParam(value = "code", required = true)String code
            ,@RequestParam(value = "name", required = true)String name
            ,@RequestParam(value = "parentid", required = true)String parentid
            ,@RequestParam(value = "sortno", required = false)int sortno
            ,@RequestParam(value = "remark", required = false)String remark
            ,@RequestParam(value = "path", required = false)String path
            ,@RequestParam(value = "leader", required = false)String leader) {

        SysOrganization org = new SysOrganization();
        org.setCode(code);
        org.setName(name);
        org.setParentid(parentid);
        org.setSortno(sortno);
        org.setRemark(remark);
        org.setPath(path);
        org.setLeader(leader);

        boolean saved = orgService.save(org);
        if( saved ){
            return ResultFactory.create(Constants.MESSAGE_PUBLIC_SAVE, org);
        }
        return ResultFactory.create(Constants.MESSAGE_PUBLIC_SAVE_FAILED);
    }


    /**
     * 删除组织机构
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result delete(@PathVariable("id") String id) {
        orgService.delete(id);
        return ResultFactory.create(Constants.MESSAGE_PUBLIC_DELETE);
    }

    /**
     * 编码唯一性校验
     * @return
     */
    @RequestMapping(value = "checkorg", method = RequestMethod.POST)
    @ResponseBody
    public String checkOrg(@RequestParam(value = "id", defaultValue = "") String id,
                           @RequestParam(value = "parentid", defaultValue = "root") String parentid,
                           @RequestParam(value = "name") String name,
                           @RequestParam(value = "param") String param) {
        //，{"info":"demo info","status":"y"}
        String jsonString = "{\"info\":\"通过信息验证！\",\"status\":\"y\"}";
        if (param != null && !param.contentEquals("")) {
            SysOrganization org = orgService.getByCode(param);//this.resourceService.checkResourceCodeExist(param, bizsysid,id)
            if (org != null) {
                jsonString = "{\"info\":\"该机构编码已存在\",\"status\":\"n\"}";
            }
        }
		/*if(this.orgService.checkOrg(id, parentid,param)){
			jsonString="{\"info\":\"同机构下相同编码已存在\",\"status\":\"n\"}";
		}*/
        return jsonString;
    }

    @RequestMapping(value = "getByCode", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Result getByCode(@RequestParam(value = "orgCode") String orgCode) {
        return ResultFactory.create(orgService.getByCodes(StringUtils.split(orgCode, ",")));
    }


}
