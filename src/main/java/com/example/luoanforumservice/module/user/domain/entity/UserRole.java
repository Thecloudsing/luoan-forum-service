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
 * 用户权限表
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
@TableName(value = "user_role", autoResultMap = true)
@ApiModel(value = "UserRole对象", description = "用户权限表")
public class UserRole implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户权限id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("权限id")
    @TableField("role_id")
    private Long roleId;

    @ApiModelProperty("用户id")
    @TableField("uid")
    private Long uid;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("修改时间")
    @TableField("update_time")
    private LocalDateTime updateTime;
}
