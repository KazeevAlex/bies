package com.bies.notification;

import com.bies.notification.dto.IdeaDto;
import com.bies.notification.dto.UserDto;
import com.bies.notification.service.MyFeignClient;
import com.bies.notification.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@Slf4j
@EnableFeignClients
public class NotificationApplication {

	@Autowired
	private MyFeignClient myFeignClient;

	public static void main(String[] args) {
		SpringApplication.run(NotificationApplication.class, args);
	}

	@KafkaListener(topics = "notificationTopic")
	public void handleNotification(IdeaDto ideaDto) {
		// send out an email notification
		log.info("Received Notification for Idea - {}", ideaDto.toString());

		int userId = ideaDto.getAuthorId();
		UserDto author = myFeignClient.getUserById(userId);
		log.info("Received Notification for User - {}", author);

	}

}
