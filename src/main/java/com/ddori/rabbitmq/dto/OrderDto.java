package com.ddori.rabbitmq.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class OrderDto {
    String orderId;
    String product;
    String message;
    String receiveUserId;

    public void generateOrderID() {
        this.orderId = UUID.randomUUID().toString();
    }
}
