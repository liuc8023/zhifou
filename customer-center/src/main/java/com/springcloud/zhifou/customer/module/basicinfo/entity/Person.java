package com.springcloud.zhifou.customer.module.basicinfo.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.*;
import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 个人基础信息
 */
@Data
@Accessors(chain = true)
@TableName("person")
@ApiModel(value="Person对象",description="个人基础信息")
public class Person implements Serializable{

    private static final long serialVersionUID=1L;

    /**
     * 客户号
     */
    @TableId(value = "party_id", type = IdType.INPUT)
    @ApiModelProperty(value="客户号",name="partyId",example="")
    private String partyId;

    /**
     * 客户名称
     */
    @TableField(value = "cust_name")
    @ApiModelProperty(value="客户名称",name="custName",example="")
    private String custName;

    /**
     * 性别(0-未知的性别,1-男,2-女，9-未说明的性别)
     */
    @TableField(value = "gender")
    @ApiModelProperty(value="性别(0-未知的性别,1-男,2-女，9-未说明的性别)",name="gender",example="")
    private String gender;

    /**
     * 名
     */
    @TableField(value = "first_name")
    @ApiModelProperty(value="名",name="firstName",example="")
    private String firstName;

    /**
     * 中间名
     */
    @TableField(value = "middle_name")
    @ApiModelProperty(value="中间名",name="middleName",example="")
    private String middleName;

    /**
     * 姓
     */
    @TableField(value = "last_name")
    @ApiModelProperty(value="姓",name="lastName",example="")
    private String lastName;

    /**
     * 头衔
     */
    @TableField(value = "personal_title")
    @ApiModelProperty(value="头衔",name="personalTitle",example="")
    private String personalTitle;

    /**
     * 后缀
     */
    @TableField(value = "suffix")
    @ApiModelProperty(value="后缀",name="suffix",example="")
    private String suffix;

    /**
     * 昵称
     */
    @TableField(value = "nickname")
    @ApiModelProperty(value="昵称",name="nickname",example="")
    private String nickname;

    /**
     * 名本地语言
     */
    @TableField(value = "first_name_local")
    @ApiModelProperty(value="名本地语言",name="firstNameLocal",example="")
    private String firstNameLocal;

    /**
     * 中间名本地语言
     */
    @TableField(value = "middle_name_local")
    @ApiModelProperty(value="中间名本地语言",name="middleNameLocal",example="")
    private String middleNameLocal;

    /**
     * 姓本地语言
     */
    @TableField(value = "last_name_local")
    @ApiModelProperty(value="姓本地语言",name="lastNameLocal",example="")
    private String lastNameLocal;

    /**
     * 其它本地语言
     */
    @TableField(value = "other_local")
    @ApiModelProperty(value="其它本地语言",name="otherLocal",example="")
    private String otherLocal;

    /**
     * 生日
     */
    @TableField(value = "birth_date")
    @ApiModelProperty(value="生日",name="birthDate",example="")
    private Date birthDate;

    /**
     * 民族
     */
    @TableField(value = "nation")
    @ApiModelProperty(value="民族",name="nation",example="")
    private String nation;

    /**
     * 国别
     */
    @TableField(value = "country")
    @ApiModelProperty(value="国别",name="country",example="")
    private String country;

    /**
     * 职业
     */
    @TableField(value = "occupation")
    @ApiModelProperty(value="职业",name="occupation",example="")
    private String occupation;

    /**
     * 境外客户标识
     */
    @TableField(value = "overseas_flag")
    @ApiModelProperty(value="境外客户标识",name="overseasFlag",example="")
    private String overseasFlag;

    /**
     * CRS客户标志
     */
    @TableField(value = "crs_cust_flag")
    @ApiModelProperty(value="CRS客户标志",name="crsCustFlag",example="")
    private String crsCustFlag;

