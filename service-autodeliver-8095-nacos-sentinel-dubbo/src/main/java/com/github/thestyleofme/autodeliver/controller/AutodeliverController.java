package com.github.thestyleofme.autodeliver.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.thestyleofme.autodeliver.sentinel.SentinelHandlerClass;
import com.github.thestyleofme.dubbo.api.ResumeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Reference
    private ResumeService resumeService;

    @GetMapping("/checkState/{userId}")
    @SentinelResource(value = "findResumeOpenState",
            // blockHandler只处理流控的异常，不处理java异常
            blockHandlerClass = SentinelHandlerClass.class,
            blockHandler = "handleException",
            // java异常需指定fallback
            fallbackClass = SentinelHandlerClass.class,
            fallback = "handleError")
    public Integer findResumeOpenState(@PathVariable Long userId) {
        // int i = 1 / 0;
        return resumeService.findDefaultResumeByUserId(userId);
    }

}
