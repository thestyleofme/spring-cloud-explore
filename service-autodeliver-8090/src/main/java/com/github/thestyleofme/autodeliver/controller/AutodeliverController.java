package com.github.thestyleofme.autodeliver.controller;

import java.util.List;

import org.springframework.cloud.client.ServiceInstance;
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

    @GetMapping("/checkState/{userId}")
    public Integer findResumeOpenState(@PathVariable Long userId) {
        List<ServiceInstance> instances = discoveryClient.getInstances("service-resume");
        ServiceInstance serviceInstance = instances.get(0);
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        return restTemplate.getForObject("http://{1}:{2}/resume/openstate/{3}", Integer.class, host, port, userId);
    }
}
