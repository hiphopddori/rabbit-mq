package com.ddori.rabbitmq.consumer;

import com.ddori.rabbitmq.config.Constant;
import com.ddori.rabbitmq.dto.OrderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GiftConsumer {
    @RabbitListener(queues = Constant.QUEUE_ORDER)
    public void consumeMessageFromOrderQue(OrderDto orderDto) {
        log.info("ORDER CONSUMMER LISTENER");
        log.info("CONSUMER::ORDER ID={}",orderDto.getOrderId());
        // log.info("CONSUMER::PRODUCT={}",orderDto.getProduct());
        log.info("{}님 에게 알림톡이 전송 되었습니다.", orderDto.getReceiveUserId());
        // 받을 사람에게 문자 및 알림톡 전송
    }

    @RabbitListener(queues = Constant.QUEUE_PRODUCT)
    public void consumeMessageFromProductQue(OrderDto orderDto) {
        log.info("PRODUCT CONSUMMER LISTENER");
        log.info("상품이 등록 되었습니다.", orderDto.getReceiveUserId());
    }
}
