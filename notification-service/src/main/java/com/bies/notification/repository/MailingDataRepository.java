package com.bies.notification.repository;

import com.bies.notification.entity.MailingData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailingDataRepository extends JpaRepository<MailingData, Long> {
}
