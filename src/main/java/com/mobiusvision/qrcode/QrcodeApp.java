package com.mobiusvision.qrcode;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
@MapperScan("com.mobiusvision.**.mapper")
public class QrcodeApp {
    public static void main(String[] args) {
        SpringApplication.run(QrcodeApp.class, args);
    }
}
