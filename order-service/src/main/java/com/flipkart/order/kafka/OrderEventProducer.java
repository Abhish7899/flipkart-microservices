package com.flipkart.order.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderEventProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    private static final String ORDER_TOPIC       = "order-events";
    private static final String PAYMENT_TOPIC     = "payment-events";
    private static final String INVENTORY_TOPIC   = "inventory-events";

    public void publishOrderPlaced(Long orderId, Long userId, Double amount) {
        OrderEvent event = OrderEvent.builder()
                .eventType("ORDER_PLACED")
                .orderId(orderId)
                .userId(userId)
                .amount(amount)
                .build();

        kafkaTemplate.send(ORDER_TOPIC, event);
        kafkaTemplate.send(PAYMENT_TOPIC, event);
        kafkaTemplate.send(INVENTORY_TOPIC, event);
    }

    public void publishOrderCancelled(Long orderId) {
        OrderEvent event = OrderEvent.builder()
                .eventType("ORDER_CANCELLED")
                .orderId(orderId)
                .build();

        kafkaTemplate.send(ORDER_TOPIC, event);
        kafkaTemplate.send(INVENTORY_TOPIC, event);
    }
}