    /**
     * 称呼
     */
    @TableField(value = "salutation")
    @ApiModelProperty(value="称呼",name="salutation",example="")
    private String salutation;

    /**
     * 成员标识
     */
    @TableField(value = "member_id")
    @ApiModelProperty(value="成员标识",name="memberId",example="")
    private String memberId;

    /**
     * 死亡时间
     */
    @TableField(value = "deceased_date")
    @ApiModelProperty(value="死亡时间",name="deceasedDate",example="")
    private Date deceasedDate;

    /**
     * 身高
     */
    @TableField(value = "height")
    @ApiModelProperty(value="身高",name="height",example="")
    private BigDecimal height;

    /**
     * 体重
     */
    @TableField(value = "weight")
    @ApiModelProperty(value="体重",name="weight",example="")
    private BigDecimal weight;

    /**
     * 母亲娘家姓
     */
    @TableField(value = "mothers_maiden_name")
    @ApiModelProperty(value="母亲娘家姓",name="mothersMaidenName",example="")
    private String mothersMaidenName;

    /**
     * 婚姻状态
     */
    @TableField(value = "marital_status")
    @ApiModelProperty(value="婚姻状态",name="maritalStatus",example="")
    private String maritalStatus;

    /**
     * 社保号
     */
    @TableField(value = "social_security_number")
    @ApiModelProperty(value="社保号",name="socialSecurityNumber",example="")
    private String socialSecurityNumber;

    /**
     * 护照号
     */
    @TableField(value = "passport_number")
    @ApiModelProperty(value="护照号",name="passportNumber",example="")
    private String passportNumber;

    /**
     * 护照过期时间
     */
    @TableField(value = "passport_expire_date")
    @ApiModelProperty(value="护照过期时间",name="passportExpireDate",example="")
    private Date passportExpireDate;

    /**
     * 总工作年限
     */
    @TableField(value = "total_years_work_experience")
    @ApiModelProperty(value="总工作年限",name="totalYearsWorkExperience",example="")
    private BigDecimal totalYearsWorkExperience;

    /**
     * 备注
     */
    @TableField(value = "comments")
    @ApiModelProperty(value="备注",name="comments",example="")
    private String comments;

    /**
     * 雇用状态枚举标识
     */
    @TableField(value = "employment_status_enum_id")
    @ApiModelProperty(value="雇用状态枚举标识",name="employmentStatusEnumId",example="")
    private String employmentStatusEnumId;

    /**
     * 居住状态枚举标识
     */
    @TableField(value = "residence_status_enum_id")
    @ApiModelProperty(value="居住状态枚举标识",name="residenceStatusEnumId",example="")
    private String residenceStatusEnumId;

    /**
     * 雇用年数
     */
    @TableField(value = "years_with_employer")
    @ApiModelProperty(value="雇用年数",name="yearsWithEmployer",example="")
    private BigDecimal yearsWithEmployer;

    /**
     * 雇用月数
     */
    @TableField(value = "months_with_employer")
    @ApiModelProperty(value="雇用月数",name="monthsWithEmployer",example="")
    private BigDecimal monthsWithEmployer;

    /**
     * 卡账号
     */
    @TableField(value = "card_id")
    @ApiModelProperty(value="卡账号",name="cardId",example="")
    private String cardId;

    /**
     * 兵团客户标识
     */
    @TableField(value = "corps_flage")
    @ApiModelProperty(value="兵团客户标识",name="corpsFlage",example="")
    private String corpsFlage;

    /**
     * 自贸区客户标识
     */
    @TableField(value = "fta_flag")
    @ApiModelProperty(value="自贸区客户标识",name="ftaFlag",example="")
    private String ftaFlag;

    /**
     * 客户属性
     */
    @TableField(value = "cust_attribute")
    @ApiModelProperty(value="客户属性",name="custAttribute",example="")
    private String custAttribute;

