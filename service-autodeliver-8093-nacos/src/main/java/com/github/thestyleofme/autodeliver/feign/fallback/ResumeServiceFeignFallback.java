package com.github.thestyleofme.autodeliver.feign.fallback;

import com.github.thestyleofme.autodeliver.feign.ResumeServiceFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * <p>
 * description
 * </p>
 *
 * @author isaac 2020/11/18 2:58
 * @since 1.0.0
 */
@Slf4j
@Component
public class ResumeServiceFeignFallback implements ResumeServiceFeign {

    @Override
    public Integer findDefaultResumeState(Long userId) {
        log.error("findDefaultResumeState fallback, userId: {}", userId);
        return -1;
    }

}
