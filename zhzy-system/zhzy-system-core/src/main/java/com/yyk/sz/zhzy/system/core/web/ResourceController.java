package com.yyk.sz.zhzy.system.core.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.common.base.utils.UtilUuid;
import com.yyk.sz.zhzy.system.common.Constants;
import com.yyk.sz.zhzy.system.core.entity.SysResource;
import com.yyk.sz.zhzy.system.core.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * 处理角色相关的请求
 */
@Api2Doc(id = "system.core.resourcecontroller", name = "权限系统-资源")
@ApiComment(seeClass = SysResource.class)
@Controller
@RequestMapping(ResourceController.BASE_PATH)
public class ResourceController {

	public static final String BASE_PATH = "/core/resource" ;

	@Autowired
    ResourceService resourceService;

    /**
     * index，测试用
     */
    @ApiComment("测试用")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ResponseBody
    public Result index() {
        return ResultFactory.create("0","权限系统-资源Controller 测试访问成功。",null);
    }

    /**
     * 获取资源树（可根据参数资源名过滤）
     *
     * @return
     */
	@ApiComment("获取资源树（可根据参数资源名过滤）")
	@RequestMapping(value="/list" ,method = RequestMethod.POST)
	@ResponseBody
	public Result listFilterResourceName(String filterResourceName){
        List<Map> resourceTree = resourceService.findResourceTree(filterResourceName);
        return ResultFactory.create(resourceTree);
	}

	/**
	 * 根据id取得对象
	 * @param id
	 * @return
	 */
    @ApiComment("根据id取得对象")
	@RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
	@ResponseBody
	public Result get(@PathVariable("id") String id){

		SysResource res = resourceService.getById(id);
        Map<String, Object> map = new HashMap<String,Object>();
		map.put("res", res);
		
		return ResultFactory.create(map);
	}

    /**
     * 获取指定角色拥有的资源
     * @param code 角色编码
     * @return
     */
    @ApiComment("获取指定角色拥有的资源")
    @RequestMapping(value="rescsbyrole/{code}" ,method = RequestMethod.GET)
    @ResponseBody
    public Result findResourcesByRoleCode(@PathVariable("code") String code){
        List<SysResource> resources = resourceService.findByRoleCode(code);
        return ResultFactory.create(resources);
    }
	
	/**
	 * 保存组织机构信息 ，id存在为更新，id不存在为新建
	 * @return
	 */
    @ApiComment("保存组织机构信息 ，id存在为更新，id不存在为新建")
	@RequestMapping(value="/save",method = RequestMethod.POST)
	@ResponseBody
	public Result save(@RequestParam(value = "code", required = false)String code
            ,@RequestParam(value = "name", required = true)String name
            ,@RequestParam(value = "parentid", required = true)String parentid
            ,@RequestParam(value = "sortno", required = false)int sortno
            ,@RequestParam(value = "bizsysid", required = false)String bizsysid
            ,@RequestParam(value = "level", required = false)int level
            ,@RequestParam(value = "abbname", required = false)String abbname){

        SysResource res = new SysResource();
        //资源编码，系统生成
        if( code == null || code.trim().length() == 0 ){
        	code = UtilUuid.uuid();
		}
        res.setCode(code);
        res.setName(name);
        res.setParentid(parentid);
        res.setSortno(sortno);
        res.setBizsysid(bizsysid);
        res.setLevel(level);
        res.setAbbname(abbname);

        resourceService.save(res);
		return ResultFactory.create(Constants.MESSAGE_PUBLIC_SAVE, res);
	}

	/**
	 * 删除组织机构
	 * @param id
	 * @return
	 */
    @ApiComment("删除组织机构")
	@RequestMapping(value="delete/{id}" ,method = RequestMethod.GET)
	@ResponseBody
	public Result delete(@PathVariable("id") String id){
		resourceService.delete(id);
		return ResultFactory.create(Constants.MESSAGE_PUBLIC_DELETE);
	}

    /**
     * 组织机构编码存在性校验
     * @param id
     * @param param
     * @return
     */
    @ApiComment("组织机构编码存在性校验")
	@RequestMapping(value="checkRescCode" ,method = RequestMethod.POST)
	@ResponseBody
	public String checkResourceCode(@RequestParam(value = "id",defaultValue="") String id,
			@RequestParam(value = "param") String param){
		String jsonString="{\"info\":\"通过信息验证！\",\"status\":\"y\"}";
		if(this.resourceService.checkResourceCodeExist(param, id)){
			jsonString="{\"info\":\"同应用下相同编码已存在\",\"status\":\"n\"}";
		}
		return jsonString;
	}

}
