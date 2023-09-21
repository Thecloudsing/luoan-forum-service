package com.luoanforum.user.controller;

import com.luoanforum.user.utils.QRCodeUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/qr/code")
public class QrCodeController {

    private static final String RootPath="D:\\out\\QRCode";
    private static final String FileFormat=".png";

    private static final ThreadLocal<SimpleDateFormat> LOCALDATEFORMAT=ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMddHHmmss"));

    //生成二维码并将其存放于本地目录
    @GetMapping("/v1")
    public Integer generateV1(@RequestParam("content") String content){
        final String fileName=LOCALDATEFORMAT.get().format(new Date());
        QRCodeUtil.createCodeToFile(content,new File(RootPath),fileName+FileFormat);
        return 200;
    }

    //生成二维码并将其返回给前端调用者
    @GetMapping("/v2")
    public Integer generateV2(String content, HttpServletResponse servletResponse) throws IOException {
        QRCodeUtil.createCodeToOutputStream(content,servletResponse.getOutputStream());
        return 200;
    }
}