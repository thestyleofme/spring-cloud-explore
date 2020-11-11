package com.github.thestyleofme.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <p>
 * description
 * </p>
 *
 * @author isaac 2020/11/12 2:34
 * @since 1.0.0
 */
@SpringBootApplication
@EnableEurekaServer
public class RegisterApplication8761 {

    public static void main(String[] args) {
        SpringApplication.run(RegisterApplication8761.class, args);
    }
}
