package com.bies.notification.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.Immutable;

import java.time.Instant;

@Entity
@Immutable
@Table(name = "mailing_data")
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Getter
@Setter
public class MailingData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @org.hibernate.annotations.Generated(GenerationTime.INSERT)
    @Column(name = "sending_time", nullable = false, insertable = false)
    private Instant sendingTime;

    @Email
    @NotBlank
    @Size(min = 6, max = 255)
    @Column(name = "email", nullable = false)
    private String email;

    @NonNull
    @Column(name = "idea_id", nullable = false)
    private Long ideaId;

    @NonNull
    @Column(name = "successfully", nullable = false)
    private Boolean successfully;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "message_template_type", nullable = false)
    private MessageTemplate messageTemplateType;
}
