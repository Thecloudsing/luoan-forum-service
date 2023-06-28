package com.example.luoanforumservice.module.stick.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

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
@Getter
@Setter
@ApiModel(value = "Dynamic对象", description = "动态表")
public class Dynamic implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("动态id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("动态发布用户id")
    private Long uid;

    @ApiModelProperty("动态标题")
    private String title;

    @ApiModelProperty("动态内容")
    private String content;

    @ApiModelProperty("动态标签")
    private Long labelId;

    @ApiModelProperty("动态图片")
    private String pictures;

    @ApiModelProperty("当前ip信息")
    private String ipInfo;

    @ApiModelProperty("动态状态 {0: 删除, 1: 正常}")
    private Integer status;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("修改时间")
    private LocalDateTime updateTime;
}
