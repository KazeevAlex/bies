package com.bies.notification.service.impl;

import com.bies.notification.entity.MailingData;
import com.bies.notification.repository.MailingDataRepository;
import com.bies.notification.service.MailingDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailingDataServiceImpl implements MailingDataService {

    private final MailingDataRepository mailingDataRepository;

    @Override
    public void save(MailingData mailingData) {
        mailingDataRepository.save(mailingData);
    }
}

