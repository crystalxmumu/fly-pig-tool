package top.todev.tool.util.core;


import cn.hutool.core.bean.BeanUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 转换工具类
 * </p>
 * @author linmeng
 * @version 1.0
 * @since 2018/12/15 11:53
 */

public class ConvertUtil {

    /**
     * <p>将源类实例转换为目标类实例</p>
     * @param sourceObj 源类实例
     * @param targetClz 目标类
     * @param <T> 目标类型
     * @return T 目标类实例
     * @author 小飞猪
     * @date 2020/12/14 9:16
     * @since 0.0.2
     */
    public static <T> T convertObject(Object sourceObj, Class<T> targetClz) {
        if (sourceObj == null) {
            return null;
        }
        if (targetClz == null) {
            throw new IllegalArgumentException("parameter clz shoud not be null");
        }
        try {
            T targetObj = targetClz.newInstance();
            BeanUtil.copyProperties(sourceObj, targetObj);
            return targetObj;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <p>将源类实例列表转换为目标类实例列表</p>
     * @param sources 源类实例列表
     * @param targetClz 目标类实例类型
     * @param <S> 源类型
     * @param <T> 目标类型
     * @return 目标类实例列表
     * @author 小飞猪
     * @date 2020/12/14 9:17
     * @since 0.0.2
     */
    public static <S, T> List<T> convertList(List<S> sources, Class<T> targetClz) {
        List<T> result = new ArrayList<>();
        if (sources == null) {
            return null;
        }
        if (sources.isEmpty()) {
            return result;
        }
        sources.forEach(temp -> {
            result.add(convertObject(temp, targetClz));
        });
        return result;
    }
}
