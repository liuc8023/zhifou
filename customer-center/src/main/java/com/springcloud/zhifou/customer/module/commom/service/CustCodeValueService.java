package com.springcloud.zhifou.customer.module.commom.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springcloud.zhifou.customer.module.commom.entity.CustCodeValue;

import java.util.List;

/**
 * 码值表服务类
 * @className: CustCodeValue
 * @author: liuc
 * @date: 2019-11-12
 */
public interface CustCodeValueService extends IService<CustCodeValue> {

    /**
     * 查询所有码值
     * @param columns
     * @return List
     * @throws
     * @date 2019/12/12 13:53
     * @author liuc
     **/
    public List<CustCodeValue> selectAllByAsc(String[] columns);
    /**
     * 分组查询所有码值
     * @param groupBy
     * @param columns
     * @return
     * @throws
     * @date 2019/12/12 13:54
     * @author liuc
     **/
    public List<CustCodeValue> selectGroupByAndAsc(String[] groupBy, String[] columns);
}
