package com.springcloud.kernel.common.context;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* @className HubRequestHead
* @description 枢纽请求报文头
* @author liuc
* @date 2019-11-01 10:26
* @since JDK 1.8
**/
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value="请求报文头",description="请求报文头")
public class HubRequestHead {

    /**
     * 服务代码
     */
    @ApiModelProperty(value="服务代码",name="serviceCode",required = true,example="")
    private String serviceCode;

    /**
     * 服务场景
     */
    @ApiModelProperty(value="服务场景",name="serviceScene",required = true,example="")
    private String serviceScene;

    /**
     * 消费系统编号
     */
    @ApiModelProperty(value="消费系统编号",name="consumerId",required = true,example="")
    private String consumerId;

    /**
     * 请求方渠道类型
     */
    @ApiModelProperty(value="请求方渠道类型",name="channelTyp",required = false,example="")
    private String channelTyp;

    /**
     * 发起方系统编号
     */
    @ApiModelProperty(value="发起方系统编号",name="orgConsumerId",required = true,example="")
    private String orgConsumerId;

    /**
     * 系统流水号
     */
    @ApiModelProperty(value="系统流水号",name="consumerSeqNo",required = true,example="")
    private String consumerSeqNo;

    /**
     * 发起方业务流水号
     */
    @ApiModelProperty(value="发起方业务流水号",name="orgConsumerSeqNo",required = true,example="")
    private String orgConsumerSeqNo;

    /**
     * 交易模式
     */
    @ApiModelProperty(value="交易模式",name="tranMode",required = false,example="")
    private String tranMode;

    /**
     * 交易日期
     */
    @ApiModelProperty(value="交易日期 yyyyMMdd格式",name="tranDate",required = true,example="20191101")
    private String tranDate;

    /**
     * 交易时间
     */
    @ApiModelProperty(value="交易时间 HHmmss格式",name="tranTime",required = true,example="104327")
    private String tranTime;

    /**
     * 终端号
     */
    @ApiModelProperty(value="终端号",name="terminalCode",required = false,example="")
    private String terminalCode;

    /**
     * 发起方终端号
     */
    @ApiModelProperty(value="发起方终端号",name="orgTerminalCode",required = false,example="")
    private String orgTerminalCode;

    /**
     * 消费系统服务器标识(IP地址)
     */
    @ApiModelProperty(value="消费系统服务器标识(IP地址)",name="consumerSvrId",required = false,example="127.0.0.1")
    private String consumerSvrId;

    /**
     * 发起方系统服务器标识(IP地址)
     */
    @ApiModelProperty(value="发起方系统服务器标识(IP地址)",name="orgConsumerSvrId",required = false,example="127.0.0.1")
    private String orgConsumerSvrId;

    /**
     * 用户语言
     */
    @ApiModelProperty(value="用户语言",name="userLang",required = false,example="")
    private String userLang;

    /**
     * 文件标志
     */
    @ApiModelProperty(value="文件标志",name="filFlg",required = false,example="")
    private String filFlg = "0";

    /**
     * 文件路径
     */
    @ApiModelProperty(value="文件路径",name="filPath",required = false,example="")
    private String filPath;

    /**
     * 柜员号
     */
    @ApiModelProperty(value="柜员号",name="tellerNo",required = false,example="")
    private String tellerNo;

    /**
     * 机构代码
     */
    @ApiModelProperty(value="机构代码",name="branchId",required = false,example="")
    private String branchId;

    /**
     * 柜员密码
     */
    @ApiModelProperty(value="柜员密码",name="tellerPassword",required = false,example="")
    private String tellerPassword;

    /**
     * 柜员级别
     */
    @ApiModelProperty(value="柜员级别",name="tellerLevel",required = false,example="")
    private String tellerLevel;

    /**
     * 柜员类别
     */
    @ApiModelProperty(value="柜员类别",name="tellerType",required = false,example="")
    private String tellerType;

