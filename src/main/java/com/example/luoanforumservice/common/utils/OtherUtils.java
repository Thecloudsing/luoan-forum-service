package com.example.luoanforumservice.common.utils;

import java.util.Objects;

/**
 * Description: 杂七杂八的工具类
 * Author: luoan
 * Date: 2023/6/27
 */
public class OtherUtils {
    public static <T> T posteriorPathway(Object target, Object def, Class<T> tClass) {
        if (Objects.isNull(target) && equalsType(tClass, def)) return (T) def;
        if (equalsType(tClass, target)) {
            return (T) target;
        }
        throw new RuntimeException(String.format("type mis match ! tClass is %s type, but target type is %s or def type is %s",
                target.getClass().getTypeName(), tClass.getTypeName(), def.getClass().getTypeName()));
    }

    public static boolean equalsType(Object src, Object desc) {
        return Objects.equals(src.getClass().getTypeName(), desc.getClass().getTypeName());
    }

    public static boolean equalsType(Class<?> src, Object desc) {
        return Objects.equals(src.getName(), desc.getClass().getTypeName());
    }
}
