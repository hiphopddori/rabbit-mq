package com.ddori.rabbitmq.config;

import org.springframework.stereotype.Component;

@Component
public class Constant {
    public static final String QUEUE_ORDER = "gift.order";
    public static final String QUEUE_PRODUCT = "gift.product";
    public static final String EXCHANGE = "gift_queue_exchange";
    public static final String ROUTING_KEY_ORDER = "gift.order.#";
    public static final String ROUTING_KEY_PRODUCT = "gift.product.#";

    public static final String ROUTING_KEY_ORDER_COMPLETE = "gift.order.complete";

}
