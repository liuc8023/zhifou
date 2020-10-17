package com.springcloud.zhifou.customer.module.basicinfo.service.impl;

import java.util.ArrayList;
import	java.util.HashMap;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springcloud.kernel.common.constant.Constant;
import com.springcloud.kernel.common.exception.UnifyErrorCode;
import com.springcloud.kernel.common.exception.UnifyException;
import com.springcloud.kernel.common.utils.UtilValidate;
import com.springcloud.zhifou.customer.common.init.UtilCommonCode;
import com.springcloud.zhifou.customer.module.basicinfo.dao.PartyMapper;
import com.springcloud.zhifou.customer.module.basicinfo.entity.Party;
import com.springcloud.zhifou.customer.module.basicinfo.service.PartyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

/**
 * 客户信息服务实现类
 */
@Service
@Slf4j
@Transactional(propagation= Propagation.NESTED,isolation= Isolation.DEFAULT,readOnly = false,rollbackFor=Exception.class)
public class PartyServiceImpl extends ServiceImpl<PartyMapper, Party> implements PartyService {
    @Resource
    private PartyMapper mapper;

    /**
     *
     * 根据客户号查询客户简要信息
     * @param context
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public Map<String, Object> selectCustBasicInfo(Map<String, ? extends Object> context) {
        if (log.isInfoEnabled()) {
            log.info("根据客户号查询客户简要信息【selectCustBasicInfo】开始---->" + context);
        }
        //客户号
        String partyId = (String) context.get("custNo");

        if (UtilValidate.isEmpty(partyId)) {
            throw new UnifyException(UnifyErrorCode.CSRCB30000, MessageFormat.format(UnifyErrorCode.CSRCB30000.getMsg(),"custNo"));
        }
        Map<String, Object> result = new HashMap<String, Object> (16);
        try {
            Party party = mapper.selectById(partyId);
            if (UtilValidate.isNotEmpty(party)) {
                //客户标识
                result.put("custNo", party.getPartyId());
                //客户名称
                result.put("custName", party.getCustName());
                //客户类型
                result.put("partyType", party.getPartyId());
                //增加是否正式客户
                result.put("existingCustomer", party.getExistingCustomer());
                //状态
                result.put("statusId", party.getStatusId());
            }
        } catch (UnifyException e) {
            log.error("查询客户简要信息异常，异常信息{}",e.getMessage());
            throw new UnifyException(UnifyErrorCode.CSRCB10001,MessageFormat.format(UnifyErrorCode.CSRCB10001.getMsg(),e.getMessage()));
        }

        if (log.isInfoEnabled()) {
            log.info("根据客户号查询客户简要信息【selectCustBasicInfo】结束---->" + result);
        }
        return result;
    }

    /**
     *
     * 根据客户号修改客户状态
     * @param context
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> updateCustBasicInfo(Map<String, ? extends Object> context) {
        if (log.isInfoEnabled()) {
            log.info("根据客户号修改客户状态【updateCustBasicInfo】开始---->" + context);
        }
        //客户号
        String partyId = (String) context.get("custNo");
        //状态
        String statusId = (String) context.get("statusId");
        //是否正式客户
        String existingCustomer = (String) context.get("existingCustomer");

        if (UtilValidate.isEmpty(partyId)) {
            throw new UnifyException(UnifyErrorCode.CSRCB30000, MessageFormat.format(UnifyErrorCode.CSRCB30000.getMsg(),"custNo"));
        }
        if (UtilValidate.isEmpty(statusId)) {
            //状态 1-生效状态；0-失效状态；为空，则默认为失效
            statusId = UtilCommonCode.getCodeValueByType("CD001400", "CD001402");
        }

        Map<String, Object> result = new HashMap<String, Object> (16);

        Party party = null;
        try {
            party = mapper.selectById(partyId);
        } catch (UnifyException e) {
            log.error("查询客户简要信息异常，异常信息{}",e.getMessage());
            throw new UnifyException(UnifyErrorCode.CSRCB10001,MessageFormat.format(UnifyErrorCode.CSRCB10001.getMsg(),e.getMessage()));
        }
        if (UtilValidate.isNotEmpty(party)) {
            try {
                party.setStatusId(statusId);
                //如果是否正式客户不为空，进行更新（潜在客户转正式客户使用）
                if (UtilValidate.isNotEmpty(existingCustomer)) {
                    party.setExistingCustomer(existingCustomer);
                }
                Map<String,Object> requestHeadMap = (Map<String, Object>) context.get("requestHead");
                // 更新系统编号
                String orgConsumerId = (String) requestHeadMap.get("orgConsumerId");
                party.setLastSystemId(orgConsumerId);
                // 更新机构
                String branchId = (String) requestHeadMap.get("branchId");
                party.setLastUpdatedOrg(branchId);
                // 更新人
                String tellerNo = (String) requestHeadMap.get("tellerNo");
                party.setLastUpdatedTe(tellerNo);
                UpdateWrapper<Party> updateWrapper = new UpdateWrapper<Party>();
                updateWrapper.eq("party_id",partyId);
                mapper.update(party, updateWrapper);
            } catch (UnifyException e) {
                log.error("修改数据库异常,{}",e.getMessage());
                throw new UnifyException(UnifyErrorCode.CSRCB10003,MessageFormat.format(UnifyErrorCode.CSRCB10003.getMsg(),e.getMessage()));
            }
        } else {
            throw new UnifyException(UnifyErrorCode.CSRCB10005,MessageFormat.format(UnifyErrorCode.CSRCB10005.getMsg(),"Party"));
        }
        //客户号
        result.put("custNo", partyId);
        if (log.isInfoEnabled()) {
            log.info("根据客户号修改客户状态【updateCustBasicInfo】结束---->" + context);
        }
        return result;
    }

    /**
     *
     * 根据客户号查询客户简要信息列表
     * @param context
     * @return
     */
    @Override
    public Map<String, Object> selectCustBasicInfoList(Map<String, ? extends Object> context) {
        if (log.isInfoEnabled()) {
            log.info("根据客户号查询客户简要信息列表【selectCustBasicInfoList】开始" + context);
        }
        //客户类型
        String partyTypeId = (String) context.get("partyType");
        //客户名称
        String partyName = (String) context.get("custName");
        //当前页面
        Integer pageNum = (Integer) context.get("pageNum");
        //页面显示数
        Integer pageSize = (Integer) context.get("pageSize");

        Map<String, Object> result = new HashMap<>(8);

        if (UtilValidate.isEmpty(pageNum)) {
            pageNum = Constant.COMMON_PAGE_NUM;
        }

        if (UtilValidate.isEmpty(pageSize)) {
            pageSize = Constant.COMMON_PAGE_SIZE;
        }

        try {
            QueryWrapper<Party> queryWrapper = new QueryWrapper<>();
            if (UtilValidate.isNotEmpty(partyTypeId)) {
                queryWrapper.eq("party_type_id", partyTypeId);
            }
            if  (UtilValidate.isNotEmpty(partyName)) {
                queryWrapper.eq("cust_name", partyName);
            }
            queryWrapper.eq("status_id", UtilCommonCode.getCodeValueByType("CD001400", "CD001401"));
            //不返回总记录数 设置false
            Page<Party> page = new Page<Party>(pageNum, pageSize, true);
            IPage<Party> iPage = mapper.selectPage(page,queryWrapper);
            List<Map<String, Object>> custBasicInfoList = new ArrayList<Map<String, Object>>(8);
            List<Party> partialList = iPage.getRecords();
            if (UtilValidate.isNotEmpty(partialList)) {
                for (Party party : partialList) {
                    Map<String, Object> info = new HashMap<String, Object> (16);
                    //客户标识
                    info.put("custNo", party.getPartyId());
                    //客户名称
                    info.put("custName", party.getCustName());
                    //客户类型
                    info.put("partyType", party.getPartyTypeId());
                    custBasicInfoList.add(info);
                }
            }
            //信息列表
            result.put("custBasicInfoList", custBasicInfoList);
            result.put("totalNum", iPage.getTotal());
            result.put("pageNum", pageNum);
            result.put("pageSize", pageSize);
        } catch (UnifyException e) {
            log.error("查询数据库异常,{}",e.getMessage());
            throw new UnifyException(UnifyErrorCode.CSRCB10001,MessageFormat.format(UnifyErrorCode.CSRCB10001.getMsg(),e.getMessage()));
        }
        if (log.isInfoEnabled()) {
            log.info("根据客户号查询客户简要信息列表【selectCustBasicInfoList】结束" + context);
        }
        return result;
    }

