package com.github.thestyleofme.autodeliver.autoconfiguration;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * description
 * </p>
 *
 * @author isaac 2020/11/18 3:35
 * @since 1.0.0
 */
@Configuration
public class FeignLog {

    /**
     * feign的日志级别（feign请求过程信息）
     * NONE:默认的,本不显示任何日志  ---性能最好
     * BASIC:仅记录请求方法、URL、响应状态码以及执行时长  ----生产问题追踪
     * HEADERS:在BASIC级别的基础上,记录请求和响应的header
     * FULL:记录请求和响应的header, body和元数据  ----适用于开发及测试环境定位问题
     */
    @Bean
    Logger.Level feignLevel() {
        return Logger.Level.FULL;
    }
}
