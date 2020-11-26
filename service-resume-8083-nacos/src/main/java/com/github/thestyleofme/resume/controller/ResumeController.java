package com.github.thestyleofme.resume.controller;

import com.github.thestyleofme.resume.service.ResumeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * description
 * </p>
 *
 * @author isaac 2020/11/12 3:54
 * @since 1.0.0
 */
@RestController
@RequestMapping("/resume")
@Slf4j
public class ResumeController {

    private final ResumeService resumeService;

    @Value("${server.port}")
    private int port;

    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @GetMapping("/openstate/{userId}")
    public Integer findDefaultResumeState(@PathVariable Long userId) {
        Integer isOpenResume = resumeService.findDefaultResumeByUserId(userId).getIsOpenResume();
        log.debug("isOpenResume: {}",isOpenResume);
        return port;
    }

}