    /**
     *
     * 判断客户号是否存在
     * @param partyId
     * @return
     * @throws UnifyException
     */
    @Override
    public Boolean selectParty(String partyId) throws UnifyException {
        Map<String, Object> paramMaps = new HashMap<String, Object> (16);
        paramMaps.put("party_id", partyId);
        List<Party> listGv =  mapper.selectByMap(paramMaps);
        Boolean returnParam = true;
        if (UtilValidate.isEmpty(listGv)) {
            returnParam = false;
        }
        return returnParam;
    }

    /**
     *
     * 根据客户号查询正式客户且状态正常的客户简要信息
     * @param context
     * @return
     */
    @Override
    public Map<String, Object> selectCustBasicInfoByCustNo(Map<String, ? extends Object> context) {
        if (log.isInfoEnabled()) {
            log.info("根据客户号查询正式客户且状态正常的客户简要信息【selectCustBasicInfoByCustNo】开始---->" + context);
        }
        //客户号
        String custNo = (String) context.get("custNo");

        if (UtilValidate.isEmpty(custNo)) {
            throw new UnifyException(UnifyErrorCode.CSRCB30000, MessageFormat.format(UnifyErrorCode.CSRCB30000.getMsg(),"custNo"));
        }
        Map<String, Object> result = new HashMap<String, Object> (16);
        try {
            QueryWrapper<Party> queryWrapper = new QueryWrapper<Party>();
            queryWrapper.eq("party_id",custNo);
            //客户状态(0-注销,1-正常)
            queryWrapper.eq("status_id",UtilCommonCode.getCodeValueByType("CD003600", "CD003601"));
            //正式客户标志(0-非正式客户,1-正式客户)
            queryWrapper.eq("existing_customer",UtilCommonCode.getCodeValueByType("CD003600", "CD003601"));
            Party party = mapper.selectOne(queryWrapper);
            if (UtilValidate.isNotEmpty(party)) {
                //客户标识
                result.put("custNo", party.getPartyId());
                //客户名称
                result.put("custName", party.getCustName());
                //客户类型
                result.put("partyTypeId", party.getPartyTypeId());
                //增加是否正式客户
                result.put("existingCustomer", party.getExistingCustomer());
                //状态
                result.put("statusId", party.getStatusId());
            }
        } catch (UnifyException e) {
            log.error("查询客户简要信息异常，异常信息{}",e.getMessage());
            throw new UnifyException(UnifyErrorCode.CSRCB10001,MessageFormat.format(UnifyErrorCode.CSRCB10001.getMsg(),e.getMessage()));
        }

        if (log.isInfoEnabled()) {
            log.info("根据客户号查询正式客户且状态正常的客户简要信息【selectCustBasicInfoByCustNo】结束---->" + result);
        }
        return result;
    }
}
