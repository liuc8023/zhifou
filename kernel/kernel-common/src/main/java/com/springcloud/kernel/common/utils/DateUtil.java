package com.springcloud.kernel.common.utils;

import com.springcloud.kernel.common.exception.UnifyException;
import lombok.extern.log4j.Log4j2;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.*;
import java.util.*;

/**
 * 时间处理工具类
 *
 * @author liuc
 */
@Log4j2
public class DateUtil implements Serializable {

    /**
     * 考虑港股和美股 采用GMT-1时区来确定报表日 即T日的报表包含北京时间T日9时至T+1日9时的数据
     */
    public static final ZoneId TIMEZONE_GMT_1 = ZoneId.of("GMT-1");
    public static final ZoneId TIMEZONE_EST = ZoneId.of("US/Eastern");
    public static final ZoneId TIMEZONE_GMT8 = ZoneId.of("GMT+8");

    /**
     * 常用时间转换格式
     */
    public static final String MONTH_FORMATTER = "yyyy-MM";
    public static final String MONTH_FORMATTER_PATTERN = "yyyyMM";
    public static final String DATE_YEAR_PATTERN = "yyyy";
    public static final String DATE_FORMATTER = "yyyy-MM-dd";
    public static final String DATETIME_FORMATTER = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_SHORT_TIME_PATTERN = "yyyy-MM-dd HH:mm";
    public static final String DATE_PATTERN_2 = "yyyy/MM/dd";
    public static final String DATE_POINT_PATTERN = "yyyy.MM.dd";
    public static final String DATE_POINT2_PATTERN = "yyyy.MM";
    public static final String DATE_SHORT_TIME_PATTERN_2 = "yyyy年MM月dd日 HH:mm";
    public static final String TIME_FORMATTER = "HH:mm:ss";
    public static final String DATE_FORMAT_COMPACT = "yyyyMMdd";
    public static final String DATE_FORMAT_COMPACTFULL = "yyyyMMdd HHmmss";
    public static final String DATE_FORMAT_FULL_MSEL = "yyyyMMdd HHmmssSSSS";
    public static final String SHORT_DATETIME_FORMATTER = "yyMMddHHmmss";
    public static final String DATE_YEAR_MONTH ="yyyyMM";
    public static final String DATE_FORMAT_FULL_MSE = "yyyyMMdd HHmmssSSS";


    public static final Map<String, DateTimeFormatter> DATE_TIME_FORMAT_MAP = new Hashtable<String, DateTimeFormatter>() {
        {
            put(MONTH_FORMATTER, DateTimeFormatter.ofPattern(MONTH_FORMATTER));
            put(MONTH_FORMATTER_PATTERN, DateTimeFormatter.ofPattern(MONTH_FORMATTER_PATTERN));
            put(DATE_YEAR_PATTERN, DateTimeFormatter.ofPattern(DATE_YEAR_PATTERN));
            put(DATE_FORMATTER, DateTimeFormatter.ofPattern(DATE_FORMATTER));
            put(DATETIME_FORMATTER, DateTimeFormatter.ofPattern(DATETIME_FORMATTER));
            put(DATE_SHORT_TIME_PATTERN, DateTimeFormatter.ofPattern(DATE_SHORT_TIME_PATTERN));
            put(DATE_PATTERN_2, DateTimeFormatter.ofPattern(DATE_PATTERN_2));
            put(DATE_POINT_PATTERN, DateTimeFormatter.ofPattern(DATE_POINT_PATTERN));
            put(DATE_POINT2_PATTERN, DateTimeFormatter.ofPattern(DATE_POINT2_PATTERN));
            put(DATE_SHORT_TIME_PATTERN_2, DateTimeFormatter.ofPattern(DATE_SHORT_TIME_PATTERN_2));
            put(TIME_FORMATTER, DateTimeFormatter.ofPattern(TIME_FORMATTER));
            put(DATE_FORMAT_COMPACT, DateTimeFormatter.ofPattern(DATE_FORMAT_COMPACT));
            put(DATE_FORMAT_COMPACTFULL, DateTimeFormatter.ofPattern(DATE_FORMAT_COMPACTFULL));
            put(DATE_FORMAT_FULL_MSEL, DateTimeFormatter.ofPattern(DATE_FORMAT_FULL_MSEL));
            put(SHORT_DATETIME_FORMATTER, DateTimeFormatter.ofPattern(SHORT_DATETIME_FORMATTER));
            put(DATE_YEAR_MONTH, DateTimeFormatter.ofPattern(DATE_YEAR_MONTH));
            put(DATE_FORMAT_FULL_MSE, DateTimeFormatter.ofPattern(DATE_FORMAT_FULL_MSE));
        }
    };

    /**
     * 根据format的格式获取相应的DateTimeFormatter对象
     *
     * @param format 时间转换格式字符串
     * @return java.time.format.DateTimeFormatter
     */
    public static DateTimeFormatter getDateTimeFormatter(String format) {
        if (DATE_TIME_FORMAT_MAP.containsKey(format)) {
            return DATE_TIME_FORMAT_MAP.get(format);
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            DATE_TIME_FORMAT_MAP.put(format, formatter);
            return formatter;
        }
    }

    /**
     * Date对象转换为LocalDateTime对象，默认格式为yyyy-MM-dd HH:mm:ss
     *
     * @param date 需要转换的日起对象
     * @return java.time.LocalDateTime
     */
    public static LocalDateTime formatDateToLdt(Date date) {
        if (UtilValidate.isEmpty(date)) {
            throw new DateTimeException("Please enter the date to be converted!");
        }
        return formatDateToLdt(date,DATETIME_FORMATTER);
    }

