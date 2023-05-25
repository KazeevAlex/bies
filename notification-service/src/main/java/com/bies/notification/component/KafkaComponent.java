/*package com.bies.notification.component;

import com.bies.notification.dto.IdeaDto;
import com.bies.notification.facade.NotificationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;

@RequiredArgsConstructor
public class KafkaComponent {

    private final NotificationFacade notificationFacade;

    @KafkaListener(topics = "notificationTopic")
    public void handleNotification(IdeaDto ideaDto) {
        notificationFacade.inform(ideaDto);
    }
}*/
