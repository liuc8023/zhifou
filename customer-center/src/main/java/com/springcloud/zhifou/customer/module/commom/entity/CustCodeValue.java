package com.springcloud.zhifou.customer.module.commom.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Date;

/**
 * @className: CustCodeValue
 * @description: 码值表
 * @author: liuc
 * @date: 2019-11-12
 */
@Data
@Accessors(chain = true)
@TableName("cust_code_value")
@ApiModel(value="CustCodeValue对象",description="码值表")
public class CustCodeValue implements Serializable{

    private static final long serialVersionUID=1L;

    /**
     * 码值小类key
     */
    @TableId(value = "code_type_id_key", type = IdType.INPUT)
    @ApiModelProperty(value="码值小类key",name="codeTypeIdKey",example="")
    private String codeTypeIdKey;

    /**
     * 码值小类value
     */
    @TableField(value = "code_type_id_value")
    @ApiModelProperty(value="码值小类value",name="codeTypeIdValue",example="")
    private String codeTypeIdValue;

    /**
     * 码值小类中文说明
     */
    @TableField(value = "code_type_name")
    @ApiModelProperty(value="码值小类中文说明",name="codeTypeName",example="")
    private String codeTypeName;

    /**
     * 码值大类key
     */
    @TableField(value = "code_type_key")
    @ApiModelProperty(value="码值大类key",name="codeTypeKey",example="")
    private String codeTypeKey;

    /**
     * 码值大类value
     */
    @TableField(value = "code_type_key_name")
    @ApiModelProperty(value="码值大类value",name="codeTypeKeyName",example="")
    private String codeTypeKeyName;

    /**
     * 码值小类key父id
     */
    @TableField(value = "code_type_parent_id")
    @ApiModelProperty(value="码值小类key父id",name="codeTypeParentId",example="")
    private String codeTypeParentId;

    /**
     * 层级
     */
    @TableField(value = "code_type_level")
    @ApiModelProperty(value="层级",name="codeTypeLevel",example="")
    private String codeTypeLevel;

    /**
     * 验证标识
     */
    @TableField(value = "validate_flage")
    @ApiModelProperty(value="验证标识",name="validateFlage",example="")
    private String validateFlage;

    /**
     * 属性值
     */
    @TableField(value = "attr_value")
    @ApiModelProperty(value="属性值",name="attrValue",example="")
    private String attrValue;

    /**
     * 属性描述
     */
    @TableField(value = "attr_description")
    @ApiModelProperty(value="属性描述",name="attrDescription",example="")
    private String attrDescription;

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
