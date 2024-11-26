package com.mawaaw.poc_malt_like.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "offers")
@AllArgsConstructor @Getter @Setter @ToString @Builder
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "freelance_id", nullable = false)
    private Freelance freelance;

    @ManyToOne
    @JoinColumn(name = "mission_id", nullable = false)
    private Mission mission;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private OfferStatus status;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "responded_at")
    private LocalDateTime respondedAt;

    public Offer() {
        this.createdAt = LocalDateTime.now();
        this.status = OfferStatus.PENDING;
    }
}
