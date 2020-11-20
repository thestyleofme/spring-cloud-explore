package com.github.thestyleofme.stream.producer.service;

/**
 * <p>
 * description
 * </p>
 *
 * @author isaac 2020/11/21 2:49
 * @since 1.0.0
 */
public interface IMessageProducer {

    /**
     * 发送消息
     *
     * @param msg 消息
     */
    void sendMessage(String msg);
}