    /**
     * 所在行政区划
     */
    @TableField(value = "contact_addr")
    @ApiModelProperty(value="所在行政区划",name="contactAddr",example="")
    private String contactAddr;

    /**
     * 账户短信提醒号码
     */
    @TableField(value = "acct_note_num")
    @ApiModelProperty(value="账户短信提醒号码",name="acctNoteNum",example="")
    private String acctNoteNum;

    /**
     * 身份类别
     */
    @TableField(value = "identity_type")
    @ApiModelProperty(value="身份类别",name="identityType",example="")
    private String identityType;

    /**
     * 户口性质
     */
    @TableField(value = "register_nature")
    @ApiModelProperty(value="户口性质",name="registerNature",example="")
    private String registerNature;

    /**
     * 涉农属性
     */
    @TableField(value = "agricul_attribute")
    @ApiModelProperty(value="涉农属性",name="agriculAttribute",example="")
    private String agriculAttribute;

    /**
     * 客户类型
     */
    @TableField(value = "cust_type")
    @ApiModelProperty(value="客户类型",name="custType",example="")
    private String custType;

    /**
     * 是否我行股东
     */
    @TableField(value = "whether_mybank_stock")
    @ApiModelProperty(value="是否我行股东",name="whetherMybankStock",example="")
    private String whetherMybankStock;

    /**
     * 是否集团客户
     */
    @TableField(value = "whether_bloc_cust")
    @ApiModelProperty(value="是否集团客户",name="whetherBlocCust",example="")
    private String whetherBlocCust;

    /**
     * 中征码
     */
    @TableField(value = "signature")
    @ApiModelProperty(value="中征码",name="signature",example="")
    private String signature;

    /**
     * 投向行业
     */
    @TableField(value = "invest_trade")
    @ApiModelProperty(value="投向行业",name="investTrade",example="")
    private String investTrade;

    /**
     * 授信客户类型
     */
    @TableField(value = "credit_cust_type")
    @ApiModelProperty(value="授信客户类型",name="creditCustType",example="")
    private String creditCustType;

    /**
     * 与我行关系
     */
    @TableField(value = "with_mybank_relat")
    @ApiModelProperty(value="与我行关系",name="withMybankRelat",example="")
    private String withMybankRelat;

    /**
     * 与我行首次信贷时间
     */
    @TableField(value = "with_mybank_first_credit_time")
    @ApiModelProperty(value="与我行首次信贷时间",name="withMybankFirstCreditTime",example="")
    private Date withMybankFirstCreditTime;

    /**
     * 逾期款金额
     */
    @TableField(value = "overdue_loan_money")
    @ApiModelProperty(value="逾期款金额",name="overdueLoanMoney",example="")
    private BigDecimal overdueLoanMoney;

    /**
     * 逾期贷款原因
     */
    @TableField(value = "overdue_loan_reason")
    @ApiModelProperty(value="逾期贷款原因",name="overdueLoanReason",example="")
    private String overdueLoanReason;

    /**
     * 信用评级日期
     */
    @TableField(value = "credit_rate_date")
    @ApiModelProperty(value="信用评级日期",name="creditRateDate",example="")
    private Date creditRateDate;

    /**
     * 信用评级等级
     */
    @TableField(value = "credit_rate_grade")
    @ApiModelProperty(value="信用评级等级",name="creditRateGrade",example="")
    private String creditRateGrade;

    /**
     * 风险预警信号
     */
    @TableField(value = "risk_early_warning_signal")
    @ApiModelProperty(value="风险预警信号",name="riskEarlyWarningSignal",example="")
    private String riskEarlyWarningSignal;

    /**
     * 不良记录
     */
    @TableField(value = "badness_record")
    @ApiModelProperty(value="不良记录",name="badnessRecord",example="")
    private String badnessRecord;

    /**
     * 健康状况
     */
    @TableField(value = "hralth_status")
    @ApiModelProperty(value="健康状况",name="hralthStatus",example="")
    private String hralthStatus;

