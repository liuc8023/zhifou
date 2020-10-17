package com.springcloud.zhifou.customer.module.dto.basic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 查询个人客户基础信息输出bean
 * @className: SelectPersonCustBasicInfoOutBean
 * @author: liuc
 * @date: 2019-12-12
 */
@Data
@ApiModel(value="查询个人客户基础信息输出bean",description="查询个人客户基础信息输出bean")
public class SelectPersonCustBasicInfoOutBean {
    @ApiModelProperty(name = "custNo", value = "客户号", dataType = "String", example = "")
    private String partyId;

    @ApiModelProperty(name = "custName", value = "客户名称", dataType = "String", example = "")
    private String custName;

    @ApiModelProperty(name = "custType", value = "客户类型", dataType = "String", example = "")
    private String custType;

    @ApiModelProperty(name = "salutation", value = "称呼", dataType = "String", example = "")
    private String salutation;

    @ApiModelProperty(name = "lastName", value = "姓", dataType = "String", example = "")
    private String lastName;

    @ApiModelProperty(name = "personalTitle", value = "头衔", dataType = "String", example = "")
    private String personalTitle;

    @ApiModelProperty(name = "nickname", value = "昵称", dataType = "String", example = "")
    private String nickname;

    @ApiModelProperty(name = "memberId", value = "成员编号", dataType = "String", example = "")
    private String memberId;

    @ApiModelProperty(name = "gender", value = "性别", dataType = "String", example = "")
    private String gender;

    @ApiModelProperty(name = "birthDate", value = "生日", dataType = "String", example = "")
    private String birthDate;

    @ApiModelProperty(name = "height", value = "身高", dataType = "String", example = "")
    private String height;

    @ApiModelProperty(name = "weight", value = "体重", dataType = "String", example = "")
    private String weight;

    @ApiModelProperty(name = "maritalStatus", value = "婚姻状态", dataType = "String", example = "")
    private String maritalStatus;

    @ApiModelProperty(name = "socialSecurityNumber", value = "社保号/社会信用号", dataType = "String", example = "")
    private String socialSecurityNumber;

    @ApiModelProperty(name = "totalYearsWorkExperience", value = "总工作年限", dataType = "String", example = "")
    private String totalYearsWorkExperience;

    @ApiModelProperty(name = "yearsWithEmployer", value = "雇用年数", dataType = "String", example = "")
    private String yearsWithEmployer;

    @ApiModelProperty(name = "monthsWithEmployer", value = "雇用月数", dataType = "String", example = "")
    private String monthsWithEmployer;

    @ApiModelProperty(name = "existingCustomer", value = "正式客户标志", dataType = "String", example = "")
    private String existingCustomer;

    @ApiModelProperty(name = "overseasFlag", value = "境外客户标识", dataType = "String", example = "")
    private String overseasFlag;

    @ApiModelProperty(name = "corpsFlage", value = "兵团客户标识", dataType = "String", example = "")
    private String corpsFlage;

    @ApiModelProperty(name = "ftaFlag", value = "自贸区客户标识", dataType = "String", example = "")
    private String ftaFlag;

    @ApiModelProperty(name = "custAttribute", value = "客户属性", dataType = "String", example = "")
    private String custAttribute;

    @ApiModelProperty(name = "country", value = "国别", dataType = "String", example = "")
    private String country;

    @ApiModelProperty(name = "nation", value = "民族", dataType = "String", example = "")
    private String nation;

    @ApiModelProperty(name = "identityType", value = "身份类别", dataType = "String", example = "")
    private String identityType;

    @ApiModelProperty(name = "registerNature", value = "户口性质", dataType = "String", example = "")
    private String registerNature;

    @ApiModelProperty(name = "agriculAttribute", value = "涉农属性", dataType = "String", example = "")
    private String agriculAttribute;

    @ApiModelProperty(name = "whetherMybankStock", value = "是否我行股东", dataType = "String", example = "")
    private String whetherMybankStock;

    @ApiModelProperty(name = "whetherBlocCust", value = "是否集团客户", dataType = "String", example = "")
    private String whetherBlocCust;

    @ApiModelProperty(name = "signature", value = "中征码", dataType = "String", example = "")
    private String signature;

    @ApiModelProperty(name = "investTrade", value = "投向行业", dataType = "String", example = "")
    private String investTrade;

    @ApiModelProperty(name = "creditCustType", value = "授信客户类型", dataType = "String", example = "")
    private String creditCustType;

    @ApiModelProperty(name = "withMybankRelat", value = "与我行关系", dataType = "String", example = "")
    private String withMybankRelat;

    @ApiModelProperty(name = "withMybankFirstCreditTime", value = "与我行首次信贷时间", dataType = "String", example = "")
    private String withMybankFirstCreditTime;

    @ApiModelProperty(name = "overdueLoanMoney", value = "逾期贷款金额", dataType = "String", example = "")
    private String overdueLoanMoney;

