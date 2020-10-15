package com.springcloud.zhifou.customer.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.springcloud.kernel.common.utils.DateUtil;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
* 配置公共字段自动填充功能  @TableField(..fill = FieldFill.INSERT)
* @className MetaObjectHandlerConfig
**/
@Component
public class MetaObjectHandlerConfig implements MetaObjectHandler {

    /**
     * 新增数据时执行,给公共字段字段填充值
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        // 获取公共字段的值
        Object createdStamp = getFieldValByName("createdStamp", metaObject);
        Object createdTxStamp = getFieldValByName("createdTxStamp", metaObject);
        // 判断是否为空,如果为空则进行填充
        if (createdStamp == null) {
            setFieldValByName("createdStamp", DateUtil.getCurrDateTime(), metaObject);
        }
        if (createdTxStamp == null) {
            setFieldValByName("createdTxStamp", DateUtil.getCurrDateTime(), metaObject);
        }
    }

    /**
     * 修改数据时执行,给公共字段字段填充值
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        // 获取公共字段的值
        Object lastUpdatedStamp = getFieldValByName("lastUpdatedStamp", metaObject);
        Object lastUpdatedTxStamp = getFieldValByName("lastUpdatedTxStamp", metaObject);
        // 判断是否为空,如果为空则进行填充
        if (lastUpdatedStamp == null) {
            setFieldValByName("lastUpdatedStamp", DateUtil.getCurrDateTime(), metaObject);
        }
        if (lastUpdatedTxStamp == null) {
            setFieldValByName("lastUpdatedTxStamp", DateUtil.getCurrDateTime(), metaObject);
        }
    }
}
