package top.todev.tool.model.bean;

import cn.hutool.core.util.StrUtil;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.todev.tool.model.constant.IStaticDataEnum;
import top.todev.tool.model.exception.NotExceptException;

import java.io.Serializable;

import static top.todev.tool.model.constant.BaseErrorCodeEnum.ERROR_CODE_0;
import static top.todev.tool.model.constant.BaseErrorCodeEnum.ERROR_CODE_999902;

/**
 * <p>
 * 通用返回结果实体
 * </p>
 *
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020/8/26 9:50
 * @since 0.0.1
 */
@Data
@NoArgsConstructor
public class CommonResultResponse<T> implements Serializable, IResultResponse<T> {

    private static final long serialVersionUID = -8481647809768783516L;
    /**
     * 是否成功
     */
    private Boolean success;
    /**
     * 错误码
     */
    private String code;
    /**
     * 错误消息
     */
    private String message;
    /**
     * 结果数据
     */
    private T data;

    public CommonResultResponse(IStaticDataEnum<String> type) {
        super();
        this.code = type.getValue();
    }

    public CommonResultResponse(Boolean success) {
        super();
        this.success = success;
    }

    public CommonResultResponse(Boolean success, String message) {
        super();
        this.success = success;
        this.message = message;
    }

    public CommonResultResponse(Boolean success, T data) {
        super();
        this.success = success;
        this.data = data;
    }

    public CommonResultResponse(Boolean success, String code, String message) {
        super();
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public CommonResultResponse(Boolean success, IStaticDataEnum<String> type, String message) {
        super();
        this.success = success;
        this.code = type.getValue();
        this.message = message;
    }

    public CommonResultResponse(Boolean success, IStaticDataEnum<String> type, T data) {
        super();
        this.success = success;
        this.code = type.getValue();
        this.data = data;
    }

    public CommonResultResponse(Boolean success, String code, T data) {
        super();
        this.success = success;
        this.code = code;
        this.data = data;
    }


    public CommonResultResponse(Boolean success, String code, String message, T data) {
        super();
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    @Override
    public CommonResultResponse<T> initSuccess(T data) {
        this.success = true;
        this.code = ERROR_CODE_0.getValue();
        this.data = data;
        return this;
    }

    @Override
    public CommonResultResponse<T> initFailure(IStaticDataEnum<String> error) {
        this.success = false;
        this.code = error.getValue();
        this.message = error.getCnName();
        return this;
    }

    @Override
    public CommonResultResponse<T> initFailure(String code, String message) {
        this.success = false;
        this.code = code;
        this.message = message;
        return this;
    }
}
