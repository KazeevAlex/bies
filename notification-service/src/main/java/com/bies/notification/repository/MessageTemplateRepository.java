package com.bies.notification.repository;

import com.bies.notification.entity.MessageTemplate;
import com.bies.notification.entity.TemplateType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageTemplateRepository extends JpaRepository<MessageTemplate, TemplateType> {
}
