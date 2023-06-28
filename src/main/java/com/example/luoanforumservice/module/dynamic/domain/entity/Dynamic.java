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
 * 动态表
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
@TableName(value = "dynamic", autoResultMap = true)
@ApiModel(value = "Dynamic对象", description = "动态表")
public class Dynamic implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("动态id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("动态发布用户id")
    @TableField("uid")
    private Long uid;

    @ApiModelProperty("动态标题")
    @TableField("title")
    private String title;

    @ApiModelProperty("动态内容")
    @TableField("content")
    private String content;

    @ApiModelProperty("动态标签")
    @TableField("label_id")
    private Long labelId;

    @ApiModelProperty("动态图片")
    @TableField("pictures")
    private String pictures;

    @ApiModelProperty("当前ip信息")
    @TableField("ip_info")
    private String ipInfo;

    @ApiModelProperty("动态状态 {0: 删除, 1: 正常}")
    @TableField("status")
    private Integer status;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("修改时间")
    @TableField("update_time")
    private LocalDateTime updateTime;
}
