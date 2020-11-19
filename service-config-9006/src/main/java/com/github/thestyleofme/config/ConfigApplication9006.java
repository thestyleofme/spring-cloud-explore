package com.github.thestyleofme.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * <p>
 * description
 * </p>
 *
 * @author isaac 2020/11/20 2:36
 * @since 1.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class ConfigApplication9006 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication9006.class, args);
    }
}
