package com.example.luoanforumservice.module.chat.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 从消息表
 * </p>
 *
 * @author luoan
 * @since 2023-06-26 11:00:26
 */
@Getter
@Setter
@TableName("user_sub_msg")
@ApiModel(value = "UserSubMsg对象", description = "从消息表")
public class UserSubMsg implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("从消息id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("主消息id")
    private Long msgId;

    @ApiModelProperty("消息发送者用户id")
    private Long senderId;

    @ApiModelProperty("消息接收者用户id")
    private Long getterId;

    @ApiModelProperty("消息体")
    private String content;

    @ApiModelProperty("回复消息id")
    private Long replyMsgId;

    @ApiModelProperty("回复消息的间隔行数")
    private Integer gapCount;

    @ApiModelProperty("消息类型 {1: 文本, 2: 文件}")
    private Integer type;

    @ApiModelProperty("消息状态 {0: 消息撤回, 1: 消息正常}")
    private Integer msgStatus;

    @ApiModelProperty("消息状态 {0: 删除, 1: 正常}")
    private Integer status;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("修改时间")
    private LocalDateTime updateTime;
}
