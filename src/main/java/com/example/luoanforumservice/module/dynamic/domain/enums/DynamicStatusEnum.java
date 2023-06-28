package com.example.luoanforumservice.module.dynamic.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public enum DynamicStatusEnum {
    DELETE(0, "删除"),
    NORMAL(1, "正常"),
    ;
    private final Integer status;
    private final String desc;
    private static Map<Integer, DynamicStatusEnum> cache;
    static {
        cache = Arrays.stream(DynamicStatusEnum.values()).collect(Collectors.toMap(DynamicStatusEnum::getStatus, Function.identity()));
    }
    public static DynamicStatusEnum of(Integer type) {
        return cache.get(type);
    }
}
