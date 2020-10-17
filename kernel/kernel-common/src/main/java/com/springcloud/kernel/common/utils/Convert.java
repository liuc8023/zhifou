package com.springcloud.kernel.common.utils;

import com.springcloud.kernel.common.exception.UnifyException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Convert {
    private static String defaultDateFormatString;
    @SuppressWarnings("unchecked")
    private static ThreadLocal<SimpleDateFormat> defaultDateFormatThreadLocal = new ThreadLocal();

    private static SimpleDateFormat getDefaultDateFormat() {
        SimpleDateFormat df = null;
        try {
            df = (SimpleDateFormat)defaultDateFormatThreadLocal.get();
            if (df == null) {
                df = new SimpleDateFormat(defaultDateFormatString, Locale.CHINA);
                defaultDateFormatThreadLocal.set(df);
            }
        }catch (Exception e){
            throw new UnifyException(e.getMessage());
        } finally {
            if (null != defaultDateFormatThreadLocal){
                defaultDateFormatThreadLocal.remove();
            }
        }
        return df;
    }

    public static BigDecimal toBigDecimal(String number)
    {
        return new BigDecimal(number);
    }

    public static BigDecimal toBigDecimal(String number, BigDecimal nvl) {
        if (number == null) {
            return nvl;
        }
        try {
            return new BigDecimal(number); } catch (Exception e) {
        }
        return nvl;
    }

    public static BigDecimal toBigDecimal(Object number)
    {
        if ((number != null) && ((number instanceof BigDecimal))) {
            return (BigDecimal)number;
        }
        return toBigDecimal(toString(number));
    }

    public static BigDecimal toBigDecimal(Object number, BigDecimal nvl) {
        if ((number != null) && ((number instanceof BigDecimal))) {
            return (BigDecimal)number;
        }
        return toBigDecimal(toString(number, null), nvl);
    }

    public static double toDouble(String value)
    {
        return Double.parseDouble(value);
    }

    public static double toDouble(String value, double nvl)
    {
        try
        {
            return Double.parseDouble(value); } catch (Exception err) {
        }
        return nvl;
    }

    public static double toDouble(Object value)
    {
        if (value == null) {
            throw new NullPointerException("无法将null转换为Double");
        }
        if ((value instanceof Double)) {
            return ((Double)value).doubleValue();
        }
        if ((value instanceof Float)) {
            return ((Float)value).floatValue();
        }
        if ((value instanceof Integer)) {
            return ((Integer)value).intValue();
        }
        if ((value instanceof Long)) {
            return ((Long)value).longValue();
        }
        if ((value instanceof Short)) {
            return ((Short)value).shortValue();
        }
        if ((value instanceof Character)) {
            return ((Character)value).charValue();
        }
        if ((value instanceof Byte)) {
            return ((Byte)value).byteValue();
        }
        if ((value instanceof Boolean)) {
            return ((Boolean)value).booleanValue() ? 1.0D : 0.0D;
        }
        if ((value instanceof String)) {
            return toDouble((String)value);
        }
        throw new ClassCastException("无法将类型" + value.getClass().getName() + "转换为Double");
    }

    public static double toDouble(Object value, double nvl)
    {
        try
        {
            return toDouble(value); } catch (Exception err) {
        }
        return nvl;
    }

    public static long toLong(String value)
    {
        return (long) Double.parseDouble(value);
    }

    public static long toLong(String value, long nvl)
    {
        try
        {
            return toLong(value);
        } catch (Exception err) {
            return nvl;
        }
    }

    public static long toLong(Object value)
    {
        if (value == null) {
            throw new NullPointerException("无法将null转换为Long");
        }
        if ((value instanceof Double)) {
            double tmp = ((Double)value).doubleValue();
            return (long) tmp;
        }if ((value instanceof Float)) {
        float tmp = ((Float)value).floatValue();
        return (long) tmp;
    }if ((value instanceof Integer)) {
        return ((Integer)value).intValue();
    }
        if ((value instanceof Long)) {
            return ((Long)value).longValue();
        }
        if ((value instanceof Short)) {
            return ((Short)value).shortValue();
        }
        if ((value instanceof Character)) {
            return ((Character)value).charValue();
        }
        if ((value instanceof Byte)) {
            return ((Byte)value).byteValue();
        }
        if ((value instanceof Boolean)) {
            return ((Boolean)value).booleanValue() ? 1L : 0L;
        }
        if ((value instanceof String)) {
            return toLong((String)value);
        }
        throw new ClassCastException("无法将类型" + value.getClass().getName() + "转换为Long");
    }

    public static long toLong(Object value, long nvl)
    {
        try
        {
            return toLong(value); } catch (Exception err) {
        }
        return nvl;
    }

    public static int toInt(String value)
    {
        return (int)toDouble(value);
    }

    public static int toInt(String value, int nvl)
    {
        try
        {
            return toInt(value); } catch (Exception err) {
        }
        return nvl;
    }

    public static int toInt(Object value)
    {
        if (value == null) {
            throw new NullPointerException("无法将null转换为Integer");
        }
        if ((value instanceof Double)) {
            double tmp = ((Double)value).doubleValue();
            return (int)tmp;
        }
        if ((value instanceof Float)) {
            float tmp = ((Float)value).floatValue();
            return (int)tmp;
        }
        if ((value instanceof Integer)) {
            return ((Integer)value).intValue();
        }
        if ((value instanceof Long)) {
            long tmp = ((Long)value).longValue();
            return (int)tmp;
        }
        if ((value instanceof Short)) {
            return ((Short)value).shortValue();
        }
        if ((value instanceof Character)) {
            return ((Character)value).charValue();
        }
        if ((value instanceof Byte)) {
            return ((Byte)value).byteValue();
        }
        if ((value instanceof Boolean)) {
            return ((Boolean)value).booleanValue() ? 1 : 0;
        }
        if ((value instanceof String)) {
            return toInt((String)value);
        }
        throw new ClassCastException("无法将类型" + value.getClass().getName() + "转换为Integer");
    }

    public static int toInt(Object value, int nvl)
    {
        try
        {
            return toInt(value); } catch (Exception err) {
        }
        return nvl;
    }

    public static String toString(long number)
    {
        return String.valueOf(number);
    }

    public static String toString(double number)
    {
        return new DecimalFormat("0.00").format(number);
    }

    public static String toString(double number, String format)
    {
        return new DecimalFormat(format).format(number);
    }

    public static String toString(Date obj)
    {
        return toString(obj, "yyyy-MM-dd HH:mm:ss");
    }

    public static String toString(Object obj) {
        return toString(obj, null);
    }

    public static String toString(Object obj, String nvl) {
        if (obj != null) {
            return String.valueOf(obj);
        }
        return nvl;
    }

    public static String toMoneyString(long number)
    {
        return toMoneyString(number);
    }

    public static String toMoneyString(BigDecimal number) {
        if (number != null) {
            return toMoneyString(number.doubleValue());
        }
        throw new NullPointerException("无法将null转换为Money");
    }

    public static String toMoneyString(BigDecimal number, String nvl)
    {
        if (number != null) {
            return toMoneyString(number.doubleValue());
        }
        return nvl;
    }

    public static String toMoneyString(double number)
    {
        return new DecimalFormat(",###.##").format(number);
    }

    public static Date toDate(String dateString, String format)
    {
        try
        {
            if ((format == null) || (defaultDateFormatString.equals(format))) {
                return getDefaultDateFormat().parse(dateString);
            }
            return new SimpleDateFormat(format, Locale.CHINA).parse(dateString);
        } catch (ParseException e) {
        }
        throw new ClassCastException("无法将字符串" + dateString + "转换为Date类型");
    }

    public static Date toDate(String dateString, String format, Date nvl)
    {
        try
        {
            if ((format == null) || (defaultDateFormatString.equals(format))) {
                return getDefaultDateFormat().parse(dateString);
            }
            return new SimpleDateFormat(format, Locale.CHINA).parse(dateString);
        } catch (ParseException e) {
        }
        return nvl;
    }

    public static String toString(Date date, String format)
    {
        if ((format == null) || (defaultDateFormatString.equals(format))) {
            return getDefaultDateFormat().format(date);
        }
        return new SimpleDateFormat(format, Locale.CHINA).format(date);
    }

    public static String toString(Date date, String format, String nvl)
    {
        try
        {
            return toString(date, format); } catch (Exception err) {
        }
        return nvl;
    }

    public static String dateFormat(String dateStr, String strformat, String targetFormat)
    {
        Date date = toDate(dateStr, strformat);
        String formatDate = toString(date, targetFormat);
        return formatDate;
    }

    static
    {
        defaultDateFormatString = "yyyy-MM-dd";
    }
}
