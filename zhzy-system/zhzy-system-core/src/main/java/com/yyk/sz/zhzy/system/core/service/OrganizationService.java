package com.yyk.sz.zhzy.system.core.service;

import com.yyk.sz.zhzy.system.core.entity.SysOrganization;

import java.util.List;
import java.util.Map;

/**
 * 组织结构业务接口
 * <p>定义组织结构的增删改查等操作<p>
 * @author chutj
 *
 */
public interface OrganizationService {

	/**
	 * 取得组织机构详情
	 */
	public SysOrganization getById(String uuid);

	public SysOrganization getByCode(String code);

	public SysOrganization getParentOrg(SysOrganization org);

	/**
	 * 条件查询组织机构列表
	 */
	public List<SysOrganization> findAll(String filterOrgName);

	/**
	 * 组织机构保存
	 */
	public boolean save(SysOrganization entity);

	/**
	 * 组织机构删除
	 */
	public void delete(String uuid);

	/**
	 * 检查编码唯一性
	 * @param id
	 * @param code
	 * @return List
	 */
	public boolean checkOrg(String code, String id);

	public List<Map> findOrgUserTree(String filterOrgName);

	public List<Map> getByCodes(String... orgCodes);

}
