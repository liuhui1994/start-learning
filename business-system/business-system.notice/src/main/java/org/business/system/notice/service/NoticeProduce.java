package org.business.system.notice.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "createAccount")
public class NoticeProduce {
    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver  : " + hello);
    }
    
    
}
