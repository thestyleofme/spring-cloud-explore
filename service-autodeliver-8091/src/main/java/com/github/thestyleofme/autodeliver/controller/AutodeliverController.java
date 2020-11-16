package com.github.thestyleofme.autodeliver.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
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

    public AutodeliverController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/checkState/{userId}")
    @HystrixCommand(
            // 舱壁模式 线程池隔离
            threadPoolKey = "findResumeOpenState",
            threadPoolProperties = {
                    // com.netflix.hystrix.HystrixThreadPoolProperties
                    @HystrixProperty(name = "coreSize", value = "2"),
                    @HystrixProperty(name = "maxQueueSize", value = "20")
            },
            commandProperties = {
                    // com.netflix.hystrix.HystrixCommandProperties
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
                    // hystrix高级特性，定制工作过程细节
                    // 如8s内，请求次数达到两个，并且失败率在50%以上，就跳闸，跳闸活动窗口设置为3s
                    // 统计时间窗口定义
                    , @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "8000"),// 默认1000
                    // 统计时间窗口内的最小请求数
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2"),// 默认20
                    // 统计时间窗口内的错数数量百分比阈值
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),// 默认50
                    // 自我修复时的活动窗口长度
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "3000")// 默认5000
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
