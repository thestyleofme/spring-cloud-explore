package com.github.thestyleofme.stream.producer;

import com.github.thestyleofme.stream.producer.service.IMessageProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p>
 * description
 * </p>
 *
 * @author isaac 2020/11/21 3:01
 * @since 1.0.0
 */
@SpringBootTest(classes = {
        StreamProducer9090.class
},
        webEnvironment = SpringBootTest.WebEnvironment.NONE
)
@RunWith(SpringJUnit4ClassRunner.class)
public class MessageProducerTest {

    @Autowired
    private IMessageProducer iMessageProducer;

    @Test
    public void testSendMessage() {
        iMessageProducer.sendMessage("hello world");
    }

}
