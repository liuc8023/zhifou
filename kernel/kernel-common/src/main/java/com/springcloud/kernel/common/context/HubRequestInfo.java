package com.springcloud.kernel.common.context;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
* @className HubRequestInfo
* @description 枢纽请求报文信息
* @author liuc
* @date 2019-11-01 10:21
* @since JDK 1.8
**/
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value="请求报文信息",description="请求报文信息")
public class HubRequestInfo<T> {
    private HubRequestHead requestHead;
    private T requestBody;

    public HubRequestHead getRequestHead() {
        return requestHead;
    }

    public void setRequestHead(HubRequestHead requestHead) {
        this.requestHead = requestHead;
    }

    public T getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(T requestBody) {
        this.requestBody = requestBody;
    }

    @Override
    public String toString() {
        return "HubRequestInfo{" +
                "requestHead=" + requestHead +
                ", requestBody=" + requestBody +
                '}';
    }
}
