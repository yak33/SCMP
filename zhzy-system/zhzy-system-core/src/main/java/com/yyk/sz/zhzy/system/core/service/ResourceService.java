package com.yyk.sz.zhzy.system.core.service;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.system.core.entity.SysResource;

import java.util.List;
import java.util.Map;


/**
 * 资源业务接口
 * <p>定义资源的增删改查等操作<p>
 * @author chutj
 *
 */
public interface ResourceService {

	/**
	 * 获取资源
	 */
	public SysResource getById(String uuid);

	/**
	 * 查询分页列表（默认排序）
	 */
	public Paging<SysResource> findByPage(int pageNumber);

	/**
	 * 查询分页列表
	 */
	public Paging<SysResource> findByPage(int pageNum, int pageSize, String sortType);

	/**
	 * 条件查询资源列表
	 */
	public List<SysResource> findAll(String filterResourceName);


	/**
	 * 获取指定用户的资源
	 * @return
	 */
	public List<SysResource> findByUserAccount(String account);

	/**
	 * 获取指定角色的资源
	 * @return
	 */
	public List<SysResource> findByRoleCode(String code);

	/**
	 * 获取普通角色的资源
	 * @return
	 */
	public List<SysResource> findOriginalRoleResources();

	/*
	 * 删除资源，绑定用户和角色不能删除
	 */
	public void delete(String uuid);

	/**
	 * 批量删除资源，绑定用户和角色不能删除
	 */
	public void deleteByIds(String uuids);

	/**
	 * 保存资源
	 */
	public void save(SysResource resource);

	
//	public String getResourceTypeForSelect(String typeCode, String typeExist);

	
	public boolean checkResourceCodeExist(String code, String id);

	
	public List<Map> findResourceTree(String filterResourceName);
}
