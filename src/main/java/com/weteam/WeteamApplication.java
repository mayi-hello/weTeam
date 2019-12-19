package com.weteam;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.weteam.mapper")
@EnableTransactionManagement
@EnableCaching
public class WeteamApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeteamApplication.class, args);
    }

}
