package com.github.thestyleofme.autodeliver.feign;

import com.github.thestyleofme.autodeliver.feign.fallback.ResumeServiceFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>
 * description
 * </p>
 *
 * @author isaac 2020/11/18 2:58
 * @since 1.0.0
 */
@FeignClient(
        value = "service-resume",
        path = "/resume",
        fallback = ResumeServiceFeignFallback.class
)
public interface ResumeServiceFeign {

    /**
     * 获取简历的公开状态值
     *
     * @param userId userId
     * @return Integer
     */
    @GetMapping("/openstate/{userId}")
    Integer findDefaultResumeState(@PathVariable("userId") Long userId);
}
