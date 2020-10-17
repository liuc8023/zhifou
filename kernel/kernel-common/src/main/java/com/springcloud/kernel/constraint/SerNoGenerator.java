package com.springcloud.kernel.constraint;

import cn.hutool.core.date.DateUtil;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.Random;

/**
* @className SerNoGenerator
* @description 
* @author liuc
* @date 2019-11-01 18:32
* @since JDK 1.8
**/
@Component
@Primary
public class SerNoGenerator implements ISerNoGenerator{
    private static Random random;
    private static long seed;

    static {
        seed = System.currentTimeMillis();
        random = new Random(seed);
    }

    /**
     * 使用默认序列号类型生成一个唯一的自增序列值
     *
     * @return
     * @throws
     * @date 2019/11/1 16:47
     * @author liuc
     **/
    @Override
    public long getSequence() {
        return 0;
    }

    /**
     * 生成一个在给定的序列号类型下的唯一的自增序列值
     *
     * @param paramString@return
     * @throws
     * @date 2019/11/1 16:55
     * @author liuc
     **/
    @Override
    public long getSequence(String paramString) {
        return 0;
    }

    /**
     * 生成一个在给定的交易类型下唯一的交易流水号
     * 不同的交易类型其流水号允许重复
     *
     * @param paramString
     * @return
     * @throws
     * @date 2019/11/1 16:56
     * @author liuc
     **/
    @Override
    public String getSerno(String paramString) {
        return null;
    }

    /**
     * 使用默认交易类型生成一个全局唯一的交易流水号
     *
     * @return
     * @throws
     * @date 2019/11/1 16:57
     * @author liuc
     **/
    @Override
    public String getSerno() {
        return null;
    }

    /**
     * 生成一个随机流水号（无需全局唯一）
     *
     * @return
     * @throws
     * @date 2019/11/1 16:58
     * @author liuc
     **/
    @Override
    public String getRandomSerno() {
        String date = DateUtil.format(new Date(),"yyyyMMddHHMMss");
        return date + createRadomString(8);
    }

    /**
     * 生成随机字符串
     * @param length
     * @return
     * @throws
     * @date 2019/11/5 13:26
     * @author liuc
     **/
    public static String createRadomString(int length){
        if (length <= 0) {
            length = 16;
        }
        char[] chArr = new char[length];
        chArr[0] = (char)('0' + uniform(0,10));
        char[] codes = {'0','1','2','3','4','5','6','7','8','9'};
        for (int i = 0; i < length; i++) {
            chArr[i] = codes[uniform(0,codes.length)];
        }
        for (int i = 0; i < length; i++) {
            int r = i + uniform(length - i);
            char temp = chArr[i];
            chArr[i] = chArr[r];
            chArr[r] = temp;
        }
        return new String(chArr);
    }

    private static int uniform(int a, int b) {
        return a + uniform(b - a);
    }

    private static int uniform(int n) {
        return random.nextInt(n);
    }
}
