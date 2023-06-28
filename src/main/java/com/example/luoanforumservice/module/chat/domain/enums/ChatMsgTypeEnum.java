package com.example.luoanforumservice.module.chat.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public enum ChatMsgTypeEnum {
    TEXT(1, "文本"),
    FILE(2, "文件"),
    ;
    private final Integer type;
    private final String desc;
    private static Map<Integer, ChatMsgTypeEnum> cache;
    static {
        cache = Arrays.stream(ChatMsgTypeEnum.values()).collect(Collectors.toMap(ChatMsgTypeEnum::getType, Function.identity()));
    }
    public ChatMsgTypeEnum of(Integer type) {
        return cache.get(type);
    }
}
