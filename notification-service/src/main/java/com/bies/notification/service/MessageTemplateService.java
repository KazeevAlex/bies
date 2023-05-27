package com.bies.notification.service;

import com.bies.notification.entity.MessageTemplate;
import com.bies.notification.entity.TemplateType;

public interface MessageTemplateService {
    MessageTemplate getTemplate(TemplateType templateType);
}
