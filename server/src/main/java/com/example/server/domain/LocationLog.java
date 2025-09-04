package com.example.server.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "location_logs")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class LocationLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Asset asset;

    private String location; // free-form location description

    @ManyToOne
    private Office office; // office reference

    @Column(columnDefinition = "TEXT")
    private String notes;

    @Column(nullable = false)
    private LocalDateTime loggedAt;

    private String loggedBy;
}