    /**
     * 社会声誉
     */
    @TableField(value = "social_reputation")
    @ApiModelProperty(value="社会声誉",name="socialReputation",example="")
    private String socialReputation;

    /**
     * 最高学位
     */
    @TableField(value = "degree")
    @ApiModelProperty(value="最高学位",name="degree",example="")
    private String degree;

    /**
     * 最高学历
     */
    @TableField(value = "academic")
    @ApiModelProperty(value="最高学历",name="academic",example="")
    private String academic;

    /**
     * 年收入（元）
     */
    @TableField(value = "annual_incime")
    @ApiModelProperty(value="年收入（元）",name="annualIncime",example="")
    private BigDecimal annualIncime;

    /**
     * 消费水平（元）
     */
    @TableField(value = "consumption_level")
    @ApiModelProperty(value="消费水平（元）",name="consumptionLevel",example="")
    private BigDecimal consumptionLevel;

    /**
     * 主联系人
     */
    @TableField(value = "principal_linkman")
    @ApiModelProperty(value="主联系人",name="principalLinkman",example="")
    private String principalLinkman;

    /**
     * 主联系人机构
     */
    @TableField(value = "principal_linkman_org")
    @ApiModelProperty(value="主联系人机构",name="principalLinkmanOrg",example="")
    private String principalLinkmanOrg;

    /**
     * 管户开始日期
     */
    @TableField(value = "manageacct_start_date")
    @ApiModelProperty(value="管户开始日期",name="manageacctStartDate",example="")
    private Date manageacctStartDate;

    /**
     * 建立日期
     */
    @TableField(value = "build_date")
    @ApiModelProperty(value="建立日期",name="buildDate",example="")
    private Date buildDate;

    /**
     * 客户是否注销
     */
    @TableField(value = "cust_whether_logout")
    @ApiModelProperty(value="客户是否注销",name="custWhetherLogout",example="")
    private String custWhetherLogout;

    /**
     * 最后更新用户
     */
    @TableField(value = "last_updated_te")
    @ApiModelProperty(value="最后更新用户",name="lastUpdatedTe",example="")
    private String lastUpdatedTe;

    /**
     * 最后更新日期
     */
    @TableField(value = "final_update_time")
    @ApiModelProperty(value="最后更新日期",name="finalUpdateTime",example="")
    private Date finalUpdateTime;

    /**
     * 开户客户经理
     */
    @TableField(value = "open_owner_id")
    @ApiModelProperty(value="开户客户经理",name="openOwnerId",example="")
    private String openOwnerId;

    /**
     * 开户机构
     */
    @TableField(value = "open_owner_org_id")
    @ApiModelProperty(value="开户机构",name="openOwnerOrgId",example="")
    private String openOwnerOrgId;

    /**
     * 是否党员
     */
    @TableField(value = "party_flag")
    @ApiModelProperty(value="是否党员",name="partyFlag",example="")
    private String partyFlag;

    /**
     * 客户拼音名称
     */
    @TableField(value = "cust_name_pinyin")
    @ApiModelProperty(value="客户拼音名称",name="custNamePinyin",example="")
    private String custNamePinyin;

    /**
     * 客户英文名称
     */
    @TableField(value = "cust_name_en")
    @ApiModelProperty(value="客户英文名称",name="custNameEn",example="")
    private String custNameEn;

    /**
     * 英文简称
     */
    @TableField(value = "eng_short_name")
    @ApiModelProperty(value="英文简称",name="engShortName",example="")
    private String engShortName;

    /**
     * 称谓
     */
    @TableField(value = "appellation")
    @ApiModelProperty(value="称谓",name="appellation",example="")
    private String appellation;

    /**
     * 籍贯
     */
    @TableField(value = "native_place")
    @ApiModelProperty(value="籍贯",name="nativePlace",example="")
    private String nativePlace;

