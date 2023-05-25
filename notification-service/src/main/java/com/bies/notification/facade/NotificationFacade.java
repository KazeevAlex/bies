/*package com.bies.notification.facade;

import com.bies.notification.dto.IdeaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class NotificationFacade {

    private final EmailService emailService;

    @KafkaListener(topics = "notificationTopic")
    public void inform(IdeaDto ideaDto) {
        emailService.notificate(....);
    }
}*/
