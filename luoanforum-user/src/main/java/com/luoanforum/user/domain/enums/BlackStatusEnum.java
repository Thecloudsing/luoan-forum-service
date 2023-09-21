package com.luoanforum.user.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public enum BlackStatusEnum {
    /**
     * 黑名单状态
     */
    NORMAL(0, "正常"),
    BLACK(1, "拉黑"),
    ;
    private final Integer status;
    private final String desc;
    private final static Map<Integer, BlackStatusEnum> cache;
    static {
        cache = Arrays.stream(BlackStatusEnum.values()).collect(Collectors.toMap(BlackStatusEnum::getStatus, Function.identity()));
    }
    public static BlackStatusEnum of(Integer type) {
        return cache.get(type);
    }
}