    /**
     * 客户综合评估级别
     */
    @TableField(value = "cust_asst_level")
    @ApiModelProperty(value="客户综合评估级别",name="custAsstLevel",example="")
    private String custAsstLevel;

    /**
     * 代理人名称
     */
    @TableField(value = "agent_name")
    @ApiModelProperty(value="代理人名称",name="agentName",example="")
    private String agentName;

    /**
     * 职业状况及其他说明
     */
    @TableField(value = "occ_status_ins")
    @ApiModelProperty(value="职业状况及其他说明",name="occStatusIns",example="")
    private String occStatusIns;

    /**
     * 语言
     */
    @TableField(value = "language")
    @ApiModelProperty(value="语言",name="language",example="")
    private String language;

    /**
     * 主要流动资产
     */
    @TableField(value = "main_cur_assets")
    @ApiModelProperty(value="主要流动资产",name="mainCurAssets",example="")
    private BigDecimal mainCurAssets;

    /**
     * 爱好
     */
    @TableField(value = "hobby")
    @ApiModelProperty(value="爱好",name="hobby",example="")
    private String hobby;

    /**
     * 单位工作起始年
     */
    @TableField(value = "unit_work_date")
    @ApiModelProperty(value="单位工作起始年",name="unitWorkDate",example="")
    private String unitWorkDate;

    /**
     * 投资理财种类
     */
    @TableField(value = "invest_final_type")
    @ApiModelProperty(value="投资理财种类",name="investFinalType",example="")
    private String investFinalType;

    /**
     * 每月还款(人民币)
     */
    @TableField(value = "repay_month")
    @ApiModelProperty(value="每月还款(人民币)",name="repayMonth",example="")
    private BigDecimal repayMonth;

    /**
     * 开户银行数
     */
    @TableField(value = "open_bank_num")
    @ApiModelProperty(value="开户银行数",name="openBankNum",example="")
    private String openBankNum;

    /**
     * 使用银行名称
     */
    @TableField(value = "use_bank_name")
    @ApiModelProperty(value="使用银行名称",name="useBankName",example="")
    private String useBankName;

    /**
     * 政治面貌
     */
    @TableField(value = "political_status")
    @ApiModelProperty(value="政治面貌",name="politicalStatus",example="")
    private String politicalStatus;

    /**
     * 是否本地户籍
     */
    @TableField(value = "local_household_register_flag")
    @ApiModelProperty(value="是否本地户籍",name="localHouseholdRegisterFlag",example="")
    private String localHouseholdRegisterFlag;

    /**
     * 本地居住年限
     */
    @TableField(value = "local_residence_year")
    @ApiModelProperty(value="本地居住年限",name="localResidenceYear",example="")
    private String localResidenceYear;

    /**
     * 是否代发工资
     */
    @TableField(value = "payroll_credit_flag")
    @ApiModelProperty(value="是否代发工资",name="payrollCreditFlag",example="")
    private String payrollCreditFlag;

    /**
     * 代发工资账号
     */
    @TableField(value = "payroll_credit_account")
    @ApiModelProperty(value="代发工资账号",name="payrollCreditAccount",example="")
    private String payrollCreditAccount;

    /**
     * 主观印象其他说明
     */
    @TableField(value = "executive_impression")
    @ApiModelProperty(value="主观印象其他说明",name="executiveImpression",example="")
    private String executiveImpression;

    /**
     * 客户性质
     */
    @TableField(value = "cust_property")
    @ApiModelProperty(value="客户性质",name="custProperty",example="")
    private String custProperty;

    /**
     * 是否属于农民专业合作社
     */
    @TableField(value = "farmer_cooperative_flag")
    @ApiModelProperty(value="是否属于农民专业合作社",name="farmerCooperativeFlag",example="")
    private String farmerCooperativeFlag;

