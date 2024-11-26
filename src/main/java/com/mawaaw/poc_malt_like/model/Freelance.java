package com.mawaaw.poc_malt_like.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Freelance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private List<String> skills;

    @ManyToMany
    @JoinTable(
            name = "freelance_mission",
            joinColumns = @JoinColumn(name = "freelance_id"),
            inverseJoinColumns = @JoinColumn(name = "mission_id")
    )
    private List<Mission> missions;

    @OneToMany(mappedBy = "freelance")
    private List<Offer> offers;
}
