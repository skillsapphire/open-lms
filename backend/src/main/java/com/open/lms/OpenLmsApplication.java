package com.open.lms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class OpenLmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenLmsApplication.class, args);
    }

}
