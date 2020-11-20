package com.github.thestyleofme.stream.consumer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

/**
 * <p>
 * description
 * </p>
 *
 * @author isaac 2020/11/21 3:14
 * @since 1.0.0
 */
@EnableBinding({Sink.class})
@Slf4j
public class MessageConsumerService {

    @StreamListener(Sink.INPUT)
    public void receiveMessage(Message<String> msg) {
        log.debug("receive message: {}", msg);
    }
}
