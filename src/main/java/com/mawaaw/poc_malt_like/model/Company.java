package com.mawaaw.poc_malt_like.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity @NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String description;

    @OneToMany(mappedBy = "company")
    private List<Mission> missions;
}
