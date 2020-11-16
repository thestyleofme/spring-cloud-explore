package com.github.thestyleofme.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * <p>
 * description
 * </p>
 *
 * @author isaac 2020/11/17 1:34
 * @since 1.0.0
 */
@SpringBootApplication
@EnableHystrixDashboard
@EnableDiscoveryClient
public class HystrixDashboardApplication9000 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApplication9000.class, args);
    }
}
