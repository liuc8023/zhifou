package com.springcloud.zhifou.customer.module.commom.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springcloud.zhifou.customer.module.commom.dao.CustCodeValueMapper;
import com.springcloud.zhifou.customer.module.commom.entity.CustCodeValue;
import com.springcloud.zhifou.customer.module.commom.service.CustCodeValueService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * 码值表服务实现类
 * @className: CustCodeValue
 * @author: liuc
 * @date: 2019-11-12
 */
@Service
public class CustCodeValueServiceImpl extends ServiceImpl<CustCodeValueMapper, CustCodeValue> implements CustCodeValueService {
    @Resource
    private CustCodeValueMapper mapper;

    @Override
    public List<CustCodeValue> selectAllByAsc(String[] columns) {
        QueryWrapper<CustCodeValue> ew = new QueryWrapper<>();
        ew.orderBy(true,true, columns);
        List<CustCodeValue> list = mapper.selectList(ew);
        return list;
    }

    @Override
    public List<CustCodeValue> selectGroupByAndAsc(String[] groupBy, String[] columns) {
        QueryWrapper<CustCodeValue> ew = new QueryWrapper<>();
        ew.select("code_type_key", "code_type_key_name");
        ew.groupBy(groupBy);
        ew.orderBy(true,true, columns);
        List<CustCodeValue> list = mapper.selectList(ew);
        return list;
    }
}
