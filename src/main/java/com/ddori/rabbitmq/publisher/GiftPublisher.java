package com.ddori.rabbitmq.publisher;


import com.ddori.rabbitmq.config.Constant;
import com.ddori.rabbitmq.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class GiftPublisher {

    private final RabbitTemplate template;
    public void sendGiftMessage (OrderDto oderInfo) {
        oderInfo.generateOrderID();
        log.info("PUBLISH ORDER : {}", oderInfo.getOrderId());


        template.convertAndSend(Constant.EXCHANGE, Constant.ROUTING_KEY_ORDER_COMPLETE, oderInfo);
        // template.convertAndSend(Constant.QUEUE_ORDER, oderInfo);

    }
}
