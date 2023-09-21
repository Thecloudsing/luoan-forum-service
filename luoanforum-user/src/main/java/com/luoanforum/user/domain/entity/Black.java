package com.luoanforum.user.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * <p>
 * 黑名单表
 * </p>
 *
 * @author luoan
 * @since 2023-07-24
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Black对象", description = "黑名单表")
@TableName(value = "black", autoResultMap = true)
public class Black implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("自增id主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户id")
    @TableField("uid")
    private Integer uid;

    @ApiModelProperty("黑名单类型")
    @TableField("type")
    private Integer type;

    @ApiModelProperty("黑名单目标")
    @TableField("target")
    private String target;

    @ApiModelProperty("拉黑原因")
    @TableField("reason")
    private String reason;

    @ApiModelProperty("拉黑状态 1正常 0拉黑")
    @TableField("status")
    private Integer status;

    @ApiModelProperty("拉黑时间")
    @TableField("blackout_time")
    private LocalDateTime blackoutTime;

    @ApiModelProperty("拉黑结束时间 默认-1永久")
    @TableField("black_time")
    private Integer blackTime;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;
}
