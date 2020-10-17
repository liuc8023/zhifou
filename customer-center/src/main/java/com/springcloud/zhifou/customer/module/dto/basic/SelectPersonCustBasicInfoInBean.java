package com.springcloud.zhifou.customer.module.dto.basic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 查询个人客户基础信息输入bean
 * @className: SelectPersonCustBasicInfoInBean
 * @author: liuc
 * @date: 2019-12-12
 */
@Data
@ApiModel(value="查询个人客户基础信息输入bean",description="查询个人客户基础信息输入bean")
public class SelectPersonCustBasicInfoInBean {
    @ApiModelProperty(name = "custNo", value = "客户号", dataType = "String", example = "")
    private String custNo;
}
