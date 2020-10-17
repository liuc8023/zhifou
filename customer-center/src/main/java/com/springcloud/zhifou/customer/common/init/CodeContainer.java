package com.springcloud.zhifou.customer.common.init;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 码值容器
 */
public class CodeContainer {
    /**
     * 1 码值的大类和中文对应容器
     */
    static final Map<String,Object> CODE_TYPE_CONTAINER = new ConcurrentHashMap<String, Object> (16);

    /**
     * 2 码值的大类 【码值小类关联key-value】
     */
    static final Map<String,Map<String,Object>> CODE_TYPE_LINK_CODE_KEY = new ConcurrentHashMap<String, Map<String,Object>> (16);

    /**
     * 3 码值的大类【码值小类关联key-name】
     */
    static final Map<String,Map<String,Object>> CODE_TYPE_LINK_CODE_KEY_NAME = new ConcurrentHashMap<String, Map<String,Object>> (16);

    /**
     * 4 码值的大类【码值小类关联value-name】
     */
    static final Map<String,Map<String,Object>> CODE_TYPE_LINK_VALUE_KEY_NAME = new ConcurrentHashMap<String, Map<String,Object>> (16);

    /**
     * 5 码值的校验标识【码值小类关联key-validateFalg】
     */
    static final Map<String,Map<String,Object>> CODE_TYPE_LINK_CODE_KEY_VF = new ConcurrentHashMap<String, Map<String,Object>> (16);

    /**
     * 6 码码值的校验标识【码值小类关联value-validateFalg】
     */
    static final Map<String,Map<String,Object>> CODE_TYPE_LINK_VALUE_KEY_VF = new ConcurrentHashMap<String, Map<String,Object>> (16);
}
