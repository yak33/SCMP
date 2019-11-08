package com.yyk.sz.zhzy.system.core.service;

import com.yyk.sz.common.base.domain.Paging;
import com.yyk.sz.zhzy.system.common.BusinessException;
import com.yyk.sz.zhzy.system.common.Constants;
import com.yyk.sz.zhzy.system.common.utils.Cn2Spell;
import com.yyk.sz.zhzy.system.core.entity.*;
import com.yyk.sz.zhzy.system.core.mapper.SysResourceMapper;
import com.yyk.sz.zhzy.system.core.mapper.SysRoleResourceMapper;
import com.yyk.sz.zhzy.system.core.mapper.SysUserRoleMapper;
import com.yyk.sz.zhzy.system.core.mappercust.SysResourceMapperCust;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


/**
 * 资源业务实现类 ,资源的增删改查，以及绑定角色用户操作
 *
 * @author lhw
 */
@Component
@Transactional
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private SysResourceMapper sysResourceMapper;

    @Autowired
    private SysResourceMapperCust sysResourceMapperCust;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Autowired
    private SysRoleResourceMapper sysRoleResourceMapper;

    /**
     * 获取资源
     */
    @Override
    public SysResource getById(String uuid) {
        SysResource resource = sysResourceMapper.selectByPrimaryKey(uuid);
        return resource;
    }

    /**
     * 查询分页列表（默认排序）
     */
    @Override
    public Paging<SysResource> findByPage(int pageNumber) {
        return this.findByPage( pageNumber, Constants.PAGE_SIZE,
                Constants.DEFAULT_SORT);
    }

    /**
     * 查询分页列表
     */
    @Override
    public Paging<SysResource> findByPage(int pageNum, int pageSize, String sortType) {
        Paging<SysResource> page = sysResourceMapperCust.listPage(pageNum, pageSize, sortType);
        return page;
    }

    /**
     * 条件查询资源列表
     */
    @Override
    public List<SysResource> findAll(String filterResourceName) {
        SysResourceExample sysResourceExample = new SysResourceExample();
        SysResourceExample.Criteria rCriteria = sysResourceExample.createCriteria();
        if( filterResourceName != null && filterResourceName.trim().length()>0 ) {
            rCriteria.andNameLike("%" + filterResourceName + "%");
        }
        sysResourceExample.setOrderByClause("sortNo asc, SysCreateDate");
        List<SysResource> list = this.sysResourceMapper.selectByExample(sysResourceExample);
        return list;
    }

    /**
     * 获取指定用户的资源
     * @return
     */
    @Override
    public List<SysResource> findByUserAccount(String account) {

        //从“用户-角色”关联表中获取用户所有的角色编码
        SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
        SysUserRoleExample.Criteria urCriteria = sysUserRoleExample.createCriteria();
        urCriteria.andUseraccountEqualTo(account);
        List<SysUserRole> userRoles = sysUserRoleMapper.selectByExample(sysUserRoleExample);

        List<String> roleCodes = new ArrayList<>();
        userRoles.forEach(userRole->roleCodes.add(userRole.getRolecode()));

        //从“角色-资源”关联表中获取对应的所有的资源编码
        SysRoleResourceExample sysRoleResourceExample = new SysRoleResourceExample();
        SysRoleResourceExample.Criteria rrCriteria = sysRoleResourceExample.createCriteria();
        rrCriteria.andRolecodeIn(roleCodes);
        List<SysRoleResource> roleResources = sysRoleResourceMapper.selectByExample(sysRoleResourceExample);

        List<String> resourceCodes = new ArrayList<>();
        roleResources.forEach(roleResource->resourceCodes.add(roleResource.getResourcecode()));

        //根据资源编码，获取所有的资源
        SysResourceExample sysResourceExample = new SysResourceExample();
        SysResourceExample.Criteria rCriteria = sysResourceExample.createCriteria();
        rCriteria.andCodeIn(resourceCodes);
        List<SysResource> resources = sysResourceMapper.selectByExample(sysResourceExample);

        return resources;
    }

    /**
     * 获取指定角色的资源
     * @return
     */
    @Override
    public List<SysResource> findByRoleCode(String code) {

        //从“角色-资源”关联表中获取对应的所有的资源编码
        SysRoleResourceExample sysRoleResourceExample = new SysRoleResourceExample();
        SysRoleResourceExample.Criteria rrCriteria = sysRoleResourceExample.createCriteria();
        rrCriteria.andRolecodeEqualTo(code);
        List<SysRoleResource> roleResources = sysRoleResourceMapper.selectByExample(sysRoleResourceExample);

        List<String> resourceCodes = new ArrayList<>();
        roleResources.forEach(roleResource->resourceCodes.add(roleResource.getResourcecode()));
        if (resourceCodes == null || resourceCodes.size()<=0){
            resourceCodes.add("9999999");
        }
        //根据资源编码，获取所有的资源
        SysResourceExample sysResourceExample = new SysResourceExample();
        SysResourceExample.Criteria rCriteria = sysResourceExample.createCriteria();
        rCriteria.andUuidIn(resourceCodes);
        List<SysResource> resources = sysResourceMapper.selectByExample(sysResourceExample);

        return resources;
    }

    /**
     * 获取普通角色的资源
     * @return
     */
    @Override
    public List<SysResource> findOriginalRoleResources() {

        String roleCode = Constants.USER_ORIGINAL_ROLECODE;

        //从“角色-资源”关联表中获取对应的所有的资源编码
        SysRoleResourceExample sysRoleResourceExample = new SysRoleResourceExample();
        SysRoleResourceExample.Criteria rrCriteria = sysRoleResourceExample.createCriteria();
        rrCriteria.andRolecodeEqualTo(roleCode);
        List<SysRoleResource> roleResources = sysRoleResourceMapper.selectByExample(sysRoleResourceExample);

        List<String> resourceCodes = new ArrayList<>();
        roleResources.forEach(roleResource->resourceCodes.add(roleResource.getResourcecode()));

        //根据资源编码，获取所有的资源
        SysResourceExample sysResourceExample = new SysResourceExample();
        SysResourceExample.Criteria rCriteria = sysResourceExample.createCriteria();
        rCriteria.andCodeIn(resourceCodes);
        List<SysResource> resources = sysResourceMapper.selectByExample(sysResourceExample);

        return resources;
    }

    /*
     * 删除资源，绑定用户和角色不能删除
     *
     * @see
     * com.chrhc.projects.uiap.core.service.ResourceService#delete(java.lang
     * .String)
     */
    @Override
    @Transactional
    public void delete(String uuid) {
        SysResource resource = sysResourceMapper.selectByPrimaryKey(uuid);

        SysResourceExample resourceExample = new SysResourceExample();
        SysResourceExample.Criteria rCriteria = resourceExample.createCriteria();
        rCriteria.andParentidEqualTo(uuid);
        List<SysResource> childResources = sysResourceMapper.selectByExample(resourceExample);
        System.out.println("用上面的sql哟~~");
        if (childResources != null && childResources.size() > 0) {
            throw new BusinessException("资源[" + resource.getName() + "]有子资源不能删除");//抛出异常
        } else {
            sysResourceMapper.deleteByPrimaryKey(uuid);
        }
    }

    /**
     * 批量删除资源，绑定用户和角色不能删除
     *
     * @see .lang.String)
     */
    @Override
    @Transactional
    public void deleteByIds(String uuids) {
        for (String uuid : uuids.split(",")) {
            delete(uuid);
        }
    }

    /**
     * 获取父资源
     * @param resource
     * @return
     */
    private SysResource getParentResource(SysResource resource){

        String parentId = resource.getParentid();
        if(  parentId== null || parentId.equalsIgnoreCase("-1") ){
            return null;
        }

        SysResource parentResource = sysResourceMapper.selectByPrimaryKey(parentId);
        return parentResource;
    }

    /**
     * 获取层数
     * @param resource
     * @return
     */
    private int getRescLevel(SysResource resource) {
        int level = 0;
        SysResource parentResource = getParentResource(resource);
        while( null != parentResource ){
            level++;
            parentResource = getParentResource(parentResource);
        }
        return level;
    }

    /**
     * 保存资源
     */
    @Override
    @Transactional
    public void save(SysResource resource) {
        if( resource.getUuid() == null ) {//新增
            if (!this.checkResourceCodeExist(resource.getCode(), resource.getUuid())) {
                if (resource.getParentid() == null) {
                    resource.setParentid("0");//根节点下的资源
                }
                resource.setLevel(getRescLevel(resource));
                if (resource.getName() != null) {
                    /*获取名称拼音缩写*/
                    String abbName = Cn2Spell.converterToFirstSpell(resource.getName());
                    resource.setAbbname(abbName);
                }
                sysResourceMapper.insert(resource);
            } else {
                throw new BusinessException("该资源编码已存在，无法保存");
            }
        }else{
            sysResourceMapper.updateByPrimaryKey(resource);
        }
    }

    @Override
    public boolean checkResourceCodeExist(String code, String id) {
        SysResourceExample resourceExample = new SysResourceExample();
        SysResourceExample.Criteria rCriteria = resourceExample.createCriteria();
        rCriteria.andCodeEqualTo(code);
        if( id != null ){
            rCriteria.andUuidNotEqualTo(id);
        }
        List<SysResource> resources = sysResourceMapper.selectByExample(resourceExample);
        if (resources != null && resources.size() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<Map> findResourceTree(String filterResourceName) {
        List<SysResource> resList = this.findAll(filterResourceName);
        System.out.println(resList.size());
        List<Map> tree = new ArrayList<Map>();
        Map<String, Object> rootNode = new HashMap<String, Object>();
        rootNode.put("id", "0");
        rootNode.put("name", "全部应用资源");
        rootNode.put("type", "root");
        rootNode.put("nocheck", "true");
        rootNode.put("pId","-1");
        tree.add(rootNode);
        Map<String, Object> childMap;
        for (SysResource resource : resList) {
            childMap = new HashMap<String, Object>();
            childMap.put("id", resource.getUuid());
            childMap.put("name", resource.getName());
            childMap.put("type", "resource");

            childMap.put("SortNo", resource.getSortno());
            childMap.put("code", resource.getCode());
            childMap.put("pId", resource.getParentid());

            /* 添资源名称缩写 */
            childMap.put("abbName", resource.getAbbname());
            tree.add(childMap);
        }
        return tree;
    }

//    @Override
//    public List<SysResource> findResourceTree(String filterResourceName) {
//        List<SysResource> resList = this.findAll(filterResourceName);
//        System.out.println(resList.size());
//        List<SysResource> resultList = this.listGetStree(resList);
//        return resultList;
//    }
//
//    //生成树形结构
//    private static List<SysResource> listGetStree(List<SysResource> list) {
//        List<SysResource> treeList = new ArrayList<SysResource>();
//        SysResource rootNode = new SysResource();
//        rootNode.setUuid("0");
//        rootNode.setName("全部应用资源");
//        treeList.add(rootNode);
//        for (SysResource tree : list) {
//            //找到子
//            for (SysResource treeNode : list) {
//                System.out.println(treeNode.getParentid()+" ; "+tree.getUuid());
//                if (treeNode.getParentid() == tree.getUuid()) {
//                    if (tree.getChildren() == null) {
//                        tree.setChildren(new ArrayList<SysResource>());
//                    }
//                    tree.getChildren().add(treeNode);
//                }
//            }
//            treeList.add(tree);
//        }
//        return treeList;
//    }


}
