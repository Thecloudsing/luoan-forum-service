package com.example.luoanforumservice.module.dynamic.domain.entity;

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
 * 动态评论表
 * </p>
 *
 * @author luoan
 * @since 2023-06-26 10:53:55
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "dynamic_comment", autoResultMap = true)
@ApiModel(value = "DynamicComment对象", description = "动态评论表")
public class DynamicComment implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("评论id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("评论发表用户id")
    @TableField("uid")
    private Long uid;

    @ApiModelProperty("评论内容")
    @TableField("content")
    private String content;

    @ApiModelProperty("当前ip信息")
    @TableField("ip_info")
    private String ipInfo;

    @ApiModelProperty("评论状态 {0: 删除, 1: 正常}")
    @TableField("status")
    private Integer status;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("修改时间")
    @TableField("update_time")
    private LocalDateTime updateTime;
}
