package com.github.thestyleofme.autodeliver.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * description
 * </p>
 *
 * @author isaac 2020/11/26 0:47
 * @since 1.0.0
 */
@RestController
@RequestMapping("/demo")
@Slf4j
public class DemoController {

    @GetMapping("/test")
    public String test() {
        return "demo/test";
    }
}