    /**
     * Date转换为LocalDateTime，格式为自定义格式，默认格式为yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return java.time.LocalDateTime
     */
    public static LocalDateTime formatDateToLdt (Date date ,String pattern) {
        if (UtilValidate.isEmpty(date)) {
            throw new DateTimeException("Please enter the date to be converted!");
        }
        if (UtilValidate.isEmpty(pattern)) {
            pattern = DATETIME_FORMATTER;
        }
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern(pattern);
        LocalDateTime localDateTime =  LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        return LocalDateTime.parse(formatter.format(localDateTime), formatter);
    }

    /**
     * LocalDateTime转换为java.util.Date
     *
     * @param localDateTime
     *            LocalDateTime对象
     * @return java.util.Date
     */
    public static Date formatLdtToDate(LocalDateTime localDateTime) {
        if (UtilValidate.isEmpty(localDateTime)) {
            throw new DateTimeException("Please enter the localDateTime to be converted!");
        }
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        return Date.from(zdt.toInstant());
    }

    /**
     * timestamp转换为字符串
     *
     * @param timestamp
     * @return java.lang.String
     */
    public static String formatTimestampToString(Long timestamp){
        Instant instant = Instant.ofEpochMilli(timestamp);
        LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return formatLdtToString(ldt, DATETIME_FORMATTER);
    }

    /**
     * timestamp转换为指定格式字符串
     *
     * @param timestamp
     * @param pattern
     * @return java.lang.String
     */
    public static String formatTimestampToString(Long timestamp, String pattern){
        if (UtilValidate.isEmpty(timestamp)) {
            throw new DateTimeException("Please enter the timestamp to be converted!");
        }
        if (UtilValidate.isEmpty(pattern)) {
            pattern = DATETIME_FORMATTER;
        }
        Instant instant = Instant.ofEpochMilli(timestamp);
        LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return formatLdtToString(ldt, pattern);
    }

    /**
     * Date转换为String 格式化时间-默认yyyy-MM-dd HH:mm:ss格式
     * @param date
     * @return java.lang.String
     */
    public static String formatDateToString (Date date) {
        if (UtilValidate.isEmpty(date)) {
            throw new DateTimeException("Please enter the date to be converted!");
        }
        return formatDateToString(date,DATETIME_FORMATTER);
    }

    /**
     * Date转换为String 格式化时间-默认yyyy-MM-dd HH:mm:ss格式
     * @param date
     * @param pattern
     * @return java.lang.String
     */
    public static String formatDateToString (Date date ,String pattern) {
        if (UtilValidate.isEmpty(date)) {
            throw new DateTimeException("Please enter the date to be converted!");
        }
        LocalDateTime localDateTime =  LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        if (UtilValidate.isEmpty(pattern)) {
            pattern = DATETIME_FORMATTER;
        }
        return getDateTimeFormatter(pattern).format(localDateTime);
    }

