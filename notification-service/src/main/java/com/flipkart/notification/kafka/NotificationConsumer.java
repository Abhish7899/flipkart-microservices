package com.flipkart.notification.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {

    // Listen for order events
    @KafkaListener(topics = "order-events", groupId = "notification-group")
    public void handleOrderEvent(Object event) {
        log.info("📧 Notification received for order event: {}", event);
        // TODO: Send email / SMS to user
        sendEmailNotification(event);
    }

    // Listen for payment events
    @KafkaListener(topics = "payment-events", groupId = "notification-group")
    public void handlePaymentEvent(Object event) {
        log.info("💳 Notification received for payment event: {}", event);
        sendEmailNotification(event);
    }

    private void sendEmailNotification(Object event) {
        // Integrate with JavaMailSender or Twilio SMS here
        log.info("✅ Sending notification for event: {}", event);
    }
}
