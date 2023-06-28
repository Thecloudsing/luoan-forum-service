package com.example.luoanforumservice.module.chat.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public enum ChatStatusEnum {
    DELETE(0, "删除"),
    NORMAL(1, "正常"),
    ;
    private final Integer status;
    private final String desc;
    private static Map<Integer, ChatStatusEnum> cache;
    static {
        cache = Arrays.stream(ChatStatusEnum.values()).collect(Collectors.toMap(ChatStatusEnum::getStatus, Function.identity()));
    }
    public static ChatStatusEnum of(Integer type) {
        return cache.get(type);
    }
}
