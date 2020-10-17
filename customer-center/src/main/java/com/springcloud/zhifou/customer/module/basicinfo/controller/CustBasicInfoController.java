package com.springcloud.zhifou.customer.module.basicinfo.controller;

import	java.util.HashMap;
import com.springcloud.kernel.common.context.HubRequestInfo;
import com.springcloud.kernel.common.context.HubResponseInfo;
import com.springcloud.kernel.common.utils.BeanConvert;
import com.springcloud.kernel.common.utils.JsonUtil;
import com.springcloud.kernel.core.common.core.HubMessageBuilder;
import com.springcloud.zhifou.customer.module.basicinfo.service.PersonService;
import com.springcloud.zhifou.customer.module.dto.basic.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

/**
 * 客户信息前端控制器
 */
@Api(value = "个人客户基础信息管理",tags = "个人客户基础信息管理")
@RestController
@RequestMapping(value = "/CustBasicInfoController")
@Log4j2
public class CustBasicInfoController {
    @Autowired
    private PersonService personService;

    @Autowired
    private HubMessageBuilder hubMessageBuilder;

    @SuppressWarnings("unchecked")
    @RequestMapping("/selectPersonCustBasicInfo")
    @ApiOperation(value = "查询个人客户基础信息",httpMethod = "POST",notes = "查询个人客户基础信息",consumes = "application/json",produces = "application/json")
    public HubResponseInfo<SelectPersonCustBasicInfoOutBean> selectPersonCustBasicInfo(@RequestBody HubRequestInfo<SelectPersonCustBasicInfoInBean> requestInfo){
        log.info("查询个人客户基础信息(selectPersonCustBasicInfo)服务请求报文："+ BeanConvert.toJson(requestInfo));
        HubResponseInfo responseInfo = hubMessageBuilder.buildHubResponse(requestInfo);
        Map requestInfoMap = JsonUtil.parseJsonToMap(BeanConvert.toJson(requestInfo));
        Map<String,Object> context = (Map<String, Object>) requestInfoMap.get("requestBody");
        Map<String,Object> map = personService.selectPersonCustBasicInfo(context);
        responseInfo.setResponseBody(map);
        log.info("查询个人客户基础信息(selectPersonCustBasicInfo)服务返回报文：" + BeanConvert.toJson(responseInfo));
        return responseInfo;
    }
    @SuppressWarnings("unchecked")
    @RequestMapping("/updatePersonCustBasicInfo")
    @ApiOperation(value = "修改个人客户基础信息",httpMethod = "POST",notes = "修改个人客户基础信息",consumes = "application/json",produces = "application/json")
    public HubResponseInfo<UpdatePersonCustBasicInfoOutBean> updatePersonCustBasicInfo(@RequestBody HubRequestInfo<UpdatePersonCustBasicInfoInBean> requestInfo){
        log.info("修改个人客户基础信息(updatePersonCustBasicInfo)服务请求报文："+ BeanConvert.toJson(requestInfo));
        HubResponseInfo responseInfo = hubMessageBuilder.buildHubResponse(requestInfo);
        Map<String,Object> requestInfoMap = JsonUtil.parseJsonToMap(BeanConvert.toJson(requestInfo));
        Map<String,Object> requestHead = (Map<String, Object>) requestInfoMap.get("requestHead");
        Map<String,Object> context = new HashMap<String,Object> (8);
        context.putAll((Map<String, Object>) requestInfoMap.get("requestBody"));
        context.put("requestHead",requestHead);
        Map<String,Object> map = personService.updatePersonCustBasicInfo(context);
        responseInfo.setResponseBody(map);
        log.info("修改个人客户基础信息(updatePersonCustBasicInfo)服务返回报文：" + BeanConvert.toJson(responseInfo));
        return responseInfo;
    }
    @SuppressWarnings("unchecked")
    @RequestMapping("/addPersonCustBasicInfo")
    @ApiOperation(value = "新增个人客户基础信息",httpMethod = "POST",notes = "新增个人客户基础信息",consumes = "application/json",produces = "application/json")
    public HubResponseInfo<AddPersonCustBasicInfoOutBean> addPersonCustBasicInfo(@RequestBody HubRequestInfo<AddPersonCustBasicInfoInBean> requestInfo){
        log.info("新增个人客户基础信息(addPersonCustBasicInfo)服务请求报文："+ BeanConvert.toJson(requestInfo));
        HubResponseInfo responseInfo = hubMessageBuilder.buildHubResponse(requestInfo);
        Map<String,Object> requestInfoMap = JsonUtil.parseJsonToMap(BeanConvert.toJson(requestInfo));
        Map<String,Object> requestHead = (Map<String, Object>) requestInfoMap.get("requestHead");
        Map<String,Object> context = new HashMap<String,Object> (8);
        context.putAll((Map<String, Object>) requestInfoMap.get("requestBody"));
        context.put("requestHead",requestHead);
        Map map = personService.addPersonCustBasicInfo(context);
        responseInfo.setResponseBody(map);
        log.info("新增个人客户基础信息(addPersonCustBasicInfo)服务返回报文：" + BeanConvert.toJson(responseInfo));
        return responseInfo;
    }
}