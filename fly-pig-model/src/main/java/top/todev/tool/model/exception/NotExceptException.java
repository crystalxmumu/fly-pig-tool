package top.todev.tool.model.exception;

import cn.hutool.core.util.StrUtil;
import top.todev.tool.model.constant.IStaticDataEnum;

import java.io.Serializable;

import static top.todev.tool.model.constant.BaseErrorCodeEnum.ERROR_CODE_999901;

/**
 * 不期望发生的异常类。
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020/8/26 9:50
 * @since 0.0.1
 */
public class NotExceptException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = -1682216390489582032L;

	/** 错误码 */
	private final String errorCode;

	public NotExceptException() {
		this(ERROR_CODE_999901);
	}

	public NotExceptException(IStaticDataEnum<String> error) {
		this(error.getValue(), error.getCnName());
	}

	public NotExceptException(String errorCode, String msg) {
		super(msg);
		this.errorCode = errorCode;
	}

	public NotExceptException(String errorCode, String msg, Exception e) {
		super(msg, e);
		this.errorCode = errorCode;
	}

	/**
	 * <p>
	 * 模板方式创建异常
	 * </p>
	 * @param errorCode 错误码
	 * @param msg 字符串模板
	 * @param args 参数
	 */
	public NotExceptException(String errorCode, String msg, Object... args) {
		super(StrUtil.format(msg, args));
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}
}
