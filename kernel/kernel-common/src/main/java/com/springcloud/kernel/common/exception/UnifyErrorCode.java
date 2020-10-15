package com.springcloud.kernel.common.exception;
/**
* @className UnifyErrorCode
* @description 系统错误码
* @author liuc
* @date 2019-11-01 14:23
* @since JDK 1.8
**/
public enum UnifyErrorCode {
    /**
     * 【{0}】时间格式转换异常
     */
    CSRCB10000("CSRCB10000","【{0}】时间格式转换异常",1),
    /**
     * 数据库查询异常,异常原因:{0}
     */
    CSRCB10001("CSRCB10001","数据库查询异常,异常原因:{0}",1),
    /**
     * 数据库删除异常,异常原因:{0}
     */
    CSRCB10002("CSRCB10002","数据库删除异常,异常原因:{0}",1),
    /**
     * 数据库修改异常,异常原因:{0}
     */
    CSRCB10003("CSRCB10003","数据库修改异常,异常原因:{0}",1),
    /**
     * 数据库插入异常,异常原因:{0}
     */
    CSRCB10004("CSRCB10004","数据库插入异常,异常原因:{0}",1),
    /**
     * 错误：查询【{0}】结果为空
     */
    CSRCB10005("CSRCB10005","错误：查询【{0}】结果为空",1),
    /**
     * 证件校验不合法:【{0}】
     */
    CSRCB10024("CSRCB10024","证件校验不合法:【{0}】",1),
    /**
     * 错误：入参中数字、金额类型字段校验不合法
     */
    CSRCB10025("CSRCB10025","错误：入参中数字、金额类型字段校验不合法",1),
    /**
     * 当前客户号【{0}】已经失效
     */
    CSRCB20001("CSRCB20001", "当前客户号【{0}】已经失效", 1),
    /**
     * 校验客户号【{0}】是否存在异常，异常信息：{1}
     */
    CSRCB20002("CSRCB20002", "校验客户号【{0}】是否存在异常，异常信息：{1}", 1),
    /**
     * 证件号码【${0}】不正确
     */
    CSRCB20004("CSRCB20004", "证件号码【${0}】不正确", 1),
    /**
     * 客户名[{0}]转拼音异常，异常信息：{1}
     */
    CSRCB20005("CSRCB20005", "客户名[{0}]转拼音异常，异常信息：{1}", 1),
    /**
     * 客户号【{0}】已存在
     */
    CSRCB23000("CSRCB23000", "客户号【{0}】已存在", 1),
    /**
     * 客户【{0}】的证件类型为【{1}】的证件信息已存在
     */
    CSRCB23001("CSRCB23001", "客户【{0}】的证件类型为【{1}】的证件信息已存在", 1),
    /**
     * 证件类型【{0}】和证件号码【{1}】已被其他客户绑定
     */
    CSRCB23002("CSRCB23002", "证件类型【{0}】和证件号码【{1}】已被其他客户绑定", 1),
    /**
     * 客户号【{0}】不存在
     */
    CSRCB23003("CSRCB23003", "客户号【{0}】不存在", 1),
    /**
     * 该客户主证件信息已存在
     */
    CSRCB23004("CSRCB23004", "该客户主证件信息已存在", 1),
    /**
     * 客户【${0}】不是【${1}】客户
     */
    CSRCB23005("CSRCB23005", "客户【${0}】不是【${1}】客户", 1),
    /**
     * 客户的核心客户号、证件类型、证件号码、客户名称与核心系统不一致，请确认
     */
    CSRCB23006("CSRCB23006", "客户的核心客户号、证件类型、证件号码、客户名称与核心系统不一致，请确认", 1),
    /**
     * 客户证件信息重复，请核实证件
     */
    CSRCB23007("CSRCB23007", "客户证件信息重复，请核实证件", 1),
    /**
     * 证件号码中的出生日期:【{0}】与输入的出生日期:【{1}】不相符
     */
    CSRCB24001("CSRCB24001", "证件号码中的出生日期:【{0}】与输入的出生日期:【{1}】不相符", 1),
    /**
     * 证件号码中的性别:【{0}】与输入的性别:【{1}】不相符
     */
    CSRCB24002("CSRCB24002", "证件号码中的性别:【{0}】与输入的性别:【{1}】不相符", 1),
    /**
     * 客户【{0}】的主证件信息不允许删除
     */
    CSRCB25001("CSRCB25001", "客户【{0}】的主证件信息不允许删除", 1),
    /**
     * 为保证客户必存在主证件，客户主证件信息不允许直接修改为非主证件
     */
    CSRCB25002("CSRCB25002", "为保证客户必存在主证件，客户主证件信息不允许直接修改为非主证件", 1),
    /**
     * 客户【{0}】已存在收入类型为【{1}】的收入信息
     */
    CSRCB25003("CSRCB25003", "客户【{0}】已存在收入类型为【{1}】的收入信息", 1),
    /**
     * 客户【{0}】已存在家庭基本信息，无需新增
     */
    CSRCB25004("CSRCB25004", "客户【{0}】已存在家庭基本信息，无需新增", 1),
    /**
     * 地址类型不存在
     */
    CSRCB25005("CSRCB25005", "地址类型不存在", 1),
    /**
     * 该地址用途已存在
     */
    CSRCB25006("CSRCB25006", "该地址用途已存在", 1),
    /**
     * 客户[{0}]主联系地址已存在
     */
    CSRCB25007("CSRCB25007", "客户[{0}]主联系地址已存在", 1),
    /**
     * 当前联系编号对应的联系用途不存在
     */
    CSRCB25008("CSRCB25008", "当前联系编号对应的联系用途不存在", 1),
    /**
     * 错误:参数【{0}】不能为空
     */
    CSRCB30000("CSRCB30000", "错误:参数【{0}】不能为空", 1),
    /**
     * 错误:报文头请求参数【{0}】不能为空
     */
    CSRCB30001("CSRCB30001", "错误:报文头请求参数【{0}】不能为空", 1),
    /**
     * 【{0}】的码值【{1}】不在标准码范围内
     */
    CSRCB30002("CSRCB30002", "【{0}】的码值【{1}】不在标准码范围内", 1),
    /**
     * 【{0}】必须为yyyyMMdd格式
     */
    CSRCB30003("CSRCB30003", "【{0}】必须为yyyyMMdd格式", 1),
    /**
     * 【{0}】必须为HH24MISS格式
     */
    CSRCB30004("CSRCB30004", "【{0}】必须为HH24MISS格式", 1),
    /**
     * 【{0}】不存在
     */
    CSRCB30005("CSRCB30005", "【{0}】不存在", 1),
    /**
     * 参数不能为空
     */
    CSRCB30006("CSRCB30006", "参数不能为空", 1),
    /**
     * 错误:调用服务【{0}】失败：【{1}】
     */
    CSRCB30007("CSRCB30007", "错误:调用服务【{0}】失败：【{1}】", 1),
    /**
     * 暂不支持的输入参数:{0}为{1}
     */
    CSRCB30008("CSRCB30008", "暂不支持的输入参数:{0}为{1}", 1),
    /**
     * CRS客户标志为N且税收居民身份是2或3时,【{0}】不能为空
     */
    CSRCB30009("CSRCB30009", "CRS客户标志为N且税收居民身份是2或3时,【{0}】不能为空", 1),
    /**
     * CRS客户标志为N且税收居民身份是2或3时，纳税人识别号[taxNationId]和无法提供纳税人识别号原因[noTaxIdReasion]只能填一项
     */
    CSRCB30010("CSRCB30010", "CRS客户标志为N且税收居民身份是2或3时，纳税人识别号[taxNationId]和无法提供纳税人识别号原因[noTaxIdReasion]只能填一项", 1),
    /**
     * 居民类别是境内居民，而税收身份为2或3时，矛盾情形的合理解释必填
     */
    CSRCB30011("CSRCB30011", "居民类别是境内居民，而税收身份为2或3时，矛盾情形的合理解释必填", 1),
    /**
     * 居民类别是非境内居民，而税收身份为1时，矛盾情形的合理解释必填
     */
    CSRCB30012("CSRCB30012", "居民类别是非境内居民，而税收身份为1时，矛盾情形的合理解释必填", 1),

