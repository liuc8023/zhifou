package com.springcloud.kernel.core.common.config;

import org.springframework.stereotype.Component;

@Component
public class HubHelpConfig {
    /**
     * 业务枢纽网关
     */
    private String gateway;
    /**
     * 本系统系统编号
     */
    private String sysId;
    /**
     * 渠道类型
     */
    private String channelTyp = "99";

    public String getGateway() {
        return this.gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    public String getChannelTyp() {
        return this.channelTyp;
    }

    public void setChannelTyp(String channelTyp) {
        this.channelTyp = channelTyp;
    }

    public String getSysId() {
        return this.sysId;
    }

    public void setSysId(String sysId) {
        this.sysId = sysId;
    }
}