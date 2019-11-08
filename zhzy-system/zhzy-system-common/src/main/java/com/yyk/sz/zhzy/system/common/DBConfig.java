package com.yyk.sz.zhzy.system.common;

/**
 * <b>数据库关联关系、字段长度等其它信息配置。<br><br>具体规则如下：</b><br><br>
 * 实体之间的关联关系的级联方式只设置持久化关联，如果两个关联的实体都需要维护关联关系，
 * 则需要分别建立关联联系。<p>
 * 数据库表逐渐在其它表中被参考字段名称：表对应实体名称+"_REFERENCE"。<p>
 * 多对多关系关联表名称规则：关联对象+"_"+被关联对象+"_JOINTABLE"。<p>
 */
public class DBConfig {
	public static final String getTest(){
		return "" ;
	}
	//系统表名称前缀
	public static final String TABLE_PREFIX = "sys_" ;
	
	//=============================系统中的表名称==============================================
	
	public static final String USER_TABLE = TABLE_PREFIX+"user" ;
	
	public static final String TENANT_TABLE = TABLE_PREFIX+"tenant" ;
	
	//public static final String USERGROUP_TABLE = TABLE_PREFIX+"usergroup" ;
	
	public static final String ROLE_TABLE = TABLE_PREFIX+"role" ;

	public static final String DATA_ROLE_TABLE = TABLE_PREFIX+"data_role" ;
	
	public static final String RESOURCE_TABLE = TABLE_PREFIX+"resource" ;
	
	public static final String ORGANIZATION_TABLE = TABLE_PREFIX+"organization" ;
	
	public static final String DICTIONARY_TABLE = TABLE_PREFIX+"dictionary" ;
	
	public static final String BIZSYS_TABLE = TABLE_PREFIX+"bizsys" ;
	
	public static final String RESTAPI_TABLE = TABLE_PREFIX+"restapi" ;
	
	//public static final String USERASSOCIATION_TABLE = TABLE_PREFIX+"userAssociation" ;
	public static final String LOG_TABLE = TABLE_PREFIX+"log" ;


	public static final String APPROVE_TABLE = TABLE_PREFIX+"approve" ;


	public static final String PROPOSAL_TABLE = TABLE_PREFIX+"proposal" ;
	

	public static final String DATARULE_TABLE = TABLE_PREFIX+"datarule" ;
	
	public static final String DATAFIELD_TABLE = TABLE_PREFIX+"datafield" ;
	
	public static final String ORG_FLAGS_TABLE = TABLE_PREFIX+"orgflag" ;

	public static final String CONDITION_TABLE = TABLE_PREFIX+"condition" ;
	

	public static final String DATA_SCOPE_TABLE = TABLE_PREFIX+"datascope" ;

	public static final String FILE_LISTEN_TASK = TABLE_PREFIX + "file_listen_task";

	public static final String FILE_LISTEN_READ = TABLE_PREFIX + "file_listen_read";
	// 批量导入表
	public static final String USER_BATCH_IMPORT = TABLE_PREFIX + "user_batchimport";
	// 岗位信息表
	public static final String POST_TABLE = TABLE_PREFIX + "post";
	// 人员岗位表
	public static final String USER_POST_TABLE= TABLE_PREFIX + "user_post";

	//=============================实体对应的数据库表外键名称=============================
	/**
	 * 租户关联列
	 */
	public static final String TENANT_REFERENCE = "tenant_id" ;
	/**
	 * 与业务系统一对多关系中业务系统参考ID
	 */
	public static final String BIZSYS_REFERENCE = "bizsys_id" ;
	/**
	 * 用户外键参考列名称
	 */
	public static final String USER_REFERENCE = "user_id" ;


	public static final String PROPOSAL_USER_REFERENCE = "proposal_user_id" ;


	public static final String APPROVE_USER_REFERENCE = "proposal_user_id" ;
	/**
	 * 组织机构关联列
	 */
	public static final String ORGANIZATION_REFERENCE = "organization_id" ;

	public static final String APPROVE_REFERENCE = "approve_id" ;
	
	/**
	 * 数据权限关联列
	 */
	public static final String CONDITION_REFERENCE = "condition_id" ;
	/**
	 * 组织机构的父组织机构关联列
	 */
	public static final String ORGANIZATION_PARENT_REFERENCE = "parent_id" ;
	/**
	 * 组织机构的机构归属关联列
	 */
	public static final String ORGANIZATION_BELONG_REFERENCE = "orgBelong";
	/**
	 * 角色外键参考列名称
	 */
	public static final String ROLE_REFERENCE = "role_id" ;

