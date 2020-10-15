package com.springcloud.zhifou.customer.module.commom.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springcloud.zhifou.customer.module.commom.entity.CustCodeValue;
import org.apache.ibatis.annotations.Mapper;
/**
 * 码值表 Mapper 接口
 * @className: CustCodeValue
 * @author: liuc
 * @date: 2019-11-12
 */
@Mapper
public interface CustCodeValueMapper extends BaseMapper<CustCodeValue> {

}
