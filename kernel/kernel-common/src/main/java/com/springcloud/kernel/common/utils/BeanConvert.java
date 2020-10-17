package com.springcloud.kernel.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.springcloud.kernel.common.UnifyPageData;
import com.springcloud.kernel.common.exception.UnifyErrorCode;
import com.springcloud.kernel.common.exception.UnifyException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
* @className BeanConvert
* @description 
* @author liuc
* @date 2019-11-01 14:57
* @since JDK 1.8
**/
public class BeanConvert {
    /**
     * Json转换时的转换配置
     */
    public static final SimpleModule SIMPLE_MODULE = new SimpleModule();
    public static final ObjectMapper MAPPER;

    /**
     * 将Json字符串转换为指定类型的对象
     * @param json
     * @param clazz
     * @return <T>
     * @throws
     * @date 2019/11/5 10:41
     * @author liuc
     **/
    public static <T> T fromJson(String json, Class<T> clazz)
    {
        try {
            return MAPPER.readValue(json, clazz);
        } catch (Exception e) {
            throw new UnifyException(UnifyErrorCode.UNKNOW_FAIL, "将字符串[" + json + "]转换为对象失败", e);
        }
    }

    /**
     * 将Json字符串转换为指定类型的对象
     * @param json
     * @param type
     * @return <T>
     * @throws
     * @date 2019/11/5 10:41
     * @author liuc
     **/
    public static <T> T fromJson(String json, JavaType type)
    {
        try
        {
            return MAPPER.readValue(json, type);
        } catch (Exception e) {
            throw new UnifyException(UnifyErrorCode.UNKNOW_FAIL, "将字符串[" + json + "]转换为对象失败", e);
        }
    }

    /**
     * 将Json字符串转换为指定类型的对象
     * @param json
     * @param typeReference 例：new TypeReference<UnifyPageData<Student>>{}
     * @return <T>
     * @throws
     * @date 2019/11/5 10:41
     * @author liuc
     **/
    public static <T> T fromJson(String json, TypeReference<T> typeReference)
    {
        try {
            return MAPPER.readValue(json, typeReference);
        } catch (Exception e) {
            throw new UnifyException(UnifyErrorCode.UNKNOW_FAIL, "将字符串[" + json + "]转换为对象失败", e);
        }
    }

    /**
     * 将Json字符串转换为对象集合
     * @param json          Json字符串
     * @param entityClazz   对象集合中对象的类型
     * @return <T>
     * @throws
     * @date 2019/11/5 10:41
     * @author liuc
     **/
    @SuppressWarnings("unchecked")
    public static <T> List<T> fromJsonToList(String json, Class<T> entityClazz)
    {
        try
        {
            return (List<T>)MAPPER.readValue(json, MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, entityClazz));
        } catch (Exception e) {
            throw new UnifyException(UnifyErrorCode.UNKNOW_FAIL, "字符串[" + json + "]转换为集合数据失败", e);
        }

    }

    /**
     * 将Json字符串转换为分页数据
     * @param json          Json字符串
     * @param entityClazz   对象集合中对象的类型
     * @return <T>
     * @throws
     * @date 2019/11/5 10:41
     * @author liuc
     **/
    @SuppressWarnings("unchecked")
    public static <T> UnifyPageData<T> fromJsonToPagedList(String json, Class<T> entityClazz) {
        try
        {
            JavaType tp = MAPPER.getTypeFactory().constructParametricType(UnifyPageData.class, new Class[] { entityClazz });
            return (UnifyPageData<T>)MAPPER.readValue(json, tp);
        } catch (Exception e) {
            throw new UnifyException(UnifyErrorCode.UNKNOW_FAIL, "字符串[" + json + "]转换为分页数据失败", e);
        }
    }

    /**
     * 将对象转换成为Json字符串
     * @param obj
     * @return <T>
     * @throws
     * @date 2019/11/5 10:41
     * @author liuc
     **/
    public static String toJson(Object obj)
    {
        try {
            return MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new UnifyException(UnifyErrorCode.UNKNOW_FAIL, "将对象转换为字符串失败", e);
        }
    }

//    public static List<Map<String, Object>> toMapList(Iterable<?> list, String[] fields)
//    {
//        try {
//            String json = MAPPER.writeValueAsString(list);
//            List map = (List)MAPPER.readValue(json, List.class);
//            if ((fields != null) && (fields.length > 0)) {
//                for (Map entity : map) {
//                    removeWithout(entity, fields);
//                }
//            }
//            return map;
//        } catch (Exception e) {
//            throw new UnifyException(UnifyErrorCode.UNKNOW_FAIL.getCode(), "将list:" + list + "转换为map失败", e);
//        }
//    }

//    public static <T> List<Map<String, Object>> toMapList(T[] array, String[] fields)
//    {
//        try
//        {
//            String json = MAPPER.writeValueAsString(array);
//            List map = (List)MAPPER.readValue(json, List.class);
//            if ((fields != null) && (fields.length > 0)) {
//                for (Map entity : map) {
//                    removeWithout(entity, fields);
//                }
//            }
//            return map; } catch (Exception e) {
//        }
//        throw new UnifyException(UnifyErrorCode.UNKNOW_FAIL.getCode(), "将数组:" + array + "转换为map失败", e);
//    }

