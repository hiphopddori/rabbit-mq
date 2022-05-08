package com.ddori.rabbitmq.publisher;

import com.ddori.rabbitmq.dto.OrderDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GiftPublisherTest {

    @Autowired
    private GiftPublisher giftPublisher;
    @Test
    public void 선물하기_publish_test() {
        giftPublisher.sendGiftMessage(OrderDto.builder()
                        .message("RabbitMq 테스트")
                        .product("스타벅스")
                .build());
    }
}
