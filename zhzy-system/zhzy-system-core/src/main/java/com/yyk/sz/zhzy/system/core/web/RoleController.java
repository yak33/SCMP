package com.yyk.sz.zhzy.system.core.web;

import com.terran4j.commons.api2doc.annotations.Api2Doc;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.common.base.result.Result;
import com.yyk.sz.common.base.result.ResultFactory;
import com.yyk.sz.zhzy.system.common.Constants;
import com.yyk.sz.zhzy.system.core.entity.SysRole;
import com.yyk.sz.zhzy.system.core.service.ResourceService;
import com.yyk.sz.zhzy.system.core.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * 处理角色相关的请求
 */
@Api2Doc(id = "system.core.rolecontroller", name = "权限系统-角色")
@ApiComment(seeClass = SysRole.class)
@Controller
@RequestMapping("/core/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService ;

	@Autowired
	private ResourceService resourceService ;

    /**
     * index，测试用
     */
    @ApiComment("测试用")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ResponseBody
    public Result index() {
        return ResultFactory.create("0","权限系统-角色Controller 测试访问成功。",null);
    }

	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @param sortType
	 * @return
	 */
	@ApiComment("分页查询")
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	@ResponseBody
	public Result list(@RequestParam(value = "pageNumber", defaultValue = "1") int pageNum
            ,@RequestParam(value = "pageSize", defaultValue = Constants.PAGE_SIZE+"") int pageSize
            ,@RequestParam(value = "sortType", defaultValue = "sortNo") String sortType
			,@RequestParam(value = "name",required = false) String name
	){
		Paging<SysRole> page = roleService.findByPage(pageNum, pageSize, sortType, name);
		return ResultFactory.create(page);
	}

	/**
	 * 查询全部角色(不分页)
	 * @return
	 */
	@ApiComment("查询全部角色(不分页)")
	@RequestMapping(value="/listAll" ,method = RequestMethod.POST)
	@ResponseBody
	public Result listAll(@RequestParam(value = "name",required = false)String filterRoleName){
		List<SysRole> list = roleService.findAll(filterRoleName);
		return ResultFactory.create(list);
	}

	/**
	 * 根据id取得角色对象
	 * @param id
	 * @return
	 */
	@ApiComment("查询全部角色(不分页)")
	@RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
	@ResponseBody
	public Result get(@PathVariable("id") String id){
		SysRole role = roleService.getById(id);
		return ResultFactory.create(role);
	}
	

	/**
	 * 保存角色
	 * @return
	 */
	@ApiComment("保存角色")
	@RequestMapping(value="/save",method = RequestMethod.POST)
	@ResponseBody
	public Result save(@RequestParam(value = "code",required = true)String code
			,@RequestParam(value = "name",required = true)String name
			,@RequestParam(value = "sortno",required = false)int sortno
			,@RequestParam(value = "roletype",required = false)int roletype
			,@RequestParam(value = "remark",required = false)String remark){

		SysRole role = new SysRole();
		role.setCode(code);
		role.setName(name);
		role.setSortno(sortno);
		role.setRoletype(roletype);
		role.setRemark(remark);

		roleService.save(role);
		return ResultFactory.create(Constants.MESSAGE_PUBLIC_SAVE);
	}
	/**
	 * 修改角色
	 * @return
	 */
	@ApiComment("修改角色")
	@RequestMapping(value="/updateRole",method = RequestMethod.POST)
	@ResponseBody
	public Result updateRole(@RequestParam(value = "uuid") String uuid
			,@RequestParam(value = "code")String code
			,@RequestParam(value = "name")String name
			,@RequestParam(value = "sortno",required = false)int sortno
			,@RequestParam(value = "roletype",required = false)int roletype
			,@RequestParam(value = "remark",required = false)String remark){
		if (code == null || "".equals(code)){
			return ResultFactory.create("角色编码不能为空!");
		}
		if (uuid == null || "".equals(uuid)){
			return ResultFactory.create("uuid不能为空!");
		}
		SysRole role = new SysRole();
		role.setUuid(uuid);
		role.setCode(code);
		role.setName(name);
		role.setSortno(sortno);
		role.setRoletype(roletype);
		role.setRemark(remark);

		roleService.updateByUUID(role);
		return ResultFactory.create(Constants.MESSAGE_PUBLIC_UPDATE);
	}
	
	/**
	 * 根据id删除角色
	 * @param id
	 * @return
	 */
	@ApiComment("根据id删除角色")
	@RequestMapping(value="/delete/{id}" ,method = RequestMethod.GET)
	@ResponseBody
	public Result delete(@PathVariable("id") String id){
		String message = roleService.delete(id);
		System.out.println(message);
		if ("删除成功！".equals(message)){
			return ResultFactory.create("0",message,null);
		}
		return ResultFactory.create("1",message,null);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@ApiComment("批量删除")
	@RequestMapping(value="/deleteByIds/{ids}" ,method = RequestMethod.GET)
	@ResponseBody
	public Result deleteByIds(@PathVariable("ids") String ids){
		roleService.deleteByIds(ids);
		return ResultFactory.create(Constants.MESSAGE_PUBLIC_DELETE);
	}

    /**
     * 获取指定用户拥有的角色
     * @param account
     * @return
     */
	@ApiComment("获取指定用户拥有的角色")
    @RequestMapping(value="/rolesbyaccount/{account}" ,method = RequestMethod.GET)
    @ResponseBody
    public Result findRolesByAccount(@PathVariable("account") String account){
        List<SysRole> roles = roleService.findByUserAccount(account);
        return ResultFactory.create(roles);
    }


	/**
	 * 绑定“角色-资源”
	 * @param roleCode 角色编码
	 * @param resourceCodes 资源编码（逗号拼接）
	 * @return
	 */
	@ApiComment("绑定“角色-资源”")
	@RequestMapping(value="/bindrescs" ,method = RequestMethod.POST)
	@ResponseBody
	public Result bindResources(
			@RequestParam("roleCode") String roleCode,
			@RequestParam(value = "resourceCodes",required = false) String resourceCodes){
		roleService.deleteByCode(roleCode);
		//如果不绑定任何资源，相当于清空此角色下的资源。
		if (resourceCodes != null && !"".equals(resourceCodes)){
			roleService.bindResources(roleCode, resourceCodes);
		}
		return ResultFactory.create(Constants.MESSAGE_PUBLIC_BIND);
	}

	/**
	 * 角色编码的唯一性校验
	 * @param id 前台路径中传入
	 * @param name  input文本框名称，validform。js中规定的
	 * @param param  input文本框输入值，validform。js中规定的
	 * @return
	 */
	@ApiComment("角色编码的唯一性校验")
	@RequestMapping(value="/checkRoleCode")
	@ResponseBody
	public String checkRoleCode(@RequestParam(value = "id",defaultValue="") String id,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "param") String param){
		String jsonString = "{\"info\":\"通过信息验证！\",\"status\":\"y\"}";
		if(roleService.checkRoleCodeExist(id, param)){
			jsonString = "{\"info\":\"此角色编码已存在！\",\"status\":\"n\"}";
		}
		return jsonString;
	}

}
