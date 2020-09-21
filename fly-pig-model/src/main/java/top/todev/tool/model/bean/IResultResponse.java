package top.todev.tool.model.bean;

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
    String getErrorCode();

    /**
     * 返回错误原因
     * @return 错误原因
     */
    String getErrorMessage();

    /**
     * 返回成功数据
     * @return 成功数据
     */
    T getData();
}
