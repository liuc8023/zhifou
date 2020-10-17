package com.springcloud.zhifou.customer.module.basicinfo.service.impl;

import java.text.MessageFormat;
import	java.util.HashMap;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springcloud.kernel.common.constant.Constant;
import com.springcloud.kernel.common.exception.UnifyErrorCode;
import com.springcloud.kernel.common.exception.UnifyException;
import com.springcloud.kernel.common.utils.BeanConvert;
import com.springcloud.kernel.common.utils.BeanMapUtil;
import com.springcloud.kernel.common.utils.DateUtil;
import com.springcloud.kernel.common.utils.UtilValidate;
import com.springcloud.zhifou.customer.common.constant.CustomerConstant;
import com.springcloud.zhifou.customer.common.init.UtilCommonCode;
import com.springcloud.zhifou.customer.module.basicinfo.dao.PartyMapper;
import com.springcloud.zhifou.customer.module.basicinfo.dao.PersonMapper;
import com.springcloud.zhifou.customer.module.basicinfo.entity.Party;
import com.springcloud.zhifou.customer.module.basicinfo.entity.Person;
import com.springcloud.zhifou.customer.module.basicinfo.helper.CustBaseInfoHelper;
import com.springcloud.zhifou.customer.module.basicinfo.helper.ICustBaseInfoHelper;
import com.springcloud.zhifou.customer.module.basicinfo.service.PersonService;
import com.springcloud.zhifou.customer.common.util.CommCheckUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.Map;

/**
 * 个人基础信息服务实现类
 * @className: Person
 * @author: liuc
 * @date: 2019-11-06
 */
