package com.yyk.sz.zhzy.system.core.service;

import com.yyk.sz.zhzy.system.common.BusinessException;
import com.yyk.sz.zhzy.system.common.Constants;
import com.yyk.sz.zhzy.system.core.entity.*;
import com.yyk.sz.zhzy.system.core.mapper.GyUserMapper;
import com.yyk.sz.zhzy.system.core.mapper.SysOrganizationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 组织机构业务实现类
 * 实现机织结构的增删改查，以及绑定角色用户操作
 * 
 * @author chutj
 * 
 */
@Component
@Transactional(readOnly=true)
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private SysOrganizationMapper sysOrganizationMapper;

	@Autowired
	private GyUserMapper gyUserMapper;

	@Autowired
	private UserService userService;

	/*
	 * 取得组织机构详情
	 * @see com.chrhc.projects.uiap.core.service.OrganizationService#get(java.lang.String)
	 */
	@Override
	public SysOrganization getById(String uuid) {
		return sysOrganizationMapper.selectByPrimaryKey(uuid);
	}

	@Override
	public SysOrganization getByCode(String code) {
		SysOrganizationExample organizationExample = new SysOrganizationExample();
		SysOrganizationExample.Criteria oCriteria = organizationExample.createCriteria();
		oCriteria.andCodeEqualTo(code);
		List<SysOrganization> orgs = sysOrganizationMapper.selectByExample(organizationExample);
		if( orgs == null || orgs.size() == 0 ){
			return null;
		}
		return orgs.get(0);
	}

	@Override
	public SysOrganization getParentOrg(SysOrganization org) {
		String pid = org.getParentid();
		if( pid == null || pid.equalsIgnoreCase("0") ){
			return null;
		}
		return getById(pid);
	}

	/**
	 * 条件查询组织机构列表
	 */
	@Override
	public List<SysOrganization> findAll(String filterOrgName) {
		SysOrganizationExample organizationExample = new SysOrganizationExample();
        SysOrganizationExample.Criteria oCriteria = organizationExample.createCriteria();
        if( filterOrgName != null && filterOrgName.trim().length()>0 ) {
            oCriteria.andNameLike("%" + filterOrgName + "%");
        }
        List<SysOrganization> orgs = sysOrganizationMapper.selectByExample(organizationExample);
		return orgs;
	}

	/**
	 * 组织机构保存
	 */
	@Override
	@Transactional
	public boolean save(SysOrganization entity) {
		if(this.checkOrg(entity.getCode(),entity.getUuid())){
			throw new BusinessException("此机构编码已存在");//抛出异常
		}
		//设置上级机构
		String pid=entity.getParentid();

		int saveCount = sysOrganizationMapper.insert(entity);
		if( saveCount != 1 ){
			return false;
		}
		
		//设置orgpath
		String orgpath = Constants.ORG_SPLITER + entity.getUuid() ;
		SysOrganization pOrg = getParentOrg(entity);
		if(pOrg!=null){
			orgpath = pOrg.getPath() + orgpath ;
		}else{
			orgpath = entity.getUuid() ;
		}
		entity.setPath(orgpath);
		return true;
	}

	/**
	 * 组织机构删除
	 */
	@Override
	@Transactional
	public void delete(String uuid){

		//检测是否存在下级机构
		SysOrganizationExample organizationExample = new SysOrganizationExample();
		SysOrganizationExample.Criteria oCriteria = organizationExample.createCriteria();
		oCriteria.andParentidEqualTo(uuid);
		List<SysOrganization> childOrgs = sysOrganizationMapper.selectByExample(organizationExample);

		if(childOrgs!=null && childOrgs.size()>0){
			throw new BusinessException("组织机构存在下级机构不能删除");//抛出异常
		}

		//检测是否存在用户
		SysOrganization org = getById(uuid);
		String code = org.getCode();

		GyUserExample userExample = new GyUserExample();
		GyUserExample.Criteria uCriteria = userExample.createCriteria();
		uCriteria.andDeptcodeEqualTo(code);
		List<GyUser> users = gyUserMapper.selectByExample(userExample);

		if(users!=null && users.size()>0){
			throw new BusinessException("组织机构存在用户不能删除");//抛出异常 
		}

		//删除
		sysOrganizationMapper.deleteByPrimaryKey(uuid);
	}


	/**
	 * 检查编码唯一性
	 * @param id
	 * @param code
	 * @return List
	 */
	@Override
	public boolean checkOrg(String code, String id) {
		SysOrganizationExample organizationExample = new SysOrganizationExample();
		SysOrganizationExample.Criteria oCriteria = organizationExample.createCriteria();
		oCriteria.andCodeEqualTo(code);
		if( id != null ){
			oCriteria.andUuidNotEqualTo(id);
		}
		List<SysOrganization> organizations = sysOrganizationMapper.selectByExample(organizationExample);
		if( organizations!= null && organizations.size() > 0 ){
			return true;
		}
		return false;
	}

	@Override
	public List<Map> findOrgUserTree(String filterOrgName) {
		List<SysOrganization> list = this.findAll(filterOrgName);
		List<Map> tree = new ArrayList<Map>();
		Map<String, Object> map ; 
		for (SysOrganization org : list) {
			map = new HashMap<String, Object>();
			map.put("id", org.getUuid());
				map.put("pId", org.getParentid());
				List<GyUser> users = userService.findByOrganizationCode(org.getCode());
				for(GyUser user:users){
					Map<String, Object> childMap= new HashMap<String, Object>();
					childMap.put("id", user.getUuid());
					childMap.put("pId", org.getUuid());
					childMap.put("name", user.getUsername());
					childMap.put("type", "user");
					tree.add(childMap);
				}
			map.put("type","org");
			map.put("name", org.getName());
			tree.add(map);
		}
		return tree;
	}

	@Override
	public List<Map> getByCodes(String... orgCodes) {

		List<String> codes = new ArrayList<>();
		for (String orgCode:orgCodes) {
			codes.add(orgCode);
		}

		SysOrganizationExample organizationExample = new SysOrganizationExample();
		SysOrganizationExample.Criteria oCriteria = organizationExample.createCriteria();
		oCriteria.andCodeIn(codes);
		List<SysOrganization> list = sysOrganizationMapper.selectByExample(organizationExample);

		List<Map> orgMaps = new ArrayList<>();
		if(list!=null && list.size()>0){
			for (SysOrganization org : list) {
				Map orgMap = new HashMap();
				orgMap.put("id",org.getUuid());
				orgMap.put("orgCode",org.getCode());
				orgMap.put("name",org.getName());
				orgMap.put("orgPath",org.getPath());
				orgMap.put("orgRemark",org.getRemark());
				orgMap.put("sortNo",org.getSortno());
				orgMaps.add(orgMap);
			}
		}
		return orgMaps;
	}

}

