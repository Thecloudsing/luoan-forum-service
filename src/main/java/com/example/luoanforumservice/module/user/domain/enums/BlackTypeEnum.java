package com.example.luoanforumservice.module.user.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public enum BlackTypeEnum {
    UID(0, "用户id"),
    IP(2, "ip地址"),
            ;
    private final Integer type;
    private final String desc;
    private static Map<Integer, BlackTypeEnum> cache;
    static {
        cache = Arrays.stream(BlackTypeEnum.values()).collect(Collectors.toMap(BlackTypeEnum::getType, Function.identity()));
    }
    public BlackTypeEnum of(Integer type) {
        return cache.get(type);
    }
}