    /**
     * 法人代码
     */
    @ApiModelProperty(value="法人代码",name="legalRepCode",required = true,example="001")
    private String legalRepCode = "001";

    /**
     * MAC值
     */

    private String mac;
    /**
     * 密匙Id(用于Pin,Mac)
     */
    @ApiModelProperty(value="密匙Id",name="keyId",required = false,example="")
    private String keyId;

    /**
     * 服务名
     */
    @ApiModelProperty(value="服务名",name="serviceName",required = false,example="")
    private String serviceName;

    /**
     * 交易码
     */
    @ApiModelProperty(value="交易码",name="tranCode",required = true,example="")
    private String tranCode;

    /**
     * 每页记录数
     */
    @ApiModelProperty(value="每页记录数",name="pageTotalNum",required = false,example="")
    private String pageTotalNum;

    /**
     * 当前页码
     */
    @ApiModelProperty(value="当前页码",name="currentPageNum",required = false,example="")
    private String currentPageNum;

    /**
     * 本页第一笔
     */
    @ApiModelProperty(value="本页第一笔",name="pageStart",required = false,example="")
    private String pageStart;

    /**
     * 本页最后一笔
     */
    @ApiModelProperty(value="本页最后一笔",name="pageEnd",required = false,example="")
    private String pageEnd;

    /**
     * 扩展内容
     */
    @ApiModelProperty(value="扩展内容",name="extendContent",required = false,example="")
    private String extendContent;

    /**
     * 鉴权信息
     */
    @ApiModelProperty(value="鉴权信息",name="servToken",required = false,example="")
    private String servToken;

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceScene() {
        return serviceScene;
    }

