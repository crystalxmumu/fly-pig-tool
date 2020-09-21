package top.todev.tool.model.action;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.todev.tool.model.bean.CommonResultResponse;
import top.todev.tool.model.bean.IResultResponse;
import top.todev.tool.model.exception.NotExceptException;

import java.util.function.Supplier;

import static top.todev.tool.model.constant.BaseErrorCodeEnum.ERROR_CODE_999903;

/**
 * <p>
 * Action基础接口
 * </p>
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020/8/27 8:52
 * @since 0.0.1
 */
public interface IBaseAction {

    Logger log = LoggerFactory.getLogger(IBaseAction.class);

    /***
     * <p>
     * 非App处理接口
     * </p>
     * @author 小飞猪
     * @since 2018/12/15 10:59
     * @param impl 接口处理
     * @param <T> 响应数据类型
     * @return 包装后的响应数据
     */
    default <T> IResultResponse<T> deal(Supplier<T> impl){
        CommonResultResponse<T> result = new CommonResultResponse<>();
        try {
            return result.initSuccess(impl.get());
        } catch (NotExceptException e) {
            log.warn("发生错误,原因:{}", e.getMessage());
            return result.initFailure(e.getErrorCode(), e.getMessage());
        } catch (Exception e){
            log.warn("发生错误", e);
            return result.initFailure(ERROR_CODE_999903);
        }
    }
}
