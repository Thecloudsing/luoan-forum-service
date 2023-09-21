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
 * 用户绑定第三方表
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
@TableName(value = "user_bind_third_party", autoResultMap = true)
@ApiModel(value = "UserBindThirdParty对象", description = "用户绑定第三方表")
public class UserBindThirdParty implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("自增id主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户id")
    @TableField("uid")
    private Integer uid;

    @ApiModelProperty("第三方类型")
    @TableField("third_party_type")
    private String thirdPartyType;

    @ApiModelProperty("第三方账号")
    @TableField("third_party_account")
    private String thirdPartyAccount;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;
}
