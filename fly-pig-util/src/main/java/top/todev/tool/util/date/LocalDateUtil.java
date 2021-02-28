package top.todev.tool.util.date;

import cn.hutool.core.date.CalendarUtil;
import cn.hutool.core.date.DatePattern;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;

import static java.time.format.DateTimeFormatter.BASIC_ISO_DATE;

/**
 * <p>
 * 本地日期对象工具类
 * </p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020/9/24 9:43
 * @since 0.0.1
 */
public class LocalDateUtil {

    /**
     * 获取日期的星期表示
     * @param date 日期
     * @return 星期几
     */
    public static String getWeek(LocalDate date) {
        return date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.SIMPLIFIED_CHINESE);
    }

    /**
     * 格式化为中文日期格式，如果isUppercase为false，则返回类似：2018年10月24日，否则返回二〇一八年十月二十四日
     * @param date        被格式化的日期
     * @param isUppercase 是否采用大写形式
     * @param withTime    是否包含时间部分
     * @return 中文日期字符串
     * @since 5.3.9
     */
    public static String formatChineseDate(LocalDate date, boolean isUppercase, boolean withTime) {
        if (null == date) {
            return null;
        }
        if (!isUppercase) {
            return date.format(
                    DateTimeFormatter.ofPattern(
                            withTime ? DatePattern.CHINESE_DATE_TIME_PATTERN : DatePattern.CHINESE_DATE_PATTERN));
        }
        return CalendarUtil.formatChineseDate(CalendarUtil.calendar(localDate2Date(date)), withTime);
    }

    /**
     * LocalDate转Date
     * @param localDate 本地日期
     * @return 日期
     */
    public static Date localDate2Date(LocalDate localDate) {
        if (null == localDate) {
            return null;
        }
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());

    }

    /**
     * Date转LocalDate
     * @param date 日期
     * @return 本地日期
     */
    public static LocalDate date2LocalDate(Date date) {
        if (null == date) {
            return null;
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * Date转换为LocalDateTime
     * @param date 日期
     * @return 本地日期时间
     */
    public static LocalDateTime date2LocalDateTime(Date date){
        if (date == null) {
            return null;
        }
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDateTime();
    }

    /**
     * LocalDateTime转换为Date
     * @param localDateTime 本地日期时间
     * @return 日期
     */
    public static Date localDateTime2Date( LocalDateTime localDateTime){
        if (localDateTime == null) {
            return null;
        }
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        return Date.from(zdt.toInstant());
    }

    /**
     * <p>从年、月日转化为LocalDate</p>
     * @param year 年
     * @param monthAndDay 月日
     * @return java.time.LocalDate
     * @author 小飞猪
     * @date 2021/2/27 7:07
     * @since 0.0.1
     */
    public static LocalDate fromPureDate(int year, String monthAndDay) {
        return LocalDate.parse(year + monthAndDay, BASIC_ISO_DATE);
    }
}
