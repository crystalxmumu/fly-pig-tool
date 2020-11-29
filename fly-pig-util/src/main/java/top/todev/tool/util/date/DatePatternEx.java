package top.todev.tool.util.date;

/**
 * <p>
 * 日期格式化扩展类
 * </p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020/9/24 8:48
 * @since 0.0.1
 */
public class DatePatternEx {

    /**
     * 标准时间格式：HH:mm。示例：07:34
     */
    public static final String NORM_MINI_TIME_PATTERN = "HH:mm";

    /**
     * UTC时间：yyyy-MM-dd'T'HH:mm。示例：2017-10-25T13:12
     */
    public static final String UTC_MINI_PATTERN = "yyyy-MM-dd'T'HH:mm";

    /**
     * UTC时间：yyyy-MM-dd'T'HH:mmXXX。示例：2013-12-30T01:45+08:00
     */
    public static final String UTC_MINI_WITH_ZONE_PATTERN = "yyyy-MM-dd'T'HH:mmXXX";


}
