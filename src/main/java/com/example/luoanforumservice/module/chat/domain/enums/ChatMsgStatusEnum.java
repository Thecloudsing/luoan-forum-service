package com.example.luoanforumservice.module.chat.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public enum ChatMsgStatusEnum {
    MESSAGE_RECALL(0, "消息撤回"),
    MESSAGE_OK(1, "消息正常"),
    ;
    private final Integer status;
    private final String desc;
    private static Map<Integer, ChatMsgStatusEnum> cache;
    static {
        cache = Arrays.stream(ChatMsgStatusEnum.values()).collect(Collectors.toMap(ChatMsgStatusEnum::getStatus, Function.identity()));
    }
    public static ChatMsgStatusEnum of(Integer type) {
        return cache.get(type);
    }
}
