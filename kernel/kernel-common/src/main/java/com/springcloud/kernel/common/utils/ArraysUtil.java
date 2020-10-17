package com.springcloud.kernel.common.utils;

import java.util.ArrayList;
import java.util.List;
/**
* @className ArraysUtil
* @description 
* @author liuc
* @date 2019-11-01 15:07
* @since JDK 1.8
**/
public class ArraysUtil {
    public static boolean contains(int[] arr, int value)
    {
        for (int i : arr) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(long[] arr, long value) {
        for (long i : arr) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(short[] arr, short value) {
        for (short i : arr) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(byte[] arr, byte value) {
        for (byte i : arr) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(float[] arr, float value) {
        for (float i : arr) {
            if (UtilValidate.areEqual(i,value)){
                return true;
            }
        }
        return false;
    }

    public static boolean contains(double[] arr, double value) {
        for (double i : arr) {
            if (UtilValidate.areEqual(i,value)){
                return true;
            }
        }
        return false;
    }

    public static boolean contains(boolean[] arr, boolean value) {
        for (boolean i : arr) {
            if (UtilValidate.areEqual(i,value)){
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> asList(T[] arr) {
        List list = new ArrayList();
        for (Object t : arr) {
            list.add(t);
        }
        return list;
    }

    public static <T> boolean contains(T[] arr, T obj) {
        for (Object t : arr) {
            if (t.equals(obj)) {
                return true;
            }
        }
        return false;
    }
}
