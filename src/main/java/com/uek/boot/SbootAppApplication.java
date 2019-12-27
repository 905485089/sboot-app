package com.uek.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1. 每个SpringBoot的项目 都会有一个使用@SpringBootApplication标注的启动类
 * 入口方法
 * 2. 如何启动springboot的项目？？？
 * 1.直接执行启动类的main方法即可
 * 2.利用maven命令来启动springboot的项目
 * spring-boot:run
 * 3. springboot重要的东西
 * a. 启动类
 *
 * @SpringBootApplication
 * @Configuration
 * @ComponentScan({""})
 * @xxxxx b. 配置文件
 * application.properties
 * c. springBoot默认的扫描机制
 * 和启动类统计被的所有包及子包都会被扫描
 * 4. clean package spring-boot-repackage
 * 5. SpringBoot的优势
 * a. 配置少
 * b. 打包后直接运行无需web容器
 * c.
 */

@SpringBootApplication
@MapperScan({"com.uek.boot.mapper"})
public class SbootAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(SbootAppApplication.class, args);
    }

}