    @ApiModelProperty(name = "overdueLoanReason", value = "逾期贷款原因", dataType = "String", example = "")
    private String overdueLoanReason;

    @ApiModelProperty(name = "creditRateDate", value = "信用评级日期", dataType = "String", example = "")
    private String creditRateDate;

    @ApiModelProperty(name = "creditRateGrade", value = "信用评级等级", dataType = "String", example = "")
    private String creditRateGrade;

    @ApiModelProperty(name = "riskRarlyWarningSignal", value = "风险预警信号", dataType = "String", example = "")
    private String riskRarlyWarningSignal;

    @ApiModelProperty(name = "badnessRecord", value = "不良记录", dataType = "String", example = "")
    private String badnessRecord;

    @ApiModelProperty(name = "hralthStatus", value = "健康状况", dataType = "String", example = "")
    private String hralthStatus;

    @ApiModelProperty(name = "socialReputation", value = "社会声誉", dataType = "String", example = "")
    private String socialReputation;

    @ApiModelProperty(name = "degree", value = "最高学位", dataType = "String", example = "")
    private String degree;

    @ApiModelProperty(name = "academic", value = "最高学历", dataType = "String", example = "")
    private String academic;

    @ApiModelProperty(name = "annualIncime", value = "年收入（元）", dataType = "String", example = "")
    private String annualIncime;

    @ApiModelProperty(name = "consumptionLevel", value = "消费水平（元）", dataType = "String", example = "")
    private String consumptionLevel;

    @ApiModelProperty(name = "manageacctStartDate", value = "管户开始日期", dataType = "String", example = "")
    private String manageacctStartDate;

    @ApiModelProperty(name = "custWhetherLogout", value = "客户是否注销", dataType = "String", example = "")
    private String custWhetherLogout;

    @ApiModelProperty(name = "openOwnerId", value = "开户客户经理", dataType = "String", example = "")
    private String openOwnerId;

    @ApiModelProperty(name = "openOwnerOrgId", value = "开户机构", dataType = "String", example = "")
    private String openOwnerOrgId;

    @ApiModelProperty(name = "partyFlag", value = "是否党员", dataType = "String", example = "")
    private String partyFlag;

    @ApiModelProperty(name = "politicalStatus", value = "政治面貌", dataType = "String", example = "")
    private String politicalStatus;

    @ApiModelProperty(name = "localHouseholdRegisterFlag", value = "是否本地户籍", dataType = "String", example = "")
    private String localHouseholdRegisterFlag;

    @ApiModelProperty(name = "localResidenceYear", value = "本地居住年限", dataType = "String", example = "")
    private String localResidenceYear;

    @ApiModelProperty(name = "payrollCreditFlag", value = "是否代发工资", dataType = "String", example = "")
    private String payrollCreditFlag;

    @ApiModelProperty(name = "payrollCreditAccount", value = "代发工资账号", dataType = "String", example = "")
    private String payrollCreditAccount;

    @ApiModelProperty(name = "hobby", value = "兴趣爱好", dataType = "String", example = "")
    private String hobby;

    @ApiModelProperty(name = "executiveImpression", value = "主观印象其他说明", dataType = "String", example = "")
    private String executiveImpression;

    @ApiModelProperty(name = "custProperty", value = "客户性质", dataType = "String", example = "")
    private String custProperty;

    @ApiModelProperty(name = "farmerCooperativeFlag", value = "是否属于农民专业合作社", dataType = "String", example = "")
    private String farmerCooperativeFlag;

    @ApiModelProperty(name = "farmerCooperativeIdCardNo", value = "农民专业合作社营业执照代码", dataType = "String", example = "")
    private String farmerCooperativeIdCardNo;

    @ApiModelProperty(name = "farmerCooperativeName", value = "农民专业合作社名称", dataType = "String", example = "")
    private String farmerCooperativeName;

    @ApiModelProperty(name = "studentFlag", value = "是否学生", dataType = "String", example = "")
    private String studentFlag;

    @ApiModelProperty(name = "schoolName", value = "学校名称", dataType = "String", example = "")
    private String schoolName;

    @ApiModelProperty(name = "schoolAddress", value = "学校地址", dataType = "String", example = "")
    private String schoolAddress;

    @ApiModelProperty(name = "schoolPhone", value = "学校电话", dataType = "String", example = "")
    private String schoolPhone;

    @ApiModelProperty(name = "schoolProperty", value = "学校属性", dataType = "String", example = "")
    private String schoolProperty;

    @ApiModelProperty(name = "comments", value = "备注", dataType = "String", example = "")
    private String comments;

    @ApiModelProperty(name = "registerDate", value = "登记日期", dataType = "String", example = "")
    private String registerDate;

    @ApiModelProperty(name = "buildDate", value = "创建日期", dataType = "String", example = "")
    private String buildDate;

