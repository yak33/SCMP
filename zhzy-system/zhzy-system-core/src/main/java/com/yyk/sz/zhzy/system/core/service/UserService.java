package com.yyk.sz.zhzy.system.core.service;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.system.core.entity.GyUser;

import java.util.List;

/**
 * 用户业务接口
 * <p>定义用户的增删改查等操作<p>
 *
 * @author chutj
 */
public interface UserService {

    /**
     * 获取用户
     */
    public GyUser getById(String uuid);

    /**
     * 批量获取用户
     */
    public List<GyUser> getByIds(String ids);

    /**
     * 根据账号获取用户
     */
    public GyUser getByAccount(String account);

    /**
     * 用户分页查询（默认排序）
     */
    public Paging<GyUser> findByPage(int pageNumber);

    /**
     * 用户分页查询
     */
    public Paging<GyUser> findByPage(int pageNumber, int pageSize, String sortType, String searchText);

    /**
     * 条件查询全部用户
     */
    public List<GyUser> findAll(String filterUserName);

    /**
     * 根据组织机构code，查询该组织下的用户
     */
    public List<GyUser> findByOrganizationCode(String code);

    /**
     * 用户绑定组织机构
     */
    public void bindOrgs(String account, String organizationId);

    /**
     * 绑定用户-角色（向“角色-用户”关联表里插入绑定数据（如果该绑定不存在的话））
     */
    public void bindRoles(String userAccount, String roleCodes);

    /**
     * 删除用户
     * 物理删除
     */
    public void delete(String uuid);

    /**
     * 删除用户（批量删除）
     */
    public void deleteByIds(String ids);

    /**
     * 保存用户
     */
    public int save(GyUser entity);

    /**
     * 重设密码
     * @param uuid
     */
    public void restPwd(String uuid);

    /**
     * 检查数据库中是否已经存在指定用户账号
     * @param id 准备插入的用户记录id
     * @param account 准备插入的用户记录的用户账号
     * @return 存在：true  不存在：false
     */
    public boolean checkUserAccountExist(String id, String account);

    /**
     * 验证密码，验证DB中存储的密码（MD5密文）是否与参数密码（铭文）一致
     * @param id
     * @param passwd
     * @return
     */
    public boolean authPassword(String id, String passwd);

    List<GyUser> getAllUsers();

    int updateByPrimaryKeySelective(GyUser gyUser);

    List<GyUser> selectUser(GyUser gyUser);

    int updateByUUID(GyUser gyUser);

    int deleteByAccout(String usercode);

}
