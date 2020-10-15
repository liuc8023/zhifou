package com.springcloud.zhifou.customer.init;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 获取初始化的码值
 */
public class UtilCommonCode {
    /**
     * @description 根据大类的key值获取大类的中文名称
     * @param key
     * @return
     */
    public static String getCodeTypeNameByKey(String key) {
        if (CodeContainer.CODE_TYPE_CONTAINER.containsKey(key)) {
            return (String) CodeContainer.CODE_TYPE_CONTAINER.get(key);
        }
        return null;
    }

    /**
     * @description 根据大类的key值，获取小类的的描述集合
     * @param type
     * @return 集合是key-value
     */
    public static Map<String,Object> getCodeGatherKv(String type) {
        if (CodeContainer.CODE_TYPE_LINK_CODE_KEY.containsKey(type)) {
            return  CodeContainer.CODE_TYPE_LINK_CODE_KEY.get(type);
        }
        return null;
    }


    /**
     * @description 根据大类的key值，获取小类的的描述集合，
     * @param type
     * @return 集合是key-中文名称
     */
    public static Map<String,Object> getCodeGatherKn(String type) {
        if (CodeContainer.CODE_TYPE_LINK_CODE_KEY_NAME.containsKey(type)) {
            return  CodeContainer.CODE_TYPE_LINK_CODE_KEY_NAME.get(type);
        }
        return null;
    }

    /**
     * @description 根据大类的key值，获取小类的的描述集合，
     * @param type
     * @return 集合是value-中文名称
     */
    public static Map<String,Object> getCodeGatherVn(String type) {
        if (CodeContainer.CODE_TYPE_LINK_VALUE_KEY_NAME.containsKey(type)) {
            return  CodeContainer.CODE_TYPE_LINK_VALUE_KEY_NAME.get(type);
        }
        return null;
    }


    /**
     * @description 根据大类的key值，以及小类的key值，获取小类的value
     * @param type
     * @param key
     * @return
     */
    public static String getCodeValueByType(String type,String key) {
        if (CodeContainer.CODE_TYPE_LINK_CODE_KEY.containsKey(type)
                && CodeContainer.CODE_TYPE_LINK_CODE_KEY.get(type).containsKey(key)) {
            return  (String) CodeContainer.CODE_TYPE_LINK_CODE_KEY.get(type).get(key);
        }
        return null;
    }

    /**
     * @description 根据大类的key值，以及小类的key值，获取小类的中文描述
     * @param type
     * @param key
     * @return
     */
    public static String getCodeNameByType(String type,String key) {
        if (CodeContainer.CODE_TYPE_LINK_CODE_KEY_NAME.containsKey(type)
                && CodeContainer.CODE_TYPE_LINK_CODE_KEY_NAME.get(type).containsKey(key)) {
            return (String) CodeContainer.CODE_TYPE_LINK_CODE_KEY_NAME.get(type).get(key);
        }
        return  null;
    }

    /**
     * @description 根据大类的key值，以及小类的value值，获取小类的中文描述
     * @param type
     * @param value
     * @return
     */
    public static String getCodeNameByTypeValue(String type,String value) {
        if (CodeContainer.CODE_TYPE_LINK_VALUE_KEY_NAME.containsKey(type)
                && CodeContainer.CODE_TYPE_LINK_VALUE_KEY_NAME.get(type).containsKey(value)) {
            return  (String) CodeContainer.CODE_TYPE_LINK_VALUE_KEY_NAME.get(type).get(value);
        }
        return null;
    }

    /**
     * 根据大类key，以及小类的的中文描述，获取小类的key值
     * @param type
     * @param chineseName
     * @return
     */
    public static String getChineseNameFrSmallKey(String type,String chineseName) {
        if (CodeContainer.CODE_TYPE_LINK_CODE_KEY_NAME.containsKey(type)) {
            Map<String,Object> map = CodeContainer.CODE_TYPE_LINK_CODE_KEY_NAME.get(type);
            Set<Entry<String, Object>> set = map.entrySet();
            Iterator<Entry<String, Object>> it = set.iterator();
            while(it.hasNext()) {
                Entry<String, Object> obj = (Entry<String, Object>) it.next();
                if(chineseName.equals(obj.getValue())) {
                    return (String) obj.getKey();
                }
            }
        }
        return null;
    }

    /**
     * @description 根据大类的key值，以及小类的key值，获取小类的校验标识
     * @param type
     * @param key
     * @author liuc
     * @date 2018-10-29
     * @return
     */
    public static Boolean getCodeVfByType(String type,String key) {
        if (CodeContainer.CODE_TYPE_LINK_CODE_KEY_VF.containsKey(type)
                && CodeContainer.CODE_TYPE_LINK_CODE_KEY_VF.get(type).containsKey(key)) {
            return (Boolean) CodeContainer.CODE_TYPE_LINK_CODE_KEY_VF.get(type).get(key);
        }
        else {
            return Boolean.FALSE;
        }
    }

    /**
     * @description 根据大类的key值，以及小类的value值，获取小类的校验标识
     * @param type
     * @param value
     * @author liuc
     * @date 2018-10-29
     * @return
     */
    public static Boolean getCodeVfByTypeValue(String type,String value) {
        if (CodeContainer.CODE_TYPE_LINK_VALUE_KEY_VF.containsKey(type)
                && CodeContainer.CODE_TYPE_LINK_VALUE_KEY_VF.get(type).containsKey(value)) {
            return  (Boolean) CodeContainer.CODE_TYPE_LINK_VALUE_KEY_VF.get(type).get(value);
        }
        else {
            return Boolean.FALSE;
        }
    }
}
