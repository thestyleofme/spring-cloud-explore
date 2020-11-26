package com.github.thestyleofme.resume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>
 * description
 * </p>
 *
 * @author isaac 2020/11/12 3:59
 * @since 1.0.0
 */
@SpringBootApplication
@EntityScan("com.github.thestyleofme.common.pojo")
@EnableDiscoveryClient
public class ResumeApplication8082 {

    public static void main(String[] args) {
        SpringApplication.run(ResumeApplication8082.class,args);
    }
}
