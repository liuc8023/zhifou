package com.springcloud.kernel.common.utils;

import com.springcloud.kernel.common.lang.IsEmpty;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

public class UtilValidate {
    /**
     * @Title: isEmpty
     * @Description: 判断对象是否为空
     * @param o
     * @return boolean
     * @author liuc
     * @date 2018年9月20日下午3:48:34
     * @throws
     */
    public static boolean isEmpty(Object o) {
        if (o == null) {
            return true;
        }
        if (o instanceof String) {
            return ((String) o).length() == 0;
        }
        if (o instanceof Collection) {
            return ((Collection<? extends Object>) o).size() == 0;
        }
        if (o instanceof Map) {
            return ((Map<? extends Object, ? extends Object>) o).size() == 0;
        }
        if (o instanceof CharSequence) {
            return ((CharSequence) o).length() == 0;
        }
        if (o instanceof IsEmpty) {
            return ((IsEmpty) o).isEmpty();
        }
        if (o instanceof Boolean) {
            return false;
        }
        if (o instanceof Number) {
            return false;
        }
        if (o instanceof Character) {
            return false;
        }
        if (o instanceof Date) {
            return false;
        }
        return false;
    }

    /**
     * @description 判断对象是否不为空
     * @param o
     * @return boolean
     * @throws
     * @date 2019/10/14 22:37
     * @author liuc
     **/
    public static boolean isNotEmpty(Object o) {
        return !isEmpty(o);
    }

    /**
     * @description 比较两个对象是否相等
     * @param obj
     * @param obj2
     * @return boolean
     * @throws
     * @date 2019/10/14 22:37
     * @author liuc
     **/
    public static boolean areEqual(Object obj, Object obj2){
        if (obj == null){
            return obj2 == null;
        }else {
            return obj.equals(obj2);
        }
    }
}
