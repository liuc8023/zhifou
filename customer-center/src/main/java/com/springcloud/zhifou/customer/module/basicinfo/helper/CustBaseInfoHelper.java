package com.springcloud.zhifou.customer.module.basicinfo.helper;

import com.springcloud.kernel.common.exception.UnifyErrorCode;
import com.springcloud.kernel.common.exception.UnifyException;
import com.springcloud.kernel.common.utils.ArithmeticUtil;
import com.springcloud.kernel.common.utils.DateUtil;
import com.springcloud.kernel.common.utils.StringUtil;
import com.springcloud.kernel.common.utils.UtilValidate;
import com.springcloud.zhifou.customer.common.constant.CustomerConstant;
import com.springcloud.zhifou.customer.common.init.UtilCommonCode;
import com.springcloud.zhifou.customer.module.basicinfo.entity.Person;
import com.springcloud.zhifou.customer.common.util.CommCheckUtil;

import java.text.MessageFormat;
import java.util.Map;


public class CustBaseInfoHelper implements ICustBaseInfoHelper {
    public static final String MODULE = CustBaseInfoHelper.class.getName();

    /**
     * 个人客户基础信息，新增、修改参数
     * @param context
     * @return map
     * @throws UnifyException
     * @date 2019/11/19 9:19
     * @author liuc
     **/
    @Override
    public Person custPerBasicInfoParam(Map<String, ?> context) throws UnifyException {
        Person person = new Person();
        // 客户号
        String custNo = (String)context.get("custNo");
        if (UtilValidate.isNotEmpty(custNo)) {
            person.setPartyId(custNo);
        }
        // 客户名称
        String custName = (String)context.get("custName");
        if (UtilValidate.isNotEmpty(custName)) {
            person.setCustName(custName);
        }
        // 称呼
        String salutation = (String)context.get("salutation");
        if (UtilValidate.isNotEmpty(salutation)) {
            person.setSalutation(salutation);
        }
        // 名
        String firstName = (String)context.get("firstName");
        if (UtilValidate.isNotEmpty(firstName)) {
            person.setFirstName(firstName);
        }
        // 中间名
        String middleName = (String)context.get("middleName");
        if (UtilValidate.isNotEmpty(middleName)) {
            person.setMiddleName(middleName);
        }
        // 姓
        String lastName = (String)context.get("lastName");
        if (UtilValidate.isNotEmpty(lastName)) {
            person.setLastName(lastName);
        }
        // 头衔
        String personalTitle = (String)context.get("personalTitle");
        if (UtilValidate.isNotEmpty(personalTitle)) {
            person.setPersonalTitle(personalTitle);
        }
        // 后缀
        String suffix = (String)context.get("suffix");
        if (UtilValidate.isNotEmpty(suffix)) {
            person.setSuffix(suffix);
    }
        // 昵称
        String nickname = (String)context.get("nickname");
        if (UtilValidate.isNotEmpty(nickname)) {
            person.setNickname(nickname);
        }
        // 姓名本地语言
        String firstNameLocal = (String)context.get("firstNameLocal");
        if (UtilValidate.isNotEmpty(firstNameLocal)) {
            person.setFirstNameLocal(firstNameLocal);
        }
        // 中间名本地语言
        String middleNameLocal = (String)context.get("middleNameLocal");
        if (UtilValidate.isNotEmpty(middleNameLocal)) {
            person.setMiddleNameLocal(middleNameLocal);
        }
        // 姓本地语言
        String lastNameLocal = (String)context.get("lastNameLocal");
        if (UtilValidate.isNotEmpty(lastNameLocal)) {
            person.setLastNameLocal(lastNameLocal);
        }
        // 其它本地语言
        String otherLocal = (String)context.get("otherLocal");
        if (UtilValidate.isNotEmpty(otherLocal)) {
            person.setOtherLocal(otherLocal);
        }
        // 成员标识
        String memberId = (String)context.get("memberId");
        if (UtilValidate.isNotEmpty(memberId)) {
            person.setMemberId(memberId);
        }
        // 母亲娘家姓
        String mothersMaidenName = (String)context.get("mothersMaidenName");
        if (UtilValidate.isNotEmpty(mothersMaidenName)) {
            person.setMothersMaidenName(mothersMaidenName);
        }
        // 婚姻状态
        String maritalStatus = (String)context.get("maritalStatus");
        if (UtilValidate.isNotEmpty(maritalStatus)) {
            person.setMaritalStatus(maritalStatus);
        }
        // 社保号
        String socialSecurityNumber = (String)context.get("socialSecurityNumber");
        if (UtilValidate.isNotEmpty(socialSecurityNumber)) {
            person.setSocialSecurityNumber(socialSecurityNumber);
        }
        // 护照号
        String passportNumber = (String)context.get("passportNumber");
        if (UtilValidate.isNotEmpty(passportNumber)) {
            person.setPassportNumber(passportNumber);
        }
        // 备注
        String comments = (String)context.get("comments");
        if (UtilValidate.isNotEmpty(comments)) {
            person.setComments(comments);
        }
        // 雇用年数
        String yearsWithEmployer = (String)context.get("yearsWithEmployer");
        if (UtilValidate.isNotEmpty(yearsWithEmployer)) {
            person.setYearsWithEmployer(ArithmeticUtil.stringToBigDecimal(yearsWithEmployer));
        }
        // 雇用月数
        String monthsWithEmployer = (String)context.get("monthsWithEmployer");
        if (UtilValidate.isNotEmpty(monthsWithEmployer)) {
            person.setMonthsWithEmployer(ArithmeticUtil.stringToBigDecimal(monthsWithEmployer));
        }
        // 境外客户标识
        String overseasFlag = (String)context.get("overseasFlag");
        if (UtilValidate.isNotEmpty(overseasFlag)) {
            person.setOverseasFlag(overseasFlag);
        }
        // 兵团客户标识
        String corpsFlage = (String)context.get("corpsFlage");
        if (UtilValidate.isNotEmpty(corpsFlage)) {
            person.setCorpsFlage(corpsFlage);
        }
        // 自贸区客户标识
        String ftaFlag = (String)context.get("ftaFlag");
        if (UtilValidate.isNotEmpty(ftaFlag)) {
            person.setFtaFlag(ftaFlag);
        }
        // 客户属性
        String custAttribute = (String)context.get("custAttribute");
        if (UtilValidate.isNotEmpty(custAttribute)) {
            person.setCustAttribute(custAttribute);
        }
        // 性别
        String gender = (String)context.get("gender");
        if (UtilValidate.isNotEmpty(context.get("gender"))) {
            person.setGender(gender);
        }
        // 国别
        String country = (String)context.get("country");
        if (UtilValidate.isNotEmpty(country)) {
            person.setCountry(country);
        }
        // 民族
        String nation = (String)context.get("nation");
        if (UtilValidate.isNotEmpty(nation)) {
            person.setNation(nation);
        }
        // 所在行政区划
        String contactAddr = (String)context.get("contactAddr");
        if (UtilValidate.isNotEmpty(contactAddr)) {
            person.setContactAddr(contactAddr);
        }
        // 账户短信提醒号码
        String acctNoteNum = (String)context.get("acctNoteNum");
        if (UtilValidate.isNotEmpty(acctNoteNum)) {
            person.setAcctNoteNum(acctNoteNum);
        }
        // 身份类别
        String identityType = (String)context.get("identityType");
        if (UtilValidate.isNotEmpty(identityType)) {
            person.setIdentityType(identityType);
        }
        // 户口性质
        String registerNature = (String)context.get("registerNature");
        if (UtilValidate.isNotEmpty(registerNature)) {
            person.setRegisterNature(registerNature);
        }
        // 涉农属性
        String agriculAttribute = (String)context.get("agriculAttribute");
        if (UtilValidate.isNotEmpty(agriculAttribute)) {
            person.setAgriculAttribute(agriculAttribute);
        }
        // 客户类型
        String custType = (String)context.get("custType");
        if (UtilValidate.isNotEmpty(custType)) {
            person.setCustType(custType);
        }
        // 是否我行股东
        String whetherMybankStock = (String)context.get("whetherMybankStock");
        if (UtilValidate.isNotEmpty(whetherMybankStock)) {
            person.setWhetherMybankStock(whetherMybankStock);
        }
        // 是否集团客户
        String whetherBlocCust = (String)context.get("whetherBlocCust");
        if (UtilValidate.isNotEmpty(whetherBlocCust)) {
            person.setWhetherBlocCust(whetherBlocCust);
        }
        // 中征码
        String signature = (String)context.get("signature");
        if (UtilValidate.isNotEmpty(signature)) {
            person.setSignature(signature);
        }
        // 投向行业
        String investTrade = (String)context.get("investTrade");
        if (UtilValidate.isNotEmpty(investTrade)) {
            person.setInvestTrade(investTrade);
        }
        // 授信客户类型
        String creditCustType = (String)context.get("creditCustType");
        if (UtilValidate.isNotEmpty(creditCustType)) {
            person.setCreditCustType(creditCustType);
        }
        // 与我行关系
        String withMybankRelat = (String)context.get("withMybankRelat");
        if (UtilValidate.isNotEmpty(withMybankRelat)) {
            person.setWithMybankRelat(withMybankRelat);
        }
        // 逾期贷款原因
        String overdueLoanReason = (String)context.get("overdueLoanReason");
        if (UtilValidate.isNotEmpty(overdueLoanReason)) {
            person.setOverdueLoanReason(overdueLoanReason);
        }
        // 信用评级等级
        String creditRateGrade = (String)context.get("creditRateGrade");
        if (UtilValidate.isNotEmpty(creditRateGrade)) {
            person.setCreditRateGrade(creditRateGrade);
        }
        // 风险预警信号
        String riskEarlyWarningSignal = (String)context.get("riskEarlyWarningSignal");
        if (UtilValidate.isNotEmpty(riskEarlyWarningSignal)) {
            person.setRiskEarlyWarningSignal(riskEarlyWarningSignal);
        }
        // 不良记录
        String badnessRecord = (String)context.get("badnessRecord");
        if (UtilValidate.isNotEmpty(badnessRecord)) {
            person.setBadnessRecord(badnessRecord);
        }
        // 健康状况
        String hralthStatus = (String)context.get("hralthStatus");
        if (UtilValidate.isNotEmpty(hralthStatus)) {
            person.setHralthStatus(hralthStatus);
        }
        // 社会声誉
        String socialReputation = (String)context.get("socialReputation");
        if (UtilValidate.isNotEmpty(socialReputation)) {
            person.setSocialReputation(socialReputation);
        }
        // 最高学位
        String degree = (String)context.get("degree");
        if (UtilValidate.isNotEmpty(degree)) {
            person.setDegree(degree);
        }
        // 最高学历
        String academic = (String)context.get("academic");
        if (UtilValidate.isNotEmpty(academic)) {
            person.setAcademic(academic);
        }
        // 客户是否注销
        String custWhetherLogout = (String)context.get("custWhetherLogout");
        if (UtilValidate.isNotEmpty(custWhetherLogout)) {
            person.setCustWhetherLogout(custWhetherLogout);
        }
        // 开户客户经理
        String openOwnerId = (String)context.get("openOwnerId");
        if (UtilValidate.isNotEmpty(openOwnerId)) {
            person.setOpenOwnerId(openOwnerId);
        }
        // 开户机构
        String openOwnerOrgId = (String)context.get("openOwnerOrgId");
        if (UtilValidate.isNotEmpty(openOwnerOrgId)) {
            person.setOpenOwnerOrgId(openOwnerOrgId);
        }
        // 是否党员
        String partyFlag = (String)context.get("partyFlag");
        if (UtilValidate.isNotEmpty(partyFlag)) {
            person.setPartyFlag(partyFlag);
        }
        // 客户拼音名称
        String custNamePinyin = (String)context.get("custNamePinyin");
        if (UtilValidate.isNotEmpty(custNamePinyin)) {
            person.setCustNamePinyin(custNamePinyin);
        }
        // 客户英文名称
        String custNameEn = (String)context.get("custNameEn");
        if (UtilValidate.isNotEmpty(custNameEn)) {
            person.setCustNameEn(custNameEn);
        }
        // 英文简称
        String engShortName = (String)context.get("engShortName");
        if (UtilValidate.isNotEmpty(engShortName)) {
            person.setEngShortName(engShortName);
        }
        // 称谓
        String appellation = (String)context.get("appellation");
        if (UtilValidate.isNotEmpty(appellation)) {
            person.setAppellation(appellation);
        }
        // 籍贯
        String nativePlace = (String)context.get("nativePlace");
        if (UtilValidate.isNotEmpty(nativePlace)) {
            person.setNativePlace(nativePlace);
        }
        // 客户综合评估级别
        String custAsstLevel = (String)context.get("custAsstLevel");
        if (UtilValidate.isNotEmpty(custAsstLevel)) {
            person.setCustAsstLevel(custAsstLevel);
        }
        // 代理人名称
        String agentName = (String)context.get("agentName");
        if (UtilValidate.isNotEmpty(agentName)) {
            person.setAgentName(agentName);
        }
        // 职业状况及其他说明
        String occStatusIns = (String)context.get("occStatusIns");
        if (UtilValidate.isNotEmpty(occStatusIns)) {
            person.setOccStatusIns(occStatusIns);
        }
        // 语言
        String language = (String)context.get("language");
        if (UtilValidate.isNotEmpty(language)) {
            person.setLanguage(language);
        }
        // 爱好
        String hobby = (String)context.get("hobby");
        if (UtilValidate.isNotEmpty(hobby)) {
            person.setHobby(hobby);
        }
        // 单位工作起始年
        String unitWorkDate = (String)context.get("unitWorkDate");
        if (UtilValidate.isNotEmpty(unitWorkDate)) {
            person.setUnitWorkDate(unitWorkDate);
        }
        // 投资理财种类
        String investFinalType = (String)context.get("investFinalType");
        if (UtilValidate.isNotEmpty(investFinalType)) {
            person.setInvestFinalType(investFinalType);
        }
        // 开户银行数
        String openBankNum = (String)context.get("openBankNum");
        if (UtilValidate.isNotEmpty(openBankNum)) {
            person.setOpenBankNum(openBankNum);
        }
        // CRS客户标志
        String crsCustFlag = (String)context.get("crsCustFlag");
        if (UtilValidate.isNotEmpty(crsCustFlag)) {
            person.setCrsCustFlag(crsCustFlag);
        }
        // 使用银行名称
        String useBankName = (String)context.get("useBankName");
        if (UtilValidate.isNotEmpty(useBankName)) {
            person.setUseBankName(useBankName);
        }
        // 政治面貌
        String politicalStatus = (String)context.get("politicalStatus");
        if (UtilValidate.isNotEmpty(politicalStatus)) {
            person.setPoliticalStatus(politicalStatus);
        }
        // 是否本地户籍
        String localHouseholdRegisterFlag = (String)context.get("localHouseholdRegisterFlag");
        if (UtilValidate.isNotEmpty(localHouseholdRegisterFlag)) {
            person.setLocalHouseholdRegisterFlag(localHouseholdRegisterFlag);
        }
        // 本地居住年限
        String localResidenceYear = (String)context.get("localResidenceYear");
        if (UtilValidate.isNotEmpty(localResidenceYear)) {
            person.setLocalResidenceYear(localResidenceYear);
        }
        // 是否代发工资
        String payrollCreditFlag = (String)context.get("payrollCreditFlag");
        if (UtilValidate.isNotEmpty(payrollCreditFlag)) {
            person.setPayrollCreditFlag(payrollCreditFlag);
        }
        // 代发工资账号
        String payrollCreditAccount = (String)context.get("payrollCreditAccount");
        if (UtilValidate.isNotEmpty(payrollCreditAccount)) {
            person.setPayrollCreditAccount(payrollCreditAccount);
        }
        // 主观印象其他说明
        String executiveImpression = (String)context.get("executiveImpression");
        if (UtilValidate.isNotEmpty(executiveImpression)) {
            person.setExecutiveImpression(executiveImpression);
        }
        // 客户性质
        String custProperty = (String)context.get("custProperty");
        if (UtilValidate.isNotEmpty(custProperty)) {
            person.setCustProperty(custProperty);
        }
        // 是否属于农民专业合作社
        String farmerCooperativeFlag = (String)context.get("farmerCooperativeFlag");
        if (UtilValidate.isNotEmpty(farmerCooperativeFlag)) {
            person.setFarmerCooperativeFlag(farmerCooperativeFlag);
        }
        // 农民专业合作社营业执照代码
        String farmerCooperativeIdCardNo = (String)context.get("farmerCooperativeIdCardNo");
        if (UtilValidate.isNotEmpty(farmerCooperativeIdCardNo)) {
            person.setFarmerCooperativeIdCardNo(farmerCooperativeIdCardNo);
        }
        // 农民专业合作社名称
        String farmerCooperativeName = (String)context.get("farmerCooperativeName");
        if (UtilValidate.isNotEmpty(farmerCooperativeName)) {
            person.setFarmerCooperativeName(farmerCooperativeName);
        }
        // 是否学生
        String studentFlag = (String)context.get("studentFlag");
        if (UtilValidate.isNotEmpty(studentFlag)) {
            person.setStudentFlag(studentFlag);
        }
        // 学校名称
        String schoolName = (String)context.get("schoolName");
        if (UtilValidate.isNotEmpty(schoolName)) {
            person.setSchoolName(schoolName);
        }
        // 学校地址
        String schoolAddress = (String)context.get("schoolAddress");
        if (UtilValidate.isNotEmpty(schoolAddress)) {
            person.setSchoolAddress(schoolAddress);
        }
        // 学校电话
        String schoolPhone = (String)context.get("schoolPhone");
        if (UtilValidate.isNotEmpty(schoolPhone)) {
            person.setSchoolPhone(schoolPhone);
        }
        // 学校属性
        String schoolProperty = (String)context.get("schoolProperty");
        if (UtilValidate.isNotEmpty(schoolProperty)) {
            person.setSchoolProperty(schoolProperty);
        }
        // 登记机构
        String initOrg = (String)context.get("initOrg");
        if (UtilValidate.isNotEmpty(initOrg)) {
            person.setInitOrg(initOrg);
        }
        // 登记人
        String initTe = (String)context.get("initTe");
        if (UtilValidate.isNotEmpty(initTe)) {
            person.setInitTe(initTe);
        }
        // 是否面签
        String visaFlag = (String)context.get("visaFlag");
        if (UtilValidate.isNotEmpty(visaFlag)) {
            person.setVisaFlag(visaFlag);
        }
        // 联网核查结果
        String interResult = (String)context.get("interResult");
        if (UtilValidate.isNotEmpty(interResult)) {
            person.setInterResult(interResult);
        }
        //税收居民身份
        String revResitSta = (String)context.get("revResitSta");
        if (UtilValidate.isNotEmpty(revResitSta)) {
            person.setRevResitSta(revResitSta);
        }
        //税收居民国地区
        String taxResiRegion = (String)context.get("taxResiRegion");
        if (UtilValidate.isNotEmpty(taxResiRegion)) {
            person.setTaxResiRegion(taxResiRegion);
        }
        //无法提供纳税人识别号原因
        String unProMark = (String)context.get("unProMark");
        if (UtilValidate.isNotEmpty(unProMark)) {
            person.setUnProMark(unProMark);
        }
        //是否取得声明文件
        String whetherFile = (String)context.get("whetherFile");
        if (UtilValidate.isNotEmpty(whetherFile)) {
            person.setWhetherFile(whetherFile);
        }
        //是否他国报税
        String isReportTax = (String)context.get("isReportTax");
        if (UtilValidate.isNotEmpty(isReportTax)) {
            person.setIsReportTax(isReportTax);
        }
        //机构类别
        String orgType = (String)context.get("orgType");
        if (UtilValidate.isNotEmpty(orgType)) {
            person.setOrgType(orgType);
        }
        //出生国家
        String birthCountry = (String)context.get("birthCountry");
        if (UtilValidate.isNotEmpty(birthCountry)) {
            person.setBirthCountry(birthCountry);
        }
        //行政区划编码
        String regionCode = (String)context.get("regionCode");
        if (UtilValidate.isNotEmpty(regionCode)) {
            person.setRegioncode(regionCode);
        }
        //行政区划名称
        String regionName = (String)context.get("regionName");
        if (UtilValidate.isNotEmpty(regionName)) {
            person.setRegionname(regionName);
        }
        //最后更新用户
        String lastUpdatedTe = (String)context.get("lastUpdatedTe");
        if (UtilValidate.isNotEmpty(lastUpdatedTe)) {
            person.setLastUpdatedTe(lastUpdatedTe);
        }
        //职业
        String occupation = (String)context.get("occupation");
        if (UtilValidate.isNotEmpty(occupation)) {
            person.setOccupation(occupation);
        }
        //雇用状态
        String employmentStatusEnumId = (String)context.get("employmentStatusEnumId");
        if (UtilValidate.isNotEmpty(employmentStatusEnumId)) {
            person.setEmploymentStatusEnumId(employmentStatusEnumId);
        }
        //居住状态
        String residenceStatusEnumId = (String)context.get("residenceStatusEnumId");
        if (UtilValidate.isNotEmpty(residenceStatusEnumId)) {
            person.setResidenceStatusEnumId(residenceStatusEnumId);
        }
        //登记日期
        String registerDate = (String)context.get("registerDate");
        if (UtilValidate.isNotEmpty(registerDate)) {
            person.setRegisterDate(registerDate);
        }
        //时间类型字段统一处理
        try {
            // 与我行首次信贷时间
            String withMybankFirstCreditTime = (String)context.get("withMybankFirstCreditTime");
            if (UtilValidate.isNotEmpty(withMybankFirstCreditTime)) {
                person.setWithMybankFirstCreditTime(
                        DateUtil.formatUtilDateToSqlDate(withMybankFirstCreditTime));
            }
            // 护照过期时间
            String passportExpireDate = (String)context.get("passportExpireDate");
            if (UtilValidate.isNotEmpty(passportExpireDate)) {
                person.setPassportExpireDate(DateUtil.formatUtilDateToSqlDate(passportExpireDate));
            }
            // 出生日期
            String birthDate = (String)context.get("birthDate");
            if (UtilValidate.isNotEmpty(birthDate)) {
                person.setBirthDate(DateUtil.formatUtilDateToSqlDate(birthDate));
            }
            // 信用评级日期
            String creditRateDate = (String)context.get("creditRateDate");
            if (UtilValidate.isNotEmpty(creditRateDate)) {
                person.setCreditRateDate(DateUtil.formatUtilDateToSqlDate(creditRateDate));
            }
            //管户开始日期
            String manageacctStartDate = (String)context.get("manageacctStartDate");
            if (UtilValidate.isNotEmpty(manageacctStartDate)) {
                person.setManageacctStartDate(DateUtil.formatUtilDateToSqlDate(manageacctStartDate));
            }
            //建立日期
            String buildDate = (String)context.get("buildDate");
            if (UtilValidate.isNotEmpty(buildDate)) {
                person.setBuildDate(DateUtil.formatUtilDateToSqlDate(buildDate));
            }
            // 最后联网核查日期
            String lastInterResultDate = (String)context.get("lastInterResultDate");
            if (UtilValidate.isNotEmpty(lastInterResultDate)) {
                person.setLastInterResultDate(DateUtil.formatUtilDateToSqlDate(lastInterResultDate));
            }
            //最后更新时间
            String lastUpdateTime = (String)context.get("lastUpdateTime");
            if (UtilValidate.isNotEmpty(lastUpdateTime)) {
                person.setFinalUpdateTime(DateUtil.formatUtilDateToSqlDate(lastUpdateTime));
            }
        } catch (Exception e) {
            throw new UnifyException(UnifyErrorCode.CSRCB10000,e.getMessage());
        }
        try {
            //身高
            String height = (String)context.get("height");
            if (UtilValidate.isNotEmpty(height)) {
                person.setHeight(ArithmeticUtil.getBigDecimal(ArithmeticUtil
                        .getBigDecimalPoint(height,
                                StringUtil.stringToInt(
                                        UtilCommonCode.getCodeValueByType("CD003500", "CD003502")))));
            }
            // 体重
            String weight = (String)context.get("weight");
            if (UtilValidate.isNotEmpty(weight)) {
                person.setWeight(ArithmeticUtil.getBigDecimal(ArithmeticUtil
                        .getBigDecimalPoint(weight,
                                StringUtil.stringToInt(
                                        UtilCommonCode.getCodeValueByType("CD003500", "CD003502")))));
            }
            // 总工作年限
            String totalYearsWorkExperience = (String)context.get("totalYearsWorkExperience");
            if (UtilValidate.isNotEmpty(totalYearsWorkExperience)) {
                person.setTotalYearsWorkExperience(ArithmeticUtil.getBigDecimal(ArithmeticUtil
                        .getBigDecimalPoint(totalYearsWorkExperience,
                                StringUtil.stringToInt(
                                        UtilCommonCode.getCodeValueByType("CD003500", "CD003502")))));
            }
            // 逾期贷款金额
            String overdueLoanMoney = (String)context.get("overdueLoanMoney");
            if (UtilValidate.isNotEmpty(overdueLoanMoney)) {
                person.setOverdueLoanMoney(ArithmeticUtil.getBigDecimal(ArithmeticUtil
                        .getBigDecimalPoint(overdueLoanMoney,
                                StringUtil.stringToInt(
                                        UtilCommonCode.getCodeValueByType("CD003500", "CD003502")))));
            }
            // 消费水平（元）
            String consumptionLevel = (String)context.get("consumptionLevel");
            if (UtilValidate.isNotEmpty(consumptionLevel)) {
                person.setConsumptionLevel(ArithmeticUtil.getBigDecimal(ArithmeticUtil
                        .getBigDecimalPoint(consumptionLevel,
                                StringUtil.stringToInt(
                                        UtilCommonCode.getCodeValueByType("CD003500", "CD003502")))));
            }
            // 主要流动资产
            String mainCurAssets = (String)context.get("mainCurAssets");
            if (UtilValidate.isNotEmpty(mainCurAssets)) {
                person.setMainCurAssets(ArithmeticUtil.getBigDecimal(ArithmeticUtil
                        .getBigDecimalPoint(mainCurAssets,
                                StringUtil.stringToInt(
                                        UtilCommonCode.getCodeValueByType("CD003500", "CD003502")))));
            }
            // 每月还款(人民币)
            String repayMonth = (String)context.get("repayMonth");
            if (UtilValidate.isNotEmpty(repayMonth)) {
                person.setRepayMonth(ArithmeticUtil.getBigDecimal(ArithmeticUtil
                        .getBigDecimalPoint(repayMonth,
                                StringUtil.stringToInt(
                                        UtilCommonCode.getCodeValueByType("CD003500", "CD003502")))));
            }
            // 每月还款(人民币)
            String monRent = (String)context.get("monRent");
            if (UtilValidate.isNotEmpty(monRent)) {
                person.setMonRent(ArithmeticUtil.getBigDecimal(ArithmeticUtil
                        .getBigDecimalPoint(monRent,
                                StringUtil.stringToInt(
                                        UtilCommonCode.getCodeValueByType("CD003500", "CD003502")))));
            }
        } catch (Exception e) {
            throw new UnifyException(UnifyErrorCode.CSRCB10025,UnifyErrorCode.CSRCB10025.getMsg());
        }
        //自然情况其他说明
        String natureNote = (String)context.get("natureNote");
        if (UtilValidate.isNotEmpty(natureNote)) {
            person.setNatureNote(natureNote);
        }
        //性格描述
        String charDesc = (String)context.get("charDesc");
        if (UtilValidate.isNotEmpty(charDesc)) {
            person.setCharDesc(charDesc);
        }
        //修养描述
        String cultDesc = (String)context.get("cultDesc");
        if (UtilValidate.isNotEmpty(cultDesc)) {
            person.setCultDesc(cultDesc);
        }
        //外貌特征
        String colorDesc = (String)context.get("colorDesc");
        if (UtilValidate.isNotEmpty(colorDesc)) {
            person.setColorDesc(colorDesc);
        }
        //主观印象其他说明
        String featureNote = (String)context.get("featureNote");
        if (UtilValidate.isNotEmpty(featureNote)) {
            person.setFeatureNote(featureNote);
        }
        //开拓人
        String openUpMan = (String)context.get("openUpMan");
        if (UtilValidate.isNotEmpty(openUpMan)) {
            person.setOpenUpMan(openUpMan);
        }
        //客户曾用名
        String custOldName = (String)context.get("custOldName");
        if (UtilValidate.isNotEmpty(custOldName)) {
            person.setCustOldName(custOldName);
        }
        //从业状况
        String empStatus = (String)context.get("empStatus");
        if (UtilValidate.isNotEmpty(empStatus)) {
            person.setEmpStatus(empStatus);
        }
        //血型
        String bloodType = (String)context.get("bloodType");
        if (UtilValidate.isNotEmpty(bloodType)) {
            person.setBloodType(bloodType);
        }
        //宗教信仰
        String faithType = (String)context.get("faithType");
        if (UtilValidate.isNotEmpty(faithType)) {
            person.setFaithType(faithType);
        }
        //公职人员标志
        String gwyFlag = (String)context.get("gwyFlag");
        if (UtilValidate.isNotEmpty(gwyFlag)) {
            person.setGwyFlag(gwyFlag);
        }
        //服兵役标识
        String fbyFlag = (String)context.get("fbyFlag");
        if (UtilValidate.isNotEmpty(fbyFlag)) {
            person.setFbyFlag(fbyFlag);
        }
        //建档立卡贫困人口标志
        String pkyFlag = (String)context.get("pkyFlag");
        if (UtilValidate.isNotEmpty(pkyFlag)) {
            person.setPkyFlag(pkyFlag);
        }
        //行内员工号
        String hannyg = (String)context.get("hannyg");
        if (UtilValidate.isNotEmpty(hannyg)) {
            person.setHannyg(hannyg);
        }
        //无法核实原因（业务相关：身份核实结果）
        String notcheckReason = (String)context.get("notcheckReason");
        if (UtilValidate.isNotEmpty(notcheckReason)) {
            person.setNotcheckReason(notcheckReason);
        }
        //处置方法（业务相关：身份核实结果）
        String handlePlan = (String)context.get("handlePlan");
        if (UtilValidate.isNotEmpty(handlePlan)) {
            person.setHandlePlan(handlePlan);
        }
        //出生地所在省
        String birthProvince = (String)context.get("birthProvince");
        if (UtilValidate.isNotEmpty(birthProvince)) {
            person.setBirthProvince(birthProvince);
        }
        //出生地所在市
        String birthCity = (String)context.get("birthCity");
        if (UtilValidate.isNotEmpty(birthCity)) {
            person.setBirthCity(birthCity);
        }
        //英文中间名
        String engMidName = (String)context.get("engMidName");
        if (UtilValidate.isNotEmpty(engMidName)) {
            person.setEngMidName(engMidName);
        }
        //英文姓
        String engSurname = (String)context.get("engSurname");
        if (UtilValidate.isNotEmpty(engSurname)) {
            person.setEngSurname(engSurname);
        }
        //国家
        String nationLocated = (String)context.get("nationLocated");
        if (UtilValidate.isNotEmpty(nationLocated)) {
            person.setNationLocated(nationLocated);
        }
        //城市
        String cityLocated = (String)context.get("cityLocated");
        if (UtilValidate.isNotEmpty(cityLocated)) {
            person.setCityLocated(cityLocated);
        }
        //小微企业主标识
        String solePrptorFlag = (String)context.get("solePrptorFlag");
        if (UtilValidate.isNotEmpty(solePrptorFlag)) {
            person.setSolePrptorFlag(solePrptorFlag);
        }
        //矛盾情形的合理解释（类似备注-涉税用）
        String contradExplain = (String)context.get("contradExplain");
        if (UtilValidate.isNotEmpty(contradExplain)) {
            person.setContradExplain(contradExplain);
        }
        //有无商业保险标志
        String hasBuzInsurance = (String)context.get("hasBuzInsurance");
        if (UtilValidate.isNotEmpty(hasBuzInsurance)) {
            person.setHasBuzInsurance(hasBuzInsurance);
        }
        //国家信用等级
        String stateCreditClass = (String)context.get("stateCreditClass");
        if (UtilValidate.isNotEmpty(stateCreditClass)) {
            person.setStateCreditClass(stateCreditClass);
        }
        //地区风险等级
        String areaRiskClass = (String)context.get("areaRiskClass");
        if (UtilValidate.isNotEmpty(areaRiskClass)) {
            person.setAreaRiskClass(areaRiskClass);
        }
        // 主联系人
        String principalLinkman = (String)context.get("principalLinkman");
        if (UtilValidate.isNotEmpty(principalLinkman)) {
            person.setPrincipalLinkman(principalLinkman);
        }
        return person;
    }

