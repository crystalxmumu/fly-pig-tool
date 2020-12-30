package top.todev.tool.model.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.todev.tool.model.constant.BaseErrorShowTypeEnum;
import top.todev.tool.model.constant.IStaticDataEnum;

import java.io.Serializable;

import static top.todev.tool.model.constant.BaseErrorCodeEnum.ERROR_CODE_0;

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
public class AntDesignProResultResponse<T> implements Serializable, IResultResponse<T> {

    private static final long serialVersionUID = -8481647809768783516L;
    /**
     * 是否成功
     */
    private Boolean success;
    /**
     * 错误码
     */
    private String errorCode;
    /**
     * 错误消息
     */
    private String errorMessage;
    /**
     * 结果数据
     */
    private T data;
    
    /** 错误消息的显示类型 */
    private Integer showType = BaseErrorShowTypeEnum.SHOW_TYPE_4.getValue();
    /** 后端跟踪的请求id */
    private String traceId;
    /** 请求机器 */
    private String host;

    public AntDesignProResultResponse(IStaticDataEnum<String> type) {
        super();
        this.errorCode = type.getValue();
    }

    public AntDesignProResultResponse(Boolean success) {
        super();
        this.success = success;
    }

    public AntDesignProResultResponse(Boolean success, String errorMessage) {
        super();
        this.success = success;
        this.errorMessage = errorMessage;
    }

    public AntDesignProResultResponse(Boolean success, T data) {
        super();
        this.success = success;
        this.data = data;
    }

    public AntDesignProResultResponse(Boolean success, String errorCode, String errorMessage) {
        super();
        this.success = success;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public AntDesignProResultResponse(Boolean success, IStaticDataEnum<String> type, String errorMessage) {
        super();
        this.success = success;
        this.errorCode = type.getValue();
        this.errorMessage = errorMessage;
    }

    public AntDesignProResultResponse(Boolean success, IStaticDataEnum<String> type, T data) {
        super();
        this.success = success;
        this.errorCode = type.getValue();
        this.data = data;
    }

    public AntDesignProResultResponse(Boolean success, String errorCode, T data) {
        super();
        this.success = success;
        this.errorCode = errorCode;
        this.data = data;
    }


    public AntDesignProResultResponse(Boolean success, String errorCode, String errorMessage, T data) {
        super();
        this.success = success;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.data = data;
    }

    @Override
    public AntDesignProResultResponse<T> initSuccess(T data) {
        this.success = true;
        this.errorCode = ERROR_CODE_0.getValue();
        this.data = data;
        return this;
    }

    @Override
    public AntDesignProResultResponse<T> initFailure(IStaticDataEnum<String> error) {
        this.success = false;
        this.errorCode = error.getValue();
        this.errorMessage = error.getCnName();
        return this;
    }

    @Override
    public AntDesignProResultResponse<T> initFailure(String errorCode, String errorMessage) {
        this.success = false;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        return this;
    }

    @Override
    @JsonIgnore
    public String getCode() {
        return this.errorCode;
    }

    @Override
    @JsonIgnore
    public String getMessage() {
        return this.errorMessage;
    }
}
