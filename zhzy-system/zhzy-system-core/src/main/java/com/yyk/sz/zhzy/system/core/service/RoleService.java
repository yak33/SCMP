package com.yyk.sz.zhzy.system.core.service;



import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.system.core.entity.SysRole;

import java.util.List;
import java.util.Map;

/**
 * 角色业务接口
 * <p>定义角色的增删改查等操作<p>
 * @author chutj
 *
 */ 
public interface RoleService {

	/**
	 * 根据主键（uuid）查询角色
	 */
	public SysRole getById(String uuid);

	/**
	 * 根据角色编码（code）查询角色
	 */
	public SysRole getByCode(String code);
	/**
	 * 根据角色名称（name）查询角色
	 */
	public SysRole getByName(String code);


	/**
	 * 分页查询角色列表（默认排序）
	 */
	public Paging<SysRole> findByPage(int pageNum, String name);

	/**
	 * 分页查询角色列表
	 */
	public Paging<SysRole> findByPage(int pageNum, int pageSize, String sortType, String name);

	/**
	 * 根据用户账号，获取其拥有的所有角色。
	 * （注意，此方法的实现使用的是多SQL查询，可以优化为单SQL查询。20181129未优化）
	 */
	public List<SysRole> findByUserAccount(String account);

	/**
	 * 查询角色列表
	 */
	public List<SysRole> findAll(String filterRoleName);

	/**
	 * 根据主键（uuid）删除角色，检查角色是否被绑定，如果绑定不能删除
	 */
	public String delete(String primaryKey);

	/**
	 * 根据主键（uuid）批量删除
	 */
	public void deleteByIds(String ids);

	/**
	 * 保存角色
	 */
	public void save(SysRole entity);

	/**
	 * 绑定资源（向“角色-资源”关联表里插入绑定数据（如果该绑定不存在的话））
	 */
	public void bindResources(String roleCode, String resourceCodes);

	/**
	 * 检查数据库中是否已经存在指定角色编码
	 * @param id 准备插入的角色记录id
	 * @param code 准备插入的角色记录的角色编码
	 * @return 存在：true  不存在：false
	 */
	public boolean checkRoleCodeExist(String id, String code);

	int updateByUUID(SysRole record);

	int deleteByCode(String roleCode);
}