    /**
     * 校验字段是否在标准码范围内
     * @param context
     * @return
     * @throws
     * @date 2019/12/4 18:08
     * @author liuc
     **/
    @Override
    public void checkCodeValue(Map<String, ?> context) {
        //如果性别不为空，校验性别是否在标准码范围内
        String gender = (String) context.get("gender");
        if (UtilValidate.isNotEmpty(gender)) {
            boolean flag = CommCheckUtil.checkOptRule(CustomerConstant.CODE_VALUE_CD001500,gender);
            if (!flag) {
                throw new UnifyException(UnifyErrorCode.CSRCB30002, MessageFormat.format(UnifyErrorCode.CSRCB30002.getMsg(),"性别",gender));
            }
        }
        //如果婚姻状态不为空，校验婚姻状态是否在标准码值范围内
        String maritalStatus = (String) context.get("maritalStatus");
        if (UtilValidate.isNotEmpty(maritalStatus)) {
            boolean flag = CommCheckUtil.checkOptRule(CustomerConstant.CODE_VALUE_CD000400,maritalStatus);
            if (!flag) {
                throw new UnifyException(UnifyErrorCode.CSRCB30002, MessageFormat.format(UnifyErrorCode.CSRCB30002.getMsg(),"婚姻状态",maritalStatus));
            }
        }
        //如果国籍不为空，校验国籍是否在标准码值范围内
        String country = (String) context.get("country");
        if (UtilValidate.isNotEmpty(country)) {
            boolean flag = CommCheckUtil.checkOptRule(CustomerConstant.CODE_VALUE_CD050000,country);
            if (!flag) {
                throw new UnifyException(UnifyErrorCode.CSRCB30002, MessageFormat.format(UnifyErrorCode.CSRCB30002.getMsg(),"国籍",country));
            }
        }
        //如果民族不为空，校验民族是否在标准码值范围内
        String nation = (String) context.get("nation");
        if (UtilValidate.isNotEmpty(nation)) {
            boolean flag = CommCheckUtil.checkOptRule(CustomerConstant.CODE_VALUE_CD050100,nation);
            if (!flag) {
                throw new UnifyException(UnifyErrorCode.CSRCB30002, MessageFormat.format(UnifyErrorCode.CSRCB30002.getMsg(),"nation",nation));
            }
        }
        //如果健康状况不为空，校验健康状况是否在标准码值范围内
        String hralthStatus = (String) context.get("hralthStatus");
        if (UtilValidate.isNotEmpty(hralthStatus)) {
            boolean flag = CommCheckUtil.checkOptRule(CustomerConstant.CODE_VALUE_CD005300,hralthStatus);
            if (!flag) {
                throw new UnifyException(UnifyErrorCode.CSRCB30002, MessageFormat.format(UnifyErrorCode.CSRCB30002.getMsg(),"健康状况",hralthStatus));
            }
        }
        //如果最高学位不为空，校验最高学位是否在标准码值范围内
        String degree = (String) context.get("degree");
        if (UtilValidate.isNotEmpty(degree)) {
            boolean flag = CommCheckUtil.checkOptRule(CustomerConstant.CODE_VALUE_CD005300,degree);
            if (!flag) {
                throw new UnifyException(UnifyErrorCode.CSRCB30002, MessageFormat.format(UnifyErrorCode.CSRCB30002.getMsg(),"最高学位",degree));
            }
        }
        //如果最高学历不为空，校验最高学历是否在标准码值范围内
        String academic = (String) context.get("academic");
        if (UtilValidate.isNotEmpty(academic)) {
            boolean flag = CommCheckUtil.checkOptRule(CustomerConstant.CODE_VALUE_CD004100,academic);
            if (!flag) {
                throw new UnifyException(UnifyErrorCode.CSRCB30002, MessageFormat.format(UnifyErrorCode.CSRCB30002.getMsg(),"最高学历",academic));
            }
        }
        //如果客户综合评估级别不为空，校验客户综合评估级别是否在标准码值范围内
        String custAsstLevel = (String) context.get("custAsstLevel");
        if (UtilValidate.isNotEmpty(custAsstLevel)) {
            boolean flag = CommCheckUtil.checkOptRule(CustomerConstant.CODE_VALUE_CD051100,custAsstLevel);
            if (!flag) {
                throw new UnifyException(UnifyErrorCode.CSRCB30002, MessageFormat.format(UnifyErrorCode.CSRCB30002.getMsg(),"客户综合评估级别",custAsstLevel));
            }
        }
        //如果语言不为空，校验语言是否在标准码值范围内
        String language = (String) context.get("language");
        if (UtilValidate.isNotEmpty(language)) {
            boolean flag = CommCheckUtil.checkOptRule(CustomerConstant.CODE_VALUE_CD052100,language);
            if (!flag) {
                throw new UnifyException(UnifyErrorCode.CSRCB30002, MessageFormat.format(UnifyErrorCode.CSRCB30002.getMsg(),"语言",language));
            }
        }
        //如果爱好不为空，校验爱好是否在标准码值范围内
        String hobby = (String) context.get("hobby");
        if (UtilValidate.isNotEmpty(hobby)) {
            boolean flag = CommCheckUtil.checkOptRule(CustomerConstant.CODE_VALUE_CD051600,hobby);
            if (!flag) {
                throw new UnifyException(UnifyErrorCode.CSRCB30002, MessageFormat.format(UnifyErrorCode.CSRCB30002.getMsg(),"爱好",hobby));
            }
        }
        //如果出生国家不为空，校验出生国家是否在标准码值范围内
        String birthCountry = (String) context.get("birthCountry");
        if (UtilValidate.isNotEmpty(birthCountry)) {
            boolean flag = CommCheckUtil.checkOptRule(CustomerConstant.CODE_VALUE_CD050000,birthCountry);
            if (!flag) {
                throw new UnifyException(UnifyErrorCode.CSRCB30002, MessageFormat.format(UnifyErrorCode.CSRCB30002.getMsg(),"出生国家",birthCountry));
            }
        }
        //如果职业不为空，校验职业是否在标准码值范围内
        String occupation = (String) context.get("occupation");
        if (UtilValidate.isNotEmpty(occupation)) {
            boolean flag = CommCheckUtil.checkOptRule(CustomerConstant.CODE_VALUE_CD050700,occupation);
            if (!flag) {
                throw new UnifyException(UnifyErrorCode.CSRCB30002, MessageFormat.format(UnifyErrorCode.CSRCB30002.getMsg(),"职业",occupation));
            }
        }
        //如果是否为本行员工不为空，校验是否为本行员工是否在标准码值范围内
        String withMybankRelat = (String) context.get("withMybankRelat");
        if (UtilValidate.isNotEmpty(withMybankRelat)) {
            boolean flag = CommCheckUtil.checkOptRule(CustomerConstant.CODE_VALUE_CD003600,withMybankRelat);
            if (!flag) {
                throw new UnifyException(UnifyErrorCode.CSRCB30002, MessageFormat.format(UnifyErrorCode.CSRCB30002.getMsg(),"是否为本行员工",withMybankRelat));
            }
        }

    }
}
