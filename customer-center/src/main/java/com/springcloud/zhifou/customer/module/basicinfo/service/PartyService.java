package com.springcloud.zhifou.customer.module.basicinfo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springcloud.kernel.common.exception.UnifyException;
import com.springcloud.zhifou.customer.module.basicinfo.entity.Party;
import java.util.Map;

/**
 * 客户信息服务类
 */
public interface PartyService extends IService<Party> {
    /**
     * 根据客户号查询客户简要信息
     * @param context
     * @return Map
     * @throws
     * @date 2019/12/12 12:12
     * @author liuc
     **/
    public Map<String, Object> selectCustBasicInfo(Map<String, ? extends Object> context);
    /**
     * 根据客户号修改客户状态
     * @param context
     * @return Map
     * @throws
     * @date 2019/12/12 12:12
     * @author liuc
     **/
    public Map<String, Object> updateCustBasicInfo(Map<String, ? extends Object> context);
    /**
     * 根据客户号查询客户简要信息列表
     * @param context
     * @return Map
     * @throws
     * @date 2019/12/12 12:12
     * @author liuc
     **/
    public Map<String, Object> selectCustBasicInfoList(Map<String, ? extends Object> context);
    /**
     * 判断客户号是否存在
     * @param partyId
     * @return Boolean
     * @throws UnifyException
     * @date 2019/12/12 12:12
     * @author liuc
     **/
    public Boolean selectParty(String partyId) throws UnifyException;
    /**
     * 根据客户号查询正式客户且状态正常的客户简要信息
     * @param context
     * @return Map
     * @throws
     * @date 2019/12/23 20:53
     * @author liuc
     **/
    public Map<String, Object> selectCustBasicInfoByCustNo(Map<String, ? extends Object> context);
}
