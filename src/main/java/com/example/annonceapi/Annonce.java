package com.example.annonceapi;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Annonce {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String titre;
    private String description;
    private double prix;

    @Enumerated(EnumType.STRING)
    private TypeAnnonce type;

}
