package com.example.luoanforumservice.module.user.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public enum UserStatusEnum {
    BLOCK(0, "拉黑"),
    NORMAL(2, "正常"),
            ;
    private final Integer status;
    private final String desc;
    private static Map<Integer, UserStatusEnum> cache;
    static {
        cache = Arrays.stream(UserStatusEnum.values()).collect(Collectors.toMap(UserStatusEnum::getStatus, Function.identity()));
    }
    public UserStatusEnum of(Integer type) {
        return cache.get(type);
    }
}
