package com.github.thestyleofme.autodeliver.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 * description
 * </p>
 *
 * @author isaac 2020/11/12 4:30
 * @since 1.0.0
 */
@RestController
@RequestMapping("/autodeliver")
@Slf4j
public class AutodeliverController {

    private final RestTemplate restTemplate;
    private final DiscoveryClient discoveryClient;

    public AutodeliverController(RestTemplate restTemplate,
                                 DiscoveryClient discoveryClient) {
        this.restTemplate = restTemplate;
        this.discoveryClient = discoveryClient;
    }

    /*@GetMapping("/checkState/{userId}")
    public Integer findResumeOpenState(@PathVariable Long userId) {
        return restTemplate.getForObject("http://localhost:8080/resume/openstate/{1}", Integer.class, userId);
    }*/

    /*@GetMapping("/checkState/{userId}")
    public Integer findResumeOpenState(@PathVariable Long userId) {
        List<ServiceInstance> instances = discoveryClient.getInstances("service-resume");
        ServiceInstance serviceInstance = instances.get(0);
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        // restTemplate未设置@LoadBalanced时可如下调用
        return restTemplate.getForObject("http://{1}:{2}/resume/openstate/{3}", Integer.class, host, port, userId);
    }*/

    @GetMapping("/checkState/{userId}")
    @HystrixCommand(
            commandProperties = {
                    // com.netflix.hystrix.HystrixCommandProperties 从此类中看所有的key以及默认值
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
            },
            fallbackMethod = "findResumeOpenStateFallback"
    )
    public Integer findResumeOpenState(@PathVariable Long userId) {
        return restTemplate.getForObject("http://service-resume/resume/openstate/{1}", Integer.class, userId);
    }

    /**
     * 该方法形参和返回值必须与原方法一致
     */
    public Integer findResumeOpenStateFallback(Long userId) {
        log.error("method findResumeOpenState Fallback, userId: {}", userId);
        return -1;
    }

}
