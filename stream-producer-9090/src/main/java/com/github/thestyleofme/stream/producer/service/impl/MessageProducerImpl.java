package com.github.thestyleofme.stream.producer.service.impl;

import com.github.thestyleofme.stream.producer.service.IMessageProducer;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;

/**
 * <p>
 * Source.class里面就是对输出通道的定义(这是Spring Cloud Stream内置的通道封装)
 * </p>
 *
 * @author isaac 2020/11/21 2:50
 * @since 1.0.0
 */
@EnableBinding(Source.class)
public class MessageProducerImpl implements IMessageProducer {

    /**
     * 将MessageChannel的封装对象Source注入到这里使用
     */
    private final Source source;

    public MessageProducerImpl(Source source) {
        this.source = source;
    }

    @Override
    public void sendMessage(String msg) {
        source.output().send(MessageBuilder.withPayload(msg).build());
    }
}
