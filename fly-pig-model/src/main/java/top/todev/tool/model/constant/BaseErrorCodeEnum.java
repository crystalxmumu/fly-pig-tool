package top.todev.tool.model.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * 基础错误码枚举
 * </p>
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020/9/4 10:02
 * @since 0.0.1
 */
@Getter
@AllArgsConstructor
public enum BaseErrorCodeEnum implements IStaticDataEnum<String> {

    /** 成功 */
    ERROR_CODE_0("ERROR_CODE_0", "成功", "0"),
    /** 不期望发生的异常 */
    ERROR_CODE_999901("ERROR_CODE_999901", "不期望发生的异常", "999901"),
    /** 数据为空异常 */
    ERROR_CODE_999902("ERROR_CODE_999902", "数据为空", "999902"),
    /** 发生未知错误异常 */
    ERROR_CODE_999903("ERROR_CODE_999903", "发生未知错误", "999903")
    ;
    /** 编码 */
    private final String code;
    /** 名称 */
    private final String cnName;
    /** 值 */
    private final String value;
}
