package com.springcloud.zhifou.customer.module.basicinfo.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 客户信息
 */
@Data
@Accessors(chain = true)
@TableName("party")
@ApiModel(value="Party对象",description="客户信息")
public class Party implements Serializable{

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
     * 客户类型标识
     */
    @TableField(value = "party_type_id")
    @ApiModelProperty(value="客户类型标识",name="partyTypeId",example="")
    private String partyTypeId;

    /**
     * 正式客户标志(0-非正式客户,1-正式客户)
     */
    @TableField(value = "existing_customer")
    @ApiModelProperty(value="正式客户标志(0-非正式客户,1-正式客户)",name="existingCustomer",example="")
    private String existingCustomer;

    /**
     * 状态
     */
    @TableField(value = "status_id")
    @ApiModelProperty(value="状态",name="statusId",example="")
    private String statusId;

    /**
     * 外部标识
     */
    @TableField(value = "external_id")
    @ApiModelProperty(value="外部标识",name="externalId",example="")
    private String externalId;

    /**
     * 优先使用币种
     */
    @TableField(value = "preferred_currency_uom_id")
    @ApiModelProperty(value="优先使用币种",name="preferredCurrencyUomId",example="")
    private String preferredCurrencyUomId;

    /**
     * 描述
     */
    @TableField(value = "description")
    @ApiModelProperty(value="描述",name="description",example="")
    private String description;

    /**
     * 创建日期
     */
    @TableField(value = "created_date")
    @ApiModelProperty(value="创建日期",name="createdDate",example="")
    private Date createdDate;

    /**
     * 创建的用户登录标识
     */
    @TableField(value = "created_by_user_login")
    @ApiModelProperty(value="创建的用户登录标识",name="createdByUserLogin",example="")
    private String createdByUserLogin;

    /**
     * 最后修改日期
     */
    @TableField(value = "last_modified_date")
    @ApiModelProperty(value="最后修改日期",name="lastModifiedDate",example="")
    private Date lastModifiedDate;

    /**
     * 最后修改的用户登录标识
     */
    @TableField(value = "last_modified_by_user_login")
    @ApiModelProperty(value="最后修改的用户登录标识",name="lastModifiedByUserLogin",example="")
    private String lastModifiedByUserLogin;

    /**
     * 数据源标识
     */
    @TableField(value = "data_source_id")
    @ApiModelProperty(value="数据源标识",name="dataSourceId",example="")
    private String dataSourceId;

    /**
     * 是否没有人看的
     */
    @TableField(value = "is_unread")
    @ApiModelProperty(value="是否没有人看的",name="isUnread",example="")
    private String isUnread;

    /**
     * 法人代码
     */
    @TableField(value = "legal_person")
    @ApiModelProperty(value="法人代码",name="legalPerson",example="")
    private String legalPerson;

    /**
     * 登记系统编号
     */
    @TableField(value = "init_system_id")
    @ApiModelProperty(value="登记系统编号",name="initSystemId",example="")
    private String initSystemId;

    /**
     * 创建所属机构
     */
    @TableField(value = "init_org")
    @ApiModelProperty(value="创建所属机构",name="initOrg",example="")
    private String initOrg;

    /**
     * 登记人
     */
    @TableField(value = "init_te")
    @ApiModelProperty(value="登记人",name="initTe",example="")
    private String initTe;

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
     * 更新人
     */
    @TableField(value = "last_updated_te")
    @ApiModelProperty(value="更新人",name="lastUpdatedTe",example="")
    private String lastUpdatedTe;

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
