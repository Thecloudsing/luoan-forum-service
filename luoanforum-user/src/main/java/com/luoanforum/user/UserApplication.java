package com.luoanforum.user;

import lombok.Cleanup;
import lombok.SneakyThrows;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.io.*;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;


/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableFeignClients
@MapperScan("com.luoanforum.user.mapper")
public class UserApplication
{

    public static void main(String[] args )
    {
        SpringApplication.run(UserApplication.class, args);
//        getFiles("C:\\Users\\17561\\IdeaProjects\\cloud-luoanforum\\luoanforum-user\\src\\main\\java\\com\\luoanforum\\user\\service",
//                filename -> filename.replace("Service", "Dao"),
//                "com.luoanforum.user.service", "com.luoanforum.user.dao");
    }

    /**
     * 获取目录下所有文件
     * @param path
     */
    public static void getFiles(String path, Function<String, String> function, String packageName, String packageNewName) {
        File filepath = new File(path);
        File[] files = filepath.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println("文件夹:" + file.getAbsolutePath());
                    getFiles(file.getAbsolutePath(), function, packageName, packageNewName);
                } else {
                    System.out.println("文件:" + file.getAbsolutePath());
                    String filename = file.getName();
                    String apply = function.apply(filename);
                    String newFilepath = file.getParent() + File.separator + apply;
                    if (file.renameTo(new File(newFilepath))) {
                        System.out.printf("文件: [%s] 修改成功!\n", filename);
                        replaceFileContent(filename, newFilepath, packageName, packageNewName);
                    } else {
                        System.out.printf("文件: [%s] 修改失败\n", filename);
                    }
                }
            }
        }
    }

    /**
     * 替换文件内容
     */
    @SneakyThrows
    public static void replaceFileContent(String oldFileName, String newFilepath, String packageName, String packageNewName) {
        File file = new File(newFilepath);
        @Cleanup BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuilder sb = new StringBuilder();
        String line;
        int lineIndex = 0;
        while ((line = br.readLine()) != null) {
            String newLine = null;
            if (line.contains(oldFileName = oldFileName.replace(".java", "").replace("Impl",""))) {
                newLine = line.replace(oldFileName, file.getName().replace(".java", "").replace("Impl",""));
            }
            newLine = newLine == null ? line : newLine;

            if (line.contains(packageName)) {
                newLine = newLine.replace(packageName, packageNewName);
            }
//            bw.write(newLine);
            sb.append(newLine).append("\n");
            if (Objects.equals(line, newLine)) {
                newLine = "没有匹配到需要替换的内容";
            }
            System.out.printf("第 %d 行: {\n原始内容=【 %s 】\n修改后内容=【 %s 】\n}\n", lineIndex, line, newLine);
            lineIndex++;
        }

        @Cleanup BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(sb.toString());
        bw.flush();
        System.out.printf("file: [%s] end => \n{\n%s\n}", file.getName(), sb);
    }

}
