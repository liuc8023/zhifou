package com.springcloud.kernel.common.utils;

import com.springcloud.kernel.common.constant.Constant;

import java.util.regex.Pattern;

/**
 * 字符串处理工具类
 *
 * @author liuc
 */
public class StringUtil {

    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile(Constant.IS_NUMERIC);
        return pattern.matcher(str).matches();
    }
}
