package top.todev.tool.model.bean;

import cn.hutool.core.util.StrUtil;
import top.todev.tool.model.constant.IStaticDataEnum;
import top.todev.tool.model.exception.NotExceptException;

import static top.todev.tool.model.constant.BaseErrorCodeEnum.ERROR_CODE_0;
import static top.todev.tool.model.constant.BaseErrorCodeEnum.ERROR_CODE_999902;

/**
 * <p>
 * 返回数据实体接口
 * </p>
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020/8/27 8:52
 * @since 0.0.1
 */
public interface IResultResponse<T> {

    /**
     * 返回是否成功
     * @return 是否成功
     */
    Boolean getSuccess();

    /**
     * 返回错误码
     * @return 错误码
     */
    String getCode();

    /**
     * 返回错误原因
     * @return 错误原因
     */
    String getMessage();

    /**
     * 返回成功数据
     * @return 成功数据
     */
    T getData();

    /**
     * 初始化成功数据
     * @param data 成功数据
     * @return 响应数据
     */
    IResultResponse<T> initSuccess(T data);

    /**
     * 初始化失败数据
     * @param error 失败枚举
     * @return 响应数据
     */
    IResultResponse<T> initFailure(IStaticDataEnum<String> error);

    /**
     * 初始化失败数据
     * @param code 错误码
     * @param message 错误原因
     * @return 响应数据
     */
    IResultResponse<T> initFailure(String code, String message);

    /**
     * 获取响应结果数据
     * @param response 响应实体
     * @return 响应结果
     */
    static <T> T getResponseData(IResultResponse<T> response) {
        if (response != null && response.getSuccess() != null && response.getSuccess()) {
            return response.getData();
        }
        return null;
    }

    /**
     * 获取响应结果数据
     * @param response 响应实体
     * @return 响应结果
     * @throws NotExceptException 不期望的异常
     */
    static <T> T getResponseDataNotAllowNull(IResultResponse<T> response) throws NotExceptException {
        T data = getResponseDataAllowNull(response);
        if (data == null) {
            throw new NotExceptException(ERROR_CODE_999902);
        }
        return data;
    }

    /**
     * 获取响应数据
     * @param response 响应实体
     * @return 响应结果
     * @throws NotExceptException 不期望的异常
     */
    static <T> T getResponseDataAllowNull(IResultResponse<T> response) throws NotExceptException {
        if (response == null) {
            throw new NotExceptException(ERROR_CODE_999902);
        } else if( response.getSuccess() == null || !response.getSuccess()) {
            throw new NotExceptException(response.getCode(), StrUtil.isBlank(response.getMessage()) ? "响应失败, 原因未知" : response.getMessage());
        }
        return response.getData();
    }
}
