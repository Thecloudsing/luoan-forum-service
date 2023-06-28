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
 * 动态评论表
 * </p>
 *
 * @author luoan
 * @since 2023-06-26 10:53:55
 */
@Getter
@Setter
@TableName("dynamic_comment")
@ApiModel(value = "DynamicComment对象", description = "动态评论表")
public class DynamicComment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("评论id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("评论发表用户id")
    private Long uid;

    @ApiModelProperty("评论内容")
    private String content;

    @ApiModelProperty("当前ip信息")
    private String ipInfo;

    @ApiModelProperty("评论状态 {0: 删除, 1: 正常}")
    private Integer status;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("修改时间")
    private LocalDateTime updateTime;
}
