package com.springcloud.zhifou.customer.common.util;

import com.springcloud.kernel.common.exception.UnifyErrorCode;
import com.springcloud.kernel.common.exception.UnifyException;
import com.springcloud.kernel.common.utils.UtilValidate;
import com.springcloud.zhifou.customer.common.init.UtilCommonCode;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

public class CommCheckUtil {

    /**
     * 校验码值是否在标准码值范围内，如果不在范围内的返回false，
     * 如果标准码值大类送过来的是空或者需要校验的码值送过来的是空，或者在码值范围内的都返回true
     * @param gatherKv
     * @param content
     * @return
     */
    public static boolean checkOptRule(String gatherKv,String content) {
        if (UtilValidate.isEmpty(gatherKv)) {
            return true;
        }
        if (UtilValidate.isEmpty(content)) {
            return true;
        }
        //如果不在范围内的返回false
        if (!UtilCommonCode.getCodeGatherKv(gatherKv).containsValue(content)) {
            return false;
        } else {
            return true;
        }
    }

    public static Map<String,Object> strTokenToMap(String str, String limit, String token){
        String[] arryStr = str.split(limit);
        Map<String,Object> result = new HashMap<String,Object>(16);
        String[] lvStr = null;
        for(int i=0; i<arryStr.length; i++) {
            lvStr = arryStr[i].split(token);
            result.put(lvStr[0], lvStr[1]);
        }
        return result;
    }


    public static Map<String,Object> requiredCheck(Map<String, Object> checkItem, Map<String, Object> context) {
        // 检查项集非空
        if (UtilValidate.isEmpty(checkItem)) {
            throw new UnifyException(UnifyErrorCode.CSRCB30000, "服务参数集为空");
        } else {
            // 遍历检查项
            for (Map.Entry<String, Object> entry : checkItem.entrySet()) {
                if (UtilValidate.isEmpty(context.get(entry.getValue()))) {
                    throw new UnifyException(UnifyErrorCode.CSRCB30000, MessageFormat.format(UnifyErrorCode.CSRCB30000.getMsg(),entry.getKey()));
                }
            }
        }
        return null;
    }
}
