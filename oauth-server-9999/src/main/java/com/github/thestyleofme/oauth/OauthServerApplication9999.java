package com.github.thestyleofme.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>
 * description
 * </p>
 *
 * @author isaac 2020/11/25 3:06
 * @since 1.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EntityScan("com.github.thestyleofme")
public class OauthServerApplication9999 {

    public static void main(String[] args) {
        SpringApplication.run(OauthServerApplication9999.class, args);
    }
}
