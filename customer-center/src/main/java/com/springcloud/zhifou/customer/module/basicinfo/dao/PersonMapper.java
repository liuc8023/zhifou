package com.springcloud.zhifou.customer.module.basicinfo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springcloud.zhifou.customer.module.basicinfo.entity.Person;
import org.apache.ibatis.annotations.Mapper;

/**
 * 人基础信息 Mapper 接口
 */
@Mapper
public interface PersonMapper extends BaseMapper<Person> {

}
