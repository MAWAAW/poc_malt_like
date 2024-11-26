package com.mawaaw.poc_malt_like.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString @Builder
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private MissionStatus status;

    @ManyToMany(mappedBy = "missions")
    private List<Freelance> freelances;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
}
