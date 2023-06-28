package com.example.luoanforumservice.module.chat.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 群聊从消息表
 * </p>
 *
 * @author luoan
 * @since 2023-06-26 11:00:26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("group_sub_msg")
@ApiModel(value = "GroupSubMsg对象", description = "群聊从消息表")
public class GroupSubMsg implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("群聊从消息id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("群聊主消息id")
    @TableField("group_msg_id")
    private Long groupMsgId;

    @ApiModelProperty("群聊id")
    @TableField("group_id")
    private Long groupId;

    @ApiModelProperty("消息发送者uid")
    @TableField("from_uid")
    private Long fromUid;

    @ApiModelProperty("消息体")
    @TableField("content")
    private String content;

    @ApiModelProperty("回复消息id")
    @TableField("reply_msg_id")
    private Long replyMsgId;

    @ApiModelProperty("回复消息的间隔行数")
    @TableField("gap_count")
    private Integer gapCount;

    @ApiModelProperty("消息类型 {1: 文本, 2: 文件}")
    @TableField("type")
    private Integer type;

    @ApiModelProperty("消息状态 {0: 消息撤回, 1: 消息正常}")
    @TableField("msg_status")
    private Integer msgStatus;

    @ApiModelProperty("消息状态 {0: 删除, 1: 正常}")
    @TableField("status")
    private Integer status;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("修改时间")
    @TableField("update_time")
    private LocalDateTime updateTime;
}
