package com.bies.notification.service;

import com.bies.notification.dto.IdeaDto;
import com.bies.notification.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;

public class NotificationServiceImpl implements NotificationService{

    @Override
    public void notify(IdeaDto ideaDto) {
        System.out.println("You have new notification.");
    }


}
