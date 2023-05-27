package com.bies.notification.component;

import com.bies.notification.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient("user-service")
public interface UserFeignClient {
    @GetMapping("/api/user/{userId}")
    UserDto getUserById(@PathVariable int userId);
}
