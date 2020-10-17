package com.springcloud.kernel.constraint;

import org.springframework.stereotype.Component;

/**
* @className ISerNoGenerator
* @description 交易流水号生成器
* @author liuc
* @date 2019-11-01 15:38
* @since JDK 1.8
**/
public interface ISerNoGenerator {
    /**
     * 使用默认序列号类型生成一个唯一的自增序列值
     * @param
     * @return
     * @throws
     * @date 2019/11/1 16:47
     * @author liuc
     **/
    public long getSequence();

    /**
     * 生成一个在给定的序列号类型下的唯一的自增序列值
     * @param
     * @return
     * @throws
     * @date 2019/11/1 16:55
     * @author liuc
     **/
    public long getSequence(String paramString);

    /**
     * 生成一个在给定的交易类型下唯一的交易流水号
     * 不同的交易类型其流水号允许重复
     * @param
     * @return
     * @throws
     * @date 2019/11/1 16:56
     * @author liuc
     **/
    public String getSerno(String paramString);

    /**
     * 使用默认交易类型生成一个全局唯一的交易流水号
     * @param
     * @return
     * @throws
     * @date 2019/11/1 16:57
     * @author liuc
     **/
    public String getSerno();

    /**
     * 生成一个随机流水号（无需全局唯一）
     * @param
     * @return
     * @throws
     * @date 2019/11/1 16:58
     * @author liuc
     **/
    public String getRandomSerno();
}