package com.yyk.sz.zhzy.system.core.service;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.system.common.BusinessException;
import com.yyk.sz.zhzy.system.common.Constants;
import com.yyk.sz.zhzy.system.common.MD5Util;
import com.yyk.sz.zhzy.system.core.entity.*;
import com.yyk.sz.zhzy.system.core.mapper.GyUserMapper;
import com.yyk.sz.zhzy.system.core.mapper.SysUserResourceMapper;
import com.yyk.sz.zhzy.system.core.mapper.SysUserRoleMapper;
import com.yyk.sz.zhzy.system.core.mappercust.SysUserMapperCust;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户业务实现类 实现用户的增删改查，以及绑定角色资源操作
 *
 * @author chutj
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private GyUserMapper gyUserMapper;

    @Autowired
    private SysUserMapperCust sysUserMapperCust;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Autowired
    private SysUserResourceMapper sysUserResourceMapper;

    @Autowired
    private RoleService roleService;

    /**
     * 获取用户
     */
    @Override
    public GyUser getById(String uuid) {
        GyUser user = gyUserMapper.selectByPrimaryKey(uuid);
        return user;
    }

    @Override
    public List<GyUser> getByIds(String ids) {
        List<GyUser> result = new ArrayList<>();
        for( String uuid : ids.split(",") ){
            GyUser user = getById(uuid);
            if( user != null ){
                result.add(user);
            }
        }
        return result;
    }

    /**
     * 根据账号获取用户
     */
    public GyUser getByAccount(String usercode) {
        GyUserExample gyUserExample = new GyUserExample();
        GyUserExample.Criteria userCriteria = gyUserExample.createCriteria();
        userCriteria.andUsercodeEqualTo(usercode);
        List<GyUser> list = gyUserMapper.selectByExample(gyUserExample);
        if( list == null || list.size() == 0 ){
            return null;
        }
        return list.get(0);
    }

    /**
     * 用户分页查询（默认排序）
     */
    @Override
    public Paging<GyUser> findByPage(int pageNumber) {
        return this.findByPage(pageNumber, Constants.PAGE_SIZE,
                Constants.DEFAULT_SORT,"");
    }

    /**
     * 用户分页查询
     */
    @Override
    public Paging<GyUser> findByPage(int pageNumber, int pageSize, String sortType, String searchText) {
        Paging<GyUser> page = sysUserMapperCust.listPage(pageNumber, pageSize, sortType, searchText);
        return page;
    }

    /**
     * 条件查询全部用户
     */
    @Override
    public List<GyUser> findAll(String filterUserName) {
        GyUserExample gyUserExample = new GyUserExample();
        GyUserExample.Criteria oCriteria = gyUserExample.createCriteria();
        if( filterUserName != null && filterUserName.trim().length()>0 ) {
            oCriteria.andUsernameLike("%" + filterUserName + "%");
        }
        List<GyUser> list = gyUserMapper.selectByExample(gyUserExample);
        return list;
    }

    /**
     * 根据组织机构code，查询该组织下的用户
     */
    @Override
    public List<GyUser> findByOrganizationCode(String code){
        GyUserExample userExample = new GyUserExample();
        GyUserExample.Criteria uCriteria = userExample.createCriteria();
        uCriteria.andDeptcodeEqualTo(code);
        List<GyUser> users = gyUserMapper.selectByExample(userExample);
        return users;
    }

    /**
     * 用户绑定组织机构
     */
    @Override
    @Transactional
    public void bindOrgs(String usercode, String deptcode) {
        GyUser user = getByAccount(usercode);
        user.setDeptcode(deptcode);
        gyUserMapper.updateByPrimaryKey(user);
    }

    /**
     * 绑定用户-角色（向“角色-用户”关联表里插入绑定数据（如果该绑定不存在的话））
     */
    @Override
    @Transactional
    public void bindRoles(String userAccount, String roleCodes) {

        SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
        SysUserRoleExample.Criteria userRoleCriteria = sysUserRoleExample.createCriteria();
        userRoleCriteria.andUseraccountEqualTo(userAccount);
        List<SysUserRole> sysUserRoles = sysUserRoleMapper.selectByExample(sysUserRoleExample);

        for (String roleCode : roleCodes.split(",")) {
            boolean exist = false;
            for( SysUserRole userRole : sysUserRoles ){
                if( roleCode.equalsIgnoreCase( userRole.getRolecode()) ){
                    exist = true;
                    break;
                }
            }
            if( !exist ){
                SysUserRole sysUserRole = new SysUserRole();
                sysUserRole.setRolecode(roleCode);
                sysUserRole.setUseraccount(userAccount);
                sysUserRoleMapper.insert(sysUserRole);
            }
        }

    }

    /**
     * 删除用户
     * 物理删除
     */
    @Override
    @Transactional
    public void delete(String uuid) {
        gyUserMapper.deleteByPrimaryKey(uuid);
    }

    /**
     * 删除用户（批量删除）
     */
    @Override
    @Transactional
    public void deleteByIds(String ids) {
        for (String id : ids.split(",")) {
            delete(id);
        }
    }

    /**
     * 保存用户
     */
    @Override
    @Transactional
    public int save(GyUser entity) {
        //验证账户唯一性
        if (this.checkUserAccountExist(entity.getUuid(), entity.getUsercode())) {
            throw new BusinessException("此账户已存在");//抛出异常
        }
        //新建
        if (StringUtils.isEmpty(entity.getUuid())) {
            //如果没有传自己的密码，就设置为初始密码
            if (entity.getPassword() == null || "".equals(entity.getPassword())){
                //初始密码
                entity.setPassword(MD5Util.MD5(Constants.USER_ORIGINAL_PASSWORD));
            }
            String name = entity.getUsercode();
            entity.setAlias(name + ",");

            //默认绑定 普通角色
            String roleCode = Constants.USER_ORIGINAL_ROLECODE; //basic
            if (entity.getFlag().equals("超级管理员")){
                roleCode = entity.getFlag();
            }

            SysRole role = roleService.getByName(roleCode);
            System.out.println("role.getUuid()==>:"+role.getUuid());
            this.bindRoles(entity.getUsercode(), role.getCode());
            int insert = gyUserMapper.insert(entity);
            return insert;
        }else{//更新
            //设置密码
            if( entity.getPassword() == null ) {
                entity.setPassword(MD5Util.MD5(Constants.USER_ORIGINAL_PASSWORD));
            }
            int update = gyUserMapper.updateByPrimaryKey(entity);
            return update;
        }

    }

    /**
     * 重设密码
     * @param uuid
     */
    @Override
    @Transactional
    public void restPwd(String uuid) {
        GyUser user = gyUserMapper.selectByPrimaryKey(uuid);
        user.setPassword(MD5Util.MD5(Constants.USER_ORIGINAL_PASSWORD));
        gyUserMapper.updateByUUID(user);
    }

    /**
     * 检查数据库中是否已经存在指定用户账号
     * @param id 准备插入的用户记录id
     * @param account 准备插入的用户记录的用户账号
     * @return 存在：true  不存在：false
     */
    @Override
    public boolean checkUserAccountExist(String id, String account) {
        GyUserExample userExample = new GyUserExample();
        GyUserExample.Criteria userCriteria = userExample.createCriteria();
        if( id != null ) {
            userCriteria.andUuidNotEqualTo(id);
        }
        userCriteria.andUsercodeEqualTo(account);
        List<GyUser> list = gyUserMapper.selectByExample(userExample);
        if (list != null && list.size() > 0) {
            return true;
        }
        return false;
    }

    /**
     * 验证密码，验证DB中存储的密码（MD5密文）是否与参数密码（铭文）一致
     * @param id
     * @param passwd
     * @return
     */
    @Override
    public boolean authPassword(String id, String passwd) {
        GyUser user = gyUserMapper.selectByPrimaryKey(id);
        if (user.getPassword().equals(MD5Util.MD5(passwd))) {
            return true;
        }
        return false;
    }

    @Override
    public List<GyUser> getAllUsers() {
        return gyUserMapper.getAllUsers();
    }

    @Override
    public int updateByPrimaryKeySelective(GyUser gyUser) {
        return gyUserMapper.updateByPrimaryKeySelective(gyUser);
    }

    @Override
    public List<GyUser> selectUser(GyUser gyUser) {
        return gyUserMapper.selectUser(gyUser);
    }

    @Override
    public int updateByUUID(GyUser gyUser) {
        //验证账户唯一性
        if (this.checkUserAccountExist(gyUser.getUuid(), gyUser.getUsercode())) {
            throw new BusinessException("此账户已存在");//抛出异常
        }
        return gyUserMapper.updateByUUID(gyUser);
    }

    @Override
    public int deleteByAccout(String usercode) {
        return gyUserMapper.deleteByAccout(usercode);
    }

}
