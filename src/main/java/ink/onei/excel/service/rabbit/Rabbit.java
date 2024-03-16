package ink.onei.excel.service.rabbit;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: nekotako
 * @Description: RabbitMQ Main Class
 * @Date: 16/03/2024 10:52 Saturday
 */
@Service
@RabbitListener(queues = "hello")
public class Rabbit {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(Object o) {
        rabbitTemplate.convertAndSend(o);
    }

    //接受者
    @RabbitHandler
    public void process(Object o) {
        System.out.println("Receiver object : " + o);
    }
}