    /**
     * 农民专业合作社营业执照代码
     */
    @TableField(value = "farmer_cooperative_id_card_no")
    @ApiModelProperty(value="农民专业合作社营业执照代码",name="farmerCooperativeIdCardNo",example="")
    private String farmerCooperativeIdCardNo;

    /**
     * 农民专业合作社名称
     */
    @TableField(value = "farmer_cooperative_name")
    @ApiModelProperty(value="农民专业合作社名称",name="farmerCooperativeName",example="")
    private String farmerCooperativeName;

    /**
     * 是否学生
     */
    @TableField(value = "student_flag")
    @ApiModelProperty(value="是否学生",name="studentFlag",example="")
    private String studentFlag;

    /**
     * 学校名称
     */
    @TableField(value = "school_name")
    @ApiModelProperty(value="学校名称",name="schoolName",example="")
    private String schoolName;

    /**
     * 学校地址
     */
    @TableField(value = "school_address")
    @ApiModelProperty(value="学校地址",name="schoolAddress",example="")
    private String schoolAddress;

    /**
     * 学校电话
     */
    @TableField(value = "school_phone")
    @ApiModelProperty(value="学校电话",name="schoolPhone",example="")
    private String schoolPhone;

    /**
     * 学校属性
     */
    @TableField(value = "school_property")
    @ApiModelProperty(value="学校属性",name="schoolProperty",example="")
    private String schoolProperty;

    /**
     * 登记日期
     */
    @TableField(value = "register_date")
    @ApiModelProperty(value="登记日期",name="registerDate",example="")
    private String registerDate;

    /**
     * 登记机构
     */
    @TableField(value = "init_org")
    @ApiModelProperty(value="登记机构",name="initOrg",example="")
    private String initOrg;

    /**
     * 登记人
     */
    @TableField(value = "init_te")
    @ApiModelProperty(value="登记人",name="initTe",example="")
    private String initTe;

    /**
     * 是否面签
     */
    @TableField(value = "visa_flag")
    @ApiModelProperty(value="是否面签",name="visaFlag",example="")
    private String visaFlag;

    /**
     * 联网核查结果
     */
    @TableField(value = "inter_result")
    @ApiModelProperty(value="联网核查结果",name="interResult",example="")
    private String interResult;

    /**
     * 最后联网核查日期
     */
    @TableField(value = "last_inter_result_date")
    @ApiModelProperty(value="最后联网核查日期",name="lastInterResultDate",example="")
    private Date lastInterResultDate;

    /**
     * 税收居民身份
     */
    @TableField(value = "rev_resit_sta")
    @ApiModelProperty(value="税收居民身份",name="revResitSta",example="")
    private String revResitSta;

    /**
     * 税收居民国地区
     */
    @TableField(value = "tax_resi_region")
    @ApiModelProperty(value="税收居民国地区",name="taxResiRegion",example="")
    private String taxResiRegion;

    /**
     * 无法提供纳税人识别号原因
     */
    @TableField(value = "un_pro_mark")
    @ApiModelProperty(value="无法提供纳税人识别号原因",name="unProMark",example="")
    private String unProMark;

    /**
     * 是否取得声明文件
     */
    @TableField(value = "whether_file")
    @ApiModelProperty(value="是否取得声明文件",name="whetherFile",example="")
    private String whetherFile;

    /**
     * 是否他国报税
     */
    @TableField(value = "is_report_tax")
    @ApiModelProperty(value="是否他国报税",name="isReportTax",example="")
    private String isReportTax;

    /**
     * 机构类别
     */
    @TableField(value = "org_type")
    @ApiModelProperty(value="机构类别",name="orgType",example="")
    private String orgType;

    /**
     * 出生国家
     */
    @TableField(value = "birth_country")
    @ApiModelProperty(value="出生国家",name="birthCountry",example="")
    private String birthCountry;

