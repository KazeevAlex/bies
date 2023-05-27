package com.bies.notification.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "message_template")
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class MessageTemplate {
    @Id
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private TemplateType type;

    @NonNull
    @Column(name = "subject")
    private String subject;

    @NonNull
    @Column(name = "message")
    private String message;
}
