package com.luoanforum.user.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * <p>
 * 
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
@TableName(value = "user_opt_time", autoResultMap = true)
@ApiModel(value = "UserOptTime对象", description = "")
public class UserOptTime implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("自增id主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户id")
    @TableField("uid")
    private Integer uid;

    @ApiModelProperty("ip地址")
    @TableField("ip_address")
    private String ipAddress;

    @ApiModelProperty("地理位置")
    @TableField("geo_location")
    private String geoLocation;

    @ApiModelProperty("登录时间")
    @TableField("login_time")
    private LocalDateTime lastLoginTime;

    @ApiModelProperty("登出时间")
    @TableField("logout_time")
    private LocalDateTime logoutTime;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;
}
