package com.example.luoanforumservice.module.stick.entity;

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
 * 动态标签表
 * </p>
 *
 * @author luoan
 * @since 2023-06-26 10:53:55
 */
@Getter
@Setter
@TableName("dynamic_label")
@ApiModel(value = "DynamicLabel对象", description = "动态标签表")
public class DynamicLabel implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("标签id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("创建标签用户id")
    private Long uid;

    @ApiModelProperty("标签")
    private String content;

    @ApiModelProperty("标签状态 {0: 删除, 1: 正常}")
    private Integer status;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("修改时间")
    private LocalDateTime updateTime;
}
