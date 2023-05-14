package com.bies.notification.controller;

import com.bies.notification.dto.IdeaDto;
import com.bies.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notification")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping
    public void notify(@RequestBody IdeaDto ideaDto) {
        notificationService.notify(ideaDto);
    }
}