    /**
     * Date转换为timestamp
     *
     * @param date
     * @return long
     */
    public static long formatDateToTimestamp(Date date){
        if (UtilValidate.isEmpty(date)) {
            throw new DateTimeException("Please enter the date to be converted!");
        }
        LocalDateTime localDateTime = formatDateToLdt(date);
        ZoneId zoneId = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zoneId).toInstant();
        //毫秒时间戳
        return instant.toEpochMilli();
    }

    /**
     * LocalDateTime转换为timestamp
     *
     * @param localDateTime
     * @return long
     */
    public static long formatLdtToTimestamp(LocalDateTime localDateTime){
        if (UtilValidate.isEmpty(localDateTime)) {
            throw new DateTimeException("Please enter the localDateTime to be converted!");
        }
        return Timestamp.valueOf(localDateTime).getTime();
    }

    /**
     * 时间戳转换为LocalDateTime
     *
     * @param timestamp
     * @return java.time.LocalDateTime
     */
    public static LocalDateTime formatTimeStampToLdt(long timestamp){
        if (UtilValidate.isEmpty(timestamp)) {
            throw new DateTimeException("Please enter the timestamp to be converted!");
        }
        Instant instant = Instant.ofEpochMilli(timestamp);
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }


    /**
     * 获取本月的第一天，格式为自定义格式，默认格式为yyyy-MM-dd HH:mm:ss
     *
     * @return java.lang.String
     */
    public static String getFirstDayOfThisMonth(String pattern) {
        DateTimeFormatter formatter = null;
        if (UtilValidate.isEmpty(pattern)) {
            formatter = getDateTimeFormatter(DATETIME_FORMATTER);
        } else {
            formatter = getDateTimeFormatter(pattern);
        }
        LocalDateTime firstDayOfThisYear = getCurrLocalDateTime().with(TemporalAdjusters.firstDayOfMonth());
        return formatter.format(firstDayOfThisYear);
    }

    /**
     * 获取本月第N天，格式为自定义格式，默认格式为yyyy-MM-dd HH:mm:ss
     * @param pattern
     * @return java.lang.String
     */
    public static String getNdayOfThisMonth (int n ,String pattern) {
        DateTimeFormatter formatter = null;
        if (UtilValidate.isEmpty(n)) {
            throw new DateTimeException("Please enter the day of the month you want to get!");
        }
        if (UtilValidate.isEmpty(pattern)) {
            formatter = getDateTimeFormatter(DATETIME_FORMATTER);
        } else {
            formatter = getDateTimeFormatter(pattern);
        }
        LocalDate secondDayOfThisMonth = LocalDate.now().withDayOfMonth(n);
        return formatter.format(secondDayOfThisMonth);
    }

    /**
     * 获取本月的最末天，格式为自定义格式，默认格式为yyyy-MM-dd HH:mm:ss
     *
     * @return java.lang.String
     */
    public static String getLastDayOfThisMonth(String pattern) {
        DateTimeFormatter formatter = null;
        if (UtilValidate.isEmpty(pattern)) {
            formatter = getDateTimeFormatter(DATETIME_FORMATTER);
        } else {
            formatter = getDateTimeFormatter(pattern);
        }
        LocalDateTime firstDayOfThisYear = getCurrLocalDateTime().with(TemporalAdjusters.lastDayOfMonth());
        return formatter.format(firstDayOfThisYear);
    }

    /**
     * 当前日期向后推多少天
     *
     * @param days
     * @return java.time.LocalDateTime
     */
    public static LocalDateTime getLocalPlusDays(int days) {
        return getCurrLocalDateTime().plusDays(days);
    }

    /**
     * 当前日期向后推多少天,默认格式为yyyy-MM-dd
     *
     * @param days
     * @return java.lang.String
     */
    public static String getStringPlusDays (int days) {
        if (UtilValidate.isEmpty(days)) {
            throw new DateTimeException("Please enter the number of days you want to move back from the current date!");
        }
        return getStringPlusDays(days,DATE_FORMATTER);
    }

    /**
     * 当前日期向后推多少天，格式为自定义格式，默认格式为yyyy-MM-dd HH:mm:ss
     *
     * @param days
     * @return java.lang.String
     */
    public static String getStringPlusDays (int days ,String pattern) {
        DateTimeFormatter formatter = null;
        if (UtilValidate.isEmpty(days)) {
            throw new DateTimeException("Please enter the number of days you want to move back from the current date!");
        }
        if (UtilValidate.isEmpty(pattern)) {
            formatter = getDateTimeFormatter(DATETIME_FORMATTER);
        } else {
            formatter = getDateTimeFormatter(pattern);
        }
        LocalDateTime localDateTime = getCurrLocalDateTime().plusDays(days);
        return formatter.format(localDateTime);
    }

    /**
     * 格式化时间-默认yyyy-MM-dd HH:mm:ss格式
     *
     * @param dateTime
     *            LocalDateTime对象
     * @return java.lang.String
     */
    public static String formatLdtToString(LocalDateTime dateTime) {
        return formatLdtToString(dateTime, DATETIME_FORMATTER);
    }

    /**
     * 按pattern格式化时间-默认yyyy-MM-dd HH:mm:ss格式
     *
     * @param dateTime
     *            LocalDateTime对象
     * @param pattern
     *            要格式化的字符串
     * @return java.lang.String
     */
    public static String formatLdtToString(LocalDateTime dateTime, String pattern) {
        if (UtilValidate.isEmpty(dateTime)) {
            throw new DateTimeException("Please enter the localDateTime to be converted!");
        }
        if (UtilValidate.isEmpty(pattern)) {
            return getDateTimeFormatter(DATETIME_FORMATTER).format(dateTime);
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return dateTime.format(formatter);
    }

    /**
     * 按pattern格式化时间-默认yyyy-MM-dd HH:mm:ss格式
     *
     * @param dateTime 需要转换的日期字符串
     * @return java.time.LocalDateTime
     */
    public static LocalDateTime formatStringToLdt(String dateTime) {
        if (UtilValidate.isEmpty(dateTime)) {
            throw new DateTimeException("Please enter The date string to be converted!");
        }
        return formatStringToLdt(dateTime, DATETIME_FORMATTER);
    }

    /**
     * 按pattern格式化时间-默认yyyy-MM-dd HH:mm:ss格式
     *
     * @param dateTime 需要转换的日期字符串
     * @param pattern 日期格式
     * @return java.time.LocalDateTime
     */
    public static LocalDateTime formatStringToLdt(String dateTime, String pattern) {
        if (UtilValidate.isEmpty(dateTime)) {
            throw new DateTimeException("Please enter The date string to be converted!");
        }
        if (UtilValidate.isEmpty(pattern)) {
            return LocalDateTime.parse(dateTime,getDateTimeFormatter(DATETIME_FORMATTER));
        }
        return LocalDateTime.parse(dateTime,getDateTimeFormatter(pattern));
    }

    /**
     * 获取今天的00:00:00
     *
     * @return java.lang.String
     */
    public static String getDayStart() {
        return getDayStart(LocalDateTime.now());
    }

    /**
     * 获取今天的23:59:59
     *
     * @return java.lang.String
     */
    public static String getDayEnd() {
        return getDayEnd(LocalDateTime.now());
    }

    /**
     * 获取某天的00:00:00
     *
     * @param dateTime
     * @return java.lang.String
     */
    public static String getDayStart(LocalDateTime dateTime) {
        if (UtilValidate.isEmpty(dateTime)) {
            throw new DateTimeException("Please enter the localDateTime to be converted!");
        }
        return formatLdtToString(dateTime.with(LocalTime.MIN));
    }

    /**
     * 获取某天的23:59:59
     *
     * @param dateTime
     * @return java.lang.String
     */
    public static String getDayEnd(LocalDateTime dateTime) {
        if (UtilValidate.isEmpty(dateTime)) {
            throw new DateTimeException("Please enter the localDateTime to be converted!");
        }
        return formatLdtToString(dateTime.with(LocalTime.MAX));
    }

    /**
     * 获取本月第一天的00:00:00
     *
     * @return java.lang.String
     */
    public static String getFirstDayOfMonth() {
        return getFirstDayOfMonth(LocalDateTime.now());
    }

    /**
     * 获取本月最后一天的23:59:59
     *
     * @return java.lang.String
     */
    public static String getLastDayOfMonth() {
        return getLastDayOfMonth(LocalDateTime.now());
    }

    /**
     * 获取某月第一天的00:00:00
     *
     * @param dateTime
     *            LocalDateTime对象
     * @return java.lang.String
     */
    public static String getFirstDayOfMonth(LocalDateTime dateTime) {
        return formatLdtToString(dateTime.with(TemporalAdjusters.firstDayOfMonth()).with(LocalTime.MIN));
    }

    /**
     * 获取某月最后一天的23:59:59
     *
     * @param dateTime
     *            LocalDateTime对象
     * @return java.lang.String
     */
    public static String getLastDayOfMonth(LocalDateTime dateTime) {
        return formatLdtToString(dateTime.with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.MAX));
    }

    /**
     * 获取系统当前日期时间字符串，格式为yyyy-MM-dd HH:mm:ss
     *
     * @return java.lang.String
     */
    public static String getCurrDateTime(){
        return LocalDateTime.now().format(getDateTimeFormatter(DATETIME_FORMATTER));
    }

    /**
     * 获取系统当前日期时间
     *
     * @return java.time.LocalDateTime
     */
    public static LocalDateTime getCurrLocalDateTime() {
        return LocalDateTime.now();
    }

    /**
     * 获取系统当前日期时间字符串，格式为自定义格式，默认格式为yyyy-MM-dd HH:mm:ss
     *
     * @return java.lang.String
     */
    public static String getCurrentLocalDate(String pattern) {
        if (UtilValidate.isEmpty(pattern)) {
            pattern = DATETIME_FORMATTER;
        }
        return formatLdtToString(getCurrLocalDateTime(), pattern);
    }

    /**
     * 返回当前的日期
     *
     * @return java.time.LocalDate
     */
    public static LocalDate getCurrentLocalDate() {
        return LocalDate.now();
    }

    /**
     * 返回当前时间
     *
     * @return java.time.LocalTime
     */
    public static LocalTime getCurrentLocalTime() {
        return LocalTime.now();
    }

    /**
     * 返回当前时间
     * @return
     */
    public static Date getCurrentDateTime() {
        // 指定格式化格式
        SimpleDateFormat f = new SimpleDateFormat(DATETIME_FORMATTER);
        return cn.hutool.core.date.DateUtil.parse(f.format(formatLdtToDate(getCurrLocalDateTime())));
    }

    /**
     * 获取两个日期的差  field参数为ChronoUnit.*
     * @param startTime
     * @param endTime
     * @param field  单位(年月日时分秒)
     * @return long
     */
    public static long betweenTwoTime(LocalDateTime startTime, LocalDateTime endTime, ChronoUnit field) {
        if (UtilValidate.isEmpty(startTime)) {
            throw new DateTimeException("Please enter a start time!");
        }
        if (UtilValidate.isEmpty(endTime)) {
            throw new DateTimeException("Please enter a end time!");
        }
        if (UtilValidate.isEmpty(field)) {
            throw new DateTimeException("Please enter a time unit!");
        }
        Period period = Period.between(LocalDate.from(startTime), LocalDate.from(endTime));
        if (field == ChronoUnit.YEARS) {
            return period.getYears();
        }
        if (field == ChronoUnit.MONTHS) {
            return period.getYears() * 12 + period.getMonths();
        }
        return field.between(startTime, endTime);
    }

    /**
     * 获取两个时间相差天数
     * @param startDateInclusive
     * @param endDateExclusive
     * @return long
     */
    public static long periodDays(LocalDate startDateInclusive, LocalDate endDateExclusive) {
        if (UtilValidate.isEmpty(startDateInclusive)) {
            throw new DateTimeException("Please enter a start time!");
        }
        if (UtilValidate.isEmpty(endDateExclusive)) {
            throw new DateTimeException("Please enter a end time!");
        }
        return endDateExclusive.toEpochDay() - startDateInclusive.toEpochDay();
    }

    /**
     * 日期相隔小时
     * @param startInclusive
     * @param endExclusive
     * @return long
     */
    public static long durationHours(Temporal startInclusive, Temporal endExclusive) {
        if (UtilValidate.isEmpty(startInclusive)) {
            throw new DateTimeException("Please enter a start time!");
        }
        if (UtilValidate.isEmpty(endExclusive)) {
            throw new DateTimeException("Please enter a end time!");
        }
        return Duration.between(startInclusive, endExclusive).toHours();
    }

    /**
     * 日期相隔分钟
     * @param startInclusive
     * @param endExclusive
     * @return long
     */
    public static long durationMinutes(Temporal startInclusive, Temporal endExclusive) {
        if (UtilValidate.isEmpty(startInclusive)) {
            throw new DateTimeException("Please enter a start time!");
        }
        if (UtilValidate.isEmpty(endExclusive)) {
            throw new DateTimeException("Please enter a end time!");
        }
        return Duration.between(startInclusive, endExclusive).toMinutes();
    }

    /**
     * 日期相隔毫秒数
     * @param startInclusive
     * @param endExclusive
     * @return long
     */
    public static long durationMillis(Temporal startInclusive, Temporal endExclusive) {
        if (UtilValidate.isEmpty(startInclusive)) {
            throw new DateTimeException("Please enter a start time!");
        }
        if (UtilValidate.isEmpty(endExclusive)) {
            throw new DateTimeException("Please enter a end time!");
        }
        return Duration.between(startInclusive, endExclusive).toMillis();
    }

    /**
     * 是否当天
     * @param date
     * @return boolean
     */
    public static boolean isToday(LocalDate date) {
        if (UtilValidate.isEmpty(date)) {
            throw new DateTimeException("Please enter a date!");
        }
        return getCurrentLocalDate().equals(date);
    }

    /**
     * 获取此日期时间与默认时区<Asia/Shanghai>组合的时间毫秒数
     * @param dateTime
     * @return
     */
    public static Long toEpochMilli(LocalDateTime dateTime) {
        if (UtilValidate.isEmpty(dateTime)) {
            throw new DateTimeException("Please enter a localDateTime!");
        }
        return dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 获取此日期时间与指定时区组合的时间毫秒数
     * @param dateTime
     * @return
     */
    public static Long toSelectEpochMilli(LocalDateTime dateTime, ZoneId zoneId) {
        if (UtilValidate.isEmpty(dateTime)) {
            throw new DateTimeException("Please enter a localDateTime!");
        }
        if (UtilValidate.isEmpty(zoneId)) {
            throw new DateTimeException("Please enter a zoneId!");
        }
        return dateTime.atZone(zoneId).toInstant().toEpochMilli();
    }

    /**
     * 判断是否为闰年
     * @param date
     * @return boolean
     */
    public static boolean isLeapYear (LocalDate date) {
        if (UtilValidate.isEmpty(date)) {
            throw new DateTimeException("Please Enter a LocalDate!");
        }
        return date.isLeapYear();
    }

    /**
     * 获取当前的ZoneDateTime
     *
     * @param zoneId 时区偏移量
     * @return
     */
    public static ZonedDateTime now(ZoneId zoneId) {
        if (UtilValidate.isEmpty(zoneId)) {
            throw new DateTimeException("Please enter a zoneId!");
        }
        return ZonedDateTime.now(zoneId);
    }

    /**
     * 获取当前日期的开始时间ZonedDateTime
     *
     * @param date   日期
     * @param zoneId 时区偏移量
     * @return
     */
    public static ZonedDateTime ldToZoneDateTime(LocalDate date, ZoneId zoneId) {
        if (UtilValidate.isEmpty(date)) {
            throw new DateTimeException("Please enter a LocalDate!");
        }
        if (UtilValidate.isEmpty(zoneId)) {
            throw new DateTimeException("Please enter a zoneId!");
        }
        return date.atStartOfDay(zoneId);
    }

    /**
     * 获取当前日期的开始时间
     *
     * @param dateTime
     * @return
     */
    public static LocalDateTime startOfDay(ZonedDateTime dateTime) {
        if (UtilValidate.isEmpty(dateTime)) {
            throw new DateTimeException("Please enter a ZonedDateTime!");
        }
        return dateTime.truncatedTo(ChronoUnit.DAYS).toLocalDateTime();
    }

    /**
     * 获取今天后的指定天数的开始时间
     *
     * @param plusDays 当前多少天后
     * @param zoneId   时区偏移量
     * @return
     */
    public static LocalDateTime startOfDay(int plusDays, ZoneId zoneId) {
        if (UtilValidate.isEmpty(plusDays)) {
            throw new DateTimeException("Please enter the specified number of days after today!");
        }
        if (UtilValidate.isEmpty(zoneId)) {
            throw new DateTimeException("Please enter a zoneId!");
        }
        return startOfDay(now(zoneId).plusDays(plusDays));
    }

    /**
     * 获取指定日期的后几个工作日的时间LocalDate
     *
     * @param date 指定日期
     * @param days 工作日数
     * @return
     */
    public static LocalDate plusWeekdays(LocalDate date, int days) {
        if (days == 0) {
            return date;
        }
        if (Math.abs(days) > 50) {
            throw new IllegalArgumentException("days must be less than 50");
        }
        int i = 0;
        int delta = days > 0 ? 1 : -1;
        while (i < Math.abs(days)) {
            date = date.plusDays(delta);
            DayOfWeek dayOfWeek = date.getDayOfWeek();
            if (dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY) {
                i += 1;
            }
        }
        return date;
    }

    /**
     * 获取指定日期的后几个工作日的时间ZoneDateTime
     *
     * @param date
     * @param days
     * @return
     */
    public static ZonedDateTime plusWeekdays(ZonedDateTime date, int days) {
        if (UtilValidate.isEmpty(date)) {
            throw new DateTimeException("Please enter a ZonedDateTime!");
        }
        if (UtilValidate.isEmpty(days)) {
            throw new DateTimeException("Please enter the working day after the specified date!");
        }
        return plusWeekdays(date.toLocalDate(), days).atStartOfDay(date.getZone());
    }

    /**
     * 获取当前月份的第一天的时间ZoneDateTime
     *
     * @param zoneId
     * @return
     */
    public static ZonedDateTime firstDayOfMonth(ZoneId zoneId) {
        if (UtilValidate.isEmpty(zoneId)) {
            throw new DateTimeException("Please enter a ZoneId!");
        }
        return now(zoneId).withDayOfMonth(1);
    }


    /**
     * 将Date转成指定时区的Date
     *
     * @param date
     * @return
     */
    public static Date dateToDate(Date date, ZoneId zoneId) {
        if (UtilValidate.isEmpty(date)) {
            throw new DateTimeException("Please enter a Date!");
        }
        if (UtilValidate.isEmpty(zoneId)) {
            throw new DateTimeException("Please enter a ZoneId!");
        }
        LocalDateTime dt = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        return formatZonedDateTimeToDate(ZonedDateTime.of(dt, zoneId));
    }

    /**
     * 将LocalDate转成Date
     *
     * @param date
     * @return
     */
    public static Date formatLdToDate(LocalDate date) {
        if (UtilValidate.isEmpty(date)) {
            throw new DateTimeException("Please enter a LocalDate!");
        }
        return Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * ZonedDateTime 转换成Date
     *
     * @param dateTime
     * @return
     */
    public static Date formatZonedDateTimeToDate(ZonedDateTime dateTime) {
        if (UtilValidate.isEmpty(dateTime)) {
            throw new DateTimeException("Please enter a ZonedDateTime!");
        }
        return Date.from(dateTime.toInstant());
    }

    /**
     * String 转换成 Date
     *
     * @param date
     * @return
     */
    public static Date formatStringToDate(String date){
        if (UtilValidate.isEmpty(date)) {
            throw new DateTimeException("Please enter the date string to be converted!");
        }
        return formatStringToDate(date,DATETIME_FORMATTER);
    }

    /**
     * String 转换成 Date
     *
     * @param date
     * @param format
     * @return
     */
    public static Date formatStringToDate(String date, String format){
        if (UtilValidate.isEmpty(date)) {
            throw new DateTimeException("Please enter the date string to be converted!");
        }
        if (UtilValidate.isEmpty(format)) {
            throw new DateTimeException("Please enter date format!");
        }
        return formatStringToDate(date,format,ZoneId.systemDefault());
    }

    /**
     * String 转换成 Date
     *
     * @param date
     * @param format
     * @return
     */
    public static Date formatStringToDate(String date, String format, ZoneId zoneId){
        if (UtilValidate.isEmpty(date)) {
            throw new DateTimeException("Please enter the date string to be converted!");
        }
        if (UtilValidate.isEmpty(format)) {
            throw new DateTimeException("Please enter date format!");
        }
        Date dt = null;
        try {
            DateTimeFormatter formatter = getDateTimeFormatter(format).withZone(zoneId);
            Instant instant = Instant.from(formatter.parse(date));
            dt =  Date.from(instant);
        } catch (DateTimeException e){
            throw new DateTimeException("Date conversion exception!");
        }
        return dt;
    }

    /**
     * 时间戳转换为LocalDate
     * @param timestamp
     * @return java.time.LocalDateTime
     */
    public static LocalDate formatTimeStampToLd(long timestamp){
        return formatDateToLd(formatLdtToDate(LocalDateTime.ofEpochSecond(timestamp/1000,0,ZoneOffset.ofHours(8))));
    }

    /**
     * Date对象转换为LocalDate对象
     *
     * @param date
     * @return java.time.LocalDate
     */
    public static LocalDate formatDateToLd(Date date){
        if (UtilValidate.isEmpty(date)) {
            throw new DateTimeException("Please enter a Date object to be converted!");
        }
        LocalDate ld = null;
        try {
            ld = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).toLocalDate();
        } catch (DateTimeException e){
            throw new DateTimeException("Date conversion exception!");
        }
        return ld;
    }

    /**
     * 将Date转成相应的时区的localDate
     *
     * @param date
     * @param zoneId
     * @return
     */
    public static LocalDate formatDateToLd(Date date, ZoneId zoneId) {
        if (UtilValidate.isEmpty(date)) {
            throw new DateTimeException("Please enter a Date object to be converted!");
        }
        LocalDate ld = null;
        try {
            ld = date.toInstant().atZone(zoneId).toLocalDate();
        } catch (DateTimeException e){
            throw new DateTimeException("Date conversion exception!");
        }
        return ld;
    }

    /**
     * 将Instant转成指定时区偏移量的localDate
     *
     * @param instant
     * @param zoneId
     * @return
     */
    public static LocalDate formatInstantToLd(Instant instant, ZoneId zoneId) {
        if (UtilValidate.isEmpty(instant)) {
            throw new DateTimeException("Please enter a Instant object to be converted!");
        }
        LocalDate ld = null;
        try {
            ld = instant.atZone(zoneId).toLocalDate();
        } catch (DateTimeException e){
            throw new DateTimeException("Date conversion exception!");
        }
        return ld;
    }

    /**
     * 将Instant转成系统默认时区偏移量的LocalDateTime
     *
     * @param instant
     * @return
     */
    public static LocalDateTime formatInstantToLdt(Instant instant) {
        if (UtilValidate.isEmpty(instant)) {
            throw new DateTimeException("Please enter a Instant object to be converted!");
        }
        return formatInstantToLdt(instant, ZoneId.systemDefault());
    }

    /**
     * 将Instant转换成指定时区偏移量的localDateTime
     *
     * @param instant
     * @param zoneId
     * @return
     */
    public static LocalDateTime formatInstantToLdt(Instant instant, ZoneId zoneId) {
        if (UtilValidate.isEmpty(instant)) {
            throw new DateTimeException("Please enter a Instant object to be converted!");
        }
        LocalDateTime ldt = null;
        try {
            ldt = instant.atZone(zoneId).toLocalDateTime();
        } catch (DateTimeException e){
            throw new DateTimeException("Date conversion exception!");
        }
        return ldt;
    }

    /**
     * 将ZoneDateTime 转成 LocalDateTime
     *
     * @param zonedDateTime
     * @return
     */
    public static LocalDateTime formatZonedDateTimeToLdt(ZonedDateTime zonedDateTime) {
        if (UtilValidate.isEmpty(zonedDateTime)) {
            throw new DateTimeException("Please enter a ZonedDateTime object to be converted!");
        }
        LocalDateTime ldt = null;
        try {
            ldt = zonedDateTime.toLocalDateTime();
        } catch (DateTimeException e){
            throw new DateTimeException("Date conversion exception!");
        }
        return ldt;
    }

    /**
     * 将ZoneDateTime 转成 指定时区偏移量的LocalDateTime
     *
     * @param zonedDateTime 时间
     * @param zoneId        指定时区偏移量
     * @return
     */
    public static LocalDateTime formatZonedDateTimeToLdt(ZonedDateTime zonedDateTime, ZoneId zoneId) {
        if (UtilValidate.isEmpty(zonedDateTime)) {
            throw new DateTimeException("Please enter a ZonedDateTime object to be converted!");
        }
        LocalDateTime ldt = null;
        try {
            ldt = zonedDateTime.toInstant().atZone(zoneId).toLocalDateTime();
        } catch (DateTimeException e){
            throw new DateTimeException("Date conversion exception!");
        }
        return ldt;
    }

    /**
     * String 转成 ZoneDateTime
     * 需要类似 yyyy-MM-dd HH:mm:ss 需要日期和时间信息完整信息
     *
     * @param date
     * @param format
     * @param zoneId
     * @return
     */
    public static ZonedDateTime stringToZoneDateTime(String date, String format, ZoneId zoneId) {
        if (UtilValidate.isEmpty(date)) {
            throw new DateTimeException("Please enter the date string to be converted!");
        }
        if (UtilValidate.isEmpty(format)) {
            throw new DateTimeException("Please enter date format!");
        }
        ZonedDateTime zdt = null;
        try {
            DateTimeFormatter formatter = getDateTimeFormatter(format).withZone(zoneId);
            Instant instant = Instant.from(formatter.parse(date));
            zdt =  ZonedDateTime.parse(date, formatter);
        } catch (DateTimeException e){
            throw new DateTimeException("Date conversion exception!");
        }
        return zdt;
    }


    /**
     * 将时间戳long转成ZonedDateTime
     *
     * @param timeStamp
     * @param zoneId
     * @return
     */
    public static ZonedDateTime longToZoneDateTime(long timeStamp, ZoneId zoneId) {
        if (UtilValidate.isEmpty(timeStamp)) {
            throw new DateTimeException("Please enter a timestamp to convert!");
        }
        ZonedDateTime zdt = null;
        try {
            zdt =  ZonedDateTime.from(Instant.ofEpochMilli(timeStamp).atZone(zoneId));
        } catch (DateTimeException e){
            throw new DateTimeException("Date conversion exception!");
        }
        return zdt;
    }

    /**
     * 两个时区的zoneDateTime相互转换
     *
     * @param zonedDateTime 需要转换的如期
     * @param zoneId        转换成的ZoneDateTime的时区偏移量
     * @return
     */
    public static ZonedDateTime zdtToZdt(ZonedDateTime zonedDateTime, ZoneId zoneId) {
        if (UtilValidate.isEmpty(zonedDateTime)) {
            throw new DateTimeException("Please enter a ZonedDateTime object to be converted!");
        }
        ZonedDateTime zdt = null;
        try {
            zdt =  ZonedDateTime.ofInstant(zonedDateTime.toInstant(), zoneId);
        } catch (DateTimeException e){
            throw new DateTimeException("Date conversion exception!");
        }
        return zdt;
    }

    /**
     * Date 转成 指定时区偏移量的ZoneDateTime
     *
     * @param date
     * @param zoneId
     * @return
     */
    public static ZonedDateTime toZonedDateTime(Date date, ZoneId zoneId) {
        if (UtilValidate.isEmpty(date)) {
            throw new DateTimeException("Please enter a Date object to be converted!");
        }
        ZonedDateTime zdt = null;
        try {
            zdt = date.toInstant().atZone(zoneId);
        } catch (DateTimeException e){
            throw new DateTimeException("Date conversion exception!");
        }
        return zdt;
    }

    /**
     * LocaldateTime 转成 指定时区偏移量的ZonedDateTime
     *
     * @param localDateTime 本地时间
     * @param zoneId        转成ZonedDateTime的时区偏移量
     * @return
     */
    public static ZonedDateTime toZonedDateTime(LocalDateTime localDateTime, ZoneId zoneId) {
        if (UtilValidate.isEmpty(localDateTime)) {
            throw new DateTimeException("Please enter a LocalDateTime object to be converted!");
        }
        ZonedDateTime zdt = null;
        try {
            zdt = localDateTime.atZone(zoneId);
        } catch (DateTimeException e){
            throw new DateTimeException("Date conversion exception!");
        }
        return zdt;
    }

    /**
     * Date装换成String
     *
     * @param date   时间
     * @param format 转化格式
     * @return
     */
    public static String formatDateToString(Date date, String format, ZoneId zoneId) {
        if (UtilValidate.isEmpty(date)) {
            throw new DateTimeException("Please enter the date string to be converted!");
        }
        if (UtilValidate.isEmpty(format)) {
            throw new DateTimeException("Please enter date format!");
        }
        String dateStr = null;
        try {
            DateTimeFormatter formatter = getDateTimeFormatter(format).withZone(zoneId);
            dateStr = formatter.format(date.toInstant());
        } catch (DateTimeException e){
            throw new DateTimeException("Date conversion exception!");
        }
        return dateStr;
    }

    /**
     * ZoneDateTime 转换成 String
     *
     * @param dateTime
     * @param zoneId   localDateTime所属时区
     * @return
     */
    public static String zoneDateTimeToString(ZonedDateTime dateTime, String format, ZoneId zoneId) {
        if (UtilValidate.isEmpty(dateTime)) {
            throw new DateTimeException("Please enter the ZonedDateTime Object to be converted!");
        }
        if (UtilValidate.isEmpty(format)) {
            throw new DateTimeException("Please enter date format!");
        }
        String dateStr = null;
        try {
            DateTimeFormatter formatter = getDateTimeFormatter(format).withZone(zoneId);
            dateStr = dateTime.format(formatter);
        } catch (DateTimeException e){
            throw new DateTimeException("Date conversion exception!");
        }
        return dateStr;
    }

    /**
     * 将ZonedDateTime转成时间戳long
     *
     * @return
     * @parm zonedDateTime
     */
    public static long zoneDateTimeToLong(ZonedDateTime zonedDateTime) {
        if (UtilValidate.isEmpty(zonedDateTime)) {
            throw new DateTimeException("Please enter the ZonedDateTime Object to be converted!");
        }
        long timeStamp = 0L;
        try {
            timeStamp = zonedDateTime.toInstant().toEpochMilli();
        } catch (DateTimeException e){
            throw new DateTimeException("Date conversion exception!");
        }
        return timeStamp;
    }

    /**
     * 将LocalDateTime转成时间戳long
     *
     * @param localDateTime
     * @param zoneId
     * @return
     */
    public static long toLong(LocalDateTime localDateTime, ZoneId zoneId) {
        if (UtilValidate.isEmpty(localDateTime)) {
            throw new DateTimeException("Please enter the LocalDateTime Object to be converted!");
        }
        long timeStamp = 0L;
        try {
            timeStamp = zoneDateTimeToLong(localDateTime.atZone(zoneId));
        } catch (DateTimeException e){
            throw new DateTimeException("Date conversion exception!");
        }
        return timeStamp;
    }

    /**
     * 获取周第一天
     *
     * @param date
     * @return
     */
    public static Date getStartDayOfWeek(String date) {
        if (UtilValidate.isEmpty(date)) {
            throw new DateTimeException("Please enter the date string to be converted!");
        }
        Date dt = null;
        try {
            LocalDate now = LocalDate.parse(date);
            dt =  getStartDayOfWeek(now);
        } catch (DateTimeException e){
            throw new DateTimeException("Date conversion exception!");
        }
        return dt;
    }

    public static Date getStartDayOfWeek(TemporalAccessor date) {
        TemporalField fieldISO = WeekFields.of(Locale.CHINA).dayOfWeek();
        LocalDate localDate = LocalDate.from(date);
        localDate = localDate.with(fieldISO, 1);
        return formatLdToDate(localDate);
    }

    /**
     * 获取周最后一天
     *
     * @param date
     * @return
     */
    public static Date getEndDayOfWeek(String date) {
        if (UtilValidate.isEmpty(date)) {
            throw new DateTimeException("Please enter the date string to be converted!");
        }
        Date dt = null;
        try {
            LocalDate now = LocalDate.parse(date);
            dt =  getEndDayOfWeek(now);
        } catch (DateTimeException e){
            throw new DateTimeException("Date conversion exception!");
        }
        return dt;
    }

    public static Date getEndDayOfWeek(TemporalAccessor date) {
        TemporalField fieldISO = WeekFields.of(Locale.CHINA).dayOfWeek();
        LocalDate localDate = LocalDate.from(date);
        localDate = localDate.with(fieldISO, 7);
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).plusDays(1L).minusNanos(1L).toInstant());
    }

    /**
     * util日期转换sql日期
     *
     * @param utilDate
     * @return
     * @throws UnifyException
     */
    public static java.sql.Date formatUtilDateToSqlDate(String utilDate) throws UnifyException {
        if (UtilValidate.isEmpty(utilDate)) {
            return null;
        } else {
            return formatUtilDateTosqlDate(formatStringToDate(utilDate));
        }
    }

    /**
     * util日期转换sql日期
     *
     * @param utilDate
     * @return
     * @throws UnifyException
     */
    public static java.sql.Date formatUtilDateTosqlDate(Date utilDate) throws UnifyException {
        try {
            if (UtilValidate.isEmpty(utilDate)) {
                return null;
            } else {
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                return sqlDate;
            }
        } catch (Exception e) {
            throw new UnifyException(e.getMessage());
        }

    }

    /**
     * 日期字符串转换sql日期
     *
     * @param dateStr
     * @return
     * @throws UnifyException
     */
    public static java.sql.Date formatStringToSqlDate(String dateStr) throws UnifyException {
        if (UtilValidate.isEmpty(dateStr)) {
            return null;
        } else {
            String dStr = dateStr;
            if (dStr.length() > 10) {
                dStr = dStr.substring(0, 10);
            }
            java.sql.Date sqlDate = new java.sql.Date((formatStringToDate(dStr)).getTime());
            return sqlDate;
        }
    }


    public static void main(String[] args) {
        System.out.println(getCurrentDateTime());
        Date date = new Date();
        System.out.println("formatDateToLdt()："+formatDateToLdt(date));
        System.out.println("formatDateToLdt()："+formatDateToLdt(date,DATETIME_FORMATTER));
        System.out.println("formatLdtToDate()："+formatLdtToDate(LocalDateTime.now()));
        System.out.println(formatTimestampToString(1562983881098L));
        System.out.println("formatDateToString()："+formatDateToString(date));
        System.out.println("formatDateToString()："+formatDateToString(date,DATE_PATTERN_2));
        System.out.println("formatDateToTimestamp()："+formatDateToTimestamp(date));
        System.out.println("formatTimeStampToLdt()："+formatTimeStampToLdt(formatDateToTimestamp(date)));
    }
}
