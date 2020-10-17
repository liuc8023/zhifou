package com.springcloud.kernel.common;

import io.swagger.annotations.ApiModelProperty;

/**
* 分页基础信息
* @className PageInfoBase
* @author liuc
* @date 2019-11-01 15:00
* @since JDK 1.8
**/
public class PageInfoBase {
    private final int DEFAULT_PAGE_SIZE = 10;
    private final int DEFAULT_PAGE_INDEX = 1;
    /**
     * 当前页
     */
    @ApiModelProperty(name = "pageNo", value = "当前页", dataType = "Integer", example = "")
    private int pageNo;
    /**
     * 每页显示条数
     */
    @ApiModelProperty(name = "pageSize", value = "每页显示条数", dataType = "Integer", example = "")
    private int pageSize;


    /**
     * 用磨人的页码和页大小构建分页对象
     */
    public PageInfoBase()
    {
        this.pageNo = 1;
        this.pageSize = 10;
    }

    public PageInfoBase(int pageNo, int pageSize) {
        if (pageNo < 1) {
            this.pageNo = 1;
        } else {
            this.pageNo = pageNo;
        }
        if (pageSize <= 0) {
            this.pageSize = 10;
        } else {
            this.pageSize = pageSize;
        }
    }

    public int getPageNo()
    {
        return this.pageNo;
    }

    public int getPageSize()
    {
        return this.pageSize;
    }

    public void setPageNo(int pageNo) {
        if (pageNo < 1) {
            this.pageNo = 1;
        } else {
            this.pageNo = pageNo;
        }
    }

    public void setPageSize(int pageSize)
    {
        if (pageSize < 1) {
            this.pageSize = 10;
        } else {
            this.pageSize = pageSize;
        }
    }
}
