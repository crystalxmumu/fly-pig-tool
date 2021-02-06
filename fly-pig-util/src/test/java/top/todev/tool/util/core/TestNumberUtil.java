package top.todev.tool.util.core;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * <p>数字工具测试类</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2021-02-06 06:05
 * @since 0.0.1
 */
@Slf4j
public class TestNumberUtil {

    @Test
    public void testNumber() {
        log.info("数值1:{}", NumberUtil.parseInt("aa13.5附件为.3"));
        log.info("数值2:{}", NumberUtil.parseInt("2发文件3.分为7"));
        log.info("数值3:{}", NumberUtil.parseInt("16b#"));
    }
}
