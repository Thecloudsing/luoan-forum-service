package com.example.luoanforumservice;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        String name = "chat";
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/luoan-forum-service-db?characterEncoding=UTF-8&useUnicode=true&useSSL=false", "root", "331520")
                .globalConfig(builder -> {
                    builder.author("luoan") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .commentDate("yyyy-MM-dd hh:mm:ss")   // 注释日期
                            .outputDir("D://test"); // 指定输出目录
                })
//                .dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
//                    int typeCode = metaInfo.getJdbcType().TYPE_CODE;
//                    if (typeCode == Types.SMALLINT) {
//                        // 自定义类型转换
//                        return DbColumnType.INTEGER;
//                    }
//                    return typeRegistry.getColumnType(metaInfo);
//
//                }))
                .packageConfig(builder -> {
                    builder.parent("com.example.luoanforumservice") // 设置父包名
                            .moduleName(name) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D://test/" + name + '/')); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder
//                            .addInclude("black") // 设置需要生成的表名
//                            .addInclude("role")
//                            .addInclude("user_role")
//                            .addInclude("user_info")

//                            .addInclude("dynamic")
//                            .addInclude("dynamic_comment")
//                            .addInclude("dynamic_label")

                            .addInclude("user_main_msg")
                            .addInclude("user_sub_msg")
                            .addInclude("group_main_msg")
                            .addInclude("group_sub_msg")
                            .addTablePrefix("sys_") // 设置过滤表前缀
                            // Entity 策略配置
                            .entityBuilder()
                            .enableLombok() //开启 Lombok
                            .enableFileOverride() // 覆盖已生成文件
                            .naming(NamingStrategy.underline_to_camel)  //数据库表映射到实体的命名策略：下划线转驼峰命
                            .columnNaming(NamingStrategy.underline_to_camel)    //数据库表字段映射到实体的命名策略：下划线转驼峰命
                            // Mapper 策略配置
                            .mapperBuilder()
                            .enableFileOverride() // 覆盖已生成文件
                            // Service 策略配置
                            .serviceBuilder()
                            .enableFileOverride() // 覆盖已生成文件
                            .formatServiceFileName("%sService") //格式化 service 接口文件名称，%s进行匹配表名，如 UserService
                            .formatServiceImplFileName("%sServiceImpl") //格式化 service 实现类文件名称，%s进行匹配表名，如 UserServiceImpl
                            // Controller 策略配置
                            .controllerBuilder()
                            .enableFileOverride() // 覆盖已生成文件
                    ;
                })
//                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateEngine(new VelocityTemplateEngine())
                .execute();
    }
}