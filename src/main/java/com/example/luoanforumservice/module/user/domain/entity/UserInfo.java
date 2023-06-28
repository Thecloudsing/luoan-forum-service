package com.example.luoanforumservice.module.user.domain.entity;

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
 * 用户表
 * </p>
 *
 * @author luoan
 * @since 2023-06-26 10:53:26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "user_info", autoResultMap = true)
@ApiModel(value = "UserInfo对象", description = "用户表")
public class UserInfo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("用户昵称")
    @TableField("name")
    private String name;

    @ApiModelProperty("性别 {0: 未知, 1: 男, 2: 女}, 默认0")
    @TableField("sex")
    private Integer sex;

    @ApiModelProperty("用户头像")
    @TableField("avatar")
    private String avatar;

    @ApiModelProperty("ip信息")
    @TableField("ip_info")
    private String ipInfo;

    @ApiModelProperty("状态 {0: 拉黑, 1: 正常}, 默认1")
    @TableField("status")
    private Integer status;

    @ApiModelProperty("最后上线时间")
    @TableField("last_opt_time")
    private LocalDateTime lastOptTime;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("修改时间")
    @TableField("update")
    private LocalDateTime updateTime;
}
