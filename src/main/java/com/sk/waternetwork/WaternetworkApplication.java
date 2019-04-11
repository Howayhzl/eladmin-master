package com.sk.waternetwork;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = "com.sk")
@EnableTransactionManagement
@EnableSwagger2
@MapperScan("com.sk.waternetwork.mapper")
public class WaternetworkApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(WaternetworkApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(this.getClass());
    }
}