    /**
     * 国籍[nat]为{0}，而税收居民国[taxNationCode]为{1}时，矛盾情形的合理解释必填
     */
    CSRCB30013("CSRCB30013", "国籍[nat]为{0}，而税收居民国[taxNationCode]为{1}时，矛盾情形的合理解释必填", 1),
    /**
     * [国籍]应为中国[CHN]
     */
    CSRCB30014("CSRCB30014", "[国籍]应为中国[CHN]", 1),
    /**
     * [国别代码]只能选择澳门、香港、台湾
     */
    CSRCB30015("CSRCB30015", "[国别代码]只能选择澳门、香港、台湾", 1),
    /**
     * [国籍]应为外国国籍
     */
    CSRCB30016("CSRCB30016", "[国籍]应为外国国籍", 1),
    /**
     * 证件类型为港澳或台湾通行证时,通行证号码[passCertNo] 不能为空
     */
    CSRCB30017("CSRCB30017", "证件类型为港澳或台湾通行证时,通行证号码[passCertNo] 不能为空", 1),

    SUCCESS("000000", null, 0),

    BUSINESS_FAILD("100000", "业务执行失败", 2),

    NON_DATA("100001", "操作失败，数据不存在", 1),

    DATA_REPETITION("100002", "已存在相同的数据,操作失败", 1),

    FREQUENTLY("100003", "操作过于频繁", 1),

    TRANS_UNKNOW("100004", "交易状态未知,需查证", 3),

    RQEUIRED_LOGIN("200000", "您需要先登录才能执行此操作", 1),

    UN_AUTHORIZATION("200002", "您没有权限执行此操作", 1),

    VALIDATE_FAILD("500000", "请求参数验证失败", 1),

    NON_INTERFACE("500002", "请求的接口不存在", 1),

    REQ_TIMEOUT("600000", "请求超时,请重试", 2),

    NETWORK_FAIL("600001", "服务器内部通讯失败", 1),

    UNKNOW_FAIL("999999", "请求执行失败(未知错误),请联系管理员", 4);


    private String code;
    private int level;
    private String msg;

    public String getCode() { return this.code; }

    public String getMsg()
    {
        return this.msg;
    }

    public int getLevel() {
        return this.level;
    }

    private UnifyErrorCode(String code, String msg, int level) {
        this.code = code;
        this.msg = msg;
        this.level = level;
    }

    public static UnifyErrorCode parse(String code) {
        UnifyErrorCode[] codes = values();
        for (UnifyErrorCode c : codes) {
            if (c.getCode().equals(code)) {
                return c;
            }
        }
        return UNKNOW_FAIL;
    }

}