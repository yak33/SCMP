package com.yyk.sz.zhzy.system.core.service;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.system.common.BusinessException;
import com.yyk.sz.zhzy.system.common.Constants;
import com.yyk.sz.zhzy.system.core.entity.*;
import com.yyk.sz.zhzy.system.core.mapper.SysRoleMapper;
import com.yyk.sz.zhzy.system.core.mapper.SysRoleResourceMapper;
import com.yyk.sz.zhzy.system.core.mapper.SysUserRoleMapper;
import com.yyk.sz.zhzy.system.core.mappercust.SysRoleMapperCust;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 角色业务实现类<br>
 * <p>
 * 实现角色的增删改查，以及绑定资源用户操作
 * <p>
 *
 * @author chutj
 */
@Component
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysRoleMapperCust sysRoleMapperCust;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Autowired
    private SysRoleResourceMapper sysRoleResourceMapper;

    /**
     * 根据主键（uuid）查询角色
     */
    @Override
    public SysRole getById(String uuid) {
        return sysRoleMapper.selectByPrimaryKey(uuid);
    }

    /**
     * 根据角色编码（code）查询角色
     */
    @Override
    public SysRole getByCode(String code) {
        SysRoleExample sysRoleExample = new SysRoleExample();
        SysRoleExample.Criteria criteria = sysRoleExample.createCriteria();
        criteria.andCodeEqualTo(code);
        List<SysRole> roles = sysRoleMapper.selectByExample(sysRoleExample);
        if( roles == null || roles.size() == 0 ){
            return null;
        }
        return roles.get(0);
    }
    /**
     * 根据角色名称（name）查询角色
     */
    @Override
    public SysRole getByName(String name) {
        SysRoleExample sysRoleExample = new SysRoleExample();
        SysRoleExample.Criteria criteria = sysRoleExample.createCriteria();
        criteria.andNameEqualTo(name);
        List<SysRole> roles = sysRoleMapper.selectByExample(sysRoleExample);
        if( roles == null || roles.size() == 0 ){
            return null;
        }
        return roles.get(0);
    }
    /**
     * 分页查询角色列表（默认排序）
     */
    @Override
    public Paging<SysRole> findByPage(int pageNum, String name) {
        return this.findByPage(pageNum, Constants.PAGE_SIZE,
                Constants.DEFAULT_SORT, name);
    }

    /**
     * 分页查询角色列表
     */
    @Override
    public Paging<SysRole> findByPage(int pageNum, int pageSize, String sortType, String name) {
        Paging<SysRole> page = sysRoleMapperCust.listPage(pageNum, pageSize, sortType, name);
        return page;
    }

    /**
     * 查询角色列表
     */
    @Override
    public List<SysRole> findAll(String filterRoleName) {
        SysRoleExample sysRoleExample = new SysRoleExample();
        SysRoleExample.Criteria oCriteria = sysRoleExample.createCriteria();
        if( filterRoleName != null && filterRoleName.trim().length()>0 ) {
            oCriteria.andNameLike("%" + filterRoleName + "%");
        }
        sysRoleExample.setOrderByClause("sortNo asc");
        List<SysRole> list = this.sysRoleMapper.selectByExample(sysRoleExample);
        return list;
    }

    /**
     * 根据主键（uuid）删除角色，检查角色是否被绑定，如果绑定不能删除
     * 物理删除
     */
    @Override
    @Transactional
    public String delete(String primaryKey) {
        String message = null;
        SysRole role = sysRoleMapper.selectByPrimaryKey(primaryKey);

        SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
        SysUserRoleExample.Criteria userRoleCriteria = sysUserRoleExample.createCriteria();
        userRoleCriteria.andRolecodeEqualTo(role.getCode());
        List<SysUserRole> userRoles = sysUserRoleMapper.selectByExample(sysUserRoleExample);

        //判断角色是否有用户在用
        if (userRoles.isEmpty()) {
            //删除“角色-资源”关联
            SysRoleResourceExample sysRoleResourceExample = new SysRoleResourceExample();
            SysRoleResourceExample.Criteria roleResourceCriteria = sysRoleResourceExample.createCriteria();
            roleResourceCriteria.andRolecodeEqualTo(role.getCode());
            sysRoleResourceMapper.deleteByExample(sysRoleResourceExample);
            //删除“角色”
            sysRoleMapper.deleteByPrimaryKey(primaryKey);
            message = Constants.MESSAGE_PUBLIC_DELETE;
        } else {
            message = "角色[" + role.getName() + "]被绑定不能删除";
        }
        return message;
    }

    /**
     * 根据主键（uuid）批量删除
     */
    @Override
    @Transactional
    public void deleteByIds(String ids){
        if (StringUtils.contains(ids, ",")) {
            String[] idsArr = ids.split(",");
            for (int i = 0; i < idsArr.length; i++) {
                String message = delete(idsArr[i]);
                if( !Constants.MESSAGE_PUBLIC_DELETE.equalsIgnoreCase(message) ){
                    throw new BusinessException(message);//抛出异常
                }
            }
        }
    }

    /**
     * 保存角色
     */
    @Override
    @Transactional
    public void save(SysRole entity) {
        if( entity.getUuid() == null ){//新增
            if (this.checkRoleCodeExist(entity.getUuid(), entity.getCode())) {
                throw new BusinessException("此角色编码已存在");//抛出异常
            }
            sysRoleMapper.insert(entity);
        }else{//更新
            sysRoleMapper.updateByPrimaryKey(entity);
        }
    }

    /**
     * 绑定资源（向“角色-资源”关联表里插入绑定数据（如果该绑定不存在的话））
     */
    @Override
    @Transactional
    public void bindResources(String roleCode, String resourceCodes) {

        SysRoleResourceExample sysRoleResourceExample = new SysRoleResourceExample();
        SysRoleResourceExample.Criteria roleResourceCriteria = sysRoleResourceExample.createCriteria();
        roleResourceCriteria.andRolecodeEqualTo(roleCode);
        List<SysRoleResource> sysRoleResources = sysRoleResourceMapper.selectByExample(sysRoleResourceExample);

        for (String resourceCode : resourceCodes.split(",")) {
            boolean exist = false;
            for( SysRoleResource roleResource : sysRoleResources ){
                if( resourceCode.equalsIgnoreCase( roleResource.getResourcecode()) ){
                    exist = true;
                    break;
                }
            }
            if( !exist ){
                SysRoleResource sysRoleResource = new SysRoleResource();
                sysRoleResource.setRolecode(roleCode);
                sysRoleResource.setResourcecode(resourceCode);
                sysRoleResourceMapper.insert(sysRoleResource);
            }
        }
    }

    /**
     * 检查数据库中是否已经存在指定角色编码
     * @param id 准备插入的角色记录id
     * @param code 准备插入的角色记录的角色编码
     * @return 存在：true  不存在：false
     */
    @Override
    public boolean checkRoleCodeExist(String id, String code) {
        SysRoleExample roleExample = new SysRoleExample();
        SysRoleExample.Criteria roleCriteria = roleExample.createCriteria();
        if( id != null ) {
            roleCriteria.andUuidNotEqualTo(id);
        }
        roleCriteria.andCodeEqualTo(code);
        List<SysRole> list = this.sysRoleMapper.selectByExample(roleExample);
        if (list != null && list.size() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public int updateByUUID(SysRole record) {
        if (this.checkRoleCodeExist(record.getUuid(), record.getCode())) {
            throw new BusinessException("此角色编码已存在");//抛出异常
        }
        return sysRoleMapper.updateByUUID(record);
    }

    @Override
    public int deleteByCode(String roleCode) {
        return sysRoleMapper.deleteByCode(roleCode);
    }

    /**
     * 根据用户账号，获取其拥有的所有角色。
     * （注意，此方法的实现使用的是多SQL查询，可以优化为单SQL查询。20181129未优化）
     */
    @Override
    public List<SysRole> findByUserAccount(String account) {

        SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
        SysUserRoleExample.Criteria userRoleCriteria = sysUserRoleExample.createCriteria();
        userRoleCriteria.andUseraccountEqualTo(account);
        List<SysUserRole> userRoles = sysUserRoleMapper.selectByExample(sysUserRoleExample);

        List<SysRole> result = new ArrayList<SysRole>();
        for( SysUserRole userRole : userRoles ){
            String roleCode = userRole.getRolecode();
            result.add( this.getByCode(roleCode) );
        }

        return result;
    }
}
