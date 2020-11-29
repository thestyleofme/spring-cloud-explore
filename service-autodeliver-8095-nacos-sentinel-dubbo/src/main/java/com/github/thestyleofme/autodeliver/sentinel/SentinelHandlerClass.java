package com.github.thestyleofme.autodeliver.sentinel;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * description
 * </p>
 *
 * @author isaac 2020/11/30 2:03
 * @since 1.0.0
 */
@Slf4j
public class SentinelHandlerClass {

    private SentinelHandlerClass() {
    }

    public static Integer handleException(Long userId, BlockException blockException) {
        log.error("findResumeOpenState exception for user: {}, exception: {}", userId, blockException);
        return -100;
    }

    public static Integer handleError(Long userId) {
        log.error("findResumeOpenState exception for user: {}", userId);
        return -500;
    }
}