    /**
     * 行政区划编码
     */
    @TableField(value = "regioncode")
    @ApiModelProperty(value="行政区划编码",name="regioncode",example="")
    private String regioncode;

    /**
     * 行政区划名称
     */
    @TableField(value = "regionname")
    @ApiModelProperty(value="行政区划名称",name="regionname",example="")
    private String regionname;

    /**
     * 自然情况其他说明
     */
    @TableField(value = "nature_note")
    @ApiModelProperty(value="自然情况其他说明",name="natureNote",example="")
    private String natureNote;

    /**
     * 性格描述
     */
    @TableField(value = "char_desc")
    @ApiModelProperty(value="性格描述",name="charDesc",example="")
    private String charDesc;

    /**
     * 修养描述
     */
    @TableField(value = "cult_desc")
    @ApiModelProperty(value="修养描述",name="cultDesc",example="")
    private String cultDesc;

    /**
     * 外貌特征
     */
    @TableField(value = "color_desc")
    @ApiModelProperty(value="外貌特征",name="colorDesc",example="")
    private String colorDesc;

    /**
     * 主观印象其他说明
     */
    @TableField(value = "feature_note")
    @ApiModelProperty(value="主观印象其他说明",name="featureNote",example="")
    private String featureNote;

    /**
     * 开拓人
     */
    @TableField(value = "open_up_man")
    @ApiModelProperty(value="开拓人",name="openUpMan",example="")
    private String openUpMan;

    /**
     * 客户曾用名
     */
    @TableField(value = "cust_old_name")
    @ApiModelProperty(value="客户曾用名",name="custOldName",example="")
    private String custOldName;

    /**
     * 从业状况
     */
    @TableField(value = "emp_status")
    @ApiModelProperty(value="从业状况",name="empStatus",example="")
    private String empStatus;

    /**
     * 血型
     */
    @TableField(value = "blood_type")
    @ApiModelProperty(value="血型",name="bloodType",example="")
    private String bloodType;

    /**
     * 宗教信仰
     */
    @TableField(value = "faith_type")
    @ApiModelProperty(value="宗教信仰",name="faithType",example="")
    private String faithType;

    /**
     * 公职人员标志
     */
    @TableField(value = "gwy_flag")
    @ApiModelProperty(value="公职人员标志",name="gwyFlag",example="")
    private String gwyFlag;

    /**
     * 服兵役标识
     */
    @TableField(value = "fby_flag")
    @ApiModelProperty(value="服兵役标识",name="fbyFlag",example="")
    private String fbyFlag;

    /**
     * 建档立卡贫困人口标志
     */
    @TableField(value = "pky_flag")
    @ApiModelProperty(value="建档立卡贫困人口标志",name="pkyFlag",example="")
    private String pkyFlag;

    /**
     * 行内员工号
     */
    @TableField(value = "hannyg")
    @ApiModelProperty(value="行内员工号",name="hannyg",example="")
    private String hannyg;

    /**
     * 无法核实原因（业务相关：身份核实结果）
     */
    @TableField(value = "notcheck_reason")
    @ApiModelProperty(value="无法核实原因（业务相关：身份核实结果）",name="notcheckReason",example="")
    private String notcheckReason;

    /**
     * 处置方法（业务相关：身份核实结果）
     */
    @TableField(value = "handle_plan")
    @ApiModelProperty(value="处置方法（业务相关：身份核实结果）",name="handlePlan",example="")
    private String handlePlan;

    /**
     * 出生地所在省
     */
    @TableField(value = "birth_province")
    @ApiModelProperty(value="出生地所在省",name="birthProvince",example="")
    private String birthProvince;

    /**
     * 出生地所在市
     */
    @TableField(value = "birth_city")
    @ApiModelProperty(value="出生地所在市",name="birthCity",example="")
    private String birthCity;

    /**
     * 英文中间名
     */
    @TableField(value = "eng_mid_name")
    @ApiModelProperty(value="英文中间名",name="engMidName",example="")
    private String engMidName;

