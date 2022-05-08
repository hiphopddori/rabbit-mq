package com.ddori.rabbitmq;

import com.ddori.rabbitmq.dto.OrderDto;
import com.ddori.rabbitmq.publisher.GiftPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class GiftRestController {

    private final GiftPublisher giftPublisher;
    @GetMapping("gift/product/{productName}")
    public String bookOrder(@PathVariable String productName) {
        var order = OrderDto.builder()
                .product(productName)
                .receiveUserId("ddori")
                .message("선물이예요")
                .build();
        giftPublisher.sendGiftMessage(order);
        return "publishing success";
    }
}
