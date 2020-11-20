package com.github.thestyleofme.stream.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>
 * description
 * </p>
 *
 * @author isaac 2020/11/21 2:46
 * @since 1.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class StreamProducer9090 {

    public static void main(String[] args) {
        SpringApplication.run(StreamProducer9090.class, args);
    }
}
