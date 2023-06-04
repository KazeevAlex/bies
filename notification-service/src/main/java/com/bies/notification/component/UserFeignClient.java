package com.bies.notification.component;

import com.bies.notification.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient("user-service")
@FeignClient(value = "user", url = "http://localhost:8180/api/user")
public interface UserFeignClient {
    @GetMapping("/api/user/{userId}")
    UserDto getUserById(@PathVariable int userId);

    @GetMapping("/feign")
    String queryParam(@RequestParam(value = "role") String role,
                      @RequestParam(value = "notifiable") boolean notifiable);
}