@Service
@Slf4j
@Transactional(propagation= Propagation.NESTED,isolation= Isolation.DEFAULT,readOnly = false,rollbackFor=Exception.class)
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements PersonService {
    @Resource
    private PartyMapper partyMapper;
    @Resource
    private PersonMapper personMapper;

    /**
     * 查询个人客户基础信息
     * @param context
     * @return 
     * @throws 
     * @date 2019/11/21 9:34 
     * @author liuc
     **/
    @Transactional(readOnly = true)
    @Override
    public Map<String,Object> selectPersonCustBasicInfo(Map<String, ? extends Object> context) {
        if (log.isInfoEnabled()) {
            log.info("查询个人客户基础信息【selectPersonCustBasicInfo】开始---->" + context);
        }
        Map<String, Object> checkParam = CommCheckUtil.strTokenToMap(CustomerConstant.SELECT_PERSON_CUST_BASIC_INFO_CHECK, Constant.COMMA, Constant.EQUAL);
        //非空校验
        CommCheckUtil.requiredCheck(checkParam, BeanConvert.toMap(context,CustomerConstant.SELECT_PERSON_CUST_BASIC_INFO_CHECK_ITEM));

        //返回结果集
        Map<String, Object> resultMap = new HashMap<> (8);
        //客户号
        String custNo = (String) context.get("custNo");
        Party party = null;
        try {
            party = partyMapper.selectById(custNo);
        } catch (UnifyException e1) {
            log.error("查询客户信息异常，异常信息{}",e1.getMessage());
            throw new UnifyException(UnifyErrorCode.CSRCB10001,MessageFormat.format(UnifyErrorCode.CSRCB10001.getMsg(),e1.getMessage()));
        }
        // 如果客户号不存在或者客户已删除，则返回空结果集
        if (UtilValidate.isEmpty(party)) {
            return resultMap;
        } else {
            if (UtilValidate.areEqual(UtilCommonCode.getCodeValueByType("CD001400", "CD001402"), party.getStatusId())) {
                log.error("当前客户号【{}】已经失效",custNo);
                throw new UnifyException(UnifyErrorCode.CSRCB20001,MessageFormat.format(UnifyErrorCode.CSRCB20001.getMsg(),custNo));
            }
        }
        Person person = null;
        try {
            person = personMapper.selectById(custNo);
        } catch (UnifyException e1) {
            log.error("查询客户信息异常，异常信息{}",e1.getMessage());
            throw new UnifyException(UnifyErrorCode.CSRCB10001,MessageFormat.format(UnifyErrorCode.CSRCB10001.getMsg(),e1.getMessage()));
        }
        if (UtilValidate.isNotEmpty(person)) {
            Map<String,Object> personMap = BeanMapUtil.beanToMap(person);
            // 客户号
            resultMap.put("custNo", personMap.get("partyId"));
            // 客户名称
            resultMap.put("custName", personMap.get("custName"));
            // 称呼
            resultMap.put("salutation", personMap.get("salutation"));
            // 名
            resultMap.put("firstName", personMap.get("firstName"));
            // 中间名
            resultMap.put("middleName", personMap.get("middleName"));
            // 姓
            resultMap.put("lastName", personMap.get("lastName"));
            // 头衔
            resultMap.put("personalTitle", personMap.get("personalTitle"));
            // 后缀
            resultMap.put("suffix", personMap.get("suffix"));
            // 昵称
            resultMap.put("nickname", personMap.get("nickname"));
            // 姓名本地语言
            resultMap.put("firstNameLocal", personMap.get("firstNameLocal"));
            // 中间名本地语言
            resultMap.put("middleNameLocal", personMap.get("middleNameLocal"));
            // 姓本地语言
            resultMap.put("lastNameLocal", personMap.get("lastNameLocal"));
            // 其它本地语言
            resultMap.put("otherLocal", personMap.get("otherLocal"));
            // 成员标识
            resultMap.put("memberId", personMap.get("memberId"));
            // 生日
            resultMap.put("birthDate", personMap.get("birthDate"));
            // 身高
            resultMap.put("height", personMap.get("height"));
            // 体重
            resultMap.put("weight", personMap.get("weight"));
            // 母亲娘家姓
            resultMap.put("mothersMaidenName", personMap.get("mothersMaidenName"));
            // 婚姻状态
            resultMap.put("maritalStatus", personMap.get("maritalStatus"));
            // 社保号
            resultMap.put("socialSecurityNumber", personMap.get("socialSecurityNumber"));
            // 护照号
            resultMap.put("passportNumber", personMap.get("passportNumber"));
            // 护照过期时间
            resultMap.put("passportExpireDate", personMap.get("passportExpireDate"));
            // 总工作年限
            resultMap.put("totalYearsWorkExperience", personMap.get("totalYearsWorkExperience"));
            // 备注
            resultMap.put("comments", personMap.get("comments"));
            // 雇用年数
            resultMap.put("yearsWithEmployer", personMap.get("yearsWithEmployer"));
            // 雇用月数
            resultMap.put("monthsWithEmployer", personMap.get("monthsWithEmployer"));
            // 境外客户标识
            resultMap.put("overseasFlag", personMap.get("overseasFlag"));
            // 兵团客户标识
            resultMap.put("corpsFlage", personMap.get("corpsFlage"));
            // 自贸区客户标识
            resultMap.put("ftaFlag", personMap.get("ftaFlag"));
            // 客户属性
            resultMap.put("custAttribute", personMap.get("custAttribute"));
            // 性别
            resultMap.put("gender", personMap.get("gender"));
            // 国别
            resultMap.put("country", personMap.get("country"));
            // 民族
            resultMap.put("nation", personMap.get("nation"));
            // 所在行政区划
            resultMap.put("contactAddr", personMap.get("contactAddr"));
            // 账户短信提醒号码
            resultMap.put("acctNoteNum", personMap.get("acctNoteNum"));
            // 身份类别
            resultMap.put("identityType", personMap.get("identityType"));
            // 户口性质
            resultMap.put("registerNature", personMap.get("registerNature"));
            // 涉农属性
            resultMap.put("agriculAttribute", personMap.get("agriculAttribute"));
            // 客户类型
            resultMap.put("custType", personMap.get("custType"));
            // 是否我行股东
            resultMap.put("whetherMybankStock", personMap.get("whetherMybankStock"));
            // 是否集团客户
            resultMap.put("whetherBlocCust", personMap.get("whetherBlocCust"));
            // 中征码
            resultMap.put("signature", personMap.get("signature"));
            // 投向行业
            resultMap.put("investTrade", personMap.get("investTrade"));
            // 授信客户类型
            resultMap.put("creditCustType", personMap.get("creditCustType"));
            // 与我行关系
            resultMap.put("withMybankRelat", personMap.get("withMybankRelat"));
            // 与我行首次信贷时间
            resultMap.put("withMybankFirstCreditTime", personMap.get("withMybankFirstCreditTime"));
            // 逾期贷款金额
            resultMap.put("overdueLoanMoney", personMap.get("overdueLoanMoney"));
            // 逾期贷款原因
            resultMap.put("overdueLoanReason", personMap.get("overdueLoanReason"));
            // 信用评级日期
            resultMap.put("creditRateDate", personMap.get("creditRateDate"));
            // 信用评级等级
            resultMap.put("creditRateGrade", personMap.get("creditRateGrade"));
            // 风险预警信号
            resultMap.put("riskEarlyWarningSignal", personMap.get("riskEarlyWarningSignal"));
            // 不良记录
            resultMap.put("badnessRecord", personMap.get("badnessRecord"));
            // 健康状况
            resultMap.put("hralthStatus", personMap.get("hralthStatus"));
            // 社会声誉
            resultMap.put("socialReputation", personMap.get("socialReputation"));
            // 最高学位
            resultMap.put("degree", personMap.get("degree"));
            // 最高学历
            resultMap.put("academic", personMap.get("academic"));
            // 消费水平（元）
            resultMap.put("consumptionLevel", personMap.get("consumptionLevel"));
            // 管户开始日期
            resultMap.put("manageacctStartDate", personMap.get("manageacctStartDate"));
            // 建立日期
            resultMap.put("buildDate", personMap.get("buildDate"));
            // 客户是否注销
            resultMap.put("custWhetherLogout", personMap.get("custWhetherLogout"));
            // 最后更新日期
            resultMap.put("lastUpdateTime", personMap.get("finalUpdateTime"));
            // 最后更新时间
            resultMap.put("lastUpdatedStamp", personMap.get("lastUpdatedStamp"));
            // 最后更新事务时间
            resultMap.put("lastUpdatedTxStamp", personMap.get("lastUpdatedTxStamp"));
            // 创建时间
            resultMap.put("createdStamp", personMap.get("createdStamp"));
            // 创建事务时间
            resultMap.put("createdTxStamp", personMap.get("createdTxStamp"));
            // 开户客户经理
            resultMap.put("openOwnerId", personMap.get("openOwnerId"));
            // 开户机构
            resultMap.put("openOwnerOrgId", personMap.get("openOwnerOrgId"));
            // 是否党员
            resultMap.put("partyFlag", personMap.get("partyFlag"));
            // 出生国家
            resultMap.put("birthCountry", personMap.get("birthCountry"));
            // 客户拼音名称
            resultMap.put("custNamePinyin", personMap.get("custNamePinyin"));
            // 客户英文名称
            resultMap.put("custNameEn", personMap.get("custNameEn"));
            // 英文简称
            resultMap.put("engShortName", personMap.get("engShortName"));
            // 称谓
            resultMap.put("appellation", personMap.get("appellation"));
            // 籍贯
            resultMap.put("nativePlace", personMap.get("nativePlace"));
            // 客户综合评估级别
            resultMap.put("custAsstLevel", personMap.get("custAsstLevel"));
            // 代理人名称
            resultMap.put("agentName", personMap.get("agentName"));
            // 职业状况及其他说明
            resultMap.put("occStatusIns", personMap.get("occStatusIns"));
            // 语言
            resultMap.put("language", personMap.get("language"));
            // 主要流动资产
            resultMap.put("mainCurAssets", personMap.get("mainCurAssets"));
            // 单位工作起始年
            resultMap.put("unitWorkDate", personMap.get("unitWorkDate"));
            // 投资理财种类
            resultMap.put("investFinalType", personMap.get("investFinalType"));
            // 每月还款(人民币)
            resultMap.put("repayMonth", personMap.get("repayMonth"));
            // 开户银行数
            resultMap.put("openBankNum", personMap.get("openBankNum"));
            // CRS客户标志
            resultMap.put("crsCustFlag", personMap.get("crsCustFlag"));
            // 使用银行名称
            resultMap.put("useBankName", personMap.get("useBankName"));
            // 政治面貌
            resultMap.put("politicalStatus", personMap.get("politicalStatus"));
            // 是否本地户籍
            resultMap.put("localHouseholdRegisterFlag", personMap.get("localHouseholdRegisterFlag"));
            // 本地居住年限
            resultMap.put("localResidenceYear", personMap.get("localResidenceYear"));
            // 是否代发工资
            resultMap.put("payrollCreditFlag", personMap.get("payrollCreditFlag"));
            // 代发工资账号
            resultMap.put("payrollCreditAccount", personMap.get("payrollCreditAccount"));
            // 兴趣爱好
            resultMap.put("hobby", personMap.get("hobby"));
            // 主观印象其他说明
            resultMap.put("executiveImpression", personMap.get("executiveImpression"));
            // 客户性质
            resultMap.put("custProperty", personMap.get("custProperty"));
            // 是否属于农民专业合作社
            resultMap.put("farmerCooperativeFlag", personMap.get("farmerCooperativeFlag"));
            // 农民专业合作社营业执照代码
            resultMap.put("farmerCooperativeIdCardNo", personMap.get("farmerCooperativeIdCardNo"));
            // 农民专业合作社名称
            resultMap.put("farmerCooperativeName", personMap.get("farmerCooperativeName"));
            // 是否学生
            resultMap.put("studentFlag", personMap.get("studentFlag"));
            // 学校名称
            resultMap.put("schoolName", personMap.get("schoolName"));
            // 学校地址
            resultMap.put("schoolAddress", personMap.get("schoolAddress"));
            // 学校电话
            resultMap.put("schoolPhone", personMap.get("schoolPhone"));
            // 学校属性
            resultMap.put("schoolProperty", personMap.get("schoolProperty"));
            // 登记日期
            resultMap.put("registerDate", personMap.get("registerDate"));
            // 是否面签
            resultMap.put("visaFlag", personMap.get("visaFlag"));
            // 联网核查结果
            resultMap.put("interResult", personMap.get("interResult"));
            // 最后联网核查日期
            resultMap.put("lastInterResultDate", personMap.get("lastInterResultDate"));
            // 税收居民身份
            resultMap.put("revResitSta", personMap.get("revResitSta"));
            // 税收居民国地区
            resultMap.put("taxResiRegion", personMap.get("taxResiRegion"));
            // 无法提供纳税人识别号原因
            resultMap.put("unProMark", personMap.get("unProMark"));
            // 是否取得声明文件
            resultMap.put("whetherFile", personMap.get("whetherFile"));
            // 是否他国报税
            resultMap.put("isReportTax", personMap.get("isReportTax"));
            // 机构类别
            resultMap.put("orgType", personMap.get("orgType"));
            // 出生国家
            resultMap.put("birthCountry", personMap.get("birthCountry"));
            // 行政区划编码
            resultMap.put("regionCode", personMap.get("regioncode"));
            // 行政区划名称
            resultMap.put("regionName", personMap.get("regionname"));
            //最后更新时间
            resultMap.put("lastUpdateTime", personMap.get("finalUpdateTime"));
            //职业
            resultMap.put("occupation", personMap.get("occupation"));
            //雇用状态
            resultMap.put("employmentStatusEnumId", personMap.get("employmentStatusEnumId"));
            //居住状态
            resultMap.put("residenceStatusEnumId", personMap.get("residenceStatusEnumId"));
            //自然情况其他说明
            resultMap.put("natureNote", personMap.get("natureNote"));
            //性格描述
            resultMap.put("charDesc", personMap.get("charDesc"));
            //修养描述
            resultMap.put("cultDesc", personMap.get("cultDesc"));
            //外貌特征
            resultMap.put("colorDesc", personMap.get("colorDesc"));
            //主观印象其他说明
            resultMap.put("featureNote", personMap.get("featureNote"));
            //开拓人
            resultMap.put("openUpMan", personMap.get("openUpMan"));
            //客户曾用名
            resultMap.put("custOldName", personMap.get("custOldName"));
            //从业状况
            resultMap.put("empStatus", personMap.get("empStatus"));
            //血型
            resultMap.put("bloodType", personMap.get("bloodType"));
            //宗教信仰
            resultMap.put("faithType", personMap.get("faithType"));
            //公职人员标志
            resultMap.put("gwyFlag", personMap.get("gwyFlag"));
            //服兵役标识
            resultMap.put("fbyFlag", personMap.get("fbyFlag"));
            //建档立卡贫困人口标志
            resultMap.put("pkyFlag", personMap.get("pkyFlag"));
            //行内员工号
            resultMap.put("hannyg", personMap.get("hannyg"));
            //无法核实原因（业务相关：身份核实结果）
            resultMap.put("notcheckReason", personMap.get("notcheckReason"));
            //处置方法（业务相关：身份核实结果）
            resultMap.put("handlePlan", personMap.get("handlePlan"));
            //出生地所在省
            resultMap.put("birthProvince", personMap.get("birthProvince"));
            //出生地所在市
            resultMap.put("birthCity", personMap.get("birthCity"));
            //英文中间名
            resultMap.put("engMidName", personMap.get("engMidName"));
            //英文姓
            resultMap.put("engSurname", personMap.get("engSurname"));
            //国家
            resultMap.put("nationLocated", personMap.get("nationLocated"));
            //城市
            resultMap.put("cityLocated", personMap.get("cityLocated"));
            //小微企业主标识
            resultMap.put("solePrptorFlag", personMap.get("solePrptorFlag"));
            //月租金（租房用）
            resultMap.put("monRent", personMap.get("monRent"));
            //矛盾情形的合理解释（类似备注-涉税用）
            resultMap.put("contradExplain", personMap.get("contradExplain"));
            //授权人
            resultMap.put("authEmp", personMap.get("authEmp"));
            //有无商业保险标志
            resultMap.put("hasBuzInsurance", personMap.get("hasBuzInsurance"));
            //国家信用等级
            resultMap.put("stateCreditClass", personMap.get("stateCreditClass"));
            //地区风险等级
            resultMap.put("areaRiskClass", personMap.get("areaRiskClass"));
            //创建系统编号
            resultMap.put("initSystemId", personMap.get("initSystemId"));
            //创建渠道
            resultMap.put("initChannel", personMap.get("initChannel"));
            //更新系统编号
            resultMap.put("lastSystemId", personMap.get("lastSystemId"));
            //更新所属机构
            resultMap.put("lastUpdatedOrg", personMap.get("lastUpdatedOrg"));
            //更新渠道
            resultMap.put("lastUpdatedChannel", personMap.get("lastUpdatedChannel"));
            //创建人
            resultMap.put("initTe", personMap.get("initTe"));
            //创建机构
            resultMap.put("initOrg", personMap.get("initOrg"));
            //更新人
            resultMap.put("lastUpdatedTe", personMap.get("lastUpdatedTe"));
            // 主联系人
            resultMap.put("principalLinkman", personMap.get("principalLinkman"));
        }
        if (log.isInfoEnabled()) {
            log.info("查询个人客户基础信息【selectPersonCustBasicInfo】结束---->" + context);
        }
        return resultMap;
    }

    /**
     * 修改个人客户基础信息
     * @param context
     * @return
     * @throws
     * @date 2019/11/18 19:29
     * @author liuc
     **/
    @SuppressWarnings("unchecked")
    @Override
    public Map<String,Object> updatePersonCustBasicInfo(Map<String, ? extends Object> context) {
        if (log.isInfoEnabled()) {
            log.info("修改个人客户基础信息【updatePersonCustBasicInfo】开始---->" + context);
        }
        Map<String, Object> checkParam = CommCheckUtil.strTokenToMap(CustomerConstant.UPDATE_PERSON_CUST_BASIC_INFO_CHECK,Constant.COMMA, Constant.EQUAL);
        //非空校验
        CommCheckUtil.requiredCheck(checkParam, BeanConvert.toMap(context,CustomerConstant.UPDATE_PERSON_CUST_BASIC_INFO_CHECK_ITEM));
        //返回结果集
        Map<String, Object> resultMap = new HashMap<String, Object> (16);
        ICustBaseInfoHelper iCustBaseInfoHelper = new CustBaseInfoHelper();

        // 根据客户号更新非空字段
        // 客户号
        String custNo = (String) context.get("custNo");
        String custName = (String) context.get("custName");
        String existingCustomer = (String) context.get("existingCustomer");
        try {
            UpdateWrapper<Party> partyUpdateWrapper = new UpdateWrapper<Party>();
            partyUpdateWrapper.eq("party_id",custNo);
            Party party = new Party();
            party.setCustName(custName);
            Map<String,Object> requestHeadMap = (Map<String, Object>) context.get("requestHead");
            // 登记系统编号
            String orgConsumerId = (String) requestHeadMap.get("orgConsumerId");
            party.setInitSystemId(orgConsumerId);
            // 登记机构
            String branchId = (String) requestHeadMap.get("branchId");
            party.setInitOrg(branchId);
            // 登记人
            String tellerNo = (String) requestHeadMap.get("tellerNo");
            party.setInitTe(tellerNo);
            partyMapper.update(party, partyUpdateWrapper);
            // 1：正式客户
            if (UtilCommonCode.getCodeValueByType("CD003600", "CD003601").equals(existingCustomer)) {
                Person person = iCustBaseInfoHelper.custPerBasicInfoParam(context);
                // 登记系统编号
                person.setInitSystemId(orgConsumerId);
                // 登记机构
                person.setInitOrg(branchId);
                // 登记人
                person.setInitTe(tellerNo);
                UpdateWrapper<Person> updateWrapper = new UpdateWrapper<Person>();
                updateWrapper.eq("party_id",custNo);
                personMapper.update(person,updateWrapper);
                if (UtilValidate.isNotEmpty(person)) {
                    //客户号
                    resultMap.put("custNo", person.getPartyId());
                    //客户名称
                    resultMap.put("custName", person.getCustName());
                }
            } else {
                // 0：临时客户
//                TempPersonDao.getInstance().update(condition, mapPar);
            }
        } catch (UnifyException e) {
            log.error("修改数据库异常",e.getMessage());
            throw new UnifyException(UnifyErrorCode.CSRCB10003,MessageFormat.format(UnifyErrorCode.CSRCB10003.getMsg(),e.getMessage()));
        }
        if (log.isInfoEnabled()) {
            log.info("修改个人客户基础信息【updatePersonCustBasicInfo】结束---->" + resultMap);
        }
        return resultMap;
    }

    /**
     * 新增个人客户基础信息
     * @param context
     * @return
     * @throws
     * @date 2019/11/18 19:29
     * @author liuc
     **/
    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> addPersonCustBasicInfo(Map<String, ? extends Object> context) {
        if (log.isInfoEnabled()) {
            log.info("新增个人客户基础信息【addPersonCustBasicInfo】开始---->" + context);
        }
        Map<String, Object> checkParam = CommCheckUtil.strTokenToMap(CustomerConstant.ADD_PERSON_CUST_BASIC_INFO_CHECK,Constant.COMMA, Constant.EQUAL);
        //非空校验
        CommCheckUtil.requiredCheck(checkParam, BeanConvert.toMap(context,CustomerConstant.ADD_PERSON_CUST_BASIC_INFO_CHECK_ITEM));

        //返回结果集
        Map<String, Object> resultMap = new HashMap<> (8);

        ICustBaseInfoHelper iCustBaseInfoHelper = new CustBaseInfoHelper();
        //校验字段是否在标准码范围内
        iCustBaseInfoHelper.checkCodeValue(context);
        // 1.创建Party
        String partyId = (String) context.get("custNo");
        String existingCustomer = (String) context.get("existingCustomer");

        // 增加校验客户是否已经存在
        Party party = null;
        try {
            party = partyMapper.selectById(partyId);
        } catch (UnifyException e1) {
            log.error("查询客户信息异常，异常信息{}",e1.getMessage());
            throw new UnifyException(UnifyErrorCode.CSRCB10001,MessageFormat.format(UnifyErrorCode.CSRCB10001.getMsg(),e1.getMessage()));
        }
        if (UtilValidate.isNotEmpty(party)) {
            throw new UnifyException(UnifyErrorCode.CSRCB23000,MessageFormat.format(UnifyErrorCode.CSRCB23000.getMsg(),partyId));
        }
        // 如果客户号存在或者客户已删除，则返回空结果集
        if (!UtilValidate.isEmpty(party) && UtilValidate
                .areEqual(UtilCommonCode.getCodeValueByType("CD001400", "CD001401"), party.getStatusId())) {
            throw new UnifyException(UnifyErrorCode.CSRCB23000,MessageFormat.format(UnifyErrorCode.CSRCB23000.getMsg(),partyId));
        }

        String custName = (String) context.get("custName");
        String partyTypeId = UtilCommonCode.getCodeValueByType("CD000200", "CD000201");

        party = new Party();
        //客户号
        party.setPartyId(partyId);
        //客户名
        party.setCustName(custName);
        //客户类型标识
        party.setPartyTypeId(partyTypeId);
        //正式客户标志
        party.setExistingCustomer(existingCustomer);
        //状态
        party.setStatusId(UtilCommonCode.getCodeValueByType("CD001400", "CD001401"));
        Map<String,Object> requestHeadMap = (Map<String, Object>) context.get("requestHead");
        // 登记系统编号
        String orgConsumerId = (String) requestHeadMap.get("orgConsumerId");
        party.setInitSystemId(orgConsumerId);
        // 登记机构
        String branchId = (String) requestHeadMap.get("branchId");
        party.setInitOrg(branchId);
        // 登记人
        String tellerNo = (String) requestHeadMap.get("tellerNo");
        party.setInitTe(tellerNo);
        try {
            party.setCreatedDate(DateUtil.getCurrentDateTime());
            partyMapper.insert(party);
        } catch (UnifyException e) {
            log.error("插入客户信息异常，异常信息{}",e.getMessage());
            throw new UnifyException(UnifyErrorCode.CSRCB10004,MessageFormat.format(UnifyErrorCode.CSRCB10004.getMsg(),e.getMessage()));
        }

        // 2.创建Person个人客户基本信息
        Person person = null;
        try {
            person = iCustBaseInfoHelper.custPerBasicInfoParam(context);
            // 客户号
            person.setPartyId(partyId);
            //登记日期
            if (UtilValidate.isEmpty(person.getRegisterDate())) {
                person.setRegisterDate(DateUtil.formatDateToString(DateUtil.getCurrentDateTime()));
            }
            //建立日期
            if (UtilValidate.isEmpty(person.getBuildDate())) {
                person.setBuildDate(DateUtil.formatUtilDateTosqlDate(DateUtil.getCurrentDateTime()));
            }
            // 客户是否注销
            if (UtilValidate.isEmpty(person.getCustWhetherLogout())) {
                person.setCustWhetherLogout(UtilCommonCode.getCodeValueByType("CD001400", "CD001402"));
            }
            // 登记系统编号
            person.setInitSystemId(orgConsumerId);
            // 登记机构
            person.setInitOrg(branchId);
            // 登记人
            person.setInitTe(tellerNo);
            if (UtilCommonCode.getCodeValueByType("CD003600", "CD003601").equals(existingCustomer)) {
                // Y：正式客户
                personMapper.insert(person);
            } else {
                // N：临时客户
//                genericValue = TempPersonDao.getInstance().create(create);
            }
        } catch (UnifyException e) {
            log.error("插入客户信息异常，异常信息{}",e.getMessage());
            throw new UnifyException(UnifyErrorCode.CSRCB10004,MessageFormat.format(UnifyErrorCode.CSRCB10004.getMsg(),e.getMessage()));
        }
        if (UtilValidate.isNotEmpty(person)) {
            //客户号
            resultMap.put("custNo", person.getPartyId());
            //客户名称
            resultMap.put("custName", person.getCustName());
        }
        if (log.isInfoEnabled()) {
            log.info("新增个人客户基础信息【addPersonCustBasicInfo】结束---->" + resultMap);
        }
        return resultMap;
    }
}
