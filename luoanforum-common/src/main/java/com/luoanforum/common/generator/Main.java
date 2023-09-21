package com.luoanforum.common.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.Types;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        FastAutoGenerator.create(
                "jdbc:mysql://127.0.0.1:3306/luoanforum_user?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8",
                        "root", "123456")
                .globalConfig(builder -> {
                    builder.author("luoan") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D://out"); // 指定输出目录
                })
                .dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                    int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                    if (typeCode == Types.SMALLINT) {
                        // 自定义类型转换
                        return DbColumnType.INTEGER;
                    }
                    return typeRegistry.getColumnType(metaInfo);

                }))
                .packageConfig(builder -> {
                    builder.parent("com.luoanforum") // 设置父包名
                            .moduleName("user") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D://out/xml")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("user_base_data") // 设置需要生成的表名
                            .addInclude("user_bind_third_party")
                            .addInclude("user_auth")
                            .addInclude("user_opt_time")
                            .addInclude("role")
                            .addInclude("user_role")
                            .addInclude("permission")
                            .addInclude("user_permission")
                            .addInclude("role_permission")
                            .addInclude("black")
                            .addInclude("user_black");


//                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
//                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
