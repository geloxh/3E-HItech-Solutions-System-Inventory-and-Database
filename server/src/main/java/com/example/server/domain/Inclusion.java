package com.example.server.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "inclusions")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Inclusion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String item;

    @Column(columnDefinition = "TEXT")
    private String description;
}
