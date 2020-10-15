package com.springcloud.zhifou.customer.init;

import com.springcloud.kernel.common.exception.UnifyErrorCode;
import com.springcloud.kernel.common.exception.UnifyException;
import com.springcloud.kernel.common.utils.UtilValidate;
import com.springcloud.zhifou.customer.module.commom.entity.CustCodeValue;
import com.springcloud.zhifou.customer.module.commom.service.CustCodeValueService;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 项目启动后初始化码值
 */
@Component
@Log4j2
public class InitCodeContainer {
    private static final String MODULE = InitCodeContainer.class.getName();

    @Autowired
    public CustCodeValueService iCustCodeValueService;
    @PostConstruct
    public void init(){
        log.info(">>>>>>>>>>>>>>>系统启动中。。。初始化码值开始<<<<<<<<<<<<<");
        //获取开始时间
        long startTime = System.currentTimeMillis();
        try {
            List<CustCodeValue> queryList = iCustCodeValueService.selectAllByAsc(new String[] {"code_type_key","code_type_id_value"});
            String[] groupBy = new String[]{"code_type_key","code_type_key_name"};
            List<CustCodeValue> queryListDistinct = iCustCodeValueService.selectGroupByAndAsc(groupBy,new String[] {"code_type_key","code_type_id_value"});
            for (CustCodeValue tempOut : queryListDistinct) {
                String codeTypeKey = (String)tempOut.getCodeTypeKey();
                String codeTypeKeyName = (String)tempOut.getCodeTypeKeyName();
                Map<String,Object> codeTypeLinkCodeKeyMap = new ConcurrentHashMap<String,Object>(8);
                Map<String,Object> codeTypeLinkCodeKeyNameMap = new ConcurrentHashMap<String,Object>(8);
                Map<String,Object> codeTypeLinkValueKeyNameMap = new ConcurrentHashMap<String,Object>(8);
                Map<String,Object> codeTypeLinkCodeKeyVfMap = new ConcurrentHashMap<String,Object>(8);
                Map<String,Object> codeTypeLinkValueKeyVfMap = new ConcurrentHashMap<String,Object>(8);

                Predicate<CustCodeValue> predicate = new Predicate<CustCodeValue>() {
                    @Override
                    public boolean evaluate(CustCodeValue gv) {
                        String oneCodeTypeKey = (String) gv.getCodeTypeKey();
                        if(oneCodeTypeKey != null && oneCodeTypeKey.equals(codeTypeKey)) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                };

                List<CustCodeValue> queryListByCodeTypeKey = (List<CustCodeValue>) CollectionUtils.select(queryList, predicate);
                for (CustCodeValue tempIn : queryListByCodeTypeKey) {
                    String codeTypeIdKeyIn = (String)tempIn.getCodeTypeIdKey();
                    String codeTypeIdValueIn = (String)tempIn.getCodeTypeIdValue();
                    String codeTypeNameIn = (String)tempIn.getCodeTypeName();
                    String codeTypeKeyIn = (String)tempIn.getCodeTypeKey();
                    String validateFlag = (String)tempIn.getValidateFlage();
                    //避免码值大类key值和码值小类key值，以及小类的value值为空造成在取该码值时造成的空指针问题，在此处加载码值时抛出异常由catch中的UnifyException捕获
                    if (UtilValidate.isEmpty(codeTypeKey)
                            || UtilValidate.isEmpty(codeTypeKeyIn)
                            || UtilValidate.isEmpty(codeTypeIdValueIn)
                            || UtilValidate.isEmpty(codeTypeNameIn)) {
                        throw new UnifyException(UnifyErrorCode.CSRCB30006, UnifyErrorCode.CSRCB30006.getMsg());
                    }
                    addValueCodeTypeLinkCodeKey(codeTypeLinkCodeKeyMap,codeTypeKey,codeTypeKeyIn,codeTypeIdKeyIn,codeTypeIdValueIn);
                    addCodeTypeLinkCodeKeyName(codeTypeLinkCodeKeyNameMap,codeTypeKey,codeTypeKeyIn,codeTypeIdKeyIn,codeTypeNameIn);
                    addCodeTypeLinkValueKeyName(codeTypeLinkValueKeyNameMap,codeTypeKey,codeTypeKeyIn,codeTypeIdValueIn,codeTypeNameIn);
                    addCodeTypeLinkCodeKeyVf(codeTypeLinkCodeKeyVfMap,codeTypeKey,codeTypeKeyIn,codeTypeIdKeyIn,validateFlag);
                    addCodeTypeLinkValueKeyVf(codeTypeLinkValueKeyVfMap,codeTypeKey,codeTypeKeyIn,codeTypeIdValueIn,validateFlag);
                }
                if (!codeTypeLinkCodeKeyMap.isEmpty()) {
                    CodeContainer.CODE_TYPE_LINK_CODE_KEY.put(codeTypeKey, codeTypeLinkCodeKeyMap);
                }
                if (!codeTypeLinkCodeKeyNameMap.isEmpty()) {
                    CodeContainer.CODE_TYPE_LINK_CODE_KEY_NAME.put(codeTypeKey, codeTypeLinkCodeKeyNameMap);
                }
                if (!codeTypeLinkValueKeyNameMap.isEmpty()) {
                    CodeContainer.CODE_TYPE_LINK_VALUE_KEY_NAME.put(codeTypeKey, codeTypeLinkValueKeyNameMap);
                }
                if (!CodeContainer.CODE_TYPE_CONTAINER.containsKey(codeTypeKey)) {
                    CodeContainer.CODE_TYPE_CONTAINER.put(codeTypeKey, codeTypeKeyName);
                }
                if (!codeTypeLinkCodeKeyVfMap.isEmpty()) {
                    CodeContainer.CODE_TYPE_LINK_CODE_KEY_VF.put(codeTypeKey, codeTypeLinkCodeKeyVfMap);
                }
                if (!codeTypeLinkValueKeyVfMap.isEmpty()) {
                    CodeContainer.CODE_TYPE_LINK_VALUE_KEY_VF.put(codeTypeKey, codeTypeLinkValueKeyVfMap);
                }
            }
        } catch (Exception e){
            log.error(e.getMessage(),MODULE);
        }
        //获取结束时间
        long endTime = System.currentTimeMillis();
        log.info("码值容器加载时间："+(endTime-startTime)+"毫秒！",MODULE);
        log.info(">>>>>>>>>>>>>>>系统启动中。。。初始化码值完成<<<<<<<<<<<<<");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("系统运行结束");
    }

    /**
     * @description 向 码值的大类 【码值小类关联key-value】 关联中添加 【码值小类关联key-value】的对应关系
     * @param loopMap	循环中定义的 Map【码值小类关联key-value】
     * @param codeTypeKey	循环第一层大类Type值
     * @param codeTypeKeyIn	循环第二层大类Type值
     * @param codeTypeIdKeyIn	循环第二层小类key值
     * @param codeTypeIdValueIn 循环第二层小类Value值
     */
    private static void addValueCodeTypeLinkCodeKey(Map<String, Object> loopMap, String codeTypeKey, String codeTypeKeyIn,
                                                    String codeTypeIdKeyIn, String codeTypeIdValueIn) {
        if (!CodeContainer.CODE_TYPE_LINK_CODE_KEY.containsKey(codeTypeKey)) {
            if (UtilValidate.areEqual(codeTypeKey, codeTypeKeyIn)) {
                loopMap.put(codeTypeIdKeyIn, codeTypeIdValueIn);
            }
        }
    }

    /**
     * @description 向 码值的大类 【码值小类关联key-name】 关联中添加 【码值小类关联key-name】的对应关系
     * @param loopMap 循环中定义的 Map【码值小类关联key-name】
     * @param codeTypeKey 循环第一层大类Type值
     * @param codeTypeKeyIn 循环第二层大类Type值
     * @param codeTypeIdKeyIn 循环第二层小类key值
     * @param codeTypeNameIn 循环第二层小类key值的中文描述
     */
    private static void addCodeTypeLinkCodeKeyName(Map<String, Object> loopMap, String codeTypeKey, String codeTypeKeyIn,
                                                   String codeTypeIdKeyIn, String codeTypeNameIn) {
        if (!CodeContainer.CODE_TYPE_LINK_CODE_KEY_NAME.containsKey(codeTypeKey)) {
            if (UtilValidate.areEqual(codeTypeKey, codeTypeKeyIn)) {
                loopMap.put(codeTypeIdKeyIn, codeTypeNameIn);
            }
        }
    }


    /**
     * @description 码值的大类 【码值小类关联value-name】联中添加 【码值小类关联value-name】的对应关系
     * @param loopMap	循环中定义的 Map【码值小类关联value-name】
     * @param codeTypeKey	循环第一层大类Type值
     * @param codeTypeKeyIn	循环第二层大类Type值
     * @param codeTypeIdValueIn	循环第二层小类value值
     * @param codeTypeNameIn	循环第二层小类key值的中文描述
     */
    private static void addCodeTypeLinkValueKeyName(Map<String, Object> loopMap, String codeTypeKey, String codeTypeKeyIn, String codeTypeIdValueIn, String codeTypeNameIn) {
        if (!CodeContainer.CODE_TYPE_LINK_VALUE_KEY_NAME.containsKey(codeTypeKey)) {
            if (UtilValidate.areEqual(codeTypeKey, codeTypeKeyIn)) {
                loopMap.put(codeTypeIdValueIn, codeTypeNameIn);
            }
        }
    }

    /**
     * @description 向 码值的大类 【码值小类关联key-validateFlag】 关联中添加 【码值小类关联key-validateFlag】的对应关系
     * @param loopMap 循环中定义的 Map【码值小类关联key-validateFlag】
     * @param codeTypeKey 循环第一层大类Type值
     * @param codeTypeKeyIn 循环第二层大类Type值
     * @param codeTypeIdKeyIn 循环第二层小类key值
     * @param validateFlag 循环第二层小类key值的校验标识
     */
    @SuppressWarnings({"rawtypes", "unchecked" })
    private static void addCodeTypeLinkCodeKeyVf(Map<String, Object> loopMap, String codeTypeKey, String codeTypeKeyIn,
                                                 String codeTypeIdKeyIn, String validateFlag) {
        if (!CodeContainer.CODE_TYPE_LINK_CODE_KEY_VF.containsKey(codeTypeKey)) {
            if (UtilValidate.areEqual(validateFlag, "Y")) {
                loopMap.put(codeTypeIdKeyIn, Boolean.TRUE);
            }
            else {
                loopMap.put(codeTypeIdKeyIn, Boolean.FALSE);
            }
        }
    }


    /**
     * @description 码值的大类 【码值小类关联key-validateFlag】联中添加 【码值小类关联key-validateFlag】的对应关系
     * @param loopMap	循环中定义的 Map【码值小类关联value-validateFlag】
     * @param codeTypeKey	循环第一层大类Type值
     * @param codeTypeKeyIn	循环第二层大类Type值
     * @param codeTypeIdValueIn	循环第二层小类value值
     * @param validateFlag	循环第二层小类key值的校验标识
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private static void addCodeTypeLinkValueKeyVf(Map<String, Object> loopMap, String codeTypeKey, String codeTypeKeyIn, String codeTypeIdValueIn, String validateFlag) {
        if (!CodeContainer.CODE_TYPE_LINK_VALUE_KEY_VF.containsKey(codeTypeKey)) {
            if (UtilValidate.areEqual(codeTypeKey, codeTypeKeyIn)) {
                if (UtilValidate.areEqual(validateFlag, "Y")) {
                    loopMap.put(codeTypeIdValueIn, Boolean.TRUE);
                }
                else {
                    loopMap.put(codeTypeIdValueIn, Boolean.FALSE);
                }
            }
        }
    }
}
