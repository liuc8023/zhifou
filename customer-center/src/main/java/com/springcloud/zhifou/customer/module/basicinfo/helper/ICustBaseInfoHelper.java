package com.springcloud.zhifou.customer.module.basicinfo.helper;

import com.springcloud.kernel.common.exception.UnifyException;
import com.springcloud.zhifou.customer.module.basicinfo.entity.Person;

import java.util.Map;

/**
* @className ICustBaseInfoHelper
* @description 
* @author liuc
* @date 2019-11-19 9:15
* @since JDK 1.8
**/
public interface ICustBaseInfoHelper {
    /**
     * 个人客户基础信息，新增、修改参数
     * @param context
     * @return Person
     * @throws UnifyException
     * @date 2019/12/12 14:00
     * @author liuc
     **/
    public Person custPerBasicInfoParam(Map<String, ? extends Object> context) throws UnifyException;
    /**
     * 校验字段是否在标准码范围内
     * @param context
     * @return
     * @throws
     * @date 2019/12/12 13:57
     * @author liuc
     **/
    public void checkCodeValue(Map<String,?> context);
}
