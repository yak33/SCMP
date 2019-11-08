package com.yyk.sz.zhzy.system.common;


public  class Constants{
	/*分页大小*/
	public final static int PAGE_SIZE = 10;
	/*租户id*/
	public final static String TENANT_ID = "public";
	//查询前缀字符串
	public final static String QUEYR_PREFIX = "search_" ;
	//默认排序字符串
	public final static String DEFAULT_SORT = "auto";
	
	public final static String ROOT_PARENT_ID = "root";
	public final static String OPTION_SPACE = "&nbsp;&nbsp;";
	public final static String OPTION_LEVEL = "├";
	public final static String OPTION_LEVEL_END = "└";
	
	public final static String NOTICE_DICT_ID = "4028815d4733dc9e0147345f06ba0017";
	public final static String MESSAGE_DICT_ID = "4028815d4733dc9e0147345fae500018";
	public final static String ORG_SPLITER="#"; 
	public final static String DELETED="1";
	public final static String NOT_DELETED="0";
	
	public final static String MESSAGE_PUBLIC_SAVE="保存成功！";
	public final static String MESSAGE_PUBLIC_SAVE_FAILED="保存失败！";
	public final static String MESSAGE_PUBLIC_DELETE="删除成功！";
	public final static String MESSAGE_PUBLIC_RESET="重置成功！";
	public final static String MESSAGE_PUBLIC_UPDATE="修改成功！";
	public final static String MESSAGE_PUBLIC_BIND="绑定成功！";
	public final static String MESSAGE_PUBLIC_REJECT="驳回成功！";
	public final static String MESSAGE_PUBLIC_BIND_FAILURE_HAVESETLEADER="绑定失败！用户已经设置单位领导，请检查。";

	public final static String MESSAGE_PUBLIC_PROPOSAL="绑定操作已成功提交审批！";
	public final static String MESSAGE_PUBLIC_APPROVE="审批成功！";

	public final static String MESSAGE_PUBLIC_BIND_FAILED="绑定失败，请先为角色绑定该资源！";
	
	public final static String DICT_CODE_USERSTATUS="userstatus";
	public final static String DICT_CODE_BIZSTATUS="bizstatus";
	public final static String USER_ORIGINAL_PASSWORD="111111";
	public final static String USER_ORIGINAL_ROLECODE="basic";
	public final static String DICT_CODE_RESOURCETYPE="resctype";
	public final static String DICT_CODE_USERSYNC="usersync";
	
	public final static String DICT_CODE_CONTROLTYPE="controlType";

	public final static String DICT_CODE_ORGTYPE="orgType";
	public final static String DICT_CODE_CLASSIFICATION="classification";
	public final static String DICT_CODE_GOVNCLASSIFICATION="govnclassification";
	public final static String DICT_CODE_OPERATIONTYPE="operationType";
	public final static String DICT_CODE_OPERATIONSTATUS="operationStatus";
	public final static String DICT_CODE_DATARULE_CONDITIONS="dataRuleConditions";
	public final static String DICT_CODE_DATAFIELD_STRUCTURES="dataFieldStructures";

	public final static String[][] ORGANIZATION_SECOND_LEVEL_NODE_CODES={{"1","xingzheng"},{"2","zuzhi"}};
	
	public final static String ORGANIZATION_XINGZHENG_PREFIX="xz_";
	public final static String ORGANIZATION_ZUZHI_PREFIX="zz_";

	public final static String DICT_CODE_RESC_LEVEL="rescLevel";
	
	public final static String SESSION_TIMEOUT_MESSAGE="会话超时，请重新登录！";
	
	public final static String VERIFICATION_SESSION_KEY="verificationCode";

	public final static String VALIDSUCCESSTIP = "通过验证";

	public final static String MESSAGE_BIND_PARAM="参数错误！";

	//管理员等级
	public final static String ADMIN_LEVEL_FIRST = "1";
	public final static String ADMIN_LEVEL_SECOND = "2";

	//管理员类别
	public final static String ADMIN_TYPE_ADMIN = "0";
	public final static String ADMIN_TYPE_SAFE = "1";
	public final static String ADMIN_TYPE_AUDIT = "2";

	public final static String MESSAGE_PUBLIC_ACTIVE="激活成功！";
	public final static String MESSAGE_PUBLIC_ACTIVE_FAILE="激活失败！";

	//系统管理员类型及级别
	public final static String TYPE_LEVEL_NORMAL = "0_0";//非三权用户
	public final static String TYPE_LEVEL1_ADMIN = "0_1";//系统管理员
	public final static String TYPE_LEVEL2_ADMIN = "0_2";//二级系统管理员
	public final static String TYPE_LEVEL1_SAFE = "1_1";//系统安全员
	public final static String TYPE_LEVEL2_SAFE = "1_2";//二级安全员
	public final static String TYPE_LEVEL1_AUDIT = "2_1";//系统审计员
	public final static String TYPE_LEVEL2_AUDIT = "2_2";//二级审计员




}
