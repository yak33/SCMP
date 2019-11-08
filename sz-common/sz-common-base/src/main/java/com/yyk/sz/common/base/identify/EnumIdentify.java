/**
 * 
 */
package com.yyk.sz.common.base.identify;

import java.io.Serializable;

/**
 * 枚举标示
 */
public interface EnumIdentify<K> extends Serializable {
    K getId();  
}  