package com.luoanforum.user.domain.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "SignQrReq对象", description = "二维码登录请求对象")
public class SignQrReq implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("二维码")
    private String qrCode;
    @ApiModelProperty("uuid")
    private String uuid;
    @ApiModelProperty("token")
    private String token;
}
