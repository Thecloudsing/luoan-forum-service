package com.luoanforum.user.domain.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "SignCodeReq对象", description = "验证码登录请求对象")
public class SignCodeReq {
    @Size(min = 6, max = 20, message = "用户名长度必须在6-20之间")
    @ApiModelProperty("用户名")
    private String username;
    @Size(min = 6, max = 6, message = "验证码长度必须为6位之")
    @ApiModelProperty("验证码")
    private String code;
    @ApiModelProperty("登录类型 1手机号 2邮箱")
    private Integer type;
}
