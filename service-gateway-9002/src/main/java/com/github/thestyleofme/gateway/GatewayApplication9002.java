package com.github.thestyleofme.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>
 * description
 * </p>
 *
 * @author isaac 2020/11/20 1:24
 * @since 1.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication9002 {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication9002.class, args);
    }
}
