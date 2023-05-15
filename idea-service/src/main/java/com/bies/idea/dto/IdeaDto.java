package com.bies.idea.dto;

import lombok.*;

@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class IdeaDto {
    private final Long ideaId;
    private final String title;
    private final String description;
    private final Long authorId;
    private final IdeaStatus status;
}
