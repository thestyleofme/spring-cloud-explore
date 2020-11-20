package com.github.thestyleofme.stream.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>
 * description
 * </p>
 *
 * @author isaac 2020/11/21 3:13
 * @since 1.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class StreamConsumer9091 {

    public static void main(String[] args) {
        SpringApplication.run(StreamConsumer9091.class, args);
    }
}