    public void setServiceScene(String serviceScene) {
        this.serviceScene = serviceScene;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public String getChannelTyp() {
        return channelTyp;
    }

    public void setChannelTyp(String channelTyp) {
        this.channelTyp = channelTyp;
    }

    public String getOrgConsumerId() {
        return orgConsumerId;
    }

    public void setOrgConsumerId(String orgConsumerId) {
        this.orgConsumerId = orgConsumerId;
    }

    public String getConsumerSeqNo() {
        return consumerSeqNo;
    }

    public void setConsumerSeqNo(String consumerSeqNo) {
        this.consumerSeqNo = consumerSeqNo;
    }

    public String getOrgConsumerSeqNo() {
        return orgConsumerSeqNo;
    }

    public void setOrgConsumerSeqNo(String orgConsumerSeqNo) {
        this.orgConsumerSeqNo = orgConsumerSeqNo;
    }

    public String getTranMode() {
        return tranMode;
    }

    public void setTranMode(String tranMode) {
        this.tranMode = tranMode;
    }

    public String getTranDate() {
        return tranDate;
    }

    public void setTranDate(String tranDate) {
        this.tranDate = tranDate;
    }

    public String getTranTime() {
        return tranTime;
    }

    public void setTranTime(String tranTime) {
        this.tranTime = tranTime;
    }

    public String getTerminalCode() {
        return terminalCode;
    }

    public void setTerminalCode(String terminalCode) {
        this.terminalCode = terminalCode;
    }

    public String getOrgTerminalCode() {
        return orgTerminalCode;
    }

    public void setOrgTerminalCode(String orgTerminalCode) {
        this.orgTerminalCode = orgTerminalCode;
    }

    public String getConsumerSvrId() {
        return consumerSvrId;
    }

    public void setConsumerSvrId(String consumerSvrId) {
        this.consumerSvrId = consumerSvrId;
    }

    public String getOrgConsumerSvrId() {
        return orgConsumerSvrId;
    }

    public void setOrgConsumerSvrId(String orgConsumerSvrId) {
        this.orgConsumerSvrId = orgConsumerSvrId;
    }

    public String getUserLang() {
        return userLang;
    }

    public void setUserLang(String userLang) {
        this.userLang = userLang;
    }

    public String getFilFlg() {
        return filFlg;
    }

    public void setFilFlg(String filFlg) {
        this.filFlg = filFlg;
    }

    public String getFilPath() {
        return filPath;
    }

    public void setFilPath(String filPath) {
        this.filPath = filPath;
    }

    public String getTellerNo() {
        return tellerNo;
    }

    public void setTellerNo(String tellerNo) {
        this.tellerNo = tellerNo;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getTellerPassword() {
        return tellerPassword;
    }

    public void setTellerPassword(String tellerPassword) {
        this.tellerPassword = tellerPassword;
    }

    public String getTellerLevel() {
        return tellerLevel;
    }

    public void setTellerLevel(String tellerLevel) {
        this.tellerLevel = tellerLevel;
    }

    public String getTellerType() {
        return tellerType;
    }

    public void setTellerType(String tellerType) {
        this.tellerType = tellerType;
    }

    public String getLegalRepCode() {
        return legalRepCode;
    }

    public void setLegalRepCode(String legalRepCode) {
        this.legalRepCode = legalRepCode;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getTranCode() {
        return tranCode;
    }

    public void setTranCode(String tranCode) {
        this.tranCode = tranCode;
    }

    public String getPageTotalNum() {
        return pageTotalNum;
    }

    public void setPageTotalNum(String pageTotalNum) {
        this.pageTotalNum = pageTotalNum;
    }

    public String getCurrentPageNum() {
        return currentPageNum;
    }

    public void setCurrentPageNum(String currentPageNum) {
        this.currentPageNum = currentPageNum;
    }

    public String getPageStart() {
        return pageStart;
    }

    public void setPageStart(String pageStart) {
        this.pageStart = pageStart;
    }

    public String getPageEnd() {
        return pageEnd;
    }

    public void setPageEnd(String pageEnd) {
        this.pageEnd = pageEnd;
    }

    public String getExtendContent() {
        return extendContent;
    }

    public void setExtendContent(String extendContent) {
        this.extendContent = extendContent;
    }

    public String getServToken() {
        return servToken;
    }

    public void setServToken(String servToken) {
        this.servToken = servToken;
    }

    @Override
    public String toString() {
        return "HubRequestHead{" +
                "serviceCode='" + serviceCode + '\'' +
                ", serviceScene='" + serviceScene + '\'' +
                ", consumerId='" + consumerId + '\'' +
                ", channelTyp='" + channelTyp + '\'' +
                ", orgConsumerId='" + orgConsumerId + '\'' +
                ", consumerSeqNo='" + consumerSeqNo + '\'' +
                ", orgConsumerSeqNo='" + orgConsumerSeqNo + '\'' +
                ", tranMode='" + tranMode + '\'' +
                ", tranDate='" + tranDate + '\'' +
                ", tranTime='" + tranTime + '\'' +
                ", terminalCode='" + terminalCode + '\'' +
                ", orgTerminalCode='" + orgTerminalCode + '\'' +
                ", consumerSvrId='" + consumerSvrId + '\'' +
                ", orgConsumerSvrId='" + orgConsumerSvrId + '\'' +
                ", userLang='" + userLang + '\'' +
                ", filFlg='" + filFlg + '\'' +
                ", filPath='" + filPath + '\'' +
                ", tellerNo='" + tellerNo + '\'' +
                ", branchId='" + branchId + '\'' +
                ", tellerPassword='" + tellerPassword + '\'' +
                ", tellerLevel='" + tellerLevel + '\'' +
                ", tellerType='" + tellerType + '\'' +
                ", legalRepCode='" + legalRepCode + '\'' +
                ", mac='" + mac + '\'' +
                ", keyId='" + keyId + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", tranCode='" + tranCode + '\'' +
                ", pageTotalNum='" + pageTotalNum + '\'' +
                ", currentPageNum='" + currentPageNum + '\'' +
                ", pageStart='" + pageStart + '\'' +
                ", pageEnd='" + pageEnd + '\'' +
                ", extendContent='" + extendContent + '\'' +
                ", servToken='" + servToken + '\'' +
                '}';
    }
}
