package com.bies.idea.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "idea")
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Idea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    @NonNull
    private String title;

    @Column(name = "description")
    @NonNull
    private String description;

    @Column(name = "author_id")
    @NonNull
    private Long authorId;

    @Column(name = "status")
    @NonNull
    private IdeaStatus status;
}
