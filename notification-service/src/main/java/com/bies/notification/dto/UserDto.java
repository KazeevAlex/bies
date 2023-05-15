package com.bies.notification.dto;

import lombok.*;

@NoArgsConstructor(force = true)
//@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {
    private int id;
    private String firstName;
    private String email;
    private UserRole role;
}
