package com.springcloud.zhifou.customer.module.dto.basic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 创建个人客户基础信息输出bean
 * @className: AddPersonCustBasicInfoOutBean
 * @author: liuc
 * @date: 2019-12-12
 */
@Data
@ApiModel(value="创建个人客户基础信息输出bean",description="创建个人客户基础信息输出bean")
public class AddPersonCustBasicInfoOutBean {
    @ApiModelProperty(name = "custNo", value = "客户标识", dataType = "String", example = "")
    private String custNo;

    @ApiModelProperty(name = "custName", value = "客户名称", dataType = "String", example = "")
    private String custName;


}