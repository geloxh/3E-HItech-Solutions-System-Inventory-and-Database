package com.example.server.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "assets")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String assetTag; // unique identifier

    @ManyToOne(optional = false)
    private AssetType assetType;

    @ManyToOne(optional = false)
    private Brand brand;

    @ManyToOne
    private OperatingSystem operatingSystem;

    @ManyToOne
    private Office office;

    private LocalDateTime acquiredAt;

    private String assignedToUser; // reference to a username or person, if applicable
}

