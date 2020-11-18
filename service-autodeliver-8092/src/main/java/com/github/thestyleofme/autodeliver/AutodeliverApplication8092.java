package com.github.thestyleofme.autodeliver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <p>
 * description
 * </p>
 *
 * @author isaac 2020/11/12 4:32
 * @since 1.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {
        "com.github.thestyleofme"
})
public class AutodeliverApplication8092 {

    public static void main(String[] args) {
        SpringApplication.run(AutodeliverApplication8092.class, args);
    }

}
