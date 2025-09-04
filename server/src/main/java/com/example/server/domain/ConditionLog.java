package com.example.server.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "condition_logs")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class ConditionLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Asset asset;

    @Column(nullable = false)
    private String condition; // e.g., "excellent", "good", "fair", "poor", "damaged"

    @Column(columnDefinition = "TEXT")
    private String notes;

    @Column(nullable = false)
    private LocalDateTime loggedAt;

    private String loggedBy;
}
