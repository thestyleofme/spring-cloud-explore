package com.github.thestyleofme.hystrix.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * <p>
 * description
 * </p>
 *
 * @author isaac 2020/11/17 2:23
 * @since 1.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableTurbine
public class HystrixTurbineApplication9001 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixTurbineApplication9001.class, args);
    }
}
