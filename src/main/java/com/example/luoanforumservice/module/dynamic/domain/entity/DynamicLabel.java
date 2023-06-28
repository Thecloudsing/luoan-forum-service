package com.example.luoanforumservice.module.dynamic.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 动态标签表
 * </p>
 *
 * @author luoan
 * @since 2023-06-26 10:53:55
 */
@Getter
@Setter
@TableName(value = "dynamic_label", autoResultMap = true)
@ApiModel(value = "DynamicLabel对象", description = "动态标签表")
public class DynamicLabel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("标签id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("创建标签用户id")
    @TableField("uid")
    private Long uid;

    @ApiModelProperty("标签")
    @TableField("content")
    private String content;

    @ApiModelProperty("标签状态 {0: 删除, 1: 正常}")
    @TableField("status")
    private Integer status;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("修改时间")
    @TableField("update_time")
    private LocalDateTime updateTime;
}
