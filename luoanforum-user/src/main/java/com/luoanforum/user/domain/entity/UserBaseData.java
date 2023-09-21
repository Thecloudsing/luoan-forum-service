package com.luoanforum.user.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.luoanforum.user.domain.entity.JSON.UserExtra;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * <p>
 * 用户表
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
@TableName(value = "user_base_data", autoResultMap = true)
@ApiModel(value = "UserBaseData对象", description = "用户表")
public class UserBaseData implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("自增id主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("唯一标识")
    @TableField(value = "unique_identification")
    private String uniqueIdentification;

    @ApiModelProperty("昵称")
    @TableField("nickname")
    private String nickname;

    @ApiModelProperty("用户名")
    @TableField("username")
    private String username;

    @ApiModelProperty("头像")
    @TableField("avatar")
    private String avatar;

    @ApiModelProperty("手机号")
    @TableField("phone")
    private String phone;

    @ApiModelProperty("邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty("拓展信息")
    @TableField(value = "user_extra",
            typeHandler = com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler.class)
    private UserExtra userExtra;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;
}
