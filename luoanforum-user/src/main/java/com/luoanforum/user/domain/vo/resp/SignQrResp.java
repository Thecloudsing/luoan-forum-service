package com.luoanforum.user.domain.vo.resp;

import io.swagger.annotations.ApiModel;
import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "SignQrResp对象", description = "二维码登录响应对象")
public class SignQrResp {
    private String qrCode;
}
