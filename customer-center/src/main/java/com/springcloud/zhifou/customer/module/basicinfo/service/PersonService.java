package com.springcloud.zhifou.customer.module.basicinfo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springcloud.zhifou.customer.module.basicinfo.entity.Person;

import java.util.Map;

/**
 *个人基础信息服务类
 */
public interface PersonService extends IService<Person> {

    /**
     * 查询个人客户基础信息
     * @param context
     * @return Map
     * @throws
     * @date 2019/12/12 12:12
     * @author liuc
     **/
    public Map<String,Object> selectPersonCustBasicInfo(Map<String, ? extends Object> context);
    /**
     * 修改个人客户基础信息
     * @param context
     * @return Map
     * @throws
     * @date 2019/12/12 12:12
     * @author liuc
     **/
    public Map<String,Object> updatePersonCustBasicInfo(Map<String, ? extends Object> context);
    /**
     * 新增个人客户基础信息
     * @param context
     * @return Map
     * @throws
     * @date 2019/12/12 12:12
     * @author liuc
     **/
    public Map<String, Object> addPersonCustBasicInfo(Map<String, ? extends Object> context);
}
