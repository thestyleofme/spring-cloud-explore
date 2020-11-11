package com.github.thestyleofme.autodeliver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

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
public class AutodeliverApplication8090 {

    public static void main(String[] args) {
        SpringApplication.run(AutodeliverApplication8090.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