//    public static UnifyPageData<Map<String, Object>> toMapList(UnifyPageData<?> data, String[] fields)
//    {
//        UnifyPageData pagedData = null;
//        if ((data != null) && (data.getList() != null)) {
//            List dataList = toMapList(data.getList(), fields);
//            pagedData = new UnifyPageData(dataList, data.getPageIndex(), data.getPageSize(), data.getTotalSize());
//        } else {
//            pagedData = new UnifyPageData(new ArrayList(), data.getPageIndex(), data.getPageSize(), data.getTotalSize());
//        }
//        return pagedData;
//    }

//    public static List<Map<String, Object>> toMapList(Object obj, String[] fields)
//    {
//        if ((obj instanceof Iterable))
//            return toMapList((Iterable)obj, fields);
//        try
//        {
//            String json = MAPPER.writeValueAsString(obj);
//            List map = (List)MAPPER.readValue(json, List.class);
//            if ((fields != null) && (fields.length > 0)) {
//                for (Map entity : map) {
//                    removeWithout(entity, fields);
//                }
//            }
//            return map; } catch (Exception e) {
//        }
//        throw new UnifyException(UnifyErrorCode.UNKNOW_FAIL.getCode(), "将对象:" + obj + "转换为map失败", e);
//    }

    /**
     * 将实体bean转换为map
     * @param bean
     * @return fields 要转换的字段 若不提供则转换所有字段
     * @throws
     * @date 2019/11/5 10:41
     * @author liuc
     **/
    @SuppressWarnings("unchecked")
    public static Map<String, Object> toMap(Object bean, String[] fields)
    {
        if ((bean instanceof Map)) {
            return (Map<String,Object>)bean;
        }
        try {
            String json = MAPPER.writeValueAsString(bean);
            Map<String,Object> map = (Map<String,Object>)MAPPER.readValue(json, Map.class);
            if ((fields != null) && (fields.length > 0)) {
                removeWithout(map, fields);
            }
            return map;
        } catch (Exception e) {
            throw new UnifyException(UnifyErrorCode.UNKNOW_FAIL.getCode(), "将bean:" + bean + "转换为map失败", e);
        }
    }

    /**
     * 将Map转换为指定的实体bean类型
     * @param map
     * @return classOfT
     * @throws
     * @date 2019/11/5 10:41
     * @author liuc
     **/
    public static <T> T fromMap(Map<String, Object> map, Class<T> classOf)
    {
        try {
            String json = MAPPER.writeValueAsString(map);
            return MAPPER.readValue(json, classOf);
        } catch (Exception e) {
            throw new UnifyException(UnifyErrorCode.UNKNOW_FAIL.getCode(), "将map:" + map + "转换为" + classOf.getName() + "失败", e);
        }
    }

    /**
     * 移除不在fields中出现的字段
     * @param map
     * @return fields
     * @throws
     * @date 2019/11/5 10:41
     * @author liuc
     **/
    @SuppressWarnings("unchecked")
    private static void removeWithout(Map<String, Object> map, String[] fields)
    {
        List<String> ks = new ArrayList(map.keySet());
        for (String k : ks) {
            if (!ArraysUtil.contains(fields, k)) {
                map.remove(k);
            }
        }
    }

    static
    {
        SIMPLE_MODULE.addSerializer(Integer.class, ToStringSerializer.instance);
        SIMPLE_MODULE.addSerializer(Integer.TYPE, ToStringSerializer.instance);
        SIMPLE_MODULE.addSerializer(Long.class, ToStringSerializer.instance);
        SIMPLE_MODULE.addSerializer(Long.TYPE, ToStringSerializer.instance);
        SIMPLE_MODULE.addSerializer(Double.class, ToStringSerializer.instance);
        SIMPLE_MODULE.addSerializer(Double.TYPE, ToStringSerializer.instance);
        SIMPLE_MODULE.addSerializer(BigDecimal.class, ToStringSerializer.instance);
        SIMPLE_MODULE.addDeserializer(Integer.class, new NumberDeserializers.IntegerDeserializer(Integer.class, null));
        SIMPLE_MODULE.addDeserializer(Integer.TYPE, new NumberDeserializers.IntegerDeserializer(Integer.class, null));
        SIMPLE_MODULE.addDeserializer(Long.class, new NumberDeserializers.LongDeserializer(Long.class, null));
        SIMPLE_MODULE.addDeserializer(Long.TYPE, new NumberDeserializers.LongDeserializer(Long.class, null));
        SIMPLE_MODULE.addDeserializer(Double.class, new NumberDeserializers.DoubleDeserializer(Double.class, null));
        SIMPLE_MODULE.addDeserializer(Double.class, new NumberDeserializers.DoubleDeserializer(Double.class, null));
        SIMPLE_MODULE.addDeserializer(BigDecimal.class, new NumberDeserializers.BigDecimalDeserializer());
        MAPPER = new ObjectMapper().registerModule(SIMPLE_MODULE).disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }
}