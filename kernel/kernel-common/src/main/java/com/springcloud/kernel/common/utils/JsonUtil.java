package com.springcloud.kernel.common.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections4.map.ListOrderedMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Json转化工具
 */
public class JsonUtil {
    public static List<Map<String, Object>> parseJsonToList(String json) {

        JSONArray jsonArr = JSONArray.parseArray(json);

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        Iterator<Object> it = jsonArr.iterator();

        while (it.hasNext()) {
            Object json2 = it.next();
            list.add(parseJsonToMap(json2.toString()));

        }
        return list;

    }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> parseJsonToMap(String jsonStr) {
        ListOrderedMap map = new ListOrderedMap();
        // 最外层解析
        JSONObject json = JSONObject.parseObject(jsonStr);
        for (Object k : json.keySet()) {
            Object v = json.get(k);
            // 如果内层还是数组的话，继续解析
            if (v instanceof JSONArray) {
                List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
                Iterator<Object> it = ((JSONArray) v).iterator();
                while (it.hasNext()) {
                    Object json2 = it.next();
                    list.add(parseJsonToMap(json2.toString()));
                }
                map.put(k.toString(), list);
            } else {
                map.put(k.toString(), v);

            }

        }

        Iterator iterator = map.keySet().iterator();

        List<String> lsList = new ArrayList<String>();
        int d=0;
        while (iterator.hasNext()) {

            String key = (String) iterator.next();

            Object object = map.get(key);

            // 进行遍历删除，当值为空的时候删除这条数据

            if (("").equals(object)) {
                iterator.remove();
                map.remove(key);
            }
        }
        return map;
    }
}
