package com.github.thestyleofme.resume.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * 该类用于模拟，使用共享的那些配置信息做一些事情
 * 从配置中心获取配置
 * 如获取数据库连接，需重新初始化数据库连接池
 * <p>
 * 修改配置后，需手动刷新，前提加了actuator
 * POST http://localhost:9002/resm/actuator/refresh
 * 再次请求 配置将更新
 * http://localhost:9002/resm/config/view
 * <p>
 * 若使用了spring cloud bus 配置mq 如rabbit
 * config server发送bus-refresh，config client自动刷新配置
 * 在广播模式下，实现了一次请求，处处更新
 * POST http://localhost:9006/actuator/bus-refresh
 * <p>
 * 也可更新指定实例 如只更新8081的resume服务
 * POST http://localhost:9006/actuator/bus-refresh/service-resume:8081
 * </p>
 *
 * @author isaac 2020/11/20 3:08
 * @since 1.0.0
 */
// @RestController 暂时不使用config注册中心
@RequestMapping("/config")
@Slf4j
@RefreshScope
public class ConfigDemoController {

    // 和取本地配置信息一样

    @Value("${demo.message}")
    private String demoMessage;
    @Value("${mysql.url}")
    private String mysqlUrl;

    @GetMapping("/view")
    public String viewConfig() {
        return String.format("demoMessage: %s, mysqlUrl: %s", demoMessage, mysqlUrl);
    }

}
