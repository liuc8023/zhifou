package com.springcloud.zhifou.customer.common.constant;

/**
 * 常量类
 */
public class CustomerConstant {

    /**
     * 标准码值大类
     */
    /** 对私证件类型大类  */
    public static final String CODE_VALUE_CD003700 = "CD003700";
    /** 对公证件类型大类  */
    public static final String CODE_VALUE_CD003800 = "CD003800";
    /** 性别大类  */
    public static final String CODE_VALUE_CD001500 = "CD001500";
    /** 国籍大类  */
    public static final String CODE_VALUE_CD050000 = "CD050000";
    /** 职业大类  */
    public static final String CODE_VALUE_CD050700 = "CD050700";
    /** 来源系统大类  */
    public static final String CODE_VALUE_CD050200 = "CD050200";
    /** 民族大类  */
    public static final String CODE_VALUE_CD050100 = "CD050100";
    /** 婚姻状态大类  */
    public static final String CODE_VALUE_CD000400 = "CD000400";
    /** 教育程度大类  */
    public static final String CODE_VALUE_CD004100 = "CD004100";
    /** 职务大类  */
    public static final String CODE_VALUE_CD050900 = "CD050900";
    /** 职称大类  */
    public static final String CODE_VALUE_CD051000 = "CD051000";
    /** 公司业务大类  */
    public static final String CODE_VALUE_CD051500 = "CD051500";
    /** 是否为本行员工、有效标志大类  */
    public static final String CODE_VALUE_CD003600 = "CD003600";
    /** 个人月收入大类  */
    public static final String CODE_VALUE_CD051900 = "CD051900";
    /** 最高学位大类  */
    public static final String CODE_VALUE_CD005300 = "CD005300";
    /** 客户类别、客户综合评估级别大类  */
    public static final String CODE_VALUE_CD051100 = "CD051100";
    /** 居住状况、住房情况大类  */
    public static final String CODE_VALUE_CD051400 = "CD051400";
    /** 健康状况大类  */
    public static final String CODE_VALUE_CD004200 = "CD004200";
    /** 语言大类  */
    public static final String CODE_VALUE_CD052100 = "CD052100";
    /** 爱好大类  */
    public static final String CODE_VALUE_CD051600 = "CD051600";
    /** 希望的联系方式大类  */
    public static final String CODE_VALUE_CD051700 = "CD051700";
    /** 投资理财种类大类  */
    public static final String CODE_VALUE_CD052200 = "CD052200";
    /** 地址类型大类  */
    public static final String CODE_VALUE_CD001000 = "CD001000";
    /** 关系类型大类  */
    public static final String CODE_VALUE_CD000700 = "CD000700";
    /** 税收居民身份大类  */
    public static final String CODE_VALUE_CD051200 = "CD051200";
    /** 币种大类  */
    public static final String CODE_VALUE_CD003200 = "CD003200";
    /** 客户类型(公司及同业)大类  */
    public static final String CODE_VALUE_CD052400 = "CD052400";
    /** 经济成份、出资人经济类型大类  */
    public static final String CODE_VALUE_CD052600 = "CD052600";
    /** 所在行政区域大类  */
    public static final String CODE_VALUE_CD050500 = "CD050500";
    /** 客户类别大类  */
    public static final String CODE_VALUE_CD052500 = "CD052500";
    /** 行业类别大类  */
    public static final String CODE_VALUE_CD004500 = "CD004500";
    /** 企业规模大类  */
    public static final String CODE_VALUE_CD004400 = "CD004400";
    /** 国民经济部门大类  */
    public static final String CODE_VALUE_CD052700 = "CD052700";
    /** 经营组织形式大类  */
    public static final String CODE_VALUE_CD052800 = "CD052800";
    /** 经营组织形式大类  */
    public static final String CODE_VALUE_CD052900 = "CD052900";
    /** 客户风险评估级别大类  */
    public static final String CODE_VALUE_CD053000 = "CD053000";
    /** 经济区域大类  */
    public static final String CODE_VALUE_CD053100 = "CD053100";
    /** 机构类型大类  */
    public static final String CODE_VALUE_CD053300 = "CD053300";
    /** 身份核实结果大类  */
    public static final String CODE_VALUE_CD050800 = "CD050800";
    /** 单位性质大类  */
    public static final String CODE_VALUE_CD051300 = "CD051300";
    /** 家庭月收入大类  */
    public static final String CODE_VALUE_CD052000 = "CD052000";
    /** 希望的联系时间大类  */
    public static final String CODE_VALUE_CD051800 = "CD051800";
    /** 金融机构类型种类大类  */
    public static final String CODE_VALUE_CD053400 = "CD053400";
    /** 我行关联方类型大类  */
    public static final String CODE_VALUE_CD053600 = "CD053600";
    /** 特殊名单类型大类  */
    public static final String CODE_VALUE_CD054000 = "CD054000";
    /** 变更原因大类  */
    public static final String CODE_VALUE_CD054100 = "CD054100";
    /** 签约类型大类  */
    public static final String CODE_VALUE_CD053700 = "CD053700";
    /** 签约状态(对私)大类  */
    public static final String CODE_VALUE_CD053800 = "CD053800";
    /** 签约状态(对公、同业)大类  */
    public static final String CODE_VALUE_CD053900 = "CD053900";
    /** 手机实名验证接口大类  */
    public static final String CODE_VALUE_CD090100 = "CD090100";

