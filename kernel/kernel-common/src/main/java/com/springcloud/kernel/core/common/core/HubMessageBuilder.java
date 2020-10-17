package com.springcloud.kernel.core.common.core;

import com.springcloud.kernel.common.context.HubRequestHead;
import com.springcloud.kernel.common.context.HubRequestInfo;
import com.springcloud.kernel.common.context.HubResponseHead;
import com.springcloud.kernel.common.context.HubResponseInfo;
import com.springcloud.kernel.common.utils.Convert;
import com.springcloud.kernel.constraint.ISerNoGenerator;
import com.springcloud.kernel.core.common.config.HubHelpConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.net.InetAddress;
import java.util.Date;

@Component
public class HubMessageBuilder {
    @Autowired
    private HubHelpConfig hubHelpConfig;
    @Autowired
    private ISerNoGenerator iSerNoGenerator;
    private String ip;

    public HubMessageBuilder(HubHelpConfig hubHelpConfig, ISerNoGenerator iSerNoGenerator)
    {
        this.hubHelpConfig = hubHelpConfig;
        this.iSerNoGenerator = iSerNoGenerator;
        try {
            this.ip = InetAddress.getLocalHost().getHostAddress();
        }
        catch (Exception localException)
        {
        }
    }

    public <T> HubRequestInfo<T> buildHubRequest()
    {
        String serno = null;
        if (this.iSerNoGenerator != null) {
            serno = this.iSerNoGenerator.getRandomSerno();
        }
        return buildHubRequest(serno);
    }

    @SuppressWarnings("unchecked")
    public <T> HubRequestInfo<T> buildHubRequest(String serno)
    {
        HubRequestInfo requestInfo = new HubRequestInfo();

        HubRequestHead reqHead = new HubRequestHead();

        requestInfo.setRequestHead(reqHead);

        reqHead.setConsumerId(this.hubHelpConfig.getSysId());
        reqHead.setOrgConsumerId(this.hubHelpConfig.getSysId());
        reqHead.setConsumerSeqNo(serno);
        reqHead.setOrgConsumerSeqNo(serno);

        reqHead.setChannelTyp(this.hubHelpConfig.getChannelTyp());

        reqHead.setConsumerSvrId(this.ip);
        reqHead.setOrgConsumerSvrId(this.ip);

        reqHead.setUserLang("CHINESE");

        Date date = new Date();
        reqHead.setTranDate(Convert.toString(date, "yyyyMMdd"));
        reqHead.setTranTime(Convert.toString(date, "HHmmss"));

        reqHead.setFilFlg("0");
        reqHead.setLegalRepCode("001");

        return requestInfo;
    }

    public <T> HubResponseInfo<T> buildHubResponse()
    {
        return buildHubResponse(new HubRequestHead(), null);
    }

    public <T> HubResponseInfo<T> buildHubResponse(String serno)
    {
        return buildHubResponse(new HubRequestHead(), serno);
    }

    public <T> HubResponseInfo<T> buildHubResponse(HubRequestInfo requestInfo)
    {
        return buildHubResponse(requestInfo.getRequestHead());
    }

    public <T> HubResponseInfo<T> buildHubResponse(HubRequestInfo requestInfo, String serno)
    {
        return buildHubResponse(requestInfo.getRequestHead(), serno);
    }

    public <T> HubResponseInfo<T> buildHubResponse(HubRequestHead requestHead)
    {
        String serno = null;
        if (this.iSerNoGenerator != null) {
            serno = this.iSerNoGenerator.getRandomSerno();
        }
        return buildHubResponse(requestHead, serno);
    }

    @SuppressWarnings("unchecked")
    public <T> HubResponseInfo<T> buildHubResponse(HubRequestHead requestHead, String serno)
    {
        HubResponseInfo responseInfo = new HubResponseInfo();
        HubResponseHead responseHead = new HubResponseHead();
        responseInfo.setResponseHead(responseHead);

        if (requestHead != null)
        {
            responseHead.setServiceCode(requestHead.getServiceCode());
            responseHead.setServiceScene(requestHead.getServiceScene());
            responseHead.setConsumerId(requestHead.getConsumerId());
            responseHead.setOrgConsumerId(requestHead.getOrgConsumerId());
            responseHead.setConsumerSeqNo(requestHead.getConsumerSeqNo());
            responseHead.setOrgConsumerSeqNo(requestHead.getOrgConsumerSeqNo());
            responseHead.setTerminalCode(requestHead.getTerminalCode());
            responseHead.setOrgTerminalCode(requestHead.getOrgTerminalCode());
            responseHead.setConsumerSvrId(requestHead.getConsumerSvrId());
            responseHead.setOrgConsumerSvrId(requestHead.getOrgConsumerSvrId());
            responseHead.setUserLang(requestHead.getUserLang());
        }

        responseHead.setSplrSeqNo(serno);

        responseHead.setDestSvrId(this.ip);
        responseHead.setTargetId(this.hubHelpConfig.getSysId());

        responseHead.setFilFlg("0");

        Date date = new Date();
        responseHead.setTranDate(Convert.toString(date, "yyyyMMdd"));
        responseHead.setTranTime(Convert.toString(date, "HHmmss"));

        return responseInfo;
    }

    public HubMessageBuilder() {
    }

    public HubMessageBuilder(HubHelpConfig hubHelpConfig, ISerNoGenerator iSerNoGenerator, String ip) {
        this.hubHelpConfig = hubHelpConfig;
        this.iSerNoGenerator = iSerNoGenerator;
        this.ip = ip;
    }
}
