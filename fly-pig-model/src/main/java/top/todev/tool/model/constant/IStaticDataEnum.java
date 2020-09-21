package top.todev.tool.model.constant;

import cn.hutool.core.util.StrUtil;

/**
 * <p>
 * 静态数据枚举接口
 * </p>
 * @author 小飞猪
 * @version 0.0.1
 * @date 2020/8/26 9:50
 * @since 0.0.1
 */
public interface IStaticDataEnum<T> {

    /**
     * 获取枚举编码
     *
     * @return 枚举编码
     */
    String getCode();

    /**
     * 获取枚举名称<br/>
     * 该名称不能和枚举名称冲突
     * @return 枚举名称
     */
    String getCnName();

    /**
     * 获取枚举值
     * @return 枚举值
     */
    T getValue();

    /**
     * 根据编码查询枚举数据
     * @param sdds 枚举数组
     * @param code 枚举编码
     * @param <S>  枚举类型
     * @return 枚举对象
     */
    @SuppressWarnings("rawtypes")
    static <S extends IStaticDataEnum> S queryByCode(S[] sdds, String code) {
        if (StrUtil.isNotBlank(code)) {
            for (S sdd : sdds) {
                if (StrUtil.equals(code, sdd.getCode())) {
                    return sdd;
                }
            }
        }
        return null;
    }

    /**
     * 根据名称查询枚举数据
     * @param sdds 枚举数组
     * @param name 枚举名称
     * @param <S>  枚举类型
     * @return 枚举对象
     */
    @SuppressWarnings("rawtypes")
    static <S extends IStaticDataEnum> S queryByName(S[] sdds, String name) {
        if (StrUtil.isNotBlank(name)) {
            for (S sdd : sdds) {
                if (StrUtil.equals(name, sdd.getCnName())) {
                    return sdd;
                }
            }
        }
        return null;
    }

    /**
     * 根据数据值查询枚举数据
     * @param sdds  枚举数据
     * @param value 枚举值
     * @param <S>   枚举值类型
     * @return 枚举对象
     */
    @SuppressWarnings("rawtypes")
    static <S extends IStaticDataEnum, T> S queryByValue(S[] sdds, T value) {
        if (value != null && sdds != null) {
            for (S sdd : sdds) {
                if (value == sdd.getValue() || sdd.getValue().equals(value) || (
                        value instanceof String &&
                                StrUtil.equals(value.toString(), sdd.getValue().toString()))) {
                    return sdd;
                }
            }
        }
        return null;
    }
}
