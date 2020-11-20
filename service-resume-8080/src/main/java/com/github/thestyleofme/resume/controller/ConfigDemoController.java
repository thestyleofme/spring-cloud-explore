package com.github.thestyleofme.resume.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
 * </p>
 *
 * @author isaac 2020/11/20 3:08
 * @since 1.0.0
 */
@RestController
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
