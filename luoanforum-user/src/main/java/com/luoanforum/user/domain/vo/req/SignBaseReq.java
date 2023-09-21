package com.luoanforum.user.domain.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "SignBaseReq对象", description = "普通登录请求对象")
public class SignBaseReq implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Size(min = 6, max = 20, message = "用户名长度必须在6-20之间")
    @ApiModelProperty("用户名")
    private String username;
    @Size(min = 6, max = 20, message = "密码长度必须在6-20之间")
    @ApiModelProperty("密码")
    private String password;
}
