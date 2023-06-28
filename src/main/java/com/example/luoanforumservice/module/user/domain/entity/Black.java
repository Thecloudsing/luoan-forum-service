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
 * 黑名单
 * </p>
 *
 * @author luoan
 * @since 2023-06-26 10:53:25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "black", autoResultMap = true)
@ApiModel(value = "Black对象", description = "黑名单")
public class Black implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("黑名单id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("拉黑类型 {1: 用户id, 2: ip地址}")
    @TableField("type")
    private Integer type;

    @ApiModelProperty("源目标")
    @TableField("target")
    private String target;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("修改时间")
    @TableField("update_time")
    private LocalDateTime updateTime;
}
