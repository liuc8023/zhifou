package com.springcloud.zhifou.customer.module.dto.basic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 修改个人客户基础信息输入bean
 * @className: UpdatePersonCustBasicInfoListInBean
 * @author: liuc
 * @date: 2019-12-12
 */
@Data
@ApiModel(description = "修改个人客户基础信息输入bean")
public class UpdatePersonCustBasicInfoListInBean {
    @ApiModelProperty(name = "custNo", value = "客户标识", dataType = "String", example = "")
    private String custNo;

    @ApiModelProperty(name = "custName", value = "客户名称", dataType = "String", example = "")
    private String custName;

    @ApiModelProperty(name = "custType", value = "客户类型", dataType = "String", example = "")
    private String custType;

    @ApiModelProperty(name = "gender", value = "性别", dataType = "String", example = "")
    private String gender;

    @ApiModelProperty(name = "birthDate", value = "生日", dataType = "String", example = "")
    private String birthDate;

    @ApiModelProperty(name = "custAttribute", value = "客户属性", dataType = "String", example = "")
    private String custAttribute;

    @ApiModelProperty(name = "country", value = "国别", dataType = "String", example = "")
    private String country;

    @ApiModelProperty(name = "buildDate", value = "创建日期", dataType = "String", example = "")
    private String buildDate;

    @ApiModelProperty(name = "existingCustomer", value = "正式客户标志", dataType = "String", example = "")
    private String existingCustomer;

}