package com.springcloud.kernel.common;

import java.io.Serializable;

/**
* 分页信息
* @className UnifyPageInfo
* @author liuc
* @date 2019-11-01 15:02
* @since JDK 1.8
**/

public class UnifyPageInfo extends PageInfoBase implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用磨人的页码和页大小构建分页对象
     */
    public UnifyPageInfo() {
        super();
    }

    /**
     * 通过页码与每页数据条数构建分页对象
     * @param pageIndex 页码
     * @param pageSize  每页数据条数
     * @return
     * @throws
     * @date 2019/11/5 11:14
     * @author liuc
     **/
    public UnifyPageInfo(int pageIndex, int pageSize) {
        super(pageIndex, pageSize);
    }

    public UnifyPageInfo(PageInfoBase pageBase) {
        super(pageBase.getPageNo(), pageBase.getPageSize());
    }

    public UnifyPageInfo(PageInfoBase pageBase, int totalRecord, int totalPage) {
        this(pageBase);
    }

    /**
     * 要获取的分页记录的开始标码
     */
    public int recordStartIndex()
    {
        return (getPageNo() - 1) * getPageSize() + 1;
    }

    /**
     * 要获取的分页记录的结束标码
     */
    public int recordEndIndex()
    {
        return getPageNo() * getPageSize();
    }
}
