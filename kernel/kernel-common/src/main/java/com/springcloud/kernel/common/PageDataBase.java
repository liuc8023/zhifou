package com.springcloud.kernel.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Collection;
import java.util.Objects;

/**
* @className PageDataBase
* @description 基础分页结果
* @author liuc
* @date 2019-11-01 15:00
* @since JDK 1.8
**/
public class PageDataBase<T> {
    private static final long serialVersionUID = 1L;
    /**
     * 当前第几页数据
     */
    @ApiModelProperty(name = "pageNo", value = "当前页", dataType = "Integer", example = "")
    private int pageNo;
    /**
     * 每页显示多少条记录
     */
    @ApiModelProperty(name = "pageSize", value = "每页显示条数", dataType = "Integer", example = "")
    private int pageSize;
    /**
     * 要显示的数据
     */
    @ApiModelProperty(name = "list", value = "信息列表", dataType = "java.util.List<T>", example = "")
    private Collection<T> list;

    public PageDataBase() {
    }

    /**
     * 通过数据与分页信息构建分页结果
     * @param list 数据
     * @param pageNo 当前页
     * @param pageSize 每页大小
     * @return
     * @throws
     * @date 2019/11/5 10:41
     * @author liuc
     **/
    @SuppressWarnings("unchecked")
    public PageDataBase(Collection<T> list, int pageNo, int pageSize) {
        this.list = list;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    /**
     * 通过数据与分页信息构建分页结果
     * @param list 数据
     * @param pageBase 分页对象
     * @return
     * @throws
     * @date 2019/11/5 10:41
     * @author liuc
     **/
    @SuppressWarnings("unchecked")
    public PageDataBase(Collection<T> list, PageInfoBase pageBase)
    {
        this.list = list;
        this.pageSize = pageBase.getPageSize();
        this.pageNo = pageBase.getPageNo();
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Collection<T> getList() {
        return list;
    }

    public void setList(Collection<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageDataBase{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", list=" + list +
                '}';
    }
}
