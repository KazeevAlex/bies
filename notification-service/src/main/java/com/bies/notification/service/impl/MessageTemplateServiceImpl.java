package com.bies.notification.service.impl;

import com.bies.notification.entity.MessageTemplate;
import com.bies.notification.entity.TemplateType;
import com.bies.notification.repository.MessageTemplateRepository;
import com.bies.notification.service.MessageTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageTemplateServiceImpl implements MessageTemplateService {

    private final MessageTemplateRepository messageTemplateRepository;

    @Override
    public MessageTemplate getTemplate(TemplateType templateType) {
        return messageTemplateRepository.getReferenceById(templateType);
    }
}
