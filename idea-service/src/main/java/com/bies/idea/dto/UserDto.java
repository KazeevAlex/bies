package com.bies.idea.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
