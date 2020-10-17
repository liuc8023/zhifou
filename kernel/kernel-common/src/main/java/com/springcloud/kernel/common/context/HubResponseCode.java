package com.springcloud.kernel.common.context;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* @className HubResponseCode
* @description 枢纽响应码及响应信息
* @author liuc
* @date 2019-11-01 11:17
* @since JDK 1.8
**/
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value="响应码及响应信息",description="响应码及响应信息")
public class HubResponseCode {
    /**
     * 交易返回码
     */
    @ApiModelProperty(value="交易返回码",name="returnCode",required = true,example="")
    private String returnCode;

    /**
     * 交易返回信息
     */
    @ApiModelProperty(value="交易返回信息",name="returnCode",required = true,example="")
    private String returnMsg;

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    @Override
    public String toString() {
        return "HubResponseCode{" +
                "returnCode='" + returnCode + '\'' +
                ", returnMsg='" + returnMsg + '\'' +
                '}';
    }
}
