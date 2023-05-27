package com.bies.notification.controller;

import com.bies.notification.dto.IdeaDto;
import com.bies.notification.entity.MessageTemplate;
import com.bies.notification.entity.TemplateType;
import com.bies.notification.service.MessageTemplateService;
import com.bies.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notification")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;
    private final MessageTemplateService messageTemplateService;

//    @GetMapping("/template")
//    public MessageTemplate getTemplate() {
//        return messageTemplateService.getTemplate(TemplateType.ACCEPTED_AUTHOR);
//    }

    @GetMapping("/template")
    public void getTemplate() {
        System.out.println(messageTemplateService.getTemplate(TemplateType.ACCEPTED_AUTHOR));
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @PostMapping
    public void notify(@RequestBody IdeaDto ideaDto) {
        notificationService.notify(ideaDto);
    }
}
