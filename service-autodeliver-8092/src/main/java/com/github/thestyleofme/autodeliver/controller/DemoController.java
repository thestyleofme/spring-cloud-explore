package com.github.thestyleofme.autodeliver.controller;

import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
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

    @SuppressWarnings("unchecked")
    @GetMapping("/test")
    public String test() {
        Object obj = SecurityContextHolder.getContext().getAuthentication().getDetails();
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) obj;
        Map<String, Object> detailsMap = (Map<String, Object>) details.getDecodedDetails();
        log.debug("clientIp: {}", detailsMap.get("clientIp"));
        return "demo/test";
    }
}