	/**
	 * 岗位外键
	 */
	public static final String POST_REFERENCE = "post_id";
	/**
	 * 用户组外键参考列名称
	 */
	public static final String USERGROUP_REFERENCE = "usergroup_id" ;
	/**
	 * 资源外键参考列名称
	 */
	public static final String RESOURCE_REFERENCE = "resource_id" ;
	
	/**
	 * 数据规则外键参考列名称
	 */
	public static final String DATARULE_REFERENCE = "datarule_id" ;
	
	/**
	 * 数据过滤外键参考列名称
	 */
	public static final String DATASCOPE_REFERENCE = "datascope_id" ;
	
	
	/**
	 * 父资源和子资源一对多关联列
	 */
	public static final String RESOURCE_PARENT_REFERENCE = "parent_id" ;
	/**
	 * userAssociation关联列
	 */
	public static final String USERASSOCIATION_REFERENCE = "userAssociation_id" ;
	/**
	 * 父字典项和子字典项的关联id
	 */
	public static final String DICTIONARY_PARENT_REFERENCE = "parent_id" ;
	
	//============================关联表配置==============================
	/**
	 * user其它属性表
	 */
	public static final String USER_PROP_TABLE = TABLE_PREFIX+"user_props" ;
	/**
	 * user和role多对多关联表
	 */
	public static final String USER_ROLE_JOINTABLE = TABLE_PREFIX+"user_role" ;

	public static final String USER_ROLE_JOINTABLE_PROPOSAL = TABLE_PREFIX+"user_role_proposal" ;
	/**
	 * user和usergroup多对多关联表
	 */
	//public static final String USER_USERGROUP_JOINTABLE = TABLE_PREFIX+"user_usergroup" ;
	/**
	 * user和bizsys多对多关联表
	 */
	public static final String USER_BUSINESSSYSTEM_JOINTABLE = TABLE_PREFIX+"user_bizsys" ;
	/**
	 * user和userAssociation多对多关联表
	 */
	public static final String USER_RESOURCE_JOINTABLE = TABLE_PREFIX+"user_resource" ;

	public static final String USER_RESOURCE_JOINTABLE_PROPOSAL = TABLE_PREFIX+"user_resource_proposal" ;
	/**
	 * role和resource多对多关联表
	 */
	public static final String ROLE_RESOURCE_JOINTABLE = TABLE_PREFIX+"role_resource" ;


	public static final String ROLE_RESOURCE_JOINTABLE_PROPOSAL = TABLE_PREFIX+"role_resource_proposal" ;
	

	/**
	 * role和bizsys多对多关联表
	 */
	public static final String ROLE_BIZSYS_JOINTABLE = TABLE_PREFIX+"role_bizsys" ;
	
	/**
	 * role和usergroup多对多关联表
	 */
	//public static final String ROLE_USERGROUP_JOINTABLE = TABLE_PREFIX+"role_usergroup" ;
	
	/**
	 * role和resource多对多关联表
	 */
	public static final String ROLE_RESOURCE_RULETABLE = TABLE_PREFIX+"role_resource_rule" ;
	

	/**
	 * role和datarule多对多关联表
	 */
	public static final String ROLE_DATARULE_JOINTABLE = TABLE_PREFIX+"role_datarule" ;

	/**
	 * role和datascope多对多关联表
	 */
	public static final String ROLE_DATASCOPE_JOINTABLE = TABLE_PREFIX+"role_datascope" ;

	/**
	 * user和datarule多对多关联表
	 */
	public static final String USER_DATARULE_JOINTABLE = TABLE_PREFIX+"user_datarule" ;

	/**
	 * post 和 user 多对多关联表
	 */
	public static final String POST_USER_JOINTABLE = TABLE_PREFIX + "post_user";

	public static final String ORGANIZATION_LEADERTABLE = TABLE_PREFIX + "organization_leader";

	/**
	 * userAdmin和user一对一关联表
	 */
	public static final String USER_ADMIN_JOINTABLE = TABLE_PREFIX + "user_admin";
	public static final String ADMIN_ORGANIZATION_JOINTABLE = TABLE_PREFIX + "user_admin_organization";
	public static final String ADMIN_RESOURCE_JOINTABLE = TABLE_PREFIX + "user_admin_resource";
	public static final String USER_ADMIN_REFERENCE = "admin_id" ;


	
}
