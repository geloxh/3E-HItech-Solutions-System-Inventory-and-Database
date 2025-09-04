package com.example.server.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "event_logs")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class EventLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Asset asset;

    @Column(nullable = false)
    private String event; // e.g., "maintenance", "repair", "retired"

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private LocalDateTime loggedAt;

    private String loggedBy;
}
