package com.example.server.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "asset_usage_logs")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class AssetUsageLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Asset asset;

    @Column(nullable = false)
    private String action; // e.g., "checked out", "returned", "used"

    private String usedBy;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @Column(nullable = false)
    private LocalDateTime loggedAt;

    private String loggedBy; // who recorded this log
}
