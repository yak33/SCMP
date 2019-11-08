package com.yyk.sz.zhzy.system.common;
/**
 * 配置数据库字段信息
 */
public class DBSchemaConfig {
	/**
	 * uuid字段的长度(32)
	 */
	public static final int UUID_LENGTH = 32 ;
	/**
	 * 一般性文本长度(100)，例如用户姓名、别名、组织机构名称
	 */
	public static final int SHORT_TEXT_LENGTH = 100 ;
	
	/**
	 * 文本长度(255)
	 */
	public static final int DEFAULT_TEXT_LENGTH = 255 ;
	
	/**
	 * 中等文本内容长度(500)，例如简介信息
	 */
	public static final int MIDDLE_TEXT_LENGTH = 500 ;
	/**
	 * 长文本内容长度(1000)，例如公告内容信息
	 */
	public static final int LONG_TEXT_LENGTH = 1000 ;
	
	/**
	 * 最长文本长度(2000)
	 */
	public static final int LONGEST_TEXT_LENGTH = 2000 ;
}
