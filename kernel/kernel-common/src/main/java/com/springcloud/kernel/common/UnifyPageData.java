package com.springcloud.kernel.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Collection;

/**
* 分页结果数据
* @className UnifyPageData
* @author liuc
* @date 2019-11-01 15:01
* @since JDK 1.8
**/
public class UnifyPageData<T> extends PageDataBase<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 一共多少条记录
     */
    @ApiModelProperty(name = "totalSize", value = "总记录数", dataType = "Integer", example = "")
    private int totalSize;
    /**
     * 一共多少页
     */
    @ApiModelProperty(name = "totalPage", value = "总页数", dataType = "Integer", example = "")
    private int totalPage;

    public UnifyPageData() {

    }

    /**
     * 通过数据与分页信息构建分页结果
     * @param list       数据
     * @param pageNo  页码
     * @param pageSize   页大小
     * @param totalSize 总数据数
     * @return
     * @throws
     * @date 2019/11/5 11:11
     * @author liuc
     **/
    public UnifyPageData(Collection<T> list, int pageNo, int pageSize, int totalSize,int totalPage)
    {
        super(list, pageNo, pageSize);
        this.totalSize = totalSize;
        this.totalPage = totalPage;
    }

    /**
     * 通过数据与分页信息构建分页结果
     * @param list 数据
     * @param pageInfo 分页信息对象
     * @return
     * @throws
     * @date 2019/11/5 11:13
     * @author liuc
     **/
    public UnifyPageData(Collection<T> list, UnifyPageInfo pageInfo) {
        super(list, pageInfo.getPageNo(), pageInfo.getPageSize());
    }

    /**
     * 通过基础分页结果构造分页信息
     * @param dataBase
     * @param totalSize
     * @return
     * @throws
     * @date 2019/11/5 11:14
     * @author liuc
     **/
    public UnifyPageData(PageDataBase<T> dataBase, int totalSize,int totalPage) {
        super(dataBase.getList(), dataBase.getPageNo(), dataBase.getPageSize());
        this.totalSize = totalSize;
        this.totalPage = totalPage;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public String toString() {
        return "UnifyPageData{" +
                "totalSize=" + totalSize +
                ", totalPage=" + totalPage +
                '}';
    }
}
