package com.github.thestyleofme.autodeliver;

import javax.servlet.Servlet;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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
@EnableCircuitBreaker
// @SpringCloudApplication
public class AutodeliverApplication8091 {

    public static void main(String[] args) {
        SpringApplication.run(AutodeliverApplication8091.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    /**
     * 在被监控的的微服务中注册一个servlet，后期我们就是通过访问这个servlet来获取该服务的hystrix监控数据的
     * 前提：被监控的的微服务需要引入spring boot actuator
     */
    @Bean
    public ServletRegistrationBean<Servlet> getsServletRegistrationBean() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean<Servlet> servletRegistrationBean =
                new ServletRegistrationBean<>(streamServlet);
        servletRegistrationBean.setLoadOnStartup(1);
        // 浏览器访问 http://localhost:8090/actuator/hystrix.stream 然后调用该服务接口可看到数据
        servletRegistrationBean.addUrlMappings("/actuator/hystrix.stream");
        servletRegistrationBean.setName("HystrixMetricsStreamServlet");
        return servletRegistrationBean;
    }
}
