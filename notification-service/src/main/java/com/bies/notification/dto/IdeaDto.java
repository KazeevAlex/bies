package com.bies.notification.dto;

import lombok.*;

@NoArgsConstructor(force = true)
//@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class IdeaDto {
    private Long ideaId;
    private String title;
    private String description;
    private int authorId;
    private IdeaStatus status;
}
