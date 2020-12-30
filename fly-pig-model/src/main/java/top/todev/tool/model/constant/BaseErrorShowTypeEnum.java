package top.todev.tool.model.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>错误显示类型枚举</p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020-12-25 20:09
 * @since 0.0.1
 */
@Getter
@AllArgsConstructor
public enum BaseErrorShowTypeEnum implements IStaticDataEnum<Integer> {

    /** silent */
    SHOW_TYPE_0("SHOW_TYPE_0", "静音", 0),
    /** message.warn */
    SHOW_TYPE_1("SHOW_TYPE_1", "全局展示Warn", 1),
    /** message.error */
    SHOW_TYPE_2("SHOW_TYPE_2", "全局展示Error", 2),
    /** notification */
    SHOW_TYPE_4("SHOW_TYPE_4", "通知提醒框", 4),
    /** page */
    SHOW_TYPE_9("SHOW_TYPE_9", "页面处理", 9)
    ;
    /** 编码 */
    private final String code;
    /** 名称 */
    private final String cnName;
    /** 值 */
    private final Integer value;
}
