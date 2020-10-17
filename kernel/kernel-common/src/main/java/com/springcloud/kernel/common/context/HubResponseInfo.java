package com.springcloud.kernel.common.context;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.springcloud.kernel.common.exception.UnifyErrorCode;
import com.springcloud.kernel.common.exception.UnifyException;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
* @className HubResponseInfo
* @description 枢纽响应报文信息
* @author liuc
* @date 2019-11-01 13:09
* @since JDK 1.8
**/
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value="响应报文信息",description="响应报文信息")
public class HubResponseInfo<T> {
    private HubResponseHead responseHead;

    private T responseBody;

    @JsonIgnore
    public void setSuccess()
    {
        HubResponseHead responseHead = getResponseHead();
        if (responseHead == null) {
            responseHead = new HubResponseHead();
            setResponseHead(responseHead);
        }

        responseHead.setReturnStatus("S");
        HubResponseCode code = new HubResponseCode();
        code.setReturnCode("000000");
        code.setReturnMsg("交易成功");
        responseHead.setRet(new HubResponseCode[] { code });
    }
    @JsonIgnore
    public void setError(UnifyErrorCode error) {
        setError(error.getCode(), error.getMsg());
    }
    @JsonIgnore
    public void setError(UnifyErrorCode error, String message) {
        setError(error.getCode(), message);
    }

    @JsonIgnore
    public void setError(UnifyException exption)
    {
        setError(exption.getErrorCode().getCode(), exption.getMessage());
    }

    @JsonIgnore
    public void setError(String errCode, String mesage)
    {
        HubResponseHead responseHead = getResponseHead();
        if (responseHead == null) {
            responseHead = new HubResponseHead();
            setResponseHead(responseHead);
        }

        responseHead.setReturnStatus("F");
        HubResponseCode code = new HubResponseCode();
        code.setReturnCode(errCode);
        code.setReturnMsg(mesage);
        responseHead.setRet(new HubResponseCode[] { code });
    }
    @JsonIgnore
    public boolean isSuccess() {
        return "S".equalsIgnoreCase(getResponseHead().getReturnStatus());
    }

    public HubResponseHead getResponseHead() {
        return responseHead;
    }

    public void setResponseHead(HubResponseHead responseHead) {
        this.responseHead = responseHead;
    }

    public T getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(T responseBody) {
        this.responseBody = responseBody;
    }

    @Override
    public String toString() {
        return "HubResponseInfo{" +
                "responseHead=" + responseHead +
                ", responseBody=" + responseBody +
                '}';
    }
}