    /**
     * 英文姓
     */
    @TableField(value = "eng_surname")
    @ApiModelProperty(value="英文姓",name="engSurname",example="")
    private String engSurname;

    /**
     * 国家
     */
    @TableField(value = "nation_located")
    @ApiModelProperty(value="国家",name="nationLocated",example="")
    private String nationLocated;

    /**
     * 城市
     */
    @TableField(value = "city_located")
    @ApiModelProperty(value="城市",name="cityLocated",example="")
    private String cityLocated;

    /**
     * 小微企业主标识
     */
    @TableField(value = "sole_prptor_flag")
    @ApiModelProperty(value="小微企业主标识",name="solePrptorFlag",example="")
    private String solePrptorFlag;

    /**
     * 月租金（租房用）
     */
    @TableField(value = "mon_rent")
    @ApiModelProperty(value="月租金（租房用）",name="monRent",example="")
    private BigDecimal monRent;

    /**
     * 矛盾情形的合理解释（类似备注-涉税用）
     */
    @TableField(value = "contrad_explain")
    @ApiModelProperty(value="矛盾情形的合理解释（类似备注-涉税用）",name="contradExplain",example="")
    private String contradExplain;

    /**
     * 有无商业保险标志
     */
    @TableField(value = "has_buz_insurance")
    @ApiModelProperty(value="有无商业保险标志",name="hasBuzInsurance",example="")
    private String hasBuzInsurance;

    /**
     * 国家信用等级
     */
    @TableField(value = "state_credit_class")
    @ApiModelProperty(value="国家信用等级",name="stateCreditClass",example="")
    private String stateCreditClass;

    /**
     * 地区风险等级
     */
    @TableField(value = "area_risk_class")
    @ApiModelProperty(value="地区风险等级",name="areaRiskClass",example="")
    private String areaRiskClass;

    /**
     * 登记系统编号
     */
    @TableField(value = "init_system_id")
    @ApiModelProperty(value="登记系统编号",name="initSystemId",example="")
    private String initSystemId;

    /**
     * 创建渠道
     */
    @TableField(value = "init_channel")
    @ApiModelProperty(value="创建渠道",name="initChannel",example="")
    private String initChannel;

    /**
     * 更新系统编号
     */
    @TableField(value = "last_system_id")
    @ApiModelProperty(value="更新系统编号",name="lastSystemId",example="")
    private String lastSystemId;

    /**
     * 更新所属机构
     */
    @TableField(value = "last_updated_org")
    @ApiModelProperty(value="更新所属机构",name="lastUpdatedOrg",example="")
    private String lastUpdatedOrg;

    /**
     * 更新渠道
     */
    @TableField(value = "last_updated_channel")
    @ApiModelProperty(value="更新渠道",name="lastUpdatedChannel",example="")
    private String lastUpdatedChannel;

    /**
     * 创建时间
     */
    @TableField(value = "created_stamp",fill = FieldFill.INSERT)
    @ApiModelProperty(value="创建时间",name="createdStamp",example="")
    private Date createdStamp;

    /**
     * 创建事务时间
     */
    @TableField(value = "created_tx_stamp",fill = FieldFill.INSERT)
    @ApiModelProperty(value="创建事务时间",name="createdTxStamp",example="")
    private Date createdTxStamp;

    /**
     * 最后更新时间
     */
    @TableField(value = "last_updated_stamp",fill = FieldFill.UPDATE)
    @ApiModelProperty(value="最后更新时间",name="lastUpdatedStamp",example="")
    private Date lastUpdatedStamp;

    /**
     * 最后更新事务时间
     */
    @TableField(value = "last_updated_tx_stamp",fill = FieldFill.UPDATE)
    @ApiModelProperty(value="最后更新事务时间",name="lastUpdatedTxStamp",example="")
    private Date lastUpdatedTxStamp;

}
