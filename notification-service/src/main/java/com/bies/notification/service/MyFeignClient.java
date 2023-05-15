package com.bies.notification.service;

import com.bies.notification.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("user-service")
public interface MyFeignClient {
    @GetMapping("/api/user/{userId}")
    UserDto getUserById(@PathVariable int userId);
}
