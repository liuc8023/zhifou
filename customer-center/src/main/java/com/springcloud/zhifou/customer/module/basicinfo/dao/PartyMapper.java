package com.springcloud.zhifou.customer.module.basicinfo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springcloud.zhifou.customer.module.basicinfo.entity.Party;
import org.apache.ibatis.annotations.Mapper;

/**
 * 客户信息 Mapper 接口
 */
@Mapper
public interface PartyMapper extends BaseMapper<Party> {

}
