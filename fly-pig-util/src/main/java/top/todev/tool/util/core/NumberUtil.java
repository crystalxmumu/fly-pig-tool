package top.todev.tool.util.core;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>数字工具类</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2021-02-06 05:58
 * @since 0.0.2
 */
@Slf4j
public class NumberUtil {

    /**
     * <p>忽略字符串中的非数字，转换为数字</p>
     * @param value 字符串
     * @return 数字
     * @throws NumberFormatException 数字格式异常
     * @author 小飞猪
     * @date 2021/2/6 6:02
     * @since 0.0.2
     */
    public static int parseInt(String value) throws NumberFormatException {
        if (StrUtil.isBlank(value)) {
            return 0;
        }
        String number = value.replaceAll("[^0-9\\.]", StrUtil.EMPTY);
        log.debug("[{}]去除非数字后: [{}]", value, number);
        return cn.hutool.core.util.NumberUtil.parseInt(number);
    }
}
