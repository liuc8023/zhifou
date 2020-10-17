package com.springcloud.kernel.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**@className: BeanMapUtil
 * @description: 利用反射对Java对象和Map相互转化
 * @author: liuc
 * @date: 2018年12月26日 下午3:11:13  
 * @since JDK 1.8
 */
public class BeanMapUtil {
	
	/**
	 * @Title: mapToBean 
	 * @Description: 将Map转化为Object返回泛型类型
	 * @param map
	 * @param beanClass
	 * @return T
	 * @author liuc
	 * @date 2018年12月26日下午3:13:36
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public static <T> T mapToBean(Map<String, Object> map, Class<T> beanClass){
		Object obj = mapToObject(map, beanClass);
		return obj == null ? null : ((T)obj);
	}

	
	/**
	 * @Title: mapToObject 
	 * @Description: 将Map转化为Object
	 * @param map
	 * @param beanClass
	 * @return Object
	 * @author liuc
	 * @date 2018年12月26日下午3:13:03
	 * @throws
	 */
	public static Object mapToObject(Map<String, Object> map, Class<?> beanClass){    
	    if (map == null) {
			return null;
		}
	    Object obj = null;
		try {
			obj = beanClass.newInstance();  
			Field[] fields = obj.getClass().getDeclaredFields();   
			for (Field field : fields) {    
			    int mod = field.getModifiers();    
			    if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){    
			        continue;    
			    }    
			    field.setAccessible(true);    
			    field.set(obj, map.get(field.getName()));   
			}
		} catch (Exception e) {
			e.printStackTrace();
		}   
	    return obj;    
	}    
	
	/**
	 * @Title: objectToMap 
	 * @Description: 将Object转化为Map
	 * @param obj
	 * @return Map<String,Object>
	 * @author liuc
	 * @date 2018年12月26日下午3:14:28
	 * @throws
	 */
	public static Map<String, Object> objectToMap(Object obj) {    
	    if(obj == null){    
	        return null;    
	    }   
	    Map<String, Object> map = new HashMap<String, Object>(16);
	    try {
	    	Field[] declaredFields = obj.getClass().getDeclaredFields();    
		    for (Field field : declaredFields) {    
		        field.setAccessible(true);  
		        map.put(field.getName(), field.get(obj));  
		    }    
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return map;  
	}   

	/**
	 * @Title: beanToMap 
	 * @Description: 将Object转化为Map
	 * @param obj
	 * @return Map<String,Object>
	 * @author liuc
	 * @date 2018年12月26日下午3:14:54
	 * @throws
	 */
	public static Map<String, Object> beanToMap(Object obj) {    
		if(obj == null){    
			return null;    
		}   
		Map<String, Object> map = new HashMap<String, Object>(16);
		try {
			Field[] declaredFields = obj.getClass().getDeclaredFields();    
			for (Field field : declaredFields) {    
				field.setAccessible(true);  
				map.put(field.getName(), field.get(obj));  
			}
			if(map.containsKey("serialVersionUID")){
				map.remove("serialVersionUID");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;  
	}   

}
