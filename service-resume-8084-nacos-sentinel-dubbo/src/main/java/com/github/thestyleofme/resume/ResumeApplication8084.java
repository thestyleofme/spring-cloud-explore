package com.github.thestyleofme.resume;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
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
@DubboComponentScan(basePackages = {
        "com.github.thestyleofme"
})
public class ResumeApplication8084 {

    public static void main(String[] args) {
        SpringApplication.run(ResumeApplication8084.class,args);
    }
}
