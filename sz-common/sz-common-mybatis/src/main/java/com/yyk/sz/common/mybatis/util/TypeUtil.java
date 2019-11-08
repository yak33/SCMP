/**
 * 
 */
package com.yyk.sz.common.mybatis.util;

/**
 * @author 605162215@qq.com
 *
 * 2016年7月21日 下午12:59:33
 */
public class TypeUtil {
	public static boolean isSimpleType(Class<?> clazz){
		if(clazz == String.class){
			return true;
		}else if(clazz == int.class || clazz == Integer.class){
			return true;
		}else if(clazz == long.class || clazz == Long.class){
			return true;
		}else if(clazz == boolean.class || clazz == Boolean.class){
			return true;
		}else if(clazz == byte.class || clazz == Byte.class){
			return true;
		}else if(clazz == char.class || clazz == Character.class){
			return true;
		}else if(clazz == short.class || clazz == Short.class){
			return true;
		}else if(clazz == float.class || clazz == Float.class){
			return true;
		}else if(clazz == double.class || clazz == Double.class){
			return true;
		}
		return false;
	}
}
