package com.bies.notification.service;

import com.bies.notification.dto.IdeaDto;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService{

    @Override
    public void notify(IdeaDto ideaDto) {
        System.out.println("You have new notification.");
    }


}