    /**
     * 查询个人客户基础信息服务校验项
     */
    public static final String SELECT_PERSON_CUST_BASIC_INFO_CHECK = "custNo=custNo";
    public static final String[] SELECT_PERSON_CUST_BASIC_INFO_CHECK_ITEM = {"custNo"};

    /**
     * 修改个人客户基础信息服务校验项
     */
    public static final String UPDATE_PERSON_CUST_BASIC_INFO_CHECK = "custNo=custNo,custName=custName,existingCustomer=existingCustomer";
    public static final String[] UPDATE_PERSON_CUST_BASIC_INFO_CHECK_ITEM = {"custNo","custName","existingCustomer"};

    /**
     * 新增个人客户基础信息服务校验项
     */
    public static final String ADD_PERSON_CUST_BASIC_INFO_CHECK = "custNo=custNo,custName=custName,existingCustomer=existingCustomer";
    public static final String[] ADD_PERSON_CUST_BASIC_INFO_CHECK_ITEM = {"custNo","custName","existingCustomer"};

    /**
     * 根据客户号查询客户证件信息服务校验项
     */
    public static final String SELECT_CUST_CERTIFICATE_INFO_CHECK = "custNo=custNo,certType=certType,certNo=certNo";
    public static final String[] SELECT_CUST_CERTIFICATE_INFO_CHECK_ITEM = {"custNo","certType","certNo"};
    /**
     * 根据客户号查询客户证件信息服务校验项
     */
    public static final String SELECT_CUST_CERT_INFO_BY_THREE_ELEMENTS_CHECK = "custName=custName,certType=certType,certNo=certNo";
    public static final String[] SELECT_CUST_CERT_INFO_BY_THREE_ELEMENTS_CHECK_ITEM = {"custName","certType","certNo"};
    /**
     * 新增客户证件信息服务校验项
     */
    public static final String ADD_CUST_CERTIFICATE_INFO_CHECK = "custNo=custNo,certType=certType,certNo=certNo,mainFlag=mainFlag";
    public static final String[] ADD_CUST_CERTIFICATE_INFO_CHECK_ITEM = {"custNo","certType","certNo","mainFlag"};
    /**
     * 修改客户证件信息服务校验项
     */
    public static final String UPDATE_CUST_CERTIFICATE_INFO_CHECK = "custNo=custNo,certType=certType,certNo=certNo,mainFlag=mainFlag";
    public static final String[] UPDATE_CUST_CERTIFICATE_INFO_CHECK_ITEM = {"custNo","certType","certNo","mainFlag"};
    /**
     * 删除客户证件信息服务校验项
     */
    public static final String DELETE_CUST_CERTIFICATE_INFO_CHECK = "custNo=custNo,certType=certType,certNo=certNo";
    public static final String[] DELETE_CUST_CERTIFICATE_INFO_CHECK_ITEM = {"custNo","certType","certNo"};
    /**
     * 新增客户收入信息服务校验项
     */
    public static final String ADD_INCOMME_INFO_CHECK = "custNo=custNo,incomeType=incomeType";
    public static final String[] ADD_INCOMME_INFO_CHECK_ITEM = {"custNo","incomeType"};
    /**
     * 修改客户收入信息服务校验项
     */
    public static final String UPDATE_INCOMME_INFO_CHECK = "custNo=custNo,incomeType=incomeType";
    public static final String[] UPDATE_INCOMME_INFO_CHECK_ITEM = {"custNo","incomeType"};
    /**
     * 修改客户收入信息服务校验项
     */
    public static final String SELECT_INCOMME_INFO_CHECK = "custNo=custNo";
    public static final String[] SELECT_INCOMME_INFO_CHECK_ITEM = {"custNo"};


    public static final String UPDATE_CUST_TICKET_INFO_CHECK = "custNo=custNo,partyInvoiceInfoId=partyInvoiceInfoId";
    public static final String[] UPDATE_CUST_TICKET_INFO_CHECK_ITEM = {"custNo,partyInvoiceInfoId"};

}