    @ApiModelProperty(name = "registerOrgId", value = "登记机构", dataType = "String", example = "")
    private String registerOrgId;

    @ApiModelProperty(name = "registerUserLogin", value = "登记人", dataType = "String", example = "")
    private String registerUserLogin;

    @ApiModelProperty(name = "visaFlag", value = "是否面签", dataType = "String", example = "")
    private String visaFlag;

    @ApiModelProperty(name = "lastUpdateTime", value = "最后更新日期", dataType = "String", example = "")
    private String lastUpdateTime;

    @ApiModelProperty(name = "lastUpdateOrgId", value = "最后更新机构", dataType = "String", example = "")
    private String lastUpdateOrgId;

    @ApiModelProperty(name = "lastUpdateCust", value = "最后更新用户", dataType = "String", example = "")
    private String lastUpdateCust;

    @ApiModelProperty(name = "custNamePinyin", value = "客户拼音名称", dataType = "String", example = "")
    private String custNamePinyin;

    @ApiModelProperty(name = "custNameEn", value = "客户英文名称", dataType = "String", example = "")
    private String custNameEn;

    @ApiModelProperty(name = "nativePlace", value = "籍贯", dataType = "String", example = "")
    private String nativePlace;

    @ApiModelProperty(name = "custAsstLevel", value = "客户综合评估级别", dataType = "String", example = "")
    private String custAsstLevel;

    @ApiModelProperty(name = "agentName", value = "代理人名称", dataType = "String", example = "")
    private String agentName;

    @ApiModelProperty(name = "occStatusIns", value = "职业状况及其他说明", dataType = "String", example = "")
    private String occStatusIns;

    @ApiModelProperty(name = "language", value = "语言", dataType = "String", example = "")
    private String language;

    @ApiModelProperty(name = "mainCurAssets", value = "主要流动资产", dataType = "String", example = "")
    private String mainCurAssets;

    @ApiModelProperty(name = "unitWorkDate", value = "单位工作起始年", dataType = "String", example = "")
    private String unitWorkDate;

    @ApiModelProperty(name = "investFinalType", value = "投资理财种类", dataType = "String", example = "")
    private String investFinalType;

    @ApiModelProperty(name = "repayMonth", value = "每月还款(人民币)", dataType = "String", example = "")
    private String repayMonth;

    @ApiModelProperty(name = "openBankNum", value = "开户银行数", dataType = "String", example = "")
    private String openBankNum;

    @ApiModelProperty(name = "useBankName", value = "使用银行名称", dataType = "String", example = "")
    private String useBankName;

    @ApiModelProperty(name = "birthCountry", value = "出生国家", dataType = "String", example = "")
    private String birthCountry;

    @ApiModelProperty(name = "crsCustFlag", value = "CRS客户标志", dataType = "String", example = "")
    private String crsCustFlag;

    @ApiModelProperty(name = "revResitSta", value = "税收居民身份", dataType = "String", example = "")
    private String revResitSta;

    @ApiModelProperty(name = "taxResiRegion", value = "税收居民国地区", dataType = "String", example = "")
    private String taxResiRegion;

    @ApiModelProperty(name = "unProMark", value = "无法提供纳税人识别号原因", dataType = "String", example = "")
    private String unProMark;

    @ApiModelProperty(name = "whetherFile", value = "是否取得声明文件", dataType = "String", example = "")
    private String whetherFile;

    @ApiModelProperty(name = "isReportTax", value = "是否他国报税", dataType = "String", example = "")
    private String isReportTax;

    @ApiModelProperty(name = "orgType", value = "机构类别", dataType = "String", example = "")
    private String orgType;

    @ApiModelProperty(name = "regionCode", value = "行政区划编码", dataType = "String", example = "")
    private String regionCode;

    @ApiModelProperty(name = "regionName", value = "行政区划名称", dataType = "String", example = "")
    private String regionName;

    @ApiModelProperty(name = "occupation", value = "职业", dataType = "String", example = "")
    private String occupation;

    @ApiModelProperty(name = "employmentStatusEnumId", value = "雇用状态", dataType = "String", example = "")
    private String employmentStatusEnumId;

    @ApiModelProperty(name = "interResult", value = "联网核查结果", dataType = "String", example = "")
    private String interResult;

    @ApiModelProperty(name = "lastInterResultDate", value = "最后联网核查日期", dataType = "String", example = "")
    private String lastInterResultDate;

    @ApiModelProperty(name = "passportExpireDate", value = "护照过期时间", dataType = "String", example = "")
    private String passportExpireDate;

    @ApiModelProperty(name = "passportNumber", value = "护照号", dataType = "String", example = "")
    private String passportNumber;

    @ApiModelProperty(name = "residenceStatusEnumId", value = "居住状态", dataType = "String", example = "")
    private String residenceStatusEnumId;

    @ApiModelProperty(name = "principalLinkman", value = "9要素维护人员编号", dataType = "String", example = "")
    private String principalLinkman;
}
